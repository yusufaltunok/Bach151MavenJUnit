package techproed.day13_Cookies_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C02_Actions extends TestBase {

    @Test
    public void test01() {
//        https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

//        Kutuya sag tıklayın
        WebElement kutu = driver.findElement(By.id("hot-spot"));
        // Sağ click yapabilmek için öncelikle Actions class'ından bir obje oluşturmalıyız.
        Actions actions = new Actions(driver);
        actions.contextClick(kutu). // Sağ click yapma metodu kullandık.
                     perform();// action objemizle yapacagimiz islemi uygulamasi icin veya sonlandirmasi icin perform() kullaniriz


//        Alert’te cikan yazinin“You selected a context menu”oldugunu test edin
        Assert.assertEquals("You selected a context menu",getTextAlert());
        // TestBase'deki getTextAlert() metodunu kullandık. --> driver.switchTo().alert().getText();

//        Tamam diyerek alert’i kapatın
        //driver.switchTo().alert().accept();
        acceptAlert(); // üstteki alert kapatmanın TestBase'deki metodu.










    }
}
