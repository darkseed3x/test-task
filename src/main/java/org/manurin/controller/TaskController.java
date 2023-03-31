package org.manurin.controller;


import org.manurin.api.ServiceConfigApi;
import org.manurin.api.model.BundledProduct;
import org.manurin.api.model.Tariff;
import org.manurin.repository.ConfRepository;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

public class TaskController implements ServiceConfigApi {

    @Inject
    ConfRepository repository;

    @Override
    public Response bundleAdd(BundledProduct bundledProduct) {

        repository.create(bundledProduct);
        return Response.ok().build();
    }

    @Override
    public Response bundleGet(String id) {

        return Response.ok().entity(repository.get(id)).build();
    }

    @Override
    public Response bundleUpdate(String id, BundledProduct bundledProduct) {
        repository.update(id,bundledProduct);
        return Response.ok().build();
    }

    @Override
    public Response tariffAdd(Tariff tariff) {
        return Response.ok().build();
    }

    @Override
    public Response tariffGet(String id) {
        return Response.ok().build();
    }

    @Override
    public Response tariffUpdate(String id, Tariff tariff) {
        return Response.ok().build();
    }
}


