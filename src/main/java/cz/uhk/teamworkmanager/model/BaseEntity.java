package cz.uhk.teamworkmanager.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public class BaseEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * Základní entita obsahující ID a datum+cas vytvoreni a posledni zmeny
	 */
	
	private Long id;
	private Timestamp dateCreated;
	
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
	
	public String toString(){
		return "BaseEntity.id="+this.getId().toString();
	}
	
	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

}
