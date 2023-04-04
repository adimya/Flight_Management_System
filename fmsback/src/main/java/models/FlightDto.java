package models;

import java.math.BigInteger;
import java.sql.Time;

public class FlightDto {
	
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
	public BigInteger id;
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getFromLoc() {
		return fromLoc;
	}

	public void setFromLoc(String fromLoc) {
		this.fromLoc = fromLoc;
	}

	public String getToLoc() {
		return toLoc;
	}

	public void setToLoc(String toLoc) {
		this.toLoc = toLoc;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getIsFull() {
		return isFull;
	}

	public void setIsFull(Boolean isFull) {
		this.isFull = isFull;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Time getTakeOffTime() {
		return takeOffTime;
	}

	public void setTakeOffTime(long takeOffTime) {
		this.takeOffTime = new Time(takeOffTime);
	}

	public Time getLandingTime() {
		return landingTime;
	}

	public void setLandingTime(long landingTime) {
		this.landingTime = new Time(landingTime);
	}

	public int getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	
	public FlightDto() {}
	
	

}
