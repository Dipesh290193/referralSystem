package referralSystem.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@IdClass(ReferralPK.class)
@Entity
@Table(name = "referrals")
public class Referral implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "referral_id", unique = true, nullable = false)
	@GeneratedValue
	private long referralId;

	@Id
	private User referrer;

	@Id
	private Item item;

	private String referralDescription;

	@Column(nullable = false)
	private String codeOrLink;

	private Date created;

	@Column(name = "view_count")
	private long viewedCount;

	@Column(nullable = false)
	private String whereToUse;

	public Referral() {

	}

	public long getReferralId() {
		return referralId;
	}

	public void setReferralId(long referralId) {
		this.referralId = referralId;
	}

	public User getReferrer() {
		return referrer;
	}

	public void setReferrer(User referrer) {
		this.referrer = referrer;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getReferralDescription() {
		return referralDescription;
	}

	public void setReferralDescription(String referralDescription) {
		this.referralDescription = referralDescription;
	}

	public String getCodeOrLink() {
		return codeOrLink;
	}

	public void setCodeOrLink(String codeOrLink) {
		this.codeOrLink = codeOrLink;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public long getViewedCount() {
		return viewedCount;
	}

	public void setViewedCount(long viewedCount) {
		this.viewedCount = viewedCount;
	}

	public String getWhereToUse() {
		return whereToUse;
	}

	public void setWhereToUse(String whereToUse) {
		this.whereToUse = whereToUse;
	}
}
