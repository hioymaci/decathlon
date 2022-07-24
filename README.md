# DECATHLON

The project's aim is to calculate the results of a Decathlon competition.

# Installation

Java Runtime Environment 8 is required. [Click](https://www.oracle.com/java/technologies/downloads/) to install.

# Usage

Project run from the terminal.

**usage:** `java -jar decathlon.jar -i inputFile.csv -o outputFile.xml`

**version:** _0.0.1_

* **-i**: mandatory input csv file. Default separator is semicolon ';'. Use -s parameter to change the
  separator.
* **-o**: output file. Output file contains all athletes overall decathlon scores, full names and their place. Output
  file
  format is xml.
* **-s**: separator character for input csv file. Default is semicolon ';'. It should be one character.
* **-v**: print version of the program.
* **-k**: verbose output.
* **-h**: print this usage information.

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

Decathlon calculator calculates 1,000,000 results in 7.522 seconds on average. (10 individual test)

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
