import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class myTest {

    private WebDriver driverc;
    private WebDriverWait wait;

    @Before
    public void start() {
        driverc = new ChromeDriver();
        wait = new WebDriverWait(driverc,20);
    }

    @Test
    public void test(){
        driverc.get("http://localhost/litecart/admin/login.php");
        driverc.findElement(By.name("username")).sendKeys("admin");
        driverc.findElement(By.name("password")).sendKeys("admin");
        driverc.findElement(By.name("login")).click();
        wait.until(titleIs("My Store"));
        driverc.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=appearance&doc=template']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h1"), "Template"));
        driverc.findElement(By.cssSelector("li#doc-template a[href='http://localhost/litecart/admin/?app=appearance&doc=template']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h1"), "Template"));
        driverc.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=appearance&doc=logotype']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h1"), "Logotype"));
        driverc.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=catalog&doc=catalog']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h1"), "Catalog"));
        driverc.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=catalog&doc=product_groups']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h1"), "Product Groups"));
        driverc.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=catalog&doc=option_groups']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h1"), "Option Groups"));
        driverc.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=catalog&doc=manufacturers']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h1"), "Manufacturers"));
        driverc.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=catalog&doc=suppliers']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h1"), "Suppliers"));
        driverc.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=catalog&doc=delivery_statuses']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h1"), "Delivery Statuses"));
        driverc.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=catalog&doc=sold_out_statuses']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h1"), "Sold Out Statuses"));
        driverc.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=catalog&doc=quantity_units']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h1"), "Quantity Units"));
        driverc.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=catalog&doc=csv']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h1"), "CSV Import/Export"));
        driverc.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=countries&doc=countries']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h1"), "Countries"));
        driverc.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=currencies&doc=currencies']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h1"), "Currencies"));
        driverc.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=customers&doc=customers']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h1"), "Customers"));
        driverc.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h1"), "Geo Zones"));
        driverc.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=languages&doc=languages']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h1"), "Languages"));
        driverc.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=languages&doc=storage_encoding']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h1"), "Storage Encoding"));
        driverc.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=modules&doc=jobs']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h1"), "Job Modules"));
        driverc.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=modules&doc=customer']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h1"), "Customer"));
        driverc.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=orders&doc=orders']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h1"), "Orders"));
        driverc.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=orders&doc=order_statuses']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h1"), "Order Statuses"));
        driverc.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=pages&doc=pages']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h1"), "Pages"));
        driverc.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=reports&doc=monthly_sales']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h1"), "Monthly Sales"));
        driverc.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=reports&doc=most_sold_products']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h1"), "Most Sold Products"));
        driverc.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=reports&doc=most_shopping_customers']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h1"), "Most Shopping Customers"));
        driverc.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=settings&doc=store_info']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h1"), "Settings"));
        driverc.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=settings&doc=defaults']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h1"), "Settings"));
        driverc.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=settings&doc=general']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h1"), "Settings"));
        driverc.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=settings&doc=listings']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h1"), "Settings"));
        driverc.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=settings&doc=images']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h1"), "Settings"));
        driverc.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=settings&doc=checkout']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h1"), "Settings"));
        driverc.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=settings&doc=advanced']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h1"), "Settings"));
        driverc.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=settings&doc=security']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h1"), "Settings"));
        driverc.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=slides&doc=slides']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h1"), "Slides"));
        driverc.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=tax&doc=tax_classes']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h1"), "Tax Classes"));
        driverc.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=tax&doc=tax_rates']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h1"), "Tax Rates"));
        driverc.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=translations&doc=search']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h1"), "Search Translations"));
        driverc.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=translations&doc=scan']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h1"), "Scan Files For Translations"));
        driverc.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=translations&doc=csv']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h1"), "CSV Import/Export"));
        driverc.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=users&doc=users']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h1"), "Users"));
        driverc.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=vqmods&doc=vqmods']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h1"), "vQmods"));

    }

    @After
    public void stop() {
        driverc.quit();
        driverc = null;
    }
}
