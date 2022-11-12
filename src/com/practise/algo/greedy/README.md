#Greedy Algorithm

* Solution is built piece by piece. Next piece offers the most obvious and immediate benefits
* Maximizes the profit & Minimizes the cost
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

#FreeCodeCamp - Video - [https://www.youtube.com/watch?v=bC7o8P_Ste4&t=536s] ##Start

Example Maximize the Gold:
  You are in a center of a grid. You can move to any direction (UP, DOWN, LEFT, RIGHT). You collect gold from that grid. Before making the step you get to know the value of next grid has.
    Rules:
        1. can move any direction
        2. Once path is taken. No Going back
        3. Game ends when no more steps can ba taken.
        
    We can choose next grid based on the gold value it has. Once choosed the max gold grid, we can next grid Gold value. 
    So gold value reveal step by step. So collecting the gold step by step based on max gold values. Sometimes we can collect more gold. Sometimes another path will have more gold values.
    
![image](https://user-images.githubusercontent.com/17019723/201487143-f5940233-6c5b-4165-9ab8-5f1911bedea8.png)

    
                                    









