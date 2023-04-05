package com.pskwiercz.inventoryorder;

import com.pskwiercz.inventoryorder.model.Inventory;
import com.pskwiercz.inventoryorder.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryOrderApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
        return args -> {
            Inventory inventory = new Inventory();
            inventory.setSkuCode("iphone_13");
            inventory.setQuantity(100);

            Inventory inventory1 = new Inventory();
            inventory1.setSkuCode("iphone_13_red");
            inventory1.setQuantity( 0);

            inventoryRepository.save(inventory);
            inventoryRepository.save(inventory1 );
        };
    }

}
