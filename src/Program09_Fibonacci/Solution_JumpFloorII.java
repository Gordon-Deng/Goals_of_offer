package Program09_Fibonacci;

public class Solution_JumpFloorII {
    public int JumpFloorII(int target) {
        if (target == 0){
            return 0;
        }

        int FLOOR_STEP_NUMBER = 1;
        int result = FLOOR_STEP_NUMBER;

        for (int i = 1; i < target; i++) {
            result = 2*result;
        }
        return result;
    }
}
