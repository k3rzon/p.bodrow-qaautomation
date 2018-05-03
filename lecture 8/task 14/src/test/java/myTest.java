import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class myTest {

    private WebDriver driverc;
    private WebDriverWait wait;
    private List<WebElement> arrows;
    private String mainwindow;
    private ArrayList<String> availableWindows;

    @Before
    public void start() {
        driverc = new ChromeDriver();
        wait = new WebDriverWait(driverc, 20);
    }

    @Test
    public void test() {
        driverc.get("http://localhost/litecart/admin/login.php");
        driverc.findElement(By.name("username")).sendKeys("admin");
        driverc.findElement(By.name("password")).sendKeys("admin");
        driverc.findElement(By.name("login")).click();
        wait.until(titleIs("My Store"));
        driverc.findElement(By.cssSelector("ul#box-apps-menu li:nth-child(3)")).click();
        driverc.findElement(By.cssSelector("a.button")).click();
        mainwindow = driverc.getWindowHandle();
        arrows = driverc.findElements(By.xpath("//i[contains(@class, 'fa fa-external-link')]/parent::*"));
        for (WebElement element:arrows) {
            element.click();
            availableWindows = new ArrayList<String>(driverc.getWindowHandles());
            if (!availableWindows.isEmpty()) {
                driverc.switchTo().window(availableWindows.get(1));
            }
            ((JavascriptExecutor) driverc).executeScript("window.close()");
            driverc.switchTo().window(mainwindow);
        }
    }

    @After
    public void stop() {
        driverc.quit();
        driverc = null;
    }
}
