$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/US_020_System%20should%20allow%20to%20read%20all%20customers%20info%20using%20api%20end%20point%20.feature");
formatter.feature({
  "name": "Read all customer data",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@registrationpage"
    }
  ]
});
formatter.background({
  "name": "Api end point being set in response",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user provides the api end point to set response using \"https://www.gmibank.com/api/tp-customers\"",
  "keyword": "Given "
});
formatter.match({
  "location": "gmibank.stepdefinitions.US_020_System_should_allow_to_read_all_customers_info_using_api_end_point.user_provides_the_api_end_point_to_set_response_using(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "read all data coming as JSON with api",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@registrationpage"
    }
  ]
});
formatter.step({
  "name": "user is desirlializing all data to Java",
  "keyword": "Given "
});
formatter.match({
  "location": "gmibank.stepdefinitions.US_020_System_should_allow_to_read_all_customers_info_using_api_end_point.user_is_desirlializing_all_data_to_Java()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "validate them from data set",
  "keyword": "And "
});
formatter.match({
  "location": "gmibank.stepdefinitions.US_020_System_should_allow_to_read_all_customers_info_using_api_end_point.validate_them_from_data_set()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "Api end point being set in response",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user provides the api end point to set response using \"https://www.gmibank.com/api/tp-customers\"",
  "keyword": "Given "
});
formatter.match({
  "location": "gmibank.stepdefinitions.US_020_System_should_allow_to_read_all_customers_info_using_api_end_point.user_provides_the_api_end_point_to_set_response_using(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "read all data coming as JSON with api",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@registrationpage"
    }
  ]
});
formatter.step({
  "name": "user is desirlializing all data to Java",
  "keyword": "Given "
});
formatter.match({
  "location": "gmibank.stepdefinitions.US_020_System_should_allow_to_read_all_customers_info_using_api_end_point.user_is_desirlializing_all_data_to_Java()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "validate them one by one",
  "keyword": "And "
});
formatter.match({
  "location": "gmibank.stepdefinitions.US_020_System_should_allow_to_read_all_customers_info_using_api_end_point.validate_them_one_by_one()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});