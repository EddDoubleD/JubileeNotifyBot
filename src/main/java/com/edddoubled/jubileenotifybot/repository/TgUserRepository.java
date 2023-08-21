package com.edddoubled.jubileenotifybot.repository;

import com.edddoubled.jubileenotifybot.model.TgUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TgUserRepository extends JpaRepository<TgUser, Long> {
}
