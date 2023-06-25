package techproed.day17_Exceptions;

import Utilities.TestBase;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class C03_NullPointerException extends TestBase {
    /*
    NullPointerException:
        Degisken yada obje olusturup bu degiskene atama yapmadıgımızda yada esitlemedigimizde
        'NullPointerException' hatası alırız.
     */

    WebDriver driver;

    Faker faker;

    Actions actions;

    Integer sayi;

    String isim;

    @Test
    public void NullPointerExceptionTest1() {

        /*
        driver=new ChromeDriver(); atamasını yapmadığımız icin NullPointerException hatasını aldım.
         */
        driver.get("https://amazon.com");
    }

    @Test
    public void NullPointerExceptionTest2() {
        //faker=new Faker(); atamasını yapmadıgımız icin NullPointerException aldım
        System.out.println(faker.name().firstName());
    }

    @Test
    public void NullPointerExceptionTest3() {
        //actions=new Actions(); atamasını yapmadıgım icin NullPointerException aldım
        actions.doubleClick().perform();
    }

    @Test
    public void NullPointerExceptionTest4() {
        //   sayi=6; sayi degiskenine atama yapmadıgımız icin
        System.out.println(sayi+5);
    }

    @Test
    public void NullPointerExceptionTest5() {
        // isim="Burak"; isim degiskenine atama yapıladıgı icin NullPointerException hatası aldık.
        System.out.println(isim.charAt(0));
    }
}
