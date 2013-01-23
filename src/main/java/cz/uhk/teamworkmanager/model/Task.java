package cz.uhk.teamworkmanager.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "tasks" )
public class Task extends BaseEntity {

	/*
	 * Třída pro úkoly
	 * 
	 * TODO anotace pro hibernate
	 * TODO změna owner na User class
	 * 
	 */
	
	String text;
	String owner;
	Boolean isCalendar;
	String calendarDate;
	String calendarTime;
	Boolean isComplete;
	String labels;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
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
	public Boolean getIsComplete() {
		return isComplete;
	}
	public void setIsComplete(Boolean isComplete) {
		this.isComplete = isComplete;
	}
	public String getLabels() {
		return labels;
	}
	public void setLabels(String labels) {
		this.labels = labels;
	}
	
	
	
}
