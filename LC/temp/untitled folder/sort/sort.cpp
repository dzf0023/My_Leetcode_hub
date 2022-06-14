#include <iostream>
#include <fstream>
#include <string>
using namespace std;



void quick_sort(vector<int> &nums, int l, int r){
	if(l + 1 >= r){
		return;
	}

	int first = l,  last = r - 1;
	int  key = nums[first];

	while(first < last){
		while(first < last && nums[last] >= key){
			--last;
		}

		nums[first] = nums[last];
		while(first < last && nums[first] <= key){
			++first;
		}
		nums[last] = nums[first];
	}

	nums[first] = key;
	quick_sort(nums, l, first);
	quick_sort(nums, first + 1, r);
}



// int main(){
// 	vector<int> nums = {1,2,3,5,77,45,3,2,221,112,3,4,455,12};
// 	sort(nums.begin(),nums.end());
// 	printf("==========");
// 	quick_sort(nums, 0, nums.size());
// }