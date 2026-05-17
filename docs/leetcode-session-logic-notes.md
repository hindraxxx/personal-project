# LeetCode Session Logic Notes

Compact notes from the interview-practice walkthrough.

## Interview Flow

Use this order:

1. Restate problem.
2. Name pattern.
3. Explain brute force quickly.
4. Explain optimized idea.
5. Mention edge cases.
6. Give complexity.
7. Code.
8. Test with one example.

Strong habit: say the invariant.

- Sliding window: current window is valid.
- Islands: visited land will not be counted again.
- Two pointers: movement changes sum/area predictably.
- Linked list: keep the node before the target when rewiring.

## Data Structure Reminders

- `Queue`: FIFO. `poll()` removes front. `peek()` reads front only.
- `Stack`: LIFO. Good for reverse output.
- `Deque`: modern Java choice for stack/queue behavior.
- `PriorityQueue`: heap. `poll()` returns smallest by comparator, but iteration is not fully sorted.
- `ListNode`: problem-specific linked node, not Java `LinkedList`.
- `Arrays.sort(nums)`: sort primitive arrays.
- `Collections.sort(list)` or `list.sort(null)`: sort lists.
- `Arrays.asList(...)`: fixed-size list, allows `set`, no add/remove.
- `List.of(...)`: immutable, Java 9+, no nulls.
- Mutable list: `new ArrayList<>(Arrays.asList(...))`.

## 1. Add Two Numbers

Pattern: linked list traversal + carry.

Key idea:

- Lists are already reversed.
- `2 -> 4 -> 3` means `342`.
- Process from head to tail.
- Append result digit directly.

Formula:

```text
sum = val1 + val2 + carry
digit = sum % 10
carry = sum / 10
```

Result for `342 + 465 = 807`:

```text
7 -> 0 -> 8
```

Do not use queue/stack unless problem order differs. Return `ListNode`.

## 2. Number Of Islands

Pattern: grid DFS/BFS connected components.

Your shadow array idea is valid: it is a visited matrix.

Correct rule:

- Scan every cell.
- If cell is land and not visited: count one island.
- DFS/BFS marks whole connected island visited.
- Do not skip entire row/column. Only skip visited cells.

Non-recursive improvement:

- Use BFS queue or iterative DFS stack.
- Same complexity.

Complexity:

```text
Time: O(rows * cols)
Space: O(rows * cols) worst case
```

## 3. Longest Substring Without Repeating Characters

Pattern: sliding window + set.

Correction:

- Do not break on duplicate.
- Shrink from the left until duplicate removed.

Invariant:

```text
window always contains unique characters
```

Movement:

```text
while current char is in set:
  remove s[left]
  left++

add current char
update max
```

For `"abcc"`, second `c` removes `a`, then `b`, then old `c`.

## 4. Median Of Two Sorted Arrays

Simple merge idea is correct behavior.

Odd length:

```text
len = 13
mid = len / 2 = 6
answer = arr[6]
```

Even length:

```text
len = 14
mid = 7
answer = (arr[6] + arr[7]) / 2.0
```

Formula:

```java
(arr[len / 2 - 1] + arr[len / 2]) / 2.0
```

Merge solution:

```text
Time: O(m + n)
Space: O(m + n)
```

Optimal expected hard solution: binary search partition, `O(log(m+n))`.

## 5. Longest Palindromic Substring

Pattern: expand around center.

Not sliding window. Palindrome validity is about symmetry, not monotonic movement.

Check both center types:

```text
odd:  expand(i, i)
even: expand(i, i + 1)
```

Odd/even refers to palindrome substring length, not whole string length.

Example:

```text
abcaaaacbasdfkjsdf
```

Best palindrome:

```text
abcaaaacba
```

Center is between index `4` and `5`.

Why try every index:

- We do not know best center beforehand.
- For every `i`, test odd and even expansion.

Complexity:

```text
Time: O(n^2)
Space: O(1)
```

## 6. Zigzag Conversion

Pattern: simulation.

Your hunch was correct:

- Move down rows.
- At bottom, move upward diagonally.
- Repeat.

No full 2D grid needed. Use one `StringBuilder` per row.

Row pattern for `numRows = 4`:

```text
0 -> 1 -> 2 -> 3 -> 2 -> 1 -> 0 ...
```

Complexity:

```text
Time: O(n)
Space: O(n)
```

## 7. Reverse Integer

String/stack approach can work, but interview-preferred is math.

Important:

- Stack is LIFO, not FIFO.
- `120` reversed becomes `21`; leading zero ignored.
- Must handle 32-bit overflow.

Math pattern:

```text
digit = x % 10
result = result * 10 + digit
x = x / 10
```

Overflow range:

```text
-2147483648 to 2147483647
```

Return `0` if reversed value overflows.

## 8. String To Integer Atoi

Pattern: parsing state machine / left-to-right accumulation.

Correct order:

1. Skip leading spaces.
2. Read optional sign.
3. Read continuous digits until non-digit.
4. Build result.
5. Clamp overflow.

Your back-processing idea can work only after extracting valid digit substring first. But overflow handling is harder.

Preferred accumulation:

```text
result = result * 10 + digit
```

Leading zeroes need no special case.

## 9. Regular Expression Matching

Pattern: DP.

Special chars:

- `.` matches any single char.
- `*` matches zero or more of previous char.

State:

```text
dp[i][j] = whether s[0..i-1] matches p[0..j-1]
```

Star choices:

```text
zero occurrence: dp[i][j - 2]
one or more:     dp[i - 1][j], if previous pattern char matches current string char
```

Complexity:

```text
Time: O(m * n)
Space: O(m * n)
```

## 10. Container With Most Water

Pattern: two pointers.

Use:

```text
left = 0
right = n - 1
```

Area:

```text
width = right - left
height = min(height[left], height[right])
area = width * height
```

Movement:

```text
if height[left] < height[right]:
  left++
else:
  right--
```

Reason:

- Smaller wall limits area.
- Moving taller wall only shrinks width without fixing bottleneck.

## 11. Integer To Roman

Pattern: greedy.

Use descending value-symbol pairs:

```text
1000 M
900  CM
500  D
400  CD
100  C
90   XC
50   L
40   XL
10   X
9    IX
5    V
4    IV
1    I
```

Loop:

```text
while num >= value:
  append symbol
  num -= value
```

Use arrays, not `HashMap`, because order matters.

Example:

```text
3749 = MMMDCCXLIX
```

## 12. 3Sum

Pattern: sort + two pointers.

Not DP. Combination-looking does not always mean DP.

Flow:

```text
sort nums
for each i:
  skip duplicate i
  left = i + 1
  right = n - 1
  while left < right:
    sum = nums[i] + nums[left] + nums[right]
```

Movement:

```text
sum < 0: left++
sum > 0: right--
sum == 0: save, move both, skip duplicates
```

Why not always `left++`:

- `left++` increases sum.
- If sum is already too big, it gets worse.

Complexity:

```text
Time: O(n^2)
Space: O(1) extra, ignoring output
```

## 13. 3Sum Closest

Pattern: sort + two pointers + closest tracking.

Same as 3Sum, but store best sum.

Track:

```text
bestSum
bestDiff = abs(target - bestSum)
```

Each step:

```text
sum = nums[i] + nums[left] + nums[right]
currentDiff = abs(target - sum)
if currentDiff < bestDiff: update
```

Movement:

```text
sum < target: left++
sum > target: right--
sum == target: return sum
```

## 14. Letter Combinations Of A Phone Number

Pattern: backtracking or BFS-style level build.

Tree is mental model. Do not build actual tree.

Mapping:

```text
2 abc
3 def
4 ghi
5 jkl
6 mno
7 pqrs
8 tuv
9 wxyz
```

Backtracking state:

```text
index = current digit
path = current letters
result = completed combinations
```

Style 2, iterative build:

```text
result = [""]
for each digit:
  nextResult = []
  for current in result:
    for letter in mapped letters:
      nextResult.add(current + letter)
  result = nextResult
```

Because length max is small, this is fine.

## 15. 4Sum

Pattern: sort + two fixed loops + two pointers.

Not three moving pointers.

Flow:

```text
sort
for i:
  skip duplicate i
  for j:
    skip duplicate j
    left = j + 1
    right = n - 1
```

Sum:

```text
nums[i] + nums[j] + nums[left] + nums[right]
```

Movement:

```text
sum < target: left++
sum > target: right--
sum == target: save, move both, skip duplicates
```

Use `long` for sum to avoid overflow.

Complexity:

```text
Time: O(n^3)
```

## 16. Remove Nth Node From End Of List

Your length idea is correct. No map needed.

Two-pass:

1. Count length.
2. Target from front is `length + 1 - n` using 1-based index.
3. Stop at node before target.
4. Remove with:

```java
prev.next = prev.next.next;
```

Use dummy node to handle removing head.

Optimal one-pass:

- Move fast `n` steps ahead.
- Move fast and slow together.
- When fast reaches end, slow is before target.

## 17. Generate Parentheses

Pattern: backtracking.

Core rules:

```text
open < n       => can add "("
close < open   => can add ")"
```

Cannot close first because nothing is open.

State:

```text
current string
open count
close count
```

Stop:

```text
current.length() == 2 * n
```

No `Set` needed. Each decision path creates one unique string.

## 18. Merge K Sorted Lists

Three approaches:

### Collect, Sort, Rebuild

Easiest.

```text
collect all values
sort
build new linked list
```

Complexity:

```text
Time: O(N log N)
Space: O(N)
```

Fine brute force, weak interview final answer.

### Priority Queue / Min Heap

Better.

```text
put each list head into heap
poll smallest
append to result
if popped node has next, offer next
```

Comparator:

```java
Integer.compare(a.val, b.val)
```

Complexity:

```text
Time: O(N log k)
Space: O(k)
```

### Divide And Conquer

Merge lists in pairs using `mergeTwoLists`.

Complexity:

```text
Time: O(N log k)
Space: O(1) extra, ignoring recursion
```

## 19. Swap Nodes In Pairs

Pattern: linked list pointer rewiring + dummy.

Your initial swap worked for one isolated pair, but missed connection from previous pair.

Need `prev`:

```text
prev -> first -> second -> nextPair
```

Rewire:

```java
first.next = nextPair;
second.next = first;
prev.next = second;
prev = first;
```

Dummy exists so first pair also has a `prev`.

Key linked-list rule:

- `node = node.next` changes local reference only.
- `prev.next = something` changes the list.

## 20. Reverse Nodes In K Group

Pattern: linked list group reversal.

Your stack idea works better if pushing `ListNode` objects, not values.

Value rebuild is not preferred because problem wants node links changed.

Stack-node version:

```text
take k nodes
if fewer than k: leave unchanged
push nodes
pop and reconnect
```

Space:

```text
O(k)
```

Pointer reversal version is optimal:

```text
dummy -> group
groupPrev = node before group
kth = kth node after groupPrev
groupNext = kth.next
```

Reverse loop:

```java
prev = groupNext;
current = groupPrev.next;

while (current != groupNext) {
    temp = current.next;
    current.next = prev;
    prev = current;
    current = temp;
}
```

Why `temp` first:

- Reversal temporarily breaks the chain.
- `temp` preserves the original next node.

Example:

```text
1 -> 2 -> 3 -> 4 -> 5, k = 3
```

During step 1:

```text
1 -> 4 -> 5
2 -> 3 -> 4 -> 5
```

This is safe because `current = 2` was saved in `temp`.

Final:

```text
3 -> 2 -> 1 -> 4 -> 5
```

## Pattern Cheat Sheet

- Linked list carry: Add Two Numbers.
- Grid components: Number Of Islands.
- Sliding window + set: Longest Substring Without Repeat.
- Expand around center: Longest Palindromic Substring.
- Simulation: Zigzag Conversion.
- Math digits + overflow: Reverse Integer.
- Parsing: Atoi.
- DP: Regex Matching.
- Two pointers from ends: Container With Most Water.
- Greedy descending values: Integer To Roman.
- Sort + two pointers: 3Sum, 3Sum Closest.
- Sort + fixed loops + two pointers: 4Sum.
- Backtracking: Letter Combinations, Generate Parentheses.
- Heap: Merge K Sorted Lists.
- Dummy + prev pointer: Swap Pairs, Remove Nth Node.
- Group pointer reversal: Reverse Nodes In K Group.

