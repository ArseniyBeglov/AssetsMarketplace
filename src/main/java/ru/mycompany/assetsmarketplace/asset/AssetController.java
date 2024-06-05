package ru.mycompany.assetsmarketplace.asset;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.mycompany.assetsmarketplace.asset.dto.AssetDto;
import ru.mycompany.assetsmarketplace.asset.service.AssetService;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/assets")
public class AssetController {
    private final AssetService assetService;

    @GetMapping
    public List<AssetDto> getAll() {
        return assetService.getAll();
    }

    @GetMapping("/{id}")
    public AssetDto getById(@PathVariable long id) {
        return assetService.getById(id);
    }

    @PostMapping
    public AssetDto create(@Valid @RequestBody AssetDto assetDto) {
        return assetService.create(assetDto);
    }

    @PatchMapping("/{id}")
    public AssetDto patch(@PathVariable long id, @RequestBody AssetDto assetDto) {
        return assetService.update(id, assetDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        assetService.deleteById(id);
    }

    @DeleteMapping
    public void deleteAll() {
        assetService.deleteAll();
    }
}
