package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract   class TestBase {
  protected   WebDriver driver;
   @Before
    public void setup(){
       WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

   }

   public void bekle(int saniye){
       try {
           Thread.sleep(saniye*1000);
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }
   }

   //Selenium Wait/Explicit Wait
    //visiblityOf(element) methodu
    public void visibleWait(WebElement element,int saniye){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(saniye));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    //visibilityOfElementLocated(locator) methodu
    public void visibleWait(By locator,int saniye){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(saniye));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //AlertWait methodu
    public void alertWait(int saniye){
       WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(saniye));
       wait.until(ExpectedConditions.alertIsPresent());
    }

    //FluentWait visible method
    public void visibleFluentWait(WebElement element ,int saniye,int milisaniye){
        new FluentWait<>(driver).withTimeout(Duration.ofSeconds(saniye)).
                pollingEvery(Duration.ofMillis(milisaniye)).
                until(ExpectedConditions.visibilityOf(element));
    }


   public void alertAccept(){
       driver.switchTo().alert().accept();
   }

   public void alertDismiss(){
       driver.switchTo().alert().dismiss();
   }

   public void alertPrompt(String text){
       driver.switchTo().alert().sendKeys(text);
   }

   public String alertText(){
    return driver.switchTo().alert().getText();
   }

   public WebElement find(By locator){
    return driver.findElement(locator);
   }

   public void click(By locator){
        find(locator).click();
   }

   public void clicked(By locator,WebDriver driver){
       driver.findElement(locator).click();
   }
}
