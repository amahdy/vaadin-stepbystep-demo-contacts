package org.vaadin.stepbystep.contacts;

import org.vaadin.stepbystep.person.backend.Person;
import org.vaadin.stepbystep.person.backend.PersonService;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Grid;
import com.vaadin.ui.themes.ValoTheme;

public class PersonViewImpl extends PersonViewDesign {

	private FieldGroup fg;
	private Person selected;
	
	private Grid grid;

	public PersonViewImpl(Grid grid, PersonService service) {
		
		this.grid = grid;
		
		fg = new FieldGroup();
		fg.bind(firstname, ContactsView.PROPERTY_FIRSTNAME);
		fg.bind(lastname, ContactsView.PROPERTY_LASTNAME);
		fg.bind(email, ContactsView.PROPERTY_EMAIL);
		fg.bind(dateOfBirth, ContactsView.PROPERTY_DOB);
		fg.bind(notes, ContactsView.PROPERTY_NOTES);
		
		grid.addSelectionListener(event -> {
			selected = (Person) grid.getSelectedRow();
			if(selected == null) {
				loadDefault();
			}else {
				fg.setItemDataSource(grid.getContainerDataSource().getItem(selected));
				picture.setSource(new ExternalResource(selected.getPicture()));
				loadField(true);
			}
		});
		
		save.addClickListener(event -> {
			service.save(selected);
			try {
				fg.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
			loadField(true);
		});
		
		cancel.addClickListener(event -> {
			fg.discard();
			loadField(true);
		});
		
		delete.addClickListener(event -> {
			service.delete(selected);
			grid.getContainerDataSource().removeItem(selected);
			selected = null;
			loadDefault();
		});
		
		edit.addClickListener(event -> {
			loadField(false);
		});
		
		loadDefault();
	}
	
	private void loadDefault() {
		loadField(true);
		grid.select(grid.getContainerDataSource().getItemIds().iterator().next());
	}
	
	private void loadField(boolean isViewMode) {
		if(isViewMode) {
			firstname.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
			lastname.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
			email.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
			dateOfBirth.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
			notes.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
		}else {
			firstname.removeStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
			lastname.removeStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
			email.removeStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
			dateOfBirth.removeStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
			notes.removeStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
		}
		
		firstname.setReadOnly(isViewMode);
		lastname.setReadOnly(isViewMode);
		email.setReadOnly(isViewMode);
		dateOfBirth.setReadOnly(isViewMode);
		notes.setReadOnly(isViewMode);
		
		edit.setVisible(isViewMode);
		
		save.setVisible(!isViewMode);
		cancel.setVisible(!isViewMode);
	}
}
