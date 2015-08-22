$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("main\\resources\\com\\qtpselenium\\app\\salesforce\\login\\login.feature");
formatter.feature({
  "id": "logging-into-salesforce",
  "description": "\r\nIn order to work \r\nAs a sales person\r\nI want to login",
  "name": "Logging into Salesforce",
  "keyword": "Feature",
  "line": 1
});
formatter.scenarioOutline({
  "id": "logging-into-salesforce;logging-in-salesforce",
  "tags": [
    {
      "name": "@login",
      "line": 7
    }
  ],
  "description": "",
  "name": "Logging in salesforce",
  "keyword": "Scenario Outline",
  "line": 8,
  "type": "scenario_outline"
});
formatter.step({
  "name": "Runmode is \"\u003cRunmode\u003e\"",
  "keyword": "Given ",
  "line": 9
});
formatter.step({
  "name": "I go to \"loginURL\" on \"\u003cBrowser\u003e\"",
  "keyword": "Given ",
  "line": 10
});
formatter.step({
  "name": "I enter \"loginusername\" as \"\u003cUsername\u003e\"",
  "keyword": "And ",
  "line": 11
});
formatter.step({
  "name": "I enter \"loginpassword\" as \"\u003cPassword\u003e\"",
  "keyword": "And ",
  "line": 12
});
formatter.step({
  "name": "I click on \"loginButton\"",
  "keyword": "And ",
  "line": 13
});
formatter.step({
  "name": "Login should be \"\u003cExpected_Result\u003e\"",
  "keyword": "Then ",
  "line": 14
});
formatter.examples({
  "id": "logging-into-salesforce;logging-in-salesforce;",
  "description": "",
  "name": "",
  "keyword": "Examples",
  "line": 16,
  "rows": [
    {
      "id": "logging-into-salesforce;logging-in-salesforce;;1",
      "cells": [
        "Runmode",
        "Browser",
        "Username",
        "Password",
        "Expected_Result"
      ],
      "line": 17
    },
    {
      "id": "logging-into-salesforce;logging-in-salesforce;;2",
      "cells": [
        "N",
        "Mozilla",
        "xxxxx",
        "zxxxx",
        "failure"
      ],
      "line": 18
    },
    {
      "id": "logging-into-salesforce;logging-in-salesforce;;3",
      "cells": [
        "N",
        "Mozilla",
        "loadrunner.jmeter@gmail.com",
        "pass@1234",
        "success"
      ],
      "line": 19
    },
    {
      "id": "logging-into-salesforce;logging-in-salesforce;;4",
      "cells": [
        "N",
        "Chrome",
        "xxxxx",
        "zxxxx",
        "failure"
      ],
      "line": 20
    },
    {
      "id": "logging-into-salesforce;logging-in-salesforce;;5",
      "cells": [
        "N",
        "Chrome",
        "loadrunner.jmeter@gmail.com",
        "pass@1234",
        "success"
      ],
      "line": 21
    }
  ]
});
formatter.scenario({
  "id": "logging-into-salesforce;logging-in-salesforce;;2",
  "tags": [
    {
      "name": "@login",
      "line": 7
    }
  ],
  "description": "",
  "name": "Logging in salesforce",
  "keyword": "Scenario Outline",
  "line": 18,
  "type": "scenario"
});
formatter.step({
  "name": "Runmode is \"N\"",
  "keyword": "Given ",
  "line": 9,
  "matchedColumns": [
    0
  ]
});
formatter.step({
  "name": "I go to \"loginURL\" on \"Mozilla\"",
  "keyword": "Given ",
  "line": 10,
  "matchedColumns": [
    1
  ]
});
formatter.step({
  "name": "I enter \"loginusername\" as \"xxxxx\"",
  "keyword": "And ",
  "line": 11,
  "matchedColumns": [
    2
  ]
});
formatter.step({
  "name": "I enter \"loginpassword\" as \"zxxxx\"",
  "keyword": "And ",
  "line": 12,
  "matchedColumns": [
    3
  ]
});
formatter.step({
  "name": "I click on \"loginButton\"",
  "keyword": "And ",
  "line": 13
});
formatter.step({
  "name": "Login should be \"failure\"",
  "keyword": "Then ",
  "line": 14,
  "matchedColumns": [
    4
  ]
});
formatter.match({
  "arguments": [
    {
      "val": "N",
      "offset": 12
    }
  ],
  "location": "CommonUtil.Runmode_is(String)"
});
formatter.result({
  "duration": 149834899,
  "status": "pending",
  "error_message": "cucumber.api.PendingException: Skipping the test as Runmode is No\r\n\tat com.qtpselenium.app.salesforce.testcases.CommonUtil.Runmode_is(CommonUtil.java:38)\r\n\tat ✽.Given Runmode is \"N\"(main\\resources\\com\\qtpselenium\\app\\salesforce\\login\\login.feature:9)\r\n"
});
formatter.match({
  "arguments": [
    {
      "val": "loginURL",
      "offset": 9
    },
    {
      "val": "Mozilla",
      "offset": 23
    }
  ],
  "location": "LoginTest.I_Go_To_Salesforce(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "loginusername",
      "offset": 9
    },
    {
      "val": "xxxxx",
      "offset": 28
    }
  ],
  "location": "CommonUtil.I_enter(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "loginpassword",
      "offset": 9
    },
    {
      "val": "zxxxx",
      "offset": 28
    }
  ],
  "location": "CommonUtil.I_enter(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "loginButton",
      "offset": 12
    }
  ],
  "location": "CommonUtil.I_Click_On(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "failure",
      "offset": 17
    }
  ],
  "location": "LoginTest.Then_login_should_be(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "id": "logging-into-salesforce;logging-in-salesforce;;3",
  "tags": [
    {
      "name": "@login",
      "line": 7
    }
  ],
  "description": "",
  "name": "Logging in salesforce",
  "keyword": "Scenario Outline",
  "line": 19,
  "type": "scenario"
});
formatter.step({
  "name": "Runmode is \"N\"",
  "keyword": "Given ",
  "line": 9,
  "matchedColumns": [
    0
  ]
});
formatter.step({
  "name": "I go to \"loginURL\" on \"Mozilla\"",
  "keyword": "Given ",
  "line": 10,
  "matchedColumns": [
    1
  ]
});
formatter.step({
  "name": "I enter \"loginusername\" as \"loadrunner.jmeter@gmail.com\"",
  "keyword": "And ",
  "line": 11,
  "matchedColumns": [
    2
  ]
});
formatter.step({
  "name": "I enter \"loginpassword\" as \"pass@1234\"",
  "keyword": "And ",
  "line": 12,
  "matchedColumns": [
    3
  ]
});
formatter.step({
  "name": "I click on \"loginButton\"",
  "keyword": "And ",
  "line": 13
});
formatter.step({
  "name": "Login should be \"success\"",
  "keyword": "Then ",
  "line": 14,
  "matchedColumns": [
    4
  ]
});
formatter.match({
  "arguments": [
    {
      "val": "N",
      "offset": 12
    }
  ],
  "location": "CommonUtil.Runmode_is(String)"
});
formatter.result({
  "duration": 195372,
  "status": "pending",
  "error_message": "cucumber.api.PendingException: Skipping the test as Runmode is No\r\n\tat com.qtpselenium.app.salesforce.testcases.CommonUtil.Runmode_is(CommonUtil.java:38)\r\n\tat ✽.Given Runmode is \"N\"(main\\resources\\com\\qtpselenium\\app\\salesforce\\login\\login.feature:9)\r\n"
});
formatter.match({
  "arguments": [
    {
      "val": "loginURL",
      "offset": 9
    },
    {
      "val": "Mozilla",
      "offset": 23
    }
  ],
  "location": "LoginTest.I_Go_To_Salesforce(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "loginusername",
      "offset": 9
    },
    {
      "val": "loadrunner.jmeter@gmail.com",
      "offset": 28
    }
  ],
  "location": "CommonUtil.I_enter(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "loginpassword",
      "offset": 9
    },
    {
      "val": "pass@1234",
      "offset": 28
    }
  ],
  "location": "CommonUtil.I_enter(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "loginButton",
      "offset": 12
    }
  ],
  "location": "CommonUtil.I_Click_On(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "success",
      "offset": 17
    }
  ],
  "location": "LoginTest.Then_login_should_be(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "id": "logging-into-salesforce;logging-in-salesforce;;4",
  "tags": [
    {
      "name": "@login",
      "line": 7
    }
  ],
  "description": "",
  "name": "Logging in salesforce",
  "keyword": "Scenario Outline",
  "line": 20,
  "type": "scenario"
});
formatter.step({
  "name": "Runmode is \"N\"",
  "keyword": "Given ",
  "line": 9,
  "matchedColumns": [
    0
  ]
});
formatter.step({
  "name": "I go to \"loginURL\" on \"Chrome\"",
  "keyword": "Given ",
  "line": 10,
  "matchedColumns": [
    1
  ]
});
formatter.step({
  "name": "I enter \"loginusername\" as \"xxxxx\"",
  "keyword": "And ",
  "line": 11,
  "matchedColumns": [
    2
  ]
});
formatter.step({
  "name": "I enter \"loginpassword\" as \"zxxxx\"",
  "keyword": "And ",
  "line": 12,
  "matchedColumns": [
    3
  ]
});
formatter.step({
  "name": "I click on \"loginButton\"",
  "keyword": "And ",
  "line": 13
});
formatter.step({
  "name": "Login should be \"failure\"",
  "keyword": "Then ",
  "line": 14,
  "matchedColumns": [
    4
  ]
});
formatter.match({
  "arguments": [
    {
      "val": "N",
      "offset": 12
    }
  ],
  "location": "CommonUtil.Runmode_is(String)"
});
formatter.result({
  "duration": 172572,
  "status": "pending",
  "error_message": "cucumber.api.PendingException: Skipping the test as Runmode is No\r\n\tat com.qtpselenium.app.salesforce.testcases.CommonUtil.Runmode_is(CommonUtil.java:38)\r\n\tat ✽.Given Runmode is \"N\"(main\\resources\\com\\qtpselenium\\app\\salesforce\\login\\login.feature:9)\r\n"
});
formatter.match({
  "arguments": [
    {
      "val": "loginURL",
      "offset": 9
    },
    {
      "val": "Chrome",
      "offset": 23
    }
  ],
  "location": "LoginTest.I_Go_To_Salesforce(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "loginusername",
      "offset": 9
    },
    {
      "val": "xxxxx",
      "offset": 28
    }
  ],
  "location": "CommonUtil.I_enter(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "loginpassword",
      "offset": 9
    },
    {
      "val": "zxxxx",
      "offset": 28
    }
  ],
  "location": "CommonUtil.I_enter(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "loginButton",
      "offset": 12
    }
  ],
  "location": "CommonUtil.I_Click_On(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "failure",
      "offset": 17
    }
  ],
  "location": "LoginTest.Then_login_should_be(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "id": "logging-into-salesforce;logging-in-salesforce;;5",
  "tags": [
    {
      "name": "@login",
      "line": 7
    }
  ],
  "description": "",
  "name": "Logging in salesforce",
  "keyword": "Scenario Outline",
  "line": 21,
  "type": "scenario"
});
formatter.step({
  "name": "Runmode is \"N\"",
  "keyword": "Given ",
  "line": 9,
  "matchedColumns": [
    0
  ]
});
formatter.step({
  "name": "I go to \"loginURL\" on \"Chrome\"",
  "keyword": "Given ",
  "line": 10,
  "matchedColumns": [
    1
  ]
});
formatter.step({
  "name": "I enter \"loginusername\" as \"loadrunner.jmeter@gmail.com\"",
  "keyword": "And ",
  "line": 11,
  "matchedColumns": [
    2
  ]
});
formatter.step({
  "name": "I enter \"loginpassword\" as \"pass@1234\"",
  "keyword": "And ",
  "line": 12,
  "matchedColumns": [
    3
  ]
});
formatter.step({
  "name": "I click on \"loginButton\"",
  "keyword": "And ",
  "line": 13
});
formatter.step({
  "name": "Login should be \"success\"",
  "keyword": "Then ",
  "line": 14,
  "matchedColumns": [
    4
  ]
});
formatter.match({
  "arguments": [
    {
      "val": "N",
      "offset": 12
    }
  ],
  "location": "CommonUtil.Runmode_is(String)"
});
formatter.result({
  "duration": 170416,
  "status": "pending",
  "error_message": "cucumber.api.PendingException: Skipping the test as Runmode is No\r\n\tat com.qtpselenium.app.salesforce.testcases.CommonUtil.Runmode_is(CommonUtil.java:38)\r\n\tat ✽.Given Runmode is \"N\"(main\\resources\\com\\qtpselenium\\app\\salesforce\\login\\login.feature:9)\r\n"
});
formatter.match({
  "arguments": [
    {
      "val": "loginURL",
      "offset": 9
    },
    {
      "val": "Chrome",
      "offset": 23
    }
  ],
  "location": "LoginTest.I_Go_To_Salesforce(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "loginusername",
      "offset": 9
    },
    {
      "val": "loadrunner.jmeter@gmail.com",
      "offset": 28
    }
  ],
  "location": "CommonUtil.I_enter(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "loginpassword",
      "offset": 9
    },
    {
      "val": "pass@1234",
      "offset": 28
    }
  ],
  "location": "CommonUtil.I_enter(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "loginButton",
      "offset": 12
    }
  ],
  "location": "CommonUtil.I_Click_On(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "success",
      "offset": 17
    }
  ],
  "location": "LoginTest.Then_login_should_be(String)"
});
formatter.result({
  "status": "skipped"
});
});