package net.nessafesta.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(table = "INVITATION")
public class Invitation {

	@Id
	private String id;

	/**
     */
	@NotNull
	@NotBlank
	private String title;

	/**
     */
	@Min(1L)
	@Column(name = "number_guests")
	private int numberGuests;

	/**
     */
	@Lob
	private String notes;

	/**
     */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "event")
	private Event event;

	/**
     */
	@OneToMany(mappedBy = "invitation", cascade = CascadeType.ALL)
	private Set<InviteesGroup> inviteeGroups = new HashSet<InviteesGroup>();

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	public Invitation() {
		this.id = UUID.randomUUID().toString();
	}

	public String toString() {
		return this.title;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Invitation)) {
			return false;
		}
		Invitation other = (Invitation) obj;
		return getId().equals(other.getId());
	}
}
