package org.vaadin.stepbystep.contacts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.vaadin.stepbystep.person.backend.Person;
import org.vaadin.stepbystep.person.backend.PersonService;

import com.vaadin.annotations.Theme;
import com.vaadin.cdi.CDIUI;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.UI;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of a html page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */
@Theme("mytheme")
@CDIUI("")
public class ContactsUI extends UI {

	HorizontalSplitPanel splitter = new HorizontalSplitPanel();
	Grid<Person> grid = new Grid(Person.class);
	PersonView editor = new PersonView(this::savePerson, this::deletePerson);

	@Inject
	PersonService service;

	private void savePerson(Person person) {
		Person newPerson = service.save(person);
		listPersons();
		grid.select(newPerson);
	}

	private void deletePerson(Person person) {
		service.delete(person);
		listPersons();
		selectDefault();
	}

	private void editSelectedPerson() {
		Person selected = grid.asSingleSelect().getValue();
		if(selected != null) {
			editor.setPerson(service.getById(selected.getId()));
		}else {
			selectDefault();
		}
	}

	private void selectDefault() {
		grid.select(service.getFirst());
	}

	private void listPersons() {
		grid.setItems(service.getEntries());
	}

	@PostConstruct
	void load() {
		service.loadData();


		grid.asSingleSelect().addValueChangeListener(evt -> {
			editSelectedPerson();
		});

		listPersons();

		grid.setColumns("firstName","lastName","email");
		// Can also be:
		// grid.addColumn(Person::getFirstName).setCaption("First Name");
		// grid.addColumn(Person::getLastName).setCaption("Last Name");
		// grid.addColumn(Person::getEmail).setCaption("Email");

		selectDefault();
	}

	@Override
	protected void init(VaadinRequest vaadinRequest) {

		splitter.setSizeFull();
		grid.setSizeFull();
		editor.setSizeFull();

		splitter.setFirstComponent(grid);
		splitter.setSecondComponent(editor);

		setContent(splitter);
	}
}
