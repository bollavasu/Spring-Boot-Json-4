package com.journaldev.spring;

import java.io.FileReader;
import java.io.FileWriter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@RestController
public class PersonController {
	
	@RequestMapping("/")
	public String healthCheck() {
		jsonRead();
		jsonReadFile();
		writeJson();
		writeJsonFile();
		return "Converted Successfully...";
	}
	
	public void jsonRead() {
		try {
			 String jsonStr = "{\"name\":\"Peter\",\"sal\":\"20000\",\"age\":\"25\",\"address\":\"Hyderabad\",\"phoneNumber\":\"9000080000\"}";	
			 JSONParser parser = new JSONParser();
			 JSONObject json = (JSONObject) parser.parse(jsonStr);				 
			 System.out.println("JSON String : " + json);
		}catch (Exception e) {
	        e.printStackTrace();
	    }	
	}
	
	public void jsonReadFile() {
		try (FileReader reader = new FileReader("C:\\Input\\Person.json")) {
			 JSONParser parser = new JSONParser();
			 JSONObject json = (JSONObject) parser.parse(reader);				 
			 System.out.println("JSON String from file : " + json);
		}catch (Exception e) {
	        e.printStackTrace();
	    }	
	}
	
	public void writeJson() {
		try {
			JSONObject employeeDetails = new JSONObject();
	        employeeDetails.put("firstName", "Lokesh");
	        employeeDetails.put("lastName", "Gupta");
	        employeeDetails.put("website", "howtodoinjava.com");
	         
	        JSONObject employeeObject = new JSONObject();
	        employeeObject.put("employee", employeeDetails);
	         
	        //Second Employee
	        JSONObject employeeDetails2 = new JSONObject();
	        employeeDetails2.put("firstName", "Brian");
	        employeeDetails2.put("lastName", "Schultz");
	        employeeDetails2.put("website", "example.com");
	         
	        JSONObject employeeObject2 = new JSONObject();
	        employeeObject2.put("employee", employeeDetails2);
	         
	        //Add employees to list
	        JSONArray employeeList = new JSONArray();
	        employeeList.add(employeeObject);
	        employeeList.add(employeeObject2);
	        System.out.println("Employee JSON String 1 : " + employeeList);
	        System.out.println("Employee JSON String 2 : " + employeeList.toString());
	        System.out.println("Employee JSON String 3 : " + employeeList.toJSONString());
		}catch (Exception e) {
	        e.printStackTrace();
	    }	
	}
		
	public void writeJsonFile() {
		//First Employee
        JSONObject employeeDetails = new JSONObject();
        employeeDetails.put("firstName", "Lokesh");
        employeeDetails.put("lastName", "Gupta");
        employeeDetails.put("website", "howtodoinjava.com");
         
        JSONObject employeeObject = new JSONObject();
        employeeObject.put("employee", employeeDetails);
         
        //Second Employee
        JSONObject employeeDetails2 = new JSONObject();
        employeeDetails2.put("firstName", "Brian");
        employeeDetails2.put("lastName", "Schultz");
        employeeDetails2.put("website", "example.com");
         
        JSONObject employeeObject2 = new JSONObject();
        employeeObject2.put("employee", employeeDetails2);
         
        //Add employees to list
        JSONArray employeeList = new JSONArray();
        employeeList.add(employeeObject);
        employeeList.add(employeeObject2);
         
        //Write JSON file
        try (FileWriter file = new FileWriter("C:\\Output\\Employee.json")) {
 
            file.write(employeeList.toJSONString());
            file.flush();
 
        } catch (Exception e) {
            e.printStackTrace();
        }	
	}
}
