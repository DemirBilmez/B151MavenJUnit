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

public class C03_DropDown {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void programminLanguage(){
        // https://testcenter.techproeducation.com/index.php?page=dropdown sayfasına gidiniz
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        // Programlama Dili Dropdown'undan "Java" seciniz
        WebElement languages=driver.findElement(By.xpath("//select[@name='Languages']"));
        Select select=new Select(languages);
        select.selectByVisibleText("Java");
        select.selectByIndex(0);
        // Programlama Dili Dropdown'undan son secilen option'un "Java" oldugunu test ediniz
        WebElement lastSelectedOption=select.getFirstSelectedOption();
        String lastSelectedOptionString=lastSelectedOption.getText();
        Assert.assertEquals("Java",lastSelectedOptionString);

        // Programlama Dili Dropdown'undaki tum optionları konsolda yazdırınız

        /*List<WebElement> options=driver.findElements(By.xpath("//select[@name='Languages']//option"));
        options.forEach(t-> System.out.println(t.getText()));*/

       // List<WebElement> allOptions=select.getOptions();
        //allOptions.forEach(t-> System.out.println(t.getText()));

        //Sayyfadaki tüm DropDownlardaki tüm opiton'ları yazdıralım

        List<WebElement> allDropDowns=driver.findElements(By.tagName("option"));
        allDropDowns.forEach(t-> System.out.println(t.getText()));

    }



}
