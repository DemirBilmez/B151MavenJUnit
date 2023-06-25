package techproed.day17_Exceptions;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C04_StaleElementReferanceException extends TestBase {

    /*
    StaleElementReferanceException:
        Bir Web sayfasındaki bir webelementin gecerliliğinin kayboldugu durumlarda olusur
        Yani bir webelementi locate ettikten sonra sayfada refresh yada back-forward kullanıyorsak
        yeniden o elemente ulasmak istedigimizde StaleElementReferanceException hatasını alırız.

        Bunu handle edebilmek icin webelemente yeniden aynı locate'i atamalıyız.
        (Webelementin locate'ını hatırlatma gibi diyebiliriz)
     */

    @Test
    public void StaleElementReferanceExceptionTest1() {
        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        //reklamı kapatalım
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        //sayfayı yenileyelim,
        driver.navigate().refresh();

        //LMS LOGIN butonuna tıklayalım
        WebElement login= driver.findElement(By.xpath("//span[@class='tc-icon fa fa-arrow-circle-right']"));
        login.click();
    }

    @Test
    public void StaleElementReferanceExceptionTest2() {
        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        //reklamı kapatalım
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        //LMS LOGIN butonunun locate'ını alalım
        WebElement login=driver.findElement(By.xpath("//span[@class='tc-icon fa fa-arrow-circle-right']"));
        //Sayfayı yenileyelm
        driver.navigate().refresh();
        //LMS LOGIN butonuna tıklayalım
        login.click();

        /*
        Navigate işleminden sonra(refresh) kullandıgımız icin login elementinin locate'i bayatladı.Bu yüzden refreshden sonra
        login ile işlem yapamadık.(StaleElementReferanceException)

        Navigate islemi yaptıktan sonra login web elementine yeniden locate atamalıyız.!!!
         */
    }

    @Test
    public void StaleElementReferanceExceptionTest3() {
        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        //reklamı kapatalım
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        //LMS LOGIN butonunun locate'ını alalım
        WebElement login=driver.findElement(By.xpath("//span[@class='tc-icon fa fa-arrow-circle-right']"));
        //Sayfayı yenileyelm
        driver.navigate().refresh();
        //LMS LOGIN butonuna tıklayalım
        login=driver.findElement(By.xpath("//span[@class='tc-icon fa fa-arrow-circle-right']"));//Burada logine yeniden atama yaparak exception'ı handle ettiik..
        login.click();

        /*
        Navigate işleminden sonra(refresh) kullandıgımız icin login elementinin locate'i bayatladı.Bu yüzden refreshden sonra
        login ile işlem yapamadık.(StaleElementReferanceException)

        Navigate islemi yaptıktan sonra login web elementine yeniden locate atamalıyız.!!!
         */
    }


}
