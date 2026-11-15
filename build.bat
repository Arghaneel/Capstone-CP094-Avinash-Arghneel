@echo off
rem Compiles main and test sources into out\
setlocal enabledelayedexpansion
cd /d "%~dp0"
if exist out rmdir /s /q out
mkdir out
set "ROOT=%CD%\"
(for /r src %%f in (*.java) do (
    set "p=%%f"
    echo !p:%ROOT%=!
)) > out\sources.txt
javac --release 17 -encoding UTF-8 -d out @out\sources.txt
if errorlevel 1 exit /b 1
echo Build OK
