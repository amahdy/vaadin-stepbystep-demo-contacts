package org.vaadin.stepbystep.contacts;

import com.vaadin.data.Binder;
import com.vaadin.server.ExternalResource;
import org.vaadin.stepbystep.person.backend.Person;

public class PersonView extends PersonDesign {

	public interface PersonSaveListener {
		void savePerson(Person person);
	}

	public interface PersonCancelListener {
		void resetPerson();
	}

	public interface PersonDeleteListener {
		void deletePerson(Person person);
	}

	Binder<Person> binder = new Binder(Person.class);

	public PersonView(PersonSaveListener saveEvt,
					  PersonCancelListener cancelEvt,
					  PersonDeleteListener delEvt) {
		binder.bindInstanceFields(this);

		save.addClickListener(evt -> saveEvt.savePerson(binder.getBean()));

		cancel.addClickListener(evt -> cancelEvt.resetPerson());

		delete.addClickListener(evt -> delEvt.deletePerson(binder.getBean()));
	}

	public void setPerson(Person selectedRow) {
		binder.setBean(selectedRow);

		picture.setSource(new ExternalResource(selectedRow.getPicture()));
	}

}
