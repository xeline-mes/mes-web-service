
package com.xeline.webservice.example;

import org.cometd.bayeux.server.BayeuxServer;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class BayeuxInitializer extends GenericServlet
{

    public static final String BROADCAST_SVC = "broadcaster";

    public void init() throws ServletException
    {
        BayeuxServer bayeux = (BayeuxServer)getServletContext().getAttribute(BayeuxServer.ATTRIBUTE);
        new HelloService(bayeux);
        EventBroadcaster bc = new EventBroadcaster(bayeux);
        getServletContext().setAttribute(BROADCAST_SVC, bc);
    }

    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException
    {
        throw new ServletException();
    }
}
