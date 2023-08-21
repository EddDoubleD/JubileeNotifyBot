package com.edddoubled.jubileenotifybot.telegram.handler;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

@Component("message")
public class MessageHandler implements CallbackHandler<CallbackQuery>{
    @Override
    public BotApiMethod<?> process(CallbackQuery query) {
        return null;
    }
}
