package se.kth.wwnr.patientjournal.keycloak;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAccessHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException {
        // Log the exception or print a message
        System.out.println("Access Denied: " + accessDeniedException.getMessage());
        // You can also redirect or respond with an error status
        response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied");
    }

}
