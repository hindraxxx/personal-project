# Graphs

## 1. Number Of Islands

Given a `grid` of `1`s and `0`s, count connected groups of land.

Practice:
- BFS and DFS versions.
- Mutating grid vs visited set.
- Empty grid edge case.

Expected pattern: grid DFS/BFS connected components.

## 2. Connected Components

Given `n` nodes and undirected edges, return the number of connected components.

```text
n = 5, edges = [[0,1],[1,2],[3,4]] -> 2
```

Expected pattern: adjacency list + BFS/DFS or union find.

## 3. Course Schedule

Given `numCourses` and prerequisites, return whether all courses can be completed.

```text
numCourses = 2, prerequisites = [[1,0]] -> true
numCourses = 2, prerequisites = [[1,0],[0,1]] -> false
```

Practice:
- DFS color states.
- Kahn topological sort.

Expected pattern: directed cycle detection.

## 4. Transaction Dependency Cycle

Transactions can depend on other transactions. Given pairs `[transaction, dependsOn]`, return whether the dependency graph contains a cycle.

Follow-ups:
- Return one cycle path.
- Return a valid processing order if no cycle exists.

Expected pattern: topological sort or DFS colors.

## 5. Shortest Payment Route

Given accounts as nodes and allowed payment rails as unweighted edges, return the minimum number of hops from source to destination.

Practice:
- Return `-1` if unreachable.
- Return actual path as follow-up.

Expected pattern: BFS shortest path.

## 6. Rotting Oranges

Given a grid with fresh and rotten oranges, return minutes until all fresh oranges rot, or `-1`.

Expected pattern: multi-source BFS.

