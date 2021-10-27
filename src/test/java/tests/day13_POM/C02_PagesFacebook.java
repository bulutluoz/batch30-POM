package tests.day13_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.TestBase;

public class C02_PagesFacebook extends TestBase {

    @Test
    public void test(){
        // facebook login sayfasina gidin
        driver.get("https://www.facebook.com");
        FacebookPage facebookPage=new FacebookPage(driver);
        // page sayfasinda cookiesGec() method'u olusturun
        facebookPage.cookiesgec();
        // kullanici adi : techproed@hotmail.com
        facebookPage.mailKutusu.sendKeys("techproed@hotmail.com");
        // sifre : 12345
        facebookPage.sifreKutusu.sendKeys("12345");
        facebookPage.loginTusu.click();
        // yazdigimizda giris yapamadigimizi test edin
        Assert.assertTrue(facebookPage.girilemediYaziElementi.isDisplayed());

}


}
