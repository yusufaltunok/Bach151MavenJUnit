package techproed.day19_ExtentReports_WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.util.List;

public class C03_WebTables extends TestBase {
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
//    https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");

//    Task 1 : Table1’i yazdırın
        WebElement table1 = driver.findElement(By.xpath("//table[1]"));
        System.out.println("Tablo 1");
        System.out.println(table1.getText());

//    Task 2 : 3. Satır verilerini yazdırın
        WebElement ucuncuSatir = driver.findElement(By.xpath("//table[1]//tr[3]"));
        System.out.println("************* 3. Satır *******************");
        System.out.println(ucuncuSatir.getText());
        /*
         List<WebElement> list = driver.findElements(By.xpath("//table[1]//tbody//tr[3]//td"));

        list.stream().forEach(t-> System.out.print(t.getText() + " - "));
         */

//    Task 3 : Son satırın verilerini yazdırın
        WebElement sonSatir = driver.findElement(By.xpath("//table[1]//tr[4]"));
        System.out.println("************* Son Satır *******************");
        System.out.println(sonSatir.getText());
        /*
           // List<WebElement> sonSatirVerileri = driver.findElements(By.xpath("//table[1]//tbody//tr[4]//td"));

        List<WebElement> sonSatirVerileri = driver.findElements(By.xpath("//table[1]//tbody//tr[last()]//td"));

        sonSatirVerileri.stream().forEach(t-> System.out.print(t.getText() + " - "));

         */
//    5. Sütun baslıgını yazdırın
        WebElement besinciSutunBasligi = driver.findElement(By.xpath("//table[1]//thead//tr[1]//th[5]"));
        System.out.println(besinciSutunBasligi.getText());


//    Task 4 : 5. Sütun verilerini yazdırın
        List<WebElement> besinciSutun = driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));

        System.out.println("************* 5. Sutun *******************");
        besinciSutun.forEach(t-> System.out.println(t.getText() +" - "));


//    Task 5 : Iki parametreli bir Java metodu oluşturalım: printData
        printData(2,3);

        //    Parameter 1 = satır numarası
        //    Parameter 2 = sütun numarası
        //    printData(2,3);  => 2. satır, 3. sütundaki veriyi yazdırsın.
        printData(3,4);

    }

    public void printData(int satir, int sutun) {

        WebElement satirSutun = driver.findElement(By.xpath("//table[1]//tbody//tr["+satir+"]//td["+sutun+"]"));

        System.out.println(satirSutun.getText());

    }
}
