package com.formento.search.pipeline.simplepipeline;

import java.io.Serializable;

public class SimpleProduct implements Serializable {

    private final String id;
    private final String title;

    public SimpleProduct(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

}
