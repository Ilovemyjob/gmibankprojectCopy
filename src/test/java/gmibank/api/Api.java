package gmibank.api;

import gmibank.utilities.ConfigReader;
import gmibank.utilities.TestBase;
import io.cucumber.java.bs.I;
import io.cucumber.java.cs.A;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.*;
import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Api extends TestBase {
     /*
	 Positive Scenario
	 when I send a GET Request to https://restful-booker.herokuapp.com/booking
	 and I accept type "application/json"  ==> Means API is accepting data just in Json Format
	 then status code should be 200
	 and content type should be "application/json" ==> Response body must be in Json format
	 */

    @Test
    public void semaver() {
        Response response = given().when().get("https://restful-booker.herokuapp.com/booking");

        response.prettyPrint();

            response.then().assertThat().statusCode(200).contentType("application/json");
    }

    /*
	 Negative Scenario
	 when I send a GET Request to https://restful-booker.herokuapp.com/booking/1001
	 then status code should be 404
	 and Response Body contains "Not Found"
	 and Response Body does not contain "Suleyman"
	*/

    //url base
    //uri base + son kismi
    @Test
    public void semaver2() {

        Response response = given().when().get("https://restful-booker.herokuapp.com/booking/1001");

        response.then().assertThat().statusCode(404);

        Assert.assertTrue(response.asString().contains("Not Found"));
        Assert.assertFalse(response.asString().contains("Suleyman"));


    }
/*
		 	                    Warm Up (10 minutes)
		 1) Create a class and name it as GetRequest03
		 2) When I send a GET Request to https://restful-booker.herokuapp.com/booking/5
		    Then
		    HTTP Status code should be "200"
		    And  Content type should be in "JSON" format
		    And  Status Line should be "HTTP/1.1 200 OK"
		    And  response body does not contain "Not Found"
		    And  response body contains "bookingdates"
	*/

    @Test
    public void semaver3() {

        Response response = given().when().get("https://restful-booker.herokuapp.com/booking/5");

        response.prettyPrint();

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).statusLine("HTTP/1.1 200 OK");

        Assert.assertFalse(response.asString().contains("Not Found"));
        Assert.assertTrue(response.asString().contains("bookingdates"));

/*
		When I send a GET request to REST API URL
		https://restful-booker.herokuapp.com/booking/1
	    And Accept type is “application/JSON”
	    Then
	    HTTP Status Code should be 200
	    And Response format should be "application/JSON"
	    And firstname should be "Susan"
	    And lastname should be "Brown"
	    And checkin date should be "2015-02-16"
	    And checkout date should be "2017-06-20"
   */

    }

    @Test
    public void semaver4() {

        Response response = given().
                //accept("application/JSON").
                        when().
                        get("https://restful-booker.herokuapp.com/booking/10");

        response.prettyPrint();
            response.then().
                    assertThat().
                    contentType("application/JSON").
                    statusCode(200).
                    body("firstname", equalTo("Jim"),
                    "lastname", equalTo("Brown"),
                     "bookingdates.checkout", equalTo("2018-01-18"),
                     "bookingdates.checkin", equalTo("2016-01-05"));
        }


/*
		When
		    I send a GET request to REST API URL
			http://dummy.restapiexample.com/api/v1/employees
	        And accept type is “application/JSON”
	    Then
		    HTTP Status Code should be 200
		    And Response format should be "application/JSON"
		    And there should be 24 employees
		    And "Ashton Cox" should be one of the employees
		    And 21, 61, and 23 should be among the employee ages
    */


            @Test
           public void semaver6() {

          Response response = given().when().get("http://dummy.restapiexample.com/api/v1/employees");

        response.prettyPrint();



        response.then().
                statusCode(200).
                contentType(ContentType.JSON).
                body("data.id", Matchers.hasSize(24),
                        "data.employee_name",Matchers.hasItem("Ashton Cox"),
                        "data.employee_age",Matchers.hasItems("61","21","23"));


        Assert.assertTrue(response.asString().contains("Ashton Cox"));
        Assert.assertTrue(response.asString().contains("61"));
        Assert.assertTrue(response.asString().contains("21"));
        Assert.assertTrue(response.asString().contains("23"));
        // Assert.assertEquals(hasSize(24),"data.id");

    }

/*
		     				Warm Up (13 minutes)
		1) Create a class and name it as you wish :)
		2) When
		     I send a GET Request to https://jsonplaceholder.typicode.com/todos
		   Then
			 HTTP Status code should be "200"
			 And Content type should be in "JSON" format
			 And there should be 200 "title"
			 And "dignissimos quo nobis earum saepe" should be one of the "title"s
			 And 111, 121, and 131 should be among the "id"s
			 And 4th title is "et porro tempora"
			 And last title is "ipsam aperiam voluptates qui"
    */

    @Test
    public void api1() {
        Response response = given().accept(ContentType.JSON).spec(spec02).when().get();
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
     //   System.out.println(jsonPath.getString());
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
        Assert.assertEquals(200, jsonPath.getList("id").size());
        Assert.assertTrue(jsonPath.getList("title").contains("dignissimos quo nobis earum saepe"));
        List<Integer> idList = new ArrayList<>();
        idList.add(111);
        idList.add(121);
        idList.add(131);
        Assert.assertTrue(jsonPath.getList("id").containsAll(idList));
        Assert.assertEquals("et porro tempora", jsonPath.getString("title[3]"));
        Assert.assertEquals("ipsam aperiam voluptates qui", jsonPath.getString("title[-1]"));
    }

    /*
        When
            I send a GET request to REST API URL
            https://restful-booker.herokuapp.com/booking/5
        Then
            HTTP Status Code should be 200
            And response content type is “application/JSON”
            And response body should be like;
            {
             "firstname": "Sally",
             "lastname": "Ericsson",
             "totalprice": 111,
             "depositpaid": false,
             "bookingdates": { "checkin": "2017-05-23",
                               "checkout":"2019-07-02" }
            }
       */
    @Test
    public void api2() {

        spec03.pathParam("id",5);
        Response response = given().
             //   accept(ContentType.JSON).
                spec(spec03).when().
                get("/{id}");
        response.prettyPrint();

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);

        JsonPath jsonPath = response.jsonPath();
   //     1.yol
        System.out.println(jsonPath.getString("firstname"));
    //    2.yol
        String exname= jsonPath.getString("firstname");
        System.out.println(exname);

        System.out.println(jsonPath.getString("firstname"));
        System.out.println(jsonPath.getString("lastname"));
        System.out.println(jsonPath.getString("totalprice"));
        System.out.println(jsonPath.getString("depositpaid"));
        System.out.println(jsonPath.getString("bookingdates.checkin"));

        System.out.println(jsonPath.getString("bookingdates.checkout"));




    }
/*
	 When
	 	 I send GET Request to http://dummy.restapiexample.com/api/v1/employees
	 Then
		 Status code is 200
		 1)Print all ids greater than 10 on the console
		   Assert that there are 14 ids greater than 10
		 2)Print all ages less than 30 on the console
		   Assert that maximum age is 23
		 3)Print all employee names whose salaries are greater than 350000
		   Assert that Charde Marshall is one of the employees whose salary is greater than 350,000
		 4)Print all employee salaries whose ids are less than 11
		   Assert that maximum salary is 433060
	 */

    @Test
    public void api3() {


        Response response= given().spec(spec01).when().get();
        response.prettyPrint();

        response.then().statusCode(200);
        JsonPath jsonPath =response.jsonPath();
        SoftAssert softAssert = new SoftAssert();
        //1.soru
        List<String> idList = jsonPath.getList("data.findAll{Integer.valueOf(it.id)>10}.id ");

        System.out.println(idList);
        System.out.println(idList.size());

        softAssert.assertEquals(idList.size(),14);
//2.soru
        List<String> agesList = jsonPath.getList("data.findAll{Integer.valueOf(it.employee_age)<30}.employee_age");
        List<Integer> maxList = new ArrayList<>();
        System.out.println(agesList);


        for (String age:agesList){
            maxList.add(Integer.valueOf(age));
        }
        System.out.println(maxList);
        Collections.sort(maxList);
        System.out.println();


        softAssert.assertTrue(maxList.get(maxList.size()-1)==23);
        softAssert.assertAll();

        System.out.println("------------");
//3
        List<String> empName = jsonPath.getList("data.findAll{Integer.valueOf(it.employee_salary)>350000}.employee_name");
        System.out.println(empName);
        Assert.assertTrue(empName.contains("Charde Marshall"));

        //4
        List<String> empSalary = jsonPath.getList("data.findAll{Integer.valueOf(it.id)<11}.employee_salary");
        System.out.println(empSalary);
        System.out.println("-----");

        List<Integer> maxSalary = new ArrayList<>();
        for (String salary: empSalary) {
            maxSalary.add(Integer.valueOf(salary));
        }
        System.out.println("-------");
        Collections.sort(maxSalary);
        System.out.println(maxSalary);
        softAssert.assertTrue(maxSalary.get(maxSalary.size()-1)==433060);

      //  jsonPath = pathlerden olusmus .eger ayrinti bilgi isttiyorsan kullaniliyor




    }
    /*
	 When
	 	 I send GET Request to http://dummy.restapiexample.com/api/v1/employees
	 Then
		 Status code is 200
		 1)Print all ids greater than 10 on the console
		   Assert that there are 14 ids greater than 10
		 2)Print all ages less than 30 on the console
		   Assert that maximum age is 23
		 3)Print all employee names whose salaries are greater than 350000
		   Assert that Charde Marshall is one of the employees whose salary is greater than 350,000
		 4)Print all employee salaries whose ids are less than 11
		   Assert that maximum salary is 433060
	 */

    @Test
    public void test4(){

        Response response = given().spec(spec01).when().get();

        JsonPath jsonPath = response.jsonPath();
        response.prettyPrint();

        List<String> empSalaries= jsonPath.getList("data.findAll{Integer.valueOf(it.id)<11}.employee_salary");


        System.out.println(empSalaries);

        List<Integer> maxSalaries = new ArrayList<>();
        for (String each:empSalaries) {
            maxSalaries.add(Integer.valueOf(each));

        }
        System.out.println("------");
        System.out.println(maxSalaries);

        int maxsalary = Collections.max(maxSalaries);
        System.out.println(maxsalary);

        Assert.assertTrue(maxsalary==433060);

        Assert.assertEquals(433060,maxsalary);

    }

    @Test
    public void api4(){

        Response response = given().
                auth().
                oauth2(ConfigReader.getProperty("token")).
                when().
                get(ConfigReader.getProperty("endpoint_state"));
//okuma
        response.prettyPrint();
//validate

       JsonPath json = response.jsonPath();
       List<String> expected = json.getList("ssn");
        System.out.println(expected);
        List<String> actual = json.getList("ssn");
        System.out.println(actual);

        //bir e bir check etme
        Assert.assertEquals(expected,actual);

        Assert.assertTrue(actual.contains(expected.get(3)));

        //tektek control etme
        for (int i = 0; i < expected.size(); i++) {

            System.out.println(expected.get(i));
            Assert.assertTrue(actual.contains(expected.get(i)));
        }

    }

    @Test
    public void deneme(){

        Response response = given().
                auth().
                oauth2(ConfigReader.getProperty("token")).
                when().
                get(ConfigReader.getProperty("endpoint_account"));

        response.prettyPrint();



    }


    }