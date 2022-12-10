package com.iteratrlearning.testing.examples.m7_page_object;

import org.eclipse.jetty.server.Server;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class StaticServerResource implements AfterEachCallback, BeforeEachCallback
{
    private static Server server;
    private static int port;

    public StaticServerResource(int port)
    {
        this.port = port;
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception
    {
        server = StaticServer.startServer(port);
    }

    @Override
    public void afterEach(ExtensionContext context)
    {
        try
        {
            server.stop();
        }
        catch (Exception e)
        {
            System.err.println("Error stopping server (" + e + ")");
        }
    }

    public static Server getServer() {
        return server;
    }

    public static int getPort() {
        return port;
    }
}
