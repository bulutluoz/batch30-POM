package tests.day14_POM;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class C05_NegativeTestConfigReader extends TestBase {
    @Test
    public void test(){
        //https://www.concorthotel.com/ adresine git
        driver.get(ConfigReader.getProperty("CHUrl"));

        ConcortHotelPage concortHotelPage=new ConcortHotelPage(driver);
        //	login butonuna bas
        concortHotelPage.ilkLoginLinki.click();
        //	test data username: manager1 ,
        concortHotelPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHInvalidUsername"));
        //	test data password : manager1!
        concortHotelPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHInvalidPassword")+ Keys.ENTER);

        //	Degerleri girildiginde sayfaya girilemedigini test et

        Assert.assertTrue(concortHotelPage.loginFailedYazisi.isDisplayed());
    }
}
