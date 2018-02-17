package referralSystem.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@IdClass(FavoriteReferralPK.class)
@Entity
@Table(name = "favorite_referrals")
public class FavoriteReferral implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private User favoriteUser;

	@Id
	private Referral favoriteReferral;

	@Column(name = "view_date", nullable = false)
	private Date viewedDate;

	public FavoriteReferral() {

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

	public Date getViewedDate() {
		return viewedDate;
	}

	public void setViewedDate(Date viewedDate) {
		this.viewedDate = viewedDate;
	}

}
