nums1 = [1,2,3] 
nums2 = [7,5,6]
m = 3 
n = 3 

i = 0
j = 0

nums3 = []
while i <= len(nums1)-1:
    while j <= len(nums2)-1:

        if nums1[i] <= nums2[j]:
            nums3.append(nums1[i])
            i = i + 1
        else:
            nums3.append(nums2[j])
            j = j + 1

print (nums3)


# for i in range (len(nums1)-m):
# 	nums1.remove(0)
# print (nums1)

'''
def mergeSorted(list1,list2,m,n):
    if m != len(nums1):
        for i in range (len(nums1)-m):
            nums1.remove(0)
    if n != len(nums2):
        for s in range (len(nums2)-n):
            nums2.remove(0)
    
    nums3 = []
    
    j,k = 0,0
    #  if one list is empty 
    while j <= len(nums1):
        while k <= len(nums2):
            if nums1[j] <= nums2[k]:
                nums3.append(nums1[j])
                j+=1
            else:
                nums3.append(nums2[k])
                k += 1
    print (nums3)

result = mergeSorted(nums1,nums2,m,n)

print (result)
'''
