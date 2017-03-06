# SudokuSolver
A Latin square is an n x n matrix in which every row and every column contains a rearrangement of all the elements of the set {1, 2, ..., n} For example, below is a 6 x 6 Latin square:

6 2 3 4 5 1
2 4 5 6 1 3
3 5 6 1 2 4
4 6 1 2 3 5
5 1 2 3 4 6
1 3 4 5 6 2

Similarly, to some other famous games, the Latin square puzzle is a partially filled n x n square which needs to be completed to the full square. For example, the puzzle on the left has a unique completion to the square on the right:

0 2 3 0 0 0          6 2 3 4 5 1
0 0 0 6 1 0          2 4 5 6 1 3
3 0 0 0 0 4          3 5 6 1 2 4
4 0 0 0 0 5 ----> 4 6 1 2 3 5
0 1 2 0 0 0          4 6 1 2 3 5
0 0 0 5 6 0          1 3 4 5 6 2


(0s denote the missing elements.) In this challenge, you are asked to devise an algorithm which given a partial Latin square completes it to a full one. Use the "backtracking" approach which simulates a run of the DFS algorithm on a suitable graph.
