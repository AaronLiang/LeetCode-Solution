/**
 * 
 */
package java.practice.level4;

/**
 * Source: LeetCode
 * 
 * @author Aaron
 * 
 *         Given an array of non-negative integers, you are initially positioned
 *         at the first index of the array.
 * 
 *         Each element in the array represents your maximum jump length at that
 *         position.
 * 
 *         Determine if you are able to reach the last index.
 * 
 *         For example: A = [2,3,1,1,4], return true.
 * 
 *         A = [3,2,1,0,4], return false.
 * 
 *         刚开始各种木有思路，以为要递归或者dp啥的，后来一想从后往前数呗，规律是，遇到为0的话把res=false，再往前看。用j-
 *         i来纪录下差的距离的值，然后看下一个A[i], 若A[i]>=j-i, 那么再res=true.这样从头到尾扫一遍。
 * 
 *         也可以用dp来做，从 水中的鱼 看到他的总结，很好值得学习，设 jump[i]为剩余的最大步数，于是
 *         jump[i]=max(jump[i-1], A[i-1])-1. 所以只要jump[i]>=n-i, 那么便可以到达结尾。
 */
public class JumpGame {
	public boolean canJump(int[] A) {
		int maxstep = 0;
		for (int i = 0; i < A.length && i <= maxstep; i++) {// i <= maxstep
			if (i + A[i] > maxstep) {
				maxstep = i + A[i];
			}
			if (maxstep >= A.length - 1) {// must >= and length -1
				return true;
			}
		}
		return false;
	}

}

//public:
//    bool canJump(int A[], int n) {
//        // Start typing your C/C++ solution below
//        // DO NOT write int main() function
//        bool res=true;
//        
//        int j=n-1;
//        for(int i=n-2; i>=0; i--)
//        {
//            if(A[i]==0)
//            res=false;
//            
//            else if(res==false&&A[i]>0)
//            {
//                if(A[i]>=j-i)
//                {
//                    res=true;
//                    j=i;
//                }
//            }
//            else if(A[i]>0&&res==true)
//            {
//                j=i;
//            }
//        }
//        return res;
//    }
