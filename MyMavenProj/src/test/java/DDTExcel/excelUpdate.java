package DDTExcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class excelUpdate {
@Test
public void updateCellDetails() throws IOException
{
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\testdata\\AppTest.xlsx");
	Workbook workbook=new XSSFWorkbook(fis);
	int sheetCnt=workbook.getNumberOfSheets();
	Sheet sheet=workbook.getSheet("TC");
	int rowcnt=sheet.getLastRowNum();
	//get specific row
	Row row=sheet.getRow(1);
	//create cell to update the data
	Cell cell=row.createCell(3);
	cell.setCellValue("Fail");
	//To atore updated data find the location to save the file
	FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\testdata\\AppTest.xlsx");
	//write content into the required file
	workbook.write(fos);
	//close the connection
	fos.close();
	System.out.println("File updated");
	
	
	
}
}
