import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class myTest_9_2 {

    private WebDriver driverc;
    private WebDriverWait wait;
    private List<WebElement> countries;
    private List<WebElement> zones;
    private List<String> original;
    private List<String> sorted;
    private String newtab;
    private List<WebElement> country_zones;
    private List<String> orig_country_zones;
    private List<String> tabs;
    @Before
    public void start() {
        driverc = new ChromeDriver();
        wait = new WebDriverWait(driverc,20);
        countries = new ArrayList();
        original = new ArrayList();
        zones = new ArrayList();
        newtab = Keys.chord(Keys.CONTROL,"t");
        country_zones = new ArrayList();
        orig_country_zones = new ArrayList();
    }

    @Test
    public void test() {
        driverc.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        driverc.findElement(By.name("username")).sendKeys("admin");
        driverc.findElement(By.name("password")).sendKeys("admin");
        driverc.findElement(By.name("login")).click();
        wait.until(titleIs("Geo Zones | My Store"));
        countries = driverc.findElements(By.cssSelector("tr.row td:nth-child(3)"));
        for (int i = 0; i < countries.size(); i++) {
            WebElement target = driverc.findElement(By.cssSelector("td tr.row:nth-child(" + String.valueOf(i + 2) + ") a"));
            ((JavascriptExecutor) driverc).executeScript("window.open('" + target.getAttribute("href") + "', 'new_window')");
            driverc.switchTo().window("new_window");
            country_zones = driverc.findElements(By.cssSelector("tr td:nth-child(3) option[selected='selected']"));
            for (int j = 1; j < country_zones.size(); j=j+2) {
                if  (country_zones.get(j).isDisplayed()) {
                orig_country_zones.add(country_zones.get(j).getText());}
            }
            sorted = new ArrayList<>(orig_country_zones);
            Collections.sort(sorted);
            assertEquals(sorted, orig_country_zones);
            orig_country_zones.clear();
            sorted.clear();
            tabs = new ArrayList<>(driverc.getWindowHandles());
            driverc.close();
            driverc.switchTo().window(tabs.get(0));
        }
    }
    @After
    public void stop() {
        driverc.quit();
        driverc = null;
    }
}