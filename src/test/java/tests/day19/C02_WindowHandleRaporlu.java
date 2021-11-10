package tests.day19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C02_WindowHandleRaporlu extends TestBaseRapor {
    @Test
    public void test(){
        extentTest=extentReports.createTest("window handle test","yeni sayfada new window yazisini test eder");
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        extentTest.info("istenen adrese gidildi");

        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        extentTest.info("linke tiklandi");

        ReusableMethods.switchToWindow("New Window");
        extentTest.info("yeni sayfaya gecildi");
        WebElement newWindowYaziElementi=Driver.getDriver().findElement(By.tagName("h3"));
        extentTest.info("test edecegimiz yazi locate edildi");
        Assert.assertTrue(newWindowYaziElementi.isDisplayed());
        extentTest.pass("yazinin gorunur oldugu test edildi");


    }
}
