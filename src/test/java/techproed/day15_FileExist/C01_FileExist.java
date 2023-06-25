package techproed.day15_FileExist;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileExist {
    @Test
    public void fileExist(){
        System.out.println(System.getProperty("user.dir"));
        //C:\Users\demir\IdeaProjects\B151MavenJUnit
        // bana icinde oldugum projenin dosya yolunu(path) verir.

        System.out.println(System.getProperty("user.home"));//C:\Users\demir
        // herkesin bilgisayarında farklı olan kısmı verir.


        // SORU:
        // Desktop(masaustu)'da bir text dosyası olusturun

        // Desktop(masaustu)'da text dosyasının olup olmadıgını test edin

        /*
        Dosyanın desktop'da oluğ olmadıgını java ile test edeceğim
        Cunku selenium web sayfalarını test eder.
        Selenium benim bilgisayarımdaki desktop'a müdahale edemez
         */

        //"C:\Users\demir\OneDrive\Masaüstü\MyText.txt"
        Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\demir\\OneDrive\\Masaüstü\\MyText.txt")));


        // daha dinamik hale getirelim

        String farkliKisim = System.getProperty("user.home");  // herkesin bilgisayarında farklı olan kısımdır
        String ortakKisim = "\\OneDrive\\Masaüstü\\MyText.txt";             // herkesin bilgisayarında ortak olan kısımdır

        String dosyaYolu = farkliKisim + ortakKisim;          // dosya yolu olarak farklı kısım ve ortak kısımı aldık

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
