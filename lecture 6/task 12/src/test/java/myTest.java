import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class myTest {

    private WebDriver driverc;
    private WebDriverWait wait;
    private List<WebElement> checkbox;
    String path;
    private WebElement select;
    private String product_name;

    @Before
    public void start() {
        driverc = new ChromeDriver();
        wait = new WebDriverWait(driverc, 20);
        checkbox = new ArrayList();
        path = new File("img/image.jpg").getAbsolutePath();
        product_name = "test_product";
    }

    @Test
    public void test() {
        driverc.get("http://localhost/litecart/admin/login.php");
        driverc.findElement(By.name("username")).sendKeys("admin");
        driverc.findElement(By.name("password")).sendKeys("admin");
        driverc.findElement(By.name("login")).click();
        wait.until(titleIs("My Store"));
        driverc.findElement(By.cssSelector("li#app-:nth-child(2)")).click();
        driverc.findElement(By.cssSelector("a.button:nth-child(2)")).click();
        driverc.findElement(By.cssSelector("input[type='radio']")).click();
        driverc.findElement(By.name("name[en]")).sendKeys(product_name);
        driverc.findElement(By.name("code")).sendKeys("757575");
        checkbox = driverc.findElements(By.cssSelector("input[type='checkbox']"));
        checkbox.get(5).click();
        driverc.findElement(By.name("quantity")).clear();
        driverc.findElement(By.name("quantity")).sendKeys("100");
        driverc.findElement(By.cssSelector("input[type='file']")).sendKeys(path);
        driverc.findElement((By.name("date_valid_from"))).click();
        driverc.findElement((By.name("date_valid_from"))).sendKeys("26022018");

        driverc.findElement((By.name("date_valid_to"))).click();
        driverc.findElement((By.name("date_valid_to"))).sendKeys("26022019");

        driverc.findElement(By.cssSelector("ul.index li:nth-child(2)")).click();
        select = driverc.findElement(By.name("manufacturer_id"));
        Select menu = new Select(select);
        menu.selectByIndex(1);
        driverc.findElement((By.name("keywords"))).sendKeys("admin");
        driverc.findElement((By.name("short_description[en]"))).sendKeys("admin");
        driverc.findElement((By.name("head_title[en]"))).sendKeys("admin");
        driverc.findElement((By.name("meta_description[en]"))).sendKeys("admin");
        driverc.findElement(By.cssSelector("a[href='#tab-prices']")).click();
        driverc.findElement(By.cssSelector("input[name='purchase_price']")).clear();
        driverc.findElement(By.cssSelector("input[name='purchase_price']")).sendKeys("20,00");
        select = driverc.findElement(By.name("purchase_price_currency_code"));
        menu = new Select(select);
        menu.selectByIndex(1);
        driverc.findElement((By.name("prices[USD]"))).sendKeys("20,00");
        driverc.findElement((By.name("gross_prices[USD]"))).sendKeys("20,00");
        driverc.findElement((By.name("prices[EUR]"))).sendKeys("20,00");
        driverc.findElement((By.name("gross_prices[EUR]"))).sendKeys("20,00");
        driverc.findElement(By.cssSelector("button[name='save']")).click();

        List<WebElement> list = driverc.findElements(By.xpath("//*[contains(text(),'" + product_name + "')]"));
        Assert.assertEquals(list.size() > 0, true);
    }

    @After
    public void stop() {
        driverc.quit();
        driverc = null;
    }
}
