#### **Basic Concepts**
1. **What is the Java Collections Framework?**
    - A unified architecture for storing and manipulating groups of objects. It includes interfaces like `List`, `Set`, `Map`, and their implementations.

2. **Why use the Collections Framework?**
    - It provides reusable data structures and algorithms, reducing the need for custom code.


#### **List**
1. **What are the key differences between `ArrayList` and `LinkedList`?**
    - **`ArrayList`**:
        - Backed by a dynamic array.
        - Fast random access (O(1)).
        - Slow insertions/deletions (O(n)).
    - **`LinkedList`**:
        - Doubly linked list.
        - Slow random access (O(n)).
        - Fast insertions/deletions (O(1)) at the head/tail.

2. **When to use `Vector`?**
    - Use `Vector` when thread safety is needed. It’s synchronized but slower than `ArrayList`.


#### **Set**
1. **How does a `HashSet` work?**
    - Backed by a `HashMap`. Uses `hashCode()` to determine bucket placement and `equals()` to check for duplicates.

2. **What’s the difference between `HashSet` and `TreeSet`?**
    - **`HashSet`**:
        - Unordered.
        - Faster (O(1) for add, remove, contains).
    - **`TreeSet`**:
        - Sorted (natural or custom).
        - Slower (O(log n)).

3. **When to use `LinkedHashSet`?**
    - When you need a `Set` that maintains insertion order.


#### **Map**
1. **How does a `HashMap` handle collisions?**
    - Collisions are resolved using separate chaining. Each bucket stores a linked list (or tree in Java 8+).

2. **What is the difference between `HashMap` and `ConcurrentHashMap`?**
    - **`HashMap`**:
        - Not thread-safe.
        - Allows one `null` key.
    - **`ConcurrentHashMap`**:
        - Thread-safe.
        - Does not allow `null` keys or values.

3. **What’s the difference between `TreeMap` and `HashMap`?**
    - **`HashMap`**:
        - Unordered.
        - O(1) for most operations.
    - **`TreeMap`**:
        - Sorted by keys.
        - O(log n) for operations.


#### **Queue/Deque**
1. **What is a `PriorityQueue`?**
    - A queue where elements are dequeued based on priority (natural ordering or custom comparator).

2. **How does a `Deque` differ from a `Queue`?**
    - **`Queue`**: FIFO (First-In-First-Out).
    - **`Deque`**: Supports both FIFO and LIFO (Last-In-First-Out).
---

#### **Generics**
1. **Why use generics in collections?**
    - Ensures type safety at compile time.
    - Prevents `ClassCastException`.


#### **Advanced Topics**
1. **What is the time complexity of `HashMap` operations?**
    - O(1) for `put` and `get` in the average case. O(n) in the worst case (due to hash collisions).

2. **What is the difference between `Comparable` and `Comparator`?**
    - **`Comparable`**:
        - Defines natural ordering (implements `compareTo()`).
    - **`Comparator`**:
        - Defines custom ordering (implements `compare()`).

   **Example:**
   ```java
   class Employee implements Comparable<Employee> {
       int id;
       public int compareTo(Employee other) {
           return this.id - other.id;
       }
   }
   ```

---

#### **Edge Cases**
1. **What happens if you modify a collection while iterating over it?**
    - Throws `ConcurrentModificationException`.
    - To avoid it, use an **Iterator** or **Concurrent collection**.

2. **Can a `HashMap` have `null` keys?**
    - Yes, it allows one `null` key.

---

#### **Behavioral/Practical Questions**
1. **When would you use a `LinkedList` over an `ArrayList`?**
    - Use `LinkedList` when you have frequent insertions and deletions, especially at the beginning or middle of the list.

2. **When to use a `TreeMap`?**
    - Use a `TreeMap` when you need a sorted key-value store (e.g., for a leaderboard).

---

### **Common Use Cases with Answers**

1. **How would you remove duplicates from a list?**
    - Use a `HashSet` because it doesn’t allow duplicates.

   **Code Example:**
   ```java
   List<Integer> list = Arrays.asList(1, 2, 2, 3);
   Set<Integer> uniqueSet = new HashSet<>(list);
   System.out.println(uniqueSet); // Output: [1, 2, 3]
   ```

2. **How do you iterate over a `HashMap`?**
    - Using `for-each` with `entrySet()`.

   **Code Example:**
   ```java
   Map<String, Integer> map = new HashMap<>();
   map.put("A", 1);
   map.put("B", 2);
   for (Map.Entry<String, Integer> entry : map.entrySet()) {
       System.out.println(entry.getKey() + " = " + entry.getValue());
   }
   ```

3. **How would you implement a stack using `Deque`?**
    - Use `push()` and `pop()`.

   **Code Example:**
   ```java
   Deque<Integer> stack = new ArrayDeque<>();
   stack.push(1);
   stack.push(2);
   System.out.println(stack.pop()); // Output: 2
   ```

---

### **Quick Cheatsheet to Memorize**
1. **List**: Ordered, duplicates allowed.
2. **Set**: Unique elements, no duplicates.
3. **Map**: Key-value pairs, unique keys.
4. **Queue**: FIFO, task scheduling.
5. **Deque**: Both FIFO and LIFO support.

---

If you memorize this, you’ll have enough to confidently answer most interview questions on Java Collections. Once you’re done, let me know, and we can move on to mock questions or coding challenges!