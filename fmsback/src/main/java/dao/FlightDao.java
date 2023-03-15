package dao;


import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.owasp.html.PolicyFactory;
import org.owasp.html.Sanitizers;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;

import models.Flight;
import models.FlightDto;
import models.FlightsDto;

public class FlightDao {
	private static Logger log = LogManager.getLogger(FlightDao.class);
	@Inject
	Provider<EntityManager> entityManagerProvider;
	public static PolicyFactory sanitizer = Sanitizers.FORMATTING.and(Sanitizers.BLOCKS);
	
	

	@Transactional
	public boolean addFlight(FlightDto flightDto) {
		EntityManager entityManager = entityManagerProvider.get();
		Flight newFlight = new Flight(
				flightDto.id,
				flightDto.fromLoc,
				flightDto.toLoc,
				flightDto.title,
				flightDto.isFull,
				flightDto.seats,
				flightDto.description,
				flightDto.companyName,
				flightDto.takeOffTime,
				flightDto.landingTime,
				flightDto.ticketPrice);
		entityManager.persist(newFlight);
		return true;

	}
	
	public FlightsDto displayAllFlights() {
		EntityManager entityManager=entityManagerProvider.get();
		TypedQuery<Flight> query=entityManager.createQuery("SELECT x FROM Flight x",Flight.class);
		List<Flight> flights=query.getResultList();
		FlightsDto flightsDto = new FlightsDto();
		flightsDto.flights=flights;
		return flightsDto;
		
		        
	}
	
	@Transactional
	public boolean updateFlight(Flight flight) {
		try {
		EntityManager entityManager = entityManagerProvider.get();
		Flight updatedFlight = entityManager.find(Flight.class, flight.id);
		Query query = entityManager.createQuery("update  Flight  set id =:id, fromLoc=:fromLoc, toLoc=:toLoc, title=:title,isFull=:isFull,seats=:seats,description=:description,companyName=:companyName, takeOffTime=:takeOffTime,landingTime=:landingTime,ticketPrice=:ticketPrice   where id=:id");
		query.setParameter("id", flight.id);
		query.setParameter("fromLoc", flight.fromLoc);
		query.setParameter("toLoc", flight.toLoc);
		query.setParameter("title", flight.title);
		query.setParameter("isFull", flight.isFull);
		query.setParameter("seats", flight.seats);
		query.setParameter("description", flight.description);
		query.setParameter("companyName", flight.companyName);
		query.setParameter("takeOffTime", flight.takeOffTime);
		query.setParameter("landingTime", flight.landingTime);
		query.setParameter("ticketPrice", flight.ticketPrice);
		

		query.executeUpdate();
		if(updatedFlight!=null) {
			return true;
		}
		return false;
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	
	
	
}

	public boolean delete(BigInteger id) {
		return deleteFlight(id);
	}

	@Transactional
	public boolean deleteFlight(BigInteger id) {
		try {
		EntityManager entityManager = entityManagerProvider.get();
		Flight flight = entityManager.find(Flight.class, id);
		entityManager.remove(flight);	
		return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
