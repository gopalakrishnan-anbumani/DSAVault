#Greedy Algorithm

* Solution is built piece by piece. Next piece offers the most obvious and immediate benefits
* Maximizes the profir & Minimizes the cost
* It means that locally optimal choice is made in the hope that it leads to a globally optimal solution

Example:
  1. Piggy bank have fixed weight. Value vs Weight problem

The greedy algorithm only has one shot to compute the optimal solution. It can never go back and reverse the decision. Hence, the algorithm makes greedy choices at each step to ensure that the objective function is optimized
optimized.

Find Shorted b/w 2 places -> Greedy approach might get failed due to consider best solution at each step.

A -> B = 10
A -> C = 15
B -> D = 50
C -> D = 5

Find shortest path A -> D. At 1st step comparing A to B & A to C. Greedy approach chose A->B bcs cost is 10. But after B it cost more. so Greedy approach sometimes fail.









