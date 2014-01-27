/*
 * File created on Jan 27, 2014 
 *
 * Copyright 2008-2013 Nerdwin15, LLC
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

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * DESCRIBE THE TYPE HERE.
 *
 * @author Michael Irwin
 */
@Named
@SessionScoped
public class BackingBean implements Serializable {

  private static final long serialVersionUID = 182363583165L;

  @Inject
  private GreetingService greetingService;
  
  private String name;

  /**
   * Gets the {@code name} property.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the {@code name} property.
   */
  public void setName(String name) {
    this.name = name;
  }
  
  public String display() {
    return "index";
  }
  
  /**
   * Get the current date
   */
  public String getGreeting() {
    return greetingService.getGreeting(name);
  }
  
}
