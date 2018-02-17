package referralSystem.model;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ReferralPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "referrer_id")
	private User referrer;

	@ManyToOne
	@JoinColumn(name = "item_id")
	private Item item;

	public ReferralPK() {

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

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (o == null)
			return false;
		if (!(o instanceof ReferralPK))
			return false;
		ReferralPK rp = (ReferralPK) o;
		return rp.referrer.equals(referrer) && rp.item.equals(item);

	}

	@Override
	public int hashCode() {
		return referrer.hashCode() + item.hashCode();
	}

}
