package el;

import java.io.IOException;
import java.net.InetAddress;

import org.apache.http.client.ClientProtocolException;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

public class X2J {

	public static void main(String[] args) throws ClientProtocolException, IOException {

		 String json = readJsonFile("E://W//demo.json");

		
		  Settings settings = Settings.builder() .put("cluster.name",
		  "elasticsearch").build();
		  
		  TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
		  .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"),
		  9300));
		  
		  IndexResponse response = client.prepareIndex("mydemo", "me").setSource(json,
		  XContentType.JSON).get();
		  
		  client.close();
		  
		 

	}

	/*
	 * public static String readJsonFile(String filename) { String result = "" ; try
	 * { BufferedReader br = new BufferedReader(new FileReader(filename));
	 * StringBuilder sb = new StringBuilder(); String line = br.readLine(); while
	 * (line != null) { sb.append(line); line = br.readLine(); } result =
	 * sb.toString(); } catch(Exception e) { e.printStackTrace(); } return result;
	 * 
	 * 
	 * 
	 * }
	 */

}
