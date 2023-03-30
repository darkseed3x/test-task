package org.manurin.controller;


import org.manurin.api.BundledProductApi;
import org.manurin.model.BundledProduct;
import org.manurin.repository.model.ConfRepository;

import javax.inject.Inject;

public class TaskController implements BundledProductApi {

    @Inject
    ConfRepository repository;

    @Override
    public void bundleAdd(BundledProduct bundledProduct) {
            repository.create(bundledProduct);
    }

    @Override
    public BundledProduct bundleGet(String id) {
        return repository.get(id);
    }

    @Override
    public void bundleUpdate(String id, BundledProduct bundledProduct) {
        repository.update(id,bundledProduct);
    }
}


