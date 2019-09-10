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
 * ReturnPaymentIn
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-09-10T14:59:39.142+02:00")

public class ReturnPaymentIn   {
  @JsonProperty("betrag")
  private BigDecimal betrag = null;

  @JsonProperty("datum")
  private String datum = null;

  public ReturnPaymentIn betrag(BigDecimal betrag) {
    this.betrag = betrag;
    return this;
  }

   /**
   * Get betrag
   * @return betrag
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getBetrag() {
    return betrag;
  }

  public void setBetrag(BigDecimal betrag) {
    this.betrag = betrag;
  }

  public ReturnPaymentIn datum(String datum) {
    this.datum = datum;
    return this;
  }

   /**
   * Get datum
   * @return datum
  **/
  @ApiModelProperty(value = "")


  public String getDatum() {
    return datum;
  }

  public void setDatum(String datum) {
    this.datum = datum;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReturnPaymentIn returnPaymentIn = (ReturnPaymentIn) o;
    return Objects.equals(this.betrag, returnPaymentIn.betrag) &&
        Objects.equals(this.datum, returnPaymentIn.datum);
  }

  @Override
  public int hashCode() {
    return Objects.hash(betrag, datum);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReturnPaymentIn {\n");
    
    sb.append("    betrag: ").append(toIndentedString(betrag)).append("\n");
    sb.append("    datum: ").append(toIndentedString(datum)).append("\n");
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

