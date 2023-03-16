package dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.owasp.html.PolicyFactory;
import org.owasp.html.Sanitizers;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;

import models.Booking;
import models.BookingDto;
import models.BookingsDto;
import models.Flight;
import models.FlightsDto;

public class BookingDao {
	
	@Inject
	Provider<EntityManager> entityManagerProvider;
	public static PolicyFactory sanitizer = Sanitizers.FORMATTING.and(Sanitizers.BLOCKS);

	@Transactional
	public boolean addBooking(BookingDto bookingDto) {
		EntityManager entityManager = entityManagerProvider.get();
	Booking newBooking=new Booking(bookingDto.id);  
	entityManager.persist(newBooking);
	return true;
	}
	
	
	public BookingsDto displayAllBooking() {
		EntityManager entityManager=entityManagerProvider.get();
		TypedQuery<Booking> query=entityManager.createQuery("SELECT x FROM Booking x",Booking.class);
		List<Booking> bookings=query.getResultList();
		BookingsDto bookingsDto = new BookingsDto();
		bookingsDto.bookings=bookings;
		return bookingsDto;
		
		        
	}
	
	public boolean delete(int id) {
		return deleteBooking(id);
	}

	@Transactional
	public boolean deleteBooking(int id) {
		try {
		EntityManager entityManager = entityManagerProvider.get();
		Booking booking = entityManager.find(Booking.class, id);
		entityManager.remove(booking);	
		return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
