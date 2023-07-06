package techproed.day20_WebTables_Excel;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {
    /*
    WEBTABLE;
        <table> tagi ile baslar
            <thead> basliklar icin bu tag ile devam eder
                <tr> başlıkların satırı
                <th> table head
                    <td> basliktaki veriler
                 <tbody> basliklar altindaki verileri temsil eder
                          <tr> table row(satir)
                              <td> table data

     */
    @Test
    public void test01() {
        extentReport("Chrome","WebTable");
        extentTest = extentReports.createTest("WebTable","Test Raporu");

        //    https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");
        extentTest.info("Sayfaya gidildi");

        //    Task 1 : Table1’i yazdırın
        WebElement table1 = driver.findElement(By.xpath("(//table)[1]"));
        System.out.println("Tablo 1");
        System.out.println(table1.getText());
        extentTest.info("Tablo1 yazdırıldı");

        //    Task 2 : 3. Satır verilerini yazdırın
        WebElement ucuncuSatir = driver.findElement(By.xpath("(//table)[1]//tr[3]"));
        System.out.println("*********************************************");
        System.out.println(ucuncuSatir.getText());
        extentTest.info("3. Satır verileri yazdırıldı");

        //    Task 3 : Son satırın verilerini yazdırın
        WebElement sonSatir = driver.findElement(By.xpath("(//tbody)[1]//tr[last()]"));
        //last() --> istenilene göre son satir yada sütün bilgilerini verir
        System.out.println("1. Tablo Son Satir Bilgileri : "+sonSatir.getText());
        extentTest.info("Son satırın verileri yazdırıldı");

        //    Task 4 : 5. Sütun verilerini yazdırın
        System.out.println("**********************************");
        WebElement besinciBaslik = driver.findElement(By.xpath("(//thead)[1]//th[5]"));
        System.out.println(besinciBaslik.getText());//-->5. sütun başlığı
        List<WebElement> besinciSutun = driver.findElements(By.xpath("(//tbody)[1]//td[5]"));
        besinciSutun.forEach(t-> System.out.println(t.getText()));
        extentTest.info("5. Sütun verileri yazdırıldı");

        //    Task 5: 3. Satırdaki 1. ve 2. sütun bilgilerini yazdırınız.
        System.out.println("**********************************");
       List < WebElement> ucuncuSatirr = driver.findElements(By.xpath("(//tbody)[1]//tr[3]//td[position() >= 1 and position() <= 2]"));
        ucuncuSatirr.forEach(t-> System.out.println(t.getText()+"\t"));
        extentTest.info("3. Satırdaki 1. ve 2. sütun bilgileri yazdırıldı");

        //    Task 6 : Iki parametreli bir Java metodu oluşturalım: printData
        //    Parameter 1 = satır numarası
        //    Parameter 2 = sütun numarası
        //    printData(2,3);  => 2. satır, 3. sütundaki veriyi yazdırsın.
        System.out.println();

       // WebElement satirSutun = driver.findElement(By.xpath("(//tbody)[1]//tr[2]//td[3]"));//fbach@yahoo.com
        // üstteki methodsuz hali alttakiler method kullanarak yazılmış hali
        printData(2,3);
        extentTest.info("2. satır 3. sütun bilgileri yazdırıldı");

        // 3. satır 2. sütun bilgisinin Jack olup olmadığını doğrulayın
        System.out.println(printData(3, 2));
        String actualData = printData(3,2);
        String expectedData = "Jack";
        Assert.assertNotEquals(expectedData, actualData);
        extentTest.fail("3. satır 2. sütun bilgisinin Jack değil, Jason olduğu görüldü");
        extentTest.pass("Sayfa kapatıldı");
        extentReports.flush();

    }

    private String printData(int satir, int sutun) {
        WebElement satirSutun = driver.findElement(By.xpath("//tbody[1]//tr["+satir+"]//td["+sutun+"]"));
       return satirSutun.getText();
    }


    @Test
    public void test02() {

        //ÖDEV
//C03_WebTables class'ı için aldığımız rapora gidelim
        // not : driver.get("testOutput/extentReports/extentReport_09_51_40_26062023.html")
        driver.get("testOutput/extentReports/extentReport_09_51_40_26062023.html");

//Başlığın Extent Report olduğunu test edelim
        Assert.assertEquals(driver.getTitle(),"Extent Report");

//Rapor temasını dark yapalım
        driver.findElement(By.id("theme-selector")).click();

//Dashboard bölümüne gidip tabloyu yazdırınız
        driver.findElement(By.xpath("(//a)[3]"));
        System.out.println(driver.findElement(By.xpath("(//table)[3]")));

//Tester'ın "isminiz" olduğunu doğrulayalım
        String actualData = printData(2,2);
        String expectedData = "Yusuf";
        Assert.assertNotEquals(expectedData, actualData);

//Sayfayı kapatalım
        driver.close();
    }
}

