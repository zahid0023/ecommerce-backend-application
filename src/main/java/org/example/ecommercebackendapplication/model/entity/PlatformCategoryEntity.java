package org.example.ecommercebackendapplication.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "platform_categories")
public class PlatformCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "platform_categories_id_gen")
    @SequenceGenerator(name = "platform_categories_id_gen", sequenceName = "platform_categories_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "parent_id")
    private PlatformCategoryEntity parentEntity;

    @Size(max = 150)
    @NotNull
    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @OneToMany(mappedBy = "parentEntity")
    private Set<PlatformCategoryEntity> subCategories = new LinkedHashSet<>();

    @NotNull
    @Column(name = "logo_url", nullable = false, length = Integer.MAX_VALUE)
    private String logoUrl;

    @OneToMany(mappedBy = "platformCategoryEntity")
    private Set<ShopCategoryEntity> shopCategories = new LinkedHashSet<>();

}