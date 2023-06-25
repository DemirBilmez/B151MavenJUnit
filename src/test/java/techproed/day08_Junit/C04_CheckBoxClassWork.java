package techproed.day08_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_CheckBoxClassWork {
    // https://the-internet.herokuapp.com/checkboxes sayfasına gidin
// Checkbox1 ve checkbox2 elementlerini locate edin.
// Checkbox1 seçili değilse secin
// Checkbox2 seçili değilse secin

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void checkBox1(){
        driver.get(" https://the-internet.herokuapp.com/checkboxes");
        WebElement check= driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
       check.click();
        isChecked(check,By.xpath("(//input[@type='checkbox'])[1]"));
    }

    @Test
    public void checkBox2(){
        driver.get(" https://the-internet.herokuapp.com/checkboxes");
        WebElement check= driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        check.click();
        isChecked(check,By.xpath("(//input[@type='checkbox'])[2]"));
    }

    @Test @Ignore("Gereksiz")
    public void ignor(){
        driver.get("https://amazon.com");
    }



    public boolean isChecked(WebElement checkBox, By locator){

        checkBox=driver.findElement(locator);
        if (checkBox.isSelected()){
            System.out.println("CheckBox seçili");
        }else {

            System.out.println("CheckBox  seçili değildi seçildi");
            checkBox.click();
        }

        return checkBox.isSelected();


    }
}
