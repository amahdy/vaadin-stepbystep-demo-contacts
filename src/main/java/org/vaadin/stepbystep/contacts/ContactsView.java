package org.vaadin.stepbystep.contacts;

import org.vaadin.stepbystep.person.backend.Person;
import org.vaadin.stepbystep.person.backend.PersonService;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalSplitPanel;

public class ContactsView extends CustomComponent {

	private BeanItemContainer<Person> container;
	private Grid grid;

	public static final String PROPERTY_FIRSTNAME = "firstname";
	public static final String PROPERTY_LASTNAME = "lastname";
	public static final String PROPERTY_EMAIL = "email";
	public static final String PROPERTY_DOB = "birthDate";
	public static final String PROPERTY_NOTES = "notes";
	
	public ContactsView(PersonService service) {
		
		service.loadData();
		
		container = new BeanItemContainer<>(Person.class, service.getEntries());
		
		grid = new Grid(container);
		grid.setSizeFull();
		grid.removeAllColumns();
		
		grid.addColumn(PROPERTY_FIRSTNAME);
		grid.getColumn(PROPERTY_FIRSTNAME).setHeaderCaption("First Name");
		grid.addColumn(PROPERTY_LASTNAME);
		grid.getColumn(PROPERTY_LASTNAME).setHeaderCaption("Last Name");
		
		HorizontalSplitPanel splitter = new HorizontalSplitPanel();
		splitter.setSplitPosition(30, Unit.PERCENTAGE);
		
		splitter.setFirstComponent(grid);
		splitter.setSecondComponent(new PersonViewImpl(grid, service));
		
		setSizeFull();
		setCompositionRoot(splitter);
	}

}
