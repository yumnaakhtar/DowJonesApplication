package com.dowjones.controller;

import java.io.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;

import com.dowjones.accessdata.*;
import com.dowjones.pojos.*;
import com.opencsv.bean.*;

@Controller
public class StockController {
	
	private final AccessStockData stockData;
	
	@Autowired
	public StockController(AccessStockData stockData) {
		this.stockData = stockData;
		
	}

	@GetMapping("/")
	public String mainPage() {
		return "homepage";
	}
	
	@GetMapping("/upload-bulk")
	public String uploadBulk(Stock indices) {
		
       
        stockData.deleteAll();
       
		return "upload-bulk";
	}
	
	@PostMapping("/uploaded-file")
	public String fileUploaded(@RequestParam("file") MultipartFile file, Model model) {
		try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

            // create csv bean reader
            CsvToBean<Stock> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Stock.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<Stock> stocks = csvToBean.parse();

            stockData.saveAll(stocks);
            System.out.println(stockData.count());

        } catch (Exception ex) {
            model.addAttribute("message", "An error occurred while processing the CSV file.");
        }
		return "uploaded-file";
    }

    
	

}
