
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertNotEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class myTest {

    private WebDriver driverc;
    private WebDriverWait wait;
    private List<WebElement> we;
    private List<WebElement> sub;
    @Before
    public void start() {
        driverc = new ChromeDriver();
//driverc.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        wait = new WebDriverWait(driverc,20);
        we = new ArrayList();
        sub = new ArrayList();
    }

    @Test
    public void test() throws InterruptedException {
        driverc.get("http://localhost/litecart/admin/login.php");
        driverc.findElement(By.name("username")).sendKeys("admin");
        driverc.findElement(By.name("password")).sendKeys("admin");
        driverc.findElement(By.name("login")).click();
        wait.until(titleIs("My Store"));
        we = driverc.findElements(By.cssSelector("li#app-"));
        for (int i = 1; i<=we.size();i++) {
            driverc.findElement(By.cssSelector("li#app-:nth-child("+String.valueOf(i)+")")).click();
            assertNotEquals(null, driverc.findElement(By.cssSelector("h1")));
            sub = driverc.findElements(By.cssSelector("ul.docs li"));
            for (int j = 1; j<=sub.size();j++) {
                driverc.findElement(By.cssSelector("ul.docs li:nth-child("+String.valueOf(j)+")")).click();
                assertNotEquals(null, driverc.findElement(By.cssSelector("h1")));
            }
        }
    }
    @After
    public void stop() {
        driverc.quit();
        driverc = null;
    }
}