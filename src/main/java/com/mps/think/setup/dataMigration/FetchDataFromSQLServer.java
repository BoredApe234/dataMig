package com.mps.think.setup.dataMigration;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mps.think.setup.model.CustomerCategory;
import com.mps.think.setup.model.CustomerDetails;
import com.mps.think.setup.model.DiscountCardKeyInfo;
import com.mps.think.setup.model.InventoryMapper;
import com.mps.think.setup.model.LableFormat;
import com.mps.think.setup.model.LableGroup;
import com.mps.think.setup.model.LableKeyLine;
import com.mps.think.setup.model.Order;
import com.mps.think.setup.model.OrderClass;
import com.mps.think.setup.model.OrderCodesSuper;
import com.mps.think.setup.model.PaymentType;
import com.mps.think.setup.model.ProfitCenter;
import com.mps.think.setup.model.RateCards;
import com.mps.think.setup.model.RateCardsRenewals;
import com.mps.think.setup.model.SourceFormat;
import com.mps.think.setup.repo.AddOrderRepo;
import com.mps.think.setup.repo.AddressesRepo;
import com.mps.think.setup.repo.CustomerAddressesRepo;
import com.mps.think.setup.repo.CustomerCategoryRepo;
import com.mps.think.setup.repo.CustomerDetailsRepo;
import com.mps.think.setup.repo.DiscountCardKeyInfoRepo;
import com.mps.think.setup.repo.InventoryRepository;
import com.mps.think.setup.repo.LableFormatRepo;
import com.mps.think.setup.repo.LableGroupRepo;
import com.mps.think.setup.repo.LableKeyLineRepo;
import com.mps.think.setup.repo.OrderClassRepo;
import com.mps.think.setup.repo.OrderCodesSuperRepo;
import com.mps.think.setup.repo.PaymentTypeRepo;
import com.mps.think.setup.repo.ProfitCenterRepo;
import com.mps.think.setup.repo.PublisherRepo;
import com.mps.think.setup.repo.RateCardsRenewalsRepo;
import com.mps.think.setup.repo.RateCardsRepo;
import com.mps.think.setup.repo.SourceFormatRepo;

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
	LableFormatRepo LFRepo;
	
	@Autowired
	LableGroupRepo LGRepo;
	
	@Autowired
	LableKeyLineRepo LKLRepo;
	
	@Autowired
	ProfitCenterRepo PCRepo;
	
	@Autowired
	AddOrderRepo AORepo;
	
	@Autowired
	OrderCodesSuperRepo OCSRepo;
	
	@Autowired
	OrderClassRepo OClassRepo;
	
	@Autowired
	CustomerDetailsRepo CDRepo;
	
	@Autowired
	PublisherRepo pubRepo;

	@Autowired
	PaymentTypeRepo PTRepo;
	
	@Autowired
	RateCardsRepo RCRepo;
	
	@Autowired
	RateCardsRenewalsRepo RCRRepo;
	
	@Autowired
	SourceFormatRepo SFRepo;
	
	@Autowired
	InventoryRepository IRepo;

	@Autowired
	DiscountCardKeyInfoRepo DCKIRepo;
	
	@Autowired
	CustomerCategoryRepo CCRepo;
	
	@Autowired
	AddressesRepo addressRepo;
	
	@Autowired
	CustomerAddressesRepo customerAddressRepo;
	

	BasicDataSource ds = new BasicDataSource();
	
	List<Integer> transfer(String publissher) {		
		
		ArrayList<Integer> llist = new ArrayList<Integer>();
		// Set up connection pooling
		ds.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		if(publissher=="CSP") { ds.setUrl("jdbc:sqlserver://10.33.11.74;databaseName=CSP_TEST_WEB;authenticationScheme=NTLM;integratedSecurity=true;encrypt=true;trustServerCertificate=true");
		FR.setPublisher(pubRepo.findById(2).get());
		}
		else if(publissher=="ASM") {ds.setUrl("jdbc:sqlserver://10.33.11.74;databaseName=ASM_TEST_WEB;authenticationScheme=NTLM;integratedSecurity=true;encrypt=true;trustServerCertificate=true");
		FR.setPublisher(pubRepo.findById(3).get());
		}
		
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
//		
		List<OrderClass> OC  =FR.fetchOrderClass(conn);
		llist.add(OC.size());
			OClassRepo.saveAll(OC);
		
		List<DiscountCardKeyInfo> DCKI = FR.fetchDiscountCardKeyInfo(conn);
		llist.add(DCKI.size());
		
			DCKIRepo.saveAll(DCKI);
		
		List<InventoryMapper> IM = FR.fetchInventoryMapper(conn);
		llist.add(IM.size());

			IRepo.saveAll(IM);
		
		
		List<RateCards> RC = FR.fetchRateCards(conn);
		llist.add(RC.size());

		RCRepo.saveAll(RC);
		
		List<RateCardsRenewals> RCR = FR.fetchRateCardRenewables(conn);
		llist.add(RCR.size());
		RCRRepo.saveAll(RCR);
		
		List<CustomerCategory> CC = FR.fetchCustomerCategory(conn);
		llist.add(CC.size());
		CCRepo.saveAll(CC);
		
		List<CustomerDetails> CD = FR.fetchCustomerDetails(conn);
		llist.add(CD.size());
		CDRepo.saveAll(CD);
		
		List<PaymentType> PT = FR.fetchPaymentType(conn);
		llist.add(PT.size());
		PTRepo.saveAll(PT);

		List<SourceFormat> SF = FR.fetchSourceFormat(conn);
		llist.add(SF.size());
		SFRepo.saveAll(SF);
		
		List<OrderCodesSuper> OCS = FR.fetchOrderCodesSuper(conn);
		llist.add(OCS.size());
		OCSRepo.saveAll(OCS);
		
		List<Order> Order = FR.fetchOrder(conn);
		llist.add(Order.size());
		AORepo.saveAll(Order);
		
		List<LableFormat> LF = FR.fetchLabelFormat(conn);
		llist.add(LF.size());
		LFRepo.saveAll(LF);
		
		List<LableGroup> LG = FR.fetchLableGroup(conn);
		llist.add(LF.size());
		LGRepo.saveAll(LG);
		
		List<LableKeyLine> LKL = FR.fetchLabelKeyLine(conn);
		llist.add(LF.size());
		LKLRepo.saveAll(LKL);
		
		List<ProfitCenter> PC = FR.fetchProfitCenter(conn);
		llist.add(PC.size());
		PCRepo.saveAll(PC);
		
		
		
		return llist;
	}

}
