# Tic-Tac-Toe Engine

## Prompt

Build a Tic-Tac-Toe game engine. Start with a 3 x 3 board and two players, then support configurable board size `N` and win condition `K`.

## Core Requirements

- Create a game with board size `N` and win length `K`.
- Allow players to make moves by row and column.
- Reject invalid moves: out of bounds, occupied cell, game already finished.
- Detect win by row, column, diagonal, or anti-diagonal.
- Detect draw when board is full.
- Expose current winner or game state.

## Suggested API

```java
Game game = new Game(3, 3);
game.move(0, 0, Player.X);
game.move(1, 1, Player.O);
GameState state = game.state();
```

## Follow-Ups

- Support `N = 10`, `K = 5`.
- Return winning cells.
- Add undo.
- Add simple computer player.
- Prevent same player from moving twice.

## Validation Cases

- X wins a row.
- O wins a column.
- X wins main diagonal.
- O wins anti-diagonal.
- Full board with no winner is draw.
- Move outside board fails.
- Move on occupied cell fails.
- Move after game over fails.

## Design Signals

- Keep board state private.
- Separate `Game`, `Board`, `Player`, and `GameState` if useful.
- Avoid hardcoding 3 x 3 logic once `N` and `K` are required.
- State time complexity for winner checks.

