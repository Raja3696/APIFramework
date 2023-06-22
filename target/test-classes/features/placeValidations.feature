Feature: Validating Place API's

@Addplace
Scenario Outline: Verify if Place is being successfully added using AddPlaceAPI

		Given Add Place Payload with "<name>" "<language>" "<address>"
		When user calls "AddPlaceAPI" with "POST" http request
		Then the API call is success with status code 200
		And "status" in response body is "OK"	
		And "scope" in response body is "APP"
		And verify place_ID created maps to "<name>" using "getPlaceAPI"
		
Examples: 

|name               |language               |address                  |
|Brahmi             |Korean                 |  Clocktown centre       |
#|MehfilBiryani     |Hyderabd               |  Nizampet Crossroads    |
#|Bawarchi          |Visakhapatnam          |  Balaga   Crossroads    |

@Deleteplace
Scenario: Verify if delete place functionality is working

	Given Delete place payload
	When user calls "deletePlaceAPI" with "POST" http request
	Then the API call is success with status code 200
	And "status" in response body is "OK"	
