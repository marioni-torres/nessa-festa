package net.nessafesta.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import net.nessafesta.reference.EventType;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(table = "EVENT")
public class Event {

	@Id
	private String id;

	/**
     */
	@NotNull
	@NotBlank
	private String name;

	/**
     */
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "M-")
	@Column(name = "party_date")
	private Date partyDate;

	/**
     */
	@Min(1L)
	@Column(name = "party_size")
	private long partySize;

	/**
     */
	@NotNull
	@Enumerated
	private EventType type;

	/**
     */
	@OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
	private Set<Invitation> invitations = new HashSet<Invitation>();

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

	public Event() {
		this.id = UUID.randomUUID().toString();

	}

	public String toString() {
		return this.name;
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
		if (!(obj instanceof Event)) {
			return false;
		}
		Event other = (Event) obj;
		return getId().equals(other.getId());
	}
}
