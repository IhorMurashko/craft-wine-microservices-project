package com.multimodels.user.model.abstractparentUserClass;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@SequenceGenerator(name = "user_sequence_generator",
        sequenceName = "user_sequence_generator",
        allocationSize = 1,
        initialValue = 1)
public abstract class AbstractUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "user_sequence_generator")
    protected Long id;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractUser that)) return false;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
