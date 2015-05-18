package ch.duc.northwind.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the order_details database table.
 * 
 */
@Embeddable
public class OrderDetailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private Integer orderId;

	private Integer productId;

	public OrderDetailPK() {
	}
	public Integer getOrderId() {
		return this.orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getProductId() {
		return this.productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof OrderDetailPK)) {
			return false;
		}
		OrderDetailPK castOther = (OrderDetailPK)other;
		return 
			this.orderId.equals(castOther.orderId)
			&& this.productId.equals(castOther.productId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.orderId.hashCode();
		hash = hash * prime + this.productId.hashCode();
		
		return hash;
	}
}