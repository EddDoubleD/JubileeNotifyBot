package com.edddoubled.jubileenotifybot.telegram.handler;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component("adapter")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class CallbackAdapter implements CallbackHandler<Update> {
    MessageHandler messageHandler;
    CallbackQueryHandler callbackQueryHandler;

    @Override
    public BotApiMethod<?> process(Update update) {
        if (update.hasCallbackQuery()) {
            return callbackQueryHandler.process(update.getCallbackQuery());
        } else if (update.hasMessage()) {
            return messageHandler.process(update.getMessage());
        }

        return null;
    }
}
