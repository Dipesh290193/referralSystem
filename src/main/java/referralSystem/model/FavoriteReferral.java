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
@Table(name = "favorite_referrals",uniqueConstraints= {@UniqueConstraint(columnNames= {"user_id","referral_id"})})
public class FavoriteReferral implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "favorite_referrals_id")
	private long favoriteReferralsId;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User favoriteUser;

	@ManyToOne
	@JoinColumn(name = "referral_id")
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
