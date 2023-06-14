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
import com.mps.think.setup.model.LableFormat;
import com.mps.think.setup.model.LableFormatGroups;
import com.mps.think.setup.model.LableGroup;
import com.mps.think.setup.model.LableKeyLine;
import com.mps.think.setup.model.Order;
import com.mps.think.setup.model.OrderClass;
import com.mps.think.setup.model.OrderCodes;
import com.mps.think.setup.model.OrderCodesSuper;
import com.mps.think.setup.model.OrderDeliveryOptions;
import com.mps.think.setup.model.OrderItemDetails;
import com.mps.think.setup.model.OrderItems;
import com.mps.think.setup.model.OrderKeyInformation;
import com.mps.think.setup.model.OrderOptions;
import com.mps.think.setup.model.OrderPaymentOptions;
import com.mps.think.setup.model.PaymentBreakdown;
import com.mps.think.setup.model.PaymentType;
import com.mps.think.setup.model.ProfitCenter;
import com.mps.think.setup.model.Publisher;
import com.mps.think.setup.model.RateCards;
import com.mps.think.setup.model.RateCardsRenewals;
import com.mps.think.setup.model.ShippingPriceList;
import com.mps.think.setup.model.SourceAttributes;
import com.mps.think.setup.model.SourceCode;
import com.mps.think.setup.model.SourceFormat;
import com.mps.think.setup.model.SourceFormatAndAttributeMapping;
import com.mps.think.setup.model.SubscriptionDefKeyInfo;
import com.mps.think.setup.model.Terms;
import com.mps.think.setup.repo.CustomerCategoryRepo;
import com.mps.think.setup.repo.CustomerDetailsRepo;
import com.mps.think.setup.repo.LableFormatRepo;
import com.mps.think.setup.repo.LableGroupRepo;
import com.mps.think.setup.repo.OrderClassRepo;
import com.mps.think.setup.repo.OrderCodesSuperRepo;
import com.mps.think.setup.repo.PublisherRepo;
import com.mps.think.setup.repo.RateCardsRepo;
import com.mps.think.setup.vo.EnumModelVO.AddressType;
import com.mps.think.setup.vo.EnumModelVO.Currency;
import com.mps.think.setup.vo.EnumModelVO.CustomerStatus;
import com.mps.think.setup.vo.EnumModelVO.Status;
import com.mps.think.setup.vo.EnumModelVO.SubDefStatus;

@Component
public class fetchRows {
	
	@Autowired
	CustomerDetailsRepo CDRepo;
	
	@Autowired
	private PublisherRepo pubRepo;
	
	@Autowired
	OrderClassRepo OCRepo;
	
	@Autowired
	LableFormatRepo LFRepo;
	
	@Autowired
	LableGroupRepo LGRepo;
	
	@Autowired
	OrderCodesSuperRepo OCSRepo;
	
	
	@Autowired
	private RateCardsRepo RCRepo;
	
	@Autowired
	private static Publisher pub;
	
	@Autowired
	private CustomerCategoryRepo CCRepo;
	
	@Autowired
	private OrderClassRepo ocRepo;
	
//	public fetchRows(PublisherRepo PRepo) {
//		this.pubRepo = PRepo;
//		fetchRows.pub = pubRepo.findById(2).get();
//		
//		}
	public void setPublisher(Publisher pub) {
		fetchRows.pub = pub;
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
			PreparedStatement cust_category = conn.prepareStatement("select * from customer order by customer_id  OFFSET 4000 ROWS FETCH NEXT 110 ROWS ONLY;");
			ResultSet rs = cust_category.executeQuery();
			rs.setFetchSize(100);
	        List<CustomerDetails> allRows = new ArrayList<CustomerDetails>();
		//	Publisher pub1 = pubRepo.findById(1).get();

			while (rs.next()) {
	        	CustomerDetails cg = new CustomerDetails();
	        	cg.setCustomerId(rs.getInt("customer_id"));
	        	CustomerCategory CC = ((rs.getString("customer_category")==null)?null:CCRepo.findByCustomerCategory(rs.getString("customer_category")));
	        	cg.setCustomerCategory(CC);
	        	cg.setThinkCategory((CC==null)?null:CC.getThinkCategory());
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
	        	System.out.print("Fetching the address of the customer...\n");
	        	PreparedStatement address_stmt= conn.prepareStatement("select * from customer_address ca2 WHERE customer_id ="+rs.getInt("customer_id")+";");
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
	        		add.setCountry(null);
	        		add.setCountryCode(null);
	        		add.setPhone(null);
	        		add.setValidFrom(rs_address.getDate("effective_date"));
	        		add.setValidTo(rs_address.getDate("reverse_date"));
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
//			rs.setFetchSize(100);
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
	
	List<Terms> fetchTerms(Connection conn){
		try {
			// Execute a prepared statement to retrieve data
			PreparedStatement stmt = conn.prepareStatement("SELECT * from ratecard r join rate_class rc on r.rate_class_id =rc.rate_class_id JOIN rate_class_effective rce on rc.rate_class_id =rce.rate_class_id ;");
//			PreparedStatement stmt_rate = conn.prepareStatement("select * from rate_class;");

			ResultSet rs = stmt.executeQuery();
//			rs.setFetchSize(100);
			// Set fetch size to retrieve 100 rows at a time
	        List<Terms> allRows = new ArrayList<Terms>();
			while (rs.next()) {
				Terms oc = new Terms();
				oc.setPubId(pub);
				oc.setTerm(rs.getString("term"));
				oc.setDescription(rs.getString("description"));
				oc.setSegmented(null);
				oc.setSegment(null);
				oc.setUnitsPerSegment(rs.getInt("n_cal_units_per_seg"));
				oc.setQuantity(rs.getInt("n_issues"));
				oc.setDuration(rs.getInt("n_calendar_units"));
				oc.setUnitsInDuration(rs.getString(""));
				oc.setVolumeGroupsToSpan(rs.getString("number_volume_sets"));
				switch(rs.getString("start_type")) {
				case "0": oc.setStartType("Anytime Starts");
					break;
				case "1": oc.setStartType("Volume Group Starts");
					break;
				case "2":oc.setStartType("Date Based with Issues");
					break;
				case "3":oc.setStartType("Date Based no Issues");
					break;
				case "4":oc.setStartType("Date based with Units");
					break;
				case "5":oc.setStartType("Unit Based no time");
					break;
				}
				switch(rs.getInt("calendar_unit")) {
				case 0: oc.setInstallmentterm("Day(s)");
				break;
				case 1: oc.setInstallmentterm("Week(s)");
				break;
				case 2: oc.setInstallmentterm("Months(s)");
				break;
				case 3: oc.setInstallmentterm("Years(s)");
				break;
				}
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
			PreparedStatement stmt_Order_class = conn.prepareStatement("select * from oc;");
			//PreparedStatement stmt_Order_Code = conn.prepareStatement("select * from order_code;");
//			PreparedStatement stmt_Order_Item_Details = conn.prepareStatement("select * from order_item");
			//ResultSet rs_Order_Code = stmt_Order_Code.executeQuery();
			ResultSet rs_Order_Class = stmt_Order_class.executeQuery();
//			ResultSet rs_Order_Item_Details = stmt_Order_Item_Details.executeQuery();
			
//			rs.setFetchSize(6000);
			// Set fetch size to retrieve 100 rows at a time
	        List<OrderCodesSuper> allRows = new ArrayList<OrderCodesSuper>();
			while (rs_Order_Class.next()) {
				OrderCodesSuper OCS = new OrderCodesSuper();
				OCS.setPublisher(pub);
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
				PreparedStatement stmt_Order_Code = conn.prepareStatement("select * from order_code where oc_id="+rs_Order_Class.getInt("oc_id")+";");
				ResultSet rs_Order_Code = stmt_Order_Code.executeQuery();
				OrderCodes oc = new OrderCodes();
				oc.setOrderCode(rs_Order_Code.getString("order_code"));
				oc.setDescription(rs_Order_Code.getString("Description"));
				oc.setOrderType(rs_Order_Code.getString("order_code_type"));
				oc.setOrderCodeId(rs_Order_Code.getString("order_code_id"));
				oc.setOrderClassId(rs_Order_Code.getString("oc_id"));
				oc.setRateCard(null);
				oc.setDiscountCard(null);
				OCS.setOrderCodes(oc);
				PreparedStatement stmt_Order_Item_Details = conn.prepareStatement("select * from order_item where order_code_id="+rs_Order_Code.getInt("order_code_id")+";");
				ResultSet rs_Order_Item_Details = stmt_Order_Item_Details.executeQuery();
				OrderItemDetails OID = new OrderItemDetails();
				OID.setEffectiveDate(rs_Order_Item_Details.getDate("order_date"));
				OID.setItemType(rs_Order_Item_Details.getString("unit_type_id"));
				OID.setItemImage(null);
				OID.setPrice(null);
				OID.setShippingWeight(null);
				OID.setCommodityCode(null);
				OID.setGraceQuanitity(rs_Order_Item_Details.getString("order_qty"));
				OID.setMedia(null);
				OID.setEdition(null);
				OID.setCategory(null);
				OrderPaymentOptions OPO = new OrderPaymentOptions();
				OPO.setProformaOptions(rs_Order_Item_Details.getString("is_proforma"));
				OPO.setCreditCardProcessing(null);
				OPO.setInstallmentBilling(rs_Order_Item_Details.getString("installment_plan_id"));
				OPO.setPrepaymentRequired(rs_Order_Item_Details.getBoolean("prepayment_req"));
				OPO.setAutoReplace(null);
				OPO.setChargeShipping(null);
				OPO.setTaxable(rs_Order_Item_Details.getBoolean("has_tax"));
				OPO.setIsActive(null);
				OCS.setOrderPaymentOptions(OPO);
				OrderOptions OO = new OrderOptions();
				OO.setSubscriptionCalculation(null);
				//0 Issue-based 1 Time-based 2 Unit-based 
				OO.setRevenueRealisedBy(rs_Order_Item_Details.getString("revenue_method"));
				OO.setTaxonomy(null);
				OO.setRenewalCard(null);
				OO.setControlled(null);
				OO.setSegmentedOrder((rs_Order_Item_Details.getInt("n_segment_left")>0)?true:false);
				OO.setGraceQuanitity(null);
				OO.setTrialType(rs_Order_Item_Details.getString("trial_type"));
				OO.setMedia(null);
				OO.setEdition(null);
				OO.setCategory(rs_Order_Item_Details.getString("order_category"));
				OO.setNumOfDays(rs_Order_Item_Details.getInt("n_days_graced"));
				OO.setNumOfUnits(rs_Order_Item_Details.getInt("n_cal_units_per_seg"));
				PreparedStatement stmt_unit_type = conn.prepareStatement("select * from unit_type where unit_type_id="+rs_Order_Item_Details.getInt("unit_type_id")+";");
				ResultSet rs_unit_type = stmt_unit_type.executeQuery();
				OO.setUnitType(rs_unit_type.getString("description"));
	        	allRows.add(OCS);
	        }
			return allRows;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	
	List<Order> fetchOrder(Connection conn){
		try {
			// Execute a prepared statement to retrieve data
			PreparedStatement stmt_Order_class = conn.prepareStatement("select * from oc;");
			PreparedStatement stmt_Order_Item = conn.prepareStatement("select * from order_item;");
			ResultSet rs_Order_Class = stmt_Order_class.executeQuery();
			ResultSet rs_Order_Item = stmt_Order_Item.executeQuery();
//			rs.setFetchSize(6000);
			// Set fetch size to retrieve 100 rows at a time
	        List<Order> allRows = new ArrayList<Order>();
			while (rs_Order_Class.next()) {
				Order Order = new Order();
				CustomerDetails CD = CDRepo.findById(rs_Order_Item.getInt("customer_id")).get();
				OrderClass OC = OCRepo.findById(rs_Order_Item.getInt("oc_id")).get();
				Order.setOrderType(null);
				Order.setOrderStatus(null);
				Order.setCustomerId(CD);
				Order.setOrderClass(OC);
				OrderKeyInformation OKI = new OrderKeyInformation();
				OKI.setAgent(null);
				OKI.setAgentReferenceNum(null);
				OKI.setOrderCategory(rs_Order_Item.getString("order_category"));
				OKI.setOrderCode(null);
				OKI.setOrderDate(null);
				OKI.setOrderStatus(rs_Order_Item.getString("order_status"));
				OKI.setPurchaseOrder(null);
				OKI.setSourceCode(null);
				Order.setKeyOrderInformation(OKI);
				PreparedStatement stmt_Issue = conn.prepareStatement("select * from order_item where oc_id="+rs_Order_Class.getString("oc_id")+";");
				ResultSet rs_Issue = stmt_Issue.executeQuery();
//				PreparedStatement stmt_job_pub_oc = conn.prepareStatement("select * from job_pub_oc where oc_id="+rs_Order_Class.getString("oc_id")+";");
//				ResultSet rs_job_pub_oc = stmt_job_pub_oc.executeQuery();
				OrderItems OI = new OrderItems();
				OI.setIssue(rs_Issue.getInt("issue_id"));
				OI.setEnumeration(rs_Issue.getString("enumeration"));
				OI.setCopiesPerIssue(null);
				PreparedStatement stmt_subs_def = conn.prepareStatement("select * from subscription_def where oc_id="+rs_Order_Class.getString("oc_id")+";");
				ResultSet rs_subs_def = stmt_subs_def.executeQuery();
				SubscriptionDefKeyInfo SDKI = new SubscriptionDefKeyInfo();
				SDKI.setPublisher(pub);
				SDKI.setOrderClass(OC);
				SDKI.setSubDefStatus((rs_subs_def.getInt("inactive")==0)?SubDefStatus.ACTIVE: SubDefStatus.INACTIVE);
				SDKI.setDescription(rs_subs_def.getString("description"));
				SDKI.setOrderCode(OCSRepo.findById(rs_subs_def.getInt("order_code_id")).get());
				List<Terms> terms = new ArrayList<Terms>();
				PreparedStatement stmt_terms = conn.prepareStatement("select * from term t left join subscription_def sd on t.term_id =sd.term_id where sd.oc_id  ="+rs_Order_Class.getString("oc_id")+";");
				ResultSet rs_terms = stmt_terms.executeQuery();
				while(rs_terms.next()) {
					Terms oc = new Terms();
					oc.setPubId(pub);
					oc.setTerm(rs_terms.getString("term"));
					oc.setDescription(rs_terms.getString("description"));
					oc.setSegmented(null);
					oc.setSegment(null);
					oc.setUnitsPerSegment(rs_terms.getInt("n_cal_units_per_seg"));
					oc.setQuantity(rs_terms.getInt("n_issues"));
					oc.setDuration(rs_terms.getInt("n_calendar_units"));
					oc.setUnitsInDuration(rs_terms.getString(""));
					oc.setVolumeGroupsToSpan(rs_terms.getString("number_volume_sets"));
					switch(rs_terms.getString("start_type")) {
					case "0": oc.setStartType("Anytime Starts");
						break;
					case "1": oc.setStartType("Volume Group Starts");
						break;
					case "2":oc.setStartType("Date Based with Issues");
						break;
					case "3":oc.setStartType("Date Based no Issues");
						break;
					case "4":oc.setStartType("Date based with Units");
						break;
					case "5":oc.setStartType("Unit Based no time");
						break;
					}
					switch(rs_terms.getInt("calendar_unit")) {
					case 0: oc.setInstallmentterm("Day(s)");
					break;
					case 1: oc.setInstallmentterm("Week(s)");
					break;
					case 2: oc.setInstallmentterm("Months(s)");
					break;
					case 3: oc.setInstallmentterm("Years(s)");
					break;
					}
					terms.add(oc);
				}
				SDKI.setTerms(terms);
				SDKI.setSubDefId(rs_subs_def.getString("subscription_def_id"));
				SDKI.setRateCard(RCRepo.findById(rs_subs_def.getInt("rate_class_id")).get());
				SDKI.setRenewalCard(rs_subs_def.getString("renewal_card_id"));
				SDKI.setOrderCodeType(null);
				SDKI.setMedia(rs_subs_def.getString("media"));
				SDKI.setEdition(rs_subs_def.getString("edition"));
				SDKI.setCategory(rs_subs_def.getString("subscription_category_id"));
				OI.setSubsProdPkgDef(SDKI);
				OI.setNumOfIssues(null);
				OI.setLiabilityIssue(null);
				OI.setExtendedIssue(null);
				OI.setTerm(null);
				OI.setExtendedByDays(null);
				Order.setOrderItemsAndTerms(OI);
				PaymentBreakdown PB = new PaymentBreakdown();
				PB.setCurrencyType(null);
				PB.setCurrency(null);
				PB.setPaymentStatus(null);
				PB.setTerm(null);
				PB.setBaseAmount(null);
				PB.setDiscount(null);
				PB.setTax(null);
				PB.setGrossAmount(null);
				PB.setCommission(null);
				PB.setShippingCharge(null);
				PB.setNetAmount(null);
				Order.setPaymentBreakdown(PB);
				OrderDeliveryOptions ODO = new OrderDeliveryOptions();
				ODO.setDeliveryMethod(null);
				ODO.setProformaPayment(null);
				ODO.setSendRenewalNotice(null);
				ODO.setAutoRenewal(null);
				Order.setDeliveryAndBillingOptions(ODO);
				
				allRows.add(Order);
	        }
			return allRows;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	
	
	List<SourceFormat> fetchSourceFormat(Connection conn){
		try {
			// Execute a prepared statement to retrieve data
			PreparedStatement stmt = conn.prepareStatement("SELECT * from source_attribute;");
			PreparedStatement stmt_format = conn.prepareStatement("SELECT * from source_format;");

			//			PreparedStatement stmt_rate = conn.prepareStatement("select * from rate_class;");

			ResultSet rs = stmt.executeQuery();
			ResultSet rs_format = stmt_format.executeQuery();
//			rs.setFetchSize(100);
			// Set fetch size to retrieve 100 rows at a time
	        List<SourceFormat> allRows = new ArrayList<SourceFormat>();
			while (rs.next() || rs_format.next()) {
				SourceAttributes oc = new SourceAttributes();
				oc.setPublisher(pub);
				oc.setAttribute(rs.getString("description"));
				SourceFormatAndAttributeMapping SFAM = new SourceFormatAndAttributeMapping();
				SFAM.setSourceAttributes(oc);
				List<SourceFormatAndAttributeMapping> ListSFAM = new ArrayList<>();
				ListSFAM.add(SFAM);
				SourceFormat SF = new SourceFormat();
				SF.setAttributeMappings(null);
				SF.setSourceFormat(rs_format.getString("source_format"));
				SF.setDescription(rs_format.getString("description"));
				SF.setMruSourceFormatSegmentSeq(rs_format.getInt("mru_source_format_segment_seq"));
				SF.setAttributeMappings(ListSFAM);
				allRows.add(SF);
	        }
			return allRows;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	
	List<ShippingPriceList> fetchShippingPriceList(Connection conn){
		try {
			// Execute a prepared statement to retrieve data
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM shipping_price_list;");
//			PreparedStatement stmt_rate = conn.prepareStatement("select * from rate_class;");

			ResultSet rs = stmt.executeQuery();
//			rs.setFetchSize(100);
			// Set fetch size to retrieve 100 rows at a time
	        List<ShippingPriceList> allRows = new ArrayList<ShippingPriceList>();
			while (rs.next()) {
				ShippingPriceList oc = new ShippingPriceList();
				oc.setPublisher(pub);
				oc.setShippingPriceList(rs.getString("shipping_price_list"));
				oc.setDescription(rs.getString("description"));
				oc.setShippingMethod(rs.getString("shipping_method"));
				allRows.add(oc);
	        }
			return allRows;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	
	List<SourceCode> fetchSourceCode(Connection conn){
		try {
			// Execute a prepared statement to retrieve data
			PreparedStatement stmt = conn.prepareStatement("SELECT * from source_code;");
//			PreparedStatement stmt_rate = conn.prepareStatement("select * from rate_class;");

			ResultSet rs = stmt.executeQuery();
			List<SourceCode> allRows = new ArrayList<SourceCode>();
			while (rs.next()) {
				SourceCode oc = new SourceCode();
				allRows.add(oc);
	        }
			return allRows;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	
	List<PaymentType> fetchPaymentType(Connection conn){
		try {
			// Execute a prepared statement to retrieve data
			PreparedStatement stmt = conn.prepareStatement("select * from payment_type;");
//			PreparedStatement stmt_rate = conn.prepareStatement("select * from rate_class;");

			ResultSet rs = stmt.executeQuery();
//			rs.setFetchSize(100);
			// Set fetch size to retrieve 100 rows at a time
	        List<PaymentType> allRows = new ArrayList<PaymentType>();
			while (rs.next()) {
				PaymentType oc = new PaymentType();
				oc.setPaymentType(rs.getString("payment_type"));
				oc.setDescription(rs.getString("description"));
				switch(rs.getString("payment_form")) {//form of payment: credit card, cash, ... 0 N/A 1 Credit Card 2 Cash 3 Check 4 Direct Debit 5 Credit Applied 6 Online Wallet 7 Gift Card 
				case "0": oc.setPaymentForm("N/A");
				break;
				case "1": oc.setPaymentForm("Credit Card");
				break;
				case "2": oc.setPaymentForm("Cash");
				break;
				case "3": oc.setPaymentForm("Check");
				break;
				case "4": oc.setPaymentForm("Direct Debit");
				break;
				case "5": oc.setPaymentForm("Credit Applied");
				break;
				case "6": oc.setPaymentForm("Online Wallet");
				break;
				case "7": oc.setPaymentForm("Gift Card");
				break;
				default: oc.setPaymentForm(null);
				}
				
				oc.setRealiseCashWhen(rs.getString("realize_cash_when"));
				oc.setUseAsDefault(rs.getBoolean("use_as_default"));
				switch(rs.getString("credit_card_type")) {//0 N/A 1 Visa 2 MasterCard 3 American Express 4 Discover 5 Other 6 Solo 7 Switch 8 Value-Link 
				case "0": oc.setCreditCardType("N/A");
				break;
				case "1": oc.setCreditCardType("Visa");
				break;
				case "2": oc.setCreditCardType("MasterCard");
				break;
				case "3": oc.setCreditCardType("American Exxpress");
				break;
				case "4": oc.setCreditCardType("Discover");
				break;
				case "5": oc.setCreditCardType("Other");
				break;
				case "6": oc.setCreditCardType("Solo");
				break;
				case "7": oc.setCreditCardType("Switch");
				break;
				case "8": oc.setCreditCardType("Value-Link");
				break;
				default: oc.setCreditCardType(null);
				}
				oc.setCvv(null);
				oc.setPublisher(pub);
	        	allRows.add(oc);
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

	List<LableFormat> fetchLabelFormat(Connection conn){
		try {
			// Execute a prepared statement to retrieve data
			PreparedStatement stmt = conn.prepareStatement("select * from label_format;");
//			PreparedStatement stmt = conn.prepareStatement("select * from rate_class;");

			ResultSet rs = stmt.executeQuery();
//			rs.setFetchSize(6000);
			// Set fetch size to retrieve 100 rows at a time
	        List<LableFormat> allRows = new ArrayList<LableFormat>();
			while (rs.next()) {
				LableFormat LF = new LableFormat();
				LF.setPubId(pub);
				LF.setLableFormat(rs.getString("label_format"));
				LF.setDescription(rs.getString("description"));
	        	allRows.add(LF);
	        }
			return allRows;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	
	List<LableGroup> fetchLableGroup(Connection conn){
		try {
			// Execute a prepared statement to retrieve data
			PreparedStatement stmt = conn.prepareStatement("select * from label_group;");
//			PreparedStatement stmt = conn.prepareStatement("select * from rate_class;");

			ResultSet rs = stmt.executeQuery();
//			rs.setFetchSize(6000);
			// Set fetch size to retrieve 100 rows at a time
	        List<LableGroup> allRows = new ArrayList<LableGroup>();
			while (rs.next()) {
				LableGroup LG = new LableGroup();
				LG.setPubId(pub);
				LG.setLableGroups(rs.getString("lable_group"));
				LG.setDescription(rs.getString("description"));
	        	allRows.add(LG);
	        }
			return allRows;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	List<LableKeyLine> fetchLabelKeyLine(Connection conn){
		try {
			// Execute a prepared statement to retrieve data
			PreparedStatement stmt = conn.prepareStatement("select * from label_keyline;");
//			PreparedStatement stmt = conn.prepareStatement("select * from rate_class;");

			ResultSet rs = stmt.executeQuery();
//			rs.setFetchSize(6000);
			// Set fetch size to retrieve 100 rows at a time
	        List<LableKeyLine> allRows = new ArrayList<LableKeyLine>();
			while (rs.next()) {
				LableKeyLine LF = new LableKeyLine();
				LF.setPubId(pub);
				LF.setLabelKeyline(rs.getString("label_keyline"));
				LF.setSuppressflag(rs.getBoolean("suppress_flag"));
				LF.setDescription(rs.getString("description"));
				LF.setCurrentIssue(null);
				LF.setCurrentVolume(null);
				LF.setText(null);
	        	allRows.add(LF);
	        }
			return allRows;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	
	List<LableFormatGroups> fetchLabelFormatGroups(Connection conn){
		try {
			// Execute a prepared statement to retrieve data
			PreparedStatement stmt = conn.prepareStatement("select * from label_format_detail;");
//			PreparedStatement stmt = conn.prepareStatement("select * from rate_class;");

			ResultSet rs = stmt.executeQuery();
//			rs.setFetchSize(6000);
			// Set fetch size to retrieve 100 rows at a time
	        List<LableFormatGroups> allRows = new ArrayList<LableFormatGroups>();
			while (rs.next()) {
				LableFormatGroups LFG = new LableFormatGroups();
				LFG.setPubId(pub);
				LableFormat LF = new LableFormat();
				LF = LFRepo.findById(rs.getInt("label_format")).get();
				LableGroup LG = new LableGroup();
				LG = LGRepo.findById(rs.getInt("label_group")).get();
				LFG.setLableFormat(LF);
				LFG.setDescription(null);
				LFG.setLablegroup(LG);
	        	allRows.add(LFG);
	        }
			return allRows;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	
	List<ProfitCenter> fetchProfitCenter(Connection conn){
		try {
			// Execute a prepared statement to retrieve data
			PreparedStatement stmt = conn.prepareStatement("select * from profit_center;");
//			PreparedStatement stmt = conn.prepareStatement("select * from rate_class;");

			ResultSet rs = stmt.executeQuery();
//			rs.setFetchSize(6000);
			// Set fetch size to retrieve 100 rows at a time
	        List<ProfitCenter> allRows = new ArrayList<ProfitCenter>();
			while (rs.next()) {
				ProfitCenter LFG = new ProfitCenter();
				LFG.setPubId(pub);
				LFG.setProfitDescription(rs.getString("description"));
				LFG.setProfitCenter(rs.getString("profit_center"));
				LFG.setInclTaxLiab(rs.getInt("incl_tax_liab"));
				LFG.setInclDelLiab(rs.getInt("incl_del_liab"));
				LFG.setInclComLiab(rs.getInt("incl_com_liab"));
				LFG.setInclComAr(rs.getInt("incl_com_ar"));
				LFG.setInclDelAr(rs.getInt("incl_del_ar"));
				LFG.setInclTaxAr(rs.getInt("incl_tax_ar"));
	        	allRows.add(LFG);
	        }
			return allRows;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	
}
