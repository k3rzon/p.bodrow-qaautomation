import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class myTest_Chrome {

    private ChromeDriver driverc;
    private WebDriverWait waitc;

    @Before
    public void start() {
        driverc = new ChromeDriver();
        waitc = new WebDriverWait(driverc, 20);
    }

    @Test
    public void test_Chrome() {

        //Главная страница магазина
        driverc.get("http://localhost/litecart/en/");
        waitc.until(titleIs("Online Store | My Store"));
        String name_main = driverc.findElement(By.cssSelector("div#box-campaigns div.name")).getText();
        int regular_price_main = Integer.parseInt(driverc.findElement(By.cssSelector("div#box-campaigns s.regular-price"))
                .getText()
                .replaceAll("[\\D]", ""));
        int campaign_price_main = Integer.parseInt(driverc.findElement(By.cssSelector("div#box-campaigns strong.campaign-price"))
                .getText()
                .replaceAll("[\\D]", ""));
        String tag_s_main = driverc.findElement(By.cssSelector("div#box-campaigns s.regular-price")).getTagName();
        String color_main_reg = driverc.findElement(By.cssSelector("div#box-campaigns s.regular-price"))
                .getCssValue("color");
        String tag_strong_main = driverc.findElement(By.cssSelector("div#box-campaigns strong.campaign-price"))
                .getTagName();
        String color_main_campaign = driverc.findElement(By.cssSelector("div#box-campaigns strong.campaign-price"))
                .getCssValue("color");
        int[] color_main_reg_arr = ColorCheck.convert(color_main_reg, driverc);
        int[] color_main_campaign_arr = ColorCheck.convert(color_main_campaign, driverc);

        String target = driverc.findElement(By.cssSelector("div#box-campaigns a.link"))
                .getAttribute("href");

        //Страница акционного товара
        driverc.executeScript("window.open('" + target + "', 'new_window')");
        String name_good = driverc.findElement(By.cssSelector("div#box-campaigns div.name")).getText();
        int regular_price_good = Integer.parseInt(driverc.findElement(By.cssSelector("div#box-campaigns s.regular-price"))
                .getText()
                .replaceAll("[\\D]", ""));
        int campaign_price_good = Integer.parseInt(driverc.findElement(By.cssSelector("div#box-campaigns strong.campaign-price"))
                .getText()
                .replaceAll("[\\D]", ""));
        String tag_s_good = driverc.findElement(By.cssSelector("div#box-campaigns s.regular-price")).getTagName();
        String color_good_reg = driverc.findElement(By.cssSelector("div#box-campaigns s.regular-price"))
                .getCssValue("color");
        String tag_strong_good = driverc.findElement(By.cssSelector("div#box-campaigns strong.campaign-price"))
                .getTagName();
        String color_good_campaign = driverc.findElement(By.cssSelector("div#box-campaigns strong.campaign-price"))
                .getCssValue("color");
        int[] color_good_reg_arr = ColorCheck.convert(color_good_reg, driverc);
        int[] color_good_campaign_arr = ColorCheck.convert(color_good_campaign, driverc);

        //Итоговые проверки
        //а)
        assertEquals(name_main, name_good);
        //б)
        assertEquals(campaign_price_main, campaign_price_good);
        assertEquals(regular_price_main, regular_price_good);
        //в)
        assertEquals(tag_s_main, tag_s_good, "s");
        assertEquals(ColorCheck.isGray(color_main_reg_arr), true);
        assertEquals(ColorCheck.isGray(color_good_reg_arr), true);
        //г)
        assertEquals(tag_strong_main, tag_strong_good, "strong");
        assertEquals(ColorCheck.isRed(color_main_campaign_arr), true);
        assertEquals(ColorCheck.isRed(color_good_campaign_arr), true);
        //д)
        assertEquals(Integer.compare(regular_price_main, campaign_price_main), 1);
        assertEquals(Integer.compare(regular_price_good, campaign_price_good), 1);
    }

    @After
    public void stop() {
        driverc.quit();
        driverc = null;
    }
}
