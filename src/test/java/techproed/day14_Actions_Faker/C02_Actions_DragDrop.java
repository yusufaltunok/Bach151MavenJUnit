package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C02_Actions_DragDrop extends TestBase {
    @Test
    public void test01() {
//  Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

//  And user moves the target element(Drag me to my target) in to  destination(Drop here
//  "Drag me to my target" webelementini "Drop here" webelementi üzerine bırakalım
        // drag ve drop webelementleri iframe icinde oldugu icin iframe'e gecis yapmaliyiz
        driver.switchTo().frame(0);
        WebElement drag =driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop =driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag, drop).perform();

            /*
            Eğer bir hareketli webelementi tutup başka bir webelementin üzerene bırakmak istersek
         sürüklemek istediğimiz we'tin locatini alıp üzerine bırakacağımız we'tin locate'ini de alarak
         dragAndDrop(kaynak,hedef) methodu ile işlemi gerçekleştirebiliriz
         */

    }

    @Test
    public void test02() {
        //  Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

//  And user moves the target element(Drag me to my target) in to  destination(Drop here
//  "Drag me to my target" webelementini "Drop here" webelementi üzerine bırakalım
        // drag ve drop webelementleri iframe icinde oldugu icin iframe'e gecis yapmaliyiz
        driver.switchTo().frame(0);
        WebElement drag =driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop =driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).//-->Bu method ile webelemente mouse ile basılı tuttuk
                moveToElement(drop).//-->Bu method ile basılı tuttuğumuz we'ti diğer we'tin üzerine götürdük
                release().//-->Bu method ile basılı tuttuğumuz we'ti serbest bıraktık
                perform();//--> işlemi sonlandırdık

    }

    @Test
    public void test03() {
        //  Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

//  And user moves the target element(Drag me to my target) in to  destination(Drop here
//  "Drag me to my target" webelementini "Drop here" webelementi üzerine koordinat kullanarak bırakalım
        // drag ve drop webelementleri iframe icinde oldugu icin iframe'e gecis yapmaliyiz
        driver.switchTo().frame(0);
        WebElement drag =driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop =driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).
                moveByOffset(150,28).  // --> Belirtmiş olduğumuz koordinatlara webelementi taşır.
                release().
                perform();

    }
}
