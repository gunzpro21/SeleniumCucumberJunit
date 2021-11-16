package stepdefinitions;

import org.junit.Assert;

import contextControls.Supervisor;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import models.Student;
import pageobjects.HoomePageKar;
import pageobjects.StudentPage;

public class StudentPage_Steps {
	Supervisor supervisor;
	StudentPage studentPage;
	HoomePageKar hoomePageKar;
	Student student;
	public StudentPage_Steps(Supervisor s_supervisor) {
		supervisor = s_supervisor;
		studentPage = supervisor.getPageObjectManager().getStudentPage();
		hoomePageKar = supervisor.getPageObjectManager().getHoomePageKar();
	}
	
	@When("^I want to search id as \"([^\"]*)\" of a student$")
	public void i_want_to_search_id_as_of_a_student(String strudentID) throws Throwable {
		hoomePageKar.clickLblStudent();
		studentPage.searchStudentID(strudentID);
	}
	
	@Then("^I can see \"([^\"]*)\" in grid view$")
	public void i_can_see_in_grid_view(String strudentID) throws Throwable {
		Assert.assertEquals(strudentID, studentPage.getTextFirstStudentID());
	}

	@When("^I add new a student$")
	public void i_want_to_add_new_a_student() {
		student= new Student();
		hoomePageKar.clickLblStudent();
		studentPage
		.clickbtnAddStudent()
		.createAStudent(student);
	}

	@Then("^I can filter a created student$")
	public void i_can_filter_a_created_student()  {
		studentPage.searchStudentID(student.getStudentID());
		Assert.assertEquals(student.getStudentID(), studentPage.getTextFirstStudentID());
	}
}
