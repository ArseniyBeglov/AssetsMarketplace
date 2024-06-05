package ru.mycompany.assetsmarketplace.asset.dto;

import ru.mycompany.assetsmarketplace.asset.model.Asset;
import ru.mycompany.assetsmarketplace.user.model.User;

public interface AssetMapper {
    AssetDto toDto(Asset asset);

    Asset fromDto(AssetDto assetDto, User user);
}
