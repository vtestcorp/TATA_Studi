package studi.co.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviders {
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	public static DataFormatter formatter = new DataFormatter();
	static Object Data[][];

	@DataProvider(name = "Political_Science_Data")
	public static Object[][] Political_Science_DataProvider_Method() {

		try {

			String basepath = System.getProperty("user.dir");
			File file = new File(basepath + "\\TestData\\Data.xlsx");
			System.out.println(file);
			FileInputStream fs = new FileInputStream(file);
			ExcelWBook = new XSSFWorkbook(fs);
			System.out.println(ExcelWBook.getSheetName(0));
			ExcelWSheet = ExcelWBook.getSheet("Political Science");
			System.out.println(ExcelWSheet.getLastRowNum());
			int rowcount = ExcelWSheet.getPhysicalNumberOfRows();
			Row = ExcelWSheet.getRow(0);
			Data = new Object[rowcount][Row.getLastCellNum()];
			System.out.println(rowcount);

			for (int i = 0; i < rowcount; i++) {
				Row = ExcelWSheet.getRow(i);
				for (int j = 0; j < Row.getLastCellNum(); j++) {
					if (Row == null)
						Data[i][j] = "";
					else {
						Cell = Row.getCell(j);
						if (Cell == null)
							Data[i][j] = ""; // if it get Null value it pass no data
						else {
							String value = formatter.formatCellValue(Cell);
							Data[i][j] = value; // This formatter get my all values as string i.e integer, float all
												// type data value
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Unable to find BBA Products file");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Data;
	}

}
