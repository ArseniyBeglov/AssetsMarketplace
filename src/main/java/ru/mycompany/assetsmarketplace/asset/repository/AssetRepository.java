package ru.mycompany.assetsmarketplace.asset.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mycompany.assetsmarketplace.asset.model.Asset;

public interface AssetRepository extends JpaRepository<Asset, Long> {
}
