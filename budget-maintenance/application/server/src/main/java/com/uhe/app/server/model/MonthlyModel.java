package com.uhe.app.server.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.uhe.app.server.model.ReturnPaymentIn;
import com.uhe.app.server.model.ReturnPaymentOut;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * MonthlyModel
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-09-10T18:02:12.946+02:00")

public class MonthlyModel   {
  @JsonProperty("auszahlungen")
  private List<ReturnPaymentOut> auszahlungen = null;

  @JsonProperty("einzahlungen")
  private List<ReturnPaymentIn> einzahlungen = null;

  @JsonProperty("kassenbestand")
  private BigDecimal kassenbestand = null;

  @JsonProperty("name")
  private String name = null;

  public MonthlyModel auszahlungen(List<ReturnPaymentOut> auszahlungen) {
    this.auszahlungen = auszahlungen;
    return this;
  }

  public MonthlyModel addAuszahlungenItem(ReturnPaymentOut auszahlungenItem) {
    if (this.auszahlungen == null) {
      this.auszahlungen = new ArrayList<ReturnPaymentOut>();
    }
    this.auszahlungen.add(auszahlungenItem);
    return this;
  }

   /**
   * Get auszahlungen
   * @return auszahlungen
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ReturnPaymentOut> getAuszahlungen() {
    return auszahlungen;
  }

  public void setAuszahlungen(List<ReturnPaymentOut> auszahlungen) {
    this.auszahlungen = auszahlungen;
  }

  public MonthlyModel einzahlungen(List<ReturnPaymentIn> einzahlungen) {
    this.einzahlungen = einzahlungen;
    return this;
  }

  public MonthlyModel addEinzahlungenItem(ReturnPaymentIn einzahlungenItem) {
    if (this.einzahlungen == null) {
      this.einzahlungen = new ArrayList<ReturnPaymentIn>();
    }
    this.einzahlungen.add(einzahlungenItem);
    return this;
  }

   /**
   * Get einzahlungen
   * @return einzahlungen
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ReturnPaymentIn> getEinzahlungen() {
    return einzahlungen;
  }

  public void setEinzahlungen(List<ReturnPaymentIn> einzahlungen) {
    this.einzahlungen = einzahlungen;
  }

  public MonthlyModel kassenbestand(BigDecimal kassenbestand) {
    this.kassenbestand = kassenbestand;
    return this;
  }

   /**
   * Get kassenbestand
   * @return kassenbestand
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getKassenbestand() {
    return kassenbestand;
  }

  public void setKassenbestand(BigDecimal kassenbestand) {
    this.kassenbestand = kassenbestand;
  }

  public MonthlyModel name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MonthlyModel monthlyModel = (MonthlyModel) o;
    return Objects.equals(this.auszahlungen, monthlyModel.auszahlungen) &&
        Objects.equals(this.einzahlungen, monthlyModel.einzahlungen) &&
        Objects.equals(this.kassenbestand, monthlyModel.kassenbestand) &&
        Objects.equals(this.name, monthlyModel.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(auszahlungen, einzahlungen, kassenbestand, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MonthlyModel {\n");
    
    sb.append("    auszahlungen: ").append(toIndentedString(auszahlungen)).append("\n");
    sb.append("    einzahlungen: ").append(toIndentedString(einzahlungen)).append("\n");
    sb.append("    kassenbestand: ").append(toIndentedString(kassenbestand)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

