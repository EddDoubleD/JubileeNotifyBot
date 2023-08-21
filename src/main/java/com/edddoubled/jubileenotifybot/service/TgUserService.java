package com.edddoubled.jubileenotifybot.service;

import com.edddoubled.jubileenotifybot.model.TgUser;
import com.edddoubled.jubileenotifybot.repository.TgUserRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.User;

import java.util.Optional;

@Component
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class TgUserService {

    TgUserRepository userRepository;

    public Optional<TgUser> getUserById(User user) {
        return userRepository.findById(user.getId());
    }
    
    public void save(User user) {
        TgUser tgUser = new TgUser();
        tgUser.setId(user.getId());
        tgUser.setUsername(user.getUserName());

        userRepository.save(tgUser);
    }
}
