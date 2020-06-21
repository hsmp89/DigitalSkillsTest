# Digital Skills technical task

## Technologies used

* Serenity
* Cucumber JVM
* Selenium Webdriver
* Java 8
* opencsv
* gradle

* IDE- IntelliJ



###  Solution / Approach

* Input text file contains the vehicle registration numbers with other text content
* Output text file contains vehicle details and these details are passed through cucumber scenario outline.

* Input text file is parsed and extracted vehicle registration numbers
* looped through each registration number
* Verified vehicle details on cartaxcheck.co.uk website
* Actual values are verified with the expected values which are present in the car_output.txt
* Solution is designed in such a way that in future multiple input and output files can be given in the scenario outline and * * the logic works without any change


### Command to execute the automation from command line
The following command should be executed from the projects root to run all tests:

`gradle clean test` default will run on local chrome browser

In order to run on other browser, please change the browser value under `serenity.properties` or alternatively, 
pass browser value as an argument in commandline as example below

`gradle clean test -Dbrowser=FIREFOX`

note:As I used WebDriverManager which eliminates the problem of locally storing the driver binary files 
and maintaining different versions of the driver files (for different browsers).

### Reports location
* Serenity Reports are located under target/site/serenity/index.html
* In adition, Cucumber Reports are located under target/features/cucumber-pretty/index.html

note: As unable to upload the target folder due to large size, so alternatively uploaded compressed target.zip


### Evidence of tests report

* A sample video of execution is enclosed under below shared link 
https://drive.google.com/file/d/199OqhSc0QRzjzyGt6VQcPTZIQHpF6STR/view?usp=sharing

* Screenshots of a serenity,cucumber output reports[as pdf] are placed under the evidence folder
https://github.com/hsmp89/Identity01/blob/master/evidence/test_report_evidence_1_0.pdf
