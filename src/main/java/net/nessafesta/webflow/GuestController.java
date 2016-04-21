/**
 * $Id$
 *
 * Copyright (c) 2014, Disney Enterprises, Inc.
 */
package net.nessafesta.webflow;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Spring MVC controller used to forward the client to the 'home' page (touch
 * point view), and to get the details of the user tapping the magic band on the
 * xBRC.
 * 
 * @author torrm268
 * 
 */
@Controller
public class GuestController {

	/**
	 * Action to forward user to the invitation's detail view.
	 * 
	 * @param eventUUID
	 *            The event UUID the guest is invited to
	 * @param invitationUUID
	 *            The invitation UUID the guest is linked to
	 * @param model
	 *            The model to be rendered on the view.
	 * 
	 * @return The forward to the invitation's detail view.
	 */
	@RequestMapping(value = "/view/invitation/{eventUUID}/{invitationUUID}", method = RequestMethod.GET)
	public String viewInvitation(@PathVariable final String eventUUID,
			@PathVariable final String invitationUUID, final Model model) {

		return String.format(
				"forward:/public/invitation?eventUUID=%s&invitationUUID=%s",
				eventUUID, invitationUUID);
	}
}
