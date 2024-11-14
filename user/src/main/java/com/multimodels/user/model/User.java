package com.multimodels.user.model;


import com.multimodels.user.model.abstractparentUserClass.AbstractUser;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends AbstractUser {


    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private String firstName;
    @Column(nullable = true)
    private String lastName;

    @Column(nullable = true)
    private String phoneNumber;

}
