import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class myTest {

    private WebDriver driverc;
    private WebDriver driverf;
    private WebDriver driverie;
    private WebDriverWait wait;

    @Before
    public void start() {
        driverc = new ChromeDriver();
        wait = new WebDriverWait(driverc,20);
        driverf = new FirefoxDriver();
        wait = new WebDriverWait(driverie,20);
        driverie = new InternetExplorerDriver();
        wait = new WebDriverWait(driverie,20);
    }

    @Test
    public void test() {
      //  driver.get("http://localhost/litecart/admin/login.php");
        //driver.findElement(By.name("username")).sendKeys("admin");
        //driver.findElement(By.name("password")).sendKeys("admin");
        //driver.findElement(By.name("login")).click();
        //wait.until(titleIs("My Store"));
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
