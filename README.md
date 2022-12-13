# dayelostra.co LeetCode

## Introduction

A [Maven 3](https://maven.apache.org/) based Java 19 project to manage my LeetCode source code and [JUnit 5](https://junit.org/junit5/) Unit Tests.

## Abstract

Each LeetCode problem should be contained within their own package with support classes included within the same package. Each Problem class should be in the submission format for the LeetCode Web IDE to make copy/paste actions easier. Unit Tests should be created for each Problem class and included in the generated Surefire reporting output.

## **Testing**

Unit and Integration tests provided to every Maven module. Each test uses [JUnit 5.9.1](http://junit.org/junit5/) and static assert imports.

## **Application Build & Deployment**

Before you begin, be sure to have the following installed on your build machine:

* Java JDK 1.19.0 with a minimum version of 1.19.0 and maximum version of 1.19.1
    * Run the `java -version` command to determine if the correct Java JDK is installed
* Maven 3 with a minimum version of 3.8.0 and a maximum version of 3.8.1
    * Run the `mvn -version` command to determine if the correct version of Maven 3 is installed


### **Maven CLI**

#### **Unit Tests**
```
mvn clean test
```

#### **Surefire HTML Reports**
```
mvn clean install site:site
```

#### **Surefire HTML Application**
1. Run the mvn command to generate the Surefire HTML Site and deploy it via an embedded Jetty container
```
mvn clean install site:run
```
2. Open a browser to http://localhost:8080
3. Once you are finished viewing the report, be sure to close/exit the terminal running mvn to stop the Jetty container

#### **JavaDocs**
```
mvn clean install javadoc:jar
```
Generated JavaDocs for all modules will be automatically aggregated to the top level target folder under site -> apidocs -> index.html


## **Dependency Security**

This project uses [Syft](https://github.com/anchore/syft) and [Grype](https://github.com/anchore/grype) to ensure that no known vulnerabilities are being introduced via dependency libraries. The latest SBOM is included at the root of this codebase and is updated on every Release Candidate version.

### **Grype**

If you want to scan the dependencies for known vulnerabilities, you can run the following Grype command on the compiled  Jar located within the /target folder:

**RELATIVE PATH EXAMPLE**

`
grype /target/leetcode.jar -o json > Vulnerabilities-Grype-20221215.txt
`

**WORKING EXAMPLE**

`
grype /target/leetcode.jar > /leetcode/Vulnerabilities-Grype-20221215.txt
`

**NOTE:** These examples also contains a Pipe command to output the file to the root project folder. If you are a
Windows user, this option will not work.

### Syft

If you want to generate a full Software Build of Materials (SBOM), you can run the following Syft command on the
compiled Spring Boot Embedded Container Jar located within the /target folder:

**RELATIVE PATH EXAMPLE**

`
syft /target/leetcode.jar -o json > SBOM-Syft-20221215.json
`

**WORKING EXAMPLE**

`
syft /target/leetcode.jar -o json > /yourdirectory/leetcode/SBOM-Syft-20221215.json
`

**NOTE:** Using the -o json flag ensures that the scan will return the most detailed SBOM Syft can provide. These examples also contains a Pipe command to output the file to the root project folder. If you are a Windows user, this option will not work.