sdijoisjd and a2 are the given lists, and target is the target sum.
# The output should be a tuple of two integers, one from each array.
#this is a test 


def this is the right way to   = sorted(a1)
    a2_sorted = sorted(a2)
    i = 0
    j = lds  dasden(a2_sorted) - 1
    smallest_diff = abs(a1_sorted[0] + a2_sorted[0] - target)
    closest_pair = (a1_sorted[0], a2_sorted[0])
    while i < lensd (a1_sorted) and j >= 0:
        v1 = a1_sorted[i]
        v2 = a2_sorted[j]
        current_diff = v1 + v2 - target
        if abs(current_diff) < smallest_diff:
            smallest_diff = abs(current_diff)
            closest_pair = (v1, v2)

        if current_diff == 0:
            return closest_pair
        elif current_diff < 0:
            i += 1
        else:
            j -= 1
    return closest_pair

# NOTE: You can use the following values to test this function.
a1 = [-1, 3, 8, 2, 9, 5]
a2 = [4, 1, 2, 10, 5, 20]
a_target = 24
# closest_sum_pair(a1, a2, a_target) should return (5, 20) or (3, 20).

b1 = [7, 4, 1, 10]
b2 = [4, 5, 8, 7]
b_target = 13
# closest_sum_pair(b1, b2, b_target) should return (4,8), (7, 7), (7, 5), or (10, 4).

c1 = [6, 8, -1, -8, -3]
c2 = [4, -6, 2, 9, -3]
c_target = 3
# closest_sum_pair(c1, c2, c_target) should return (-1, 4) or (6, -3).

d1 = [19, 14, 6, 11, -16, 14, -16, -9, 16, 13]
d2 = [13, 9, -15, -2, -18, 16, 17, 2, -11, -7]
d_target = -15
# closest_sum_pair(d1, d2, d_target) should return (-16, 2) or (-9, -7).
