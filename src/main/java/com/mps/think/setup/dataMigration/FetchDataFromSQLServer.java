package com.mps.think.setup.dataMigration;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mps.think.setup.model.Addresses;
import com.mps.think.setup.model.CustomerDetails;
import com.mps.think.setup.model.DiscountCardKeyInfo;
import com.mps.think.setup.model.InventoryMapper;
import com.mps.think.setup.model.OrderClass;
import com.mps.think.setup.model.RateCards;
import com.mps.think.setup.model.RateCardsRenewals;
import com.mps.think.setup.repo.AddressesRepo;
import com.mps.think.setup.repo.CustomerAddressesRepo;
import com.mps.think.setup.repo.CustomerCategoryRepo;
import com.mps.think.setup.repo.CustomerDetailsRepo;
import com.mps.think.setup.repo.DiscountCardKeyInfoRepo;
import com.mps.think.setup.repo.InventoryRepository;
import com.mps.think.setup.repo.OrderClassRepo;
import com.mps.think.setup.repo.OrderCodesSuperRepo;
import com.mps.think.setup.repo.PublisherRepo;
import com.mps.think.setup.repo.RateCardsRenewalsRepo;
import com.mps.think.setup.repo.RateCardsRepo;

@Service
public class FetchDataFromSQLServer {

	@Value("${sqlserverconfig}")
	String connection;

	@Value("${user}")
	String username;

	@Value("${pass}")
	String password;

	@Autowired
	fetchRows FR;
	
	@Autowired
	OrderCodesSuperRepo OCSRepo;
	
	@Autowired
	OrderClassRepo OClassRepo;
	
	@Autowired
	CustomerDetailsRepo CDRepo;
	
	@Autowired
	PublisherRepo pubRepo;

	@Autowired
	CustomerDetailsRepo cusRepo;
	
	@Autowired
	RateCardsRepo RCRepo;
	
	@Autowired
	RateCardsRenewalsRepo RCRRepo;
	
	@Autowired
	InventoryRepository IRepo;

	@Autowired
	DiscountCardKeyInfoRepo DCKIRepo;
	
	@Autowired
	CustomerCategoryRepo custCatRepo;
	
	@Autowired
	AddressesRepo addressRepo;
	
	@Autowired
	CustomerAddressesRepo customerAddressRepo;
	

	BasicDataSource ds = new BasicDataSource();
	
	List<Integer> transfer(String publissher) {		
		
		ArrayList<Integer> llist = new ArrayList<Integer>();
		// Set up connection pooling
		ds.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		if(publissher=="CSP") ds.setUrl("jdbc:sqlserver://10.33.11.74;databaseName=CSP_TEST_WEB;authenticationScheme=NTLM;integratedSecurity=true;encrypt=true;trustServerCertificate=true");
		else if(publissher=="ASM") ds.setUrl("jdbc:sqlserver://10.33.11.74;databaseName=ASM_TEST_WEB;authenticationScheme=NTLM;integratedSecurity=true;encrypt=true;trustServerCertificate=true");
		ds.setUrl(connection);
		ds.setUsername(username);
		ds.setPassword(password);
		//ds.setMaxTotal(-1); // Maximum number of connections in the pool
//
//		// Connect to the database
		
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<OrderClass> OC  =FR.fetchOrderClass(conn);
		llist.add(OC.size());
		for(OrderClass add:OC) {
			OClassRepo.save(add);
		}
		
		
		List<Addresses> Address = FR.fetchAddresses(conn);
		llist.add(Address.size());

		for (Addresses add : Address) {
			addressRepo.save(add);
		}
		
		List<DiscountCardKeyInfo> DCKI = FR.fetchDiscountCardKeyInfo(conn);
		llist.add(DCKI.size());
		
		for (DiscountCardKeyInfo add : DCKI) {
			DCKIRepo.save(add);
		}
		
		List<InventoryMapper> IM = FR.fetchInventoryMapper(conn);
		llist.add(IM.size());

		for (InventoryMapper add : IM) {
			IRepo.save(add);
		}
		
		List<RateCards> RC = FR.fetchRateCards(conn);
		llist.add(RC.size());

		for (RateCards add : RC) {
			RCRepo.save(add);
		}
		List<RateCardsRenewals> RCR = FR.fetchRateCardRenewables(conn);
		llist.add(RCR.size());
		for(RateCardsRenewals add:RCR) {
			RCRRepo.save(add);
		}
		
		List<CustomerDetails> CD = FR.fetchCustomerDetails(conn);
		llist.add(RCR.size());
		for(CustomerDetails add:CD) {
			CDRepo.save(add);
		}

		return llist;
	}

}
