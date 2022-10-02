package com.dowjones.controller;

import java.io.*;
import java.util.*;

import javax.validation.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.*;
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

	//main page
	@GetMapping("/")
	public String mainPage() {
		return "homepage";
	}
	
	//Upload CSV file on this page
	@GetMapping("/upload-bulk")
	public String uploadBulk(Stock bulkStock) {
		return "upload-bulk";
	}
	
	//Parse uploaded CSV page
	@PostMapping("/uploaded-file")
	public String fileUploaded(@RequestParam("file") MultipartFile file, Model model) {
		
		try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

            // create csv bean reader
            CsvToBean<Stock> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Stock.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<Stock> stocks = csvToBean.parse();

            //Add to database
            stockData.saveAll(stocks);
            

        } catch (Exception ex) {
            model.addAttribute("message", "An error occurred while processing the CSV file.");
        }
		return "uploaded-file";
    }

	//Query a stock by ticker
	@GetMapping("/query-stock")
	public String queryStock(Model model) {
		model.addAttribute("stock",new Stock());
		return "query-stock";
	}
    
	//Return results of stock query
	@GetMapping("/query/{stock}")
	public String getStock(@RequestParam(name="stock") String stock, Model model) {
		List<Stock> results = stockData.findByStock(stock);
		model.addAttribute("allresults", results);
		return "query-results";
	}
	
	//Enter record details to add to the database
	@GetMapping("/add-record")
	public String addRecord(Model model) {
		model.addAttribute("new_stock",new Stock());
		return "add-record";
	}
	
	//Add the record to the database
	@PostMapping("/dowork")
	public String addRecord(@ModelAttribute("new_stock") @Valid Stock new_stock, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "add-record";
		} 			
		stockData.save(new_stock);
		return "show-record";
	}
	

}
