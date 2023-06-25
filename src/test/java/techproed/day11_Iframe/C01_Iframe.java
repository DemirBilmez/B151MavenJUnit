package techproed.day11_Iframe;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C01_Iframe extends TestBase {


    @Test
    public void iframe() {
        //==>   https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get(" https://testcenter.techproeducation.com/index.php?page=iframe");
//==>  Ana sayfadaki 'An iframe with a thin black border:' yazısının 'black border' icerdigini test edin
        String exp = "black border";
        String act = driver.findElement(By.xpath("//p[text()='An iframe with a thin black border:']")).getText();
        Assert.assertTrue(act.contains(exp));

        //==>  icteki web sayfasında 'Applications lists' yazisinin görünür oldugunu test edelim

        WebElement iframe = driver.findElement(By.xpath("//iframe[@style='border:1px solid black;']"));
        driver.switchTo().frame(iframe);


        /*
        Applications lists yazısını dogru locate edip,
        dogru sekilde görünür oldugunu test etmemize ragmen Faild oldu
        bunun üzerine HTML kodlarını inceleyince
        Applications lists yazısının aslında bir iframe icerisinde oldugunu gördük
        bu durumda once iframe'i locate edip
        switchTo() ile iframe'e gecmeliyiz
         */




        WebElement aplicationsYazisi = driver.findElement(By.xpath("//h1[text()='Applications lists']"));

        Assert.assertTrue(aplicationsYazisi.isDisplayed());

//==>   Ana sayfadaki'Povered By' yazisinin "Povered" icerdigini test edin

        driver.switchTo().defaultContent();
        String actual= driver.findElement(By.xpath("//p[text()='Povered By']")).getText();
        String expected="Povered";
        Assert.assertTrue(actual.contains(expected));
    }
}
