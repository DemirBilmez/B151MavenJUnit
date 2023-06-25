package techproed.day16_SeleniumWait;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C04_ExplicitWaitClassWork extends TestBase {
    @Test
    public void test01() {
        //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver adresine gidelim
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
        //Click me to open an Alert buttonuna basalım
        driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
        //alertWait(5);
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.alertIsPresent());
        //Çıkan Alert'ü kapatalım
        alertAccept();
    }

    @Test
    public void test02() {
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

        driver.findElement(By.xpath("//button[@id='populate-text']")).click();

        WebElement seleniumText=driver.findElement(By.xpath("//h2[text()='Selenium Webdriver']"));

        visibleFluentWait(seleniumText,11,150);
        Assert.assertEquals("Selenium Webdriver",seleniumText.getText());
    }

    @Test
    public void test03() {
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

        driver.findElement(By.xpath("//button[@id='display-other-button']")).click();

        WebElement enableButton=driver.findElement(By.xpath("//button[@id='hidden']"));

        visibleWait(enableButton,20);
        Assert.assertTrue(enableButton.isEnabled());

    }
}
