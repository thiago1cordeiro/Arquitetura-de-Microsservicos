package br.com.microservices.orchestrated.inventoryservice.core.consumer;

import br.com.microservices.orchestrated.inventoryservice.core.ultils.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class InventoryConsumer {
    
    private final JsonUtil jsonUtil;
    
    @KafkaListener(
            groupId = "${spring.kafka.consumer.group-id}",
            topics = "${spring.kafka.topic.inventory-success}"
    )
    public void consumerSuccessEvent(String payload) {
        log.info("Receiving success event {} from inventory-success topic", payload);
        
        var event = jsonUtil.toEvent(payload);
        
        log.info(event.toString());
    }
    
    @KafkaListener(
            groupId = "${spring.kafka.consumer.group-id}",
            topics = "${spring.kafka.topic.inventory-fail}"
    )
    public void consumerFailEvent(String payload) {
        log.info("Receiving rollback event {} from inventory-fail topic", payload);
        
        var event = jsonUtil.toEvent(payload);
        
        log.info(event.toString());
    }
}
