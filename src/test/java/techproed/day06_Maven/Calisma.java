package techproed.day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Calisma {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


//         1.) Bir class oluşturun : Locators_css
//         2.) Main method oluşturun ve aşağıdaki görevi tamamlayın.
//         a. Verilen web sayfasına gidin. "https://www.heroku.com/home"
//        driver.get("https://www.heroku.com/home");
//        driver.findElement(By.cssSelector("a[href='https://id.heroku.com']")).click();

//         b.Locate email textbox
//        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("testtechproed@gmail.com", Keys.TAB,"Test1234!",Keys.TAB,Keys.ENTER);

//         c. Locate password textbox ve

//         d.Locate signin button
//        e. Asagidaki kullanıcı adını ve şifreyi girin ve sign in düğmesini tıklayın
//        i. Username : testtechproed@gmail.com
//        ii.Password : Test1234!
// NOT: cssSelector kullanarak elementleri locate ediniz (


//        1. Tarayıcıyı başlatın
//        2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

//        3. Ana sayfanın başarıyla göründüğünü doğrulayın
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains("https://automationexercise.com/login")){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

//        4. 'Kaydol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.cssSelector("[href='/login']")).click();

//        5. "Hesabınıza giriş yapın"ın göründüğünü doğrulayın
        WebElement hesabaGirisGorunuyorMu = driver.findElement(By.xpath("(//h2)[1]"));
        System.out.println("hesabaGirisGorunuyorMu = " + hesabaGirisGorunuyorMu.isDisplayed());

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://automationexercise.com/";
        if (actualURL.equals(expectedURL)) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED " + actualURL);
        }

        //Click on 'Signup / Login' button
        driver.findElement(By.cssSelector("a[href='/login']")).click();

        //Verify 'Login to your account' is visible
        boolean b1 = driver.findElement(By.xpath("(//h2)[1]")).isDisplayed();
        System.out.println(b1);

        //Enter correct email address and password

        driver.findElement(By.cssSelector("input[data-qa='login-email']")).
                sendKeys("bahadirgunuvar223@gmail.com", Keys.TAB, "Bg5128518", Keys.TAB, Keys.ENTER);

        //Verify that 'Logged in as username' is visible
        System.out.println(driver.findElement(By.xpath("//*[text()=' Logged in as ']")).isDisplayed());

        //Click 'Delete Account' button
        driver.findElement(By.cssSelector("a[href='/delete_account']")).click();

        //Verify that 'ACCOUNT DELETED!' is visible
        System.out.println(driver.findElement(By.cssSelector("h2[class='title text-center']")).isDisplayed());

    }
}
