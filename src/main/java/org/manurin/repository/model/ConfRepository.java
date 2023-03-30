package org.manurin.repository.model;

import org.manurin.model.BundledProduct;
import org.manurin.model.Products;
import org.manurin.repository.model.BundledProductEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class ConfRepository {

    @Transactional
    public void create(BundledProduct item) {
        BundledProductEntity bundle = new BundledProductEntity();
        bundle.name = item.getName();
        bundle.deleted = item.getDeleted();
        bundle.internet = item.getProducts().getInternet();
        bundle.sms = item.getProducts().getSms();
        bundle.calls = item.getProducts().getCalls();
        bundle.persist();
    }

    @Transactional
    public void update(String id,BundledProduct item) {
        BundledProductEntity bundle = BundledProductEntity.findById(id);
        bundle.name = item.getName();
        bundle.deleted = item.getDeleted();
        bundle.internet = item.getProducts().getInternet();
        bundle.sms = item.getProducts().getSms();
        bundle.calls = item.getProducts().getCalls();
        bundle.persist();
    }

    @Transactional
    public BundledProduct get(String id) {
        BundledProductEntity bundle = BundledProductEntity.findById(id);
        return new BundledProduct()
                .products(
                        new Products()
                                .calls(bundle.calls)
                                .sms(bundle.sms)
                                .internet(bundle.internet)
                )
                .createDate(bundle.createDate)
                .id(bundle.id)
                .name(bundle.name)
                .deleted(bundle.deleted);

    }
}

