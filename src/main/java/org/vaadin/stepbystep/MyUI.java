package org.vaadin.stepbystep;

import com.vaadin.annotations.Theme;
import com.vaadin.cdi.CDIUI;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.UI;
import org.vaadin.stepbystep.person.backend.Person;
import org.vaadin.stepbystep.person.backend.PersonService;

import javax.inject.Inject;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
@CDIUI("")
public class MyUI extends UI {

    @Inject
    PersonService service;

    HorizontalSplitPanel splitPanel = new HorizontalSplitPanel();
    Grid<Person> grid = new Grid<>(Person.class);
    PersonEditorView editorView = new PersonEditorView(person -> {

        Person save = service.save(person);
        listPersons();
        grid.select(save);

    });

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        listPersons();

        grid.asSingleSelect().addValueChangeListener(evt -> {
           editorView.setPerson(evt.getValue());
        });

        splitPanel.setSizeFull();
        grid.setSizeFull();
        editorView.setSizeFull();

        splitPanel.setFirstComponent(grid);
        splitPanel.setSecondComponent(editorView);

        setContent(splitPanel);

    }

    private void listPersons() {
        grid.setItems(service.getEntries());
    }
}
