package org.example.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class ResourceService {
    private @Value("${resource.location}") String location;

    private final ResourceLoader resourceLoader;

    private ResourceService(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public Resource getResource(){
        return resourceLoader.getResource(location);
    }

    @Value("#{2 > 1 ? 'a' : 'b'}") // a
    private String ternary;

    @Value("#{!true}")
    private boolean not; // false

    public boolean isNot() {
        return not;
    }

    public String getTernary() {
        return ternary;
    }
}
