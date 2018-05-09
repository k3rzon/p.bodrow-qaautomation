import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class myTest {

    private WebDriver driverc;
    private WebDriverWait wait;
    private List<WebElement> goods;
    private List<String> tabs;
    private List<String> logs;

    @Before
    public void start() {
        driverc = new ChromeDriver();
        wait = new WebDriverWait(driverc, 20);
        logs = new ArrayList<>();
    }

    @Test
    public void test() {
        driverc.get("http://localhost/litecart/admin/login.php");
        driverc.findElement(By.name("username")).sendKeys("admin");
        driverc.findElement(By.name("password")).sendKeys("admin");
        driverc.findElement(By.name("login")).click();
        wait.until(titleIs("My Store"));
        driverc.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        goods = driverc.findElements(By.xpath("//tr//td[not(@id)][3]/a"));
        for (WebElement element:goods) {
            ((JavascriptExecutor) driverc).executeScript("window.open('" + element.getAttribute("href") + "', 'new_window')");
            for (LogEntry l : driverc.manage().logs().get("browser").getAll()) {
                logs.add(l.toString()+"\n");
            }
            driverc.switchTo().window("new_window");
            tabs = new ArrayList<>(driverc.getWindowHandles());
            driverc.close();
            driverc.switchTo().window(tabs.get(0));
        }
        Assert.assertEquals(0,logs.size());
    }

    @After
    public void stop() {
        driverc.quit();
        driverc = null;
    }
}