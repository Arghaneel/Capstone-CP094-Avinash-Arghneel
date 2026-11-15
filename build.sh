#!/usr/bin/env bash
# Compiles main and test sources into out/
set -e
rm -rf out
mkdir -p out
find src -name "*.java" > out/sources.txt
javac --release 17 -encoding UTF-8 -d out @out/sources.txt
echo "Build OK"
