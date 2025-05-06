package pro.nxs.subscriptions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.nxs.subscriptions.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
