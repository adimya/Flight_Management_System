/**
 * Copyright (C) the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Copyright (C) 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigInteger;
import java.sql.Time;

import ninja.Context;
import ninja.Result;
import ninja.session.Session;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import dao.ArticleDao;
import dao.FlightDao;
import models.FlightDto;
import java.math.BigInteger;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
public class FlightControllerTest {
	private Session session;
	private Context context;
    @Mock
    private FlightDao flightDao;
    
    private FlightController flightController;
    
    @Before
    public final void setupTest() {
        flightController = new FlightController();
        flightController.flightDao = flightDao;
    }
    

//    @Test
//    public void postFlight() {
//    	FlightDto flightDto=new FlightDto();
//    	flightDto.setId(new BigInteger("3"));
//    	flightDto.setToLoc("Abc");
//    	flightDto.setCompanyName("abc");
//    	flightDto.setDescription("abc");
//    	flightDto.setIsFull(false);
//    	flightDto.setLandingTime(111111);
//    	flightDto.setTicketPrice(0);
//    	flightDto.setTitle("abc");
//    	flightDto.setTakeOffTime(111111);
//    	flightDto.setFromLoc("adb");
//    	flightDto.setSeats(0);
//    	
//    	
//    	
//        when(flightDao.addFlight(flightDto)).thenReturn(true);
//        
//        Result result = flightController.addNewFlight(context, flightDto);
//        
//        assertEquals(200, result.getStatusCode());
//
//    }
    
    @Test
    public void DeleteFlight() {
    	when(flightDao.delete(new BigInteger("4"))).thenReturn(true);
    	Result result = flightController. deleteFlight(new Long(4));
    	assertEquals(200, result.getStatusCode());
    	
    	
    }
    
    @Test
    public void AllFlight() {
    	
    	when(flightDao.displayAllFlights()).thenReturn(null);
    	Result result = flightController.allFlights();
    	assertEquals(200, result.getStatusCode());
    	
    	
    }
    
    
//    
//    @Test
//    public void testThatPostArticleReturnsNotFoundWhenArticleDaoReturnsFalse() {
//
//        when(flightDao.postArticle(null, null)).thenReturn(false);
//        
//        Result result = flightController.postArticleJson(null, null);
//        
//        assertEquals(404, result.getStatusCode());
//
//    }

}
