package blog.sample.resource;

import blog.sample.core.Article;
import blog.sample.dao.ArticleDAO;
import blog.sample.view.ArticleListView;
import blog.sample.view.ArticleView;
import com.codahale.metrics.annotation.Timed;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by anthonychen on 9/14/14.
 */

@Path("/blog/article")
@Produces(MediaType.APPLICATION_JSON)
public class ArticleResource {

    private ArticleDAO articleDAO;

    public ArticleResource(ArticleDAO articleDAO) {
        this.articleDAO = articleDAO;
    }

    @GET
    @Timed
    @UnitOfWork
    @Path("/view/all")
    @Produces(MediaType.TEXT_HTML)
    public ArticleListView viewAllArticles() {
        return new ArticleListView(articleDAO.findAll());
    }


    @GET
    @Timed
    @UnitOfWork
    @Path("/view/{id}")
    @Produces(MediaType.TEXT_HTML)
    public ArticleView viewArticle(@PathParam("id") String id) {

        return new ArticleView(articleDAO.findById(id));
    }

    public ArticleView createArticle(Article article){
        

        return null;
    }



    @GET
    @Timed
    @UnitOfWork
    @Path("/api/{id}")
    public Article getArticle(@PathParam("id") String id) {
        return articleDAO.findById(id);
    }

    @GET
    @Timed
    @UnitOfWork
    @Path("/api/all")
    public List<Article> getAllArticles() {
        return articleDAO.findAll();
    }

}
