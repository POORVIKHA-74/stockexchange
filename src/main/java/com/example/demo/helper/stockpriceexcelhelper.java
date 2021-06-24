package com.example.demo.helper;

import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.stockpriceexcel;

public class stockpriceexcelhelper {

	public static String TYPE="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	static String[] HEADERs= {"companyid,stockexchangeid,currentprice,date,time"};
	static String SHEET="sample_stock_data";
	
	public static boolean hasexcelformat(MultipartFile file)
	{
		if(!TYPE.equals(file.getContentType())) {
			return false;
		}
		return true;
	}
	public static List<stockpriceexcel>exceltostockprice(InputStream is)
	{
		
		
		try
		{
			Workbook workbook=new XSSFWorkbook(is);
			
			Sheet sheet=workbook.getSheet(SHEET);
			Iterator<Row> rows=sheet.iterator();
			List<stockpriceexcel> finallist=new ArrayList<stockpriceexcel>();
			int rowNumber=0;
			while(rows.hasNext())
			{
				Row currentrow=rows.next();
			
			
				if(rowNumber==0)
				{
					rowNumber++;
					continue;
				}
			
			
				Iterator<Cell>cellinrow=currentrow.iterator();
				
				stockpriceexcel stockpriceexcel=new stockpriceexcel();
				
				int cellidx=0;
				
				while(cellinrow.hasNext())
				{
					Cell currentcell=cellinrow.next();
					
					switch(cellidx)
					{
					case 0:
						stockpriceexcel.setCompanyid((int)currentcell.getNumericCellValue());
						break;
					
					case 1:
						stockpriceexcel.setStockexchangeid((int)currentcell.getNumericCellValue());
						break;
					
					case 2:
						stockpriceexcel.setCurrentprice((int)currentcell.getNumericCellValue());
						break;
					case 3:
						stockpriceexcel.setDate((String)currentcell.getStringCellValue());
						break;
					case 4:
						stockpriceexcel.setTime((String)currentcell.getStringCellValue());
						break;
					default:
						break;
						
					}
					cellidx++;
			}
			
			finallist.add(stockpriceexcel);
			
			}
			
			workbook.close();
			
			return finallist;
		}
		catch(IOException e) {
			throw new RuntimeException("fail to parse excel file:"+e.getMessage());
		}
		//return finallist;
	}
}
