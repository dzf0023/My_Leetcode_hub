class MergeSort{


	void merge(int arr[], int l,  int m, int r){
		int n1 = m - l + 1;
		int n2 = r - m;

		int[] L = new int[n1];
		int[] R = new int[n2];

		for(int i = 0; i < n1; i++){
			L[i] = arr[l + i];
		}

		for (int j = 0; j < n2;  j++) {
			R[j] = arr[m + 1 + j];
		}

		int i = 0, j = 0;

		int k = l;
		while(i < n1 && j < n2){
			if(L[i] <= R[j]){
				arr[k] = L[i];
				i++;
			}else{
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		while(i < n1){
			arr[k] = L[i];
			i++;
			k++;
		}
		while(j < n2){
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	void sort(int arr[], int l, int r){
		if(l < r){
			int m = (l + r) / 2;

			sort(arr, l, m);
			sort(arr, m+1, r);
			merge(arr, l, m, r);
		}
	}

	static void printArray(int arr[]){
		int n = arr.length;
		for(int i = 0; i < n; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int arr[] = {12, 11, 13,4,5,6};

		System.out.println("Given Array");
		printArray(arr);

		MergeSort ob = new MergeSort();
		ob.sort(arr, 0, arr.length - 1);

		System.out.println("\nSorted Array");
		printArray(arr);
	}

}



/////////////////second ways
class Solution {
    public int[] sortArray(int[] nums) {
        if(nums.length <= 1){
            return nums;
        }
        
        int pivot = nums.length / 2;
        
        int[] left_nums = sortArray(Arrays.copyOfRange(nums, 0, pivot));
        int[] right_nums = sortArray(Arrays.copyOfRange(nums, pivot, nums.length));
        
        return merge(left_nums, right_nums);
    }
    
    
    public int[] merge(int[] left, int[] right){
        int left_length = left.length;
        int right_length = right.length;
        
        int l_point = 0;
        int r_point = 0;
        int[] res = new int[left_length + right_length];
        int idx = 0;
        while(l_point < left_length && r_point < right_length){
            if(left[l_point] < right[r_point]){
                res[idx] = left[l_point];
                idx += 1;
                l_point += 1;
            }else{
                res[idx] = right[r_point];
                idx += 1;
                r_point += 1;
            }
        }
        
        while(l_point < left_length){
            res[idx] = left[l_point];
            idx += 1;
            l_point += 1;
        }
        
        while(r_point < right_length){
            res[idx] = right[r_point];
            idx += 1;
            r_point += 1;
        }
        
        return res;
        
        
    }
}








