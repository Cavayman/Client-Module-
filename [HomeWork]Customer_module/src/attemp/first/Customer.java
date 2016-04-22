package attemp.first;

import java.io.Serializable;

public class Customer implements Comparable<Customer>,Serializable {
	private String FirsName;
	private String SecondName;
	private String Address;
	private int GoodsValue;
	private Integer ID;

	public Customer() {
		FirsName = null;
		SecondName = null;
		Address = null;
		GoodsValue = 0;
		ID = null;
	}

	public Customer(String firsName, String secondName, String address, int goodsValue) {
		FirsName = firsName;
		SecondName = secondName;
		Address = address;
		GoodsValue = goodsValue;
		
	}

	public String getFirsName() {
		return FirsName;
	}

	public void setFirsName(String firsName) {
		FirsName = firsName;
	}

	public String getSecondName() {
		return SecondName;
	}

	public void setSecondName(String secondName) {
		SecondName = secondName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public int getGoodsValue() {
		return GoodsValue;
	}

	public void setGoodsValue(int goodsValue) {
		GoodsValue = goodsValue;
	}

	/**
	 * @return the iD
	 */
	public Integer getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(Integer iD) {	
		ID = iD;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Address == null) ? 0 : Address.hashCode());
		result = prime * result + ((FirsName == null) ? 0 : FirsName.hashCode());
		result = prime * result + GoodsValue;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		result = prime * result + ((SecondName == null) ? 0 : SecondName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (Address == null) {
			if (other.Address != null)
				return false;
		} else if (!Address.equals(other.Address))
			return false;
		if (FirsName == null) {
			if (other.FirsName != null)
				return false;
		} else if (!FirsName.equals(other.FirsName))
			return false;
		if (GoodsValue != other.GoodsValue)
			return false;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		if (SecondName == null) {
			if (other.SecondName != null)
				return false;
		} else if (!SecondName.equals(other.SecondName))
			return false;
		return true;
	}

	@Override
	public int compareTo(Customer o) {
		if (this.ID == null)
			return -1;
		if (o.ID == null)
			return 1;
		if (this.ID == o.ID) {
			if(this.FirsName==null)
				return -1;
			if(o.FirsName==null)
				return 1; 
			int res = this.FirsName.compareTo(o.FirsName);
					
			return res;
		
			    
		}
		return this.ID - o.ID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [ID= " + ID + " FirsName=" + FirsName + ", SecondName=" + SecondName + ", Address=" + Address
				+ ", GoodsValue=" + GoodsValue +"]";
	}
	

}
