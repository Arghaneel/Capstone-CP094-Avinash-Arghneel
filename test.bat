@echo off
rem Builds, then runs every *Test class
call "%~dp0build.bat" || exit /b 1
java -cp "%~dp0out" com.copycheck.TestRunner
