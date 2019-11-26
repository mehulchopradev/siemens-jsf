package com.abc.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.abc.domain.Country;

@ApplicationScoped
@ManagedBean(name="cb", eager=true)
public class CountryBean {
	private List<Country> countries;
	private HashMap<String, String> countriesMap;

	public CountryBean() {
		// imagine code written here to get the list of countries from database
		System.out.println("Getting countries from the dataase");
		this.countries = new ArrayList<>();
		this.countries.add(new Country("IN", "India"));
		this.countries.add(new Country("USA", "United states of america"));
		this.countries.add(new Country("AU", "Australia"));
		
		countriesMap = new LinkedHashMap<>();
		countriesMap.put("India", "IN");
		countriesMap.put("China", "CH");
	}
	
	public List<Country> getCountries() {
		return countries;
	}
	
	public HashMap<String, String> getCountriesMap() {
		return countriesMap;
	}
}
