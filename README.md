## RandomKing

For my senior thesis at Middlebury College, I wrote a paper on Cover Times of Random Walks, and Pólya's Recurrence Theorem. As part of the project. I decided to run a simulation on how many random moves it would take for a King, if randomly placed on an empty chessboard, to reach every tile on the entire board. We can view the king's moves as random steps along a connected graph, and the time it took as the cover time of the graph.

## Results

In a simulation of 1 million trials, I found the king to have a mean cover time of 615 moves. Out of curiousity, I created a Knight class that also extended from the piece class, and ran the same simulation. Surprisingly, a knight covers the board in less moves on average - 565 moves.

I might decide to add a Queen class as well, but for the purposes of my thesis, I'm ok with these two simulations for now. The user can change the static variables trials and dims to change the number of trials in the simulation and the dimensions of the chessboard, respectively.  
