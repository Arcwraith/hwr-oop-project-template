# Chess Game in Console

This repository contains a chess game made by students for a project.
It is created for an ongoing lecture on object-oriented programming with Java
at HWR Berlin (summer term 2022). 

⚠️ This code is for educational purpose only. Do not rely on it!

## Abstract

This chess game is played in the console. The figures are choosen
by typing in the correct coordinates and the chessfield is
updated after each move.

This chess game has no special rules meaning it has everything
except upgrading pawns when they reach the end of the chessfield and no checkmate.

Some difficulties were implementing Interfaces and also
differencing friendly from hostile figures.
## Feature List


| Number | Feature                                | Tests |
|--------|----------------------------------------|-------|
| 1      | chessfield                             | 79    |
| 2      | moves of the figures                   | 12    |
| 3      | capture enemy figures                  | 6     |

## Additional Dependencies


| Number | Dependency Name | Dependency Description | Why is it necessary?      |
|--------|----------------------------------------|-----|---------------------------|
| 1      | java.io.PrintStream                             | A PrintStream adds functionality to another output stream, namely the ability to print representations of various data values conveniently.    | for console output        |
| 2      | java.util.Scanner                  | A simple text scanner which can parse primitive types and strings using regular expressions.    | for reading console input |