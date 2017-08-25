package com.epam.lab3.dao;

import com.epam.lab3.models.Category;
import com.epam.lab3.models.News;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class NewsDAO {
    private static final Logger logger = Logger.getLogger(NewsDAO.class.getName());
    private final static List<News> newsList;
    private static List<Category> categoryList;

    static {
        newsList = new ArrayList<>();
        categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Business"));
        categoryList.add(new Category(2, "Society"));
        categoryList.add(new Category(3, "Technology"));
        categoryList.add(new Category(4, "Sport"));
        categoryList.add(new Category(5, "Kriminal"));
        categoryList.add(new Category(6, "Hobby"));
        newsList.add(new News("FC Karpaty lose as always", categoryList.get(3), "Mariupol - Karpaty: 3-0", "On Sunday played FC Mariupol with FC Karpaty. FC Karpaty lose with score 0:3 and ...", "Karpaty#loser"));
        newsList.add(new News("FC Karpaty2 lose as always", categoryList.get(0), "Mariupol2 - Karpaty2: 3-0", "On Sunday played FC Mariupol with FC Karpaty. FC Karpaty lose with score 0:3 and ...", "Karpaty2#loser"));
        newsList.add(new News("FC Karpaty3 lose as always", categoryList.get(5), "Mariupol3 - Karpaty3: 3-0", "On Sunday played FC Mariupol with FC Karpaty. FC Karpaty lose with score 0:3 and ...", "Karpaty3#loser"));

        logger.info("Created Newspaper DB and three news was added");
    }

    public static void setCategoryList(List<Category> list) {
        categoryList = list;
    }

    public static List<News> getNewsList() {
        return newsList;
    }

    public static News addNews(News newNews) {
        logger.info("Add News");
        newsList.add(newNews);
        return newNews;
    }

    public static News getNews(int newsID) {
        logger.info("Get News by ID");
        return newsList.get(newsID - 1);
    }

    public static boolean updateNews(int newsID, String news) {
        logger.info("Update text in News by ID");
        News newsForUpdate = newsList.get(newsID - 1);
        if(newsForUpdate != null){
            newsForUpdate.setNews(news);
            return true;
        }else
            return false;
    }

    public static List<News> getAllNewsByCategory(int categoryID) {
        logger.info("Get ");
        List<News> listNewsByCategory = new ArrayList<>();
        for (News news : newsList){
            if(news.getCategory().equals(categoryList.get(categoryID-1)))
                listNewsByCategory.add(news);
        }
        return listNewsByCategory;
    }

    public static List<Category> getAllCategories() {
        Set<Category> setAllCategories = new LinkedHashSet<>();
        for (News news : newsList){
            setAllCategories.add(news.getCategory());
        }
        List<Category> list = new ArrayList<>(setAllCategories);
        return list;
    }
}
