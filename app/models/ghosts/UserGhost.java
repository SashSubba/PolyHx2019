package models.ghosts;

public class UserGhost {
	public String email;
	public String password;
	public String password2;
	public String number;
	public String unit;
	public String street;
	public String postalCode;
	public String province;
	public String city;
	public String country;
	public String firstName;
	public String lastName;
	public int yob;
	public int mob;
	public int dob;
	public String phoneNumber;
	public UserGhost parentUser;

	@Override
	public String toString() {
		return firstName + " " + lastName + ", " + email + " - " + password;
	}
}
