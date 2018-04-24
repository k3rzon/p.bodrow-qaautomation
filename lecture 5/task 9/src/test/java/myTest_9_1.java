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

public class myTest_9_1 {

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
    public void test1(){
        driverc.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driverc.findElement(By.name("username")).sendKeys("admin");
        driverc.findElement(By.name("password")).sendKeys("admin");
        driverc.findElement(By.name("login")).click();
        wait.until(titleIs("Countries | My Store"));

        /*Проверка отсортированности списка стран
          ArrayList из WebElement'ов я перезалил в String'овый, чтобы можно было использовать метод .sort()
         */
        countries = driverc.findElements(By.cssSelector("tr.row td:nth-child(5)"));
        for (int i = 0; i<countries.size(); i++) {
            original.add(countries.get(i).getText());
        }
        sorted = new ArrayList<>(original);
        Collections.sort(sorted);
        assertEquals(sorted, original);

        /*Затем пробегаемся по количеству временных зон для каждой из стран в таблице.
            WebElement'ы я спарсил в int, чтобы можно было выявить неравенство нулю.
         */
        zones = driverc.findElements(By.cssSelector("tr.row td:nth-child(6)"));
        for (int j = 0; j<zones.size(); j++) {
            int value = Integer.parseInt(zones.get(j).getText());

            /*Если количество зон не равно нулю, открываем соответствующую страну в новой вкладке и
            проверяем сортировку зон уже там, затем закрываем и переключаемся на начальную вкладку.
             */
            if (value != 0) {
                WebElement target = driverc.findElement(By.cssSelector("tr.row:nth-child(" + String.valueOf(j + 2) + ") td:nth-child(5) a"));
                ((JavascriptExecutor) driverc).executeScript("window.open('" + target.getAttribute("href") + "', 'new_window')");
                driverc.switchTo().window("new_window");
                country_zones = driverc.findElements(By.cssSelector("tr td:nth-child(3)"));
                for (int k = 1; k < value + 1; k++) {
                    orig_country_zones.add(country_zones.get(k).getText());
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
    }
    @After
    public void stop() {
        driverc.quit();
        driverc = null;
    }
}