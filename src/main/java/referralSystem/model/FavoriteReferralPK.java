package referralSystem.model;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class FavoriteReferralPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User favoriteUser;

	@ManyToOne
	@JoinColumn(name = "referral_id", referencedColumnName = "referral_id")
	private Referral favoriteReferral;

	public FavoriteReferralPK() {

	}

	public User getFavoriteUser() {
		return favoriteUser;
	}


	public void setFavoriteUser(User favoriteUser) {
		this.favoriteUser = favoriteUser;
	}


	public Referral getFavoriteReferral() {
		return favoriteReferral;
	}


	public void setFavoriteReferral(Referral favoriteReferral) {
		this.favoriteReferral = favoriteReferral;
	}


	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (o == null)
			return false;
		if (!(o instanceof FavoriteReferralPK))
			return false;
		FavoriteReferralPK vrp = (FavoriteReferralPK) o;
		return vrp.favoriteUser.equals(favoriteUser) && vrp.favoriteReferral.equals(favoriteReferral);
	}

	@Override
	public int hashCode() {
		return favoriteUser.hashCode() + favoriteReferral.hashCode();
	}

}
