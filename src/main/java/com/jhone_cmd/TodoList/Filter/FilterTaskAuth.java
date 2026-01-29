package com.jhone_cmd.TodoList.Filter;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        String authEncoded = authHeader.substring("Basic".length()).trim();

        byte[] authDecoded = java.util.Base64.getDecoder().decode(authEncoded);

        String authString = new String(authDecoded);
        String[] authParts = authString.split(":");

        String email = authParts[0];
        String password = authParts[1];

        System.out.println(email);
        System.out.println(password);

    }
}