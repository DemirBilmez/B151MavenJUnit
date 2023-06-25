package techproed.day17_Exceptions;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class C01_NoSuchElementException extends TestBase {


    @Test
    public void NoSuchElementException() {
        /*
        NoSuchElementException:
                   Sayfada bulunmayan bir elemente erişim sağlanmaya calisildiginda 'NoSuchElementException'
                   hatasını alırız.
         */

        //techproeducation sayfasına gidiniz
        driver.get("http://techproeducation.com");
        bekle(3);
        //reklamı kapatınız
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        //searchbox'a 'java' yazıp aratalım
        driver.findElement(By.xpath("//input[@id='YANLISelementor-search-form-9f26725']")).sendKeys("java", Keys.ENTER);



        /*
     NoSuchElementException:
Yanlis locator
Popup, yeni pencere, iframe,…
Sayfa dolmada problemler ve yavaslamalar
Sakli olan elementle

            Solution:
Locatorin dogrulugunu tekrar kontrol et
Manual test ile iframe, yeni pencere, alert,… gibi elementlerin varligini kontrol et.
Bekleme problemi olabilir. Implicit wait bekleme suresini cozmuyor. Bu durumda explicit wait yada
fluent wait kullaniriz
     */
    }
}
