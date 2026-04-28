#! /usr/bin/env bash

#rm -i ./*/*.class
#javac Main.java ./model/*.java ./view/*.java ./controller/*.java
#java Main

mvn clean compile
mvn javafx:run
