   Feature: Login into platform QA

@Smoke @Regression 
Scenario Outline: Positive Flow of Login
Given the url is present 
When the request "<userID>" "<name>" are passed into "loginAPI"
Then the session token extracted
And the status code should be "<code>"
And login is successful "msg"

Examples:
	|userID|name     | code   |
	|5     |Sharmila | 40033  |	
	|6     |Checker_S| 40033  |
	|2     |Avinash  | 220059 |