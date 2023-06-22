package techproed.day17_Exceptions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import techproed.utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {
    @Test
    public void test01() {
        /*
        NO_SUCH_ELEMENT_EXCEPTION
            -Bir webelementin locate'ini yanlis aldigimizda, elementi bulamayacagi icin bu
            exception'i aliriz
     */

        //techproeducation sayfasına gidelim
        driver.get("https://www.techproeducation.com");

        //reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //arama kutusunda qa aratalım
        driver.findElement(By.xpath("//*[@type='search']")).sendKeys("qa", Keys.ENTER);
   /*
        normal locatemiz //*[@type='search'] bu sekilde iken NoSuchElementException alabilmek icin locate'i bozduk
        //*[@type='ssearch'] ve exception'i aldigimizi gorduk. Dolayisiyla bu hatayi handle edebilmek icin
        duzgun locate almamiz gerekiyor
   */

        //sayfa başlığının qa içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("qa"));
    }
    @Test
    public void test02() {
        //techproeducation sayfasına gidelim
        driver.get("https://www.techproeducation.com");

        //reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //arama kutusunda qa aratalım
        driver.findElement(By.cssSelector("//*[@type='search']")).sendKeys("qa", Keys.ENTER);
         /*
        org.openqa.selenium.InvalidSelectorException: xpath ile aldigimiz bir webelementin locate'ini
        cssSelector locator ile kullanirsak bu exception'i aliriz.Dolayisiyla bunu handle etmek icin
        dogru locator'i kullanmamiz gerekir.Webelement bir iframe icinde olabilir, bir butona tikladigimizda yeni bir
        pencere acilabilir yada alert cikabilir bu gibi durumlarda da nosuchelementexception aliriz
         */

        //sayfa başlığının qa içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("qa"));


    }
}
