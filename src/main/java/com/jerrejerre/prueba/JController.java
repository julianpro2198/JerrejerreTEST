package com.jerrejerre.prueba;

import java.util.List;
import java.util.Random;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
@Controller
public class JController {
	
	public String passgenerator() {
		
		 int leftLimit = 48; // numeral '0'
		    int rightLimit = 122; // letter 'z'
		    int targetStringLength = 10;
		    Random random = new Random();
		 
		    String generatedString = random.ints(leftLimit, rightLimit + 1)
		      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
		      .limit(targetStringLength)
		      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
		      .toString();
		
		return generatedString;
	}
	
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	@Autowired
	private CompanyRepository companyRepository;
	
	
	
	
	 @PostMapping("/users/c")
	  public String createUser(@RequestBody Customer customer) {
		customer.setPassword(passgenerator());
		
		JSONObject item = new JSONObject();
		
		
		try {
			if(customer.getName().equals("") || customer.getName().length()>120 || customer.getEmail().equals("") || customer.getEmail().length()>120) {
				item.put("cod", "500");
				item.put("message", "error");
			}
			else {
				customerRepository.save(customer);
				item.put("cod", "200");
				item.put("message", "exito");
			}
		}
		catch(Exception e){
			item.put("cod", "500");
			item.put("message", "error");
			
		}
		
		
		return item.toString();
		
	   
	  } 
	 
	 
	
	@GetMapping("/users")
	  public List<Customer> getAllUsers() {
	    return (List<Customer>) customerRepository.findAll();
	  }
	
	
	
	@PostMapping("/companies")
	  public String createCompany(@RequestBody Company company) throws JSONException {
		
		
		JSONObject item = new JSONObject();
			
		try {
			if(company.getName().equals("") || company.getName().length()>120 || company.getNit().equals("") || company.getNit().length()>12) {
				item.put("cod", "500");
				item.put("message", "error");
			}
			else {
				companyRepository.save(company);
				item.put("cod", "200");
				item.put("message", "exito");
			}
		}
		catch(Exception e){
			item.put("cod", "500");
			item.put("message", "error");
			
		}
			
		
			
			return item.toString();
	
	}
	
	
	/*
	 * 	@PostMapping("/companies")
	  public Company createCompany(@RequestBody Company company) {
		
	
			return companyRepository.save(company);
	
	}
	 */
	
	
	
	
}
