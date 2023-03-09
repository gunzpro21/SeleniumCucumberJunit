package models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.datafaker.Faker;
import utilities.UtilitiesJava;

@Getter
@Setter
@AllArgsConstructor
public class Student {
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String school;
	private String studentID;

	public Student() {
		Faker faker= new Faker();
		this.firstName = faker.name().firstName();
		this.lastName = faker.name().lastName();
		this.dateOfBirth = "1999-10-11";
		this.school = "TEST SCHOOL 12";
		this.studentID = "Stu"+UtilitiesJava.getDate() +"."+UtilitiesJava.generatingRandomAlphanumeric(12);
	}
}
