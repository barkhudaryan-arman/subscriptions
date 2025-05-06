package pro.nxs.subscriptions.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pro.nxs.subscriptions.model.Subscription;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    List<Subscription> findByUserId(Long userId);

    @Query("SELECT s.serviceName, COUNT(s) as cnt FROM Subscription s GROUP BY s.serviceName ORDER BY cnt DESC")
    List<Object[]> findTopSubscriptions(Pageable pageable);
}
