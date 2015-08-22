$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("com\\qtpselenium\\facebook\\login\\login.feature");
formatter.feature({
  "id": "logging-in-facebook",
  "description": "In order to see my account\r\nAs a user\r\nI want to login",
  "name": "Logging in Facebook",
  "keyword": "Feature",
  "line": 1
});
formatter.scenario({
  "id": "logging-in-facebook;good-user",
  "description": "",
  "name": "Good user",
  "keyword": "Scenario",
  "line": 6,
  "type": "scenario"
});
formatter.step({
  "name": "I go to facebook on \"Mozilla\"",
  "keyword": "Given ",
  "line": 7
});
formatter.step({
  "name": "I enter \"username\" as \"its.thakur@gmail.com\"",
  "keyword": "And ",
  "line": 8
});
formatter.step({
  "name": "I enter \"password\" as \"whoareyou\"",
  "keyword": "And ",
  "line": 9
});
formatter.step({
  "name": "I click on \"LoginButton\"",
  "keyword": "And ",
  "line": 10
});
formatter.step({
  "name": "login should be \"success\"",
  "keyword": "Then ",
  "line": 11
});
formatter.match({
  "arguments": [
    {
      "val": "Mozilla",
      "offset": 21
    }
  ],
  "location": "LoginTest.gotoFacebook(String)"
});
formatter.result({
  "duration": 12259167186,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "username",
      "offset": 9
    },
    {
      "val": "its.thakur@gmail.com",
      "offset": 23
    }
  ],
  "location": "LoginTest.input(String,String)"
});
formatter.result({
  "duration": 336817405,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "password",
      "offset": 9
    },
    {
      "val": "whoareyou",
      "offset": 23
    }
  ],
  "location": "LoginTest.input(String,String)"
});
formatter.result({
  "duration": 48125567,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "LoginButton",
      "offset": 12
    }
  ],
  "location": "LoginTest.click(String)"
});
formatter.result({
  "duration": 15472867255,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "success",
      "offset": 17
    }
  ],
  "location": "LoginTest.verifyLogin(String)"
});
formatter.result({
  "duration": 303346561,
  "status": "passed"
});
formatter.uri("com\\qtpselenium\\facebook\\tester.feature");
formatter.feature({
  "id": "life-of-it-tester",
  "description": "\r\nIn order to get good salary\r\nAs a IT guy\r\nI want to keep my boss happy",
  "name": "Life of IT Tester",
  "keyword": "Feature",
  "line": 1
});
formatter.scenario({
  "id": "life-of-it-tester;i-am-a-tester;;2",
  "tags": [
    {
      "name": "@tester",
      "line": 7
    }
  ],
  "description": "",
  "name": "I am a tester",
  "keyword": "Scenario Outline",
  "line": 24,
  "type": "scenario"
});
formatter.step({
  "name": "I am a \"Good\" tester",
  "keyword": "Given ",
  "line": 10,
  "matchedColumns": [
    0
  ],
  "rows": [
    {
      "cells": [
        "industry",
        "country"
      ],
      "line": 11
    },
    {
      "cells": [
        "IT",
        "India"
      ],
      "line": 12
    },
    {
      "cells": [
        "Automobile",
        "Germany"
      ],
      "line": 13
    }
  ]
});
formatter.step({
  "name": "I go to work",
  "keyword": "When ",
  "line": 14
});
formatter.step({
  "name": "I \"Complete\" it",
  "keyword": "Then ",
  "line": 15,
  "matchedColumns": [
    1
  ]
});
formatter.step({
  "name": "My boss \"Salutes\" me",
  "keyword": "And ",
  "line": 16,
  "matchedColumns": [
    2
  ],
  "rows": [
    {
      "cells": [
        "country"
      ],
      "line": 17
    },
    {
      "cells": [
        "India"
      ],
      "line": 18
    },
    {
      "cells": [
        "Germany"
      ],
      "line": 19
    }
  ]
});
formatter.step({
  "name": "The developer \"hates\" me",
  "keyword": "But ",
  "line": 20,
  "matchedColumns": [
    3
  ]
});
formatter.match({
  "arguments": [
    {
      "val": "Good",
      "offset": 8
    }
  ],
  "location": "HolyTester.I_am_a_bad_tester(String,DataTable)"
});
formatter.result({
  "duration": 2351420,
  "status": "passed"
});
formatter.match({
  "location": "HolyTester.I_go_to_work()"
});
formatter.result({
  "duration": 79861,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Complete",
      "offset": 3
    }
  ],
  "location": "HolyTester.I_mess_with_it(String)"
});
formatter.result({
  "duration": 121755,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Salutes",
      "offset": 9
    }
  ],
  "location": "HolyTester.My_boss_fires_me(String,DataTable)"
});
formatter.result({
  "duration": 312821,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "hates",
      "offset": 15
    }
  ],
  "location": "HolyTester.The_developer_likes_me(String)"
});
formatter.result({
  "duration": 129442,
  "status": "passed"
});
formatter.scenario({
  "id": "life-of-it-tester;i-am-a-tester;;3",
  "tags": [
    {
      "name": "@tester",
      "line": 7
    }
  ],
  "description": "",
  "name": "I am a tester",
  "keyword": "Scenario Outline",
  "line": 25,
  "type": "scenario"
});
formatter.step({
  "name": "I am a \"Bad\" tester",
  "keyword": "Given ",
  "line": 10,
  "matchedColumns": [
    0
  ],
  "rows": [
    {
      "cells": [
        "industry",
        "country"
      ],
      "line": 11
    },
    {
      "cells": [
        "IT",
        "India"
      ],
      "line": 12
    },
    {
      "cells": [
        "Automobile",
        "Germany"
      ],
      "line": 13
    }
  ]
});
formatter.step({
  "name": "I go to work",
  "keyword": "When ",
  "line": 14
});
formatter.step({
  "name": "I \"Mess\" it",
  "keyword": "Then ",
  "line": 15,
  "matchedColumns": [
    1
  ]
});
formatter.step({
  "name": "My boss \"Fires\" me",
  "keyword": "And ",
  "line": 16,
  "matchedColumns": [
    2
  ],
  "rows": [
    {
      "cells": [
        "country"
      ],
      "line": 17
    },
    {
      "cells": [
        "India"
      ],
      "line": 18
    },
    {
      "cells": [
        "Germany"
      ],
      "line": 19
    }
  ]
});
formatter.step({
  "name": "The developer \"Likes\" me",
  "keyword": "But ",
  "line": 20,
  "matchedColumns": [
    3
  ]
});
formatter.match({
  "arguments": [
    {
      "val": "Bad",
      "offset": 8
    }
  ],
  "location": "HolyTester.I_am_a_bad_tester(String,DataTable)"
});
formatter.result({
  "duration": 389729,
  "status": "passed"
});
formatter.match({
  "location": "HolyTester.I_go_to_work()"
});
formatter.result({
  "duration": 54791,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Mess",
      "offset": 3
    }
  ],
  "location": "HolyTester.I_mess_with_it(String)"
});
formatter.result({
  "duration": 82157,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Fires",
      "offset": 9
    }
  ],
  "location": "HolyTester.My_boss_fires_me(String,DataTable)"
});
formatter.result({
  "duration": 218678,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Likes",
      "offset": 15
    }
  ],
  "location": "HolyTester.The_developer_likes_me(String)"
});
formatter.result({
  "duration": 79141,
  "status": "passed"
});
formatter.scenario({
  "id": "life-of-it-tester;i-am-a-tester;;4",
  "tags": [
    {
      "name": "@tester",
      "line": 7
    }
  ],
  "description": "",
  "name": "I am a tester",
  "keyword": "Scenario Outline",
  "line": 26,
  "type": "scenario"
});
formatter.step({
  "name": "I am a \"avg\" tester",
  "keyword": "Given ",
  "line": 10,
  "matchedColumns": [
    0
  ],
  "rows": [
    {
      "cells": [
        "industry",
        "country"
      ],
      "line": 11
    },
    {
      "cells": [
        "IT",
        "India"
      ],
      "line": 12
    },
    {
      "cells": [
        "Automobile",
        "Germany"
      ],
      "line": 13
    }
  ]
});
formatter.step({
  "name": "I go to work",
  "keyword": "When ",
  "line": 14
});
formatter.step({
  "name": "I \"sufficient\" it",
  "keyword": "Then ",
  "line": 15,
  "matchedColumns": [
    1
  ]
});
formatter.step({
  "name": "My boss \"congrats\" me",
  "keyword": "And ",
  "line": 16,
  "matchedColumns": [
    2
  ],
  "rows": [
    {
      "cells": [
        "country"
      ],
      "line": 17
    },
    {
      "cells": [
        "India"
      ],
      "line": 18
    },
    {
      "cells": [
        "Germany"
      ],
      "line": 19
    }
  ]
});
formatter.step({
  "name": "The developer \"respects\" me",
  "keyword": "But ",
  "line": 20,
  "matchedColumns": [
    3
  ]
});
formatter.match({
  "arguments": [
    {
      "val": "avg",
      "offset": 8
    }
  ],
  "location": "HolyTester.I_am_a_bad_tester(String,DataTable)"
});
formatter.result({
  "duration": 384617,
  "status": "passed"
});
formatter.match({
  "location": "HolyTester.I_go_to_work()"
});
formatter.result({
  "duration": 73420,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sufficient",
      "offset": 3
    }
  ],
  "location": "HolyTester.I_mess_with_it(String)"
});
formatter.result({
  "duration": 93764,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "congrats",
      "offset": 9
    }
  ],
  "location": "HolyTester.My_boss_fires_me(String,DataTable)"
});
formatter.result({
  "duration": 186475,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "respects",
      "offset": 15
    }
  ],
  "location": "HolyTester.The_developer_likes_me(String)"
});
formatter.result({
  "duration": 76811,
  "status": "passed"
});
});