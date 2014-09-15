package blog.sample.view;

import blog.sample.core.Article;
import io.dropwizard.views.View;

/**
 * Created by anthonychen on 9/14/14.
 */
public class ArticleView extends View {

    final Article article;

    public ArticleView(String template, Article article) {
        super(template);
        this.article = article;
    }

    public Article getArticle() {
        return article;
    }
}
