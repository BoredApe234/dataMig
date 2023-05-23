package com.mps.think.setup.dataMigration;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.mps.think.setup.model.CustomerDetails;
import com.mps.think.setup.model.Publisher;
import com.mps.think.setup.repo.CustomerCategoryRepo;
import com.mps.think.setup.repo.CustomerDetailsRepo;
import com.mps.think.setup.repo.PublisherRepo;
import com.mps.think.setup.repo.TermsRepo;

@Service
public class DataMig {
	
	@Autowired
	PublisherRepo pubRepo;
	
	@Autowired
	TermsRepo termsRepo;
	
	@Autowired
	CustomerDetailsRepo customerRepo;
	
	@Autowired
	CustomerCategoryRepo customerCatRepo;
	
	@Autowired
	Environment env;

	public List<CustomerDetails> getAllRows(String tableName) throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		
        Connection conn = DriverManager.getConnection(env.getProperty("sqlserverconfig"), env.getProperty("user"), env.getProperty("pass"));
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT TOP(500) * FROM " + tableName);
        
//        List<Terms> allRows = new ArrayList<>();
        List<CustomerDetails> allRows = new ArrayList<>();
//        List<CustomerCategory> allRows = new ArrayList();
        Publisher pub1 = pubRepo.findById(1).get();
        while (rs.next()) {
        	
        	CustomerDetails cd = new CustomerDetails();
        	cd.setCustomerId(rs.getInt("customer_id"));
        	cd.setCustomerCategory(null);
        	cd.setSalutation(rs.getString("salutation"));
        	cd.setFname(rs.getString("fname"));
        	cd.setLname(rs.getString("lname"));
        	cd.setInitialName(rs.getString("initial_name"));
        	cd.setSuffix(rs.getString("suffix"));
        	cd.setCompany(rs.getString("company"));
//        	cd.setDepartment(tableName); could not find
        	cd.setEmail(rs.getString("email"));
//        	cd.setCountryCode(tableName);
//        	cd.setPrimaryPhone(tableName);
//        	cd.setMobileNumber(tableName);
//        	cd.setTaxId(tableName);
//        	cd.setTaxExempt(null);
//        	cd.setSecondaryEmail(tableName);
//        	cd.setSecondaryPhone(tableName);
        	cd.setListRental(rs.getString("list_rental_category"));
        	cd.setSalesRepresentative("");
//        	cd.setCreditStatus(tableName);
//        	cd.setFax(rs.get);
//        	cd.setInstitutionalId(null);
//        	cd.setParentInstitutionalId(null);
//        	cd.setChargeTaxOn(null);
//        	cd.setPaymentOptions(null);
//        	cd.setConfigurationOptionsforOrders(null);
//        	cd.setNewOrderCommission(tableName);
//        	cd.setRenewalCommission(tableName);
//        	cd.setPaymentThreshold(tableName);
        	cd.setCreatedAt(rs.getDate("creation_date"));
        	cd.setPublisher(pub1);
        	allRows.add(cd);
        }
        
		stmt.close();
        conn.close();
        
        return allRows;
 
	}
	
	public void transfer(String fromTable) throws Exception {
		List<CustomerDetails> allRows = getAllRows(fromTable);
//		allRows.forEach(r -> System.out.println(r));
		customerRepo.saveAllAndFlush(allRows);
	}

}


