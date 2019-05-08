package io.alauda.jenkins.devops.sync.var;

import java.util.Map;

public class AlaudaContext {
    private String namespace;
    private String name;
    private Map<String, String> data;

    public String getNamespace() {
        return namespace;
    }

    public String getName() {
        return name;
    }

    public String getItem(String key) {
        return data.get(key);
    }

    public boolean isSupport() {
        return true;
    }
}


alaudaContext.namespace
alaudaContext.getItem("fff")