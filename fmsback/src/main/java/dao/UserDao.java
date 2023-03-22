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
 * Copyright (C) 2012-2020 the original author or authors.
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

package dao;


import java.math.BigInteger;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.commons.logging.Log;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import models.User;
import models.UserDto;
import models.UsersDto;
import ninja.jpa.UnitOfWork;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;

import controllers.FlightController;


public class UserDao {
    
    @Inject
    Provider<EntityManager> entityManagerProvider;
    
    private static Logger log = LogManager.getLogger(FlightController.class);
    
    public UsersDto displayAllUsers() {
		EntityManager entityManager=entityManagerProvider.get();
		TypedQuery<User> query=entityManager.createQuery("SELECT x FROM User x",User.class);
		List<User> users=query.getResultList();
		UsersDto usersDto = new UsersDto();
		usersDto.users=users;
		
		return usersDto;
		
		        
	}
    
    @Transactional
	public boolean addNewUser(UserDto userDto) {
		EntityManager entityManager = entityManagerProvider.get();
//		System.out.println(userDto.fullname);
//		System.out.println(userDto.bookedId);
//		for(int i=0;i<userDto.bookedId.length;i++) {
//			System.out.println(userDto.bookedId[i]);
//		}
//		int arr[]=userDto.bookedId;
//		System.out.print(arr);
		User user = new User();
		
		user.setAdmin(userDto.isAdmin);
		user.setUsername(userDto.username);
		user.setBookedId(userDto.bookedId);
		user.setPassword(userDto.password);
		user.setFullname(userDto.fullname);
		System.out.print(user);
		entityManager.persist(user);
		
		return true;

	}
    
    @Transactional
	public boolean deleteUser(BigInteger id) {
		try {
		EntityManager entityManager = entityManagerProvider.get();
		User user = entityManager.find(User.class, id);
		entityManager.remove(user);	
		return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
    @UnitOfWork
    public boolean isUserAndPasswordValid(String username, String password) {
        
        if (username != null && password != null) {
            
            EntityManager entityManager = entityManagerProvider.get();
            
            TypedQuery<User> q = entityManager.createQuery("SELECT x FROM User x WHERE username = :usernameParam", User.class);
            User user = getSingleResult(q.setParameter("usernameParam", username));

            if (user != null) {
                
                if (user.password.equals(password)) {

                    return true;
                }
                
            }

        }
        
        return false;
 
    }

    /**
     * Get single result without throwing NoResultException, you can of course just catch the
     * exception and return null, it's up to you.
     */
    private static <T> T getSingleResult(TypedQuery<T> query) {
        query.setMaxResults(1);
        List<T> list = query.getResultList();
        if (list == null || list.isEmpty()) {
            return null;
        }

        return list.get(0);
    }
    
    

}
