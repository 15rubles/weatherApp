package com.task.weatherApp.cadence.activities;

import com.task.weatherApp.model.Weather;
import com.task.weatherApp.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.LocalTime;

@Component
@RequiredArgsConstructor
public class ActivitiesImpl implements GetWeatherRespondActivity, PostWeatherInfActivity {

    private final WeatherRepository weatherRepository;

    @Override
    public Double getResponse(String city) {

        String url = "https://api.openweathermap.org/data/2.5/weather?" +
                "q=" + city +
                "&units=metric" +
                "&appid=538a46f6d1e21875b18fce87008adcaa";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        String resStr = response.body();
        JSONObject res = new JSONObject(resStr);

        if (res.getInt("cod") == 200) {
            return res.getJSONObject("main").getDouble("temp");
        } else {
            return null;
        }
    }

    @Override
    public void postWeatherInf(String city, Double temperature) {
        if (temperature != null) {
            weatherRepository.save(Weather.builder()
                    .city(city)
                    .date(LocalDate.now())
                    .time(LocalTime.now())
                    .temperature(temperature)
                    .build());
        }
    }
}