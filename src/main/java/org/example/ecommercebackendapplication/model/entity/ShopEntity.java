package org.example.ecommercebackendapplication.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "shops")
public class ShopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shops_id_gen")
    @SequenceGenerator(name = "shops_id_gen", sequenceName = "shops_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "merchant_id", nullable = false)
    private ShopOwnerEntity shopOwnerEntity;

    @Size(max = 150)
    @NotNull
    @Column(name = "shop_name", nullable = false, length = 150)
    private String shopName;

    @Size(max = 200)
    @NotNull
    @Column(name = "shop_slug", nullable = false, length = 200)
    private String shopSlug;

    @NotNull
    @Column(name = "description", nullable = false, length = Integer.MAX_VALUE)
    private String description;

    @NotNull
    @Column(name = "logo_url", nullable = false, length = Integer.MAX_VALUE)
    private String logoUrl;

    @ColumnDefault("false")
    @Column(name = "is_active")
    private Boolean isActive;
}