package com.epam.lab3.models;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name="News")
public class News implements Serializable{
    private static final long serialVersionUID = 2776029553016531145L;

    private String title;
    private Category category;
    private String description;
    private String news;
    private String textLink;

    public News() {
    }

    public News(String title, Category category, String description, String news, String textLink) {
        this.title = title;
        this.category = category;
        this.description = description;
        this.news = news;
        this.textLink = textLink;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTextLink() {
        return textLink;
    }

    public void setTextLink(String textLink) {
        this.textLink = textLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News news1 = (News) o;

        if (!title.equals(news1.title)) return false;
        if (!category.equals(news1.category)) return false;
        if (!description.equals(news1.description)) return false;
        if (!news.equals(news1.news)) return false;
        return textLink.equals(news1.textLink);

    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + category.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + news.hashCode();
        result = 31 * result + textLink.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "News{" +
                "category=" + category +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", news='" + news + '\'' +
                ", textLink='" + textLink + '\'' +
                '}';
    }
}
