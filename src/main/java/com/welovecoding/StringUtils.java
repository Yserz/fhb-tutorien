package com.welovecoding;

import com.google.api.client.repackaged.com.google.common.base.Joiner;

public class StringUtils {

  public static String join(Object[] list, String delim) {
    return Joiner.on(",").join(list);
  }

  public static String capitalize(String line) {
    return Character.toUpperCase(line.charAt(0)) + line.substring(1);
  }

  public static String lowerFirstChar(String line) {
    return Character.toLowerCase(line.charAt(0)) + line.substring(1);
  }

  public static String getControllerBeanName(Object object) {
    return getControllerBeanName(object.getClass().getSimpleName());
  }

  public static String getControllerBeanName(String type) {
    return lowerFirstChar(type) + "Controller";
  }

  /**
   * @param value Category[id=1]
   * @return String categoryController
   */
  public static String getControllerBeanNameByStringValue(String value) {
    String className = value.substring(0, value.indexOf("["));
    return getControllerBeanName(className);
  }

  /**
   * @param value Category[id=5]
   * @return Long 5
   */
  public static Long getIdByStringValue(String value) {
    String id = value.substring(value.indexOf("id=") + 3, value.indexOf("]"));
    return Long.valueOf(id);
  }

  public static String getMethodName(String key) {
    return String.format("get%sValues", capitalize(key));
  }
}
