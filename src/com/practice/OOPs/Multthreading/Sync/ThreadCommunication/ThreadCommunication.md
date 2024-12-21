This program demonstrates **thread communication** using **wait-notify mechanisms** in Java. The producer thread produces data and the consumer thread consumes it, with both synchronizing through a shared resource (`SharedResource`).

Here’s a step-by-step explanation:

---

### **1. Main Method Execution**
The `main` method:
1. Creates an instance of `SharedResource`.
2. Initializes `producerThread` with a `Producer` that works on the shared resource.
3. Initializes `consumerThread` with a `Consumer` that works on the same shared resource.
4. Starts both threads using the `start()` method.

When `start()` is called, the JVM starts executing the `run()` methods of the `Producer` and `Consumer` concurrently in separate threads.

---

### **2. Producer Thread Execution**
- The `run()` method of the `Producer` class loops 10 times (`for (int i = 0; i < 10; i++)`).
- It calls the `produce()` method of `SharedResource` with the current value of `i`.

#### **SharedResource produce() Execution**
- The `produce()` method is `synchronized`, ensuring only one thread (producer or consumer) accesses it at a time.
- The producer:
    1. **Waits if data is already produced** (`while (hasData)`).
        - Calls `wait()` to release the lock and let the consumer thread take over.
    2. **Produces data**:
        - Sets `data = value`.
        - Sets `hasData = true`.
        - Prints `Produced: value`.
    3. **Notifies waiting threads** (the consumer) using `notify()`.

---

### **3. Consumer Thread Execution**
- The `run()` method of the `Consumer` class loops 10 times (`for (int i = 0; i < 10; i++)`).
- It calls the `consume()` method of `SharedResource`.

#### **SharedResource consume() Execution**
- The `consume()` method is also `synchronized`.
- The consumer:
    1. **Waits if no data is available to consume** (`while (!hasData)`):
        - Calls `wait()` to release the lock and wait for the producer to produce data.
    2. **Consumes data**:
        - Sets `hasData = false`.
        - Prints `Consumed: data`.
    3. **Notifies waiting threads** (the producer) using `notify()`.

---

### **4. Thread Communication Using `wait` and `notify`**
- **Producer Thread**:
    - Produces data.
    - Calls `notify()`, waking up the consumer thread.
    - Goes back to waiting (`wait()`) if `hasData` is true.
- **Consumer Thread**:
    - Consumes data.
    - Calls `notify()`, waking up the producer thread.
    - Goes back to waiting (`wait()`) if `hasData` is false.

This back-and-forth communication ensures synchronization:
- The producer waits until the consumer consumes.
- The consumer waits until the producer produces.

---

### **Execution Flow Example**
1. Both threads start:
    - Producer calls `produce(0)`.
    - Consumer tries to `consume()` but waits as `hasData` is initially `false`.

2. Producer produces `0`:
    - Sets `data = 0`, `hasData = true`.
    - Prints "Produced: 0".
    - Calls `notify()`.
    - Waits (`wait()`).

3. Consumer wakes up:
    - Consumes `0`.
    - Sets `hasData = false`.
    - Prints "Consumed: 0".
    - Calls `notify()`.
    - Waits (`wait()`).

4. Producer wakes up:
    - Produces `1`.
    - Sets `data = 1`, `hasData = true`.
    - Prints "Produced: 1".
    - Calls `notify()`.
    - Waits (`wait()`).

This process continues until all 10 items are produced and consumed.

---

### **Key Concepts**
- **Synchronization**: Ensures only one thread accesses critical sections of code.
- **wait()**: Makes the current thread release the lock and wait until another thread calls `notify()`.
- **notify()**: Wakes up a single waiting thread.
- **Race Conditions Avoided**: The `while` loops in `produce()` and `consume()` ensure that threads re-check conditions after waking up to avoid race conditions.

### **Output Example**
```
Produced: 0
Consumed: 0
Produced: 1
Consumed: 1
Produced: 2
Consumed: 2
...
Produced: 9
Consumed: 9
```

Each `Produced` message is immediately followed by a corresponding `Consumed` message because of the synchronized communication between the threads.