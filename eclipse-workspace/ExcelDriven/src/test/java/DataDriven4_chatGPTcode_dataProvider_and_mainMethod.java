import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDriven4_chatGPTcode_dataProvider_and_mainMethod {

    @DataProvider(name = "ExcelData")
    public Object[][] readExcelData() throws IOException {
        return DataDriven3_chatGPTcode_excelReader.getExcelData("D:\\demodata.xlsx", "data");
    }

    @Test(dataProvider = "ExcelData")
    public void testWithExcelData(String col1, String col2, String col3) {
        System.out.println("Data: " + col1 + ", " + col2 + ", " + col3);
        // Add your test logic here
    }
}
