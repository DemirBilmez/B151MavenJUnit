package techproed.day09_DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01_DropDown {
    /*
    DropDown: Alt baslıkların oldugu acılır menu listesidir.

    DropDown 3 adımda handle edilir

    1-)DropDown locate edilmelidir.

    2-)Select objesi olusturulmalıdır

        Select select=new Select(ddm)

    3-)Opsiyonların bir tanesi secilir
    -selectByVisibleText()==>option'a görünür metin ile ulasmak icin kullanılır
    -selectByIndex()==>option'a index ile ulasmak icin kullanılır(index 0'dan baslar)
    -selectByValue==> opiton'a value ile ulasmak icin kullanılır*/





    // Ay Dropdown'undan "August" seciniz

    // Gün Dropdown'undan "5" seciniz

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void testCenter(){
        // https://testcenter.techproeducation.com/index.php?page=dropdown sayfasına gidiniz
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

        // Yıl Drodown'undan "2020" seciniz
        WebElement ddmYear=driver.findElement(By.xpath("//select[@id='year']"));
        Select select=new Select(ddmYear);
        //select.selectByValue("2020");
        //select.selectByVisibleText("2020");
        select.selectByIndex(3);

        //    // Ay Dropdown'undan "August" seciniz

        WebElement ddmMonth=driver.findElement(By.xpath("//select[@id='month']"));
        Select select2=new Select(ddmMonth);
        //select2.selectByValue("August");
        //select2.selectByVisibleText("August");
        select2.selectByIndex(7);


        // Gün Dropdown'undan "5" seciniz

        WebElement ddmDay=driver.findElement(By.xpath("//select[@id='day']"));
        Select select3=new Select(ddmDay);
        //select3.selectByValue("5");
        //select3.selectByVisibleText("5");
        select3.selectByIndex(4);


    }


}
