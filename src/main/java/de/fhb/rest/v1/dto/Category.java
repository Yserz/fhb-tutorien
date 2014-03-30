package de.fhb.rest.v1.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;

@JsonPropertyOrder({
  "id",
  "name",
  "color",
  "numberOfVideos",
  "availableLanguages"
})
public class Category {

  private long id;
  private String name;
  private String color;
  private int numberOfVideos;
  private List<String> availableLanguages;

  public Category() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    if (name == null || name.isEmpty()) {
    } else {
      this.name = name;
    }
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    if (color == null || color.isEmpty()) {
    } else {
      this.color = color;
    }
  }

  public int getNumberOfVideos() {
    return numberOfVideos;
  }

  public void setNumberOfVideos(int numberOfVideos) {
    this.numberOfVideos = numberOfVideos;
  }

  public List<String> getAvailableLanguages() {
    return availableLanguages;
  }

  public void setAvailableLanguages(List<String> availableLanguages) {
    this.availableLanguages = availableLanguages;
  }

}