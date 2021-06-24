package com.example.demo.Controller;

//import java.util.List;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.helper.stockpriceexcelhelper;
import com.example.demo.message.responsemessage;
//import com.example.demo.helper.stockpriceexcelhelper;
//import com.example.demo.model.stockpriceexcel;
import com.example.demo.service.stockpriceexcelservice;

@CrossOrigin("http://localhost:8081")
@Controller
@RequestMapping("/api/excel")
public class stockpriceexcelController {

	@Autowired
	stockpriceexcelservice service;
	
	@PostMapping("/excel-upload")
	public ResponseEntity<responsemessage>uploadfile(@RequestParam("file") MultipartFile file)
	{
		String message="";
		//System.out.print(file.getOriginalFilename());
		//System.out.print(file.getContentType());
		if(stockpriceexcelhelper.hasexcelformat(file))
		{
			//System.out.println("yes");
		  try
		  {
			  System.out.print("in");
			  service.save(file);
			  message="upoladed the fil successfully:"+file.getOriginalFilename();
			  return ResponseEntity.status(HttpStatus.OK).body(new responsemessage(message));
		  }
		  catch(Exception e)
		  {
			  message="could not upload file"+file.getOriginalFilename();
			  return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new responsemessage(message));
			  
		  }
		}
		
		message="please upload an excel file";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new responsemessage(message));
		
				
	}
	
	/*@GetMapping("/excel-show")
	public List<stockpriceexcel>getAllstockprice()
	{
		return service.getAllstockprice();
	}*/
}

