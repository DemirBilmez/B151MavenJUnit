package techproed.day17_Exceptions;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class C05_StaleElementReferanceException extends TestBase {

    @Test
    public void StaleElementReferanceExceptionTest1() {
        //https://amazon.com sayfasına giidin
        driver.get("https://amazon.com");
        //Arama motoruna 'Iphone' yazıp aratın
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Iphone", Keys.ENTER);
        //Cıkan sonuclardan ilk 5'ine tıklayıp sayfa baslıklarını alalım konsola yazdıralım
        List<WebElement> results=driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));
        for(int i=0; i<=results.size();i++){
            results.get(i).click();
            System.out.println(i+". URUN TITLE: "+driver.getTitle());

            driver.navigate().back();//Navigate islemi sebebi ile StaleElementReferanceException aldık.Navigatten sonra results'a tekrar locate atamalıydık
            //results=driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));

            if (i==4){
                break;
            }
        }




    }

    @Test
    public void StaleElementReferanceExceptionTest2() {
        //https://amazon.com sayfasına giidin
        driver.get("https://amazon.com");
        //Arama motoruna 'Iphone' yazıp aratın
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Iphone", Keys.ENTER);
        //Cıkan sonuclardan ilk 5'ine tıklayıp sayfa baslıklarını alalım konsola yazdıralım
        List<WebElement> results=driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));
        for(int i=0; i<=results.size();i++){
            results.get(i).click();
            System.out.println(i+". URUN TITLE: "+driver.getTitle());

            driver.navigate().back();//Navigate islemi sebebi ile StaleElementReferanceException aldık.Navigatten sonra results'a tekrar locate atamalıydık
            results=driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));
            //Burada results'a tekrar locate atayarak Exception'ı handle ettik
            if (i==4){
                break;
            }
        }




    }
}
