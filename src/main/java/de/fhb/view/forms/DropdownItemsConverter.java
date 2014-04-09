package de.fhb.view.forms;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * @see http://www.mkyong.com/jsf2/custom-converter-in-jsf-2-0/
 * @see http://www.mastertheboss.com/jsf/develop-custom-jsf-converters
 */
@FacesConverter("de.fhb.view.forms.DropdownItemsConverter")
public class DropdownItemsConverter implements Converter {

  @Override
  public Object getAsObject(FacesContext context, UIComponent component, String value) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public String getAsString(FacesContext context, UIComponent component, Object value) {
    if (value == null) {
      return null;
    }
    return value.toString();
  }
}
