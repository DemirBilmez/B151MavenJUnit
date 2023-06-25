package techproed.day14_Actions_Faker;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C03_KeyDownKeyUp extends TestBase {
    @Test
    public void test01() {
        //Google anasayfasına gidelim
        driver.get("https://google.com");
        //arama kutusunda shift tusuna basılı olarak selenium yazdıralım ve shift tusunu serbest bırakarak java yazdıralım
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        Actions actions = new Actions(driver);
        actions.keyDown(aramaKutusu, Keys.SHIFT).//Arama kutusunda shift tusuna bastık
                sendKeys("selenium").//selenium metnini shift tusuna basılı oldugu için büyük yazdı
                keyUp(Keys.SHIFT).//shift tusunu serbest bıraktık
                sendKeys("-java", Keys.ENTER).//bu kısmı shift'i serbest bıraktığımız icin kucuk yazdı
                perform();
    }

    @Test
    public void test02() {
        //Google anasayfasına gidelim
        driver.get("https://google.com");
        //arama kutusunda shift tusuna basılı olarak selenium yazdıralım ve shift tusunu serbest bırakarak java yazdıralım
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        aramaKutusu.sendKeys(Keys.SHIFT, "selenium", Keys.SHIFT, "-java", Keys.ENTER);
        /*
        Mouse işlemleri icin actions class'ını kullanmamız gerekir. Fakat bir metin kutusundaki klavye işlemleri icin
        actions class'ına kullanmadan sendKeys() methodu ile de istediğimiz bir metni büyük yazdırabilir.
        hatta birden fazla klavye tuslarına bastırabiliriz. Yukarıdaki örnekte sendeKeys() methodu ile Keys.SHIFT diyerek
        sonrasında yazdırmak istedigimiz metni kücük harfle yazmamıza ragmen büyük harflerle yazdırdı, tekrar Keys.SHIFT
        kullanarak shift tusunu serbest bırakyık
         */
    }

    @Test
    public void test03() {
        //Google anasayfasına gidelim
        driver.get("https://google.com");

        //Arama kutusuna "Selenium" yazın ve Enter tusuna basın
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        aramaKutusu.sendKeys("Selenium", Keys.ENTER);

        //Sayfayı bekleyin
        bekle(2);

        //Arattıgınız kelimeyi arama kutusundan ctrl+x ile keselim
        //Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
        driver.findElement(By.xpath("//*[@class='gLFyf']")).//-->sayfa yenilendiği için tekrar locate aldık
                sendKeys(Keys.CONTROL, "a");//-->Metni kesebilmemiz için önce ctrl+a ile seçmemiz gerekir
        bekle(2);
        driver.findElement(By.xpath("//*[@class='gLFyf']")).
                sendKeys(Keys.CONTROL, "x");//-->Seçilen metni ctrl+x ile kestik
        bekle(2);
        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
        driver.navigate().to("https://google.com");
        driver.findElement(By.xpath("//*[@class='gLFyf']")).
                sendKeys(Keys.CONTROL, "v", Keys.ENTER);//-->Kestiğimiz metni ctrl+v tusu ile tekrar arama kutusuna yapıştırdık ve arattık
    }
}
