#!/usr/bin/env bash

# settings
WEEK_DIR=$(pwd)
LIB_DIR=${WEEK_DIR}/lib
SRC_DIR=${WEEK_DIR}/src

JAVA_CP="${SRC_DIR}/main/java:${SRC_DIR}/test/java"
JAVA_CP="${JAVA_CP}:${LIB_DIR}/*"

FILES_DIR=${SRC_DIR}/main/java/edu/nyu/cs9053/homework8
TEST_FILES_DIR=${SRC_DIR}/test/java/edu/nyu/cs9053/homework8

# Clean up .class files
rm ${FILES_DIR}/base/*.class ${FILES_DIR}/*.class ${TEST_FILES_DIR}/*.class

# Redundant, I know
javac -cp ${JAVA_CP} -Xlint:unchecked ${FILES_DIR}/base/*.java
javac -cp ${JAVA_CP} -Xlint:unchecked ${FILES_DIR}/*.java

javac -cp ${JAVA_CP} -Xlint:unchecked ${TEST_FILES_DIR}/*.java

# Run tests
java -cp ${JAVA_CP} edu.nyu.cs9053.homework8.TestRunner