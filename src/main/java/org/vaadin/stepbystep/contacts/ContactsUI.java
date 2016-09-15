package org.vaadin.stepbystep.contacts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;

import org.vaadin.stepbystep.person.backend.PersonService;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.cdi.CDIUI;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
@CDIUI("")
public class ContactsUI extends UI {

    @Inject
    PersonService service;

    @PostConstruct
    void load() {
        setContent(new ContactsView(service));
    }
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {

    }
}
