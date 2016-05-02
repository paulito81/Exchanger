package restweb;


import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

/**
 * Created by Paul on 02.05.2016.
 */
@Stateless
@Path("/exchangeRates")
@Produces(MediaType.APPLICATION_XML)
public class RestService {


    RestService(String inputExchange, String inputExchangeTwo) {
        getExchangeRate(inputExchange, inputExchangeTwo);
    }

    @GET
    public String getExchangeRate(@QueryParam("fromCurrency") String fromCurrency, @QueryParam("toCurrency") String toCurrency) {

        URI uri = UriBuilder.fromUri("http://api.fixer.io/latest")
                .queryParam("base", fromCurrency).build();

        Client client = ClientBuilder.newClient();
        Response response = client.target(uri).request("application/json").get();

        //   JSONParser parser = new JSONParser();
        System.out.println("Result as string : " + response.readEntity(String.class));

/*
        try {
            Object object = parser.parse(s);
            JSONArray array = (JSONArray) object;
            System.out.println("Element One: ");
          //  System.out.println(array.get(0));
            System.out.println();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        */
        return "";

    }
}
