package techproed.day15_filesExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C03_FileUploadTest extends TestBase {
    @Test
    public void test01() {
//      https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

         /*
         Eğer dosya seç buronuna basmamız istenirse ve otomasyon ile bu butona click yaptığımızda exception alıyoraak,
         direkt upload yapmak istedigimiz dosya yolunu alip sendKeys() methodu ile dosyayi sayfaya upload yapabiliriz.
         Eger upload ya da dosyaSec butonuna tikladiginizda windows penceresi aciliyorsa o webelemente
         sendKeys() methodu ile dosya gonderemeyebilirsiniz. Boyle bir durumla karsilasirsaniz
         Robot class'indan obje ile methodlar kullanarak bunu asabilirsiniz.
         */


//      Dosya Seç butonuna basalim
        WebElement dosyaSec = driver.findElement(By.id("file-upload"));
        //dosyaSec.click(); //  hata aldık

//      Yuklemek istediginiz dosyayi secelim.
        String dosyaYolu ="C:\\Users\\EXCALIBUR\\Downloads\\b10 all test cases, code.docx";
        dosyaSec.sendKeys(dosyaYolu);

//      Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

//      "File Uploaded!" textinin goruntulendigini test edelim.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());


    }
}
