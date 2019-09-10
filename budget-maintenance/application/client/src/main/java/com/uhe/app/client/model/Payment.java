/*
 * Budget Rest APIs
 * This page lists all the rest apis for Hotel Management App.
 *
 * OpenAPI spec version: 1.0-SNAPSHOT
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.uhe.app.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

/**
 * Payment
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-09-10T14:40:45.422+02:00")
public class Payment {
  @JsonProperty("betrag")
  private BigDecimal betrag = null;

  @JsonProperty("kategorie")
  private String kategorie = null;

  @JsonProperty("memo")
  private String memo = null;

  /**
   * Gets or Sets typ
   */
  public enum TypEnum {
    EINZAHLUNG("EINZAHLUNG"),
    
    AUSZAHLUNG("AUSZAHLUNG");

    private String value;

    TypEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypEnum fromValue(String text) {
      for (TypEnum b : TypEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("typ")
  private TypEnum typ = null;

  public Payment betrag(BigDecimal betrag) {
    this.betrag = betrag;
    return this;
  }

   /**
   * Get betrag
   * @return betrag
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getBetrag() {
    return betrag;
  }

  public void setBetrag(BigDecimal betrag) {
    this.betrag = betrag;
  }

  public Payment kategorie(String kategorie) {
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

  public Payment memo(String memo) {
    this.memo = memo;
    return this;
  }

   /**
   * Get memo
   * @return memo
  **/
  @ApiModelProperty(value = "")
  public String getMemo() {
    return memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }

  public Payment typ(TypEnum typ) {
    this.typ = typ;
    return this;
  }

   /**
   * Get typ
   * @return typ
  **/
  @ApiModelProperty(value = "")
  public TypEnum getTyp() {
    return typ;
  }

  public void setTyp(TypEnum typ) {
    this.typ = typ;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Payment payment = (Payment) o;
    return Objects.equals(this.betrag, payment.betrag) &&
        Objects.equals(this.kategorie, payment.kategorie) &&
        Objects.equals(this.memo, payment.memo) &&
        Objects.equals(this.typ, payment.typ);
  }

  @Override
  public int hashCode() {
    return Objects.hash(betrag, kategorie, memo, typ);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Payment {\n");
    
    sb.append("    betrag: ").append(toIndentedString(betrag)).append("\n");
    sb.append("    kategorie: ").append(toIndentedString(kategorie)).append("\n");
    sb.append("    memo: ").append(toIndentedString(memo)).append("\n");
    sb.append("    typ: ").append(toIndentedString(typ)).append("\n");
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

