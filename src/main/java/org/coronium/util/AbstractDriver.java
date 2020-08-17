package org.coronium.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.coronium.page.core.ui.common.Property;
import org.coronium.page.core.ui.driver.Driver;
import org.coronium.page.core.ui.listeners.LogListener;
import org.coronium.page.core.ui.proxy.ProxyFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.events.EventFiringWebDriver;


public abstract class AbstractDriver implements Driver {
    protected static final Logger logger = LogManager.getLogger();

    private EventFiringWebDriver webDriverWrapper;

    @Override
    public EventFiringWebDriver getWebDriver() {
        return this.webDriverWrapper;
    }

    /**
     * Creates the Wrapped Driver object and maximises if required.
     */
    public void initialise() {
        this.webDriverWrapper = setupEventFiringWebDriver(getCapabilities());
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
