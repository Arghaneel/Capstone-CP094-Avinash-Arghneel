#!/usr/bin/env bash
# Builds, then runs every *Test class
set -e
"$(dirname "$0")/build.sh"
java -cp out com.copycheck.TestRunner
