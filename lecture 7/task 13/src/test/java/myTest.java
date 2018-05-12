
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class myTest {

    private WebDriver driverc;
    private WebDriverWait wait;
    private WebElement list;
    private Select size;
    private WebElement quantity;
    private WebElement good;

    @Before
    public void start() {
        driverc = new ChromeDriver();
        wait = new WebDriverWait(driverc, 20);
    }

    @Test
    public void test() {
        driverc.get("http://localhost/litecart/en/");
        for (int i = 1; i < 4; i++) {
            driverc.findElement(By.cssSelector("#box-most-popular > div > ul > li:nth-child(1)"))
                    .click();
            if (driverc.findElements(By.name("options[Size]")).size() != 0){
                list = driverc.findElement(By.name("options[Size]"));
                size = new Select(list);
                size.selectByIndex(i);}
            driverc.findElement(By.name("add_cart_product")).click();
            quantity = driverc.findElement(By.cssSelector("#cart > a.content > span.quantity"));
            wait.until(ExpectedConditions.textToBe(By.cssSelector("#cart > a.content > span.quantity"), String.valueOf(i)));
            ((JavascriptExecutor) driverc).executeScript("window.history.go(-1)");
            wait.until(titleIs("Online Store | My Store"));}
        driverc.findElement(By.cssSelector("#cart")).click();
        do {
            good = driverc.findElement(By.cssSelector("table.dataTable.rounded-corners tr:nth-child(2)"));
            driverc.findElement(By.name("remove_cart_item")).click();
            wait.until(ExpectedConditions.stalenessOf(good));
        }
        while (driverc.findElements(By.cssSelector("table.dataTable.rounded-corners tr")).size() > 0);
        Assert.assertEquals("There are no items in your cart.", driverc.findElement(By.cssSelector("em")).getText());
    }

    @After
    public void stop() {
        driverc.quit();
        driverc = null;
    }
}