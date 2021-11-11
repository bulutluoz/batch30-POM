package tests.day25;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class DataProviderIleTest {


    @DataProvider
    public static Object[] aranacakKelimeListesi() {
        String arr[]={"Nutella", "Iphone", "Samsung"};
        return arr;
    }



    @Test(dataProvider = "aranacakKelimeListesi")
    public void test(String aranacak){
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // parametre olarak girilen deger icin arama yapin
        Driver.getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys(aranacak+Keys.ENTER);

        // sonuc sayisini yazdirin ve sonuc yazisinin aradigimiz parametre degerini icerdigini test edin
        WebElement sonucYazisiElementi=Driver.getDriver().findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYazisiElementi.getText());

        Assert.assertTrue(sonucYazisiElementi.getText().contains(aranacak));
    }




}
