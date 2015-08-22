$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("\u0027qtpselenium\\facebook\\login\\login.feature\u0027");
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
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.uri("\u0027qtpselenium\\facebook\\tester.feature\u0027");
formatter.feature({
  "id": "life-of-it-tester",
  "description": "\r\nIn order to get good salary\r\nAs a IT guy\r\nI want to keep my boss happy",
  "name": "Life of IT Tester",
  "keyword": "Feature",
  "line": 1
});
formatter.scenarioOutline({
  "id": "life-of-it-tester;i-am-a-tester",
  "tags": [
    {
      "name": "@tester",
      "line": 7
    }
  ],
  "description": "",
  "name": "I am a tester",
  "keyword": "Scenario Outline",
  "line": 8,
  "type": "scenario_outline"
});
formatter.step({
  "name": "I am a \"\u003cTesterType\u003e\" tester",
  "keyword": "Given ",
  "line": 10,
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
  "name": "I \"\u003cWork_Output\u003e\" it",
  "keyword": "Then ",
  "line": 15
});
formatter.step({
  "name": "My boss \"\u003cBoss_Action\u003e\" me",
  "keyword": "And ",
  "line": 16,
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
  "name": "The developer \"\u003cDeveloper_Reaction\u003e\" me",
  "keyword": "But ",
  "line": 20
});
formatter.examples({
  "id": "life-of-it-tester;i-am-a-tester;",
  "description": "",
  "name": "",
  "keyword": "Examples",
  "line": 22,
  "rows": [
    {
      "id": "life-of-it-tester;i-am-a-tester;;1",
      "cells": [
        "TesterType",
        "Work_Output",
        "Boss_Action",
        "Developer_Reaction"
      ],
      "line": 23
    },
    {
      "id": "life-of-it-tester;i-am-a-tester;;2",
      "cells": [
        "Good",
        "Complete",
        "Salutes",
        "hates"
      ],
      "line": 24
    },
    {
      "id": "life-of-it-tester;i-am-a-tester;;3",
      "cells": [
        "Bad",
        "Mess",
        "Fires",
        "Likes"
      ],
      "line": 25
    },
    {
      "id": "life-of-it-tester;i-am-a-tester;;4",
      "cells": [
        "avg",
        "sufficient",
        "congrats",
        "respects"
      ],
      "line": 26
    }
  ]
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
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
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
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
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
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});