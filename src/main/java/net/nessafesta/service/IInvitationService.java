package net.nessafesta.service;

import java.util.List;

import net.nessafesta.domain.AttendeesGroup;
import net.nessafesta.domain.Event;
import net.nessafesta.domain.Invitation;
import net.nessafesta.domain.InviteesGroup;
import net.nessafesta.dto.InvitationDTO;

public interface IInvitationService {

	Invitation findAssignedTo(final String eventUUID,
			final String invitationUUID);

	boolean isInvitationConfirmed(final String eventUUID,
			final String invitationUUID);

	AttendeesGroup findAttendeesGroupOn(final InviteesGroup inviteesGroup);

	List<InvitationDTO> buildInvitationsLink(final Event event, final String hostname);
}
