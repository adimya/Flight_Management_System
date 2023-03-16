package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Booking {
	
	@Id
	public int id;
	
	public Booking(){
		
	}
	public Booking(int id) {
		this.id=id;
	}
	
	
}
