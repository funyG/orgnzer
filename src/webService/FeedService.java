package webService;

import com.google.gson.Gson;
import dto.FeedObjects;
import model.ProjectManager;

import javax.ws.rs.*;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.ArrayList;

@Path("/Products")
@Provider
public class FeedService implements ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext request,
                       ContainerResponseContext response) throws IOException {
        response.getHeaders().add("Access-Control-Request-Headers", "X-Requested-With, accept, content-type");
        response.getHeaders().add("Access-Control-Allow-Methods", "GET, POST");
        response.getHeaders().add("Access-Control-Allow-Origin", "http://localhost:4200");
    }

    @GET
    @Path("/product/{id}")
    @Produces("application/json")
    public Response feed(@PathParam("id") Integer id) {
        String feeds = null;
        try {
            ArrayList<FeedObjects> feedData = null;
            ProjectManager projectManager = new ProjectManager();
            feedData = projectManager.GetProductById(id);
            //StringBuffer sb = new StringBuffer();
            Gson gson = new Gson();
            System.out.println(gson.toJson(feedData));
            feeds = gson.toJson(feedData);
            System.out.println(" !!!!problem >>>>>" + feedData);

        } catch (Exception e) {
            System.out.println(e);
        }
        return Response.status(200)
                .header("Access-Control-Request-Headers", "X-Requested-With, accept, content-type")
                .header("Access-Control-Allow-Methods", "GET, POST")
                .header("Access-Control-Allow-Origin", "http://localhost:4200")
                .entity(feeds).build();
    }

    @GET
    @Path("/all/")
    @Produces("application/json")
    public Response agents() {
        String feeds = null;
        try {
            ArrayList<FeedObjects> feedData = null;
            ProjectManager projectManager = new ProjectManager();
            feedData = projectManager.GetAllProducts();
            //StringBuffer sb = new StringBuffer();
            Gson gson = new Gson();
            System.out.println(gson.toJson(feedData));
            feeds = gson.toJson(feedData);

        } catch (Exception e) {
            System.out.println("error");
        }
        return Response.status(200)
                .header("Access-Control-Request-Headers", "X-Requested-With, accept, content-type")
                .header("Access-Control-Allow-Methods", "GET, POST")
                .header("Access-Control-Allow-Origin", "http://localhost:4200")
                .entity(feeds).build();
    }


    @GET
    @Path("/category/all")
    @Produces("application/json")
    public Response Categories() {
        String nullObj = null;
        try {
            ArrayList<FeedObjects> data = null;
            ProjectManager projectManager = new ProjectManager();
            data = projectManager.Categories();
            Gson jsonObjekt = new Gson();
            nullObj = jsonObjekt.toJson(data);

        } catch (Exception e) {
            System.out.println("Category<FEEDob>" + e);
        }
        System.out.println("null object returnes ===>>>" + nullObj);
        return Response.status(200).entity(nullObj)
                .header("Access-Control-Request-Headers", "X-Requested-With, accept, content-type")
                .header("Access-Control-Allow-Methods", "GET, POST")
                .header("Access-Control-Allow-Origin", "http://localhost:4200")
                .build();
    }

    @GET
    @Path("/subcategory/all")
    @Produces("application/json")
    public Response SubCategoriesAll() {
        String Subcat = null;
        try {
            ArrayList<FeedObjects> data = null;
            ProjectManager projectManager = new ProjectManager();
            data = projectManager.Subcategories();
            Gson jsonObjekt = new Gson();
            Subcat = jsonObjekt.toJson(data);

        } catch (Exception e) {
            System.out.println("Category<FEEDob>" + e);
        }
        System.out.println("null object returnes ===>>>" + Subcat);
        return Response.status(200).entity(Subcat)
                .header("Access-Control-Request-Headers", "X-Requested-With, accept, content-type")
                .header("Access-Control-Allow-Methods", "GET, POST")
                .header("Access-Control-Allow-Origin", "http://localhost:4200")
                .build();
    }


    @GET
    @Path("/category/{id}/all")
    @Produces("application/json")
    public Response productsInCategory(@PathParam("id") Integer id) {
        String productsCategory = null;
        try {
            ArrayList<FeedObjects> data = null;
            ProjectManager projectManager = new ProjectManager();
            data = projectManager.SubCategoryToCategory(id);
            Gson jsonObjekt = new Gson();
            productsCategory = jsonObjekt.toJson(data);

        } catch (Exception e) {
            System.out.println("Category<FEEDob>" + e);
        }
        System.out.println("SubCategoryCategorys===>>>" + productsCategory);
        return Response.status(200).entity(productsCategory)
                .header("Access-Control-Request-Headers", "X-Requested-With, accept, content-type")
                .header("Access-Control-Allow-Methods", "GET, POST")
                .header("Access-Control-Allow-Origin", "http://localhost:4200")
                .build();
    }

    @GET
    @Path("/subcategory/{id}")
    @Produces("application/json")
    public Response ProductsInSubcategory(@PathParam("id") Integer id) {
        String productsCategory = null;
        try {
            ArrayList<FeedObjects> data = null;
            ProjectManager projectManager = new ProjectManager();
            data = projectManager.SubCategoryToCategory(id);
            Gson jsonObjekt = new Gson();
            productsCategory = jsonObjekt.toJson(data);

        } catch (Exception e) {
            System.out.println("Category<FEEDob>" + e);
        }
        System.out.println("SubCategoryCategory===>>>" + productsCategory);
        return Response.status(200).entity(productsCategory)
                .header("Access-Control-Request-Headers", "X-Requested-With, accept, content-type")
                .header("Access-Control-Allow-Methods", "GET, POST")
                .header("Access-Control-Allow-Origin", "http://localhost:4200")
                .build();
    }

    @GET
    @Path("/subcategory/{id}/all")
    @Produces("application/json")
    public Response SubCatAll(@PathParam("id") Integer id) {
        String productsCategory = null;
        try {
            ArrayList<FeedObjects> data = null;
            ProjectManager projectManager = new ProjectManager();
            data = projectManager.ProductsInSubCategory(id);
            Gson jsonObjekt = new Gson();
            productsCategory = jsonObjekt.toJson(data);

        } catch (Exception e) {
            System.out.println("SubCategories<FEEDob>" + e);
        }
        System.out.println("subcategoryAll===>>>" + productsCategory);
        return Response.status(200).entity(productsCategory)
                .header("Access-Control-Request-Headers", "X-Requested-With, accept, content-type")
                .header("Access-Control-Allow-Methods", "GET, POST")
                .header("Access-Control-Allow-Origin", "http://localhost:4200")
                .build();
    }

    // vzame dan in pokaze vse agente v tistem dnevu odsotne
    //    }

    //        return Response.status(200).entity(q).build();
//        }
//
//        } catch (Exception e ) {
//            System.out.println("ITERATOR" + gson.toJson(DataFromAbscence));
//
//            q = gson.toJson(DataFromAbscence);
//            Gson gson = new Gson();
//            DataFromAbscence = AbModel.GetAbscenceDay(Day);
//            ArrayList<FeedObjects> DataFromAbscence = null;
//            ProjectManager AbModel = new ProjectManager();
//        try {
//        String q = null;
//    public Response AbscenceByDAy(@PathParam("day") Integer Day) {
//    @Path("/abscence/{day}")
//    @GET
//    @POST
//    @Path("/order/")
//    public Response getUsers(
//            @QueryParam("id") Integer id,
//            @QueryParam("firstname") String firstname,
//            @QueryParam("lastname") String lastname,
//            @QueryParam("hours") String hours,
//            @QueryParam("group_id") String group_id,
//            @QueryParam("proffesion") String proffesion) {
//        String feeds = null;  // -todo POMOJE TO NE RABIŠ
//        try {
//            ProjectManager model = new ProjectManager();
//            model.AddAgent(id, firstname, lastname, hours, group_id, proffesion);
//
//
//        } catch (Exception e) {
//            System.out.println("error");
//        }
//        return Response.status(200).entity("getUsers is called, from : " + firstname + ", to : " + lastname + ", orderBy").build();
//
    }




