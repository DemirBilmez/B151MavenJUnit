package techproed.day10_TestBase;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class C02_Alert extends TestBase {
    /*
    https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.


    Bir metod olusturun: acceptAlert
    1. butona tıklayın,
    uyarıdaki OK butonuna tıklayın
    ve result mesajının "You successfully clicked an alert" oldugunu test edin.



    Bir metod olusturun: dismissAlert
    2. butona tıklayın,
    uyarıdaki Cancel butonuna tıklayın
    ve result mesajının "successfuly" icermedigini test edin.



    Bir metod olusturun: sendKeysAlert
    3. butona tıklayın,
    uyarıdaki mesajı konsolda yazdırın,
    uyarıdaki metin kutusuna isminizi yazin,
    OK butonuna tıklayın
    ve result mesajında isminizin görüntülendiğini doğrulayın.

     */

    @Test
    public void acceptAlert() throws InterruptedException {
    driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
      //  1. butona tıklayın,
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
       Thread.sleep(2000);

        //uyarıdaki OK butonuna tıklayın
        driver.switchTo().alert().accept(); //driver'ı alerte gecirip kabul ettik
        Thread.sleep(2000);

        //ve result mesajının "You successfully clicked an alert" oldugunu test edin.
        String expMessage="You successfully clicked an alert";
      String actMessage= driver.findElement(By.xpath("//p[@id='result']")).getText();

        Assert.assertEquals(actMessage,expMessage);
    }

    @Test
    public void dismissAlert() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //2. butona tıklayın,
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Thread.sleep(2000);
        //uyarıdaki Cancel butonuna tıklayın
        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);

        //ve result mesajının "successfuly" icermedigini test edin.
        String expMessage="successfuly";
        String actMessage= driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertFalse(actMessage.contains(expMessage));
    }

    @Test
    public void sendKeysAlert() throws InterruptedException {
       // Bir metod olusturun: sendKeysAlert
        //3. butona tıklayın,
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        //uyarıdaki mesajı konsolda yazdırın,
        System.out.println(driver.switchTo().alert().getText());

        Thread.sleep(2000);
        //uyarıdaki metin kutusuna isminizi yazin OK butonuna tıklayın
        driver.switchTo().alert().sendKeys("Demir");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
       // ve result mesajında isminizin görüntülendiğini doğrulayın.
        String name="Demir";
        String expName=driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertTrue(expName.contains(name));
    }


}
