package techproed.day08_BeforeClassAfterClass_Assertion;

import org.junit.*;

public class C01_BeforeClassAfterClass {

    /*
        @BeforeClass ve @AfterClass methodlari static olmak zorundadir
     */

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Her classdan önce BeforeClass Metodu bir kez çalışır");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Her classdan sonra AfterClass Metodu bir kez çalışır");

    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Her test methodundan önce bir kez before (setUp) metodu çalışır");

    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Her test methodundan sonra bir kez after (tearDown) metodu çalışır");

    }

    @Test
    public void test01() {
        System.out.println("Test01 Metodu çalıştı.");
    }

    @Test
    public void test02() {
        System.out.println("Test02 Metodu çalıştı.");

    }

    @Test
    public void test03() {
        System.out.println("Test03 Metodu çalıştı.");

    }
}
