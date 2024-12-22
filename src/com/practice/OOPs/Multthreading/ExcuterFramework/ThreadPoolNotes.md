### **Multithreading in Java: Thread Pooling and Executor Framework**

 **1. Thread Pooling**
---

#### **What is Thread Pooling?**
Thread pooling is a technique to manage a group of reusable threads, reducing the overhead of thread creation and destruction. Instead of creating new threads for every task, a pool of threads is maintained, and tasks are assigned to available threads.

---

#### **Why Use Thread Pooling?**
1. **Performance Improvement**: Reduces the overhead of frequent thread creation and destruction.
2. **Resource Optimization**: Limits the number of concurrent threads, preventing excessive resource usage.
3. **Task Queueing**: Tasks can wait in a queue if no thread is available, ensuring smooth task execution.
4. **Reusability**: Threads in the pool are reused for multiple tasks.

---

#### **How Thread Pooling Works**
1. A fixed number of threads are created when the thread pool is initialized.
2. Tasks are submitted to the thread pool.
3. Threads pick up tasks from the queue and execute them.
4. Once a thread finishes its task, it goes back to the pool, ready for another task.

---

#### **Thread Pool Example**
Without thread pooling:
```java
for (int i = 0; i < 10; i++) {
    Thread t = new Thread(() -> {
        System.out.println(Thread.currentThread().getName() + " is running");
    });
    t.start();
}
```

With thread pooling:
```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5); // Create a pool of 5 threads

        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " is running");
            });
        }

        executor.shutdown(); // Graceful shutdown
    }
}
```

---

#### **Benefits of Thread Pooling**
- **Prevents Overhead**: Threads are reused instead of being created and destroyed repeatedly.
- **Task Management**: Tasks can be queued for execution.
- **Controlled Concurrency**: Limits the number of active threads, avoiding resource exhaustion.

---

 **2. Executor Framework**
---

#### **What is the Executor Framework?**
The Executor Framework in Java is a high-level API for managing and controlling thread execution. It abstracts the complexity of thread creation, management, and termination.

---

#### **Core Components of the Executor Framework**
1. **Executor**:
    - The root interface for launching tasks.
    - Example: `execute(Runnable command)`.

2. **ExecutorService** (Extends Executor):
    - Adds features for managing the lifecycle of tasks.
    - Example: `shutdown()`, `submit(Callable task)`.

3. **ScheduledExecutorService**:
    - Allows scheduling tasks with a delay or at fixed intervals.
    - Example: `scheduleAtFixedRate()`.

4. **ThreadPoolExecutor**:
    - A concrete implementation that provides fine-grained control over thread pool behavior.

---

#### **Creating Thread Pools with Executors**
The `Executors` utility class provides factory methods for creating thread pools:

1. **Fixed Thread Pool**:
    - A pool with a fixed number of threads.
   ```java
   ExecutorService fixedPool = Executors.newFixedThreadPool(5);
   ```

2. **Cached Thread Pool**:
    - A pool with an unlimited number of threads, reusing idle threads.
   ```java
   ExecutorService cachedPool = Executors.newCachedThreadPool();
   ```

3. **Single Thread Executor**:
    - A pool with only one thread.
   ```java
   ExecutorService singleThread = Executors.newSingleThreadExecutor();
   ```

4. **Scheduled Thread Pool**:
    - A pool for scheduling tasks.
   ```java
   ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);
   ```

---

#### **Submitting Tasks to Executor Framework**
1. **Runnable Tasks**:
   Runnable tasks are submitted using the `execute()` or `submit()` method.
   ```java
   ExecutorService executor = Executors.newFixedThreadPool(2);
   executor.execute(() -> System.out.println("Runnable Task Executed"));
   executor.shutdown();
   ```

2. **Callable Tasks**:
   Callable tasks return a result and can throw exceptions.
   ```java
   ExecutorService executor = Executors.newFixedThreadPool(2);
   Future<Integer> future = executor.submit(() -> 10 + 20);
   try {
       System.out.println("Result: " + future.get()); // Waits for the result
   } catch (Exception e) {
       e.printStackTrace();
   }
   executor.shutdown();
   ```

---

#### **Key Methods in Executor Framework**
1. **execute(Runnable command)**:
    - Executes the given task without returning a result.

2. **submit(Callable or Runnable)**:
    - Executes a task and returns a `Future` representing the result.

3. **shutdown()**:
    - Initiates a graceful shutdown, rejecting new tasks but allowing existing tasks to complete.

4. **shutdownNow()**:
    - Attempts to stop all tasks immediately.

5. **awaitTermination(timeout, unit)**:
    - Blocks until all tasks have completed or the timeout occurs.

---

#### **ThreadPoolExecutor: Advanced Configuration**
You can customize thread pools with the `ThreadPoolExecutor` class:
```java
ThreadPoolExecutor executor = new ThreadPoolExecutor(
    2, // Core pool size
    4, // Maximum pool size
    60, // Keep-alive time
    TimeUnit.SECONDS, // Time unit for keep-alive
    new LinkedBlockingQueue<>() // Task queue
);
```

---

#### **ScheduledExecutorService Example**
```java
import java.util.concurrent.*;

public class ScheduledExample {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Scheduled Task Executed at " + System.currentTimeMillis());
        }, 1, 2, TimeUnit.SECONDS); // Initial delay: 1 second, Period: 2 seconds
    }
}
```

---

#### **When to Use Thread Pooling and Executor Framework?**
1. **Thread Pooling**: For general multi-threading tasks where threads need to be reused.
2. **Executor Framework**: For more control over thread lifecycle, task scheduling, and advanced use cases like delayed or periodic tasks.

---

