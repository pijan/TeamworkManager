package cz.uhk.teamworkmanager.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "events" )
public class Event extends BaseEntity {

	/*
	 * Třída pro událost v kalendáři
	 * 
	 * TODO anotace pro hibernate
	 * TODO změna owner na User class
	 * 
	 */
	
	String name;
	String owner;
	String text;
	String calendarDate;
	String calendarTime;
	String labels;
	
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
