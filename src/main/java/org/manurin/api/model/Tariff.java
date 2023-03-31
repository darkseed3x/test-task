package org.manurin.api.model;

import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import javax.validation.constraints.*;
import javax.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("Tariff")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-03-31T13:01:56.739564+03:00[Europe/Moscow]")
public class Tariff   {
  
  private @Valid String id;
  private @Valid String name;
  private @Valid OffsetDateTime createDate;
  private @Valid Boolean archived = false;
  private @Valid Boolean deleted = false;
  private @Valid BundledProduct bundledProduct;

  /**
   **/
  public Tariff id(String id) {
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
  public Tariff name(String name) {
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
  public Tariff createDate(OffsetDateTime createDate) {
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
  public Tariff archived(Boolean archived) {
    this.archived = archived;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("archived")
  public Boolean getArchived() {
    return archived;
  }

  @JsonProperty("archived")
  public void setArchived(Boolean archived) {
    this.archived = archived;
  }

/**
   **/
  public Tariff deleted(Boolean deleted) {
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

/**
   **/
  public Tariff bundledProduct(BundledProduct bundledProduct) {
    this.bundledProduct = bundledProduct;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("bundledProduct")
  public BundledProduct getBundledProduct() {
    return bundledProduct;
  }

  @JsonProperty("bundledProduct")
  public void setBundledProduct(BundledProduct bundledProduct) {
    this.bundledProduct = bundledProduct;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Tariff tariff = (Tariff) o;
    return Objects.equals(this.id, tariff.id) &&
        Objects.equals(this.name, tariff.name) &&
        Objects.equals(this.createDate, tariff.createDate) &&
        Objects.equals(this.archived, tariff.archived) &&
        Objects.equals(this.deleted, tariff.deleted) &&
        Objects.equals(this.bundledProduct, tariff.bundledProduct);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, createDate, archived, deleted, bundledProduct);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Tariff {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    createDate: ").append(toIndentedString(createDate)).append("\n");
    sb.append("    archived: ").append(toIndentedString(archived)).append("\n");
    sb.append("    deleted: ").append(toIndentedString(deleted)).append("\n");
    sb.append("    bundledProduct: ").append(toIndentedString(bundledProduct)).append("\n");
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

