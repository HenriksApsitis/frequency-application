# frequency-application
To run programm and tests
1. Pull project
2. In cmd - mkdir out
3. Compile project using javac -d out -cp lib/junit-platform-console-standalone-1.9.2.jar test/com/company/MainTest.java src/com/company/Main.java
4. Run programm using java -cp out com.company.Main
5. Run tests using java -jar lib/junit-platform-console-standalone-1.9.2.jar --class-path out --scan-class-path
Made with JDK-19
