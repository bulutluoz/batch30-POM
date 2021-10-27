package tests.day17_ExcelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C01_ReadExcel {
    @Test (groups = "birinciGrup")
    public void test() throws IOException {

        // 7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/test/java/resources/ulkeler.xlsx";
        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fileInputStream=new FileInputStream(dosyaYolu);
        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        //10. WorkbookFactory.create(fileInputStream)

        //11. Worksheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet= workbook.getSheet("Sayfa1");
        //12. Row objesi olusturun sheet.getRow(index)
        Row row= sheet.getRow(4);
        //13. Cell objesi olusturun row.getCell(index)
        Cell cell= row.getCell(1);

        System.out.println(cell);
    }

    @Test
    public void test2() throws IOException {
        // 7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/test/java/resources/ulkeler.xlsx";
        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fileInputStream=new FileInputStream(dosyaYolu);
        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        //10. WorkbookFactory.create(fileInputStream)

        //11. Worksheet objesi olusturun workbook.getSheetAt(index)

        //12. Row objesi olusturun sheet.getRow(index)

        //13. Cell objesi olusturun row.getCell(index)
        Cell cell= workbook.getSheet("Sayfa1").getRow(5).getCell(3);

        System.out.println(cell);

        // secilen hucredeki yazinin Luanda oldugunu test edin

        // Assert.assertEquals(cell,"Luanda");
        // cell'in data turu Cell, "Luanda" ise String
        // data turleri farkli oldugu icin bu ikisi equal olamaz
        // Cell data turu yazdirilabilir ancak String method'lari ile kullanilamaz
        // String manipulation yapmak icin Cell data turunu String'e Cast yapmaliyiz
        Assert.assertEquals(cell.toString(),"Luanda");
        Assert.assertEquals(cell.getStringCellValue(),"Luanda");

        // index'i 3 olan satirdaki index'i 2 olan hucredeki yaziyi buyuk harfle yazdirin
        Cell cell1=workbook.getSheet("Sayfa1").getRow(3).getCell(2);
        System.out.println(cell1.toString().toUpperCase());

        // getLastRowNum() bize son satirin index'ini verir
        // getPhysicalNumberOfRows() ise fiili olarak kullanilan satir sayisini verir
        System.out.println(workbook.getSheet("Sayfa1").getLastRowNum()); //190
        System.out.println(workbook.getSheet("Sayfa1").getPhysicalNumberOfRows()); //191
        System.out.println(workbook.getSheet("Sayfa1").getFirstRowNum());//0

        System.out.println(workbook.getSheet("Sayfa2").getLastRowNum()); // 16
        System.out.println(workbook.getSheet("Sayfa2").getPhysicalNumberOfRows()); // 5
        System.out.println(workbook.getSheet("Sayfa2").getFirstRowNum()); // 1

        System.out.println(workbook.getSheet("Sheet1").getLastRowNum()); // -1
        System.out.println(workbook.getSheet("Sheet1").getPhysicalNumberOfRows()); // 0
        System.out.println(workbook.getSheet("Sheet1").getFirstRowNum()); // -1

    }

    @Test
    public void test3() throws IOException {
        // tablodaki 2.sutunu bir liste olarak yazdirin
        List<String> ikinciSutun=new ArrayList<>();
        String dosyaYolu="src/test/java/resources/ulkeler.xlsx";
        FileInputStream fileInputStream=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fileInputStream);

        for (int i=0; i<=workbook.getSheet("Sayfa1").getLastRowNum(); i++){
          ikinciSutun.add(workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString());
        }

        System.out.println(ikinciSutun);

        // A ile baslayan sehirleri liste yapip yazdirin
        List<String> aIleBaslayanSehirler=new ArrayList<>();

        for (String each: ikinciSutun
             ) {
            if (each.startsWith("A")){
                aIleBaslayanSehirler.add(each);
            }
        }
        System.out.println(aIleBaslayanSehirler);

        // eger tum datayi java'da kullanilabilir bir collection'a cevirmek istesek
        // en uygun yapi map olur
        // map icin unique degerlere sahip bir sutunu key
        // geriye kalan tum sutunlari ise virgulle ayrilan string'ler olarak value yapmaliyiz
        // key=Turkey value=Ankara, Turkiye, Ankara

        Map<String,String> ulkelerMap=new HashMap<>();
        String key="";
        String value="";
        for (int i=0; i<=workbook.getSheet("Sayfa1").getLastRowNum(); i++){

            key=workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            value= workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString() + ", "+
                    workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString() + ", "+
                    workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            ulkelerMap.put(key,value);
        }

        System.out.println(ulkelerMap);

        // Biz java method'larini ve collections'i kullanarak excel'deki datalari
        // manipule edebilecegimiz Java ortamina alabiliriz
    }
}
