package techproed.day15_FileExist;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class C03_FileUpload extends TestBase {
    @Test
    public void name() {

        // masaustunde bir deneme dosyası olusturun


        // 'https://the-internet.herokuapp.com/upload' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/upload");

        bekle(2);


        // 'Dosya Seç' kısmına deneme dosyasını yükleyiniz
        WebElement dosyaSec=driver.findElement(By.xpath("//input[@id='file-upload']"));
        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\OneDrive\\Masaüstü\\deneme.txt";

        String dosyaYolu = farkliKisim + ortakKisim;


        dosyaSec.sendKeys(dosyaYolu);


        bekle(3);

        // 'Upload' butonuna basın
        WebElement upload=driver.findElement(By.xpath("//input[@id='file-submit']"));
        upload.click();
        bekle(2);

        // 'File Uploaded!' yazısının goruntulendigini test edin
        WebElement fileUploaded = driver.findElement(By.xpath("//h3[text()='File Uploaded!']"));

        Assert.assertTrue(fileUploaded.isDisplayed());


    }
}
