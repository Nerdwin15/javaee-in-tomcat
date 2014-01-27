/*
 * File created on Jan 27, 2014 
 *
 * Copyright 2008-2013 Virginia Polytechnic Institute and State University
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
 *
 */
package com.nerdwin15.demo;

import javax.enterprise.context.ApplicationScoped;

/**
 * A very simple service that gets the current date.
 *
 * @author Michael Irwin
 */
@ApplicationScoped
public class GreetingService {

  public String getGreeting(String name) {
    if (name == null)
      return null;
    
    if (name.contains("Michael"))
      return "Hi there " + name;
    return "Hello " + name;
  }
  
}
