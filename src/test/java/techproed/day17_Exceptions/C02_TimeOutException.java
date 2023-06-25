package techproed.day17_Exceptions;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {

    @Test
    public void TimeOutException() {
        /*
        TimeOutException:
            Sayfada aradıgımız elementi wait ile belirttigimiz max sürede bulamadıgı durumda
            'TimeOutException' hatası alırız.
         */

       //techproeducation sayfasına gidelim
        driver.get("http://techproeducation.com");
        bekle(3);
       //Reklamı kapatalım
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //searchbox görünür oluncaya kadar bekleyin
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='YANLISelementor-search-form-9f26725']")));
        //wait işlemindeki locator yanlıs oldugundan 'TimeOutException' hatası verdi.

        /*
        TimeOutException alabilmek icin visibilityOfElementLocated methodunu kullanarak yanlıs bir locate aldık.

        Webelementi beklerken o webelementin locate'ini bulamadıgı icin max belirttiğimiz süre kadar bekledi ve "TimeOutException"
        hatasını verdi.
         */
    }

    @Test
    public void TimeOutException2() {
        //https://the-internet.herokuapp.com/dynamic_loading/1 sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1 ");
        //Start butonun tıklayınız
        driver.findElement(By.xpath("//button[text()='Start']")).click();
        //Hello world yazısının görünürlüğünü test ediniz
        WebElement helloWorldText=driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(helloWorldText));

        Assert.assertTrue(helloWorldText.isDisplayed());

        /*
        Normalde hello wrold yazısı ortalam 6 saniyede görünüyor
        TimeOutException alabilmek icin Explicit Wait'e max bekleme süresini 2 saniye verdim.
        Bu sebeple TimeOutException hatası aldım.
         */


    }

    /*
            TimeOutException:
Explicit wait kullanildiginda, ve element bulunamadiginda
alinir.
Explicit wait & yanlis locator-> timeout
Explicit wait & doğru locator & sure yeterli degil -> timeout
Explicit wait & dogru locator & sure yeterli & iframe var ->
time out


            Solution:
-Sureyi arttirmak
-Farkli explicit kullanmak: wait visibilityOfElementLocated
YERINE presenceOfElementLocated. Yada javascript executor
da ki waiter sayfa geçişlerini beklemek icin kullanabilirim
-Locatori tekrar kontrol etmek
-Frameworkunde hazir reusable method lar var Bu durumda
timeoutexception aldigimda hızlıca o metotlar yardımıyla
problemi cozebiliyoruz

 */
}
