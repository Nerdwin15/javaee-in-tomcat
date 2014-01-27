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

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A listener that, when deployed in a Tomcat environment, wraps the Weld
 * listener and delegates all event calls to the listener.
 *
 * @author Michael Irwin
 */
@WebListener
public class TomcatSupportListener implements ServletContextListener, 
    ServletRequestListener, HttpSessionListener {
  
  private static final Logger logger = 
      LoggerFactory.getLogger(TomcatSupportListener.class);
  
  private static final String WELD_LISTENER_CLASS = 
      "org.jboss.weld.environment.servlet.Listener";
  
  private ServletContextListener scListener;
  private ServletRequestListener srListener;
  private HttpSessionListener hsListener;
  
  /**
   * Creates a new instance. If the Weld listening class is in the 
   * classpath (only appears in Tomcat environment), create a new
   * instance of it and get it ready for delegating of future events.
   */
  public TomcatSupportListener() {
    try {
      Class<?> listenerClass = Class.forName(WELD_LISTENER_CLASS, false, 
          Thread.currentThread().getContextClassLoader());
      Object listener = listenerClass.newInstance();
      scListener = (ServletContextListener) listener;
      srListener = (ServletRequestListener) listener;
      hsListener = (HttpSessionListener) listener;
      logger.info("The TomcatSupportListener has been configured with a " 
          + WELD_LISTENER_CLASS);
    } 
    catch (ClassNotFoundException e) {
      logger.info("Not using the TomcatSupportListener as the weld listener"
          + " (" + WELD_LISTENER_CLASS + ") is not defined on the classpath");
    }
    catch (InstantiationException e) {
      throw new RuntimeException(e);
    }
    catch (IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public void contextInitialized(ServletContextEvent event) {
    if (scListener != null)
      scListener.contextInitialized(event);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void contextDestroyed(ServletContextEvent event) {
    if (scListener != null)
      scListener.contextDestroyed(event);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void sessionCreated(HttpSessionEvent event) {
    if (hsListener != null)
      hsListener.sessionCreated(event);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void sessionDestroyed(HttpSessionEvent event) {
    if (hsListener != null)
      hsListener.sessionDestroyed(event);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void requestDestroyed(ServletRequestEvent event) {
    if (srListener != null)
      srListener.requestDestroyed(event);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void requestInitialized(ServletRequestEvent event) {
    if (srListener != null)
      srListener.requestInitialized(event);    
  }
 
}
