package org.manurin.repository;

import org.manurin.api.model.BundledProduct;
import org.manurin.api.model.Tariff;
import org.manurin.repository.model.BundledProductEntity;
import org.manurin.repository.model.TariffEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ConfRepository {




    @Transactional
    public BundledProductEntity createBundle(BundledProduct item) {
        BundledProductEntity bundle =
                new BundledProductEntity()
                        .setName(item.getName())
                        .setDeleted(item.getDeleted())
                        .setCalls(item.getProducts().getCalls())
                        .setSms(item.getProducts().getSms())
                        .setInternet(item.getProducts().getInternet());

        bundle.persist();
        return bundle;
    }

    @Transactional
    public BundledProductEntity updateBundle(String id, BundledProduct item) {
        Optional<BundledProductEntity> bundledProduct = BundledProductEntity.findByIdOptional(id);
        BundledProductEntity bundledProductEntity = bundledProduct.orElseThrow(NotFoundException::new);
        bundledProductEntity
                .setName(item.getName())
                .setDeleted(item.getDeleted())
                .setCalls(item.getProducts().getCalls())
                .setSms(item.getProducts().getSms())
                .setInternet(item.getProducts().getInternet())
                .persist();
        return bundledProductEntity;
    }

    @Transactional
    public BundledProductEntity getBundle(String id) {
        Optional<BundledProductEntity> bundledProduct = BundledProductEntity.findByIdOptional(id);
        return bundledProduct.orElseThrow(NotFoundException::new);
    }

    @Transactional
    public TariffEntity createTariff(Tariff item) {
        TariffEntity tariff =
                new TariffEntity()
                        .setName(item.getName())
                        .setDeleted(item.getDeleted())
                        .setArchived(item.getArchived())
                        .setBundledProductId(
                                item.getBundledProduct() != null ?
                                        createBundle(item.getBundledProduct()) :
                                        null
                        );


        tariff.persist();
        return tariff;
    }

    @Transactional
    public TariffEntity updateTariff(String id, Tariff item) {
        Optional<TariffEntity> tariff = TariffEntity.findByIdOptional(id);
        TariffEntity tariffEntity = tariff.orElseThrow(NotFoundException::new);
        tariffEntity
                .setName(item.getName())
                .setDeleted(item.getDeleted())
                .setArchived(item.getArchived())
                .setBundledProductId(
                        item.getBundledProduct() != null ?
                                createBundle(item.getBundledProduct()) :
                                null
                )
                .persist();
        return tariffEntity;
    }

    @Transactional
    public TariffEntity getTariff(String id) {
        Optional<TariffEntity> tariff = TariffEntity.findByIdOptional(id);
        return tariff.orElseThrow(NotFoundException::new);

    }

    @Transactional
    public List<TariffEntity> search() {


        return TariffEntity.listAll();
    }
}
