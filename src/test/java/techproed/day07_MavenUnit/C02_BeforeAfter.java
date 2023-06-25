package techproed.day07_MavenUnit;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_BeforeAfter {

    /*
    Notasyonlara sahip methodlar olusturabilmek icin mouse+sag tik +generate(kisayol alt + insert) yaparak
    after methodu icin teardown'u seceriz.
    before methodu icin setup'i seceriz.
    test methodu icin de test'i seceriz

     Junit frameworkunde testlerimizi sıralama yapabilmek için ekstra bir notasyon yoktur
Eğer belli bir sıralamada çalıştırmak istersek method isimlerini alfabetik ve sayıl olarak belirtmemiz gerekir.
*/
    @After
    public void tearDown() {
        System.out.println("Her test methodundan sonra bir kez calisir!");
    }

    @Before
    public void setUp()  {
        System.out.println("Her test methodundan once bir kez calisir");
    }

    @Test
    public void test1() {
        System.out.println("Test1 methodu calisti");
    }
    @Test
    public void test2() {
        System.out.println("Test2 methodu calisti");
    }
    @Test
    public void test3() {
        System.out.println("Test3 methodu calisti");
    }


}