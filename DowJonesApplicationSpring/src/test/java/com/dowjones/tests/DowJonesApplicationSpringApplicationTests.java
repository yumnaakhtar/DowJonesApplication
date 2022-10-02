package com.dowjones.tests;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.*;
import org.springframework.ui.*;
import org.springframework.validation.*;

import com.dowjones.accessdata.*;
import com.dowjones.controller.*;
import com.dowjones.pojos.*;

@SpringBootTest
class DowJonesApplicationSpringApplicationTests {
	
	private static StockController testController;
	private static Model testModel;
	private static AccessStockData testDatabase;
	private static BindingResult testResult;
	
	@BeforeAll
	public static void setUpMocks() {
		testModel = mock(Model.class);
		testDatabase = mock(AccessStockData.class);
		testController = new StockController(testDatabase);
		testResult = mock(BindingResult.class);
	}

	@Test
	void testUploadBulkPath() {
		Stock example = new Stock("1","AA","1/14/2011","$16.71","$16.71","$15.64","$15.97","242963398","-4.42849","1.380223028", "239655616", "$16.19", "$15.79", "-2.47066", "19", "0.187852");
		//test if path works
		assertThat(testController.uploadBulk(example)).isEqualTo("upload-bulk");
		
	}
	
	@Test
	void testQueryStockPath() {
		String tickerToQuery = "AA";
		assertThat(testController.getStock(tickerToQuery, testModel)).isEqualTo("query-results");
	}
	
	@Test 
	void testAddRecordPath() {
		Stock example = new Stock("2","AA","1/14/2011","$16.71","$16.71","$15.64","$15.97","242963398","-4.42849","1.380223028", "239655616", "$16.19", "$15.79", "-2.47066", "19", "0.187852");
		assertThat(testController.addRecord(example,testResult)).isEqualTo("show-record");
	}
	

}
