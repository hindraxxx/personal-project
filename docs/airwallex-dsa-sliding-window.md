# Sliding Window

## 1. Longest Substring Without Repeating Characters

Given a string, return the length of the longest substring without repeated characters.

```text
"abcabcbb" -> 3
"bbbbb" -> 1
"pwwkew" -> 3
```

Expected pattern: variable sliding window + last seen index.

## 2. Minimum Window Substring

Given strings `s` and `t`, return the smallest substring of `s` containing all characters of `t`.

```text
s = "ADOBECODEBANC", t = "ABC" -> "BANC"
```

Practice:
- Track required character counts.
- Shrink only when valid.

Expected pattern: variable sliding window + frequency map.

## 3. Fixed Window Max Sum

Given an integer array and `k`, return the maximum sum of any contiguous window of size `k`.

```text
[2,1,5,1,3,2], k = 3 -> 9
```

Expected pattern: fixed sliding window.

## 4. Rate Limit Events

Given event timestamps in seconds and a limit `N` per `W` seconds, return which events are accepted.

```text
timestamps = [1,2,3,10,11], limit = 3, window = 10
accepted = [true,true,true,false,true]
```

Practice:
- Clarify inclusive/exclusive window boundary.
- Use queue/deque of active timestamps.

Expected pattern: sliding time window.

