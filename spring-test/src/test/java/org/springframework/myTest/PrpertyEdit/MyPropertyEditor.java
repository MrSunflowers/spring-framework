package org.springframework.myTest.PrpertyEdit;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyPropertyEditor extends PropertyEditorSupport {

	private String format = "yyyy-MM-dd";

	public void setFormat(String format) {
		this.format = format;
	}

	@Override
	public void setAsText(String dateStr){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = simpleDateFormat.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.setValue(date);
	}

}
