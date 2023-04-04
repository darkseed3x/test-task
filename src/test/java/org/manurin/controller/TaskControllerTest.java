package org.manurin.controller;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.manurin.api.model.BundledProduct;
import org.manurin.api.model.Products;
import org.manurin.api.model.Tariff;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class TaskControllerTest {

    @Test
    void bundleAdd() {
        BundledProduct product = new BundledProduct()
                .name("Trenton")
                .deleted(true)
                .products(new Products()
                        .calls(350)
                        .sms(100)
                        .internet(-1));


        BundledProduct bundledProduct = given()
                .body(product)
                .contentType(ContentType.JSON)
                .when().post("/tcr-web/bundledProduct")
                .then()
                .statusCode(200)
                .extract()
                .body().as(BundledProduct.class);
        assertNotNull(bundledProduct.getCreateDate());
        assertNotNull(bundledProduct.getId());
    }

    @Test
    void bundleGet() {
        BundledProduct product = given()
                .queryParam("id", "cdc153c2-d216-11ed-afa1-0242ac120002")
                .when().get("/tcr-web/bundledProduct")
                .then()
                .statusCode(200)
                .extract()
                .body().as(BundledProduct.class);
        assertNotNull(product);
        assertEquals("cdc153c2-d216-11ed-afa1-0242ac120002", product.getId());
        assertEquals("kruul", product.getName());
    }

    @Test
    void bundleUpdate() {
        BundledProduct newProduct = new BundledProduct()
                .name("Shikaka")
                .deleted(false)
                .products(new Products()
                        .calls(500)
                        .sms(200)
                        .internet(20));
        BundledProduct product = given()
                .queryParam("id", "ebfc4b62-d216-11ed-afa1-0242ac120002")
                .body(newProduct)
                .contentType(ContentType.JSON)
                .when().put("/tcr-web/bundledProduct")
                .then()
                .statusCode(200)
                .extract()
                .body().as(BundledProduct.class);
        assertNotNull(product);
        assertEquals("ebfc4b62-d216-11ed-afa1-0242ac120002", product.getId());
        assertEquals("Shikaka", product.getName());
    }

    @Test
    void tariffAdd() {
        Tariff newTariff = new Tariff()
                .name("Flugengekhaimer")
                .deleted(false)
                .archived(false)
                .bundledProduct(
                        new BundledProduct()
                                .name("gloryBeast")
                                .deleted(true)
                                .products(
                                        new Products()
                                                .calls(350)
                                                .sms(100)
                                                .internet(-1)
                                )
                );
        Tariff tariff = given()
                .body(newTariff)
                .contentType(ContentType.JSON)
                .when().post("/tcr-web/tariff")
                .then()
                .statusCode(200)
                .extract()
                .body().as(Tariff.class);
        assertNotNull(tariff.getCreateDate());
        assertNotNull(tariff.getId());
    }

    @Test
    void tariffDublAdd() {
        Tariff newTariff = new Tariff()
                .name("vvvvvv")
                .deleted(false)
                .archived(false)
                .bundledProduct(
                        new BundledProduct()
                                .name("gloryBeast")
                                .deleted(true)
                                .products(
                                        new Products()
                                                .calls(350)
                                                .sms(100)
                                                .internet(-1)
                                )
                );
         given()
                .body(newTariff)
                .contentType(ContentType.JSON)
                .when().post("/tcr-web/tariff")
                .then()
                .statusCode(500);
    }

    @Test
    void tariffGet() {
        Tariff tariff = given()
                .queryParam("id", "71b862e0-d217-11ed-afa1-0242ac120002")
                .when().get("/tcr-web/tariff")
                .then()
                .statusCode(200)
                .extract()
                .body().as(Tariff.class);
        assertNotNull(tariff);
        assertEquals("71b862e0-d217-11ed-afa1-0242ac120002", tariff.getId());
        assertEquals("qwartet", tariff.getName());
    }

    @Test
    void tariffUpdate() {
        Tariff newTariff = new Tariff()
                .name("Shraubikus")
                .deleted(false)
                .archived(false)
                .bundledProduct(
                        new BundledProduct()
                                .name("uber")
                                .deleted(true)
                                .products(
                                        new Products()
                                                .calls(900)
                                                .sms(222)
                                                .internet(0)
                                )
                );
        Tariff tariff = given()
                .queryParam("id", "76792594-d217-11ed-afa1-0242ac120002")
                .body(newTariff)
                .contentType(ContentType.JSON)
                .when().put("/tcr-web/tariff")
                .then()
                .statusCode(200)
                .extract()
                .body().as(Tariff.class);
        assertNotNull(tariff);
        assertEquals("76792594-d217-11ed-afa1-0242ac120002", tariff.getId());
        assertEquals("Shraubikus", tariff.getName());
    }

    @Test
    void search() {
        List<Tariff> tariff = given()
                .queryParams(
                        "name", "nnnnnn",
                        "archived", "true",
                        "unlimInternet", "false",
                        "unlimCalls", "false"
                )
                .when().get("/tcr-web/tariff/search")
                .then()
                .statusCode(200)
                .extract()
                .body().jsonPath().getList("");
        assertTrue(tariff.size() != 0);
    }
}