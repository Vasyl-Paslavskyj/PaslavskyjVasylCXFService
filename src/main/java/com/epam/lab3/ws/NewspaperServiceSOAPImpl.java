package com.epam.lab3.ws;

import com.epam.lab3.dao.NewsDAO;
import com.epam.lab3.models.Category;
import com.epam.lab3.models.News;
import org.apache.log4j.Logger;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@WebService(endpointInterface = "com.epam.lab3.ws.NewspaperService")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class NewspaperServiceSOAPImpl implements NewspaperService {
    private static final Logger logger = Logger.getLogger(NewspaperServiceRESTImpl.class.getName());

    public void setCategoryList(List<Category> categoryList) {
        NewsDAO.setCategoryList(categoryList);
    }

    public List<News> getNewsList() {
        return NewsDAO.getNewsList();
    }

    @Override
    public News addNews(News news) {
        News addNews = NewsDAO.addNews(news);
        if(addNews != null)
            logger.info("Added new" + addNews.toString());
        else
            logger.warn("News wasn't added");
        return addNews;
    }

    @Override
    public News getNews(int newsID) {
        News getNews = NewsDAO.getNews(newsID);
        if(getNews != null)
            logger.info("Get - " + getNews.toString());
        else
            logger.error("There is some problems!!! Check news id");
        return getNews;
    }

    @Override
    public boolean updateNews(int newsID, String news) {
        boolean isNewsUpdated = NewsDAO.updateNews(newsID, news);
        if(isNewsUpdated)
            logger.info("News with " +newsID +" id was updated");
        else
            logger.error("There is some problems!!! Check news id");
        return isNewsUpdated;
    }

    @Override
    public List<News> getAllNewsByCategory(int categoryID) {
        List<News> listNewsByCategory = NewsDAO.getAllNewsByCategory(categoryID);
        if(listNewsByCategory != null)
            logger.info("get List News by category id");
        else
            logger.error("There is some problems!!! Check category id");
        return listNewsByCategory;
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> categoryList = NewsDAO.getAllCategories();
        if(categoryList != null)
            logger.info("get List categories");
        else
            logger.error("There is some problems with method (getAllCategories)!!!");
        return categoryList;
    }
}
