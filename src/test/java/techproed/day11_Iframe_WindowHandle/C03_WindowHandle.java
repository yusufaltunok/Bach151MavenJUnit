package techproed.day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import techproed.utilities.TestBase;

public class C03_WindowHandle extends TestBase {
    @Test
    public void windowHandle() {
        /*
        Eger sayfaya gittikten sonra yeni sekme yada yeni bir pencereyle baska sayfaya gider, sonra
        tekrar ilk actiginiz sayfaya dçnmek isterseniz, ilk sayfaya driver.get() methoduyla gittikten sonra
        String bir degiskene handle degerini assign ederseniz tekrar ilk acilan sayfaya donmek istediginizde
        driver.switchTo().window(ilksayfaHandleDegeri) ile gecis yapabilirsiniz
         */
    //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproHandle = driver.getWindowHandle();


    //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        String actualTitle = driver.getTitle();
        String expectedTitle = "Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(actualTitle, expectedTitle);

    //Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);// --> driver'ı yeni bir pencereye taşır.
        // WindowType.TAB -->Yeni bir sekme açar.
        driver.get("https://www.youtube.com");
        String youtubeHandle = driver.getWindowHandle();

    //Window 3'te (yeni bir pencerede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String linkedinHandle = driver.getWindowHandle();

    //techproeducation sayfasına geçiniz:
        driver.switchTo().window(techproHandle);
        bekle(2);

    //youtube sayfasına geçiniz:
        driver.switchTo().window(youtubeHandle);
        bekle(2);

    //linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinHandle);
        bekle(2);

    }
    @Test
    public void windowHandleTab() {
        /*
        Eger sayfaya gittikten sonra yeni sekme yada yeni bir pencereyle baska sayfaya gider, sonra
        tekrar ilk actiginiz sayfaya dçnmek isterseniz, ilk sayfaya driver.get() methoduyla gittikten sonra
        String bir degiskene handle degerini assign ederseniz tekrar ilk acilan sayfaya donmek istediginizde
        driver.switchTo().window(ilksayfaHandleDegeri) ile gecis yapabilirsiniz
         */
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproHandle = driver.getWindowHandle();


        //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        String actualTitle = driver.getTitle();
        String expectedTitle = "Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(actualTitle, expectedTitle);

        //Window 2'de (yeni bir sekmede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);// --> driver'ı yeni bir pencereye taşır.
        // WindowType.TAB -->Yeni bir sekme açar.
        driver.get("https://www.youtube.com");
        String youtubeHandle = driver.getWindowHandle();

        //Window 3'te (yeni bir sekmede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");
        String linkedinHandle = driver.getWindowHandle();

        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(techproHandle);
        bekle(2);

        //youtube sayfasına geçiniz:
        driver.switchTo().window(youtubeHandle);
        bekle(2);

        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinHandle);
        bekle(2);

    }

}
