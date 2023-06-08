package techproed.day09_DropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C03_Dropdown {

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void test01() {
        // programming languages ddm den istediğiniz 4 seçeneği seçiniz.
        WebElement diller = driver.findElement(By.xpath("(//select)[6]"));
        Select select = new Select(diller);
        select.selectByIndex(0);
        select.selectByIndex(2);
        select.selectByIndex(3);
        select.selectByIndex(4);
        // Eğer saddece seçili olan seçenekleri yazdırmak istersek
        // Lambda ile
        select.getAllSelectedOptions().forEach(w-> System.out.println(w.getText()));

        System.out.println("*****************************************************");

        // for each ile
        for (WebElement w:select.getAllSelectedOptions()) {
            System.out.println(w.getText());
        }
        //Seçeneklerden 4 tane seçtiğimizi doğrulayalım
        Assert.assertEquals(4,select.getAllSelectedOptions().size());

        System.out.println("*****************************************************");

        // Seçtiğimiz seçeneklerden ilkini yazdıralım, ilk seçeneğin Java olduğunu doğrulayalım.
        System.out.println("Seçilen seçeneklerden ilki : "+select.getFirstSelectedOption().getText());
        Assert.assertEquals("Java",select.getFirstSelectedOption().getText());
        bekle(3);

        // Seçtiğimiz seçeneklerin hepsini kaldırmak için;
        select.deselectAll();

        // sendKeys() metodu ile istediğimiz bir seçeneği gönderelim.
        diller.sendKeys("C#");
        //select.selectByIndex(2);

        // visibleText olarak seçim yapacağımız bir method olşturup programming languages ddm den bir seçenek seçelim.
        selectVisibleText(diller,"Java");
        bekle(2);

        // index olarak seçim yapacağımız bir method olşturup programming languages ddm den bir seçenek seçelim.
        selectIndex(diller,3);
        bekle(2);

        // value olarak seçim yapacağımız bir method olşturup programming languages ddm den bir seçenek seçelim.
        selectValue(diller,"js");
    }

    @After
    public void tearDown() throws Exception {
        bekle(3);
        driver.close();
    }

    public void selectVisibleText(WebElement ddm, String text){
        Select select = new Select(ddm);
        select.selectByVisibleText(text);
    }
    public void selectIndex(WebElement ddm,int index){
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }
    public void selectValue(WebElement ddm,String value){
        Select select = new Select(ddm);
        select.selectByValue(value);
    }
    public void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
