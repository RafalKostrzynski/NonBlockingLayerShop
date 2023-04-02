package pl.kostrzynski.nonblockinglayershop.product;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

    Product toDomain(ProductJpaEntity entity);

}
