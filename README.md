# FetchWeather

Fetch Weather is Test Automation Framework to validate Web Pages, API and compare data between them

It is implemented as a [maven Project].

## Table of contetnt

* [Maven project structure]
* [Usage]

## Maven project structure

The maven project consist of mutliple modules. A src module and one or more adaption modules, each responsible for different test object that is in scope of test automation assignment.

### src
This module is responsible for managing test cases, test data, test environmnets and configurations.

## Usage
After clone repository use any of the below command running tests
A set of common commands
 * mvn verify   :run any checks on results of integration tests to ensure quality criteria are met
 * mvn clean test   :to run all scenarios
 * mvn test -Dcucumber.options="--tag @getRepos"    :to run specific tag 
 
 Junit and cucumber support additional parameters
