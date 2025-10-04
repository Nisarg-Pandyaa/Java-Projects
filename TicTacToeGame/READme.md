# ❌⭕ Tic Tac Toe Game (Java)

A **2-player console-based Tic Tac Toe game** written in Java using **IntelliJ IDEA**.  
This version includes **custom player sides**, **score tracking**, **replay functionality**,  
and clear board visualization for each round.

---

## 🧠 Game Overview
Two players take turns placing 'X' and 'O' on a 3×3 grid.  
The first player to align three marks horizontally, vertically, or diagonally wins the round.  
The game keeps track of total wins for both players and the number of draws.

---

## 🕹️ Gameplay Flow
1. The first player chooses `'X'` or `'O'`.  
   The second player automatically gets the other symbol.
2. Players enter coordinates (row and column) [0-Based Index] to make a move.
3. The board updates after every turn.
4. The game detects:
   - **Win condition** — 3 in a row, column, or diagonal.
   - **Draw condition** — Board is full and no winner.
5. After each match:
   - The **scoreboard** displays total wins and draws.
   - Players can choose to **play again** or **end** the game.

---

## 💡 Features
- Console-based interactive gameplay.
- Customizable side selection ('X' or 'O').
- Automatic scoreboard tracking for multiple rounds.
- Input validation for invalid or repeated moves.
- Clean, modular, single-class implementation.

---
