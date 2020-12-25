  Feature: getCorporateList

@Positive @Regression @Smoke
Scenario Outline: Positive Flow of Login
Given the test scenario with "<Offset>" "<page_size>" "<sort_order>" "<field_name>" "getCorporateList"
Then the message is verified "Corporate List fetched Successfully"

Examples:
|Offset|page_size|sort_order|field_name|
|6|10|ASC|code|
|10|5|DESC|name|
|3|15|ASC|name|
|0|50|DESC|code|
|3|15|  |name|

@Negative @Regression
Scenario Outline: Negative Flow of Login
Given the test scenario with "<Offset>" "<page_size>" "<sort_order>" "<field_name>" "getCorporateList"
Then the message is not verified "Corporate List fetched Successfully"

Examples:
|Offset|page_size|sort_order|field_name|
|-6|10|ASC|code|
#|10|-5|DESC|name|
#|3|15|ASCending|name|
#|0|50|DESC|parent_id|


@NullValue @Regression
Scenario Outline: Null Flow of Login
Given the test scenario with "<Offset>" "<page_size>" "<sort_order>" "<field_name>" "getCorporateList"
Then the message is not verified "Corporate List fetched Successfully"

Examples:
|Offset|page_size|sort_order|field_name|
#|      |10       |ASC       |code      |
|10    |         |DESC      |name      |
|0     |50       |DESC      |          |

@Google @Smoke 
Scenario: Login to Google
Given enter the url "http://216.10.245.166/Library/GetBook.php?ID=xabc123xabc123"


@Google 
Scenario: Login to Google
Given enter the url "http://216.10.245.166/Library/GetBook.php?ID=xabc123xabc123"