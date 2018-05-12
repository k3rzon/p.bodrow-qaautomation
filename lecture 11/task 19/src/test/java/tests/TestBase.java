package tests;

import org.junit.After;
import org.junit.Before;

//Import from my packages:
import app.Application;


public class TestBase {
    public Application app;

    @Before
    public void start() {
        app = new Application();
    }

    @After
    public  void stop () {
        app.quit();
    }
}
