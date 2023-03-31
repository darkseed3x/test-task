package org.manurin.api.model;

import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import javax.validation.constraints.*;
import javax.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("BundledProduct")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-03-31T13:01:56.739564+03:00[Europe/Moscow]")
public class BundledProduct   {
  
  private @Valid String id;
  private @Valid String name;
  private @Valid OffsetDateTime createDate;
  private @Valid Products products;
  private @Valid Boolean deleted = false;

  /**
   **/
  public BundledProduct id(String id) {
    this.id = id;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(String id) {
    this.id = id;
  }

/**
   **/
  public BundledProduct name(String name) {
    this.name = name;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("name")
  @NotNull
 @Size(max=128)  public String getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(String name) {
    this.name = name;
  }

/**
   **/
  public BundledProduct createDate(OffsetDateTime createDate) {
    this.createDate = createDate;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("createDate")
  public OffsetDateTime getCreateDate() {
    return createDate;
  }

  @JsonProperty("createDate")
  public void setCreateDate(OffsetDateTime createDate) {
    this.createDate = createDate;
  }

/**
   **/
  public BundledProduct products(Products products) {
    this.products = products;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("products")
  @NotNull
  public Products getProducts() {
    return products;
  }

  @JsonProperty("products")
  public void setProducts(Products products) {
    this.products = products;
  }

/**
   **/
  public BundledProduct deleted(Boolean deleted) {
    this.deleted = deleted;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("deleted")
  public Boolean getDeleted() {
    return deleted;
  }

  @JsonProperty("deleted")
  public void setDeleted(Boolean deleted) {
    this.deleted = deleted;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BundledProduct bundledProduct = (BundledProduct) o;
    return Objects.equals(this.id, bundledProduct.id) &&
        Objects.equals(this.name, bundledProduct.name) &&
        Objects.equals(this.createDate, bundledProduct.createDate) &&
        Objects.equals(this.products, bundledProduct.products) &&
        Objects.equals(this.deleted, bundledProduct.deleted);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, createDate, products, deleted);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BundledProduct {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    createDate: ").append(toIndentedString(createDate)).append("\n");
    sb.append("    products: ").append(toIndentedString(products)).append("\n");
    sb.append("    deleted: ").append(toIndentedString(deleted)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


}

