package techproed.day08_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeClassAfterClass {
    WebDriver driver;
    @BeforeClass
    public static void beforeClass(){
        System.out.println("Amazon testi baslatıldı");
    }

    @AfterClass
    public static void aferClass(){
        System.out.println("Amazon testi sonuclandı");
    }

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test01(){
        driver.get("https://amazon.com");
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
    }

    @Test
    public void test02(){
        driver.get("https://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);    }


}
