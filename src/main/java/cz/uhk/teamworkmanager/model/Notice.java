package cz.uhk.teamworkmanager.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "notes" )
public class Notice extends BaseEntity{

	/*
	 * Třída pro poznámky
	 * 
	 * TODO anotace pro Hibernate
	 * TODO změna owner na User class
	 * 
	 */
	
	String name;
	String owner;
	String text;
	Boolean isCalendar;
	String calendarDate;
	String calendarTime;
	String labels;
	
	public Notice(String text) {
		this.text = text;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Boolean getIsCalendar() {
		return isCalendar;
	}
	public void setIsCalendar(Boolean isCalendar) {
		this.isCalendar = isCalendar;
	}
	public String getCalendarDate() {
		return calendarDate;
	}
	public void setCalendarDate(String calendarDate) {
		this.calendarDate = calendarDate;
	}
	public String getCalendarTime() {
		return calendarTime;
	}
	public void setCalendarTime(String calendarTime) {
		this.calendarTime = calendarTime;
	}
	public String getLabels() {
		return labels;
	}
	public void setLabels(String labels) {
		this.labels = labels;
	}
	
}
