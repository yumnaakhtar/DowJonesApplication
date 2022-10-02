package com.dowjones.accessdata;

import java.util.*;

import org.springframework.data.mongodb.repository.*;
import org.springframework.stereotype.*;

import com.dowjones.pojos.*;

@Repository
public interface AccessStockData extends MongoRepository<Stock, Long> {
	public List<Stock> findByStock(String stock);
}
