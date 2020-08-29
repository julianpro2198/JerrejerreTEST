package com.jerrejerre.prueba;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Company {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
  
  @Column(nullable = false)
  private String name;
  
  @Column(nullable = false)
  private String Nit;
  
  
  
  @OneToMany(mappedBy = "company")
  private List<Customer> customers;


  protected Company() {}

  public Company(String name) {
    this.name = name;
  }

  @Override

	  
	  public String toString() {
		    return "Company {" + "id=" + this.id + ", name='" + this.name + ", Nit='" + this.Nit + "'}";

  }

  public Long getId() {
    return id;
  }
  
  public void setId(long id) {
      this.id = id;
  }
  
  public void setName(String name) {
      this.name = name;
  }
  
  public void setNit(String Nit) {
      this.Nit = Nit;
  }
  
  
  public String getNit() {
	  return Nit;
  }
  

  public String getName() {
    return name;
  }
}