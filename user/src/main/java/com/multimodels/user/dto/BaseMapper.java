package com.multimodels.user.dto;

import java.util.List;

public interface BaseMapper<E, D> {

    D toDto(E entity);

    E toEntity(D dto);

    List<E> toEntities(List<D> dtos);

    List<D> toDtos(List<E> entities);


}
