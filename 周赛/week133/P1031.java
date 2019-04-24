package week133;

import java.util.Arrays;

/**
 * Created on 24/04/2019.
 * Description:
 *
 * @author iznauy
 */
public class P1031 {

    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int length = A.length;
        int[] arrayL = new int[length - L + 1];
        for (int i = 0; i < L; i++)
            arrayL[0] += A[i];
        for (int i = L; i < length; i++)
            arrayL[i - L + 1] = arrayL[i - L] + A[i] - A[i - L];

        System.out.println("ArrayL: " + Arrays.toString(arrayL));

        int[] arrayM = new int[length - M + 1];
        for (int i = 0; i < M; i++)
            arrayM[0] += A[i];
        for (int i = M; i < length; i++)
            arrayM[i - M + 1] = arrayM[i - M] + A[i] - A[i - M];

        int[] arrayM1 = new int[length - M + 1], arrayM2 = new int[length - M + 1];
        for (int i = 0; i < arrayM1.length; i++) {
            if (i == 0)
                arrayM1[i] = arrayM[i];
            else
                arrayM1[i] = Math.max(arrayM1[i - 1], arrayM[i]);
        }
        for (int i = arrayM2.length - 1; i >= 0; i--) {
            if (i == arrayM2.length - 1)
                arrayM2[i] = arrayM[i];
            else
                arrayM2[i] = Math.max(arrayM2[i + 1], arrayM[i]);
        }

        System.out.println("ArrayM1: " + Arrays.toString(arrayM1));
        System.out.println("ArrayM2: " + Arrays.toString(arrayM2));

        int max = 0;
        for (int i = 0; i < arrayL.length; i++) {
            int curr = arrayL[i];
            if (i >= M) {
                int leftMax = arrayM1[i - M];
                if (curr + leftMax > max)
                    max = curr + leftMax;
            }
            if (i <= length - M - L) {
                int rightMax = arrayM2[i + L];
                if (curr + rightMax > max)
                    max = curr + rightMax;
            }
        }
        return max;

    }

    public static void main(String[] args) {
        int L = 1, M = 2;
        int[] array = new int[]{ 0,6,5,2,2,5,1,9,4 };
        P1031 p1031 = new P1031();
       System.out.println(p1031.maxSumTwoNoOverlap(array, L, M));
    }

}
