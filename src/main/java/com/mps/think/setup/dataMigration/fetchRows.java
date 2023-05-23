package com.mps.think.setup.dataMigration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mps.think.setup.model.Addresses;
import com.mps.think.setup.model.CustomerAddresses;
import com.mps.think.setup.model.CustomerCategory;
import com.mps.think.setup.model.CustomerDetails;
import com.mps.think.setup.model.DiscountCardKeyInfo;
import com.mps.think.setup.model.InventoryBulkTotals;
import com.mps.think.setup.model.InventoryGeneralInformation;
import com.mps.think.setup.model.InventoryMapper;
import com.mps.think.setup.model.InventoryOrderSettings;
import com.mps.think.setup.model.InventoryStorageLocations;
import com.mps.think.setup.model.InventoryTotals;
import com.mps.think.setup.model.InventoryUnitInformation;
import com.mps.think.setup.model.OrderClass;
import com.mps.think.setup.model.OrderCodes;
import com.mps.think.setup.model.OrderCodesSuper;
import com.mps.think.setup.model.OrderItemDetails;
import com.mps.think.setup.model.Publisher;
import com.mps.think.setup.model.RateCards;
import com.mps.think.setup.model.RateCardsRenewals;
import com.mps.think.setup.repo.CustomerCategoryRepo;
import com.mps.think.setup.repo.OrderClassRepo;
import com.mps.think.setup.repo.PublisherRepo;
import com.mps.think.setup.repo.RateCardsRepo;
import com.mps.think.setup.vo.EnumModelVO.AddressType;
import com.mps.think.setup.vo.EnumModelVO.Currency;
import com.mps.think.setup.vo.EnumModelVO.CustomerStatus;
import com.mps.think.setup.vo.EnumModelVO.Status;

@Component
public class fetchRows {
	
	
	@Autowired
	private PublisherRepo pubRepo;
	
	@Autowired
	private RateCardsRepo RCRepo;
	
	@Autowired
	private static Publisher pub;
	
	@Autowired
	private CustomerCategoryRepo CCRepo;
	
	@Autowired
	private OrderClassRepo ocRepo;
	
	public fetchRows(PublisherRepo PRepo) {
		this.pubRepo = PRepo;
		fetchRows.pub = pubRepo.findById(2).get();	
		}
	
	public List<CustomerCategory> fetchCustomerCategory(Connection conn) {
		
		try {
			// Execute a prepared statement to retrieve data
			PreparedStatement cust_category = conn.prepareStatement("Select * from customer_category;");
			ResultSet rs = cust_category.executeQuery();
			// Set fetch size to retrieve 100 rows at a time
	        List<CustomerCategory> allRows = new ArrayList<CustomerCategory>();
		//	Publisher pub1 = pubRepo.findById(1).get();

			while (rs.next()) {
	        	CustomerCategory cg = new CustomerCategory();
	        	cg.setPubId(pub);
	        	cg.setCustCategory(rs.getString("customer_category"));
	        	cg.setThinkCategory(rs.getString("description"));
	        	cg.setStatus(rs.getInt("active"));
	        	// column row_version in the older db is still not alligned with nthe new db table of customer_category. 
	        	//where to get the PID on the new DB from the old DB?
	        	
	        	allRows.add(cg);
	        }
			// Close the database connection
//			ds.close();
			return allRows;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	
	public List<CustomerDetails> fetchCustomerDetails(Connection conn){

		try {
			// Execute a prepared statement to retrieve data
			PreparedStatement cust_category = conn.prepareStatement("Select * from customer;");
			ResultSet rs = cust_category.executeQuery();
			// Set fetch size to retrieve 100 rows at a time
	        List<CustomerDetails> allRows = new ArrayList<CustomerDetails>();
		//	Publisher pub1 = pubRepo.findById(1).get();

			while (rs.next()) {
	        	CustomerDetails cg = new CustomerDetails();
	        	CustomerCategory CC = CCRepo.findByCustomerCategory(rs.getString("cust_category"));
	        	cg.setCustomerCategory(CC);
	        	cg.setThinkCategory(CC.getThinkCategory());
	        	cg.setSalutation(rs.getString("salutation"));
	        	cg.setFname(rs.getString("fname"));
	        	cg.setLname(rs.getString("lname"));
	        	cg.setInitialName(rs.getString("initial_name"));
	        	cg.setSuffix(rs.getString("suffix"));
	        	cg.setCompany(rs.getString("company"));
	        	cg.setDepartment(null);
	        	cg.setEmail(rs.getString("email"));
	        	cg.setCountryCode(null);
	        	cg.setPrimaryPhone(null);
	        	cg.setMobileNumber(null);
	        	cg.setTaxId(null);
	        	cg.setTaxExempt(null);
	        	cg.setSecondaryEmail(null);
	        	cg.setSecondaryPhone(null);
	        	cg.setListRental(null);
	        	cg.setCreditStatus(null);
	        	cg.setFax(null);
	        	cg.setInstitutionalId(null);
	        	cg.setChargeTaxOn(null);
	        	cg.setPaymentOptions(null);
	        	cg.setConfigurationOptionsforOrders(null);
	        	cg.setNewOrderCommission(null);
	        	cg.setRenewalCommission(null);
	        	cg.setAgencyname(null);
	        	cg.setAgencycode(null);
	        	cg.setCustAuxFieldJSON(null);
	        	cg.setPublisher(pub);
	        	List<CustomerAddresses> CAs = new ArrayList<CustomerAddresses>();
	        	PreparedStatement address_stmt= conn.prepareStatement("select * from customer_address ca2 WHERE customer_id =;"+rs.getInt("customer_id"));
	        	ResultSet rs_address = address_stmt.executeQuery();
	        	while(rs_address.next()) {
	        		CustomerAddresses CA = new CustomerAddresses();
	        		Addresses add = new Addresses();
	        		add.setAddressName(rs_address.getString("title"));
	        		if(rs_address.getString("address_type")==null) add.setAddressType(null);
	        		else if(rs_address.getString("address_type")=="BUSINESS") add.setAddressType(AddressType.Business);
	        		else if (rs_address.getString("address_type")=="RESIDENCE")add.setAddressType(AddressType.Residential);
	        		else if(rs_address.getString("address_type")=="OTHER")add.setAddressType(AddressType.Other);
	        		add.setAddressCategory(null);
	        		add.setState(rs_address.getString("address_status"));
	        		add.setPrimaryAddress(null);
	        		add.setName(null);
	        		add.setAddressLine1(rs_address.getString("address1"));
	        		add.setAddressLine2(rs_address.getString("address2")+rs_address.getString("address3"));
	        		add.setZipCode(rs_address.getString("zip"));
	        		add.setCity(rs_address.getString("city"));
	        		add.setState(rs_address.getString("state"));
	        		add.setCountry(rs_address.getString("country"));
	        		add.setCountryCode(null);
	        		add.setPhone(null);
	        		add.setValidFrom(rs_address.getDate("effective_date"));
	        		add.setValidTo(null);
	        		add.setFrequency(null);
	        		add.setSelectionFrom(null);
	        		add.setSelectionTo(null);
	        		add.setAddressAuxJSON(null);
	        		CAs.add(CA);
	        	}
	        	cg.setCustomerAddresses(CAs);
	        	if(rs.getInt("inactive")==0)cg.setCustomerStatus(CustomerStatus.Active);
	        	else if(rs.getInt("inactive")==1)cg.setCustomerStatus(CustomerStatus.Inactive);
	        	cg.setCurrCustomerStatusCause(null);
	        	cg.setDateUntilDeactivation(null);
	        	allRows.add(cg);
	        }
			// Close the database connection
//			ds.close();
			return allRows;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	

	List<InventoryMapper> fetchInventoryMapper(Connection conn){
		try {
			// Execute a prepared statement to retrieve data
			PreparedStatement stmt = conn.prepareStatement("select top 10 * from inventory i inner join inv_location il on i.inv_location_id = il.inv_location_id ;");
			ResultSet rs = stmt.executeQuery();
//			rs.setFetchSize(6000);
			// Set fetch size to retrieve 100 rows at a time
	        List<InventoryMapper> allRows = new ArrayList<InventoryMapper>();
			while (rs.next()) {
				InventoryMapper IM = new InventoryMapper();
				InventoryGeneralInformation IGI = new InventoryGeneralInformation();
	        	IGI.setInventoryCode(rs.getString("inven_code"));
	        	IGI.setInventoryId(rs.getInt("inventory_id"));
	        	IGI.setUserCode(rs.getString("user_code"));
	        	IGI.setDescription(rs.getString("description"));
	        	IGI.setActiveInventoryItem(rs.getBoolean("active"));
	        	InventoryUnitInformation IUI = new InventoryUnitInformation();
	        	IUI.setDefaultPrice(rs.getDouble("unit_price_d"));
	        	IUI.setWeight(rs.getString("unit_wt_d"));
	        	IUI.setCost(rs.getDouble("unit_cost_d"));
	        	InventoryTotals IT = new InventoryTotals();
	        	IT.setOrderNotShipped(null);
	        	IT.setCustomerBackOrders(null);
	        	IT.setInStock(rs.getInt("qty_onhand"));
	        	IT.setOnVendorOrder(rs.getInt("qty_order"));
	        	IT.setOnVendorBackOrder(rs.getInt("qty_vend_bo"));
	        	IT.setAdjustments(rs.getInt("adjustments"));
	        	IT.setTotalUnitsAvailable(rs.getInt("qty_onhand"));
	        	InventoryStorageLocations ISL = new InventoryStorageLocations();
	        	ISL.setLocation(rs.getString("location"));
	        	ISL.setAreaLookup(rs.getString("description"));
	        	ISL.setAlternateArea(null);
	        	ISL.setBin(rs.getString("bin"));
	        	InventoryOrderSettings IOS = new InventoryOrderSettings();
	        	IOS.setPackageNumbers(null);
	        	IOS.setUnitPerPackage(null);
	        	IOS.setDisallowAsSample(null);
	        	IOS.setMinimumForSamples(null);
	        	IOS.setReorderPrint(null);
	        	IOS.setLastShipment(null);
	        	
	        	InventoryBulkTotals IBT = new InventoryBulkTotals();
	        	IBT.setOnVentoryBackOrder(null);
	        	IBT.setOnVentoryOrder(null);
	        	IBT.setBulkInStock(null);
	        	IBT.setInventoryInTransfer(null);
	        	
	        	IM.setGeneralInformation(IGI);
	        	IM.setUnitInformation(IUI);
	        	IM.setInventoryTotals(IT);
	        	IM.setPrimaryStorageLocation(ISL);
	        	IM.setOrderSettings(IOS);
	        	IM.setBulkInventoryTotals(IBT);
	        	allRows.add(IM);
	        }
			return allRows;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	
	List<DiscountCardKeyInfo> fetchDiscountCardKeyInfo(Connection conn){
		try {
			// Execute a prepared statement to retrieve data
			PreparedStatement stmt = conn.prepareStatement("select * from discount_class;");
//			PreparedStatement stmt_rate = conn.prepareStatement("select * from rate_class;");

			ResultSet rs = stmt.executeQuery();
//			rs.setFetchSize(6000);
			// Set fetch size to retrieve 100 rows at a time
	        List<DiscountCardKeyInfo> allRows = new ArrayList<DiscountCardKeyInfo>();
			while (rs.next()) {
				DiscountCardKeyInfo oc = new DiscountCardKeyInfo();
				oc.setDiscountCard(rs.getString("discount_class"));
				oc.setDescription(rs.getString("description"));
				oc.setOrderClass(ocRepo.findById(rs.getInt("oc_id")).get());
				oc.setUseForPkg(false);
				oc.setPublisher(pub);
	        	allRows.add(oc);
	        }
			return allRows;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	
	List<RateCards> fetchRateCards(Connection conn){
		try {
			// Execute a prepared statement to retrieve data
			PreparedStatement stmt = conn.prepareStatement("SELECT * from ratecard r FULL JOIN rate_class rc on r.rate_class_id =rc.rate_class_id;");
//			PreparedStatement stmt_rate = conn.prepareStatement("select * from rate_class;");

			ResultSet rs = stmt.executeQuery();
//			rs.setFetchSize(6000);
			// Set fetch size to retrieve 100 rows at a time
	        List<RateCards> allRows = new ArrayList<RateCards>();
			while (rs.next()) {
				RateCards oc = new RateCards();
				oc.setOcId(ocRepo.findById(rs.getInt("oc_id")).get());
				oc.setRateClassEffectiveSequence(rs.getInt("mru_rate_class_effective_seq"));
				oc.setRateCard(rs.getString("Rate_class"));
				oc.setDescription(rs.getString("description"));
				oc.setUseForPackage(rs.getBoolean("is_package"));
				oc.setItemtype(rs.getString("unit_type"));
				oc.setDefaultPricePerItem(rs.getFloat("price"));
	        	allRows.add(oc);
	        }
			return allRows;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	
	
	List<RateCardsRenewals> fetchRateCardRenewables(Connection conn){
		try {
			// Execute a prepared statement to retrieve data
			PreparedStatement stmt = conn.prepareStatement("SELECT * from ratecard r join rate_class rc on r.rate_class_id =rc.rate_class_id JOIN rate_class_effective rce on rc.rate_class_id =rce.rate_class_id ;");
//			PreparedStatement stmt_rate = conn.prepareStatement("select * from rate_class;");

			ResultSet rs = stmt.executeQuery();
//			rs.setFetchSize(6000);
			// Set fetch size to retrieve 100 rows at a time
	        List<RateCardsRenewals> allRows = new ArrayList<RateCardsRenewals>();
			while (rs.next()) {
				RateCardsRenewals oc = new RateCardsRenewals();
				oc.setRenewalId(RCRepo.findById(rs.getInt("rate_class_id")).get());
				oc.setBasicPrice(rs.getFloat("basic"));
				oc.setNoOfItem(rs.getInt("baseline_qty"));
				oc.setUnitPrice(rs.getFloat("price"));
				if(rs.getString("currency") == null) oc.setCurrency(null);
				else if (rs.getString("currency").equals("USD")) oc.setCurrency(Currency.USD);
				else if (rs.getString("currency").equals("CAD")) oc.setCurrency(Currency.CAD);
				oc.setValidFrom(rs.getDate("effective_date"));
				oc.setValidTo(null);
				oc.setFromQuantity(null);
				oc.setToQuantity(null);
				oc.setValidForRegions(rs.getString("region"));
				oc.setRenewalExpiryDate(rs.getDate("renewal_expire_effective_date"));
	        	allRows.add(oc);
	        }
			return allRows;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
		
	}
	
	List<OrderCodesSuper> fetchOrderCodesSuper(Connection conn){
		try {
			// Execute a prepared statement to retrieve data
			PreparedStatement stmt_Order_Code = conn.prepareStatement("select * from order_code;");
			PreparedStatement stmt_Order_class = conn.prepareStatement("select * from oc;");
			PreparedStatement stmt_Order_Item_Details = conn.prepareStatement("select * from order_item");
			ResultSet rs_Order_Code = stmt_Order_Code.executeQuery();
			ResultSet rs_Order_Class = stmt_Order_class.executeQuery();
			ResultSet rs_Order_Item_Details = stmt_Order_Item_Details.executeQuery();
//			rs.setFetchSize(6000);
			// Set fetch size to retrieve 100 rows at a time
	        List<OrderCodesSuper> allRows = new ArrayList<OrderCodesSuper>();
			while (rs_Order_Code.next()||rs_Order_Class.next()) {
				OrderCodesSuper OCS = new OrderCodesSuper();
				OCS.setPublisher(pub);
				OrderCodes oc = new OrderCodes();
				oc.setOrderCode(rs_Order_Code.getString("order_code"));
				oc.setDescription(rs_Order_Code.getString("Description"));
				oc.setOrderType(rs_Order_Code.getString("order_code_type"));
				oc.setOrderCodeId(rs_Order_Code.getString("order_code_id"));
				oc.setOrderClassId(rs_Order_Code.getString("oc_id"));
				oc.setRateCard(null);
				oc.setDiscountCard(null);
				OCS.setOrderCodes(oc);
				OrderClass OC = new OrderClass();
				OC.setOcId(rs_Order_Class.getInt("oc_id"));
				OC.setOrderClassName(rs_Order_Class.getString("oc"));
				OC.setOcType(rs_Order_Class.getString("oc_type"));
				OC.setDisallowInstallBilling(rs_Order_Class.getString("disallow_install_billing"));
				OC.setDoCancelCreditOnCancel(rs_Order_Class.getString("do_cancel_credit_on_cancel"));
				OC.setLowSampleStock(rs_Order_Class.getString("low_sample_stock"));
				OC.setLowStock(rs_Order_Class.getString("low_stock"));
				OC.setNewGroupMemberAction(rs_Order_Class.getString("new_group_member_action"));
				OC.setPostConversionReconcile(rs_Order_Class.getString("post_conversion_reconcile"));
				OC.setSampleIssueSelection(rs_Order_Class.getString("sample_issue_selection"));
				OC.setTrackInven(rs_Order_Class.getString("track_inven"));
				OC.setUpsellOn(rs_Order_Class.getString("upsell_on"));
				OC.setPubId(pub);
				OCS.setOrderClass(OC);
				OrderItemDetails OID = new OrderItemDetails();
				OID.setEffectiveDate(rs_Order_Item_Details.getDate(""));
				OID.setItemType(null);
				OID.setItemImage(null);
				OID.setPrice(null);
				OID.setShippingWeight(null);
				OID.setCommodityCode(null);
				OID.setGraceQuanitity(null);
				OID.setMedia(null);
				OID.setEdition(null);
				OID.setCategory(null);
				
				
	        	allRows.add(OCS);
	        }
			return allRows;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	
//	List<CustomerCategory> fetchCustoemrCategory(Connection conn){
//		
//		PreparedStatement stmt = conn.prepareStatement("select * from customer");
//		ResultSet rs = stmt.executeQuery();
//
//		// Set fetch size to retrieve 100 rows at a time
//		rs.setFetchSize(1000);
//		Map<String, Integer> customerCategories = fillCustCategory();
//		
//		CustomerCategory custCatCash = custCatRepo.findById(1).get();
//		CustomerCategory custCatCredit = custCatRepo.findById(2).get();
//		int count = 0;
//		// Process the retrieved data
//		while (rs.next()) {
//			System.out.println(++count);
//			CustomerDetails cd = new CustomerDetails();
//			cd.setCustomerId(rs.getInt("customer_id"));
////			if (rs.getString("customer_category") == null) {
////				cd.setCustomerCategory(null);
////			} else {
////				cd.setCustomerCategory(custCatRepo.findById(customerCategories.get(rs.getString("customer_category"))).get());
////			}
//			if (rs.getString("customer_category") == null) {
//				cd.setCustomerCategory(null);
//			} else if (rs.getString("customer_category").equals("Cash")) {
//				cd.setCustomerCategory(custCatCash);
//			} else if (rs.getString("customer_category").equals("Credit")) {
//				cd.setCustomerCategory(custCatCredit);
//			}
//			cd.setSalutation(rs.getString("salutation"));
//			cd.setFname(rs.getString("fname"));
//			cd.setLname(rs.getString("lname"));
//			cd.setInitialName(rs.getString("initial_name"));
//			cd.setSuffix(rs.getString("suffix"));
//			cd.setCompany(rs.getString("company"));
////        	cd.setDepartment(tableName); could not find
//			cd.setEmail(rs.getString("email"));
////        	cd.setCountryCode(tableName);
////        	cd.setPrimaryPhone(tableName);
////        	cd.setMobileNumber(tableName);
////        	cd.setTaxId(tableName);
////        	cd.setTaxExempt(null);
////        	cd.setSecondaryEmail(tableName);
////        	cd.setSecondaryPhone(tableName);
//			cd.setListRental(rs.getString("list_rental_category"));
//			cd.setSalesRepresentative("");
////        	cd.setCreditStatus(tableName);
////        	cd.setFax(rs.get);
////        	cd.setInstitutionalId(null);
////        	cd.setParentInstitutionalId(null);
////        	cd.setChargeTaxOn(null);
////        	cd.setPaymentOptions(null);
////        	cd.setConfigurationOptionsforOrders(null);
////        	cd.setNewOrderCommission(tableName);
////        	cd.setRenewalCommission(tableName);
////        	cd.setPaymentThreshold(tableName);
//			cd.setCreatedAt(rs.getDate("creation_date"));
//			cd.setPublisher(pub1);
//			allRows.add((T) cd);
//		}
//
//	}
	
	List<Addresses> fetchAddresses(Connection conn){
		
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("select * from customer_address;");
		
		ResultSet rs = stmt.executeQuery();

		// Set fetch size to retrieve 100 rows at a time
//		rs.setFetchSize(1000);
		
		List<Addresses> customerAddMp = new ArrayList<Addresses>();
		
		while (rs.next()) {
			Addresses a = new Addresses();
			
			a.setAddressName(null);
			if (rs.getString("address_type").equals("BUSINESS")) a.setAddressType(AddressType.Business);
			else if (rs.getString("address_type").equals("RESIDENCE")) a.setAddressType(AddressType.Residential);
			else a.setAddressType(AddressType.Other);
			
			a.setStatus(Status.Active);
			a.setName(rs.getString("fname")+" "+rs.getString("lname"));
			a.setAddressLine1(rs.getString("address1"));
			a.setAddressLine2(rs.getString("address2"));
			a.setZipCode(rs.getString("zip"));
			a.setCity(rs.getString("city"));
			a.setState(rs.getString("state"));
			a.setCountry(rs.getString("county"));
			a.setPhone(rs.getString("phone"));
//			a.setValidFrom(null);
//			a.setValidTo(null);
//			a.setFrequency(null);
//			a.setSelectionFrom(null);
//			a.setSelectionTo(null);
//			a.setAddressAuxJSON(null);
			
		}
		return customerAddMp;
		
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	
	List<OrderClass> fetchOrderClass(Connection conn){
		try {
			// Execute a prepared statement to retrieve data
			PreparedStatement stmt = conn.prepareStatement("select * from oc;");
//			PreparedStatement stmt = conn.prepareStatement("select * from rate_class;");

			ResultSet rs = stmt.executeQuery();
//			rs.setFetchSize(6000);
			// Set fetch size to retrieve 100 rows at a time
	        List<OrderClass> allRows = new ArrayList<OrderClass>();
			while (rs.next()) {
				OrderClass oc = new OrderClass();
				oc.setOcId(rs.getInt("oc_id"));
				oc.setOrderClassName(rs.getString("oc"));
				oc.setOcType(rs.getString("oc_type"));
				oc.setDisallowInstallBilling(rs.getString("disallow_install_billing"));
				oc.setDoCancelCreditOnCancel(rs.getString("do_cancel_credit_on_cancel"));
				oc.setLowSampleStock(rs.getString("low_sample_stock"));
				oc.setLowStock(rs.getString("low_stock"));
				oc.setNewGroupMemberAction(rs.getString("new_group_member_action"));
				oc.setPostConversionReconcile(rs.getString("post_conversion_reconcile"));
				oc.setSampleIssueSelection(rs.getString("sample_issue_selection"));
				oc.setTrackInven(rs.getString("track_inven"));
				oc.setUpsellOn(rs.getString("upsell_on"));
				oc.setPubId(pub);
	        	allRows.add(oc);
	        }
			return allRows;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	
}
