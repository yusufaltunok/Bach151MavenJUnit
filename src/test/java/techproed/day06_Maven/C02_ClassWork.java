package techproed.day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_ClassWork {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//        1.http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

//        2.Signin buttonuna tiklayin
        driver.findElement(By.cssSelector("button[id='signin_button']")).click();

//        3.Login alanine “username” yazdirin
        driver.findElement(By.id("user_login")).sendKeys("username",Keys.TAB,"password");

//        4.Password alanine “password” yazdirin
        //driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("password");

//        5.Sign in buttonuna tiklayin
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        driver.navigate().back();

//        6.Online Banking altında Pay Bills sayfasina gidin
        driver.findElement(By.id("[id='pay_bills_link']")).click();
        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();
        driver.findElement(By.xpath("//*[text()='Pay Bills']")).click();
        Thread.sleep(3000);

//        7.amount kismina yatirmak istediginiz herhangi bir miktari yazin
//        8.tarih kismina “2020-09-10” yazdirin
        WebElement amount = driver.findElement(By.xpath("//*[@id='sp_amount']"));
        amount.sendKeys("666", Keys.TAB, "2020-09-10" );
        Thread.sleep(3000);

//        9.Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();
        Thread.sleep(3000);


//        10.“The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement successfully = driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']"));
        String basariliYazisi = successfully.getText();
        if (basariliYazisi.equals("The payment was successfully submitted.")) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");
        }

        driver.close();




    }
}
