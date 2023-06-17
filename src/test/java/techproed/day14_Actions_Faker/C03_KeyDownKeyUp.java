package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C03_KeyDownKeyUp extends TestBase {
    @Test
    public void test01() {
//  Google anasayfasına gidelim
        driver.get("https://www.google.com");

//  arama kutusunda shift tusuna basılı olarak selenium yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
       WebElement aramaKutusu =  driver.findElement(By.id("APjFqb"));
        Actions actions = new Actions(driver);
        actions.keyDown(aramaKutusu, Keys.SHIFT). // arama Kutusunda SHIFT tuşuna bastık.
            sendKeys("selenium-"). // --> selenium metnini SHIFT tuşuna basılı olduğu için büyük yazdı.
            keyUp(Keys.SHIFT). // SHIFT tuşunu serbest bırak
            sendKeys("java",Keys.ENTER). // SHIFT tuşunu serbest bıraktığımız için küçük yazdı
            perform();

        // Actions'u genellikle mouse kullanmamız gereken durumlarda kullanırız.

    }
    @Test
    public void test02() {
//  Google anasayfasına gidelim
        driver.get("https://www.google.com");

//  arama kutusunda shift tusuna basılı olarak selenium yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement aramaKutusu =  driver.findElement(By.id("APjFqb"));
        aramaKutusu.sendKeys(Keys.SHIFT,"selenium ",Keys.SHIFT,"java",Keys.ENTER);

    // Klavye tuşlarını kullanmamız gereken durumlarda Action kullanmamıza gerek kalmadan üstteki şekilde .sendKeys() ile kullanabiliriz..


    /*
        Mouse islemleri icin actions class' ini kullanmamiz gerekir. Fakat bir metin kutusundaki klavye islemleri icin
        actions class' ini kullanmadan sendKeys() methodu ile de istedigimiz bir metni buyuk yazdirabilir,
        hatta birden fazla klavye tuslarina bastirabiliriz.
        Yukaridaki ornekte sendKeys() methodu ile Keys.SHIFT diyerek sonrasinda yazdirmak istedigimiz metni kucuk harfle
        yazmamiza ragmen buyuk harflerle yazdirdi, tekrar Keys.SHIFT
        kullanarak shift tusunu serbest birakmis olduk

        */

    }
    @Test
    public void test03() {
//  google sayfasına gidelim
        driver.get("https://www.google.com");

//  Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
        WebElement aramaKutusu =  driver.findElement(By.id("APjFqb"));
        aramaKutusu.sendKeys("Selenium ",Keys.ENTER);

//   Sayfayı bekleyin
        bekle(4);

//   Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
        driver.findElement(By.id("APjFqb")).  //-->Sayfa yenilendigi icin tekrar locate aldik
                sendKeys(Keys.CONTROL,"a"); // metni kaesebilmek için önce ctrl+a ile seçmemiz gerekir.
        driver.findElement(By.id("APjFqb")).
                sendKeys(Keys.CONTROL,"x"); // seçilen metni ctrl+x ile kestik

//   Sayfayı bekleyin
        bekle(3
        );
//  Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
        driver.navigate().back();
        aramaKutusu.sendKeys(Keys.CONTROL,"v",Keys.ENTER); // Kestiğimiz metni ctrl+v ile arama kutusuna yapıştırdık.

    }

}
