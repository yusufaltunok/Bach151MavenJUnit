package techproed.day10_TestBase_Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

public class C03_Alert extends TestBase {
    @Test
    public void test01() {
        //https://demoqa.com/alerts adresine gidelim
        driver.get("https://demoqa.com/alerts");

        //Click Button to see alert karşısındaki butona tıklayalım
        driver.findElement(By.xpath("(//button)[2]")).click();
        bekle(2);
        //Çıkan Alert'te You clicked a button yazısının çıktığını doğrulayalım
        System.out.println("Allert üzerindeki yazı"+getTextAlert());//-->TestBase class'ında oluşturmuş olduğumuz method
        Assert.assertEquals("You clicked a button", getTextAlert());
        bekle(2);
        //Ve alert'ü kapatalım
        acceptAlert();//-->TestBase class'ında oluşturmuş olduğumuz method
    }

    @Test
    public void test02() {
        //https://demoqa.com/alerts adresine gidelim
        driver.get("https://demoqa.com/alerts");

        //On button click, confirm box will appear karşısındaki butona tıklayalım.
        driver.findElement(By.xpath("(//button)[4]")).click();
        bekle(2);

        //Çıkan alertte iptale basalım.
        dismissAlert();

        // Sonuç yazısında You selected Cancel yazdığını doğrulayalım
        String sonucYazisi = driver.findElement(By.id("confirmResult")).getText();
        Assert.assertEquals("You selected Cancel",sonucYazisi);
    }

    @Test
    public void test03() {
        //https://demoqa.com/alerts adresine gidelim
        driver.get("https://demoqa.com/alerts");

        //On button click, prompt box will appear karşısındaki butona tıklayalım
        driver.findElement(By.xpath("(//button)[5]")).click();
        bekle(2);

        //çıkan alerte ismimizi girelim
        sendKeysAlert("yusuf");
        acceptAlert();
        bekle(2);

        //ismi girdiğimizi doğrulayalım
        String sonucYazisi = driver.findElement(By.id("promptResult")).getText();
        Assert.assertTrue(sonucYazisi.contains("yusuf"));

    }
}
