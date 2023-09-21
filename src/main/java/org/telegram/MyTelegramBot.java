package org.telegram;

import com.fasterxml.jackson.core.JsonProcessingException;
import javassist.expr.Instanceof;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.json.simple.parser.ParseException;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;

public class MyTelegramBot extends TelegramLongPollingBot {
    private Weather weather;

    public MyTelegramBot() {
        weather = Weather.getInstance();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String text_messsage = update.getMessage().getText();
            String chat_id = update.getMessage().getChatId().toString();
            if (text_messsage.equals("/start")) {
                sendMsg(chat_id, "Please enter the name of the city you want to know the weather!");
                return;
            }
            String weatherResponse;
            try {
                weatherResponse = weather.weatherPredictionPlatform(text_messsage);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            sendMsg(chat_id, weatherResponse);
        }

    }

    public synchronized void sendMsg(String chat_id, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chat_id);
        sendMessage.setText(s);
        try {
            execute(sendMessage);

        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getBotUsername() {
        return "kasrafarrokhibot";
    }


    @Override
    public String getBotToken() {
        return "6162883956:AAFBC_TSdLHMAJ3hPl0OMCGqAJ2U-c3ToHE";
    }
}
