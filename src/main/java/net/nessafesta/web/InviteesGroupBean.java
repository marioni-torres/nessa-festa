package net.nessafesta.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import net.nessafesta.domain.InviteesGroup;

import org.springframework.roo.addon.jsf.managedbean.RooJsfManagedBean;
import org.springframework.roo.addon.serializable.RooSerializable;

@RooSerializable
@RooJsfManagedBean(entity = InviteesGroup.class, beanName = "inviteesGroupBean")
public class InviteesGroupBean {
	private List<String> columns;

	@PostConstruct
	public void init() {
		columns = new ArrayList<String>();
		columns.add("event");
		columns.add("invitation");
		columns.add("guestType");
		columns.add("invited");
	}
}
