# Memory-Allocation-Methods
 Program in JAVA to implement three Memory Allocation Methods: FF,BF,WF. This program should read data about the processes from “Minput.data” and produce the memory allocations for new processes in 3 files: “FFoutput.data”, “BFoutput.data” , and “WFoutput.data” 


Memory Management:
			The memory management potion of the operating System is responsible for efficient usage of main memory. The memory management portion of the Operating System is responsible for the efficient usage of main memory, especially in a multiprogramming environment where processes contend for memory.
 It must also offer protection of one process address space from another (including protection of system address space from user processes). 
The memory subsystem should also provide programmers with a convenient logical or virtual address space, in which the low-level details of memory management are hidden.
In Operating systems, there are some common memory management techniques.
1.	Fetch Strategy: Determine when to load and how much to load at a time. E.g., demand fetching, anticipated fetching (prefetching).
2.	Placement (or allocation) Strategy: Determine where information is to be placed. E.g., Best-Fit, First-Fit, Buddy-System.
3.	Replacement Strategy: Determine which memory area is to be removed under contention conditions. E.g., LRU, FIFO.	


Allocation Methods:
				There are mainly three Memory allocation methods. They are First -Fit (FF), Best-Fit (BF), Worst-Fit (WF).
First Fit	:  Allocate the first hole that is big enough.
Best Fit	: Allocate the smallest hole that is big enough; must search entire list, unless ordered by size.  
Produces the smallest leftover hole.
Worst Fit: Allocate the largest hole; must also search entire list  
Produces the largest leftover hole

Example:
Let {Hi | i = 1… n} be unused blocks and k be the size of a 
Requested block. 
First-Fit :
 Select the first Hi such that size (Hi) ≥ k. ß That is, select the first block that is big enough 
 Best-Fit :
 Select Hi such that size (Hi ) ≥ k and, if size (Hj) ≥ k then size (Hj ) ≥ size (Hi ) for i ≠ j. ß That is, select the smallest block that is big enough. 
 Worst-Fit :
 Select Hi such that size (Hi ) ≥ k, and if size(Hj ) ≥ k then size(Hj ) ≥ size(Hi ) for i ≠ j. (idea: to produce the largest left-over block.)
