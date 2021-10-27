package tests.day14_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class C03_PositiveTestConfigReaderIle extends TestBase {

    @Test
    public void positiveTestConfig(){
    //https://www.concorthotel.com/ adresine git
        driver.get(ConfigReader.getProperty("CHUrl"));

        ConcortHotelPage concortHotelPage=new ConcortHotelPage(driver);

    //		login butonuna bas
        concortHotelPage.ilkLoginLinki.click();
    //	test data username: manager ,
        concortHotelPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHValidUsername"));
    //	test data password : Manager1!
        concortHotelPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHValidPassword"));
        concortHotelPage.loginButonu.click();
    //	Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(concortHotelPage.basariliGirisYaziElementi.isDisplayed());
}
}
