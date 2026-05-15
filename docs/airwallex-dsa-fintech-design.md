# Fintech And Design Variants

## 1. LRU Cache

Design an LRU cache with `get(key)` and `put(key, value)` in O(1).

Practice:
- Update existing key.
- Evict least recently used when capacity exceeded.
- Capacity 1.

Expected pattern: hash map + doubly linked list.

## 2. Account Balance Processor

Given ledger entries `(accountId, delta, timestamp)`, compute final balances and flag accounts that ever go negative.

Follow-ups:
- Entries may arrive out of order.
- Need balance at arbitrary timestamp.
- Need idempotency by transaction ID.

Expected pattern: sorting + maps; clarify invariants.

## 3. Payment Idempotency Cache

Design a small in-memory idempotency layer. Given request IDs and responses, return cached response for repeated IDs and evict old entries.

Expected pattern: hash map + TTL or LRU, depending on requirement.

## 4. Practical Variant Checklist

Be ready to adapt core patterns to:
- Detect cycles in transaction dependency graph.
- Reconcile unmatched records using hash maps.
- Rate-limit events over time windows.
- Find duplicate transaction IDs.
- Process ledger/account balances safely.
- Design an LRU/cache-like structure.

