
package com.xeline.webservice.example;

import org.cometd.bayeux.Message;
import org.cometd.bayeux.server.BayeuxServer;
import org.cometd.bayeux.server.ServerSession;
import org.cometd.server.AbstractService;

import java.util.HashMap;
import java.util.Map;

public class HelloService extends AbstractService
{
    public HelloService(BayeuxServer bayeux)
    {
        super(bayeux, "hello");
        addService("/service/hello", "processHello");
    }

    public void processHello(ServerSession remote, Message message)
    {
        Map<String, Object> input = message.getDataAsMap();
        String name = (String)input.get("name");

        Map<String, Object> output = new HashMap<String, Object>();
        output.put("greeting", "Hi, " + name);
        remote.deliver(getServerSession(), "/hello", output, null);
    }

}
