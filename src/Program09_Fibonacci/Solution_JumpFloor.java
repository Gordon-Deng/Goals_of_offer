package Program09_Fibonacci;

public class Solution_JumpFloor {
    public int JumpFloor(int target) {
        int [] inputData = {0,1,2};

        if (target <= 2){
            return inputData[target];
        }

        int FLOOR_STEP_NUMBER = 1;
        int SECOND_STEP_NUMBER = 2;
        int result = 0;

        for (int i = 3; i <= target; i++) {
            result = FLOOR_STEP_NUMBER + SECOND_STEP_NUMBER;
            FLOOR_STEP_NUMBER = SECOND_STEP_NUMBER;
            SECOND_STEP_NUMBER = result;
        }

        return result;
    }
}
