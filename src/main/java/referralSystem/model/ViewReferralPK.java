package referralSystem.model;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ViewReferralPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "viwed_user_id")
	private User viewedUserId;

	@ManyToOne
	@JoinColumn(name = "viewed_referral_id", referencedColumnName = "referral_id")
	private Referral viewedReferralId;

	public ViewReferralPK() {

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

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (o == null)
			return false;
		if (!(o instanceof ViewReferralPK))
			return false;
		ViewReferralPK vrp = (ViewReferralPK) o;
		return vrp.viewedUserId.equals(viewedUserId) && vrp.viewedReferralId.equals(viewedReferralId);
	}

	@Override
	public int hashCode() {
		return viewedUserId.hashCode() + viewedReferralId.hashCode();
	}

}
