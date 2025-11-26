package org.example.ecommercebackendapplication.utils;

import lombok.experimental.UtilityClass;
import org.springframework.security.core.context.SecurityContextHolder;

@UtilityClass
public class AuthContext {

    public static Long getUserId() {
        var auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null) return null;

        Object details = auth.getDetails();

        if (details instanceof Long) {
            return (Long) details;
        }

        return null;
    }

    public static String getUsername() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        return auth != null ? auth.getName() : null;
    }
}
