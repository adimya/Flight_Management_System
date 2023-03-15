package controllers;

import ninja.Result;
import ninja.Results;

public class CorsHeaderController {
	
	public Result routeForOp() {
		return addHeaders(Results.ok().json().render("key","value"));
	}
	
	public Result addHeaders(Result result) {
		return result.addHeader("Access-Control-Allow-Origin","*").addHeader("Access-Control-Allow-Credentials","true").status(200);
		
				
		
	}
}
