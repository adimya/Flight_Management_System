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

import ninja.Result;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


import dao.FlightDao;
import dao.UserDao;


@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
	
    @Mock
    private UserDao userDao;
    
    private UserController userController;
    
    @Before
    public final void setupTest() {
        userController = new UserController();
        userController.userDao = userDao;
    }
    


    
    @Test
    public void DeleteFlight() {
    	when(userDao.deleteUser(new BigInteger("4"))).thenReturn(true);
    	Result result = userController.deleteUser(new Long(4));
    	assertEquals(200, result.getStatusCode());
    	
    	
    }
    
    @Test
    public void AllFlight() {
    	
    	when(userDao.displayAllUsers()).thenReturn(null);
    	Result result = userController.allUsers();
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
