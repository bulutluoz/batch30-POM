package tests.day16_WebTables;

import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.Driver;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

public class C02_WebTable {
    @Test
    public void test() throws InterruptedException {
        //Bir class oluşturun : C02_WebTables
        //● login() metodun oluşturun ve oturum açın.
        //● https://www.concorthotel.com//admin/HotelRoomAdmin adresine gidin
        //			○ Username : manager
        //			○ Password : Manager1!
        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.ConcortHotelLogin();
        qaConcortPage.hotelManagementLinki.click();
        qaConcortPage.hotelRoomsLinki.click();
        //● table() metodu oluşturun
        //			○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody


        System.out.println("Tablodaki sutun sayisi : "+qaConcortPage.basliklarListesi.size());
        //			○ Table’daki tum body’i ve başlıkları(headers) konsolda yazdırın.
        // Eger tum tablo body'sini hucrelere ayirmadan tek bir String olarak gormek istersek
        // tum body'i tek bir Webelement olarak locate edebiliriz
        // Bu yklasim, tabloda HAPPY HOTEL var mi gibi sorular icin ideal bir cozum olur
        System.out.println(qaConcortPage.tBodyTumu.getText());
        Thread.sleep(1000);
        Assert.assertTrue(qaConcortPage.tBodyTumu.getText().contains("HAPPY HOTEL"));

        for (WebElement each: qaConcortPage.basliklarListesi
        ) {
            System.out.println(each.getText());
        }

        //● printRows() metodu oluşturun //tr
        //			○ table body’sinde bulunan toplam satir(row) sayısını bulun.

        System.out.println("tablodaki satir sayisi : "+qaConcortPage.satirlarListesi.size());
        //			○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        System.out.println(qaConcortPage.birinciSatir.getText());

        // eger tum satirlari yazdirmak istersek
        for (int i=0;i<qaConcortPage.satirlarListesi.size();i++){
            System.out.println( i+1 +". satir : " + qaConcortPage.satirlarListesi.get(i).getText());
        }
        //			○ 4.satirdaki(row) elementleri konsolda yazdırın.
        for (WebElement each:qaConcortPage.dorduncuSutunListesi
             ) {
            System.out.println(each.getText());
        }


        Driver.closeDriver();
    }
}
