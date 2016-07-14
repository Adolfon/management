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

package co.jp.eureka.example;

/**
 * <code>Set welcome message.</code>
 */
public class HelloWorld extends ExampleSupport {

    public String execute() throws Exception {
        setMessage(getText(MESSAGE)); // this is from the properties file.
        LOG.info("properties variables values, MESSAGE: "+MESSAGE+", ADOLMESSAGE: "+ADOLMESSAGE);  //This log comes directly from the ActionSupport class 
        setAdolmessage(getText(ADOLMESSAGE)); // getText if for accessing the properties file..
        //this.setAdolmessage("Mi mensaje.."); //set the property for the view.
        return SUCCESS;
    }

    /**
     * Provide default value for Message property.
     */
    public static final String MESSAGE = "HelloWorld.message";
    public static final String ADOLMESSAGE= "Adolfo"; //this is the name in the properties language files

    /**
     * Field for Message property.
     */
   
    private String adolmessage; //bean properties with getter and setter, it is available in the view layer (No need of forms in struts2)

    public String getAdolmessage() {
		return adolmessage;
	}

	public void setAdolmessage(String adolmessage) {
		this.adolmessage = adolmessage;
	}
	
	 private String message;

	/**
     * Return Message property.
     *
     * @return Message property
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set Message property.
     *
     * @param message Text to display on HelloWorld page.
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
