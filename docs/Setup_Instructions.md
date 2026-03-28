# Setup Instructions

## JDK Version Used

- Installed JDK in this environment: `JDK 21.0.10`
- Project compiler target in `pom.xml`: `Java 17`

This means the project is currently being compiled with JDK 21, while the source and target compatibility are set for Java 17.

## Java Installation and Configuration

1. Install the Java Development Kit (JDK).
2. Verify installation using:

    java -version,
    javac -version

3. Open this project in your IDE or terminal.
4. Compile the Java files and run the main class.

## Hello World Program Run

A simple Hello World Java program contains a `main` method and prints text using `System.out.println()`.

Example:

    public class HelloWorld {
        public static void main(String[] args) {
            System.out.println("Hello, World!");
        }
    }

Brief run explanation:

1. Save the file as `HelloWorld.java`.
2. Compile it using `javac HelloWorld.java`.
3. Run it using `java HelloWorld`.
4. The output displayed in the terminal is:

```text
Hello, World!
```

If screenshots are required for submission, capture:

- the terminal after running `javac HelloWorld.java`
- the terminal output after running `java HelloWorld`
