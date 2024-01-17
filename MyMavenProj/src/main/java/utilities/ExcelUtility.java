package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	
		// Global vars
private static FileInputStream fis;
private static Workbook workbook;

//method To initialize workbook
public static Workbook initializeWorkbook(String filepath)
{
	try
	{
		fis=new FileInputStream(filepath);
		workbook=new XSSFWorkbook(fis);
		return workbook;//return new XSSFWorkbook(fis);-return workbook obj if file found
	}catch(FileNotFoundException e)
	{
		e.printStackTrace();
		
	}catch(IOException e)
	{
		e.printStackTrace();
	}
	return null;//If File not found dn it will return Null
}
//***********Get row count
public static int getRowCount(String filepath,String sheetname)
{
	workbook=initializeWorkbook(filepath);
	return workbook.getSheet(sheetname).getLastRowNum();//returns no of rows from given sheet
}
//*****Get Cell count on the rows
public static int getCellCountOnTheRows(String filepath,String sheetname,int rowNum)
{
	workbook=initializeWorkbook(filepath);
	return workbook.getSheet(sheetname).getRow(rowNum).getLastCellNum();
}
//********Get cell value of particular cell
public static String getCellvalue(String filepath,String sheetname,int rowNum,int cellNum)
{
	workbook=initializeWorkbook(filepath);
	Cell cell=workbook.getSheet(sheetname).getRow(rowNum).getCell(cellNum);
	switch(cell.getCellType())
	{
	case(Cell.CELL_TYPE_STRING):
		return cell.getStringCellValue();
	
	case(Cell.CELL_TYPE_NUMERIC):
		return ""+(int)cell.getNumericCellValue();
	//break;//cant write break coz it returns previously
	case(Cell.CELL_TYPE_BOOLEAN):
		return ""+cell.getBooleanCellValue();
	//break;
	case(Cell.CELL_TYPE_BLANK):
		return "";
	default:throw new RuntimeException("There is no support to this type of cell");
	
	}
}
//*********Update Excel
public static void updateExcelContent(String filepath,String sheetname,int rowNum,int cellNum,String input)
{
	workbook=initializeWorkbook(filepath);
	Cell cell=workbook.getSheet(sheetname).getRow(rowNum).createCell(cellNum);
	cell.setCellValue(input);
	//to store the updated data find location to save the file
	FileOutputStream fos;
	try {
		fos=new FileOutputStream(filepath);
		//write the content to the required file
		workbook.write(fos);
		//close the connection
		fos.close();
	}catch(FileNotFoundException e)
	{
		e.printStackTrace();
	}catch(IOException e) {
		e.printStackTrace();
	}
}
	

}
