//package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class SecretOrigins {
    //    public class Main {
    public static int[] swap(int data[], int left, int right)
    {

        // Swap the data
        int temp = data[left];
        data[left] = data[right];
        data[right] = temp;

        // Return the updated array
        return data;
    }

    // Function to reverse the sub-array
    // starting from left to the right
    // both inclusive
    public static int[] reverse(int data[], int left, int right)
    {

        // Reverse the sub-array
        while (left < right) {
            int temp = data[left];
            data[left++] = data[right];
            data[right--] = temp;
        }

        // Return the updated array
        return data;
    }

    // Function to find the next permutation
    // of the given integer array
    public static boolean findNextPermutation(int data[])
    {

        // If the given dataset is empty
        // or contains only one element
        // next_permutation is not possible
        if (data.length <= 1)
            return false;

        int last = data.length - 2;

        // find the longest non-increasing suffix
        // and find the pivot
        while (last >= 0) {
            if (data[last] < data[last + 1]) {
                break;
            }
            last--;
        }

        // If there is no increasing pair
        // there is no higher order permutation
        if (last < 0)
            return false;

        int nextGreater = data.length - 1;

        // Find the rightmost successor to the pivot
        for (int i = data.length - 1; i > last; i--) {
            if (data[i] > data[last]) {
                nextGreater = i;
                break;
            }
        }

        // Swap the successor and the pivot
        data = swap(data, nextGreater, last);

        // Reverse the suffix
        data = reverse(data, last + 1, data.length - 1);

        // Return true as the next_permutation is done
        return true;
    }
    public static void main(String[] args) throws IOException {
        Sc sc = new Sc();
        Print out = new Print();
        BufferedWriter close = new BufferedWriter(new OutputStreamWriter(System.out));
        int till=sc.nextInt();
        for (int z = 0; z < till; z++) {
            String num=Integer.toString(sc.nextInt(), 2);
            int[] newGuess = new int[num.length()+1];
            newGuess[0]=0;
            for (int i = 0; i < num.length(); i++)
            {
                newGuess[i+1] = num.charAt(i) - '0';
            }
            findNextPermutation(newGuess);
            String s="";
//            for (int i=newGuess.length-1; i>=0 ;i--)
//            {
//                s+=newGuess[i]; //add all the ints to a string
//            }
            for (int i=0; i< newGuess.length ;i++)
            {
                s+=newGuess[i]; //add all the ints to a string
            }
            out.println("Case "+(z+1)+": "+ Integer.toString(Integer.parseInt(s, 2), 10));
        }
        close.close();
        //x=int(input())#solved it like proooooooooo
        //for _ in range(x):
        //    n=int(input())
        //    arr=list('0'+bin(n)[2:])
        //    class Solution(object):
        //       def nextPermutation(self, nums):
        //          found = False
        //          i = len(nums)-2
        //          while i >=0:
        //             if nums[i] < nums[i+1]:
        //                found =True
        //                break
        //             i-=1
        //          if not found:
        //             nums.sort()
        //          else:
        //             m = self.findMaxIndex(i+1,nums,nums[i])
        //             nums[i],nums[m] = nums[m],nums[i]
        //             nums[i+1:] = nums[i+1:][::-1]
        //          return nums
        //       def findMaxIndex(self,index,a,curr):
        //          ans = -1
        //          index = 0
        //          for i in range(index,len(a)):
        //             if a[i]>curr:
        //                if ans == -1:
        //                   ans = curr
        //                   index = i
        //                else:
        //                   ans = min(ans,a[i])
        //                   index = i
        //          return index
        //    ob1 = Solution()
        //    ob1.nextPermutation(arr)
        //    print(arr)
        //    #arr.reverse()
        //    print(int("".join(arr),2))
    }

    static class Sc {
        private byte[] buf = new byte[1024];
        private int index;
        private InputStream in;
        private int total;

        public Sc() {
            in = System.in;
        }

        public int read() throws IOException {
            if (total < 0)
                throw new InputMismatchException();
            if (index >= total) {
                index = 0;
                total = in.read(buf);
                if (total <= 0)
                    return -1;
            }
            return buf[index++];
        }

        public int nextInt() throws IOException {
            int integer = 0;
            int n = read();
            while (isWhiteSpace(n))
                n = read();
            int neg = 1;
            if (n == '-') {
                neg = -1;
                n = read();
            }
            while (!isWhiteSpace(n)) {
                if (n >= '0' && n <= '9') {
                    integer *= 10;
                    integer += n - '0';
                    n = read();
                } else throw new InputMismatchException();
            }
            return neg * integer;
        }

        public double nextDouble() throws IOException {
            double doub = 0;
            int n = read();
            while (isWhiteSpace(n))
                n = read();
            int neg = 1;
            if (n == '-') {
                neg = -1;
                n = read();
            }
            while (!isWhiteSpace(n) && n != '.') {
                if (n >= '0' && n <= '9') {
                    doub *= 10;
                    doub += n - '0';
                    n = read();
                } else throw new InputMismatchException();
            }
            if (n == '.') {
                n = read();
                double temp = 1;
                while (!isWhiteSpace(n)) {
                    if (n >= '0' && n <= '9') {
                        temp /= 10;
                        doub += (n - '0') * temp;
                        n = read();
                    } else throw new InputMismatchException();
                }
            }
            return doub * neg;
        }

        public String nextString() throws IOException {
            StringBuilder sb = new StringBuilder();
            int n = read();
            while (isWhiteSpace(n))
                n = read();
            while (!isWhiteSpace(n)) {
                sb.append((char) n);
                n = read();
            }
            return sb.toString();
        }

        private boolean isWhiteSpace(int n) {
            if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1)
                return true;
            return false;
        }
    }

    static class Print {
        private final OutputStream out;

        public Print() {
            this.out = System.out;
        }

        public void print(String str) throws IOException {
            for (int i = 0; i < str.length(); i++) {
                out.write(str.charAt(i));
            }
        }

        public void println(String str) throws IOException {
            print(str);
            out.write('\n');
        }

        public void close() throws IOException {
            out.close();
        }
    }
}