/**
 * 
 */
package net.nessafesta.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import net.nessafesta.domain.AttendeesGroup;
import net.nessafesta.domain.Event;
import net.nessafesta.domain.Invitation;
import net.nessafesta.domain.InviteesGroup;
import net.nessafesta.dto.InvitationDTO;

import org.springframework.stereotype.Service;

/**
 * @author marioni
 * 
 */
@Service
public class InvitationService implements IInvitationService {

	@PersistenceContext
	private EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.nessafesta.service.IInvitationService#findAssignedTo(java.lang.String
	 * , java.lang.String, java.lang.String)
	 */
	@Override
	public Invitation findAssignedTo(final String eventUUID,
			final String invitationUUID) {
		TypedQuery<Invitation> query = entityManager
				.createQuery(
						"FROM Invitation o WHERE o.id=:invitationUUID AND o.event.id=:eventUUID",
						Invitation.class)
				.setParameter("invitationUUID", invitationUUID)
				.setParameter("eventUUID", eventUUID);

		return query.getSingleResult();
	}

	public boolean isInvitationConfirmed(final String eventUUID,
			final String invitationUUID) {
		TypedQuery<AttendeesGroup> query = entityManager
				.createQuery(
						"FROM AttendeesGroup o WHERE o.inviteesGroup.invitation.id=:invitationUUID AND o.inviteesGroup.invitation.event.id=:eventUUID",
						AttendeesGroup.class)
				.setParameter("invitationUUID", invitationUUID)
				.setParameter("eventUUID", eventUUID);

		return query.getResultList().size() > 0;
	}

	public AttendeesGroup findAttendeesGroupOn(final InviteesGroup inviteesGroup) {
		TypedQuery<AttendeesGroup> query = entityManager
				.createQuery(
						"FROM AttendeesGroup o WHERE o.inviteesGroup.id=:inviteesGroupUUID",
						AttendeesGroup.class).setParameter("inviteesGroupUUID",
						inviteesGroup.getId());
		List<AttendeesGroup> result = query.getResultList();
		return result.isEmpty() ? null : result.get(0);
	}

	public List<InvitationDTO> buildInvitationsLink(final Event event,
			final String hostname) {
		final List<InvitationDTO> result = new ArrayList<InvitationDTO>();

		final TypedQuery<Event> query = entityManager.createQuery(
				"FROM Event o WHERE o.id=:eventUUID", Event.class)
				.setParameter("eventUUID", event.getId());
		final Event evento = query.getSingleResult();

		for (final Invitation item : evento.getInvitations()) {
			final String url = String.format(
					"%s/public/view/invitation/%s/%s", hostname,
					item.getEvent().getId(), item.getId());
			result.add(new InvitationDTO(item.getTitle(), item.getEvent()
					.getName(), url, item.getEvent().getPartyDate()));
		}

		return result;
	}
}
