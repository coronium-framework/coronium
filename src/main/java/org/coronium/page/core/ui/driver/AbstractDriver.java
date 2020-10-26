package org.coronium.page.core.ui.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.coronium.page.core.ui.common.Property;
import org.coronium.page.core.ui.driver.remotes.BrowserStack;
import org.coronium.page.core.ui.driver.remotes.Sauce;
import org.coronium.page.core.ui.listeners.LogListener;
import org.coronium.page.core.ui.proxy.ProxyFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;


public abstract class AbstractDriver implements Driver {
    protected static final Logger logger = LogManager.getLogger();

    private WebDriverWrapper webDriverWrapper;

    @Override
    public EventFiringWebDriver getWebDriver() {
        return this.webDriverWrapper;
    }

    /**
     * Creates the Wrapped Driver object and maximises if required.
     */
    public void initialise() {
        DesiredCapabilities capsFromImpl = getDesiredCapabilities();
        DesiredCapabilities caps = (DesiredCapabilities) addProxyIfRequired(capsFromImpl);
        logger.debug("Browser Capabilities: " + caps);

        this.webDriverWrapper = (WebDriverWrapper) setupEventFiringWebDriver(caps);

        maximiseBrowserIfRequired();
    }

    private  void maximiseBrowserIfRequired(){
        if (isMaximiseRequired()) {
            this.webDriverWrapper.manage().window().maximize();
        }
    }

    private boolean isMaximiseRequired() {
        boolean ableToMaximise = !Sauce.isDesired()
                && !BrowserStack.isDesired()
                && !Driver.isNative();

        return Property.wantToMaximise() && ableToMaximise;
    }

    private EventFiringWebDriver setupEventFiringWebDriver(Capabilities capabilities) {
        Capabilities caps = addProxyIfRequired(capabilities);
        logger.debug("Browser Capabilities: " + caps);
        EventFiringWebDriver eventFiringWD = new EventFiringWebDriver(getWebDriver(caps));
        eventFiringWD.register(new LogListener());
        return eventFiringWD;
    }

    private static Capabilities addProxyIfRequired(Capabilities caps) {
        if (Property.PROXY.isSpecified()) {
            return caps.merge(createProxyCapabilities(Property.PROXY.getValue()));
        } else {
            return caps;
        }
    }

    private static Capabilities createProxyCapabilities(String proxyProperty) {
        return new ImmutableCapabilities(
                CapabilityType.PROXY,
                ProxyFactory.createProxy(proxyProperty));
    }
}
