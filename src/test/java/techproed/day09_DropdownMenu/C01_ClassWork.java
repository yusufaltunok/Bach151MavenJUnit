package techproed.day09_DropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ClassWork {

//Before kullanmadan tek browserda açmak için aşağıdaki şekilde yapılabilir.
    /*
    1)https://amazon.com adresine gidin
    2)Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleriyapin
    ○ title Test  => Sayfa başlığının “Amazon” kelimesini içerip içermediğini test edin
    ○ image Test => Amazon resminin görüntülendiğini (isDisplayed()) test edin
    ○ Search Box 'in erisilebilir oldugunu test edin(isEnabled())
    ○ wrongTitleTest => Sayfa basliginin “amazon” içermediğini doğrulayın
*/

    static WebDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }
    @Test
    public void titleTest() {
        //Sayfa başlığının “Amazon” kelimesini içerip içermediğini test edin
        String actualTitle = driver.getTitle();
        String exceptedlTitle = "Amazon";
        Assert.assertTrue(actualTitle.contains(exceptedlTitle));
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

    }
    @Test
    public void imageTest() {
        //Amazon resminin görüntülendiğini (isDisplayed()) test edin
        WebElement image = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(image.isDisplayed());
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("samsung", Keys.ENTER);

    }
    @Test
    public void searchBoxTest() {
        //Search Box 'in erisilebilir oldugunu test edin(isEnabled())
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(searchBox.isEnabled());
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("huawei", Keys.ENTER);

    }
    @Test
    public void wrongTitleTest() {
        //Sayfa basliginin “amazon” içermediğini doğrulayın
        String actualTitle = driver.getTitle();
        String exceptedlTitle = "amazon";
        Assert.assertFalse(actualTitle.contains(exceptedlTitle));
    }
    @AfterClass
    public static void tearDown() throws Exception {
        driver.close();
    }




}
