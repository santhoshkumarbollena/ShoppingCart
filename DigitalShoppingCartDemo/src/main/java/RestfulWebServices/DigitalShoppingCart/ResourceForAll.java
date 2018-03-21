package RestfulWebServices.DigitalShoppingCart;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElement;

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
		logger.info(r1.getUserName());
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
		logger.info(p1.getNoOfunits());
		System.out.println(p1.getName());
		Cart c = new Cart();
		 c.AddProductToCart(p1);
		return p1;

	}
	@GET
	@Path("/GetPrice/{Product}")
	@Produces(MediaType.APPLICATION_JSON)
	public int getPrice(@PathParam("Product") String prod)
	{
		GetPrice gt=new GetPrice();
		return gt.getPrice(prod);
		
	}
	
	@GET
	@Path("/GetCustomerDetails/{UserName}")
	@Produces(MediaType.APPLICATION_JSON)
	
	public List<RegistrationClass> getCustomerDetails(@PathParam("UserName") String UserName)
	{
		List<RegistrationClass> r1=new ArrayList<RegistrationClass>();
		RegisteringDetailsToDb rdb=new RegisteringDetailsToDb();
		return rdb.getDetailsOfCustomer(UserName);
		
	}
	@GET
	@Path("/CartDetails/{UserName}")
	@Produces(MediaType.APPLICATION_JSON)
	
	public ArrayList<Product> getCartDetails(@PathParam("UserName") String UserName)
	{
		logger.info("demo");
		ProductMapper pm=new ProductMapper();
		ArrayList<Product> pro=pm.getCart(UserName);
		logger.info("\n");
		logger.info(pro);
		return pm.getCart(UserName);
	}
	@DELETE
	@Path("/DeletingFromCart/{UserName}/{ProductName}")
	@Produces(MediaType.APPLICATION_JSON)
	
	public boolean deletingItemFromCart(@PathParam("UserName") String UserName,@PathParam("ProductName") String ProductName)
	{
		logger.info(ProductName);
		logger.info(UserName);
		ProductMapper pm=new ProductMapper();
		return pm.deleteProductFromCart(UserName,ProductName);
	}
	@PUT
	@Path("/UpdateCustomerDetails/{UserName}")
	@Produces(MediaType.APPLICATION_JSON)
	
	public List<RegistrationClass> updateCustomerDetails(RegistrationClass r1,@PathParam("UserName") String UserName)
	{
		RegisteringDetailsToDb rdb=new RegisteringDetailsToDb();
		return rdb.updateDetailsOfCustomer(r1,UserName);
		
	}
	@GET
	@Path("/fruitscheakavalability")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> fruitscheakavalability()
	{
		CheakingAvalabilityOfProduct c1=new CheakingAvalabilityOfProduct();
		return c1.cheakfruits();
	}
	@GET
	@Path("/GetFruitsPrice")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Integer> fruitsPrice()
	{
		GettingPriceInCategery g1=new GettingPriceInCategery();
		
		return null;
	}
	/*@GET
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
	*/
	@POST
	@Path("/LoggingDetails")
	// @Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public boolean verifyLogingDetails(LoginDetails l1) {
		// r1.create(r1);
		logger.info(l1.getUserName());
		logger.info(l1.getPassword());
		LoggingMapper lm=new LoggingMapper();
		return lm.verify(l1);

	}
	@GET
	@Path("/UserNameValidation")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> RegisterUserName()
	{
		RegisteringDetailsToDb rs=new RegisteringDetailsToDb();
		return rs.getUserNamefromDb();
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
