package net.nessafesta.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.FacesEvent;

import net.nessafesta.domain.AttendeesGroup;
import net.nessafesta.domain.Invitation;
import net.nessafesta.domain.InviteesGroup;
import net.nessafesta.reference.GuestType;
import net.nessafesta.service.IInvitationService;

import org.primefaces.component.datatable.DataTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ManagedBean(name = "confirmInvitationBean")
@SessionScoped
public class ConfirmInvitationBean {

	private int guests;
	private DataTable dataTable;
	private Invitation invitation;
	private boolean confirmed;
	private List<AttendeesGroup> attendeesGroupList;

	@Autowired
	private IInvitationService invitationService;

	public void loadInvitation(final String eventUUID,
			final String invitationUUID) {
		invitation = invitationService
				.findAssignedTo(eventUUID, invitationUUID);
		confirmed = invitationService.isInvitationConfirmed(eventUUID,
				invitationUUID);
	}

	public int findMaxGuestsAllowedFor(final String guestType) {
		int result = 0;
		final GuestType type = GuestType.valueOf(guestType);
		for (InviteesGroup group : invitation.getInviteeGroups()) {
			if (group.getGuestType() == type) {
				result += group.getInvited();
			}
		}

		return result;
	}

	public List<AttendeesGroup> buildAttendeesGroupForInvitation() {
		attendeesGroupList = new ArrayList<AttendeesGroup>();
		for (InviteesGroup inviteesGroup : invitation.getInviteeGroups()) {
			AttendeesGroup attendeesGroup = invitationService
					.findAttendeesGroupOn(inviteesGroup);
			if (attendeesGroup == null) {
				attendeesGroup = new AttendeesGroup();
				attendeesGroup.setAttending(inviteesGroup.getInvited());
				attendeesGroup.setInviteesGroup(inviteesGroup);
			}
			attendeesGroup.setInviteesGroupId(inviteesGroup.getId());
			attendeesGroupList.add(attendeesGroup);
		}

		return attendeesGroupList;
	}

	public String saveAttendeeGroups() {
		for (final AttendeesGroup attendeesGroup : attendeesGroupList) {
			attendeesGroup.persist();
		}

		return "success";
	}

	public void updateAttendeesNumber(final FacesEvent event) {
		assert event.getSource() != null : "Source firing this event cannot be null";
	}

	/**
	 * @return the guests
	 */
	public int getGuests() {
		return guests;
	}

	/**
	 * @param guests
	 *            the guests to set
	 */
	public void setGuests(int guests) {
		this.guests = guests;
	}

	/**
	 * @return the dataTable
	 */
	public DataTable getDataTable() {
		return dataTable;
	}

	/**
	 * @param dataTable
	 *            the dataTable to set
	 */
	public void setDataTable(DataTable dataTable) {
		this.dataTable = dataTable;
	}

	/**
	 * @return the invitation
	 */
	public Invitation getInvitation() {
		return invitation;
	}

	/**
	 * @return the editable
	 */
	public boolean isConfirmed() {
		return confirmed;
	}

	/**
	 * @return the attendeesGroupList
	 */
	public List<AttendeesGroup> getAttendeesGroupList() {
		return attendeesGroupList;
	}

	/**
	 * @param attendeesGroupList
	 *            the attendeesGroupList to set
	 */
	public void setAttendeesGroupList(List<AttendeesGroup> attendeesGroupList) {
		this.attendeesGroupList = attendeesGroupList;
	}
}
