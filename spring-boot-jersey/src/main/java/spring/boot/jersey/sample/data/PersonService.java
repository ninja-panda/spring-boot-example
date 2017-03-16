package spring.boot.jersey.sample.data;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class PersonService {

	private final List<Person> personList = new ArrayList<>();

	@PostConstruct
	public void init() {
		personList.add(new Person(1, "Bari kruchten", "b.kruchten@xyz.com"));
		personList.add(new Person(2, "Juliet Roker", "jrocker@hkmail.com"));
		personList.add(new Person(3, "Idalia Clover", "clover@hmail.com"));
		personList.add(new Person(1, "Aspaiht", "aspaiht.t@xyz.com"));
	}

	public Person getById(int personId) {
		return personList.stream().filter((person) -> person.getPersonId() == personId).findFirst().get();
	}

	public List<Person> getAllPersons() {
		return personList;
	}

}
