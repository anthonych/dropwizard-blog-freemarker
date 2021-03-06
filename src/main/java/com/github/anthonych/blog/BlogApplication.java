package com.github.anthonych.blog;

import com.github.anthonych.blog.conf.BlogConfiguration;
import com.github.anthonych.blog.core.Article;
import com.github.anthonych.blog.dao.ArticleDAO;
import com.github.anthonych.blog.health.BlogHealthCheck;
import com.github.anthonych.blog.resource.ArticleResource;
import com.github.anthonych.blog.resource.BlogResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.hibernate.SessionFactoryHealthCheck;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

/**
 * Created by anthonychen on 9/11/14.
 */
public class BlogApplication extends Application<BlogConfiguration> {

    private final HibernateBundle<BlogConfiguration> hibernateBundle
            = new HibernateBundle<BlogConfiguration>(Article.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(BlogConfiguration configuration) {
            return configuration.getDatabase();
        }
    };

    public static void main(String[] args) throws Exception {
        new BlogApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<BlogConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
        bootstrap.addBundle(new ViewBundle());
        bootstrap.addBundle(new AssetsBundle("/assets/js", "/js", null, "js"));
    }

    @Override
    public void run(BlogConfiguration configuration, Environment environment) throws Exception {
        // Crete DAOs
        final ArticleDAO articleDAO = new ArticleDAO(hibernateBundle.getSessionFactory());

        // Create healthchecks
        final SessionFactoryHealthCheck dbHealthCheck = new SessionFactoryHealthCheck(
                hibernateBundle.getSessionFactory(), configuration.getDatabase().getValidationQuery()
        );

        // Register resources, filters and healthchecks
        environment.jersey().register(new BlogResource(articleDAO));
        environment.jersey().register(new ArticleResource(articleDAO));
        environment.healthChecks().register("databaseHealthcheck", dbHealthCheck);
        environment.healthChecks().register("blogHealthcheck", new BlogHealthCheck(hibernateBundle.getSessionFactory()));
    }
}
