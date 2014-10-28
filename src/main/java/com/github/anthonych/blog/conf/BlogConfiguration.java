package com.github.anthonych.blog.conf;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by anthonychen on 9/11/14.
 */
public class BlogConfiguration extends Configuration {

    @NotEmpty
    @JsonProperty("siteName")
    private String siteName;

    @Valid
    @NotNull
    @JsonProperty("database")
    private DataSourceFactory database = new DataSourceFactory();

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public DataSourceFactory getDatabase() {
        return database;
    }
}
