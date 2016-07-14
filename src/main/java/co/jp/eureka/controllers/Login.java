/*
 * $Id$
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package co.jp.eureka.controllers;

import org.apache.logging.log4j.LogManager;

//import java.util.logging.LogManager;

import org.apache.logging.log4j.Logger;

public class Login extends EurekaSupport {
	
	// this specific class log (you can use different appenders and separate them by components for example)
	//static final Logger logger = LogManager.getLogger( Logger.class.getName() );
	static final Logger log = LogManager.getLogger(Login.class.getName());	
	
	
    public String execute() throws Exception {    	
    		
    	log.debug("----------Start Loggin from execute LOG debug mode----------");
    	//Recovering just the text from the i18n file Method from ActionSupport
    	String aux=getText("TitleTab.detailProject");
    	log.debug("accessing the i18n text: "+aux);
    	
        if (isInvalidName(this.getUsername())) return INPUT;
        

        if (isInvalidNamePassword(this.getPassword())) return INPUT;
        
        log.debug("----------Checking database with: "+this.getUsername()+", "+this.getPassword());
        
        //Database method
        if (checkDatabase(this.getUsername(),this.getPassword()))
        	return SUCCESS;
        else
        	return "fail";
                
    }
    
        
    
    private boolean checkDatabase(String username2, String password2) {
		//Need to look at the database but the right tables are not yet define so I am going to put just a basic login
    	String user="Admin";
    	String password="Admin";
    	if (username2.equals(user) && password2.equals(password2))
    		return true;
    	else
    		return false;
		
	}



	private boolean isInvalidName(String value) {
        return (value == null || value.length() == 0);
    }
    
    private boolean isInvalidNamePassword(String value) {
        return (value == null || value.length() == 0);
    }

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    /*
     * package com.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor  extends AbstractInterceptor {

        @Override
        public String intercept(ActionInvocation invocation) throws Exception {
                Map<String, Object> session = invocation.getInvocationContext().getSession();

                String loginId = (String) session.get("loginId");

                if (loginId == null) 
                {
                        return Action.LOGIN;
                } 
                else 
                {
                        return invocation.invoke();
                }
        }
}
     */
    
    
    //Login.action
    /*
     * package com.action;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

        private static final long serialVersionUID = 1L;
        private String userName;
        private Map<String, Object> session;

        public String home() {
                return SUCCESS;
        }

        // Log Out user
        public String logOut() {
                session.remove("loginId");
                addActionMessage("You have been Successfully Logged Out");
                return SUCCESS;
        }

        // Login user
        public String login() {
                if (userName.isEmpty()) {
                        addActionError("Username can't be blanked");
                        return LOGIN;
                } else {
                        session.put("loginId", userName);
                        return SUCCESS;
                }
        }

        public String getUserName() {
                return userName;
        }

        public Map<String, Object> getSession() {
                return session;
        }

        public void setUserName(String userName) {
                this.userName = userName;
        }

        public void setSession(Map<String, Object> map) {
                this.session = map;
        }
}
     */
    

}