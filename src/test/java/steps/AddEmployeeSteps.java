package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.ExcelReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {
    @When("user clicks on Add Employee option")
    public void user_clicks_on_add_employee_option() {
        WebElement addEmployeeOption = driver.findElement(By.id("menu_pim_addEmployee"));
        click(addEmployeeOption);
    }
    @When("user enters firstname and middlename and lastname")
    public void user_enters_firstname_and_middlename_and_lastname() {
        //WebElement firstNameloc = driver.findElement(By.id("firstName"));
        //WebElement middleNameloc = driver.findElement(By.id("middleName"));
        //WebElement lastNameloc = driver.findElement(By.id("lastName"));

        sendText("ella",addEmployeePage.firstNameLocator);
        sendText("ms", addEmployeePage.middleNameLocator);
        sendText("neopaney", addEmployeePage.lastNameLocator);


    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        //WebElement saveButton = driver.findElement(By.id("btnSave"));
        //click(saveButton);
        click(addEmployeePage.saveButton);

    }

    @Then("user is added successfully")
    public void user_is_added_successfully() {
        System.out.println("Employee Added");
    }

    @When("user enters {string} and {string} and {string}")
    public void user_enters_and_and(String fn, String mn, String ln) {
        //WebElement firstNameloc = driver.findElement(By.id("firstName"));
        //WebElement middleNameloc = driver.findElement(By.id("middleName"));
        //WebElement lastNameloc = driver.findElement(By.id("lastName"));

        sendText(fn, addEmployeePage.firstNameLocator);
        sendText(mn, addEmployeePage.middleNameLocator);
        sendText(ln, addEmployeePage.lastNameLocator);
    }

    @When("user enters {string} and  {string} and {string} values")
    public void user_enters_and_and_values(String fn, String mn, String ln) {
        //WebElement firstNameloc = driver.findElement(By.id("firstName"));
        //WebElement middleNameloc = driver.findElement(By.id("middleName"));
        //WebElement lastNameloc = driver.findElement(By.id("lastName"));

        sendText(fn, addEmployeePage.firstNameLocator);
        sendText(mn, addEmployeePage.middleNameLocator);
        sendText(ln, addEmployeePage.lastNameLocator);
    }

    @When("user adds multiple employees from datatable and verify it is added")
    public void user_adds_multiple_employees_from_datatable_and_verify_it_is_added
            (io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> employeeNames = dataTable.asMaps();




        //it will give me one map at one point of time
        for (Map<String,String> employee:employeeNames){
            //WebElement firstNameloc = driver.findElement(By.id("firstName"));
            //WebElement middleNameloc = driver.findElement(By.id("middleName"));
            //WebElement lastNameloc = driver.findElement(By.id("lastName"));

            //it will give me values from the map
            sendText(employee.get("firstname"), addEmployeePage.firstNameLocator);
            sendText(employee.get("middlename"), addEmployeePage.middleNameLocator);
            sendText(employee.get("lastname"), addEmployeePage.lastNameLocator);
            // Thread.sleep(2000);
            //WebElement saveButton = driver.findElement(By.id("btnSave"));
            //click(saveButton);
            click(addEmployeePage.saveButton);
            //after clicking on save button again I have go to add employee page
            Thread.sleep(2000);
            //WebElement addEmployeeOption = driver.findElement(By.id("menu_pim_addEmployee"));
            //click(addEmployeeOption);
            click(dashboardPage.addEmployeeOption);
            Thread.sleep(2000);


        }

    }

    @When("user adds multiple employees from excel file and validate them")
    public void user_adds_multiple_employees_from_excel_file_and_validate_them() throws IOException, InterruptedException, IOException {
        //we need to read the data from excel file
        List<Map<String, String>> newEmployees = ExcelReader.read();

        for (Map<String, String> employee :newEmployees){
            //WebElement firstNameloc = driver.findElement(By.id("firstName"));
            //WebElement middleNameloc = driver.findElement(By.id("middleName"));
            //WebElement lastNameloc = driver.findElement(By.id("lastName"));

            sendText(employee.get("firstName"), addEmployeePage.firstNameLocator);
            sendText(employee.get("middleName"), addEmployeePage.middleNameLocator);
            sendText(employee.get("lastName"), addEmployeePage.lastNameLocator);

            //WebElement saveButton = driver.findElement(By.id("btnSave"));
            //click(saveButton);

            WebElement addEmployeeOption = driver.findElement(By.id("menu_pim_addEmployee"));
            //click(addEmployeeOption);
            click(dashboardPage.addEmployeeOption);
            Thread.sleep(2000);

        }

    }
}


