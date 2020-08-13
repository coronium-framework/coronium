package org.coronium.util.constant;

import java.time.Duration;

public enum Time {
    GLOBAL_PAGE_LOAD_TIMEOUT(Duration.ofSeconds(20)),
    GLOBAL_WAIT_LOADING_TIMEOUT(Duration.ofSeconds(180)),
    GLOBAL_SCRIPT_TIMEOUT(Duration.ofSeconds(120)),
    GLOBALADMIN_SCRIPT_TIMEOUT(Duration.ofSeconds(180)),
    GLOBAL_TABLE_LOAD_TIMEOUT(Duration.ofSeconds(180)),
    GLOBAL_TABLE_LOAD_QUICK_TIMEOUT(Duration.ofSeconds(30));

    private Duration duration;

    Time(Duration duration) {
        this.duration = duration;
    }

    public long seconds() {
        return duration.getSeconds();
    }

    public long milliseconds() {
        return duration.toMillis();
    }
}
