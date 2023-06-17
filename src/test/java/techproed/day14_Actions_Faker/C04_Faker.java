package techproed.day14_Actions_Faker;

import com.github.javafaker.Faker;
import org.junit.Test;
import techproed.utilities.TestBase;

public class C04_Faker {
    @Test
    public void faker() {
         /*
        Faker class'indan sahte verileri kullanabilmek icin obje olusturmamiz gerekir
         */

        Faker faker = new Faker();
        // faker objesini kullanarak bir name yazdıralım.
        System.out.println("İsim : " + faker.name().firstName());

        // faker objesini kullanarak bir lastName yazdıralım.
        System.out.println("Soyisim : " +faker.name().lastName());

        // faker objesini kullanarak bir fullName yazdıralım.
        System.out.println("İsim_Soyisim : " +faker.name().fullName());

        // faker objesini kullanarak bir adress yazdıralım.
        System.out.println("Adress : " + faker.address().fullAddress());


        // faker objesini kullanarak bir tel_no yazdıralım.
        System.out.println("Telefon Numarası :" + faker.phoneNumber().phoneNumber());
        System.out.println("Cep Telefon Numarası :" + faker.phoneNumber().cellPhone());

        //Rastgele 15 haneli bir numara yazdıralım
        System.out.println("Rastgele 15 haneli bir numara : "+faker.number().digits(15));

        // Meslek Pozisyonu
        System.out.println(faker.job().position());


    }
}
