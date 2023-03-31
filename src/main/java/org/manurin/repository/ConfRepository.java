package org.manurin.repository;

import org.manurin.api.model.BundledProduct;
import org.manurin.api.model.Products;
import org.manurin.repository.model.BundledProductEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class ConfRepository {

    @Transactional
    public void create(BundledProduct item) {
        BundledProductEntity bundle =
                new BundledProductEntity()
                        .setName(item.getName())
                        .setDeleted(item.getDeleted())
                        .setCalls(item.getProducts().getCalls())
                        .setSms(item.getProducts().getSms())
                        .setInternet(item.getProducts().getInternet());

        bundle.persist();
    }

    @Transactional
    public void update(String id, BundledProduct item) {
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
    public BundledProduct get(String id) {
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
}

