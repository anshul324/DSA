package arrays;

public class RainTrappingWater {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        left[0] = height[0];
        right[height.length - 1] = height[height.length - 1];
        for(int i = 1; i < height.length; ++i) {
            left[i] = Math.max(height[i], left[i - 1]);
        }
        for(int i = height.length - 2; i > 0; --i) {
            right[i] = Math.max(height[i], right[i + 1]);
        }
        int result = 0;
        for(int i = 1; i < height.length - 1; ++i) {
            result += Math.max(0, Math.min(left[i - 1], right[i + 1]) - height[i]);
        }
        return result;
    }

    public int trapOptimal(int[] height) {
        int result = 0;
        int i = 0;
        int j = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;
        while(i < j) {
            if(height[i] <= height[j]) {
                if(height[i] > maxLeft) {
                    maxLeft = height[i];
                } else {
                    result += maxLeft - height[i];
                }
                ++i;
            } else {
                if(height[j] > maxRight) {
                    maxRight = height[j];
                } else {
                    result += maxRight - height[j];
                }
                --j;
            }
        }
        return result;
    }
}
