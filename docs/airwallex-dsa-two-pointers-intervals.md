# Two Pointers And Intervals

## 1. Sorted Two Sum

Given a sorted array and target, return whether two numbers sum to target.

Expected pattern: left/right pointers.

## 2. Merge Intervals

Given a list of intervals, merge overlapping intervals.

```text
[[1,3],[2,6],[8,10],[15,18]] -> [[1,6],[8,10],[15,18]]
```

Practice:
- Sort by start.
- Clarify whether touching intervals merge: `[1,2]` and `[2,3]`.

Expected pattern: sort + scan.

## 3. Trapping Rain Water

Given bar heights, compute trapped water.

```text
[0,1,0,2,1,0,1,3,2,1,2,1] -> 6
```

Expected pattern: two pointers with left/right max.

