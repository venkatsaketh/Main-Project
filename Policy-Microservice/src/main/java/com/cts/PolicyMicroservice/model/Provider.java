package com.cts.PolicyMicroservice.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Provider 
{
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int pr_id;
	 private String name;
	 private String location;
	 
	 @JsonIgnore
	 @ManyToMany(fetch = FetchType.LAZY,
	            cascade = {
	                CascadeType.PERSIST,
	                CascadeType.MERGE,
	                CascadeType.ALL
	            },mappedBy = "providerList")
	private Set<Policy> policyList = new HashSet<>();
	 
	 
	public Set<Policy> getPolicyList() {
		return policyList;
	}
	public void setPolicyList(Set<Policy> policyList) {
		this.policyList = policyList;
	}
	public int getPr_id() {
		return pr_id;
	}
	public Provider() {
		super();
	}
	public Provider(int pr_id, String name, String location) {
		super();
		this.pr_id = pr_id;
		this.name = name;
		this.location = location;
		
	}
	public void setPr_id(int pr_id) {
		this.pr_id = pr_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	 
}
