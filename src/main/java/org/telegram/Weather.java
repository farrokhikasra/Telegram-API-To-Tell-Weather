package org.telegram;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Weather {
    private static final String API_KEY = "bb9b25cbf19d44d6ba2203006231509";
    private static Weather weather;

    private Weather() {

    }

    public static Weather getInstance() {
        if (weather == null) {
            weather = new Weather();
            return weather;
        }
        return weather;
    }

    public URL requestURL(String city) {
        URL request_URL;
        try {
            request_URL = new URL(
                    "http://api.weatherapi.com/v1/current.json?key=" + API_KEY + "&q=" + city + "&aqi=no");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return request_URL;
    }

    public JSONObject sendWeatherRequest(URL url) throws IOException, ParseException {
        InputStreamReader in = new InputStreamReader(url.openStream());
        JSONParser parser = new JSONParser();
        JSONObject json;
        json = (JSONObject) parser.parse(in);
        return json;
    }

    public String trimJson(@NotNull JSONObject json) {
        JSONObject current = (JSONObject) json.get("current");
        List<String> neededInfo = new ArrayList<>();
        neededInfo.add("Feels like: " + current.get("feelslike_c").toString());
        neededInfo.add("UV: " + current.get("uv").toString());
        neededInfo.add("Last updated: " + current.get("last_updated").toString());
        return neededInfo.toString();
    }

    public String weatherPredictionPlatform(String city) throws IOException, ParseException {
        URL url = requestURL(city);
        JSONObject jsonObject = sendWeatherRequest(url);
        ObjectMapper mapper = new ObjectMapper();
        CurrentWeatherDataModel currentWeatherDataModel = mapper.readValue((jsonObject.get("current")).toString(),
                CurrentWeatherDataModel.class);
        return currentWeatherDataModel.toString();
    }
}

