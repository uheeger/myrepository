package com.uhe.app.server.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ReturnPaymentOut
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-09-10T18:02:12.946+02:00")

public class ReturnPaymentOut   {
  @JsonProperty("kategorie")
  private String kategorie = null;

  @JsonProperty("summe")
  private BigDecimal summe = null;

  public ReturnPaymentOut kategorie(String kategorie) {
    this.kategorie = kategorie;
    return this;
  }

   /**
   * Get kategorie
   * @return kategorie
  **/
  @ApiModelProperty(value = "")


  public String getKategorie() {
    return kategorie;
  }

  public void setKategorie(String kategorie) {
    this.kategorie = kategorie;
  }

  public ReturnPaymentOut summe(BigDecimal summe) {
    this.summe = summe;
    return this;
  }

   /**
   * Get summe
   * @return summe
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getSumme() {
    return summe;
  }

  public void setSumme(BigDecimal summe) {
    this.summe = summe;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReturnPaymentOut returnPaymentOut = (ReturnPaymentOut) o;
    return Objects.equals(this.kategorie, returnPaymentOut.kategorie) &&
        Objects.equals(this.summe, returnPaymentOut.summe);
  }

  @Override
  public int hashCode() {
    return Objects.hash(kategorie, summe);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReturnPaymentOut {\n");
    
    sb.append("    kategorie: ").append(toIndentedString(kategorie)).append("\n");
    sb.append("    summe: ").append(toIndentedString(summe)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

