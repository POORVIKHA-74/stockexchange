package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.stockprice;
import com.example.demo.repository.stockpricerepository;
import com.example.demo.service.exceldataservice;
import com.example.demo.service.fileuploaderservice;

@Controller
public class stockpricecontroller {

	 @Autowired
	 fileuploaderservice fileservice;
	 
	 @Autowired
	  exceldataservice excelservice;
	 
	 @Autowired
	 stockpricerepository repo;
	 
	 @GetMapping("/")
	 public String index()
	 {
		 return "upload page";
	 }
	 
	 @PostMapping("/uploadFile")
	    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

		 fileservice.uploadFile(file);

	        redirectAttributes.addFlashAttribute("message",
	            "You have successfully uploaded '"+ file.getOriginalFilename()+"' !");
	        try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return "redirect:/";
	    }
	    
	    @GetMapping("/saveData")
	    public String saveExcelData(Model model) {
	    	
	    	List<stockprice> excelDataAsList = excelservice.getExcelDataAsList();
	    	int noOfRecords = excelservice.saveExcelData(excelDataAsList);
	    	model.addAttribute("noOfRecords",noOfRecords);
	    	return "success";
	    }
	}

