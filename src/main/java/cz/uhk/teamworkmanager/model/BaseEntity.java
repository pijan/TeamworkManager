package cz.uhk.teamworkmanager.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public class BaseEntity implements Serializable {
	
	/*
	 * Základní entita obsahující ID a datum
	 */
	
	private Long id;
	private String date;
	
	//konstruktor
	public BaseEntity(){
		
	}
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public Long getId(){
		return this.id;
	}
	
	public void setId(Long id){
		//bude vůbec potřeba?
		this.id = id;
	}
	
	public String getDate(){
		return this.date;
	}
	
	public void setDate(String date){
		//vrací čas a datum poslední změny
		this.date = date;
	}
	
	
	public String toString(){
		return "BaseEntity.id="+this.getId().toString();
	}

}
