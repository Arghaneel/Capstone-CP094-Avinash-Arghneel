@echo off
rem Builds, then starts the app
call "%~dp0build.bat" || exit /b 1
java -cp "%~dp0out" com.copycheck.Main
