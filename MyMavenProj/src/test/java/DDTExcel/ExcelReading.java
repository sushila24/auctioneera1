package DDTExcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelReading {
	@Test
	public void testCase() {
		// step1:file location using FileInputStream class
		// step 2:create an instance of required XSSFworkbook class and upcast it to
		// workbook interface
		// 3:u can get sheet related info n specific sheet as well from workbook
		// instance
		// 4:once u get specific sheet,u can get all rows n specific row information
		// 5.once u get specific row,u can get value of all the cell or specific cell
	}

	@Test
	public void readSheetdetails() throws IOException {
		// create instance of FileInputStream class n pass required excel file location
		// to its constructor
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\testdata\\AppTest.xlsx");
		// Absolute
		// path=//D:\workspace2023\FirstProject\src\test\resources\testdata\AppTest.xlsx
		// create an instance of required workbook classs n upcast it to workbook
		// interface and pass fis instance to its constructor
		Workbook workbook = new XSSFWorkbook(fis);
		// get the number of sheets present in excel
		int sheetCnt = workbook.getNumberOfSheets();
		System.out.println("Sheet count:" + sheetCnt);
		// print all sheet name from Excel
		for (int i = 0; i < sheetCnt; i++) {
			String sheetName = workbook.getSheetName(i);
			System.out.println(sheetName);
		}
		// get the required sheet from excel
		workbook.getSheet("TC");// will open TC excel worksheet
	}

//GET ROW Details
	@Test
	public void getRowDetails() throws IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\testdata\\AppTest.xlsx");
		Workbook workbook = new XSSFWorkbook(fis);
		int sheetCount = workbook.getNumberOfSheets();
		System.out.println("No.of sheets:" + sheetCount);
		System.out.println("Present sheets are:");
		for (int i = 0; i < sheetCount; i++) {

			String sheetName = workbook.getSheetName(i);
			System.out.println(sheetName);
		}
		// get required sheet from the Excel
		Sheet sheet = workbook.getSheet("TC");
		// get row count from the excel-rowCount=ActualCount-1
		int rowCount = sheet.getLastRowNum();
		System.out.println("No.of rows ppresent in sheet :" + rowCount);
		// get specific row from the sheet
		Row row = sheet.getRow(1);// first row
	}

	// **GeT CELL Details
	@Test
	public void getCellDetails() throws IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\testdata\\AppTest.xlsx");
		Workbook workbook = new XSSFWorkbook(fis);
		int sheetCount = workbook.getNumberOfSheets();
		for (int i = 0; i < sheetCount; i++) {
			System.out.println(workbook.getSheetName(i));
		}
		// get the required sheet
		Sheet sheet = workbook.getSheet("TC");
		// get row count from the sheet its cnt=Actual rows-1
		int rowCnt = sheet.getLastRowNum();
		// get specific row from sheet
		Row row = sheet.getRow(0);
		// get the cell count from the row
		int celCount = row.getLastCellNum();
		System.out.println("Cell count on row 0:" + celCount);
		// get cell-2 data from cell from row0
		Cell cell = row.getCell(2);
		System.out.println("Row0 -cell2 data is:" + cell.getStringCellValue());// string type data
		// Get all cells data from row0
		for (int i = 0; i < celCount; i++) {
			Cell col = row.getCell(i);
			String cellData = col.getStringCellValue();
			System.out.println("cell data=" + cellData);
			// or
			// System.out.println("Cell data:"+row.getCell(i).getStringCellValue());//prints
			// all coumn name Row0 data cells
		}

	}

	// *******Get different Types of Cell data like string/int/boolean
	@Test
	public void getDiffTypeOfCellData() throws IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\testdata\\AppTest.xlsx");
		Workbook workbook = new XSSFWorkbook(fis);
		int sheetCnt = workbook.getNumberOfSheets();
		for (int i = 0; i < sheetCnt; i++) {
			System.out.println(workbook.getSheetName(i));
		}
		Sheet sheet = workbook.getSheet("TC");
		// get rows count
		int rowCnt = sheet.getLastRowNum();
		// get specific row from the sheet
		Row row = sheet.getRow(2);
		// get the cell count from the specific row
		int cellCnt = row.getLastCellNum();
		// get all cell data from row3
		for (int i = 0; i < cellCnt; i++) {
			// System.out.println("cell data:"+row.getCell(i).getStringCellValue());//for
			// string type data
			Cell cell = row.getCell(i);
			// use switch case to read different type of data
			switch (cell.getCellType())
			// Return the cell
			// type.Returns:Cell.CELL_TYPE_BLANKCell.CELL_TYPE_NUMERICCell.CELL_TYPE_STRINGCell.CELL_TYPE_FORMULACell.CELL_TYPE_BOOLEANCell.CELL_TYPE_ERROR
			{
			case (Cell.CELL_TYPE_STRING):
				System.out.println("cell data:" + cell.getStringCellValue());
				break;
			case (Cell.CELL_TYPE_NUMERIC):
				System.out.println("Cell data:" + cell.getNumericCellValue());
				break;
			case (Cell.CELL_TYPE_BOOLEAN):
				System.out.println("Cell data:" + cell.getBooleanCellValue());
				break;
			case (Cell.CELL_TYPE_BLANK):
				System.out.println("Empty Cell data");
				break;
			default:
				System.out.println("Invalid cell details");
				break;

			}
		}
	}

	// *******Read all data from sheet
	@Test
	public void readAllDataFromSheet() throws IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\testdata\\AppTest.xlsx");
		Workbook workbook = new XSSFWorkbook(fis);
		int sheetCnt = workbook.getNumberOfSheets();
		for (int i = 0; i < sheetCnt; i++) {
			System.out.println(workbook.getSheetName(i));
		}
		Sheet sheet = workbook.getSheet("TC");
		int rowCnt = sheet.getLastRowNum();
		// get row wise data
		for (int x = 0; x <= sheet.getLastRowNum(); x++) {
			// get specific row from0
			Row row = sheet.getRow(x);
			// get the cell count from the row
			int cellCnt = row.getLastCellNum();
			// get all cell data from specific row
			for (int i = 0; i < cellCnt; i++) {
				// System.out.println("Cell data:"+row.getCell(i).getStringCellValue());//for
				// string type data
				Cell cell = row.getCell(i);
				switch (cell.getCellType()) {
				case (Cell.CELL_TYPE_BOOLEAN):
					System.out.println("Cell data:" + cell.getBooleanCellValue());
					break;
				case (Cell.CELL_TYPE_STRING):
					System.out.println("Cell data:" + cell.getStringCellValue());
					break;
				case (Cell.CELL_TYPE_NUMERIC):
					System.out.println("Cell data:" + cell.getNumericCellValue());
					break;
				case (Cell.CELL_TYPE_BLANK):
					System.out.println("Invalid/blank cell");
					break;
				default:
					System.out.println("Invalid cell details");
					break;
				}
				System.out.print("|");
			}
			System.out.println();
		}
	}
}
