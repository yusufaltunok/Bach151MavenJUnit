package techproed.day10_TestBase_Alert;

import org.junit.Assert;
import org.junit.Test;
import techproed.utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {
    //Techproeducation sayfasına gidelim
    //Başlığın Bootcamp içerdiğini test edelim

    @Test
    public void test01() {
        //Techproeducation sayfasına gidelim
        driver.get("https://www.techproeducation.com");

        //3 sn bekle
        bekle(3);

        //Başlığın Bootcamp içerdiğini test edelim
        String actualTitle = driver.getTitle();
        String expectedTitle = "Bootcamp";
        Assert.assertTrue(actualTitle.contains(expectedTitle));



    }
}
