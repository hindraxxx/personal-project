#!/usr/bin/env bash
set -euo pipefail

rm -rf build/plain-test
mkdir -p build/plain-test

javac -d build/plain-test main_runner/Main.java test/PlainJavaSmokeTest.java
java -cp build/plain-test PlainJavaSmokeTest
