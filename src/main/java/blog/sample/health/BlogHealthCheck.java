package blog.sample.health;

import com.codahale.metrics.health.HealthCheck;

public class BlogHealthCheck extends HealthCheck {

    private final String checkStr;

    public BlogHealthCheck(String checkStr) {
        this.checkStr = checkStr;
    }

    @Override
    protected Result check() throws Exception {
        if (checkStr != null && checkStr.equalsIgnoreCase("Test")) {
            return Result.healthy();
        }

        return Result.unhealthy("Service Unavailable.");
    }
}
