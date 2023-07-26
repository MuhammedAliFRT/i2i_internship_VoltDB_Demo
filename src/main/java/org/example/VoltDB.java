package org.example;

import org.voltdb.*;
import org.voltdb.client.Client;
import org.voltdb.client.ClientConfig;
import org.voltdb.client.ClientFactory;
import org.voltdb.client.ClientResponse;

public class VoltDB {
    public static void main(String[] args) {
        try {
			ClientConfig config = new ClientConfig(" "," ");
            config.setTopologyChangeAware(true);
            Client client = ClientFactory.createClient(config);
            client.createConnection("0.0.0.0",3564);


            ClientResponse response = client.callProcedure("@AdHoc", "SELECT * FROM SUBSCRIBER;");
            VoltTable[] results = response.getResults();
            VoltTable result = results[0];
            System.out.println(result);


            client.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
