package com.edddoubled.jubileenotifybot.telegram.handler;

import org.telegram.telegrambots.meta.api.interfaces.BotApiObject;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;

/**
 * Bot Event Handling
 * @param <T> typed request for processing
 */
public interface CallbackHandler<T extends BotApiObject> {

    /**
     * Request processing logic
     *
     * @param query typed request for processing
     * @return bot api method
     */
    BotApiMethod<?> process(T query);
}
