//package default package;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {
	
	public static void main(String[] args) throws IOException {
		getData("r1");
	}

	public static ArrayList<String> getData(String testcaseName) throws IOException {
		ArrayList<String> list = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("D:\\demodata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int numberOfSheets = workbook.getNumberOfSheets();
		for (int i = 0; i < numberOfSheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("data")) {
				XSSFSheet sheet = workbook.getSheetAt(i);

				Iterator<Row> rows = sheet.rowIterator();
				Row firstRow = rows.next();
				Iterator<Cell> ce = firstRow.cellIterator();
				int k = 0;
				int column = 0;
				while (ce.hasNext()) {
					Cell val = ce.next();
					if (val.getStringCellValue().equalsIgnoreCase("testcases")) {
						column = k;
					}
					k++;
				}
				System.out.println(column);

				// now the column is identified. Lets find "r1" testcase in this column, and get
				// its data

				while (rows.hasNext()) {
					Row r = rows.next();
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName)) {
						Iterator<Cell> cellIterator = r.cellIterator();
						while (cellIterator.hasNext()) {
							String a = cellIterator.next().getStringCellValue();
							System.out.println(a);
							list.add(a);
						}
					}
				}

			}
		}
		
		return list;

	}

}