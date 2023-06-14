package com.example.movie.Controller;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@RestController
@RequestMapping("/movies")
@CrossOrigin("*")
public class MovieController {

    private static final String RAPID_API_KEY = "d92c3e1fcfmshef81bb9b5397c4cp11b60fjsn72ac60f80d5f";
    private static final String RAPID_API_HOST = "imdb-top-100-movies.p.rapidapi.com";
    private static final String API_URL = "https://imdb-top-100-movies.p.rapidapi.com/";

    @GetMapping
    public String getMovies() {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(API_URL);
        request.setHeader("X-RapidAPI-Key", RAPID_API_KEY);
        request.setHeader("X-RapidAPI-Host", RAPID_API_HOST);

        try {
            HttpResponse response = httpClient.execute(request);
            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            return result.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "Error occurred while fetching movies.";
        }
    }
}

