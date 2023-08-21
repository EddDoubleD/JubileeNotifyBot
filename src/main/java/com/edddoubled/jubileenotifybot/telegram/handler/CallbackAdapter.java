package com.edddoubled.jubileenotifybot.telegram.handler;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Map;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class CallbackAdapter implements CallbackHandler<Update> {
    private static final String MESSAGE = "message";
    private static final String QUERY = "query";

    Map<String, CallbackHandler<CallbackQuery>> handlers;

    @Override
    public BotApiMethod<?> process(Update update) {
        if (update.hasCallbackQuery()) {
            return handlers.get(QUERY).process(update.getCallbackQuery());
        }

        return handlers.get(MESSAGE).process(update.getCallbackQuery());
    }
}
