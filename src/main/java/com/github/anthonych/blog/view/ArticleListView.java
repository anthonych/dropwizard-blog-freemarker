package com.github.anthonych.blog.view;

import com.github.anthonych.blog.core.Article;
import io.dropwizard.views.View;

import java.util.List;

/**
 * Created by anthonychen on 9/12/14.
 */
public class ArticleListView extends View {

    final List<Article> articles;

    public ArticleListView(List<Article> articles) {
        super("list-article.ftl");
        this.articles = articles;
    }

    public List<Article> getArticles() {
        return articles;
    }
}
