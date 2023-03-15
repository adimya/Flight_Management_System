package models;

import java.math.BigInteger;
import java.sql.Time;

public class FlightDto {
	
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
	
	public FlightDto() {}
	
	

}
