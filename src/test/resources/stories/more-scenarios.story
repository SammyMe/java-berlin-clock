Scenario: Minutes in the range of 5 to 9
When the time is 00:09:00
Then the clock should look like
Y
OOOO
OOOO
YOOOOOOOOOO
YYYY

Scenario: Minutes in the range of 10 to 14
When the time is 00:14:00
Then the clock should look like
Y
OOOO
OOOO
YYOOOOOOOOO
YYYY

Scenario: Minutes in the range of 15 to 29
When the time is 00:28:00
Then the clock should look like
Y
OOOO
OOOO
YYRYYOOOOOO
YYYO

Scenario: Minutes in the range of 30 to 44
When the time is 00:44:00
Then the clock should look like
Y
OOOO
OOOO
YYRYYRYYOOO
YYYY

Scenario: Minutes in the range of 45 to 59
When the time is 00:54:00
Then the clock should look like
Y
OOOO
OOOO
YYRYYRYYRYO
YYYY
