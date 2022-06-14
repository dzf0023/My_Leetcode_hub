public class Car {
	public void fullThrottle() {
		System.out.println("The car is going as fast as it can");
	}


	public void speed(int maxSpeed){
		System.out.println("Max speed is:  " + maxSpeed );
	}

	public static void main(String[] args) {
		Car myCar = new Car();
		myCar.fullThrottle();
		myCar.speed(200);
	}
}

class Train{
	public void TrainSpeed(int maxSpeed){
		System.out.println("Max speed of train is :" + maxSpeed);
	}
	public static void main(String[] args) {
		Car VW = new Car();
		Train Subway = new Train();

		Subway.TrainSpeed(30000);

	}
}
/*
int[] memo;
public int rob(int[] nums){
	memo = new int(nums.length + 1);
	Arrays.fill(memo,-1);
	return rob(nums, nums.length-1);
}

private int rob(int[] nums, int i){
	if(i<0){
		return 0;
	}
	if (memo[i]>=0){
		return memo[i];
	}
	int result = Math.max(rob(nums, i-2)+ nums[i], rob(nums, i-1));
	memo[i] = result;
	return result;
}

*/





