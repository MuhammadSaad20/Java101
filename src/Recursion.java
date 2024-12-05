public class Recursion {

    // Recursive method to calculate factorial
    public static int factorialRecursive(int n) {
        // Input validation
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }

        // Base case
        if (n == 0 || n == 1) {
            return 1;
        }

        // Recursive case
        return factorialRecursive(n - 1) * n;
    }

    // Iterative method to calculate factorial
    public static int factorialIterative(int n) {
        // Input validation
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        int result = 1;
        for (int i = 2; i <= n; i++) { // Start from 2, as multiplying by 1 is redundant
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 6;

        // Test factorial using recursion
        System.out.println("Recursive Factorial of " + n + ": " + factorialRecursive(n));

        // Test factorial using iteration
        System.out.println("Iterative Factorial of " + n + ": " + factorialIterative(n));
    }
}



/*

In terms of performance, **iterative approaches** generally run faster than
**recursive approaches**, especially in a language like Java. Here's why, with a breakdown of the key factors:


1. Overhead of Function Calls in Recursion
- **Recursive Approach**: Each recursive call creates a new **stack frame** in the call stack. This involves:

  1. Saving the current state of the function.
  2. Allocating memory for function arguments and local variables.
  3. Returning to the previous state after the recursion completes.

- **Iterative Approach**: Iterative solutions avoid this overhead by using a single loop that runs within the same stack frame.

Impact:
- Recursive calls introduce additional overhead in terms of memory and CPU time, making recursion slower than iteration.


2. Risk of Stack Overflow**
- **Recursive Approach**: In Java, the stack has a fixed size (default is often 1 MB). If recursion depth exceeds this limit, it throws a `StackOverflowError`. For large inputs, recursion can fail.
- **Iterative Approach**: Iterative methods don't use the stack for intermediate results, so they can handle much larger input sizes without crashing.


3. Function Call Optimizations**
- **Tail-Recursion**: In some languages, compilers optimize certain recursive calls (tail-recursion) into iteration-like performance. However, Java does **not** perform tail-recursion optimization, meaning recursion remains less efficient compared to iteration.


4. Memory Usage

- **Recursive Approach**: Every recursive call requires memory for a new stack frame. The memory usage grows linearly with the depth of recursion.
- **Iterative Approach**: Memory usage remains constant (apart from the variables used within the loop).


5. Readability and Maintainability
- While recursion may sometimes be more elegant and concise for problems like tree traversals, **performance should take precedence** when dealing with large inputs or tight computational requirements. Iterative solutions are more predictable and efficient.




Performance Comparison**

| **Aspect**            | **Recursive Approach**                         | **Iterative Approach**                          |
|------------------------|------------------------------------------------|------------------------------------------------|
| **Speed**             | Slower (overhead of stack management)          | Faster (no stack management overhead)          |
| **Memory Usage**      | Higher (stack grows with recursion depth)       | Lower (constant memory usage)                  |
| **Risk of Failure**   | StackOverflowError for large inputs            | No such risk                                   |
| **Code Elegance**     | Sometimes simpler for certain problems         | Longer, but easier to optimize                 |


Why Iterative is Faster
1. **No function call overhead**: Iterative loops don't require repeated stack frame creation and destruction.
2. **Efficient resource usage**: The loop runs in a single stack frame with minimal memory.
3. **Predictable behavior**: Iterative solutions scale better for large inputs because they don't depend on the limited call stack size.


When to Use Recursion
1. **Elegant Problem Representation**:
   - Problems that naturally decompose into smaller subproblems (e.g., tree traversal, divide-and-conquer).
2. **Readability and Simplicity**:
   - For small input sizes or scenarios where recursion makes the logic clearer.
3. **Memory is not a constraint**:
   - When the recursion depth is small and stack usage is manageable.


Conclusion
For most cases where **performance** is critical, **iterative approaches** are faster and more memory-efficient than recursion.
However, recursion can still be a good choice when clarity or problem representation outweighs raw performance.

*/