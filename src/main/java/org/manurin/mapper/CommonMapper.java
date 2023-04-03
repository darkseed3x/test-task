package org.manurin.mapper;


import org.manurin.api.model.BundledProduct;
import org.manurin.api.model.Tariff;
import org.manurin.repository.model.BundledProductEntity;
import org.manurin.repository.model.TariffEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "CDI")
public interface CommonMapper {

    @Mapping(target = "bundledProduct", source = "bundledProductId")
    Tariff map(TariffEntity tariff);

    @Mapping(target = "products.calls", source = "calls")
    @Mapping(target = "products.sms", source = "sms")
    @Mapping(target = "products.internet", source = "internet")
    BundledProduct map(BundledProductEntity product);

    List<Tariff> map(List<TariffEntity> tariff);
    List<BundledProduct> mapB(List<BundledProductEntity> tariff);


}
