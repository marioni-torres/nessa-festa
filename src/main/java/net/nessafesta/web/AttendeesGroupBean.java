package net.nessafesta.web;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import net.nessafesta.domain.AttendeesGroup;

import org.springframework.roo.addon.jsf.managedbean.RooJsfManagedBean;
import org.springframework.roo.addon.serializable.RooSerializable;

@RooSerializable
@RooJsfManagedBean(entity = AttendeesGroup.class, beanName = "attendeesGroupBean")
public class AttendeesGroupBean {
    private List<String> columns;

    @PostConstruct
    public void init() {
        columns = new ArrayList<String>();
        columns.add("inviteesGroup");
        columns.add("attending");
    }
}
