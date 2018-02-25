package referralSystem.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "referrals",uniqueConstraints= {@UniqueConstraint(columnNames= {"referrer_id","item_id"})})
public class Referral implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "referral_id", unique = true, nullable = false)
	@GeneratedValue
	@Id
	private long referralId;

	@ManyToOne
	@JoinColumn(name = "referrer_id")
	private User referrer;

	@ManyToOne
	@JoinColumn(name = "item_id")
	private Item item;

	@Column(name="referral_description")
	private String referralDescription;

	@Column(nullable = false)
	private String codeOrLink;

	private Date created;

	@Column(name = "view_count")
	private long viewedCount;

	@Column(nullable = false)
	private String whereToUse;

	//Count of favorites
	@Column(name = "likes")
	private int numberOfLikes;

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

	public int getNumberOfLikes() {
		return numberOfLikes;
	}

	public void setNumberOfLikes(int numberOfLikes) {
		this.numberOfLikes = numberOfLikes;
	}

}
