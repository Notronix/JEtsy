# JEtsy
A Java implementation of a Java version of the Etsy API

### About
JEtsy (Java Etsy API) is 2 things:

1. An API.  JEtsy provides a Java version of the Etsy API.  Etsy's REST API is fully described using java 
<code>interfaces</code>.  This allows anyone to build their own implementation of that API and makes adapting or 
extending the implementation much easier to achieve.
2. An Implementation.  JEtsy provides a full implementation of the API mentioned above.  This makes JEtsy usable right 
out of the gate.  There's nothing to change, unless you need a specific feature or would rather use different underlying 
implementations (ex. a different Http transport).

### Installation
Version 1.0.0003 of JEtsy is available from the Maven Central Repository [here](https://search.maven.org/search?q=g:com.notronix%20a:JEtsy)

    <dependency>
        <groupId>com.notronix</groupId>
        <artifactId>JEtsy</artifactId>
        <version>1.0.0003</version>
    </dependency>

### Contribution
1. Found an issue?  Add the details [here](https://github.com/Notronix/JEtsy/issues)
2. Want code changed? Fork the repository and make a pull request.
