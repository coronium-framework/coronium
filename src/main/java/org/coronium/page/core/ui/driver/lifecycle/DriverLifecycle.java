package org.coronium.page.core.ui.driver.lifecycle;

import org.coronium.page.core.ui.driver.Driver;
import org.openqa.selenium.WebDriver;

import java.util.function.Supplier;

public interface DriverLifecycle {

    //Driver are reused rather than created each time  a driver is requested.To reuse driver.
    default void initDriverPool(Supplier<Driver> driverSupplier){}

    //Return NoSuchElementException if this pool is empty
    void initBrowserBeforeTest(Supplier<Driver> driverSupplier);

    /**
     * @return the {@link WebDriver} in use by the current thread
     * @throws NullPointerException if called before
     * {@link #initBrowserBeforeTest(Supplier)} or after
     * {@link #tearDownDriver()}.
     */

    WebDriver getWebDriver();

    /**
     * Tears down the driver,ready for reinitilisation,if required, by
     * {@link #initBrowserBeforeTest(Supplier)}.
     */
    void tearDownDriver();

    /**
     * Clears the driver pool,if exists, ready to run
     * run {@link #initDriverPool(Supplier)} agian if required.
     */
    default void tearDownDriverPool(){}
}
