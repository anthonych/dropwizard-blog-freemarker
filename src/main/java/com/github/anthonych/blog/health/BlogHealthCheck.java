package com.github.anthonych.blog.health;

import com.codahale.metrics.health.HealthCheck;
import org.hibernate.SessionFactory;

public class BlogHealthCheck extends HealthCheck {

    private final SessionFactory database;

    public BlogHealthCheck(SessionFactory database) {
        this.database = database;
    }

    @Override
    protected Result check() throws Exception {
        if (database.openSession().isConnected()) {
            return Result.healthy();
        }

        return Result.unhealthy("Service Unavailable.");
    }
}
