package com.edddoubled.jubileenotifybot.telegram.handler;

import com.edddoubled.jubileenotifybot.service.TgUserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;

@Component("message")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@Slf4j
public class MessageHandler implements CallbackHandler<Message> {

    TgUserService tgUserService;

    private static final String START = "/start";
    private static final String SAY_HELLO = "/say_hello";

    @Override
    public BotApiMethod<?> process(Message message) {
        final String chatId = message.getChatId().toString();
        final User user = message.getFrom();
        if (tgUserService.getUserById(user).isEmpty()) {
            tgUserService.save(user);
        }

        final String text = message.getText();

        log.info("get message {} from chat {}", text, chatId);
        if (START.equals(text)) {
            return new SendMessage(chatId, "Get start ?");
        } else if (SAY_HELLO.equals(text)) {
            return new SendMessage(chatId, String.format("Hello, %s", user.getUserName()));
        }

        return new SendMessage(chatId, "Command not found");
    }
}
