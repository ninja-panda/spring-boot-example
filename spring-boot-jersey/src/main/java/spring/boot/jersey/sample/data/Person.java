package spring.boot.jersey.sample.data;

public class Person {

	private int personId;
	private String name;
	private String email;

	public Person(int personId, String name, String email) {
		super();
		this.personId = personId;
		this.name = name;
		this.email = email;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
