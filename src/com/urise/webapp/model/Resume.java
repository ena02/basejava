package com.urise.webapp.model;

/**
 * Initial resume class
 */
public class Resume {

    // Unique identifier
    private String uuid;

    @Override
    public String toString() {
        return uuid;
    }

    @Override
    public boolean equals(Object obj) {
        return this.uuid == obj;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}

