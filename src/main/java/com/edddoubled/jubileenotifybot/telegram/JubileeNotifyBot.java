package com.edddoubled.jubileenotifybot.telegram;

import com.edddoubled.jubileenotifybot.telegram.handler.CallbackAdapter;
import com.edddoubled.jubileenotifybot.telegram.handler.CallbackHandler;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.starter.SpringWebhookBot;

/**
 * actually here is the shell of the bot itself
 */
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JubileeNotifyBot extends SpringWebhookBot {

    String botPath;
    String botUsername;
    String botToken;

    CallbackHandler<Update> callbackHandler;

    public JubileeNotifyBot(SetWebhook setWebhook, CallbackHandler<Update> callbackHandler) {
        super(setWebhook);

        this.callbackHandler = callbackHandler;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        return callbackHandler.process(update);
    }
}
