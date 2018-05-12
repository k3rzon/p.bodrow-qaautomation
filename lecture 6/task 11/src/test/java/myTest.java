import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class myTest {

    private ChromeDriver driverc;
    private WebDriverWait waitc;
    private Actions builder;
    private Select select_country;
    private Select select_zone;
    String first_n = "Admin";
    String last_n = "Admin";
    String address_1 = "100 4th Avenue";
    String postcode = "10017";
    String city = "New York";
    String email = DateStamp.now() + "@test.com";
    String phone = "+123123123";
    String pass = "qwerty123";
    WebElement notice_success;

    @Before
    public void start() {
        driverc = new ChromeDriver();
        waitc = new WebDriverWait(driverc, 20);
        builder = new Actions(driverc);
    }

    @Test
    public void test() throws InterruptedException{
        driverc.get("http://localhost/litecart/en/");
        String reg_page = driverc.findElement(By.cssSelector("form[name='login_form'] table tr:nth-child(5) a"))
                .getAttribute("href");
        driverc.get(reg_page);
        driverc.findElement(By.cssSelector("td input[name='firstname']")).sendKeys(first_n);
        driverc.findElement(By.cssSelector("td input[name='lastname']")).sendKeys(last_n);
        driverc.findElement(By.cssSelector("td input[name='address1']")).sendKeys(address_1);
        driverc.findElement(By.cssSelector("td input[name='postcode']")).sendKeys(postcode);
        driverc.findElement(By.cssSelector("td input[name='city']")).sendKeys(city);
        driverc.findElement(By.cssSelector("td input[name='email']")).sendKeys(email);
        driverc.findElement(By.cssSelector("td input[name='phone']")).sendKeys(phone);
        driverc.findElement(By.cssSelector("td input[name='password']")).sendKeys(pass);
        driverc.findElement(By.cssSelector("td input[name='confirmed_password']")).sendKeys(pass);

        WebElement country_slct = driverc.findElement(By.cssSelector("select:nth-child(3)"));
        WebElement zone_slct = driverc.findElement(By.cssSelector("select[name*='zone']"));
        select_country = new Select(country_slct);
        select_zone = new Select(zone_slct);
        select_country.selectByVisibleText("United States");
        builder
                .click(zone_slct)
                .sendKeys("New York")
                .sendKeys(Keys.ENTER)
                .perform();
        driverc.findElement(By.cssSelector("button[type='submit']")).click();
        driverc.findElement(By.xpath("//*[contains(text(), 'Logout')]")).click();
        driverc.findElement(By.cssSelector("input[name='email']")).sendKeys(email);
        driverc.findElement(By.cssSelector("input[name='password']")).sendKeys(pass);
        driverc.findElement(By.cssSelector("input[name='password']")).click();
        driverc.findElement(By.cssSelector("table button[name='login']")).click();
        Thread.sleep(3000);
        notice_success = driverc.findElement(By.cssSelector("div[class ='notice success']"));
        Assert.assertEquals(notice_success.isDisplayed(), true);
    }

    @After
    public void stop() {
        driverc.quit();
        driverc = null;
    }
}