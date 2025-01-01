### **Understanding Generics in Java**

Generics in Java provide a way to create classes, interfaces, and methods that can operate on types specified at runtime while ensuring type safety at compile time. They are a crucial concept in modern Java programming and are frequently tested in interviews.

---

### **Key Concepts of Generics**

#### 1. **Definition and Syntax**
- **Generic Class**: A class that can handle any type of object.
  ```java
  class Box<T> {
      private T item;
      public void set(T item) { this.item = item; }
      public T get() { return item; }
  }
  ```
- **Generic Method**: A method that can work with any type.
  ```java
  public <T> void printArray(T[] array) {
      for (T element : array) {
          System.out.println(element);
      }
  }
  ```

---

#### 2. **Type Erasure**
- Generics are implemented using **type erasure**, which means generic type information is removed during compilation. This ensures backward compatibility with older versions of Java.
- Example:
  ```java
  List<String> list = new ArrayList<>();
  ```
  At runtime, the `List<String>` becomes just `List`.

---

#### 3. **Bounded Type Parameters**
- **Upper Bound**: Restricts the type to a subclass of a specific class.
  ```java
  public <T extends Number> void process(T value) {
      System.out.println(value.doubleValue());
  }
  ```
- **Lower Bound**: Restricts the type to a superclass of a specific class.
  ```java
  public void addNumbers(List<? super Integer> list) {
      list.add(5);
  }
  ```

---

#### 4. **Wildcards**
- **Unbounded Wildcard (`?`)**: Accepts any type.
  ```java
  public void printList(List<?> list) {
      for (Object obj : list) {
          System.out.println(obj);
      }
  }
  ```
- **Upper Bound Wildcard (`<? extends T>`)**: Accepts `T` or its subclasses.
  ```java
  public void process(List<? extends Number> list) {
      for (Number num : list) {
          System.out.println(num);
      }
  }
  ```
- **Lower Bound Wildcard (`<? super T>`)**: Accepts `T` or its superclasses.
  ```java
  public void add(List<? super Integer> list) {
      list.add(10);
  }
  ```

---

#### 5. **Generic Interfaces**
- Interfaces can also be generic.
  ```java
  interface Repository<T> {
      void save(T entity);
      T findById(int id);
  }
  ```

---

#### 6. **Common Uses of Generics**
- **Collections Framework**: Most classes in the `java.util` package use generics, e.g., `List<T>`, `Map<K, V>`.
- **Custom Data Structures**: Implementing stack, queue, etc., with generics.
- **Utility Methods**: Writing reusable methods using generics.

---

### **Interview-Specific Topics**

#### 1. **Why Use Generics?**
- **Type Safety**: Prevents runtime `ClassCastException`.
- **Code Reusability**: Write once and use for different types.
- **Improved Readability**: Clearer code since types are explicit.

#### 2. **Type Erasure in Depth**
- Removes type information during runtime.
- Example:
  ```java
  List<String> list = new ArrayList<>();
  list.add("Hello");
  List<Integer> list2 = new ArrayList<>();
  list2.add(123);

  // At runtime, both are treated as just List.
  ```

#### 3. **Difference Between `?`, `T`, and Raw Types**
- `T`: A specific type parameter.
- `?`: Represents an unknown type.
- Raw Types: Using a generic class without specifying the type, e.g., `List list`.

#### 4. **PECS (Producer Extends, Consumer Super)**
- Use `extends` when the generic is producing data.
- Use `super` when the generic is consuming data.
- Example:
  ```java
  List<? extends Number> producer = Arrays.asList(1, 2, 3); // Can read but not write
  List<? super Integer> consumer = new ArrayList<>(); // Can write but not read
  ```

#### 5. **Generic Constraints**
- Only reference types can be used as type parameters.
- Primitive types like `int` must be wrapped using wrapper classes (`Integer`, `Double`, etc.).

---

### **Common Interview Questions**

1. **What is the purpose of generics in Java?**
   Generics provide type safety and eliminate the need for explicit typecasting.

2. **What are bounded type parameters?**
   Bounded types restrict the permissible types for a generic class or method.

3. **Explain type erasure and its implications.**
   Type erasure removes type parameters during compilation, making generics compatible with older Java versions.

4. **What is the difference between `List<Object>` and `List<?>`?**
    - `List<Object>` can hold objects of type `Object`.
    - `List<?>` can hold any type but is read-only.

5. **How does the `Collections` API use generics?**
   The `Collections` API uses generics extensively for type safety, e.g., `List<T>`, `Set<T>`, `Map<K, V>`.

---

### **Practical Examples**
1. **Custom Generic Stack**
   ```java
   class Stack<T> {
       private List<T> elements = new ArrayList<>();

       public void push(T item) { elements.add(item); }
       public T pop() { return elements.remove(elements.size() - 1); }
       public boolean isEmpty() { return elements.isEmpty(); }
   }
   ```

2. **Generic Pair Class**
   ```java
   class Pair<K, V> {
       private K key;
       private V value;

       public Pair(K key, V value) {
           this.key = key;
           this.value = value;
       }

       public K getKey() { return key; }
       public V getValue() { return value; }
   }
   ```

---

### **How to Prepare for Interviews**
1. **Understand Core Concepts**: Focus on type safety, type erasure, bounded types, and wildcards.
2. **Practice with Collections**: Use generics in `List`, `Set`, `Map`, and `Queue`.
3. **Implement Custom Generics**: Write classes like `Stack<T>` or `Pair<K, V>`.
4. **Learn PECS Rule**: Practice examples with `extends` and `super`.
5. **Review Codebases**: Understand how real-world libraries use generics.

---

---

### **What is PECS?**
PECS stands for:
- **Producer Extends**
- **Consumer Super**

It's a rule to help you decide whether to use `extends` or `super` when working with generics and wildcards (`?`) in Java.

---

### **Upper Bound (`extends`)**
- Use **`extends`** when you want to **read** data from a generic type (the generic is a **producer**).
- The generic type is bounded to a class and its **subclasses**.

#### Example 1: Reading from a List with `extends`
```java
public void printNumbers(List<? extends Number> list) {
    for (Number num : list) {
        System.out.println(num);
    }
}
```

- **Key Points**:
    - `<? extends Number>` means the list can hold elements of type `Number` or its subclasses like `Integer`, `Double`, etc.
    - You can **read** elements as `Number` but **cannot add** elements because the exact type is unknown.

#### Usage Example:
```java
List<Integer> intList = List.of(1, 2, 3);
printNumbers(intList); // Works because Integer extends Number

List<Double> doubleList = List.of(1.1, 2.2, 3.3);
printNumbers(doubleList); // Works because Double extends Number
```

#### Example 2: Why Can't We Add to `extends`?
```java
public void addNumber(List<? extends Number> list) {
    list.add(10); // ERROR: Compiler doesn't know if it’s Integer, Double, etc.
}
```

- The compiler prevents adding elements because it can't confirm the exact type.

---

### **Lower Bound (`super`)**
- Use **`super`** when you want to **write** data into a generic type (the generic is a **consumer**).
- The generic type is bounded to a class and its **superclasses**.

#### Example 1: Adding to a List with `super`
```java
public void addNumbers(List<? super Integer> list) {
    list.add(10); // Allowed
    list.add(20); // Allowed
}
```

- **Key Points**:
    - `<? super Integer>` means the list can hold elements of type `Integer` or its superclasses like `Number` or `Object`.
    - You can **add** elements of type `Integer` or its subclasses.
    - Reading elements is restricted to `Object` type because the specific type isn’t guaranteed.

#### Usage Example:
```java
List<Number> numberList = new ArrayList<>();
addNumbers(numberList); // Works because Number is a superclass of Integer

List<Object> objectList = new ArrayList<>();
addNumbers(objectList); // Works because Object is a superclass of Integer
```

---

### **Unbounded Wildcard (`?`)**
- Use **`?`** when you don’t care about the type and only want to access the data.

#### Example: Print a List of Any Type
```java
public void printList(List<?> list) {
    for (Object obj : list) {
        System.out.println(obj);
    }
}
```

- **Key Points**:
    - `List<?>` can hold any type (e.g., `List<String>`, `List<Integer>`).
    - The type is unknown, so you can only **read** elements as `Object`.

#### Usage Example:
```java
List<String> stringList = List.of("A", "B", "C");
printList(stringList); // Prints A, B, C

List<Integer> intList = List.of(1, 2, 3);
printList(intList); // Prints 1, 2, 3
```

---

### **PECS Rule in Summary**
- **Producer (Source of Data)** → Use `extends`.
    - Example: Reading from a list of numbers.
- **Consumer (Data Sink)** → Use `super`.
    - Example: Adding elements to a list.

| Wildcard   | Usage       | Example                        |
|------------|-------------|--------------------------------|
| `<? extends T>` | Producer  | Reading data from a list.      |
| `<? super T>`   | Consumer  | Writing data to a list.        |
| `<?>`           | Both/None | Generic utilities like printing. |

---

### **Visual Example**
Imagine you have a hierarchy:
```
Object
   ↳ Number
       ↳ Integer
       ↳ Double
```

#### `<? extends Number>` (Upper Bound)
- The list can be:
    - `List<Number>`
    - `List<Integer>`
    - `List<Double>`
- **You can read elements** as `Number`.
- **You cannot add elements**, as the specific type is unclear.

#### `<? super Integer>` (Lower Bound)
- The list can be:
    - `List<Object>`
    - `List<Number>`
    - `List<Integer>`
- **You can write elements** of type `Integer` or its subclasses.
- **You can only read** elements as `Object`.

---
