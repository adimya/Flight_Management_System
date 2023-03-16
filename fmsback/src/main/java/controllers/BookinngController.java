package controllers;

import java.math.BigInteger;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.google.inject.Inject;

import dao.BookingDao;
import dao.FlightDao;
import models.BookingDto;
import models.BookingsDto;
import models.FlightDto;
import models.FlightsDto;
import ninja.Context;
import ninja.Result;
import ninja.Results;
import ninja.params.PathParam;

public class BookinngController {
	
	@Inject
	BookingDao bookingDao;
	
public Result addNewBooking(Context context, BookingDto bookingDto) {
		bookingDao.addBooking(bookingDto);
		
		context.getFlashScope().success("New Booking Addded");
		return Results.ok().json().render("New Booking Added");

	}
public Result allBooking() {
	
	BookingsDto booking=bookingDao.displayAllBooking();
	
	return booking!=null?Results.json().render(booking): Results.json().render("No Booking");
	

}

public Result deleteBooking(@PathParam("id") int id) {
	
	boolean status = bookingDao.delete(id);
	if (status == true) {	
		return Results.ok().json().render("Deleted");
	}
		return Results.ok().json().render("Not Found");
}


}
