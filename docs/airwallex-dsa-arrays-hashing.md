# Arrays, Hashing, Prefix Sum

## 1. Two Sum All Pairs

Given an array of integers and a target, return all unique index pairs whose values sum to the target.

```text
nums = [2, 7, 11, 15, -2, 9], target = 9
answer includes pairs for values (2, 7) and (-2, 11)
```

Practice:
- Handle duplicates.
- Decide whether returning indices or values is required.
- Explain why a hash map works.

Expected pattern: hash map from value to prior indices.

## 2. Subarray Sum Equals K

Given an integer array and integer `k`, return the number of continuous subarrays whose sum equals `k`.

```text
[1, 1, 1], k = 2 -> 2
[1, -1, 0], k = 0 -> 3
```

Practice:
- Negative numbers break sliding window.
- Use prefix sum frequency.

Expected pattern: prefix sum + hash map.

## 3. Maximum Subarray

Given an integer array, find the largest sum of any non-empty contiguous subarray.

```text
[-2,1,-3,4,-1,2,1,-5,4] -> 6
[-3,-2,-5] -> -2
```

Expected pattern: Kadane DP.

## 4. Reconcile Unmatched Records

You receive two transaction lists: bank records and internal ledger records. Each record has `id`, `amount`, and `timestamp`. Return matched IDs, bank-only records, ledger-only records, and same-ID records with mismatched amount.

Practice:
- Use maps, not nested loops.
- Define behavior for duplicate IDs.

Expected pattern: hash map reconciliation.

## 5. Duplicate Transaction IDs

Given a stream or list of transaction IDs, return all IDs seen more than once.

Follow-ups:
- Preserve first duplicate detection order.
- Support millions of IDs.
- Support streaming input.

Expected pattern: seen set + duplicate set.

