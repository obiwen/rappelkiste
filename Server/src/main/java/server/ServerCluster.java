package server;

import handler.PingHandler;
import org.eclipse.jetty.server.Server;


public class ServerCluster {

    public static void main( String[] args ) throws Exception
    {

        PingHandler pingHandler = new PingHandler();


        Server server = new Server(8080);
        server.setHandler(pingHandler);

        Server server2 = new Server(8081);
        server2.setHandler(pingHandler);


        try {
            server.start();
            server2.start();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(100);
        }

    }
}
