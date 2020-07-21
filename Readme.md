This is a demo about how to use the spring cloud function with Spring boot adapter

The demo also shows how to laod the custom keystore and test the presence of a keystore alias

how to run: mvn clean package

Load target/springclodufunction-1.0-shaded.jar to aws lambda and then create the test event with a string

E.g. Test: "ABBA"
