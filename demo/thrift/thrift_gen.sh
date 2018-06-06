#!/bin/bash
rm -rf gen-java/
thrift11 -r --gen java calc.thrift
cp -r gen-java/* ../src/main/java