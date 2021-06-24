package com.example.demo.serviceimpl;

import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.model.stockprice;
import com.example.demo.repository.stockpricerepository;
import com.example.demo.service.exceldataservice;

@Service
public class exceldataserviceimpl implements exceldataservice{

	
	@Value("${app.upload.file:${user.home}}")
	public String EXCEL_FILE_PATH;

	@Autowired
	stockpricerepository repo;

	Workbook workbook;

	public List<stockprice> getExcelDataAsList() {

		List<String> list = new ArrayList<String>();

		// Create a DataFormatter to format and get each cell's value as String
		DataFormatter dataFormatter = new DataFormatter();

		// Create the Workbook
		try {
			workbook = WorkbookFactory.create(new File(EXCEL_FILE_PATH));
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}

		// Retrieving the number of sheets in the Workbook
		System.out.println("-------Workbook has '" + workbook.getNumberOfSheets() + "' Sheets-----");

		// Getting the Sheet at index zero
		Sheet sheet = workbook.getSheetAt(0);

		// Getting number of columns in the Sheet
		int noOfColumns = sheet.getRow(0).getLastCellNum();
		System.out.println("-------Sheet has '"+noOfColumns+"' columns------");

		// Using for-each loop to iterate over the rows and columns
		for (Row row : sheet) {
			for (Cell cell : row) {
				String cellValue = dataFormatter.formatCellValue(cell);
				list.add(cellValue);
			}
		}

		// filling excel data and creating list as List<Invoice>
		List<stockprice> invList = createList(list, noOfColumns);

		// Closing the workbook
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return invList;
	}

	private List<stockprice> createList(List<String> excelData, int noOfColumns) {

		ArrayList<stockprice> invList = new ArrayList<stockprice>();

		int i = noOfColumns;
		do {
			stockprice inv = new stockprice();

			inv.setCompanyid(Integer.valueOf(excelData.get(i)));
			inv.setStockexchangeid(Integer.valueOf(excelData.get(i+1)));
			inv.setCurrentprice(Integer.valueOf(excelData.get(i+2)));
			inv.setDate(excelData.get(i + 3));
			inv.setTime(excelData.get(i + 4));
			
				

			invList.add(inv);
			i = i + (noOfColumns);

		} while (i < excelData.size());
		return invList;
	}

	@Override
	public int saveExcelData(List<stockprice> stockprice) {
		stockprice = repo.saveAll(stockprice);
		return stockprice.size();
	}
}
