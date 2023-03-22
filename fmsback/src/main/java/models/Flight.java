package models;

import java.math.BigInteger;
import java.sql.Time;


import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Flight {
	
	@Id
	public BigInteger id;
	
	public String fromLoc;
	public String toLoc;
	public String title;
	public Boolean isFull;
	public int seats;
	public String description;
	public String companyName;
	public Time takeOffTime;
	public Time landingTime;
	public  int ticketPrice;
	
	public Flight() {}
    
	public Flight(BigInteger id,String fromLoc,String toLoc,String title,Boolean isFull,int seats,
			String description,String companyName,Time takeOffTime,Time landingTime,int ticketPrice) {
		
		super();
		this.id=id;
		this.fromLoc=fromLoc;
		this.toLoc=toLoc;
		this.title=title;
		this.isFull=isFull;
		this.seats=seats;
		this.description=description;
		this.companyName=companyName;
		this.takeOffTime=takeOffTime;
		this.landingTime=landingTime;
		this.ticketPrice=ticketPrice;
		
	}
	
	
	
	

}
