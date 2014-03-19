package de.fhb.view.forms;

import java.util.HashMap;
import java.util.Map;

// Convention: FormModels have to be called <EntityName>FormModel.java and extends abstract class FormModel
public class AuthorFormModel extends FormModel {

  public AuthorFormModel() {
    super.PROPERTY_ORDER = new String[]{"id", "name", "created", "lastModified"};
  }

  @Override
  public FormInput[] parseProperties(Map<String, Class<?>> properties) {
    HashMap<String, FormInput> inputs = new HashMap<>(properties.size());
    FormInput[] formFields = new FormInput[properties.size()];

    // Parse each property and collect them in a map
    for (Map.Entry<String, Class<?>> property : properties.entrySet()) {
      FormInput input = new FormInput(property);

      String key = input.getKey();

      if (key.equals("id")) {
        input.setReadOnly(true);
      }

      inputs.put(key, input);
    }

    // Sort properties according to "PROPERTY_ORDER"
    int i = 0;
    for (String orderedKey : PROPERTY_ORDER) {
      formFields[i] = inputs.get(orderedKey);
      i++;
    }

    return formFields;
  }
}
