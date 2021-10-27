package tests.day14_POM;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class C04_AmazonConfigReader extends TestBase {

    @Test
    public void test(){
        // amazon sayfasina gidip
        driver.get(ConfigReader.getProperty("amazonUrl"));

        AmazonPage amazonPage=new AmazonPage(driver);

        // nutella icin arama yapin
        amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonArananKelime")+ Keys.ENTER);
        // sonuc sayisini yazdirin ve sonuc yazisinin nutella icerdigini test edin
        System.out.println(amazonPage.sonucYazisiElementi.getText());

        Assert.
                assertTrue(amazonPage.sonucYazisiElementi.getText().
                contains(ConfigReader.getProperty("amazonArananKelime")));
    }
}
