### **Future, Runnable, and Callable in Java**

These interfaces and classes are part of Java's concurrency framework. They are used to execute tasks asynchronously, enabling better performance and responsiveness.

---

### **1. Runnable**
- Represents a task that can be executed by a thread.
- Does **not return a result** and cannot throw checked exceptions.

#### **Key Features**:
- Simple and lightweight.
- Suitable for tasks that do not require a return value or exception handling.

#### **Example**:
```java
public class RunnableExample {
    public static void main(String[] args) {
        Runnable task = () -> System.out.println("Task executed by " + Thread.currentThread().getName());
        Thread thread = new Thread(task);
        thread.start();
    }
}
```

---

### **2. Callable**
- Introduced in **Java 5**.
- Similar to `Runnable` but can:
    - Return a result.
    - Throw checked exceptions.

#### **Key Features**:
- Returns a value using the `call()` method.
- Used with the `ExecutorService` for advanced thread management.

#### **Example**:
```java
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<Integer> task = () -> {
            System.out.println("Task executed by " + Thread.currentThread().getName());
            return 42; // Return some result
        };

        try {
            Future<Integer> future = executor.submit(task);
            System.out.println("Result: " + future.get()); // Blocks until the result is available
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
```

---

### **3. Future**
- Represents the result of an asynchronous computation.
- Provides methods to check if the task is complete, cancel it, and retrieve the result.

#### **Key Features**:
- Used with `Callable` or `Runnable` tasks submitted to an `ExecutorService`.
- Methods:
    - `get()`: Retrieves the result (blocks until the task completes).
    - `cancel()`: Attempts to cancel the task.
    - `isDone()`: Checks if the task is complete.
    - `isCancelled()`: Checks if the task was cancelled.

#### **Example**:
```java
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<String> task = () -> {
            Thread.sleep(2000); // Simulate some work
            return "Task completed!";
        };

        Future<String> future = executor.submit(task);

        System.out.println("Task submitted, doing other work...");

        try {
            // Check if the task is done
            while (!future.isDone()) {
                System.out.println("Task is still running...");
                Thread.sleep(500); // Wait a bit before checking again
            }

            // Retrieve the result
            System.out.println("Result: " + future.get());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
```

---

### **4. Combining Runnable, Callable, and Future**
You can use `Runnable` with a `FutureTask` to achieve a return value for a `Runnable`.

#### **Example**:
```java
import java.util.concurrent.FutureTask;

public class RunnableWithFuture {
    public static void main(String[] args) throws Exception {
        FutureTask<Integer> task = new FutureTask<>(() -> {
            System.out.println("Task executed");
            return 100; // Return a result
        });

        Thread thread = new Thread(task);
        thread.start();

        // Get the result
        System.out.println("Result: " + task.get());
    }
}
```

---

### **Best Practices**
1. Use `Runnable` for simple tasks without a return value.
2. Use `Callable` with `Future` when you need a return value or exception handling.
3. Use `ExecutorService` to manage threads instead of creating them manually.
4. Always shut down the `ExecutorService` to release resources.

