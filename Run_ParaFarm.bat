@echo off
chcp 65001 >nul
where java >nul 2>nul
if %errorlevel%==0 (
    set "JAVA_EXE=java"
) else (
    set "JAVA_EXE="
    for /d %%D in ("C:\Program Files\Eclipse Adoptium\jdk-*") do set "JAVA_EXE=%%D\bin\java.exe"
)
if not "%JAVA_EXE%"=="" goto run
echo No Java installation found. Please install JDK 17 or newer.
pause
exit /b 1

:run
"%JAVA_EXE%" -jar "%~dp0ParaFarm.jar"
echo.
pause
