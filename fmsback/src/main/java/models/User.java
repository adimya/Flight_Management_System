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

package models;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="user",schema="public")
public class User {
    
	@Id
    @Column(name="id")
	@SequenceGenerator(name="seq-gen",sequenceName="MY_SEQ_GEN", initialValue=205, allocationSize=12)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq-gen")
    public BigInteger id;
    

	@Column(name="username")
    public String username;
    
    @Column(name="password")
    public String password;
    
    @Column(name="fullname")
    public String fullname;
    
    @Column(name="isAdmin")
    public boolean isAdmin;
    
    @Column(name="bookedId")
    public String bookedId;
    
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getBookedId() {
		return bookedId;
	}

	public void setBookedId(String bookedId) {
		this.bookedId = bookedId;
	}

    public User() {}
    
    public User(String username, String password, String fullname,String bookedId,boolean isAdmin) {
    	super();
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.bookedId=bookedId;
        this.isAdmin=isAdmin;
    }
 
}
