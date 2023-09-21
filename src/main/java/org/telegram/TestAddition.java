package org.telegram;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestAddition {
    private static Weather weather;
    private static MyTelegramBot telegramBot;

    @BeforeAll
    public static void init() {

        weather = Weather.getInstance();
        telegramBot = new MyTelegramBot();
    }

    @BeforeEach
    public void load() {
    }

    @Test
    public void testWeatherURL() {
        URL testTehran;
        URL testMontreal;
        try {
            testTehran = new URL("http://api.weatherapi.com/v1/current.json?key=bb9b25cbf19d44d6ba2203006231509&q=Tehran&aqi=no");
            testMontreal = new URL("http://api.weatherapi.com/v1/current.json?key=bb9b25cbf19d44d6ba2203006231509&q=Montreal&aqi=no");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        assertEquals(testTehran, weather.requestURL("Tehran"));
    }

    @Test
    public void testWeatherResponse() throws IOException, ParseException {
        String actualWeather = weather.weatherPredictionPlatform("Montreal");
        System.out.println(actualWeather);
        assertTrue(actualWeather.contains("feelslike_c"));

    }


    @AfterAll
    public static void teardown() {
    }
}
