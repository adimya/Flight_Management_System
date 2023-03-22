package controllers;

import java.math.BigInteger;

import javax.inject.Inject;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import dao.UserDao;
import models.UserDto;
import models.UsersDto;
import ninja.Context;
import ninja.Result;
import ninja.Results;
import ninja.params.PathParam;

public class UserController {
	
	@Inject
	UserDao userDao;
	private static Logger log = LogManager.getLogger(FlightController.class);
	
public Result allUsers() {
		
		UsersDto users=userDao.displayAllUsers();
		
		return users!=null?Results.json().render(users): Results.json().render("No Users");
		

	}
public Result addUser(Context context, UserDto userDto) {
	
	
	log.info(userDto);
	userDao.addNewUser(userDto);
	
	context.getFlashScope().success("New user Addded");
	return Results.ok().json().render("New User Added");

}
public Result deleteUser(@PathParam("id") Long id) {

//	BigInteger big=new BigInteger(id);
	BigInteger big=BigInteger.valueOf(id);
	boolean status = userDao.deleteUser(big);
	if (status == true) {	
		return Results.ok().json().render("Deleted");
	}
		return Results.ok().json().render("Not Found");
}


}
