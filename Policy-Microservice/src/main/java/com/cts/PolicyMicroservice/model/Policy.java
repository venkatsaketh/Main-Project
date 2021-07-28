package com.cts.PolicyMicroservice.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Policy 
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int p_id;
   private String benefits;
   private int premium;
   private int tenure;
   
   
   @ManyToMany(fetch = FetchType.LAZY,
           cascade = {
               CascadeType.PERSIST,
               CascadeType.MERGE,
               CascadeType.ALL
           })
   @JoinTable(name = "provider_policy",
   joinColumns = @JoinColumn(name = "prp_p_id"),
   inverseJoinColumns = @JoinColumn(name = "prp_pr_id"))
   private Set<Provider> providerList =  new HashSet<>();

public Set<Provider> getProviderList() {
	return providerList;
}
public void setProviderList(Set<Provider> providerList) {
	this.providerList = providerList;
}
public int getP_id() {
	return p_id;
}
public void setP_id(int p_id) {
	this.p_id = p_id;
}
public String getBenefits() {
	return benefits;
}
public void setBenefits(String benefits) {
	this.benefits = benefits;
}
public int getPremium() {
	return premium;
}
public void setPremium(int premium) {
	this.premium = premium;
}
public int getTenure() {
	return tenure;
}
public void setTenure(int tenure) {
	this.tenure = tenure;
}
public Policy(int p_id, String benefits, int premium, int tenure) {
	super();
	this.p_id = p_id;
	this.benefits = benefits;
	this.premium = premium;
	this.tenure = tenure;
}
public Policy() {
	super();
}
   
}
