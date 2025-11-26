package org.example.ecommercebackendapplication.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.example.ecommercebackendapplication.dto.request.auth.RegistrationRequest;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Setter
@Entity
@Table(name = "shop_owners")
public class ShopOwnerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "username", nullable = false, length = 100)
    private String username;

    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    public static ShopOwnerEntity fromRequest(RegistrationRequest request, PasswordEncoder passwordEncoder) {
        ShopOwnerEntity entity = new ShopOwnerEntity();
        entity.setUsername(request.getUserName());
        entity.setPassword(passwordEncoder.encode(request.getPassword()));
        return entity;
    }
}