import heapq

#using as a priority queue to always get the minimum to pop
def minMeetingRooms(intervals):
	intervals.sort(key = lambda x:x[0])
	heap = []

	for item in intervals:
		if heap == [] or heap[0] > item[0]:
			heapq.heappush(heap, item[1])
		else:
			heapq.heappop(heap)
			heapq.heappush(heap,item[1])
	return heap



intervals = [[0,15],[5,20],[30,40],[35,39],[36,55]]

res = minMeetingRooms(intervals)
print (res)

