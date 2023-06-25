package techproed.day14_Actions_Faker;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C03_Actions_DragDrop extends TestBase {
    @Test
    public void test01(){
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag,drop).perform();
        /*
            Eğer bir hareketli webelementi tutup başka bir webelementin üzerene bırakmak istersek
         sürüklemek istediğimiz we'tin locatini alıp üzerine bırakacağımız we'tin locate'ini de alarak
         dragAndDrop(kaynak,hedef) methodu ile işlemi gerçekleştirebiliriz
         */

    }

    @Test
    public void test02() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
    /*
    drag ve drop webelementleri iframe içinde olduğu için iframe geçiş yapmalıyız
     */
        driver.switchTo().frame(0);
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions=new Actions(driver);
        actions.clickAndHold(drag).//Bu method ile webelemente mouse ile basılı tuttuk
                moveToElement(drop).//Bu method ile basılı tuttuğumuz web elementi diger web elementin üzerine götürdük
                release().//Bu method ile basılı tuttugumuz web elementi serbest bıraktık
                perform();
    }

    @Test
    public void test03() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
    /*
    drag ve drop webelementleri iframe içinde olduğu için iframe geçiş yapmalıyız
     */
        driver.switchTo().frame(0);
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).
                moveByOffset(84,28).//-->Belirtmiş olduğumuz kordinatlara we'ti taşır
                release().perform();

    }
}
