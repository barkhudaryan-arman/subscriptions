package pro.nxs.subscriptions.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pro.nxs.subscriptions.dto.SubscriptionRequest;
import pro.nxs.subscriptions.exception.UserNotFoundException;
import pro.nxs.subscriptions.model.Subscription;
import pro.nxs.subscriptions.model.User;
import pro.nxs.subscriptions.repository.SubscriptionRepository;
import pro.nxs.subscriptions.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;
    private final UserRepository userRepository;

    public Subscription addSubscription(Long userId, SubscriptionRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
        Subscription subscription = new Subscription();
        subscription.setServiceName(request.getServiceName());
        subscription.setUser(user);
        subscription.setCreatedAt(LocalDateTime.now());
        log.info("Добавление подписки для пользователя {}", userId);
        return subscriptionRepository.save(subscription);
    }

    public List<Subscription> getSubscriptionsByUserId(Long userId) {
        return subscriptionRepository.findByUserId(userId);
    }

    public void deleteSubscription(Long subscriptionId) {
        subscriptionRepository.deleteById(subscriptionId);
        log.info("Удаление подписки {}", subscriptionId);
    }

    public List<String> getTop3Subscriptions() {
        return subscriptionRepository.findTopSubscriptions(PageRequest.of(0, 3))
                .stream()
                .map(res -> (String) res[0])
                .collect(Collectors.toList());
    }
}
