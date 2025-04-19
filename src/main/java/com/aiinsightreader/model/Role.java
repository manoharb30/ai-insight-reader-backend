package com.aiinsightreader.model;

public enum Role {
    ADMIN,
    USER,
    FREE,
    VIEWER;

    public static String[] names() {
        return new String[]{ADMIN.name(), USER.name(), FREE.name(),VIEWER.name()};
    }
}
