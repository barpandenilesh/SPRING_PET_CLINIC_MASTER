package com.testutility;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class testUtility 

{
	
	public static long PAGE_LOAD_TIMEOUT = 22;
	public static long IMPLICIT_WAIT = 22;
	
	public static String TESTDATA_SHEET_PATH = "D:\\SPRING_PET_CLINIC_MASTER\\spring-petclinic-master\\src\\test\\java\\com\\testdata\\OwnerData - Copy.xls";
	static Workbook wb;
	static Sheet sh1;
	static Row ro;
	
	public static Object[][] getDatafromExcel(String Sheetname)
	{
		
			  // Specify the path of file
			FileInputStream file = null;
			try {
				file = new FileInputStream(TESTDATA_SHEET_PATH);
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
			try 
			{
			   wb=WorkbookFactory.create(file);
			} 
			catch (InvalidFormatException e) 
			{
				e.printStackTrace();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			   // Load sheet- Here we are loading first sheetonly
			  
			   sh1= wb.getSheet(Sheetname);
			   System.out.println("This is sheet" +sh1);
			  
		
		   Object[][] ob = new Object[sh1.getLastRowNum()][sh1.getRow(0).getLastCellNum()];
		System.out.println(sh1.getLastRowNum() + "--------" + sh1.getRow(0).getLastCellNum());
			   
			for (int rowNum=0;rowNum< sh1.getLastRowNum();rowNum++)
			{
				
				for (int col1=0;col1< sh1.getRow(0).getLastCellNum();col1++)
					
					{
					String value = "";
					if (sh1.getRow(rowNum).getCell(col1)==null)
					{
					Cell mycell=sh1.getRow(rowNum).getCell(col1);
					value = cellToString(mycell);
					}
					ob[rowNum][col1] = value;
					System.out.print(value);
					System.out.print("");
					
					 ob[rowNum][col1]=sh1.getRow(rowNum+1).getCell(col1) .toString();
					 
					 System.out.println(ob[rowNum][col1]);
					}
				
			}					
		
			return ob;
		
	}

	private static String cellToString(Cell pinto) {
		// TODO Auto-generated method stub
		return null;
	}			
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		TakesScreenshot driver = null;
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}	
}
	
	
	
	 
	
		


		
		
				
	
	
