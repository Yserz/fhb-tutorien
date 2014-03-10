package de.fhb.controller;

import de.fhb.entities.BaseEntity;
import de.fhb.service.BaseService;
import de.fhb.util.JSFUtils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import javax.faces.application.Application;
import javax.faces.component.UIOutput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import org.apache.myfaces.custom.fieldset.Fieldset;

/**
 * @author MacYser
 * @see http://docs.oracle.com/javaee/7/tutorial/doc/jsf-page002.htm#BNARF
 */
public abstract class GenFormBaseController<T extends BaseEntity, E extends BaseService> extends BaseController<T, E> {

  private static final long serialVersionUID = 1L;
  private transient HtmlForm form;

  public void setForm(HtmlForm form) {
    this.form = form;
  }

  public HtmlForm getForm() {
    FacesContext context = FacesContext.getCurrentInstance();
    Application app = context.getApplication();
    form = (HtmlForm) app.createComponent(HtmlForm.COMPONENT_TYPE);
    form.setStyleClass("pure-form pure-form-stacked");

    UIOutput legend = new UIOutput();
    legend.setRendererType("javax.faces.Text");
    legend.getAttributes().put("escape", false);
    legend.setValue("<legend>Eintrag bearbeiten</legend>");

    // Create form fields from entity (business model) 
    Fieldset fieldset = new Fieldset();
    fieldset.getChildren().add(legend);

    if (item != null) {
      for (Map.Entry<String, Class<?>> property : getAttributes(item).entrySet()) {
        // Label
        HtmlOutputLabel label = (HtmlOutputLabel) app.createComponent(HtmlOutputLabel.COMPONENT_TYPE);
        label.setValue(property.getKey());
        fieldset.getChildren().add(label);

        // Input
        HtmlInputText input = (HtmlInputText) app.createComponent(HtmlInputText.COMPONENT_TYPE);
        String valueExpression = "#{" + getELClassname() + ".item." + property.getKey() + "}";
        System.out.println("ValueExpression: " + valueExpression);
        input.setValueExpression("value", JSFUtils.createValueExpression(valueExpression, property.getValue()));
        fieldset.getChildren().add(input);
      }
    }

    /*
     HtmlCommandButton button = (HtmlCommandButton) app.createComponent(HtmlCommandButton.COMPONENT_TYPE);
     button.setStyleClass("pure-button pure-button-primary");
     ELContext elContext = FacesContext.getCurrentInstance().getELContext();
     MethodExpression expression = app.getExpressionFactory().createMethodExpression(elContext, "#{authorController.edit}", Void.class, new Class[0]);
     button.setActionExpression(expression);
    
     // .setAction(context.getApplication().createMethodBinding("#{Handler.action_replyToComment}", null));
     */
//    HtmlCommandButton button = (HtmlCommandButton) app.createComponent(HtmlCommandButton.COMPONENT_TYPE);
//    button.setAction(context.getApplication().createMethodBinding("#{authorController.edit}", null));

    form.getChildren().add(fieldset);
//    form.getChildren().add(button);

    return form;
  }

  private Map<String, Class<?>> getAttributes(Object obj) {
    Map<String, Class<?>> attributes = new HashMap<>();

    Field[] objectFields = obj.getClass().getDeclaredFields();
    Field[] superclassFields = obj.getClass().getSuperclass().getDeclaredFields();

    // check for class
    for (Field field : objectFields) {
      System.out.println("Fieldname: " + field.getName() + " Fieldtype: " + field.getType());

      if (checkGetterPresent(obj.getClass(), field) && isJavaLang(field.getType())) {
        attributes.put(field.getName(), field.getType());
      }
    }

    // check for superclass
    for (Field field : superclassFields) {
      System.out.println("Fieldname: " + field.getName() + " Fieldtype: " + field.getType());

      if (checkGetterPresent(obj.getClass().getSuperclass(), field) && isJavaLang(field.getType())) {
        attributes.put(field.getName(), field.getType());
      }
    }

    return attributes;
  }

  /**
   * @deprecated A Property file will translate all keys and provide capital
   * letters.
   * @param line
   * @return
   */
  private String capitalize(String line) {
    return Character.toUpperCase(line.charAt(0)) + line.substring(1);
  }

  private String getELClassname() {
    String classname = this.getClass().getSimpleName();
    classname = Character.toLowerCase(classname.charAt(0)) + classname.substring(1);
    return classname;
  }

  private boolean checkGetterPresent(Class<?> clazz, Field field) {
    Class<?>[] emptyParamObjects = new Class<?>[]{};
    boolean isPresent = false;
    try {
      clazz.getDeclaredMethod("get" + capitalize(field.getName()), emptyParamObjects);
      isPresent = true;
    } catch (NoSuchMethodException ex) {
      // NO-OP ignore the field
    }
    return isPresent;
  }

  private boolean isJavaLang(Class<?> type) {
    if (type.isPrimitive()) {
      return true;
    } else {
      return type.getPackage().getName().startsWith("java.");
    }
  }

}
