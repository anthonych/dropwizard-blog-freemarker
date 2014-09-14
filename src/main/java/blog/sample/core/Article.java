package blog.sample.core;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by anthonychen on 9/9/14.
 */
@Entity
@Table(name = "article", schema = "", catalog = "blog")
@NamedQuery(name = "Article.findAll", query = "from Article")
public class Article {
    private String id;
    private String headline;
    private String body;
    private Timestamp postDate;
    private Timestamp updateDate;
    private User author;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "headline", nullable = true, insertable = true, updatable = true, length = 65535)
    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    @Basic
    @Column(name = "body", nullable = true, insertable = true, updatable = true, length = 2147483647)
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Basic
    @Column(name = "post_date", nullable = true, insertable = true, updatable = true)
    public Timestamp getPostDate() {
        return postDate;
    }

    public void setPostDate(Timestamp postDate) {
        this.postDate = postDate;
    }

    @Basic
    @Column(name = "update_date", nullable = true, insertable = true, updatable = true)
    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;

        if (body != null ? !body.equals(article.body) : article.body != null) return false;
        if (headline != null ? !headline.equals(article.headline) : article.headline != null) return false;
        if (id != null ? !id.equals(article.id) : article.id != null) return false;
        if (postDate != null ? !postDate.equals(article.postDate) : article.postDate != null) return false;
        if (updateDate != null ? !updateDate.equals(article.updateDate) : article.updateDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (headline != null ? headline.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (postDate != null ? postDate.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "author", referencedColumnName = "id")
    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
