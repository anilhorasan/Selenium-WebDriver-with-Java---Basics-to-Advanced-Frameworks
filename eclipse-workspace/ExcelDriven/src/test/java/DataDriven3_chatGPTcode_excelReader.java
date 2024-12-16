import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class DataDriven3_chatGPTcode_excelReader {
    public static Object[][] getExcelData(String filePath, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);
        
        DataFormatter formatter = new DataFormatter();

        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells(); 
        // getLastRowNum()	            Index of the last row (zero-based)		i <= rowCount
        // getPhysicalNumberOfRows()	Total number of rows (1-based count)	i < rowCount

        Object[][] data = new Object[rowCount - 1][colCount];

        for (int i = 1; i < rowCount; i++) { // Skipping header row
            Row row = sheet.getRow(i);
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = row.getCell(j+1).toString();
                // alternatively, you could use dataFormatter -->
                // data[i - 1][j] = formatter.formatCellValue(row.getCell(j+1));
                // DATAFORMATTER is BETTER Examples below: 
                // toString()				DataFormatter.formatCellValue();
                // Aspect					toString()									DataFormatter.formatCellValue()
                //-----------------------------------------------------------------------------------------------------
                // Numbers			Outputs raw value (e.g., 123.0).						Formats value (e.g., 123).
                // Dates					(e.g., 44204).								formatted date (e.g., 15-Nov-2024).
                // Empty Cells		May throw NullPointerException.							Returns an empty string ("").
                // Formula Cells	Outputs the formula itself (=SUM(A1:A3)).			Outputs the evaluated formula result.
                // Ease of Use				Simple but limited.							More user-friendly and versatile.
                
            }
        }

        workbook.close();
        fis.close();

        return data;
    }
}
