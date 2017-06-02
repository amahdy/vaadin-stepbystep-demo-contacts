package org.vaadin.stepbystep;

import com.vaadin.data.Binder;
import com.vaadin.server.ExternalResource;
import org.vaadin.stepbystep.person.backend.Person;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by amahdy on 6/1/17.
 */
public class PersonEditorView extends PersonEditorDesign {

    Binder<Person> binder = new Binder<>(Person.class);

    public PersonEditorView(Consumer<Person> saveEvt,
                            Function<Person, Person> cancelEvt) {
        binder.bindInstanceFields(this);

        save.addClickListener(evt -> saveEvt.accept(binder.getBean()));
        cancel.addClickListener(evt -> setPerson(cancelEvt.apply(binder.getBean())));
    }

    public void setPerson(Person value) {
        binder.setBean(value);

        picture.setSource(new ExternalResource(value.getPicture()));
    }
}
