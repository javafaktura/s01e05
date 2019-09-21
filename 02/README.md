# 02 Fifty shades of smog

![src//test//resources//images//smog_map.jpg](src//test//resources//images//smog_map.jpg)

Read this article as reference [https://www.polskialarmsmogowy.pl/polski-alarm-smogowy/smog/szczegoly,poziomy-informowania-i-alarmowe,19.html](https://www.polskialarmsmogowy.pl/polski-alarm-smogowy/smog/szczegoly,poziomy-informowania-i-alarmowe,19.html)

## Code
* [Pm10SmogAlertService.java](src//main//java//io//github//javafaktura//s01e05//Pm10SmogAlertService.java) - our smog service responsible for defining whenever given smog alert type should be send for given params
* [Country.java](src//main//java//io//github//javafaktura//s01e05//Country.java) - simple enum storing all countries supported by service
* [SmogAlertType.java](src//main//java//io//github//javafaktura//s01e05//SmogAlertLevel.java) - simple enum storing all countries supported by service

## Bad Tests
* [BadPm10SmogAlertServiceTest.java](src//test//java//io//github//javafaktura//s01e05//BadPm10SmogAlertServiceTest.java) - multiple tests to cover all corner cases of service

### Nice parts and lessons learned included:
* :+1: better test naming, both method naming and descriptive one
* :+1: using [literals](https://en.wikipedia.org/wiki/Literal_(computer_programming))
* :+1: given / when / convention
* :+1: high code coverage
* :+1: clean formatting of params
* :+1: helping class to encapsulate params

### Smells (sometimes opinionated):
* :hankey: single test with multiple assertions instead multiple tests
* :hankey: for loop isn't best approach to deal with multi parameter tests
* :hankey: multiple reasons why test can fail - breaking the concrete test rule
* :hankey: if failing test happen it is quite hard to spot the reason
* :hankey: boilerplate code for test setup (`testScenarios.add(new TestParams(..`)
* :hankey: getting external source for test params is quite tricky


## Better Tests

[BetterPm10SmogAlertServiceTest.java](src//test//java//io//github//javafaktura//s01e05//BetterPm10SmogAlertServiceTest.java) - the same tests but grouped by param approach

### Good practices (sometimes opinionated):
* :+1: right way to do parameterized test without for loop
* :+1: [Data-driven testing](https://en.wikipedia.org/wiki/Data-driven_testing) introduced
* :+1: splitting single test to multiple ones allows us to get one single scenario when test fails
* :+1: it is way easier to spot reason why a certain test failed
* :+1: additional ability to import data params from external source
* :+1: convention names for easier connection between csv data and test

## Fixing bugs and tests

![src//test//resources//images//gdzietensmog.jpg](src//test//resources//images//gdzietensmog.jpg)

Looks like we introduced some bugs. Poland country is way more tolerant towards PM10 levels than we assumed.
Thanks to data-driven approach it is way easier to add/modify test.
