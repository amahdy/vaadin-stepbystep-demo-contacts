package org.vaadin.stepbystep.contacts;

import org.vaadin.stepbystep.person.backend.Person;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.server.ExternalResource;

public class PersonView extends PersonDesign {

	public interface PersonChangeEvent {
		void savePerson(Person person);

		void deletePerson(Person person);
	}

	BeanFieldGroup<Person> binder = new BeanFieldGroup<>(Person.class);

	public PersonView(PersonChangeEvent event) {
		binder.bindMemberFields(this);

		save.addClickListener(evt -> {
			try {
				binder.commit();
				event.savePerson(binder.getItemDataSource().getBean());
			} catch (CommitException e) {
				e.printStackTrace();
			}
		});

		cancel.addClickListener(evt -> {
			binder.discard();
		});

		delete.addClickListener(evt -> {
			event.deletePerson(binder.getItemDataSource().getBean());
		});
	}

	public void setPerson(Person selectedRow) {
		binder.setItemDataSource(selectedRow);

		picture.setSource(new ExternalResource(selectedRow.getPicture()));
	}

}
