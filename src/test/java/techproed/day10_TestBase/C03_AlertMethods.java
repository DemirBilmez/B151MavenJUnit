package techproed.day10_TestBase;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class C03_AlertMethods extends TestBase {

    @Test
    public void acceptAlert() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //  1. butona tıklayın,
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
       bekle(2);

        //uyarıdaki OK butonuna tıklayın
        alertAccept();
        bekle(2);

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
        bekle(2);
        //uyarıdaki Cancel butonuna tıklayın
        alertDismiss();
        bekle(2);

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
        alertText();

        bekle(2);
        //uyarıdaki metin kutusuna isminizi yazin OK butonuna tıklayın
        alertPrompt("Demir");
        bekle(2);
        alertAccept();
        bekle(2);
        // ve result mesajında isminizin görüntülendiğini doğrulayın.
        String name="Demir";
        String expName=driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertTrue(expName.contains(name));
    }

}
