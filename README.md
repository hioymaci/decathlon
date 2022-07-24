# DECATHLON

The project's aim is to calculate the results of a Decathlon competition.

# Installation

Java Runtime Environment 8 is required. [Click](https://www.oracle.com/java/technologies/downloads/) to install.

Project can be run with jar file. If you want to create it from scratch, you should install maven 3 and
run `mvn package`. Jar file is created in target folder.

# Usage

Project run from the terminal.

**usage:** `java -jar decathlon.jar -i inputFile.csv -o outputFile.xml`

**version:** _0.0.1_

* **-i**: mandatory input csv file. Default separator is semicolon ';'. Use -s parameter to change the
  separator.
* **-o**: output file. Output file contains all athletes overall decathlon scores, full names and their place. Output
  file format is xml.
* **-s**: separator character for input csv file. Default is semicolon ';'. It should be one character.
* **-v**: print version of the program.
* **-k**: verbose output.
* **-h**: print this usage information.

# Input

Input file is a csv file separated with semicolon. Each row has 11 fields:

- Full Name
- 100-meter dash score as _seconds_
- Long jump as _meter_
- Shot put as _meter_
- High jump as _meter_
- 400-meter dash as _seconds_
- 110m hurdles as _seconds_
- Discus throw as _meter_
- Pole vault as _meter_
  Javelin _throw_
- 1500 meter run as format _mm:ss_

Sample input file is in `ìnputs` folder.

# Output

Output file has all athletes':

- full name
- decathlon score
- place: place is rank in the competition of the athlete. If there are more than same score, place shows rank gap. For
  example if 3 athletes has same score after first athlete, their places are '2-4'. Athletes are placed according to
  their names if they share the places.

Sample output file is in `sample_outputs` folder.

# Resources

Click [here](https://en.wikipedia.org/wiki/Decathlon) for Decathlon information and formula calculation.

Formula: INT(A((B-P)*-1)^C) (multiplication by -1 is valid for field event) in which 'INT' operation removes the
fractional part of
calculating point.

Results are checked with the table under the Benchmark's topic in the wiki.
Only High jump and Pole vault's event results for 1000 pts are a bit different. They are required to calculate more
sensitive.

For High jump instead of 2.2000, it should be 2.2077. For Pole vault instead of 5.2800, it should be 5.2863.

These results are also checked with this [calculator](https://www.sportcalculators.com/decathlon-calculator).

# Naming Convention

[Google naming convention](https://google.github.io/styleguide/javaguide.html) is used in this project.

# Benchmark

Decathlon calculator calculates 1,000,000 results in 3.17 seconds on average.

10 individual test is run in computer which has Intel i9-10850K CPU and 16 GB DDR4 2400 MHz RAM.

# Test Coverage

There are unit tests in project with using Junit 5 Jupiter. Test coverage results:

* class coverage: %100
* method coverage: %100
* line coverage: %73. When integration tests are included, line coverage is %97.

It is measured with IntelliJ code coverage feature.

# Dependencies

- Java 1.8
- Maven

Project tested with Apache Maven 3.8.1.
Project developed with IntelliJ Ultimate 2021.1.1.

# Static Code Analyzer

SonarLint plugin in Intellij and IntelliJ itself static code analyzers are used to check code. All possible issues are
fixed.

# Licence

Go to file [LICENSE](LICENSE).

# Author

[Halil Ibrahim Oymaci](mailto:hioymaci@gmail.com) - Senior Software Engineer
