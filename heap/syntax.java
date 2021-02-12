
/*You can use Java Priority Queue as a Heap.
================================================================

Min Heap: --> to keep the min element always on top, so you can access it in O(1).

----------------------------------------------------------------*/
PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
/*-------------------------------------------------------------------


==================================================================



Max Heap: --> to keep the max element always on top, the same order as above.
-----------------------------------------------------------------------*/
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
/*-----------------------------------------------------------------------
===================================================================*/