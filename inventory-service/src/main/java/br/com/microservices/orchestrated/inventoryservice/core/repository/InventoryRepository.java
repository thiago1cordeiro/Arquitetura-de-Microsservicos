package br.com.microservices.orchestrated.inventoryservice.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.microservices.orchestrated.inventoryservice.core.model.Inventory;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
    
    Optional<Inventory> findByProductCode(String productCode);
    
}
