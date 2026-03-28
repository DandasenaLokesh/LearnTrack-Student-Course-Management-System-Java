# JVM Basics

## What is JDK, JRE, and JVM?

The JDK(Java Development Kit) is the full toolkit used to develop Java programs. It includes the compiler (javac), the Java runtime tools, and other utilities needed for writing, compiling, and running Java code.

The JRE(Java Runtime Environment) is used to run Java programs. It provides the libraries and runtime support needed for an already compiled Java application.

The JVM(Java Virtual Machine) is the engine that actually runs Java bytecode. It reads the compiled .class files and executes them on the current operating system.

## What is Bytecode?

Bytecode is the intermediate code produced when a Java source file is compiled. Java source code written in a .java file is converted into .class files, and those .class files contain bytecode.

This bytecode is not tied to one specific operating system. Instead, the JVM on each platform reads the same bytecode and runs it.

## What does "Write Once, Run Anywhere" mean?

Java follows the idea of "write once, run anywhere" because Java source code is compiled into bytecode, not directly into machine code for only one platform. Once the program is compiled, the same bytecode can run on any system that has a compatible JVM.

For example, a Java program compiled on Windows can also run on Linux or macOS without changing the source code, as long as a suitable JVM is installed there. This is one of Java's biggest advantages for portability.
