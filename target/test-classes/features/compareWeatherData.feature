Feature: Compare Weather Data between Website and API

@twitter
	Scenario: Compare Weather Data between Website and API and check diffrence is withing allowed threshold
	Given User navigates to the website URL
	When User Navigate to "WEATHER" Page
	And User Search for "Bengaluru" City and pins in Weather Page
	And User Notes the Temperature of pinned City from Weather Page
	And User requests Temperature of pinned City from Weather API
	Then API Response code is "200"
	And Temparature difference bewteen Web and API is not more than "15" 
	