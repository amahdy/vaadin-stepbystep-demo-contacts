package org.vaadin.stepbystep;

import com.vaadin.data.Binder;
import org.vaadin.stepbystep.person.backend.Person;

/**
 * Created by amahdy on 6/1/17.
 */
public class PersonEditorView extends PersonEditorDesign {

    Binder<Person> binder = new Binder<>(Person.class);

    public PersonEditorView() {
        binder.bindInstanceFields(this);
    }

    public void setPerson(Person value) {
        binder.setBean(value);
    }
}
