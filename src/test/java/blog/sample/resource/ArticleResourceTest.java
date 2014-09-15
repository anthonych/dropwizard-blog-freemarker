package blog.sample.resource;


import blog.sample.core.Article;
import blog.sample.core.User;
import blog.sample.dao.ArticleDAO;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

public class ArticleResourceTest {

    private static final ArticleDAO articleDAO = mock(ArticleDAO.class);
    private static final Article article1 = new Article();
    private static final Article article2 = new Article();
    private static final List<Article> articles = new ArrayList<Article>();

    @ClassRule
    public static final ResourceTestRule resource = ResourceTestRule.builder().addResource(
            new ArticleResource(articleDAO)).build();

    @Before
    public void setUp() throws Exception {
        User author = createTestUser();
        createTestArticle(author);

        articles.add(article1);
        articles.add(article2);

        when(articleDAO.findById(eq("id1"))).thenReturn(article1);
        reset(articleDAO);
    }

    private void createTestArticle(User author) {
        article1.setId("id1");
        article1.setHeadline("First blog post");
        article1.setBody("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ducimus, vero, obcaecati, aut, error quam sapiente nemo saepe quibusdam sit excepturi nam quia corporis eligendi eos magni recusandae laborum minus inventore?\\n\\nLorem ipsum dolor sit amet, consectetur adipisicing elit. Ut, tenetur natus doloremque laborum quos iste ipsum rerum obcaecati impedit odit illo dolorum ab tempora nihil dicta earum fugiat. Temporibus, voluptatibus.\\n\\nLorem ipsum dolor sit amet, consectetur adipisicing elit. Eos, doloribus, dolorem iusto blanditiis unde eius illum consequuntur neque dicta incidunt ullam ea hic porro optio ratione repellat perspiciatis. Enim, iure!\\n\\nLorem ipsum dolor sit amet, consectetur adipisicing elit. Error, nostrum, aliquid, animi, ut quas placeat totam sunt tempora commodi nihil ullam alias modi dicta saepe minima ab quo voluptatem obcaecati?\\n\\nLorem ipsum dolor sit amet, consectetur adipisicing elit. Harum, dolor quis. Sunt, ut, explicabo, aliquam tenetur ratione tempore quidem voluptates cupiditate voluptas illo saepe quaerat numquam recusandae? Qui, necessitatibus, est!");
        article1.setPostDate(new Timestamp(1410530400000L));
        article1.setUpdateDate(null);
        article1.setAuthor(author);

        article2.setId("id2");
        article2.setHeadline("Second blog post");
        article2.setBody("Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus. ");
        article2.setPostDate(new Timestamp(1410566400000L));
        article2.setUpdateDate(null);
        article2.setAuthor(author);
    }

    private User createTestUser() {
        User author = new User();
        author.setId("id1");
        author.setName("anthonychen");
        author.setEmail("anthonychen@gmail.com");
        author.setPassword("");
        return author;
    }

    @Test
    public void testGetArticle() throws Exception {
        assertThat(resource.client().resource("/article/api/id1").get(Article.class)).isEqualTo(article1);
        verify(articleDAO).findById("id1");
    }
}