Feature: Git API Traning Feature


	Scenario: Tweets
	Given Request tweets of a user
	When I check the status code fo repsonse
	Then Response code is "200"