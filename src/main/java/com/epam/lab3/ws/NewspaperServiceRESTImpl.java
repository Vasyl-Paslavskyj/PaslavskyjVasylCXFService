package com.epam.lab3.ws;

import com.epam.lab3.dao.NewsDAO;
import com.epam.lab3.models.Category;
import com.epam.lab3.models.News;
import com.epam.lab3.modelsWeb.JSONCreator;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

public class NewspaperServiceRESTImpl {
    private static final Logger logger = Logger.getLogger(NewspaperServiceRESTImpl.class.getName());
    private static JSONCreator parser = new JSONCreator();

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/addNews")
    public Response addNews(String newsJSON) {
        News addNews = NewsDAO.addNews((News) parser.unmarshall(newsJSON, News.class));//title, categoryID, description, news, textLink
        if(addNews != null){
            logger.info("Added new" + addNews.toString());
            return Response.status(Response.Status.OK).entity(parser.marshall(addNews)).build();
        } else{
            logger.warn("News wasn't added");
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @GET
    @Produces("application/json")
    @Path("/getNews/{id}")
    public Response getNews(@PathParam("id") int newsID) {
        News getNews = NewsDAO.getNews(newsID);
        if(getNews != null){
            logger.info("Get - " + getNews.toString());
            return Response.status(Response.Status.OK).entity(parser.marshall(getNews)).build();
        }
        else{
            logger.error("There is some problems!!! Check news id");
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/updateNews/{id}")
    public Response updateNews(@PathParam("id") int newsID, String news) {
        boolean isNewsUpdated = NewsDAO.updateNews(newsID, news);
        if(isNewsUpdated){
            logger.info("News with " +newsID +" id was updated");
            return Response.status(Response.Status.OK).entity(parser.marshall(isNewsUpdated)).build();
        }
        else{
            logger.error("There is some problems!!! Check news id");
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Produces("application/json")
    @Path("/getAllNewsByCategory/{id}")
    public Response getAllNewsByCategory(@PathParam("id") int categoryID) {
        List<News> listNewsByCategory = NewsDAO.getAllNewsByCategory(categoryID);
        if(listNewsByCategory != null){
            logger.info("get List News by category id");
            return Response.status(Response.Status.OK).entity(parser.marshallList(listNewsByCategory)).build();
        } else{
            logger.error("There is some problems!!! Check category id");
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Produces("application/json")
    @Path("/getAllCategories")
    public Response getAllCategories() {
        List<Category> categoryList = NewsDAO.getAllCategories();
        if(categoryList != null){
            logger.info("get List categories");
            return Response.status(Response.Status.OK).entity(parser.marshallList(categoryList)).build();
        } else{
            logger.error("There is some problems with method (getAllCategories)!!!");
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}

