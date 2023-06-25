package techproed.day16_SeleniumWait;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.beans.Visibility;
import java.time.Duration;

public class C01_ExplicitWait extends TestBase {
    /*
    SELENIUM WAIT:
             IMPLICITLY WAIT--> Driver'ı olusturduktan sonra sayfadaki tüm webelementlerin etkileşime girebilmesi icin
            belirtmiş ooldugumuz maximum (Duration.ofSecond(20)) süre kadar bekler.
             EXPLICIT WAIT--> Bir webelementin sayfa yüklendikten sonra etkileşime girebilmesi icin
            maximum belirtmiş oldugumuz süre kadar default olarak yarım saniyelik aralıklarla bekler.
                Ornegin bir webelemente tıkladık ve bir alert'ün çıkması zaman alabilir. internet yoğunluğundan yada sayfaının performansından kaynaklı
                bu süreyi normalde kullandıgımız Thread.sleep() ile de çözebiliriz fakat testimizi her calistirdigimizda
                Thread.sleep() icin kac saniye beklemesi gerektiğini kestiremeyebiliriz. Bu gibi durumlar icin
                explicit wait kullanırız
                   EXPLICIT WAIT / FluentWait --> Bir webelemwnt'in sayfa yuklendikten sonra etkilesime girebilmesi icin max. belirtmis oldugumuz
                            sure kadar bizim belirttigimiz araliklarda (saniye/salise) bekler
     */
    @Test
    public void test01(){
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button[text()='Start']")).click();
        //Hello World! Yazının sitede oldugunu test et

        WebElement helloWorld=driver.findElement(By.xpath("(//h4)[2]"));
        //Locate'ini aldığımız helloWorldText webelementini görünür olana kadar explicit wait ile bekleyeceğim
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(helloWorld));
        Assert.assertEquals("Hello World!",helloWorld.getText());
    }

    @Test
    public void test02() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button[text()='Start']")).click();
        //Hello World! Yazının sitede oldugunu test et

        WebElement helloWorld=new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h4)[2]")));
        //Locate'ini aldığımız helloWorldText webelementini görünür olana kadar explicit wait ile bekleyeceğim

        Assert.assertEquals("Hello World!",helloWorld.getText());
    }

    @Test
    public void test03() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button[text()='Start']")).click();
        //Hello World! Yazının sitede oldugunu test et

      new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h4)[2]")));

        Assert.assertEquals("Hello World!",driver.findElement(By.xpath("(//h4)[2]")).getText());
    }

    @Test
    public void test04() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button[text()='Start']")).click();
        //Hello World! Yazının sitede oldugunu test et

        WebElement helloWorld=driver.findElement(By.xpath("(//h4)[2]"));

        WebElement loading=driver.findElement(By.xpath("//div[@id='loading']"));

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOf(loading));//Loading kutusu görünmez olana kadar bekliycez
        Assert.assertEquals("Hello World!",helloWorld.getText());
    }
}
