package com.epam.lab3.ws;

import com.epam.lab3.models.Category;
import com.epam.lab3.models.News;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;
import java.util.Set;
import javax.ws.rs.core.Response;

@WebService
public interface NewspaperService {

    @WebMethod
    News addNews(News news);//String title, int categoryID, String description, String news, String textLink

    @WebMethod
    News getNews(int newsID);

    @WebMethod
    boolean updateNews(int newsID, String news);

    @WebMethod
    List<News> getAllNewsByCategory(int categoryID);

    @WebMethod
    List<Category> getAllCategories();
}
