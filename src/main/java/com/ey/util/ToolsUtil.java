package com.ey.util;

public class ToolsUtil {

    public static final String getUuid() {
        String result = java.util.UUID.randomUUID().toString();
        result.replaceAll("-", "");
        result.substring(0, 32);
        return result;
    }
}
