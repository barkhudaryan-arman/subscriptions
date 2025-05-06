package pro.nxs.subscriptions.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long userId) {
        super("Пользователь не найден: " + userId);
    }
}
