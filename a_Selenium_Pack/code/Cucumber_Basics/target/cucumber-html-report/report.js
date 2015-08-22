$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("\u0027developer.feature\u0027");
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
  "name": "I work in microsoft",
  "keyword": "Given ",
  "line": 10
});
formatter.step({
  "name": "I meet Bill Gates",
  "keyword": "When ",
  "line": 11
});
formatter.step({
  "name": "I hesitate",
  "keyword": "Then ",
  "line": 12
});
formatter.step({
  "name": "he is a good person",
  "keyword": "But ",
  "line": 13
});
formatter.match({
  "arguments": [
    {
      "val": "microsoft",
      "offset": 10
    }
  ],
  "location": "HolyDeveloper.I_am(String)"
});
formatter.result({
  "duration": 174875875,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Bill Gates",
      "offset": 7
    }
  ],
  "location": "HolyDeveloper.I_meet(String)"
});
formatter.result({
  "duration": 162415,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "hesitate",
      "offset": 2
    }
  ],
  "location": "HolyDeveloper.I_(String)"
});
formatter.result({
  "duration": 115951,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "good",
      "offset": 8
    }
  ],
  "location": "HolyDeveloper.He_is_a(String)"
});
formatter.result({
  "duration": 177081,
  "status": "passed"
});
formatter.scenario({
  "id": "life-of-it-developer;i-am-a-linux-developer",
  "tags": [
    {
      "name": "@linuxDev",
      "line": 15
    }
  ],
  "description": "",
  "name": "I am a linux developer",
  "keyword": "Scenario",
  "line": 16,
  "type": "scenario"
});
formatter.step({
  "name": "I work in Apple",
  "keyword": "Given ",
  "line": 18
});
formatter.step({
  "name": "I meet Steve Jobs",
  "keyword": "When ",
  "line": 19
});
formatter.step({
  "name": "I scream",
  "keyword": "Then ",
  "line": 20
});
formatter.step({
  "name": "he is a wise person",
  "keyword": "But ",
  "line": 21
});
formatter.match({
  "arguments": [
    {
      "val": "Apple",
      "offset": 10
    }
  ],
  "location": "HolyDeveloper.I_am(String)"
});
formatter.result({
  "duration": 193735,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Steve Jobs",
      "offset": 7
    }
  ],
  "location": "HolyDeveloper.I_meet(String)"
});
formatter.result({
  "duration": 129189,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "scream",
      "offset": 2
    }
  ],
  "location": "HolyDeveloper.I_(String)"
});
formatter.result({
  "duration": 86155,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "wise",
      "offset": 8
    }
  ],
  "location": "HolyDeveloper.He_is_a(String)"
});
formatter.result({
  "duration": 116050,
  "status": "passed"
});
formatter.uri("\u0027tester.feature\u0027");
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
  "duration": 1481110,
  "status": "passed"
});
formatter.match({
  "location": "HolyTester.I_go_to_work()"
});
formatter.result({
  "duration": 57521,
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
  "duration": 113181,
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
  "duration": 258796,
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
  "duration": 134618,
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
  "duration": 324194,
  "status": "passed"
});
formatter.match({
  "location": "HolyTester.I_go_to_work()"
});
formatter.result({
  "duration": 52219,
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
  "duration": 239071,
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
  "duration": 271552,
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
  "duration": 190809,
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
  "duration": 602767,
  "status": "passed"
});
formatter.match({
  "location": "HolyTester.I_go_to_work()"
});
formatter.result({
  "duration": 210687,
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
  "duration": 185501,
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
  "duration": 282512,
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
  "duration": 165308,
  "status": "passed"
});
});