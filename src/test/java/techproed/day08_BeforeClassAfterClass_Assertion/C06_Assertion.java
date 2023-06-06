package techproed.day08_BeforeClassAfterClass_Assertion;

import org.junit.Assert;
import org.junit.Test;

public class C06_Assertion {
    /*
    Assertion'larda eşitlik için expected,actual olarak kullanılır.
     */

    @Test
    public void test01() {
        Assert.assertEquals(2,2);
        System.out.println("Test başarılı bir şekilde çalıştı");
    }
    @Test
    public void test02() {
        Assert.assertEquals(3,2);
        System.out.println("Test başarılı bir şekilde çalıştı");
    }
    @Test
    public void test03() {
        Assert.assertNotEquals(5,4);
        System.out.println("Test başarılı bir şekilde çalıştı");
    }
    @Test
    public void test04() {
        String actualName = "yusuf";
        String expectedName = "Yusuf";
        System.out.println("Test başarılı bir şekilde çalıştı");
        System.out.println("Test başarılı bir şekilde çalıştı");
        System.out.println("Test başarılı bir şekilde çalıştı");
        System.out.println("Test başarılı bir şekilde çalıştı");
        System.out.println("Test başarılı bir şekilde çalıştı");
        System.out.println("Test başarılı bir şekilde çalıştı");
        System.out.println("Test başarılı bir şekilde çalıştı");
        Assert.assertEquals(expectedName,actualName);
        System.out.println("Test başarılı bir şekilde çalıştı");
        System.out.println("Test başarılı bir şekilde çalıştı");
        System.out.println("Test başarılı bir şekilde çalıştı");
        System.out.println("Test başarılı bir şekilde çalıştı");
        System.out.println("Test başarılı bir şekilde çalıştı");
        System.out.println("Test başarılı bir şekilde çalıştı");
    }
    @Test
    public void test05() {
        int yas = 46;
        int emeklilikYas = 56;
        Assert.assertTrue(emeklilikYas<yas);
        System.out.println("Test başarılı bir şekilde çalıştı");
    }
    @Test
    public void test06() {
        int yas = 46;
        int emeklilikYas = 56;
        Assert.assertTrue(emeklilikYas>yas);
        System.out.println("Test başarılı bir şekilde çalıştı");
    }
    @Test
    public void test07() {
        int yas = 46;
        int emeklilikYas = 56;
        Assert.assertFalse(emeklilikYas<yas);
        System.out.println("Test başarılı bir şekilde çalıştı");
    }

}
