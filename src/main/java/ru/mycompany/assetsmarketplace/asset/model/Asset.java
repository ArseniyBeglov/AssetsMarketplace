package ru.mycompany.assetsmarketplace.asset.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mycompany.assetsmarketplace.user.model.User;
import java.time.*;

@Entity
@Table(name = "assets")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "details", columnDefinition = "text")
    private String details;

    @Column(name = "version", length = 20)
    private String version;

    @Column(name = "archived", columnDefinition = "boolean default false")
    private boolean archived;

    @Column(name = "asset_link", columnDefinition = "text")
    private String assetLink;

    @Column(name = "images_link")
    // TODO another table for links
    private String imagesLink;

    @Column(name = "cost")
    private Double cost;

    @Column(name = "category")
    // TODO another table for categories
    private String category;

    @Column(name = "engine")
    // TODO another table for engines
    private String engine;

    @Column(name = "platform")
    private String platform;

    @Column(name = "publication_date")
    private LocalDateTime publicationDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @Column(name = "tags", columnDefinition = "text")
    // TODO another table for tags
    private String tags;

    @Column(name = "tech_details", columnDefinition = "text")
    private String techDetails;

    @PrePersist
    private void init(){
        publicationDate=LocalDateTime.now();
    }
}

