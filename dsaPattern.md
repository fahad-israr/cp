- If the given input is sorted, we can use binary search or the two pointer strategy to work out the solution.
- If the problem deals with the top/min/max/closest K elements among given n elements, use a heap to simplify it.
- When you need to try out all combinations( or permutations) of the input (given the constraints are low and suitable enough), use either the Recursive Backtracking algorithm or the Iterative BFS algorithm.
- Most of the problems related to trees and graphs could be solved either through a DFS or BFS approach.
- Every recursive solution can be converted to an iterative solution using stacks.
- If for a problem there exists a brute force solution in O(n^2) time complexity and constant space, then following two can also exist:
    1. Using a hashmap or a set for O(n) time and O(n) space.
    2. Using sorting for O(nlogn) time and constant space.
- When you have to optimize the solution with problems that could be divided into smaller subproblems, use a DP approach.
- Many optimization problems also demand the knowledge of Binary Search algorithm. So if it occurs to you intuitively, you can surely crack the code within a few mins. Some typical examples include dealing with min/max/at least/at most/largest min/smallest max etc.
- If we need to find some common substring among a set of strings, use a hashmap or a trie(prefix tree)
- When there is a need to search among a bunch of strings, Trie will be the best data structure.
- If problem involves a linked list and we can't use extra space, then usually its related to reversing some part of it or using a Fast and Slow pointer (Hare and Tortoise).
- If O(n) time and O(n) space is to be reduced to O(n) time and constant space, try incorporating the two pointer method.