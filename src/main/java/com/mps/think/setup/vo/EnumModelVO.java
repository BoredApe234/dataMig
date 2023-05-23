package com.mps.think.setup.vo;

public class EnumModelVO {
	public static enum Currency {

		USD("USD"), INR("INR"), POUND("POUND"), EURO("EURO"), CAD("CAD");

		private final String displayCurrency;

		Currency(String displayCurrency) {
			this.displayCurrency = displayCurrency;
		}

		public String getDisplayName() {
			return displayCurrency;
		}
	}

	public static enum DateFormat {

		MMDDYY("MMDDYY"), DDMMYY("DDMMYY"), YYMMDD("YYMMDD");

		private final String displayDateFormat;

		DateFormat(String displayDateFormat) {
			this.displayDateFormat = displayDateFormat;
		}

		public String getDisplayName() {
			return displayDateFormat;
		}
	}

	public static enum TimeZone {

		IST("IST"), AEST("AEST"), ACST("ACST"), AWST("AWST"), PDT("PDT"), MST("MST"), MDT("MDT"), CST("CST"),
		CDT("CDT"), EST("EST"), EDT("EDT"), AST("AST"), ADT("ADT"), NDT("NDT"), BST("BST"), HST("HST"), HDT("HDT"),
		AKDT("AKDT");

		private final String displayTimeZone;

		TimeZone(String displayTimeZone) {
			this.displayTimeZone = displayTimeZone;
		}

		public String getDisplayName() {
			return displayTimeZone;
		}
	}

	public static enum SubDefStatus {

		ACTIVE("ACTIVE"), INACTIVE("INACTIVE");

		private final String status;

		private SubDefStatus(String status) {
			this.status = status;
		}

		public String getStatus() {
			return status;
		}

	}

	public static enum StartType {

		ANYTIME_START("ANYTIME START"), VOLUME_GROUP_START("VOLUME GROUP START"),
		DATE_BASED_WITH_ISSUES("DATE BASED WITH ISSUES"), DATE_BASED_WITH_NO_ISSUES("DATE BASED WITH NO ISSUES"),
		DATE_BASED_WITH_UNITS("DATE BASED WITH UNITS"), UNIT_BASED_NO_TIME("UNIT BASED NO TIME"), ANY("ANY");

		private final String displayStartType;

		StartType(String displayStartType) {
			this.displayStartType = displayStartType;
		}

		public String getDisplayName() {
			return displayStartType;
		}
	}

	public static enum InstallmentTerm {

		MONTHLY("MONTHLY"), YEARLY("YEARLY"), HALF_YEARLY("HALF YEARLY");

		private final String displayInstallmentTerm;

		InstallmentTerm(String displayInstallmentTerm) {
			this.displayInstallmentTerm = displayInstallmentTerm;
		}

		public String getDisplayName() {
			return displayInstallmentTerm;
		}
	}

	public static enum Source_code_type {

		Zero("Basic"), One("Package"), Two("Dual"), Three("Catalog"), four("Generic"), five("Shipping");

		private String displayName;

		Source_code_type(String displayName) {
			this.displayName = displayName;
		}

		public String displayName() {
			return displayName;
		}

		@Override
		public String toString() {
			return displayName;
		}
	}

	public static enum AddressType {

		Business("Business"), Residential("Residential"), Other("Other");

		private final String displayAddressType;

		AddressType(String displayAddressType) {
			this.displayAddressType = displayAddressType;
		}

		public String getDisplayName() {
			return displayAddressType;
		}

	}

	public static enum AddressCategory {

		ShippingAddress("Shipping Address"), BillingAddress("Billing Address"), RenewalAddress("Renewal Address"),
		AlternateAddress("Alternate Address");

		private final String displayAddressCategory;

		AddressCategory(String displayAddressCategory) {
			this.displayAddressCategory = displayAddressCategory;
		}

		public String getDisplayName() {
			return displayAddressCategory;
		}

	}

	public static enum Frequency {

		EveryYear("Every Year"), None("None");

		private final String displayFrequency;

		Frequency(String displayFrequency) {
			this.displayFrequency = displayFrequency;
		}

		public String getDisplayName() {
			return displayFrequency;
		}

	}

	public static enum CustomerCategory {

		Agency("Agency"), Individual("Individual"), Institutional("Institutional");

		private final String displayCustomerCategory;

		CustomerCategory(String displayCustomerCategory) {
			this.displayCustomerCategory = displayCustomerCategory;
		}

		public String getDisplayName() {
			return displayCustomerCategory;
		}

	}

	public static enum ConfigurationOptionsforOrders {

		BundleDiscounts("Bundle Discounts"), BillToAgency("Bill to Agency"), RenewToAgency("Renew to Agency");

		private final String displayConfigurationOptionsforOrders;

		ConfigurationOptionsforOrders(String displayConfigurationOptionsforOrders) {
			this.displayConfigurationOptionsforOrders = displayConfigurationOptionsforOrders;
		}

		public String getDisplayName() {
			return displayConfigurationOptionsforOrders;
		}

	}

	public static enum PaymentOptions {

		PayCommissionToAgency("Pay Commission to Agency"), AgencyRemitsNetPayment("Agency Remits Net Payment");

		private final String displayPaymentOptions;

		PaymentOptions(String displayPaymentOptions) {
			this.displayPaymentOptions = displayPaymentOptions;
		}

		public String getDisplayName() {
			return displayPaymentOptions;
		}

	}

	public static enum ChargeTaxOn {

		AgencyPaysTax("Agency Pays Tax"), TaxChargedOnGross("Tax Charged On Gross"),
		TaxChargedOnNet("Tax Charged On Net");

		private final String displayChargeTaxOn;

		ChargeTaxOn(String displayChargeTaxOn) {
			this.displayChargeTaxOn = displayChargeTaxOn;
		}

		public String getDisplayName() {
			return displayChargeTaxOn;
		}

	}

	public static enum PaymentStatus {

		Pending("Pending"), Completed("Completed"), Cancelled("Cancelled");

		private final String displaypaymentStatus;

		PaymentStatus(String displaypaymentStatus) {
			this.displaypaymentStatus = displaypaymentStatus;
		}

		public String getDisplayName() {
			return displaypaymentStatus;
		}
	}

	public static enum OrderStatus {

		Active("Active"), Cancelled("Cancelled"), Pending("Pending");

		private final String displayOrderStatus;

		OrderStatus(String displayOrderStatus) {
			this.displayOrderStatus = displayOrderStatus;
		}

		public String getDisplayName() {
			return displayOrderStatus;
		}
	}

	public static enum OrderType {

		SingleCopyOrder("Single Copy Order"), BasicPackageOrder("Basic Package Order"),
		DateBasedSubscriptionOrder("Date Based Order"), IssueBasedSubscriptionOrder("Issue Based Subscription Order");

		private final String displayOrderType;

		OrderType(String displayOrderType) {
			this.displayOrderType = displayOrderType;
		}

		public String getDisplayName() {
			return displayOrderType;
		}
	}

	public static enum ItemType {

		Issue("Issue"), Day("Day");

		private final String displayItemType;

		ItemType(String displayItemType) {
			this.displayItemType = displayItemType;
		}

		public String getDisplayName() {
			return displayItemType;
		}
	}

	public static enum Status {

		Active("Active"), Inactive("Inactive");

		private final String displayStatus;

		Status(String displayStatus) {
			this.displayStatus = displayStatus;
		}

		public String getDisplayName() {
			return displayStatus;
		}
	}

	public static enum RefundTo {

		One("Original Source"), Two("Deposit Account"), Three("Payment Account"), Four("Others");

		private final String displayRefundTo;

		RefundTo(String displayRefundTo) {
			this.displayRefundTo = displayRefundTo;
		}

		public String getDisplayName() {
			return displayRefundTo;
		}
	}

	public static enum CustomerStatus {
		Active("Active"), Inactive("Inactive"), Hold("Hold");

		private final String customerStatus;

		CustomerStatus(String customerStatus) {
			this.customerStatus = customerStatus;
		}

		public String getCustomerStatus() {
			return customerStatus;
		}
	}
	
	public static enum RealiseCashWhen {
		
		AUTHORISED("Authorised"), CLEARED("Cleared");
		
		private final String realiseCash;

		RealiseCashWhen(String realiseCash) {
			this.realiseCash = realiseCash;
		}

		public String getRealiseCash() {
			return realiseCash;
		}
		
	}
	
	public static enum CVVValues {
		
		NOTREQUIRED("Not Required"), REQUIRED("Required");
		private final String cvv;
		
		CVVValues(String cvv) {
			this.cvv = cvv;
		}
		public String getCvv() {
			return cvv;
		}
	
	}

}
