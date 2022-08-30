package utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jdbcdemo.reports.dto.Customer;
import com.jdbcdemo.reports.dto.EmployeeReportData;
import com.jdbcdemo.reports.dto.ReceiptItem;

public class ReportDataSetter {

	public static Map<String, Object> createReportData() {
		Map<String, Object> data = new HashMap<>();
		Customer customer = new Customer();
		customer.setCompanyName("Simple Solution");
		customer.setContactName("John Doe");
		customer.setAddress("123, Simple Street");
		customer.setEmail("contact@simplesolution.dev");
		customer.setPhone("123 456 789");
		data.put("customer", customer);

		List<ReceiptItem> receiptItems = new ArrayList<>();
		ReceiptItem receiptItem1 = new ReceiptItem();
		receiptItem1.setDescription("Test Item 1");
		receiptItem1.setQuantity(1);
		receiptItem1.setUnitPrice(100.0);
		receiptItem1.setTotal(100.0);
		receiptItems.add(receiptItem1);

		ReceiptItem receiptItem2 = new ReceiptItem();
		receiptItem2.setDescription("Test Item 2");
		receiptItem2.setQuantity(4);
		receiptItem2.setUnitPrice(500.0);
		receiptItem2.setTotal(2000.0);
		receiptItems.add(receiptItem2);

		ReceiptItem receiptItem3 = new ReceiptItem();
		receiptItem3.setDescription("Test Item 3");
		receiptItem3.setQuantity(2);
		receiptItem3.setUnitPrice(200.0);
		receiptItem3.setTotal(400.0);
		receiptItems.add(receiptItem3);

		data.put("receiptItems", receiptItems);
		return data;
	}
	
	public static Map<String, Object> createOrderData(Map<String, Object> orderData) {
		Map<String, Object> data = new HashMap<>();
		
		
		Customer customer = new Customer();
		customer.setCompanyName("Junaid Solutions");
		customer.setContactName("Junaid Khan");
		customer.setAddress("123, Simple Street");
		customer.setEmail("contact@simplesolution.dev");
		customer.setPhone("123 456 789");
		data.put("customer", customer);
		
		List<Map> productDetails = (List<Map>)orderData.get("productDetails");
		List<ReceiptItem> receiptItems = new ArrayList<>();
		for(Map productMap:productDetails) {
			Integer quantity=Integer.parseInt((String)productMap.get("Quantity"));
			Double unitPrice=Double.parseDouble((String)productMap.get("Gross Price"));
			Double totalValue=Double.parseDouble((String)productMap.get("Net Price"));
			
		
			ReceiptItem receiptItem1 = new ReceiptItem();
			
			receiptItem1.setDescription((String)productMap.get("Product Name"));
			receiptItem1.setQuantity(quantity);
			receiptItem1.setUnitPrice(unitPrice);
			receiptItem1.setTotal(totalValue);
			receiptItems.add(receiptItem1);
			
		}

		/*
		 * List<ReceiptItem> receiptItems = new ArrayList<>(); ReceiptItem receiptItem1
		 * = new ReceiptItem(); receiptItem1.setDescription("Test Item 1");
		 * receiptItem1.setQuantity(1); receiptItem1.setUnitPrice(100.0);
		 * receiptItem1.setTotal(100.0); receiptItems.add(receiptItem1);
		 * 
		 * ReceiptItem receiptItem2 = new ReceiptItem();
		 * receiptItem2.setDescription("Test Item 2"); receiptItem2.setQuantity(4);
		 * receiptItem2.setUnitPrice(500.0); receiptItem2.setTotal(2000.0);
		 * receiptItems.add(receiptItem2);
		 * 
		 * ReceiptItem receiptItem3 = new ReceiptItem();
		 * receiptItem3.setDescription("Test Item 3"); receiptItem3.setQuantity(2);
		 * receiptItem3.setUnitPrice(200.0); receiptItem3.setTotal(400.0);
		 * receiptItems.add(receiptItem3);
		 */

		data.put("receiptItems", receiptItems);
		return data;
	}
	
	public static Map<String, Object> createEmployeeData(Map<String, Object> orderData) {
		Map<String, Object> data = new HashMap<>();
		
		
		Customer customer = new Customer();
		customer.setCompanyName("Junaid Solutions");
		customer.setContactName("Junaid Khan");
		customer.setAddress("123, Simple Street");
		customer.setEmail("contact@simplesolution.dev");
		customer.setPhone("123 456 789");
		data.put("customer", customer);
		
		List<Map> productDetails = (List<Map>)orderData.get("ordersList");
		List<EmployeeReportData> employeeReportData = new ArrayList<>();
		for(Map employeeMap:productDetails) {
			Double gst=Double.parseDouble((String)employeeMap.get("gst"));
			Double grossAmount=Double.parseDouble((String)employeeMap.get("Gross Amount"));
			Double netAmount=Double.parseDouble((String)employeeMap.get("Net Amount"));
			
		
			EmployeeReportData employeeData = new EmployeeReportData();
			
			employeeData.setOrderNumber((String)employeeMap.get("Order Number"));
			employeeData.setOrderData((String)employeeMap.get("Order Date"));
			employeeData.setStatus((String)employeeMap.get("Status"));
			employeeData.setCustomerCode((String)employeeMap.get("Customer Code"));
			employeeData.setGrossAmount(grossAmount);
			employeeData.setNetAmount(netAmount);
			employeeData.setGst(gst);
			employeeReportData.add(employeeData);
			
		}

		/*
		 * List<ReceiptItem> receiptItems = new ArrayList<>(); ReceiptItem receiptItem1
		 * = new ReceiptItem(); receiptItem1.setDescription("Test Item 1");
		 * receiptItem1.setQuantity(1); receiptItem1.setUnitPrice(100.0);
		 * receiptItem1.setTotal(100.0); receiptItems.add(receiptItem1);
		 * 
		 * ReceiptItem receiptItem2 = new ReceiptItem();
		 * receiptItem2.setDescription("Test Item 2"); receiptItem2.setQuantity(4);
		 * receiptItem2.setUnitPrice(500.0); receiptItem2.setTotal(2000.0);
		 * receiptItems.add(receiptItem2);
		 * 
		 * ReceiptItem receiptItem3 = new ReceiptItem();
		 * receiptItem3.setDescription("Test Item 3"); receiptItem3.setQuantity(2);
		 * receiptItem3.setUnitPrice(200.0); receiptItem3.setTotal(400.0);
		 * receiptItems.add(receiptItem3);
		 */

		data.put("reportItems", employeeReportData);
		return data;
	}
}
