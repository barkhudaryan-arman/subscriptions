package pro.nxs.subscriptions.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.nxs.subscriptions.service.SubscriptionService;

import java.util.List;

@RestController
@RequestMapping("/subscriptions")
@RequiredArgsConstructor
public class TopSubscriptionController {
    private final SubscriptionService subscriptionService;

    @GetMapping("/top")
    public ResponseEntity<List<String>> getTopSubscriptions() {
        return ResponseEntity.ok(subscriptionService.getTop3Subscriptions());
    }
}
