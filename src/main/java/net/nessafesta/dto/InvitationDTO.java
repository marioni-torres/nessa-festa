package net.nessafesta.dto;

import java.util.Date;

public class InvitationDTO {

	private String title;
	private String event;
	private String url;
	private Date partyDate;

	public InvitationDTO() {
		this("", "", "", null);
	}

	public InvitationDTO(final String title, final String event,
			final String url, final Date partyDate) {
		this.title = title;
		this.event = event;
		this.url = url;
		this.partyDate = partyDate;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the event
	 */
	public String getEvent() {
		return event;
	}

	/**
	 * @param event
	 *            the event to set
	 */
	public void setEvent(String event) {
		this.event = event;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the partyDate
	 */
	public Date getPartyDate() {
		return partyDate;
	}

	/**
	 * @param partyDate the partyDate to set
	 */
	public void setPartyDate(Date partyDate) {
		this.partyDate = partyDate;
	}
}
