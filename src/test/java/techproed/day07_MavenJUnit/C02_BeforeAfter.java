package techproed.day07_MavenJUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeAfter {

         /*
     Notasyonlara sahip methodlar olşturabilmek için mouse sağ tik + generate ( alt + insert ) yaparak
     after methodu icin teardown'u seceriz.
     before methodu icin setup'i seceriz.
     test methodu icin de test'i seceriz
     JUnit frameworkunde testlerimizi siralama yapabilmek icin ekstra bir notasyon yoktur.
     Eger belli bir siralamada calistirmak istersek method isimlerini alfabetik ve sayisal olarak belirtmemiz gerekir
     JUnit'te Testleri alfabetik sıraya göre çalıştırır

          */

     @After
     public void tearDown() {
          System.out.println("Her test methodundan sonra bir kez after çalışır");

     }

     @Before
     public void setUp()  {
          System.out.println("Her test methodundan önce bir kez before çalışır");

     }

     @Test
     public void test1() {
          System.out.println("Test1 methodu çalıştı");

     }  @Test
     public void test2() {
          System.out.println("Test2 methodu çalıştı");

     }  @Test
     public void test3() {
          System.out.println("Test3 methodu çalıştı");

     }

}
