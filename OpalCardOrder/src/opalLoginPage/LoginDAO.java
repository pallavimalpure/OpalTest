package opalLoginPage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import config.ConfigHelper;

//Login Data Access
public class LoginDAO 
{
	  HSSFWorkbook wb;
	  HSSFSheet sh;
	  Row rw;
	  Cell cl;
	  FileInputStream fis;
	  String fPath = null;
	  int rcount, ccount, row, col;
	  FileOutputStream fos;
	  HashMap<Integer, LoginData> UserLoginDataMap = new HashMap<Integer, LoginData>();
	  
	  public void writeTheStatustoExcel() throws IOException
	  {
		  getOutputSheet();
		  cl.setCellValue("Successfully logged in");
		  wb.write(fos);
	  }
	  
	  public void getOutputSheet() throws IOException
	  {
		  fPath = ConfigHelper.getGetconfig().getFilePath();
		  fos = new FileOutputStream(fPath);
	  }
	  
	  public void getInputSheet() throws IOException
	  {
		  fPath = ConfigHelper.getGetconfig().getFilePath();
		  fis = new FileInputStream(fPath);
		  
		  wb = new HSSFWorkbook(fis);
		  sh = wb.getSheetAt(0);
		  String shName = wb.getSheetName(0);
		  System.out.println("SheetName:" + shName);
	  }
	  
/*	  public Object[][] getLoginDetails() throws IOException
	  {

		  getInputSheet();
		  
		  rcount = sh.getPhysicalNumberOfRows();
		  ccount = sh.getRow(1).getPhysicalNumberOfCells();
			
		  Object [][] data = new Object[1][ccount];
			
		  for(row = 0;row<rcount-1;row++)
		  {
		  	rw = sh.getRow(row+1);
		 	for (col =0;col<ccount;col++)
			{
				cl = rw.getCell(col);
				data[row][col] = cl.getStringCellValue();
	  		}
	  	  }
		
		fis.close();
	  	return data;
		  	
	  }*/
	  
	  public HashMap<Integer, LoginData> getLoginDetails() throws IOException
	  {

		  getInputSheet();
		  
		  rcount = sh.getPhysicalNumberOfRows();
		  ccount = sh.getRow(1).getPhysicalNumberOfCells();
			
		  //HashMap<Integer, LoginDataNew> map = new HashMap<Integer, LoginDataNew>(); 
			
		  for(row = 0;row<rcount-1;row++)
		  {
			LoginData data = new LoginData();
			rw = sh.getRow(row+1);
		 	for (col =0;col<ccount;col++)
			{
				cl = rw.getCell(col);
				if(col == 0)
				{
					data.userId = rw.getCell(col).getStringCellValue();
				}
				else if(col == 1)
				{
					data.password = rw.getCell(col).getStringCellValue();
				}
				
				else if(col == 2)
				{
					//data.rowId =  Integer.parseInt(rw.getCell(col).getStringCellValue());
					//data.rowId = Integer.parseInt(rw.getCell(col).getNumericCellValue());
				}
				
	  		}
		 	
		 	UserLoginDataMap.put(row, data);
	  	  }
		  
		return UserLoginDataMap;
	  }
	  
	  public LoginData getLoginDetailsForId(int id) throws IOException
	  {
		  try 
		  {
		  if(UserLoginDataMap.size() == 0)
		  {
			  getLoginDetails();
		  }
		  }
		  catch(IOException ex)
		  {
		  
		  }
		  return UserLoginDataMap.get(id);
	  }

}
