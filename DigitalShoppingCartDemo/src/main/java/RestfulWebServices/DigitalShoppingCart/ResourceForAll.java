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
	final static Logger logger = Logger.getLogger(ResourceForAll.class);
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
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
	@Produces({ MediaType.APPLICATION_JSON })
	public RegistrationClass SetRegistrationDetails(RegistrationClass r1) {
		// r1.create(r1);
		logger.info(r1);
		RegisteringDetailsToDb rdb = new RegisteringDetailsToDb();
		rdb.addCoustomer(r1);
		return r1;

	}
	@POST
	@Path("/AddingToCart")
	// @Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public Product AddingToCart(Product p1) {
		// r1.create(r1);
		logger.info(p1.getName());
		System.out.println(p1.getName());
		Cart c = new Cart();
		 c.AddProductToCart(p1);
		return p1;

	}
	@GET
	@Path("/GetPrice")
	@Produces(MediaType.APPLICATION_JSON)
	public int getPrice()
	{
		GetPrice gt=new GetPrice();
		return gt.getPrice();
		
	}
	@GET
	@Path("/LoggingIn")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> Authenticate()
	{
		LoggingAuth la=new LoggingAuth();
		
		return la.VerifyLogin();
		
	}
	@GET
	@Path("/LoggingInUserName")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> AuthenticateU()
	{
		LoggingAuth la=new LoggingAuth();
		
		return la.VerifyLoginU();
		
	}
	@GET
	@Path("/Product")
	@Produces(MediaType.APPLICATION_JSON)
	public Product getProduct()
	{
		//Product p1=new Product();
		ProductMapper pm=new ProductMapper();
		return pm.getDetails();
		
	}
	@GET
	@Path("/Products")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProducts()
	{
		List<Product> li=new ArrayList<Product>();
		return li;
	}
}
