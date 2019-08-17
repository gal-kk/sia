package gk.gk.Repository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Table(name="Taco_Order")
public class Order {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;

  @javax.validation.constraints.NotBlank(message="Delivery name is required")
  private String deliveryName;

  @NotBlank(message="Street is required")
  private String deliveryStreet;

  @NotBlank(message="City is required")
  private String deliveryCity;

  @NotBlank(message="State is required")
  private String deliveryState;

  @NotBlank(message="Zip code is required")
  private String deliveryZip;

  @NotBlank(message="Not a valid credit card number")
  private String ccNumber;

  @NotBlank(message="Must be formatted MM/YY")
  private String ccExpiration;

  @NotBlank(message="Invalid CVV")
  private String ccCVV;

  @ManyToMany(targetEntity = Taco.class)
  private List<Taco> tacos = new ArrayList<>();

  public void addTaco(Taco taco){
    tacos.add(taco);
  }


  public List<Taco> getTacos() {
    return tacos;
  }

  public void setTacos(List<Taco> tacos) {
    this.tacos = tacos;
  }

  public Order() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDeliveryName() {
    return deliveryName;
  }

  public void setDeliveryName(String deliveryName) {
    this.deliveryName = deliveryName;
  }

  public String getDeliveryStreet() {
    return deliveryStreet;
  }

  public void setDeliveryStreet(String deliveryStreet) {
    this.deliveryStreet = deliveryStreet;
  }

  public String getDeliveryCity() {
    return deliveryCity;
  }

  public void setDeliveryCity(String deliveryCity) {
    this.deliveryCity = deliveryCity;
  }

  public String getDeliveryState() {
    return deliveryState;
  }

  public void setDeliveryState(String deliveryState) {
    this.deliveryState = deliveryState;
  }

  public String getDeliveryZip() {
    return deliveryZip;
  }

  public void setDeliveryZip(String deliveryZip) {
    this.deliveryZip = deliveryZip;
  }

  public String getCcNumber() {
    return ccNumber;
  }

  public void setCcNumber(String ccNumber) {
    this.ccNumber = ccNumber;
  }

  public String getCcExpiration() {
    return ccExpiration;
  }

  public void setCcExpiration(String ccExpiration) {
    this.ccExpiration = ccExpiration;
  }

  public String getCcCVV() {
    return ccCVV;
  }

  public void setCcCVV(String ccCVV) {
    this.ccCVV = ccCVV;
  }
}
