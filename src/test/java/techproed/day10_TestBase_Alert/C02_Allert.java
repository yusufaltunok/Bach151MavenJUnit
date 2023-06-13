package techproed.day10_TestBase_Alert;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C02_Allert extends TestBase {

       /*
        Eğer web sayfasındaki bir butona tıkladığımızda uyarı penceresi çıkıyorsa
         ve bu çıkan pencereye sağ click yapıp locate alamıyorsak, bu bir js Alert'tür.
        Js Alert'u handle edebilmek icin driver'imizi o pencereye gecirmemeiz gerekir. Bunun icin; driver objemizi kullanarak
       swichTo() methoduyla alert() methodunu kullanarak js alert'e gecir yapmis oluruz.
       accept() ya da dismiss() methodlariyla js Alert'u onaylar ya da iptal ederek kapatiriz

         */

    //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
    //Bir metod olusturun: acceptAlert
    //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
    //Bir metod olusturun: dismissAlert
    //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    //“successfuly” icermedigini test edin.
    //Bir metod olusturun: sendKeysAlert
    //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.


    @Test @Ignore //--> Çalışmasını istemediğimiz test notasyonundan sonra @Ignore notasyonu kullanırız
    public void acceptAlert() {
        //Bir metod olusturun: acceptAlert
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("(//button)[1]")).click();
        bekle(3);
        driver.switchTo().//geçmek için kullanılan method
                alert().//alert'e geçiş yapar
                accept();//çıkan alert'te ok yada tamam butonuna tıklar
        bekle(2);
        WebElement resultMessage = driver.findElement(By.xpath("(//p)[2]"));
        String istenenYazi = "You successfully clicked an alert";
        Assert.assertEquals(istenenYazi, resultMessage.getText());

    }

    @Test
    public void dismissAlert() {
        //Bir metod olusturun: dismissAlert
//  https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
//  2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve
        driver.findElement(By.xpath("(//button)[2]")).click();
        bekle(3);
        driver.switchTo().alert().dismiss();//js Alert'teki iptal butonuna basar
        bekle(2);
//  result mesajının “successfuly” icermedigini test edin.
        WebElement resultMessage = driver.findElement(By.xpath("(//p)[2]"));
        String istenenYazi = "successfuly";
        Assert.assertFalse(resultMessage.getText().contains(istenenYazi));

    }

    @Test
    public void sendKeysAlert() {
        //Bir metod olusturun: sendKeysAlert
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve
        driver.findElement(By.xpath("(//button)[3]")).click();
        driver.switchTo().alert().sendKeys("Yusuf Altunok");
        bekle(2);
        driver.switchTo().alert().accept();

        // result mesajında isminizin görüntülendiğini doğrulayın.
        WebElement resultMessage = driver.findElement(By.xpath("(//p)[2]")); // You entered: Yusuf Altunok
        String istenenYazi = "Yusuf Altunok";
        Assert.assertTrue(resultMessage.getText().contains(istenenYazi));


    }
}
