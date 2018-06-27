#!/bin/bash
rm -rf gen-java/
thrift -r --gen java calc.thrift