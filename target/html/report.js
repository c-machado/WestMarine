$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("register.feature");
formatter.feature({
  "line": 2,
  "name": "As a user I want to register in the WestMarine page so I can manage my billing data",
  "description": "",
  "id": "as-a-user-i-want-to-register-in-the-westmarine-page-so-i-can-manage-my-billing-data",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@test"
    }
  ]
});
formatter.scenario({
  "line": 4,
  "name": "Successful register",
  "description": "",
  "id": "as-a-user-i-want-to-register-in-the-westmarine-page-so-i-can-manage-my-billing-data;successful-register",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I\u0027m in WestMarine Homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I click to sign in",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I have to choose create option",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I fill out the form with correct information",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I click on the Register button",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I\u0027m succesfully registered",
  "keyword": "Then "
});
formatter.match({
  "location": "Register.iMInWestMarineHomepage()"
});
formatter.result({
  "duration": 10931633978,
  "status": "passed"
});
formatter.match({
  "location": "Register.iClickToSignIn()"
});
formatter.result({
  "duration": 297693838,
  "status": "passed"
});
formatter.match({
  "location": "Register.iHaveToChooseCreateOption()"
});
formatter.result({
  "duration": 3514037122,
  "status": "passed"
});
formatter.match({
  "location": "Register.iFillOutTheFormWithCorrectInformation()"
});
formatter.result({
  "duration": 1553232741,
  "status": "passed"
});
formatter.match({
  "location": "Register.iClickOnTheRegisterButton()"
});
formatter.result({
  "duration": 1978782722,
  "status": "passed"
});
formatter.match({
  "location": "Register.iMSuccesfullyRegistered()"
});
formatter.result({
  "duration": 38521564,
  "status": "passed"
});
});