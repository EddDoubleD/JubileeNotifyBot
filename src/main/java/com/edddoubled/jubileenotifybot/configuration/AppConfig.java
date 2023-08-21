package com.edddoubled.jubileenotifybot.configuration;

import com.edddoubled.jubileenotifybot.telegram.JubileeNotifyBot;
import com.edddoubled.jubileenotifybot.telegram.handler.CallbackAdapter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;

@Configuration
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AppConfig {
    TelegramConfig telegramConfig;

    @Bean
    public SetWebhook setWebhookInstance() {
        return SetWebhook.builder().url(telegramConfig.getWebhookPath()).build();
    }

    @Bean
    public JubileeNotifyBot jubileeNotifyBot(SetWebhook setWebhook, CallbackAdapter adapter) {
        JubileeNotifyBot bot = new JubileeNotifyBot(setWebhook, adapter);
        bot.setBotPath(telegramConfig.getWebhookPath());
        bot.setBotToken(telegramConfig.getBotToken());
        bot.setBotUsername(telegramConfig.getBotName());

        return bot;
    }
}
