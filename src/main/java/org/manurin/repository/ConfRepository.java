package org.manurin.repository;

import org.manurin.api.model.BundledProduct;
import org.manurin.api.model.Products;
import org.manurin.api.model.Tariff;
import org.manurin.repository.model.BundledProductEntity;
import org.manurin.repository.model.TariffEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

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
    public void updateBundle(String id, BundledProduct item) {
        BundledProductEntity bundle = BundledProductEntity.findById(id);
        bundle
                .setName(item.getName())
                .setDeleted(item.getDeleted())
                .setCalls(item.getProducts().getCalls())
                .setSms(item.getProducts().getSms())
                .setInternet(item.getProducts().getInternet())

                .persist();
    }

    @Transactional
    public BundledProduct getBundle(String id) {
        BundledProductEntity bundle = BundledProductEntity.findById(id);
        return new BundledProduct()
                .products(
                        new Products()
                                .calls(bundle.getCalls())
                                .sms(bundle.getSms())
                                .internet(bundle.getInternet())
                )
                .createDate(bundle.getCreateDate())
                .id(bundle.getId())
                .name(bundle.getName())
                .deleted(bundle.isDeleted());

    }

    @Transactional
    public void createTariff(Tariff item) {
        TariffEntity bundle =
                new TariffEntity()
                        .setName(item.getName())
                        .setDeleted(item.getDeleted())
                        .setArchived(item.getArchived())

                        .setBundledProductId(
                                item.getBundledProduct() != null ?
                                        createBundle(item.getBundledProduct()) :
                                        null
                        );


        bundle.persist();
    }

    @Transactional
    public void updateTariff(String id, Tariff item) {
        TariffEntity bundle = TariffEntity.findById(id);
        bundle
                .setName(item.getName())
                .setDeleted(item.getDeleted())
                .setArchived(item.getArchived())

                .setBundledProductId(
                        item.getBundledProduct() != null ?
                                createBundle(item.getBundledProduct()) :
                                null
                )

                .persist();
    }

    @Transactional
    public Tariff getTariff(String id) {
        TariffEntity tariff = TariffEntity.findById(id);
        return new Tariff()
                .bundledProduct(getBundle(tariff.getBundledProductId().getId()))
                .createDate(tariff.getCreateDate())
                .id(tariff.getId())
                .name(tariff.getName())
                .deleted(tariff.isDeleted())
                .archived(tariff.isArchived());

    }
}

