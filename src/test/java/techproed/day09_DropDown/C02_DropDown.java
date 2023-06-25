package techproed.day09_DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropDown {
    /*

    -getFirstSelectedOption()==> dropdown'daki en son sectigimiz option'ı bize döndürür

    -getOptions()==> dropdown'daki tüm opsiyonları bize döndürür.
     */

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01(){
        // https://testcenter.techproeducation.com/index.php?page=dropdown sayfasına gidiniz

        driver.get(" https://testcenter.techproeducation.com/index.php?page=dropdown");
        // Select a State Dropdown'undan "Arizona" seciniz
        WebElement selectAState=driver.findElement(By.xpath("//select[@id='state']"));
        Select select=new Select(selectAState);
       // sas.selectByValue("AZ");
        select.selectByVisibleText("Arizona");
        // Select a State Dropdown'undan son secilen option'un "Arizona" oldugunu test ediniz
        WebElement lastSelectedOption= select.getFirstSelectedOption();
      String lastSelectedOptionText=lastSelectedOption.getText();
      Assert.assertEquals("Arizona",lastSelectedOptionText);
        // Select a State Dropdown'undaki tum optionları konsolda yazdırınız
       /* List<WebElement> allOptions= select.getOptions();
        allOptions.forEach(t-> System.out.println(t.getText()));*/

        //2.Yol // Select a State Dropdown'undaki tum optionları konsolda yazdırınız

        List<WebElement> options= driver.findElements(By.xpath("//select[@id='state']//option"));
        options.forEach(t-> System.out.println(t.getText()));
    }
}
