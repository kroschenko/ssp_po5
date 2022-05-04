javac -cp src src\cp\*.java -d bin
javadoc src\cp\*.java -d docs
jar cvfm cp.jar resources\manifest.txt -C bin . src docs
