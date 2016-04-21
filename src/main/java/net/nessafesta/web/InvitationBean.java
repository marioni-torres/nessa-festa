package net.nessafesta.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import net.nessafesta.domain.Invitation;

import org.springframework.roo.addon.jsf.managedbean.RooJsfManagedBean;
import org.springframework.roo.addon.serializable.RooSerializable;

@RooSerializable
@RooJsfManagedBean(entity = Invitation.class, beanName = "invitationBean")
public class InvitationBean {

	private List<String> columns;
	private Invitation invitation;

	@PostConstruct
	public void init() {
		columns = new ArrayList<String>();
		columns.add("event");
		columns.add("title");
		columns.add("numberGuests");
		columns.add("notes");
	}
}
