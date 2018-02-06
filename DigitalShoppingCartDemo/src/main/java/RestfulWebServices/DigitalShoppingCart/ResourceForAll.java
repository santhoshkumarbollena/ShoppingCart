package RestfulWebServices.DigitalShoppingCart;
import java.util.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ResourceForAll")
public class ResourceForAll {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ItemsDetails> getItemsDetails()
	{
		GettingInfFromDb g=new GettingInfFromDb();
		List<ItemsDetails> li=new ArrayList<ItemsDetails>();
		li=g.getDetails();
		return li;
	}
}
