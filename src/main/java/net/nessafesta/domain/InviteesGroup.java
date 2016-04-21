package net.nessafesta.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import net.nessafesta.reference.GuestType;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(identifierField = "id", table = "INVITEES_GROUP")
public class InviteesGroup {

	/**
     */
	@NotNull
	@Enumerated
	@Column(name = "guest_type")
	private GuestType guestType;

	/**
     */
	@Min(1L)
	private int invited;

	/**
     */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "invitation")
	private Invitation invitation;

	/**
     */
	@OneToMany(mappedBy = "inviteesGroup", cascade = CascadeType.ALL)
	private Set<AttendeesGroup> attendeeGroups = new HashSet<AttendeesGroup>();

	public String toString() {
		return String.format("%s (%d %s invited)", this.invitation,
				this.invited, this.guestType);
	}

	public Event getEvent() {
		return this.invitation.getEvent();
	}
}
