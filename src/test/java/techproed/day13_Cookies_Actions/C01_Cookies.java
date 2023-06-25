package techproed.day13_Cookies_Actions;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class C01_Cookies extends TestBase {
    @Test
    public void test01(){
        //1-Amazon anasayfaya gidin
        driver.get("https://amazon.com");
        //2-tum cookie’leri listeleyin
      Set<Cookie> cookieSet= driver.manage().getCookies();
      int sayac=1;
      for (Cookie w:cookieSet){
          System.out.println(sayac+". cookie ="+w);
          sayac++;
      }

      //2.Yol
       // Arrays.stream(driver.manage().getCookies().toArray()).forEach(System.out::println);



        /*
        Cookie'leri listelemek istersek driver.manage().getCookies(); methoduyla bir set yada ArrayListe atarak listeleyebilieiz
         */
        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int cookiesSize=cookieSet.size();
        Assert.assertTrue(cookiesSize>5);


        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String actCookieValue=driver.manage().getCookieNamed("i18n-prefs").getValue();
        Assert.assertEquals(actCookieValue,"USD");
        // 5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie myCookie=new Cookie("en sevdiğim cookie","çikolatalı");
        driver.manage().addCookie(myCookie);

        //6-eklediginiz cookie’nin sayfaya eklendigini test edin
      cookieSet=driver.manage().getCookies();
       int sayac2=1;
        for (Cookie w:cookieSet){
            System.out.println(sayac2+". cookie ="+w);
            sayac2++;
        }
       // Assert.assertTrue(driver.manage().getCookieNamed("en sevdigim cookie").getValue().equals("cikolatali"));

        System.out.println("Cookie'lerin sayisi = "+Arrays.stream(driver.manage().getCookies().toArray()).count());
        //7-ismi skin olan cookie’yi silin ve silindigini test edin
       int silinmedeOnce=cookieSet.size();
        System.out.println("Silinmeden once Cookie sayısı = "+silinmedeOnce);
        driver.manage().deleteCookieNamed("skin");
        bekle(2);
        cookieSet=driver.manage().getCookies();//Silindikten sonra cookieSet'e yine atama yapiyoruz aksi taktirde fail aliriz
        for (Cookie each:cookieSet){
            System.out.println(each);
        }
        int silindiktenSonra=cookieSet.size();
        Assert.assertEquals(1,(silinmedeOnce-silindiktenSonra));

        //8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookieSet=driver.manage().getCookies();
        Assert.assertTrue(cookieSet.isEmpty());
    }
}
