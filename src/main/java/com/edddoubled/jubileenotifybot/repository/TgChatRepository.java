package com.edddoubled.jubileenotifybot.repository;

import com.edddoubled.jubileenotifybot.model.TgChat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TgChatRepository extends JpaRepository<TgChat, Long> {
}
