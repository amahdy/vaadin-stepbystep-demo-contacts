package org.vaadin.stepbystep;

import com.vaadin.data.BeanValidationBinder;
import com.vaadin.server.ExternalResource;
import org.vaadin.stepbystep.person.backend.Person;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by amahdy on 6/1/17.
 */
public class PersonEditorView extends PersonEditorDesign {

    BeanValidationBinder<Person> binder = new BeanValidationBinder<>(Person.class);

    public PersonEditorView(Consumer<Person> saveEvt,
                            Function<Person, Person> cancelEvt,
                            Consumer<Person> delEvt) {
        binder.bindInstanceFields(this);
        binder.setValidationStatusHandler(status -> {
            save.setEnabled(status.isOk());
        });

        save.addClickListener(evt -> saveEvt.accept(binder.getBean()));
        cancel.addClickListener(evt -> setPerson(cancelEvt.apply(binder.getBean())));
        delete.addClickListener(evt -> delEvt.accept(binder.getBean()));
    }

    public void setPerson(Person value) {
        binder.setBean(value);

        picture.setSource(new ExternalResource(value.getPicture()));
    }
}
