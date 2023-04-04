package org.manurin.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.jboss.resteasy.reactive.RestQuery;
import org.manurin.api.model.BundledProduct;
import org.manurin.api.model.Tariff;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/tcr-web")
@Api
public interface ServiceConfigApi {
    @Path("/tariff/search")
    @GET
    @Produces({ "application/json" })
    @ApiOperation(value = "Поиск тарифов по критериям", notes = "", tags={ "it-product-api" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Tariff.class) })
    Response search(@QueryParam("name")   String name, @QueryParam("UnlimInternet")   Boolean unlimInternet, @QueryParam("UnlimCalls")   Boolean unlimCalls, @QueryParam("archived")   Boolean archived);



    @Path("/bundledProduct")
    @POST
    @Consumes({ "application/json" })
    @ApiOperation(value = "Метод добавления пакетов", notes = "", tags={ "it-product-api" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Void.class) })
    Response bundleAdd(@Valid BundledProduct bundledProduct);


    @Path("/bundledProduct")
    @GET
    @Produces({ "application/json" })
    @ApiOperation(value = "Метод получения пакетов по id", notes = "", tags={ "it-product-api" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = BundledProduct.class) })
    Response bundleGet(@QueryParam("id") @NotNull String id);


    @Path("/bundledProduct")
    @PUT
    @Consumes({ "application/json" })
    @ApiOperation(value = "Метод обновления пакетов", notes = "", tags={ "it-product-api" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Void.class) })
    Response bundleUpdate(@QueryParam("id") @NotNull   String id,@Valid BundledProduct bundledProduct);


    @Path("/tariff")
    @POST
    @Consumes({ "application/json" })
    @ApiOperation(value = "Метод добавления тарифов", notes = "", tags={ "it-product-api" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Void.class) })
    Response tariffAdd(@Valid Tariff tariff);


    @Path("/tariff")
    @GET
    @Produces({ "application/json" })
    @ApiOperation(value = "Метод получения тарифов по id", notes = "", tags={ "it-product-api" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Tariff.class) })
    Response tariffGet(@QueryParam("id") @NotNull   String id);


    @Path("/tariff")
    @PUT
    @Consumes({ "application/json" })
    @ApiOperation(value = "Метод обновления тарифов", notes = "", tags={ "it-product-api" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Void.class) })
    Response tariffUpdate(@QueryParam("id") @NotNull   String id,@Valid Tariff tariff);
}
