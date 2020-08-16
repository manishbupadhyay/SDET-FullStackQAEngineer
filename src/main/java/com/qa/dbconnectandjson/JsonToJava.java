package com.qa.dbconnectandjson;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToJava {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, JsonGenerationException, JsonMappingException, IOException {
		
	    ArrayList<CustomerDetails> arrayList = new ArrayList<CustomerDetails>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Business", "root", "Aadi@4417");
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from CustomerInfo where Location='Asia' and PurchasedDate=curdate();");
		while(resultSet.next()) {
			//System.out.println(resultSet.getString(1)+"  "+resultSet.getString(2)+"  "+resultSet.getInt(3) +"  "+ resultSet.getString(4));
			
			// create object of CustomerDetails class
			CustomerDetails customerDetails = new CustomerDetails();
			customerDetails.setCourseName(resultSet.getString(1));
			customerDetails.setPurchasedDate(resultSet.getString(2));
			customerDetails.setAmount(resultSet.getInt(3));
			customerDetails.setLocation(resultSet.getString(4));
			
			/*
			 * System.out.println(customerDetails.getCourseName());
			 * System.out.println(customerDetails.getPurchasedDate());
			 * System.out.println(customerDetails.getAmount());
			 * System.out.println(customerDetails.getLocation());
			 */
			
			arrayList.add(customerDetails);
		}
		
		// create object ObjectMapper class
		// convert java object to Json file using Jackon api
		for(int i=0; i<arrayList.size(); i++) {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.writeValue(new File("/JavaDatabaseConnectivity/customerInfo"+i+".json"), arrayList.get(i));
		}
		
		connection.close();
	}

}
