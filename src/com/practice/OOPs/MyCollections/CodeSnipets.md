### **1. List Interface**
Used when you need an ordered collection that allows duplicates.

#### **Common Implementations**: `ArrayList`, `LinkedList`, `Vector`

**Code Example:**
```java
import java.util.*;

public class ListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(); // Use LinkedList or Vector similarly
        list.add("A");        // Adds an element
        list.add("B");
        list.add("A");        // Duplicates allowed
        list.add(1, "C");     // Inserts at index 1

        System.out.println(list);  // Output: [A, C, B, A]

        list.remove("A");     // Removes the first occurrence
        System.out.println(list);  // Output: [C, B, A]

        String element = list.get(0);  // Access by index
        System.out.println("First Element: " + element);

        System.out.println("Contains B? " + list.contains("B")); // Check if element exists

        list.sort(Comparator.naturalOrder()); // Sort the list
        System.out.println("Sorted List: " + list);
    }
}
```

---

### **2. Set Interface**
Used when you need a collection with no duplicate elements.

#### **Common Implementations**: `HashSet`, `LinkedHashSet`, `TreeSet`

**Code Example:**
```java
import java.util.*;

public class SetDemo {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>(); // Use LinkedHashSet or TreeSet similarly
        set.add("A");
        set.add("B");
        set.add("A");  // Duplicate will not be added

        System.out.println(set);  // Output: [A, B] (Order is not guaranteed)

        set.remove("A");
        System.out.println(set);  // Output: [B]

        System.out.println("Contains B? " + set.contains("B")); // Check if element exists
    }
}
```

---

### **3. Map Interface**
Used for storing key-value pairs.

#### **Common Implementations**: `HashMap`, `LinkedHashMap`, `TreeMap`

**Code Example:**
```java
import java.util.*;

public class MapDemo {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>(); // Use LinkedHashMap or TreeMap similarly
        map.put(1, "A");
        map.put(2, "B");
        map.put(1, "C");  // Overwrites value for key 1

        System.out.println(map);  // Output: {1=C, 2=B}

        map.remove(2);  // Removes entry with key 2
        System.out.println(map);  // Output: {1=C}

        System.out.println("Key 1 exists? " + map.containsKey(1)); // Check key
        System.out.println("Value 'C' exists? " + map.containsValue("C")); // Check value

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
```

---

### **4. Queue Interface**
Used for FIFO (First-In-First-Out) operations.

#### **Common Implementations**: `LinkedList`, `PriorityQueue`

**Code Example:**
```java
import java.util.*;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>(); // PriorityQueue works similarly
        queue.add("A");    // Adds an element
        queue.add("B");
        queue.add("C");

        System.out.println(queue);  // Output: [A, B, C]

        System.out.println("Peek: " + queue.peek());  // Retrieves head without removing

        System.out.println("Poll: " + queue.poll());  // Retrieves and removes head
        System.out.println(queue);  // Output: [B, C]
    }
}
```

---

### **5. Deque Interface**
Used for both FIFO and LIFO operations.

#### **Common Implementations**: `ArrayDeque`

**Code Example:**
```java
import java.util.*;

public class DequeDemo {
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("A");  // Adds to the front
        deque.addLast("B");   // Adds to the back

        System.out.println(deque);  // Output: [A, B]

        System.out.println("Remove First: " + deque.removeFirst()); // Removes from front
        System.out.println(deque);  // Output: [B]

        deque.push("C");  // Push (LIFO)
        System.out.println(deque);  // Output: [C, B]

        System.out.println("Pop: " + deque.pop());  // Removes from top
        System.out.println(deque);  // Output: [B]
    }
}
```

---

### **6. Utility Methods in `Collections`**
Common methods to manipulate collections.

**Code Example:**
```java
import java.util.*;

public class CollectionsDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        Collections.reverse(list);  // Reverse the list
        System.out.println("Reversed: " + list);

        Collections.shuffle(list);  // Shuffle the list
        System.out.println("Shuffled: " + list);

        int max = Collections.max(list);  // Get the max element
        System.out.println("Max: " + max);

        int min = Collections.min(list);  // Get the min element
        System.out.println("Min: " + min);

        Collections.sort(list);  // Sort the list
        System.out.println("Sorted: " + list);

        Collections.swap(list, 0, 1);  // Swap two elements
        System.out.println("After Swap: " + list);
    }
}
```

---

### **7. Stream API for Collections**
Simplifies operations like filtering, sorting, and mapping.

**Code Example:**
```java
import java.util.*;
import java.util.stream.*;

public class StreamDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Apple", "Banana", "Cherry", "Apple");

        // Filter elements
        List<String> filtered = list.stream()
                                    .filter(e -> e.startsWith("A"))
                                    .collect(Collectors.toList());
        System.out.println("Filtered: " + filtered);  // Output: [Apple, Apple]

        // Remove duplicates
        List<String> distinct = list.stream()
                                    .distinct()
                                    .collect(Collectors.toList());
        System.out.println("Distinct: " + distinct);  // Output: [Apple, Banana, Cherry]

        // Sort elements
        List<String> sorted = list.stream()
                                  .sorted()
                                  .collect(Collectors.toList());
        System.out.println("Sorted: " + sorted);  // Output: [Apple, Apple, Banana, Cherry]
    }
}
```

---

### **Quick Reference Table**

| **Interface** | **Implementation**     | **Key Methods**                  |
|---------------|-------------------------|-----------------------------------|
| List          | ArrayList, LinkedList  | `add()`, `remove()`, `get()`, `sort()` |
| Set           | HashSet, TreeSet       | `add()`, `remove()`, `contains()` |
| Map           | HashMap, TreeMap       | `put()`, `get()`, `remove()`, `entrySet()` |
| Queue         | LinkedList, PriorityQueue | `add()`, `poll()`, `peek()`       |
| Deque         | ArrayDeque             | `addFirst()`, `addLast()`, `pop()`, `push()` |

