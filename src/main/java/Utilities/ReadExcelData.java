package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadExcelData {
	
	

	@DataProvider(name = "readDataValues")
	public static String[][] readData() throws IOException {
		
		

		String Path1 = System.getProperty("user.dir");
		String Path =Path1+"\\src\\main\\java\\TestDataExcel\\customerDetails.xlsx";
		System.out.println(Path);
	
		
		FileInputStream fs = new FileInputStream(Path);

		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheet("Sheet1");

		int rowCount = sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();

		DataFormatter format = new DataFormatter();
		String testData[][] = new String[rowCount][columnCount];

		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				testData[i - 1][j] = format.formatCellValue(sheet.getRow(i).getCell(j));
			}
		}

		return testData;

	}
}
