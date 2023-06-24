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
Version 3.0.0014 of JEtsy is available from the Maven Central Repository [here](https://search.maven.org/search?q=g:com.notronix%20a:JEtsy)

    <dependency>
        <groupId>com.notronix</groupId>
        <artifactId>JEtsy</artifactId>
        <version>3.0.0014</version>
    </dependency>

### Usage (TODO: update to V3 implementation with OAuth2.0)
JEtsy is intended to be used as a way to allow any Java developer to quickly get their own application (known as the 
"Client") off the ground and running.  As a result, the first step required is to register your own application with 
Etsy.  This registration process will provide you with a "key string" (known as the "App Key"). The App Key can then 
be used with JEtsy to make API calls.  However, some API calls require you to obtain an access token which can also 
be obtained using JEtsy.  The following steps illustrate how to get started.

1. Register your application with Etsy [here](https://www.etsy.com/developers/documentation/getting_started/register).
   

2. Record the "key string" provided by completing step 1 above.


3. Create an instance of `EtsyAPI` and `AppKey` using the key string from step 2. 


    ```
    EtsyAPI etsyAPI = EtsyAPI.getDefaultInstance();
    AppKey appKey = AppKey.forKeyString("your_app_keystring");


4. Use the `etsyAPI` to make API calls that do not require an access token.


    ```
    PingMethod<HttpContent> pingMethod = etsyAPI.getAuthResource().createPingMethod();
    Long pingResponse = etsyAPI.execute(appKey, pingMethod).getContent();

4. To make API calls that require an access token, obtain your token using the OAuth flow.


    ```
    OAuthConnector connector = etsyAPI.getAuthResource().createOAuthConnector();
    String loginURL = connector.getConnectionURL(appKey, "redirect",
            Arrays.stream(EtsyScope.values()).collect(Collectors.toSet()));


5. Visit Etsy via the login URL obtained in step 4 above.  Etsy will require you to log in to an existing Etsy account. 
After a successful login, Etsy will ask you to grant your application (client) access to your account.  If you specified 
an OOB callback then record the verifier code presented to you.  If you specified your own callback URL, then Etsy will 
redirect to your URL and provide the verifier code as a query parameter.
   

6. Use the `EtsyDataService` object and your verifier code to obtain access credentials.  Access credentials will be 
   required whenever the Etsy API indicates that OAuth is required.  Details of the API methods are available 
   [here](https://www.etsy.com/developers/documentation/reference/apimethod)


    ```
    String verifier = "VerificationCodeProvidedByEtsy"; // replace this with your verification code
    Credentials accessCreds = etsyDataService.getAccessCredentials(temporaryCreds, verifier);


7. Use the `EtsyDataService` and your credentials to make API calls to Etsy.  The example below shows an API call to get
the Etsy user associated with the account that was verified in step 5.


    ```
    List<String> userIdsOrNames = Collections.singletonList(EtsyAPI.__SELF__);
    List<EtsyUser> users = etsyDataService.getUser(accessCreds, userIdsOrNames, UserAssociations.values());
    EtsyUser authorizedEtsyAccountUser = users.get(0);


### Contribution
1. Found an issue?  Add the details [here](https://github.com/Notronix/JEtsy/issues)
2. Need a missing Etsy API method call added to this library? Add the details [here](https://github.com/Notronix/JEtsy/issues)
3. Want code changed? Fork the repository and make a pull request.
