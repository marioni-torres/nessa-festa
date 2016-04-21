package net.nessafesta.web;

import java.util.List;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import net.nessafesta.domain.Event;
import net.nessafesta.dto.InvitationDTO;
import net.nessafesta.service.IInvitationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.roo.addon.jsf.managedbean.RooJsfManagedBean;
import org.springframework.roo.addon.serializable.RooSerializable;

@RooSerializable
@RooJsfManagedBean(entity = Event.class, beanName = "eventBean")
public class EventBean {

	private Event event;

	@Autowired
	private IInvitationService invitationService;

	public List<InvitationDTO> getAllInvitationsLink() {
		FacesContext fcontext = FacesContext.getCurrentInstance();
		ExternalContext econtext = fcontext.getExternalContext();
		return invitationService.buildInvitationsLink(event, String.format(
				"%s://%s:%s%s", econtext.getRequestScheme(),
				econtext.getRequestServerName(),
				econtext.getRequestServerPort(),
				econtext.getRequestContextPath()));
	}

}
