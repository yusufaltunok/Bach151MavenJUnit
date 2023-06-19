package techproed.day15_filesExist;

import org.junit.Assert;
import org.junit.Test;
import techproed.utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class C01_FilesExist {

    @Test
    public void test01() {

        /*
        Bir web sitesini test ettiğimizde download işlemi yapıldığı zaman dosyanın bilgisayarımıza inip inmediğini
    kontrol etmek varlığını doğrulamak için yada bilgisayarımızdaki herhangi bir dosyanın varlığını doğrulayabilmek
    için;
        Files class'ından exists() methodunu kullanarak parametre olarak Paths.get(dosyaYolu) methodunu kullanarak
    dosyanın varlığını test edebiliriz. --> Files.exists(Paths.get(dosyaYolu)
    Dolayısıyla bu işleme başlamadan önce varlığını test edeceğimiz dosyanın yolunu String bir değişkene
    assing ederiz.
 */
        String dosyaYolu = "C:/Users/EXCALIBUR/Desktop/ilovepdf_merged (12).pdf";
        System.out.println(Files.exists(Paths.get(dosyaYolu)));//-->Dosya varsa True yoksa False döner
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }

    @Test
    public void test02() {
        String dosyaYolu = "C:\\Users\\EXCALIBUR\\Desktop\\Bach-151\\day03.sql";
        System.out.println(Files.exists(Paths.get(dosyaYolu)));//-->Dosya varsa True yoksa False döner
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
    @Test
    public void test03() {
        /*
        Bir server da farklı işletim sistemleri ile aynı anda dosya varlığını test etmek istediğimiz zaman,
        daha dinamik olması açısından System.getProperty("os.name") bu şekilde işletim sistemibi alır.
        her işletim sisteminin kullanıcı yolu farklı olacağından System.getProperty("user.home") bilgisayarımızdaki
        kullanıcı yolunu bu şekilde alıp alıp String bir değişkene farklıYol ismiyle System.getPropertu("user.home")
        atayarak her seferinde farklı yolları almakla uğraşmamış oluruz.
        Dosya diyelimki masaüstünde ve her işletim sisteminde bize aynı yolu vereceği için bunu da ortakYol olarak bir String'e assign ederiz.
         */

        String isletimSistemiAdi = System.getProperty("os.name");// Windows 11 --> İşletim sistemimizin adını verir
        System.out.println(isletimSistemiAdi);

        String farkliYol ="";
        System.out.println(System.getProperty("user.home"));// C:\Users\EXCALIBUR --> Bilgisayarımızdaki kullanıcı yolunu verir

        if (isletimSistemiAdi.contains("Win")){
            farkliYol = System.getProperty("user.home");// C:\Users\EXCALIBUR

        } else if (isletimSistemiAdi.contains("mac")) {
            farkliYol = "/Users/aycapolatkamali  "; // --> Mac işletim sistemi yolu

        }
        String ortakYol = "/Desktop/ilovepdf_merged (12).pdf";
        String dosyaYolu = farkliYol + ortakYol;

        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        try {
            Files.delete(Paths.get(dosyaYolu));// --> Bu şekilde belirtmiş olduğumuz dosyayı sileriz.
        } catch (IOException e) {
            System.out.println("Dosya Bulunamadı");
        }
        Assert.assertFalse(Files.exists(Paths.get(dosyaYolu)));

        // Sildiğimiz dosya isminde yeni bir dosya oluşturalım
        try {
            Files.createFile(Paths.get(dosyaYolu));// --> Belirtmiş olduğumuz dosyayı oluşturduk
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        /*
        Test ettiğiniz sayfada her seferinde download işlemi yapılıyorsa gereksiz dosya kalabalığını önlemek için
         yukarıdaki delete işlemini kullanabiliriz.
         */

    }

    @Test
    public void test04() {
        /*
         Yukaridaki methodlarda bilgisayarimizdaki dosya yolunun varligini Files.exists() methodu ile test etmistik.
    Ayni islemi asagidaki ornekteki gibi File class'indan obje olusturarak da yapabiliriz
         */

        String dosyaYolu = "C:\\Users\\EXCALIBUR\\Desktop\\Yeni Metin Belgesi.txt";
         File file = new File(dosyaYolu);
       // new File(dosyaYolu).exists(); // Birden fazla kullanmayacaksak obje oluşturmadan bu şekilde kullanabiliriz.
        System.out.println(file.exists());
        Assert.assertTrue(file.exists());
        file.delete();


    }
}
