# Dynamic Programming

## 1. Climbing Stairs Variants

You can climb 1 or 2 steps. Return number of ways to reach `n`.

Follow-ups:
- Steps can be `[1,3,5]`.
- Each step has a cost; minimize total cost.
- Some steps are blocked.

Expected pattern: one-dimensional DP.

## 2. Coin Change

Given coin denominations and an amount, return the minimum number of coins needed, or `-1`.

```text
coins = [1,2,5], amount = 11 -> 3
coins = [2], amount = 3 -> -1
```

Expected pattern: unbounded knapsack DP.

## 3. Grid Unique Paths With Blocks

Given a grid with blocked cells, count unique paths from top-left to bottom-right moving only right or down.

Expected pattern: two-dimensional DP.

## 4. Longest Increasing Subsequence

Given an integer array, return the length of the longest strictly increasing subsequence.

Practice:
- O(n^2) DP first.
- O(n log n) tails method follow-up.

Expected pattern: sequence DP or binary search tails.

## 5. Edit Distance Lite

Given two strings, return minimum insert/delete operations to make them equal.

Expected pattern: string DP using longest common subsequence or edit DP.

