[![Build Status](https://travis-ci.org/artkuznetsov101/jmstest.svg?branch=master)](https://travis-ci.org/artkuznetsov101/jmstest)

# jmstest

Simple jms integration test utility I used during the development of (yet another) jms message broker. 

Easy to use and suitable for CI servers.

By default, it is configured for testing ActiveMQ message broker. In order to test another broker you need to implement Provider interface (Provider.java) and check getProvider() method of ProviderLoader class (ProviderLoader.java). Provider implementation for Qpid message broker also included.

#### how to build:
    mvn package

#### how to run test:
    mvn verify

#### test result location:
    target/surefire-reports
