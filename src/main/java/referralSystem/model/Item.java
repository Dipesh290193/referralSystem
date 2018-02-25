package referralSystem.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "item_id")
	private long itemId;

	@Column(nullable = false)
	private String name;

	@Column(name = "description")
	private String itemDescription;

	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private ItemCategory itemCategory;

	@Column(name = "image_path")
	private String itemImagePath;

	@Column(name = "status", nullable=false)
	private String status;
	
	@OneToMany(mappedBy="item")
	private Set<Referral> referrals;

	public Item() {

	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public ItemCategory getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(ItemCategory itemCategory) {
		this.itemCategory = itemCategory;
	}

	public String getItemImagePath() {
		return itemImagePath;
	}

	public void setItemImagePath(String itemImagePath) {
		this.itemImagePath = itemImagePath;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
