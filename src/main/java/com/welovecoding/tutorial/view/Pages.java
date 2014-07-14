package com.welovecoding.tutorial.view;

public class Pages {

  public static final String LOGIN = "/login.xhtml";
  public static final String ADMIN_LOGIN = "/login?faces-redirect=true";
  public static final String ADMIN_POST_LOGIN = "/admin/index?faces-redirect=true";
  public static final String ADMIN_AUTHORS = "/admin/authors";
  public static final String ADMIN_CATEGORY = "/admin/categories";
  public static final String ADMIN_INDEX = "/admin/index";
  public static final String ADMIN_PLAYLISTS = "/admin/playlists";
  public static final String ADMIN_VIDEOS = "/admin/videos";
  public static final String ADMIN_USERS = "/admin/users";
  public static final String REST_VERSION_1 = "/rest/fhb/v1";
  public static final String REST_VERSION_2 = "/rest/fhb/v2";

  //REST V2
  public static final String REST_CATEGORY = "categories/{0}";
  public static final String REST_PLAYLIST = "categories/{0}/playlists/{1}";
  public static final String REST_VIDEO = "categories/{0}/playlists/{1}/videos/{2}";

}
