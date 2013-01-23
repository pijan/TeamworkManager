package cz.uhk.teamworkmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "users" )
public class User extends BaseEntity {
	
	/*
	 * Třída obsahující základní informace o uživateli
	 * 
	 * TODO dořešit projectGroup, permissions, ...
	 * 
	 */

	String name;
	String login;
	String password;
	int permissions;
	int projectGroup;
	String lastLogin;
	String email;
	
	public User(){
		
	}
	
	public User(String name){
		this.name = name;
	}
	
	public User(String name, String login, String password, int permissions, int projectGroup, String email){
		this.name = name;
		this.login = login;
		this.password = password;
		this.permissions = permissions;
		this.projectGroup = projectGroup;
		this.email = email;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPermissions() {
		return permissions;
	}
	public void setPermissions(int permissions) {
		this.permissions = permissions;
	}
	public int getProjectGroup() {
		return projectGroup;
	}
	public void setProjectGroup(int projectGroup) {
		this.projectGroup = projectGroup;
	}
	public String getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString(){
		return "User ID: " 
				+ this.getId() + ", " 
				+ this.getName() + ", "
				+ this.getLogin() + ", "
				+ this.getPassword() + ", "
				+ this.getPermissions() + ", "
				+ this.getProjectGroup() + ", "
				+ this.getLastLogin() + ", "
				+ this.getEmail() + "\n";
	}
	
}
