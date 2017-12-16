package webService;

import model.OrdersManager;
import model.ProjectManager;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
@Path("/Order")
public class OrderService {
    @POST
    @Path("/addOrder/")
    public Response AddOrder(
            @QueryParam("OrderId") Integer OrderId,
            @QueryParam("Sessionid") String Session,
            @QueryParam("Costumer") String CostumerName,
            @QueryParam("CostumerName") String CostumerSurename,
            @QueryParam("address") String address,
            @QueryParam("number") Integer number,
            @QueryParam("StudentStatus") Boolean studentStatus) {
        try {
            OrdersManager model = new OrdersManager();
            model.Order(OrderId, Session, CostumerName, CostumerSurename, address, number, studentStatus);


        } catch (Exception e) {
            System.out.println("ModelError> edit/" + e);
        }
        return Response.status(200).entity("done").build();
    }
}
