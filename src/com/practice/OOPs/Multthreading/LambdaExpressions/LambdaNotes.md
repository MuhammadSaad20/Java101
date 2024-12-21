If an Interface has only one
Abstract Method, 
it's called a Functional Interface 


// Example

interface Design {
public abstract void doSomething();
}


//Lambda Expression Anonymous Function 
public void fun()
{ 
//do something
}
// Anonymous Function
()→{//do something }


### **Lambda Expression in Java**
A **lambda expression** is a concise way to represent an **anonymous function** (a function without a name). It simplifies the implementation of functional interfaces in Java.

---

### **Syntax**
```java
(parameters) -> { body }
```
- **Parameters**: The input to the lambda function.
- **Arrow (`->`)**: Separates the parameter list from the body.
- **Body**: Contains the logic or code to execute.

If the body is a single statement, curly braces (`{}`) can be omitted.

---

### **Anonymous Function vs Lambda Expression**

**Anonymous Function**:
- Implemented using **anonymous classes**.
- Verbose and requires more boilerplate code.

**Lambda Expression**:
- Compact and concise.
- Often used with functional interfaces like `Runnable`, `Comparator`, or custom ones.

---

### **Examples**

#### 1. **Without Lambda Expression (Using Anonymous Class)**:
```java
Runnable r = new Runnable() {
    @Override
    public void run() {
        System.out.println("Running using an anonymous class!");
    }
};
new Thread(r).start();
```

#### 2. **With Lambda Expression**:
```java
Runnable r = () -> System.out.println("Running using a lambda expression!");
new Thread(r).start();
```

---

### **Detailed Examples**

#### 1. **Functional Interface Example**
A functional interface is an interface with exactly one abstract method.

```java
@FunctionalInterface
interface Greeting {
    void sayHello();
}
```

**Using Anonymous Class**:
```java
Greeting greet = new Greeting() {
    @Override
    public void sayHello() {
        System.out.println("Hello, World!");
    }
};
greet.sayHello();
```

**Using Lambda Expression**:
```java
Greeting greet = () -> System.out.println("Hello, World!");
greet.sayHello();
```

---

#### 2. **Lambda with Parameters**
```java
@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}
```

**Using Anonymous Class**:
```java
MathOperation addition = new MathOperation() {
    @Override
    public int operate(int a, int b) {
        return a + b;
    }
};
System.out.println("Sum: " + addition.operate(5, 3)); // Output: 8
```

**Using Lambda Expression**:
```java
MathOperation addition = (a, b) -> a + b;
System.out.println("Sum: " + addition.operate(5, 3)); // Output: 8
```

---

#### 3. **Lambda with Collections**
**Sorting a List Without Lambda**:
```java
import java.util.*;

List<String> names = Arrays.asList("John", "Alice", "Bob");
Collections.sort(names, new Comparator<String>() {
    @Override
    public int compare(String s1, String s2) {
        return s1.compareTo(s2);
    }
});
System.out.println(names); // [Alice, Bob, John]
```

**Sorting a List With Lambda**:
```java
import java.util.*;

List<String> names = Arrays.asList("John", "Alice", "Bob");
names.sort((s1, s2) -> s1.compareTo(s2));
System.out.println(names); // [Alice, Bob, John]
```

---

### **Advantages of Lambda Expressions**
1. **Conciseness**: Reduces boilerplate code.
2. **Improved Readability**: Makes code easier to understand.
3. **Functional Programming**: Enables functional programming paradigms in Java.
4. **Ease of Use with Streams**: Lambda expressions work seamlessly with Java Streams for data processing.

---

### **When to Use Lambda Expressions**
- **Single-method interfaces** (Functional Interfaces).
- Replace anonymous classes for cleaner code.
- Simplify operations with collections (e.g., filtering, mapping, sorting).

---

### **Key Points**
1. Lambda expressions require **functional interfaces**.
2. They are often used in combination with Java's **Stream API** for data processing.
3. Simplifies callbacks and event handling (e.g., listeners in GUIs).