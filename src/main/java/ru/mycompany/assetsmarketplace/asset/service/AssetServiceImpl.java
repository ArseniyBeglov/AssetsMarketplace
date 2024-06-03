package ru.mycompany.assetsmarketplace.asset.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mycompany.assetsmarketplace.asset.dto.AssetDto;
import ru.mycompany.assetsmarketplace.asset.dto.AssetMapper;
import ru.mycompany.assetsmarketplace.asset.dto.AssetMapperImpl;
import ru.mycompany.assetsmarketplace.asset.model.Asset;
import ru.mycompany.assetsmarketplace.asset.repository.AssetRepository;
import ru.mycompany.assetsmarketplace.exceptions.NotFoundException;
import ru.mycompany.assetsmarketplace.user.model.User;
import ru.mycompany.assetsmarketplace.user.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AssetServiceImpl implements AssetService{

    private final AssetRepository assetRepository;
    private final UserRepository userRepository;
    private  final AssetMapper assetMapper = new AssetMapperImpl();
    @Override
    public List<AssetDto> getAll() {
        log.debug("Request GET to /assets");
        return assetRepository.findAll()
                .stream()
                .map(assetMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AssetDto getById(long id) {
        log.debug("Request GET to /assets/{}",id);
        Asset asset = assetRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Asset with id = " + id + " is not found"));
        return assetMapper.toDto(asset);
    }

    @Override
    @Transactional
    public AssetDto create(AssetDto assetDto) {
        log.debug("Request POST to /assets");
        User owner = userRepository.findById(assetDto.getAuthorId())
                .orElseThrow(() ->
                        new NotFoundException("User with id = " + assetDto.getAuthorId() + " not found"));

        return assetMapper.toDto(assetRepository.save(assetMapper.fromDto(assetDto, owner)));
    }

    @Override
    @Transactional
    public AssetDto update(long id, AssetDto assetDto) {
        log.debug("Request PATCH to /assets/{}", id);
        userRepository.findById(assetDto.getAuthorId())
                .orElseThrow(() ->
                        new NotFoundException("User with id = " + assetDto.getAuthorId() + " is not found"));
        Asset asset = assetRepository.findById(id)
                .orElseThrow(() ->
                        new NotFoundException("Asset with id = " + id + " is not found"));

        if (!asset.getAuthor().getId().equals(assetDto.getAuthorId())) {
            throw new NotFoundException("Asset with this id is not found in this user");
        }
        assetDto.setId(id);

        return assetMapper.toDto(update(assetDto, asset));
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        log.debug("Request DELETE to /assets/{}", id);
        assetRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        log.debug("Request DELETE to /assets");
        assetRepository.deleteAll();
    }

    private Asset update(AssetDto assetDto, Asset asset){
        if (assetDto.getName() != null && !assetDto.getName().isBlank()) {
            asset.setName(assetDto.getName());
        }
        if (assetDto.getDescription() != null && !assetDto.getDescription().isBlank()) {
            asset.setDescription(assetDto.getDescription());
        }
        if (assetDto.getDetails() != null && !assetDto.getDetails().isBlank()) {
            asset.setDetails(assetDto.getDetails());
        }
        if (assetDto.getVersion() != null && !assetDto.getVersion().isBlank()) {
            asset.setVersion(assetDto.getVersion());
        }
        asset.setArchived(assetDto.isArchived());
        if (assetDto.getAssetLink() != null && !assetDto.getAssetLink().isBlank()) {
            asset.setAssetLink(assetDto.getAssetLink());
        }
        if (assetDto.getImagesLink() != null && !assetDto.getImagesLink().isBlank()) {
            asset.setImagesLink(assetDto.getImagesLink());
        }
        if (assetDto.getCost() != null) {
            asset.setCost(assetDto.getCost());
        }
        if (assetDto.getCategory() != null && !assetDto.getCategory().isBlank()) {
            asset.setCategory(assetDto.getCategory());
        }
        if (assetDto.getEngine() != null && !assetDto.getEngine().isBlank()) {
            asset.setEngine(assetDto.getEngine());
        }
        if (assetDto.getPlatform() != null && !assetDto.getPlatform().isBlank()) {
            asset.setPlatform(assetDto.getPlatform());
        }
        if (assetDto.getTags() != null && !assetDto.getTags().isBlank()) {
            asset.setTags(assetDto.getTags());
        }
        if (assetDto.getTechDetails() != null && !assetDto.getTechDetails().isBlank()) {
            asset.setTechDetails(assetDto.getTechDetails());
        }
        return asset;
    }
}
