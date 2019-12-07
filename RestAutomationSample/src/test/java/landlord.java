
public class landlord {
	private String firstName;
	private String lastName;
	private boolean trusted;
	private String address;
	private int price;
	private int square;
	private boolean active;
	
	public landlord(String FN,String LN,boolean trusted) {
		this.firstName=FN;
		this.lastName=LN;
		this.trusted=trusted;
	}
	
	public landlord(String address, int price, int square, boolean active) {
		this.address = address;
		this.price = price;
		this.square = square;
		this.active = active;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSquare() {
		return square;
	}

	public void setSquare(int square) {
		this.square = square;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public boolean isTrusted() {
		return trusted;
	}
	public void setTrusted(boolean trusted) {
		this.trusted = trusted;
	}

}
