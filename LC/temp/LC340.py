# numCourses = 5

# prerequisites = [[1,2],[2,4],[3,1],[4,5],[2,1]]


# edges = [[] for i in range(numCourses)]
# inDegree = [0 for i in range(numCourses)]
# for edge in prerequisites:
# 	# print(edge[0])
# 	print(edge[1])
# 	inDegree[edge[0]]+=1
# 	# edges[edge[1]].append(edge[0])
# print (inDegree)

from collections import defaultdict
#LC340
def lengthOfLongestSubstringKDinstinct(s,k):
	n = len(s)
	if k == 0 or n == 0:
		return 0
	left , right = 0,0
	hashmap = defaultdict()
	# hashmap = {}
	maxLen = 1
	while right < n:
		hashmap[s[right]] = right
		right += 1

		if len(hashmap) == k+1:
			# since the minimum is the left, since value is index
			# same as delete the leftmost
			del_idx = min(hashmap.values())
			del hashmap[s[del_idx]]

			left = del_idx+1
		maxLen = max(maxLen,right-left)
		# print (hashmap,   min(hashmap.values()))

	return maxLen

s = 'eceba'
k = 2
res = lengthOfLongestSubstringKDinstinct(s,k)
print (res)


