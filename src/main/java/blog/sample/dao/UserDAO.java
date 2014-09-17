package blog.sample.dao;

import blog.sample.core.User;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

/**
 * Created by anthonychen on 9/17/14.
 */
public class UserDAO extends AbstractDAO<User> {

    public UserDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public User findById(String id) {
        return get(id);
    }
}
