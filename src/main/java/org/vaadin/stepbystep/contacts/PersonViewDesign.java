package org.vaadin.stepbystep.contacts;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.declarative.Design;

/** 
 * !! DO NOT EDIT THIS FILE !!
 * 
 * This class is generated by Vaadin Designer and will be overwritten.
 * 
 * Please make a subclass with logic and additional interfaces as needed,
 * e.g class LoginView extends LoginDesign implements View { }
 */
@DesignRoot
@AutoGenerated
@SuppressWarnings("serial")
public class PersonViewDesign extends HorizontalLayout {
	protected Image picture;
	protected TextField firstname;
	protected TextField lastname;
	protected TextField email;
	protected DateField dateOfBirth;
	protected TextArea notes;
	protected Button save;
	protected Button edit;
	protected Button cancel;
	protected Button delete;

	public PersonViewDesign() {
		Design.read(this);
	}
}
