package techproed.day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Amazona gidelim

        driver.get("https://amazon.com");

        // “Samsung headphones” ile arama yapalim
        WebElement searchBox=driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
        searchBox.sendKeys("Samsung headphones", Keys.ENTER);

        //Bulunan sonuc sayısını yazdıralım
        WebElement resultText=driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println(resultText.getText());
        String resultNumber[]=resultText.getText().split(" ");
        System.out.println("Sonuc sayisi ="+ resultNumber[2]);

        //Ilk urune tıklayalım
        driver.findElement(By.xpath("(//h2//a)[1]")).click();

        //Sayfadaki tum baslıklar yazdırın
        List<WebElement> sayfaBaslıkları= driver.findElements(By.xpath("//h1 | //h2"));
        sayfaBaslıkları.forEach(t-> System.out.println(t.getText()));

        //sayfayı kapatınız
        driver.close();

    }
}
