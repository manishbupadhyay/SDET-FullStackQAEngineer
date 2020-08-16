package com.qa.dbconnectandjson;
import java.io.File;
import java.io.IOException;

import org.omg.CORBA.ObjectHolder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExtractJson {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		// convert json file to java object
		ObjectMapper objectMapper = new ObjectMapper();
		CustomerDetailsAppium customerDetailsAppium = objectMapper.readValue(new File("/JavaDatabaseConnectivity/customerInfo0.json"), CustomerDetailsAppium.class);
		System.out.println(customerDetailsAppium.getCourseName());
	}

}
