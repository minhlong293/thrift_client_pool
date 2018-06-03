#!/bin/bash
rm -rf gen-java/
thrift -r --gen java calc.thrift
cp -r gen-java/* ../src/main/java