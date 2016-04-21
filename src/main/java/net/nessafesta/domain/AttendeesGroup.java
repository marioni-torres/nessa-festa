package net.nessafesta.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(table = "ATTENDEES_GROUP")
public class AttendeesGroup {

	@Id
	@Column(name = "invitees_group")
	private Long inviteesGroupId;

	/**
     */
	@Min(0L)
	private int attending;

	/**
     */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "invitees_group", insertable = false, updatable = false)
	private InviteesGroup inviteesGroup;

	public String toString() {
		return String.format("%s (%d attending)", this.inviteesGroup,
				this.attending);
	}
}
