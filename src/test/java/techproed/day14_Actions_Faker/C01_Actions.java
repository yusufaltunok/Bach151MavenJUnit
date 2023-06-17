package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C01_Actions extends TestBase {
    @Test
    public void test01() {
//  techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        // reklemı kapat
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

//  sayfanın altına doğru gidelim
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
        bekle(2);

//  sayfanın üstüne doğru gidelim
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP).perform();

    }

    @Test
    public void test02() {
        //  techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        // reklemı kapat
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

//  sayfanın en altına scroll yapalım
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END);
        bekle(3);

//  sayfanın en üstüne scroll yapalım
        actions.sendKeys(Keys.HOME).build().perform();

        // build() methodu action'ları birleştirmek için kullanılan methoddur.
        // Birden fazla olşturduğumuz action objesini birbirine baglar.
        // Eger yapilan islemin cok hizli olmasini istemiyorsak build() kullanmak yerine her action'dan sonra perform() kullanmamiz gerekir.
        // bekle() koysak bile beklemez. Çok hızlı çalışır.
        //relaise() methodu mouse'u bırakır. Drag and drop yaparken mouse'u bırakmak için kullanılır.

    }

    @Test
    public void test03() {

        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        bekle(2);
        //sayfanın altına doğru gidelim
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0,1500).perform();
        bekle(3);

        //sayfanın üstüne doğru gidelim
        actions.scrollByAmount(0,-1500).perform();






    }
}
