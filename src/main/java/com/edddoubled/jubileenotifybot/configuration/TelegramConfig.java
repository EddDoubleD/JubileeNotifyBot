package com.edddoubled.jubileenotifybot.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class TelegramConfig {
    @Value("${telegram.webhook-path}")
    String webhookPath;
    @Value("${telegram.bot-name}")
    String botName;
    @Value("${telegram.bot-token}")
    String botToken;
}
