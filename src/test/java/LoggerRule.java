package test.java;

import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LoggerRule extends TestWatcher {

    private HashMap<String, List<String>> logs;
    private Description description;
    private static final Logger LOG = LoggerFactory.getLogger(SelenideLogger.class);


    @Override
    public Statement apply(Statement base, Description description) {
        logs = new HashMap<String, List<String>>();
        this.description = description;
        logs.put(description.getDisplayName(), new ArrayList<String>());
        return base;
    }

    @Override
    protected void failed(Throwable e, Description description) {
        printf();
        super.failed(e, description);
    }

    public void addLog(String testLog)
    {
        logs.get(description.getDisplayName()).add(testLog);
    }

    @Override
    protected void finished(Description description) {
        printf();
    }

    public void printf()
    {
        logs.get(description.getDisplayName()).forEach(e -> LOG.info(e));
    }
}
