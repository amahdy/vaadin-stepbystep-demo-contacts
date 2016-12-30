package org.vaadin.stepbystep.contacts;

import org.vaadin.stepbystep.person.backend.Person;

import com.vaadin.data.fieldgroup.BeanFieldGroup;

public class PersonView extends PersonDesign {

	BeanFieldGroup<Person> binder = new BeanFieldGroup<>(Person.class);
	
	public PersonView() {
		binder.bindMemberFields(this);
	}
	
	public void setPerson(Person selectedRow) {
		binder.setItemDataSource(selectedRow);
	}

}
