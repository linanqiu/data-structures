Prepared by Linan Qiu <[lq2137@columbia.edu](lq2137@columbia.edu)>

# Command Line Arguments

So far we have been taking input during runtime. Command line arguments let us take input from the user right before runtime.

Everything that comes after the program name is a command line argument.

```java
java MyProgram pikachu bulbasaur mew
```

Your program can take as many command line arguments as you wish.

Recall:

```java
// in MyProgram

public static void main (String[] args) {
  
}
```

The `String[] args` represents a String array. This String Array holds the command line arguments you passed to your program.

```java
// in MyProgram

public static void main (String[] args) {
  System.out.println(args[0]); // "pikachu"
  System.out.println(args[1]); // "bulbasaur"
  System.out.println(argsp2); //"mew"
}
```
