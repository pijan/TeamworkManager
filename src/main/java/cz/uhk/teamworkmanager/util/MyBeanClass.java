package cz.uhk.teamworkmanager.util;

/*
 * 
 * 
 * TESTOVACÍ TŘÍDA
 * 
 * 
 */

public class MyBeanClass {

	String abc;
	
	private MyBeanClass(){
	}

	public String getAbc() {
		return abc;
	}

	public void setAbc(String abc) {
		this.abc = abc;
		System.out.println("nastavení beany s this.abc="+abc);
	}
	
	
	
}
