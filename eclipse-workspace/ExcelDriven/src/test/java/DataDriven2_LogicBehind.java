//package default package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven2_LogicBehind {

	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static FileInputStream fis;
	public static void main(String[] args) throws IOException {
		
		String value5 = getCelldata(1, 1);
		System.out.println("(1,1): " + value5);
		String value6 = getCelldata(1, 2);
		System.out.println("(1,2): " + value6);
		String value7 = getCelldata(1, 3);
		System.out.println("(1,3): " + value7);
		
		
		String value = getCelldata(2, 2);
		System.out.println(value);
		String value1 = getCelldata(1, 2);
		System.out.println(value1);
		String value3 = setCelldata("automation", 2, 2);
		value = getCelldata(2, 2);
		System.out.println(value);
		System.out.println(value3);
	}

	private static String setCellvalue(int i, int j) {
		return null;
	}

	public static String getCelldata(int rownum, int col) throws IOException{

		fis = new FileInputStream("D:\\demodata.xlsx");
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet("data");
		row = sheet.getRow(rownum);
		cell = row.getCell(col);
		return cell.getStringCellValue();
	}

	public static String setCelldata(String text, int rownum, int col) throws IOException{
		fis = new FileInputStream("D:\\demodata.xlsx");
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet("data");
		row = sheet.getRow(rownum);
		cell = row.getCell(col);
		cell.setCellValue(text);
		String celldata1 = cell.getStringCellValue();
		return celldata1;
	}
}