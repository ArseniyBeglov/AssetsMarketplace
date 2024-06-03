package ru.mycompany.assetsmarketplace.asset.service;

import ru.mycompany.assetsmarketplace.asset.dto.AssetDto;
import java.util.List;

public interface AssetService {
    List<AssetDto> getAll();

    AssetDto getById(long id);

    AssetDto create(AssetDto assetDto);

    AssetDto update(long id, AssetDto assetDto);

    void deleteById(long id);

    void deleteAll();
}
