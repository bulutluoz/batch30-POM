package tests.day17;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.Driver;

public class C01_WebTables {
    @Test
    public void test(){
        //Bir class oluşturun : C02_WebTables
        //● login() metodun oluşturun ve oturum açın.
        //● https://www.concorthotel.com//admin/HotelRoomAdmin adresine gidin
        //			○ Username : manager
        //			○ Password : Manager1!
        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.ConcortHotelLogin();
        qaConcortPage.hotelManagementLinki.click();
        qaConcortPage.hotelRoomsLinki.click();

        // 1. pages sayfasinda bir metod oluşturun : printData(int row, int column);
        //	 Satır(row) ve sütun(column) numarasını girdiğinizde, printData metodu bu
        //	hücredeki(cell) veriyi yazdırmalıdır.
        String actualData= qaConcortPage.printData(3, 5);

        //	2. Ve bu metodu printData() methodunu cagirmak icin kullanin.
        //	   Örnek: printData (3,5); => 3. satır, 5. Sütundaki veriyi yazdırmalıdır

        //	3. yazdirilan datanin olmasi gereken dataya (USA) esit oldugunu test edin
        // assert'u bu class'da yapmak istiyorsak istenen datanin bu class'a donmesini saglamaliyiz
        Assert.assertEquals(actualData,"USA","yazilan data istenenden farkli");

        Driver.closeDriver();
    }
}
