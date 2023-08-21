package com.edddoubled.jubileenotifybot.controller;

import com.edddoubled.jubileenotifybot.telegram.JubileeNotifyBot;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * The controller is required to access the bot
 */
@RestController
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class WebHookController {

    JubileeNotifyBot jubileeNotifyBot;

    @PostMapping
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {
        return jubileeNotifyBot.onWebhookUpdateReceived(update);
    }
}
