package org.vaadin.stepbystep.contacts;

import org.vaadin.stepbystep.person.backend.Person;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;

public class PersonView extends PersonDesign {

	BeanFieldGroup<Person> binder = new BeanFieldGroup<>(Person.class);
	
	public PersonView() {
		binder.bindMemberFields(this);
		
		save.addClickListener(evt -> {
			try {
				binder.commit();
			} catch (CommitException e) {
				e.printStackTrace();
			}
		});
	}
	
	public void setPerson(Person selectedRow) {
		binder.setItemDataSource(selectedRow);
	}

}
