package com.mps.think.setup.dataMigration;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MoveData {
	
//	@Autowired
//	DataMig dataMigObj;
	
	@Autowired
	FetchDataFromSQLServer t;
	
//	@GetMapping("/moveData")
//	public List<String> moveData() {
//		return t.transfer().stream().map(c -> c.toString()).collect(Collectors.toList());
//	}
	
	@GetMapping("/moveData/{pub}")
	public List<String> moveData(@PathVariable("pub") String publisher) {
		return t.transfer(publisher).stream().map(c -> c.toString()).collect(Collectors.toList());
	}
	
}
