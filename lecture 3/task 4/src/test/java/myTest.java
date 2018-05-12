import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class myTest {

    private WebDriver driverc;
    private WebDriver driverf;
    private WebDriver driverie;

    @Test
    public void test() {
        driverc = new ChromeDriver();
        driverf = new FirefoxDriver();
        driverie = new InternetExplorerDriver();
    }

    @After
    public void stop() {
      driverc.quit();
      driverc = null;
      driverf.quit();
      driverf = null;
      driverie.quit();
      driverie = null;
    }
}
