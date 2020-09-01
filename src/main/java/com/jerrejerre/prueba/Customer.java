package com.jerrejerre.prueba;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Customer {
		


  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private String name;
  private String email;
  private String password;
  

  @ManyToOne
  @JoinColumn(name="company_id")
  private Company company;
  
  protected Customer() {}

  public Customer(String name, String email) {
    this.name = name;
    this.email = email;
  }

  @Override
  public String toString() {
	    return "Customer {" + "id=" + this.id + ", email='" + this.email + ", pass='" + this.password + " company='" +this.company+ "' }";

  }
  
  
  public void setPassword(String password) {
      this.password = password;
  }
  

  public String getPassword() {
	  return this.password;
  }
  
 
  public String getCompany() {
	  
	  return this.company.getName();
	
  }
  
 public String getCompanyNit() {
	  
	  return this.company.getNit();
	
  }
  
  public void setCompany(Company company) {
	  this.company=company;
  }

  
  
  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }
}