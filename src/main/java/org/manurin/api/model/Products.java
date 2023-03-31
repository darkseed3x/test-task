package org.manurin.api.model;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("Products")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-03-31T13:01:56.739564+03:00[Europe/Moscow]")
public class Products   {
  
  private @Valid Integer calls;
  private @Valid Integer sms;
  private @Valid Integer internet;

  /**
   **/
  public Products calls(Integer calls) {
    this.calls = calls;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("calls")
  public Integer getCalls() {
    return calls;
  }

  @JsonProperty("calls")
  public void setCalls(Integer calls) {
    this.calls = calls;
  }

/**
   **/
  public Products sms(Integer sms) {
    this.sms = sms;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("sms")
  public Integer getSms() {
    return sms;
  }

  @JsonProperty("sms")
  public void setSms(Integer sms) {
    this.sms = sms;
  }

/**
   **/
  public Products internet(Integer internet) {
    this.internet = internet;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("internet")
  public Integer getInternet() {
    return internet;
  }

  @JsonProperty("internet")
  public void setInternet(Integer internet) {
    this.internet = internet;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Products products = (Products) o;
    return Objects.equals(this.calls, products.calls) &&
        Objects.equals(this.sms, products.sms) &&
        Objects.equals(this.internet, products.internet);
  }

  @Override
  public int hashCode() {
    return Objects.hash(calls, sms, internet);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Products {\n");
    
    sb.append("    calls: ").append(toIndentedString(calls)).append("\n");
    sb.append("    sms: ").append(toIndentedString(sms)).append("\n");
    sb.append("    internet: ").append(toIndentedString(internet)).append("\n");
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

