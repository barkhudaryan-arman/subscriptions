package pro.nxs.subscriptions.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pro.nxs.subscriptions.dto.UserRequest;
import pro.nxs.subscriptions.exception.UserNotFoundException;
import pro.nxs.subscriptions.model.User;
import pro.nxs.subscriptions.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public User createUser(UserRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        log.info("Создание пользователя {}", user.getEmail());
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public User uodateUser(Long id, UserRequest request) {
        User user = getUserById(id);
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        log.info("Обновление данных пользователя {}", id);
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        User user = getUserById(id);
        userRepository.delete(user);
        log.info("Удаление пользователя {}", id);
    }
}
