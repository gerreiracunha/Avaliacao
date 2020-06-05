package com.teste.ibm.filmes.domain;

import java.io.Serializable;

public class Filmes implements Serializable {

  public String Title;
  public String Year;
  public String imdbID;
  public String url;

  public String getTitle() {
    return Title;
  }

  public void setTitle(String title) {
    Title = title;
  }

  public String getYear() {
    return Year;
  }

  public void setYear(String year) {
    Year = year;
  }

  public String getImdbID() {
    return imdbID;
  }

  public void setImdbID(String imdbID) {
    this.imdbID = imdbID;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
