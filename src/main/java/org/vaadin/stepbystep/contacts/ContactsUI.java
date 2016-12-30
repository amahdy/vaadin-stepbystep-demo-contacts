package org.vaadin.stepbystep.contacts;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class ContactsUI extends UI {

	HorizontalSplitPanel splitter = new HorizontalSplitPanel();
	Grid grid = new Grid();
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {

    		splitter.setSizeFull();
    		grid.setSizeFull();
    		
    		splitter.setFirstComponent(grid);
        
        setContent(splitter);
    }

    @WebServlet(urlPatterns = "/*", name = "ContactsUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = ContactsUI.class, productionMode = false)
    public static class ContactsUIServlet extends VaadinServlet {
    }
}
