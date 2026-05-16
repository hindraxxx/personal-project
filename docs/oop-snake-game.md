# Snake Game

## Prompt

Build a Snake game engine. The snake moves on a grid, eats food, grows, and dies when it hits a wall or itself.

## Core Requirements

- Initialize board width, height, initial snake position, and food list.
- Move snake one step in a elevatorDirection.
- Return current score after each move.
- Return game over when snake hits wall or itself.
- Grow snake when it eats food.
- Move normally by adding a new head and removing the tail.

## Suggested API

```java
SnakeGame game = new SnakeGame(3, 2, List.of(new Point(1, 2)));
int score = game.move(Direction.RIGHT);
boolean over = game.isGameOver();
```

## Follow-Ups

- Reject reversing elevatorDirection directly.
- Generate random food.
- Support obstacles.
- Return snake body for rendering.
- Support multiple snakes.

## Validation Cases

- Normal move keeps same length.
- Eating food increases score and length.
- Moving into wall ends game.
- Moving into body ends game.
- Moving into the old tail position is allowed when tail moves away.
- Food appears in order.

## Design Signals

- Use deque for snake body.
- Use set for occupied cells.
- Be careful with tail removal before self-collision check.
- Keep rendering/input outside engine.

