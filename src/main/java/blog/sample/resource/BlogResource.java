package blog.sample.resource;

import blog.sample.dao.ArticleDAO;
import blog.sample.view.ArticleListView;
import com.codahale.metrics.annotation.Timed;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by anthonychen on 9/11/14.
 */

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class BlogResource {

    private ArticleDAO articleDAO;

    public BlogResource(ArticleDAO articleDAO) {
        this.articleDAO = articleDAO;
    }

    @GET
    @Timed
    @UnitOfWork
    @Produces(MediaType.TEXT_HTML)
    public ArticleListView viewHome() {
        return new ArticleListView(articleDAO.findAll());
    }

}
