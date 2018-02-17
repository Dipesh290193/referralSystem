package referralSystem.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@IdClass(ViewReferralPK.class)
@Entity
@Table(name = "view_referrals")
public class ViewReferral implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private User viewedUserId;

	@Id
	private Referral viewedReferralId;

	@Column(name = "view_date", nullable = false)
	private Date viewedDate;

	public ViewReferral() {

	}

	public User getViewedUserId() {
		return viewedUserId;
	}

	public void setViewedUserId(User viewedUserId) {
		this.viewedUserId = viewedUserId;
	}

	public Referral getViewedReferralId() {
		return viewedReferralId;
	}

	public void setViewedReferralId(Referral viewedReferralId) {
		this.viewedReferralId = viewedReferralId;
	}

	public Date getViewedDate() {
		return viewedDate;
	}

	public void setViewedDate(Date viewedDate) {
		this.viewedDate = viewedDate;
	}

}
