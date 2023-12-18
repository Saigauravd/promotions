package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WrtingValuesInExcel {

	
	public static void main(String[] args) throws IOException {
		 String path = System.getProperty("user.dir")+".//Excel.xlsx";
		 File file = new File(path);
		 FileInputStream fis = new FileInputStream(file);
		 XSSFWorkbook book = new XSSFWorkbook(fis);
		 XSSFSheet sheet = book.getSheet("Coupons");
	//	 DataFormatter df = new DataFormatter();
		
		 String GName ="Coupon with Gift and Custom Code";
		 String GDesc ="Description for gift";
		 String DaName = "Disc Amt With Adv Setting";
		 String DaDesc = "Description for Discount amount ";
		 String DaNamew = "Coupon with Disc without adv ";
		 String DaDescw = "Description for Discount without setting";
		 String DpName = "Disc pert With Adv Setting";
		 String DpDesc = "Description percentage with setting";
		 String DuName = "Disc unit With Adv Setting";
		 String DuDesc = " Discription for Discount unit with setting";
		 String DuNamew = "Disc  unit Without Adv Setting";
		 String DuDescw = "Discription for Discount unit without setting";
		 String DoName = "Disc  other Without Adv Setting";
		 String DoDesc = "Description for unit other with setting";
		 String GNamew ="Coupon with Gift and systemGenerated code";
		 String GDescw ="Description for gift with out Setting";
		 String DpNamew = "Disc pert Without Adv Setting";
		 String DpDescw = "Description percentage without setting";
		 
		 
		 File fout = new File(path); 
		 FileOutputStream fos = new FileOutputStream(fout);
		 
		 sheet.getRow(1).getCell(0).setCellValue(GName);
		 sheet.getRow(1).getCell(1).setCellValue(GDesc);
		 sheet.getRow(3).getCell(0).setCellValue(DaName);
		 sheet.getRow(3).getCell(1).setCellValue(DaDesc);
		 sheet.getRow(4).getCell(0).setCellValue(DaNamew);
		 sheet.getRow(4).getCell(1).setCellValue(DaDescw);
		 sheet.getRow(5).getCell(0).setCellValue(DpName);
		 sheet.getRow(5).getCell(1).setCellValue(DpDesc);
		 sheet.getRow(7).getCell(0).setCellValue(DuName);
		 sheet.getRow(7).getCell(1).setCellValue(DuDesc);
		 sheet.getRow(8).getCell(0).setCellValue(DuNamew);
		 sheet.getRow(8).getCell(1).setCellValue(DuDescw);
		 sheet.getRow(9).getCell(0).setCellValue(DoName);
		 sheet.getRow(9).getCell(1).setCellValue(DoDesc);
		 sheet.getRow(2).getCell(0).setCellValue(GNamew);
		 sheet.getRow(2).getCell(1).setCellValue(GDescw);
		 sheet.getRow(6).getCell(0).setCellValue(DpNamew);
		 sheet.getRow(6).getCell(1).setCellValue(DpDescw);
		 book.write(fos);
	}
}
