package blog.sample.dao;

import blog.sample.core.Article;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class ArticleDAO extends AbstractDAO<Article> {

    public ArticleDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Article findById(String id) {
        return get(id);
    }

    public List<Article> findAll() {

        return list(namedQuery("Article.findAll"));
    }

    public Article saveArticle(Article article) {

        return persist(article);
    }
}
