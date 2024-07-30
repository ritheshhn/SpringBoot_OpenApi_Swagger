package com.thantrick.SpringBoot_openapi_Swagger.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.graphql.ConditionalOnGraphQlSchema;

import java.util.List;

@Entity
@Table(name = "user_tbl")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "User Entity")
public class UserEntity {

    @Id
    @GeneratedValue
    @Schema(description = "Unique identifier for the user", example = "1")
    private long id;

    @Column(nullable=false, unique = true)
    @Schema(description = "Unique identifier for the user", example = "1")
    private String userId;

    @Column(nullable=false, length=50)
    @Schema(description = "First name of the user", example = "Rithesh")
    private String firstName;

    @Column(nullable=false, length=50)
    @Schema(description = "Last name of the user", example = "Nagaraj")
    private String lastName;

    @Column(nullable=false, length=120, unique = true)
    @Schema(description = "User email", example = "rithesh@gmail.com")
    private String email;

    @Column(nullable=false)
    private String encryptedPassword;

    private String emailVerificationToken;

    @Column(nullable=false)
    private Boolean emailVerificationStatus = false;

    @OneToMany(mappedBy="userDetails", cascade=CascadeType.ALL)
    private List<AddressEntity> addresses;
}
