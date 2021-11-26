package org.springframework.myTest.PrpertyEdit;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

import java.beans.PropertyEditor;

public class DatePropertyEditorRegistrars implements PropertyEditorRegistrar {

	private PropertyEditor propertyEditor;

	@Override
	public void registerCustomEditors(PropertyEditorRegistry registry) {
		registry.registerCustomEditor(java.util.Date.class,propertyEditor);
	}

	public void setPropertyEditor(PropertyEditor propertyEditor) {
		this.propertyEditor = propertyEditor;
	}
}
