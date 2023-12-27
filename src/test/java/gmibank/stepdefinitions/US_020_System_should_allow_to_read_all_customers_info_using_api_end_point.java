package gmibank.stepdefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import gmibank.pojos.Customer;
import gmibank.utilities.ConfigReader;
import gmibank.utilities.Readtext;
import gmibank.utilities.WriteToTxt;
import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

public class US_020_System_should_allow_to_read_all_customers_info_using_api_end_point {

    Response response;

    Customer[] customers;
    @Given("user provides the api end point to set response using {string}")
    public void user_provides_the_api_end_point_to_set_response_using(String url) {


        response = given().headers("Authorization",
                "Bearer " + ConfigReader.getProperty("token"),
                "Content-Type",
                ContentType.JSON,
                "Accept",
               ContentType.JSON).
                 when().
                 get(url).
                 then().
                 contentType(ContentType.JSON).
                 extract().
                 response();

//        response = given().auth().
//                oauth2(ConfigReader.getProperty("api_bearer_token")).
//                contentType(ContentType.JSON).
//                when().
//                get(url).
//                then().
//                contentType(ContentType.JSON).
//                statusCode(200).
//                extract().
//                response();

    //    response.prettyPrint();
    }

      List<String> allSsn = new ArrayList<>();
    @Given("user is desirlializing all data to Java")
    public void user_is_desirlializing_all_data_to_Java() throws IOException {

//        JsonPath jsonPath = response.jsonPath();
//        jsonPath.get
        //jacksondan olustur 2. secenek
        ObjectMapper objectMapper = new ObjectMapper();

//responsen icindeki butun bilgileri Array olarak customerin icine attik
        customers = objectMapper.readValue(response.asString(), Customer[].class);
        // System.out.println(customers[0].getUser().getId());
       // System.out.println ("--------------------------");

        for (int i = 0; i < customers.length; i++) {
         //   allSsn.add(customers[i].getSsn());

            if (customers[i].getSsn() != null) {
                allSsn.add(customers[i].getSsn());
             //   System.out.println(customers[i].getSsn());
              //  System.out.println("--------------------------");
//            }
              //  System.out.println("--------------------------");
                //    System.out.println("all user"+ customers[i].getUser());
            }
            //System.out.println(allSsn);
           // System.out.println("--------------------------");
        }
        System.out.println(allSsn);

        //ssn texte kaydetme
        WriteToTxt.saveAllSsn("src/test/java/gmibank/test_data/CustomerInfo.txt",customers);
        // verify etmek
        List<String> allSSNs= Readtext.returnAllCustomersSsn("src/test/java/gmibank/test_data/CustomerInfo.txt");
       //neyi asset ediyorsun? yazdigimizi ve okudugumzu
        Assert.assertEquals("not verift", allSSNs,allSsn);




    }



    @Given("use set all CUstomer information to related files")
    public void use_set_all_CUstomer_information_to_related_files() {

        //texte yazdirma
     //   WriteToTxt.saveAllData("src/test/java/gmibank/test_data/CustomerInfo.txt",customers);
//bu sekilde baska file olusur
        //        WriteToTxt.saveAllData("src/test/java/gmibank/test_data/CustomerInfo2.txt",customers);
//        WriteToTxt.saveAllData("src/test/java/gmibank/test_data/CustomerInfo3.txt",customers);


    }

    //bunun anlamai=Datalarin olup olmadigini ogreniyoruz=butun data
    //toplu olarak assert yap demenk asaginin dogru oldunu bilmiyorum
    @Given("validate them from data set")
    public void validate_them_from_data_set() {
        List<String> expectedSSNs = new ArrayList<>();
        expectedSSNs.add("458-62-6584");
        expectedSSNs.add("450-56-4994");
        expectedSSNs.add("612-15-5726");
        expectedSSNs.add("186-48-4946");
        expectedSSNs.add("439-12-4312");
        expectedSSNs.add("234-55-8998");
        expectedSSNs.add("108-53-6655");
        expectedSSNs.add("821-84-3971");
        expectedSSNs.add("355-88-2318");
        expectedSSNs.add("244-56-7748");
        expectedSSNs.add("123-12-1234");
        expectedSSNs.add("473-22-1798");
        expectedSSNs.add("511-18-8543");
        expectedSSNs.add("224-71-4004");
        expectedSSNs.add("194-21-8830");
        expectedSSNs.add("498-53-5576");
        expectedSSNs.add("234-11-8998");
        expectedSSNs.add("777-23-7777");




//read den okutup verify etmek

       List<String> allSSNs= Readtext.returnAllCustomersSsn("src/test/java/gmibank/test_data/CustomerInfo.txt");

        //Assert.assertTrue("All do not match", allSSNs.containsAll(expectedSSNs));

        System.out.println("All data validation has been successful");


    }
// bunun anlami birkactanesinin olup oldugunu
    //tek tek assert et demek mis
    @Given("validate them one by one")
    public void validate_them_one_by_one() {

        List<String> expectedSSNs2 = new ArrayList<>();
        expectedSSNs2.add("458-62-6584");
        expectedSSNs2.add("612-15-5726");
        expectedSSNs2.add("450-56-4994");
        expectedSSNs2.add("186-48-4946");
        expectedSSNs2.add("439-12-4312");
        expectedSSNs2.add("234-55-8998");
        expectedSSNs2.add("511-18-8543");
        expectedSSNs2.add("333-34-2395");
        expectedSSNs2.add("473-22-1798");
        expectedSSNs2.add("123-12-1234");
        expectedSSNs2.add("244-56-7748");
        expectedSSNs2.add("355-88-2318");
        expectedSSNs2.add("821-84-3971");
        expectedSSNs2.add("108-53-6655");
        expectedSSNs2.add("224-71-4004");
        expectedSSNs2.add("194-21-8830");
        expectedSSNs2.add("498-53-5576");
        expectedSSNs2.add("234-22-8998");
        expectedSSNs2.add("234-11-8998");
        expectedSSNs2.add("777-23-7777");




        for (int i = 0; i < customers.length; i++) {
            if (customers[i].getSsn()!=null){
                Assert.assertTrue(customers[i].getSsn().contains(expectedSSNs2.get(i)));
            }
        }




    }





}
