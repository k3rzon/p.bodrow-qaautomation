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
import static org.junit.Assert.assertEquals;

public class myTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private List<WebElement> we;
    private List<WebElement> stickers;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,20);
        we = new ArrayList<WebElement>();
        stickers = new ArrayList<WebElement>();
        }

    @Test
    public void test() throws InterruptedException {
        driver.get("http://localhost/litecart/en/");
        we = driver.findElements(By.cssSelector("a.link[href*='rubber-ducks-c-1']"));
        for (WebElement element:we) {
            stickers = element.findElements((By.cssSelector("div[class*=sticker]")));
            assertEquals(1, stickers.size());
        }
   }

    @After
    public void stop() {
      driver.quit();
      driver = null;
      }
}
