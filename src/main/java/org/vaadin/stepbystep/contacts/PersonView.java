package org.vaadin.stepbystep.contacts;

import org.vaadin.stepbystep.person.backend.Person;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.server.ExternalResource;

public class PersonView extends PersonDesign {

	BeanFieldGroup<Person> binder = new BeanFieldGroup<>(Person.class);
	
	public PersonView() {
		binder.bindMemberFields(this);
		
		save.addClickListener(evt -> {
			try {
				binder.commit();
				((ContactsUI) getUI()).savePerson(binder.getItemDataSource().getBean());
			} catch (CommitException e) {
				e.printStackTrace();
			}
		});
	}
	
	public void setPerson(Person selectedRow) {
		binder.setItemDataSource(selectedRow);
		
		picture.setSource(new ExternalResource(selectedRow.getPicture()));
	}

}
