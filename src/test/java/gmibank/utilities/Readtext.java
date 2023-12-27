package gmibank.utilities;

import gmibank.pojos.Countries;
import gmibank.pojos.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Readtext {
    public static List<String> returnAllCustomersSsn(String filePath)  {

        List<String> allSSNIds =new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line =reader.readLine();
        //    System.out.println(line);

           int i =0;
           while (line !=null){
               String temp = "";
               temp= line.split(",")[0].trim();

               sb.append(System.lineSeparator())    ;
               line=reader.readLine();

               System.out.println(i++);

               allSSNIds.add(temp);
           }




        } catch (IOException e) {
            e.printStackTrace();
        }
        return allSSNIds;

    }

    public static List<Customer>  returnAllCountries(String filePath)  {

        List<Customer> allSSNCountry =new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line =reader.readLine();
            //    System.out.println(line);

            int i =0;
            while (line !=null){
                Customer customer = new Customer();
             //   String temp = "";
            //    temp= line.split(",")[0].trim();
                sb.append(line);
                sb.append(System.lineSeparator())    ;
                line=reader.readLine();
                String [] each = line.split(",");
                customer.setFirstName(each[0]);
                customer.setLastName(each[1]);
                allSSNCountry.add(customer);


                System.out.println(i++);

              //  allSSNCountry.add(temp);
            }

            String everthing = sb.toString();


        } catch (IOException e) {
            e.printStackTrace();
        }
        return allSSNCountry;

    }

}
