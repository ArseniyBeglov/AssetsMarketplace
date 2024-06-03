package ru.mycompany.assetsmarketplace.asset.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class AssetDto {
    private Long id;
    private String name;
    private String description;
    private String details;
    private String version;
    private boolean archived;
    private String assetLink;
    private String imagesLink;
    private Double cost;
    private String category;
    private String engine;
    private String platform;
    private LocalDateTime publicationDate;
    private Long authorId;
    private String tags;
    private String techDetails;

}
