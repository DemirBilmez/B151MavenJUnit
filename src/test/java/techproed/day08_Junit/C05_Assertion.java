package techproed.day08_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.asynchttpclient.util.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_Assertion {
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01(){
        driver.get("https://amazon.com");
      String actualTitle=  driver.getTitle();
        String expected="Amazon";
        Assert.assertTrue(actualTitle.contains(expected));
    }

    @Test
    public void test02(){
        //amazon sayfasına gidin
        //amazon resminin görüntülendigini test edin

        driver.get("https://amazon.com");
      WebElement logo= driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
      Assert.assertTrue(logo.isDisplayed());
    }

    @Test
    public void test03(){
        //amazon sayfasına gidin
        driver.get("https://amazon.com");
        //Arama kutusunun erişilebilir oldugunu test edin
        WebElement searchBox=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        Assert.assertTrue(searchBox.isEnabled());
    }

    @Test
    public void test04() {

        // test04
        // https://amazon.com sayfasına gidin
        //driver.get("https://amazon.com");


        // sayfa baslıgının "kitap" icermedigini test edin
        String actuelTitle = driver.getTitle();
        Assert.assertFalse(actuelTitle.contains("kitap"));

    }
}
