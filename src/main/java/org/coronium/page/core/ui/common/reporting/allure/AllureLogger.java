package org.coronium.page.core.ui.common.reporting.allure;

import io.qameta.allure.model.StepResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.UUID;

public class AllureLogger {

    private static final Logger logger = LogManager.getLogger();
    private static final ThreadLocal<Deque<String>> STEP_UUID_STACK =
            ThreadLocal.withInitial(ArrayDeque::new);

    private AllureLogger(){
    //hide constructor TBC
    }

    @Step("{message}")
    public static void logToAllure(String message){
        logger.debug("Logged to allure: " +message);
    }

    public static void stepStart(String stepName){
        StepResult result = new StepResult().setName(stepName);
        String uuid = UUID.randomUUID().toString();
       /* getLifecycle.startStep(uuid,result);*/
        STEP_UUID_STACK.get().addFirst(uuid);
    }

    public static void stepFinish(){
        /*getLifecycle.stopStep(STEP_UUID_STACK.get().removeFirst());*/
    }
}
