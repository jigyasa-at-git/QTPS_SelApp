$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("\u0027com\\salesforce\\login\\resource\\login.feature\u0027");
formatter.feature({
  "id": "life-of-it-developer",
  "description": "\r\nIn order to get good salary\r\nAs a IT guy\r\nI want to keep my boss happy",
  "name": "Life of IT Developer",
  "keyword": "Feature",
  "line": 1
});
formatter.scenario({
  "id": "life-of-it-developer;i-am-a-java-developer",
  "tags": [
    {
      "name": "@javaDev",
      "line": 7
    }
  ],
  "description": "",
  "name": "I am a java developer",
  "keyword": "Scenario",
  "line": 8,
  "type": "scenario"
});
formatter.step({
  "name": "I open \"Mozilla\"",
  "keyword": "Given ",
  "line": 10
});
formatter.step({
  "name": "I navigate to \"salesforcehomepage\"",
  "keyword": "And ",
  "line": 11
});
formatter.step({
  "name": "I click on \"loginLink\"",
  "keyword": "And ",
  "line": 12
});
formatter.step({
  "name": "I enter \"username\" as \"testuser\"",
  "keyword": "And ",
  "line": 13
});
formatter.step({
  "name": "I enter \"password\" as \"testpass\"",
  "keyword": "And ",
  "line": 14
});
formatter.step({
  "name": "I click on \"loginButton\"",
  "keyword": "And ",
  "line": 15
});
formatter.match({
  "arguments": [
    {
      "val": "Mozilla",
      "offset": 8
    }
  ],
  "location": "Login.openBrowserandNavigate(String)"
});
formatter.result({
  "duration": 7880323142,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "salesforcehomepage",
      "offset": 15
    }
  ],
  "location": "Login.navigate(String)"
});
formatter.result({
  "duration": 5912488092,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "loginLink",
      "offset": 12
    }
  ],
  "location": "Login.click(String)"
});
formatter.result({
  "duration": 136250323,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "username",
      "offset": 9
    },
    {
      "val": "testuser",
      "offset": 23
    }
  ],
  "location": "Login.input(String,String)"
});
formatter.result({
  "duration": 3579184756,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "password",
      "offset": 9
    },
    {
      "val": "testpass",
      "offset": 23
    }
  ],
  "location": "Login.input(String,String)"
});
formatter.result({
  "duration": 42049159,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "loginButton",
      "offset": 12
    }
  ],
  "location": "Login.click(String)"
});
formatter.result({
  "duration": 68479474,
  "status": "passed"
});
});