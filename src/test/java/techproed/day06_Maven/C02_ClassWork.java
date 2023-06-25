package techproed.day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_ClassWork {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1.http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2.Signin buttonuna tiklayin
        WebElement signinButton=driver.findElement(By.xpath("//button[@id='signin_button']"));
        signinButton.click();
        //3.Login alanine "username" yazdirin
        driver.findElement(By.cssSelector("input#user_login")).sendKeys("username");
        //4.Password alanine "password" yazdirin
        driver.findElement(By.cssSelector("input#user_password")).sendKeys("password");
        //5.Sign in buttonuna tiklayin
        WebElement signButton= driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
        signButton.click();

        driver.navigate().back();
        //6.Online Banking altında Pay Bills sayfasina gidin
         WebElement onlineBanking=driver.findElement(By.xpath("(//*[text()=.])[11]"));
        //-->(//*[text()=.])[11] Bu şekilde text ile aldığımız bir xpath'de text değişse bile biz o webelementi handle edebiliriz.
        onlineBanking.click();
        Thread.sleep(2000);
        driver.findElement(By.id("(//h4)[4]//span")).click();
        Thread.sleep(3000);
        //7.amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.cssSelector("input#sp_amount")).sendKeys("3000");

        //8.tarih kismina "2020-09-10" yazdirin
        driver.findElement(By.cssSelector("input#sp_date")).sendKeys("03-08-1998");
        Thread.sleep(3000);
        //9.Pay buttonuna tiklayin
        driver.findElement(By.cssSelector("input#pay_saved_payees")).click();
        //10."The payment was successfully submitted." mesajinin ciktigini control edin
        boolean isDisplayed=driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']")).isDisplayed();
        if (isDisplayed){
            System.out.println("'The payment was successfully submitted' is visible");
        }else {
            System.out.println("'The payment was successfully submitted' is not visible");
        }





    }
}
