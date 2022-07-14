package level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Person {
	private int id;
	private String name;
	private String city;

	public Person(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}

	@Override
	public String toString() {
		return "{" + "id : " + id + " name: " + name + " city: " + city + "}";
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}

}

class Employee {
	private int id;
	private String name;
	private String city;

	public Employee(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}

	@Override
	public String toString() {
		return "{" + "id : " + id + " name: " + name + " city: " + city + "}";
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}
}

public class Test {

	public static void main(String[] args) {
		List<Person> person = Arrays.asList(new Person(100, "Alex", "Boston"), new Person(200, "Ravi", "Atlanta"),
				new Person(300, "Ashwin", "UTAH"));

		List<Employee> employee = convertList(person);

		System.out.println(person);
		System.out.println(employee);
	}

	private static List<Employee> convertList(List<Person> person) {
		List<Employee> ans = new ArrayList<>();

		for (Person p : person) {
			ans.add(cast(p));
		}

		return ans;
	}

	private static Employee cast(Person person) {
		return new Employee(person.getId(), person.getName(), person.getCity());
	}
}
