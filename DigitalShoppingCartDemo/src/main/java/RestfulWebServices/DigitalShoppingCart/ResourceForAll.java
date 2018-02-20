package RestfulWebServices.DigitalShoppingCart;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ResourceForAll")
public class ResourceForAll {
	ItemDetailsMapper g = new ItemDetailsMapper();
	final static Logger logger = Logger.getLogger(Log4jExample.class);
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<ItemsDetails> getItemsDetails() {

		List<ItemsDetails> li = new ArrayList<ItemsDetails>();
		
		//ItemsDetails it = new ItemsDetails();
		li = g.getDetails();

		return li;
	}

	@POST
	@Path("/demo")
	@Produces(MediaType.APPLICATION_JSON)
	public ItemsDetails setItemDetails(ItemsDetails i1) {
		logger.info(i1.getAddedDate());
		g.create(i1);
		return i1;
	}

	@POST
	@Path("/RegisteringDetails")
	// @Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public RegistrationClass SetRegistrationDetails(RegistrationClass r1) {
		// r1.create(r1);
		logger.info(r1);
		RegisteringDetailsToDb rdb = new RegisteringDetailsToDb();
		rdb.addCoustomer(r1);
		return r1;

	}
}
