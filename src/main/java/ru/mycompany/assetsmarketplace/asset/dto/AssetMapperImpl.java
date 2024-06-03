package ru.mycompany.assetsmarketplace.asset.dto;

import ru.mycompany.assetsmarketplace.asset.model.Asset;
import ru.mycompany.assetsmarketplace.user.model.User;

public class AssetMapperImpl implements AssetMapper{

    @Override
    public AssetDto toDto(Asset asset) {
        return new AssetDto(
                asset.getId(),
                asset.getName(),
                asset.getDescription(),
                asset.getDetails(),
                asset.getVersion(),
                asset.isArchived(),
                asset.getAssetLink(),
                asset.getImagesLink(),
                asset.getCost(),
                asset.getCategory(),
                asset.getEngine(),
                asset.getPlatform(),
                asset.getPublicationDate(),
                asset.getAuthor().getId(),
                asset.getTags(),
                asset.getTechDetails());
    }
    

    @Override
    public Asset fromDto(AssetDto assetDto, User user) {
        Asset asset = new Asset();
        asset.setId(assetDto.getId());
        asset.setName(assetDto.getName());
        asset.setDescription(assetDto.getDescription());
        asset.setDetails(assetDto.getDetails());
        asset.setVersion(assetDto.getVersion());
        asset.setArchived(assetDto.isArchived());
        asset.setAssetLink(assetDto.getAssetLink());
        asset.setImagesLink(assetDto.getImagesLink());
        asset.setCost(assetDto.getCost());
        asset.setCategory(assetDto.getCategory());
        asset.setEngine(assetDto.getEngine());
        asset.setPlatform(assetDto.getPlatform());
        asset.setAuthor(user);
        asset.setTags(assetDto.getTags());
        asset.setTechDetails(assetDto.getTechDetails());
        return asset;
    }
}
