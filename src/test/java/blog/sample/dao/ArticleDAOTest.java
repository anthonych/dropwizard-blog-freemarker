package blog.sample.dao;

import blog.sample.core.Article;
import blog.sample.core.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SuppressWarnings("JpaQueryApiInspection")
public class ArticleDAOTest {

    private SessionFactory sessionFactory;
    private Session session;
    private Query query;
    private ArticleDAO articleDAO;
    private static final Article article1 = new Article();
    private static final Article article2 = new Article();
    private static final List<Article> articles = new ArrayList<Article>();

    @SuppressWarnings("JpaQueryApiInspection")
    @Before
    public void setUp() throws Exception {
        sessionFactory = mock(SessionFactory.class);
        session = mock(Session.class);
        query = mock(Query.class);

        createTestArticle(createTestUser());
    }

    @Test
    public void testFindById() throws Exception {
        articleDAO = new ArticleDAO(sessionFactory);
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        when(session.get(Article.class, "id1")).thenReturn(article1);
        Article actualArticle = articleDAO.findById("id1");
        assertEquals(article1, actualArticle);
    }

    @Test
    public void testFindAll() throws Exception {
        articleDAO = new ArticleDAO(sessionFactory);
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        when(session.getNamedQuery("Article.findAll")).thenReturn(query);
        articles.add(article1);
        articles.add(article2);
        when(query.list()).thenReturn(articles);

        assertNotNull(articleDAO.findAll());
        assertTrue(articleDAO.findAll().size() == 2);
    }

    @Test
    public void testSaveArticle() throws Exception {
        articleDAO = new ArticleDAO(sessionFactory);
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        Article actualArticle = articleDAO.saveArticle(article1);
        assertEquals(article1, actualArticle);
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
}