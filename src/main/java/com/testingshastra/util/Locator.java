package com.testingshastra.util;

import static com.testingshastra.util.PropertiesFile.getObject;
public class Locator {
	
	public static final String  SIGNUP_FULLNAME = getObject("signup.fullname");
	public static final String  SIGNUP_COMPANYNAME = getObject("signup.companyname"); 
	public static final String  SIGNUP_EMAIL = getObject("signup.email"); 
	public static final String  SIGNUP_CONTACT = getObject("signup.contact"); 
	public static final String  SIGNUP_PASSWORD = getObject("signup.password"); 
	public static final String  SIGNUP_IAMNOTROBOT = getObject("signup.Iamrobot");
	
}

