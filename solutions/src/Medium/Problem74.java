package Medium;

public class Problem74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int length = matrix[0].length;
        return binarySearchMatrix(matrix, target, 0, matrix.length * length, length);
    }

    private boolean binarySearchMatrix(int[][] matrix, int target, int start, int end, int length) {
        if (end - start == 1)
            return matrix[start / length][start % length] == target;
        int mid = (start + end) / 2, valMid = matrix[mid / length][mid % length];
        if (target == valMid)
            return true;
        if (target > valMid)
            return binarySearchMatrix(matrix, target, mid, end, length);
        else
            return binarySearchMatrix(matrix, target, start, mid, length);
    }

    public static void main(String[] args) {
        Problem74 problem74 = new Problem74();
        System.out.println(problem74.searchMatrix(new int[][]{new int[]{1,3,5,7}, new int[]{10,11,16,20}, new int[]{23,30,34,60}}, 3));
        System.out.println(problem74.searchMatrix(new int[][]{new int[]{1,3,5,7}, new int[]{10,11,16,20}, new int[]{23,30,34,60}}, 9));
        System.out.println(problem74.searchMatrix(new int[][]{new int[]{1,3,5,7}, new int[]{10,11,16,20}, new int[]{23,30,34,60}}, 60));
    }
}
