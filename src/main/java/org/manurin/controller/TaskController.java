package org.manurin.controller;


import org.apache.commons.lang3.StringUtils;
import org.manurin.api.ServiceConfigApi;
import org.manurin.api.model.BundledProduct;
import org.manurin.api.model.Tariff;
import org.manurin.mapper.CommonMapper;
import org.manurin.repository.ConfRepository;
import org.manurin.repository.model.TariffEntity;
import org.manurin.utils.Common;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
public class TaskController implements ServiceConfigApi {

    @Inject
    ConfRepository repository;

    @Inject
    CommonMapper mapper;

    @Override
    public Response bundleAdd(BundledProduct bundledProduct) {

        return Response
                .ok()
                .entity(mapper.map(repository.createBundle(bundledProduct)))
                .build();
    }

    @Override
    public Response bundleGet(String id) {
        return Response
                .ok()
                .entity(mapper.map(repository.getBundle(id)))
                .build();
    }

    @Override
    public Response bundleUpdate(String id, BundledProduct bundledProduct) {
        return Response
                .ok()
                .entity(mapper.map(repository.updateBundle(id, bundledProduct)))
                .build();
    }

    @Override
    public Response tariffAdd(Tariff tariff) {
        return Response
                .ok()
                .entity(mapper.map(repository.createTariff(tariff)))
                .build();
    }

    @Override
    public Response tariffGet(String id) {
        return Response
                .ok()
                .entity(mapper.map(repository.getTariff(id)))
                .build();
    }

    @Override
    public Response tariffUpdate(String id, Tariff tariff) {
        return Response
                .ok()
                .entity(mapper.map(repository.updateTariff(id, tariff)))
                .build();
    }

    @Override
    public Response search(String name, Boolean unlimInternet, Boolean unlimCalls, Boolean archived) {


        List<TariffEntity> list = repository.search().stream()
                .filter(tariff ->
                        Common.isaBoolean(name, unlimInternet, unlimCalls, archived, tariff)
                )
                .toList();


        return Response
                .ok()
                .entity(list)
                .build();
    }
}


