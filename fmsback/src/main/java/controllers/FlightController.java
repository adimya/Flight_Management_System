package controllers;



import java.math.BigInteger;



import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.google.inject.Inject;

import dao.FlightDao;
import models.Flight;
import models.FlightDto;
import models.FlightsDto;
import ninja.Context;
import ninja.Result;
import ninja.Results;
import ninja.params.PathParam;


public class FlightController {
	
	private static Logger log = LogManager.getLogger(FlightController.class);
	@Inject
	FlightDao flightDao;
	
	public Result addNewFlight(Context context, FlightDto flightDto) {
		
		log.info(flightDto.toString());
		flightDao.addFlight(flightDto);
		
		context.getFlashScope().success("New Flight Addded");
		return Results.ok().json().render("New Flight Added");

	}
	
public Result allFlights() {
		
		FlightsDto flights=flightDao.displayAllFlights();
		
		return flights!=null?Results.json().render(flights): Results.json().render("No FLights");
		

	}

public Result updateFlight(Context context, Flight flight) {
	boolean status=flightDao.updateFlight(flight);
	if(status==true) {
	context.getFlashScope().success("updated");
	return Results.ok().json().render("updatedy");
	}
	else {
		return Results.ok().json().render("Not Found");
	}
	

}


public Result deleteFlight(@PathParam("id") Long id) {
	log.info(id);
//	BigInteger big=new BigInteger(id);
	BigInteger big=BigInteger.valueOf(id);
	boolean status = flightDao.delete(big);
	if (status == true) {	
		return Results.ok().json().render("Deleted");
	}
		return Results.ok().json().render("Not Found");
}



}
