package tests.day13_POM;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.TestBase;

public class C03_Pages extends TestBase {
    @Test
    public void test(){
        // amazon sayfasina gidin
        driver.get("https://www.amazon.com");
        // dropdown menuden book kategorisini secin
        AmazonPage amazonPage=new AmazonPage(driver);
        Select select=new Select(amazonPage.dropdownMenu);
        select.selectByVisibleText("Books");


        // java icin arama yapin
        amazonPage.aramaKutusu.sendKeys("java"+ Keys.ENTER);
        // bulunan sonuc sayisini yazin
        System.out.println(amazonPage.sonucYazisiElementi.getText());
        // ilk urunun isminde Java gectigini test edin
        Assert.assertTrue(amazonPage.ilkUrunIsim.getText().contains("Java"));


    }
}
