package com.iteratrlearning.testing.examples.m7_page_object;

import com.iteratrlearning.PortFinder;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class StaticServer
{
    private static final int PORT = PortFinder.findPort();

    public static void main(String[] args) throws Exception
    {
        System.out.println("Hosting on port " + PORT);
        final Server jettyServer = startServer(PORT);
        jettyServer.join();
    }

    public static Server startServer(final int port) throws Exception
    {
        final ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setResourceBase(System.getProperty("user.dir") + "/src/main/webapp");
        context.setContextPath("/");

        ServletHolder staticContentServlet = new ServletHolder(
                "staticContentServlet", DefaultServlet.class);
        staticContentServlet.setInitParameter("dirAllowed","true");
        context.addServlet(staticContentServlet,"/");

        final Server jettyServer = new Server(port);
        jettyServer.setHandler(context);
        jettyServer.start();
        return jettyServer;
    }
}
