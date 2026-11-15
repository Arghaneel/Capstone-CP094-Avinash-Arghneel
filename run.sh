#!/usr/bin/env bash
# Builds, then starts the app
set -e
"$(dirname "$0")/build.sh"
java -cp out com.copycheck.Main
