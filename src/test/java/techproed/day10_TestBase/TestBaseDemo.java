package techproed.day10_TestBase;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;

public class TestBaseDemo extends TestBase {

    @Test
    public void name(){

        //techproeducation sayfasına gidiniz
        driver.get("https://techproeducation.com");

        String actuelTitle = driver.getTitle();
        String expectedTitle = "Bootcamp";

        Assert.assertTrue(actuelTitle.contains(expectedTitle));

    }
}
