package ru.mycompany.assetsmarketplace.asset.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mycompany.assetsmarketplace.asset.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
