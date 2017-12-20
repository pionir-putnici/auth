package com.hellokoding.auth.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CompanyDetails {

	public final String companyDetails1="My Company";
	public final String companyDetails2="Adress";
	public final String companyDetails3="City";
	
	public CompanyDetails() {

	}

	public String getCompanyDetails1() {
		return companyDetails1;
	}

	public String getCompanyDetails2() {
		return companyDetails2;
	}

	public String getCompanyDetails3() {
		return companyDetails3;
	}



}