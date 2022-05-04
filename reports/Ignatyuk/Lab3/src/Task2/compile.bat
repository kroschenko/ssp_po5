javac -cp ".\src\;.\lib\SizeOf.jar" -d ".\bin" .\src\vmem\*.java
@REM javadoc -cp ".\src\;.\lib\SizeOf.jar" -d ".\docs" .\src\vmem\*.java
jar -cvfm vmem.jar ".\resources\manifest.txt" -C ".\bin" .\
@REM jar -cvfm vmem.jar ".\resources\manifest.txt" -C ".\bin" .\ -C ".\docs" .\ -C ".\lib" .\
