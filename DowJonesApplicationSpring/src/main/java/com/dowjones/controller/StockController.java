package com.dowjones.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.dowjones.accessdata.*;

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

}
