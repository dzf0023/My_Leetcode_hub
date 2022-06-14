
#  top - down
def merge_sort(nums):
	if len(nums) <= 1:
		return nums

	pivot = len(nums) // 2 
	left_list = merge_sort(nums[0:pivot])
	right_list = merge_sort(nums[pivot:])

	return merge(left_list, right_list)


def merge(list1, list2):
	left_pivot = right_pivot =  0
	res = []


	while left_pivot < len(list1) and right_pivot < len(list2):
		if list1[left_pivot] < list2[right_pivot]:
			res.append(list1[left_pivot])
			left_pivot += 1
			
		else:
			res.append(list2[right_pivot])
			right_pivot += 1
		

	res.extend(list1[left_pivot:])
	res.extend(list2[right_pivot:])

	return res


nums = [2,3,11,22,3,2]
result  = merge_sort(nums)
print (result)

