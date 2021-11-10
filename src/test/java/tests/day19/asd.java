package tests.day19;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import java.util.Date;

public class asd {
    @Test
    public void test(){
        Faker faker=new Faker();
        Date tarih=new Date();
        tarih.setTime(20211201);
        System.out.println(tarih.toString());
    }
}
