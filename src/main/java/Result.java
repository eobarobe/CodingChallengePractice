import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'closestNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> closestNumbers(List<Integer> arr) {
        Collections.sort(arr); //sort give array
        List<Integer> result = new ArrayList<>(); //create empty result array
        int smallest = Integer.MAX_VALUE; //create max val to compare to

        for (int i = 1; i <arr.size() ; i++) {
            if (numToCompare(arr.get(i),arr.get(i-1))< smallest){//check if difference < curr smallest
                smallest = numToCompare(arr.get(i),arr.get(i-1));
            }
        }
        for (int i = 1; i <arr.size() ; i++) {
            if (numToCompare(arr.get(i),arr.get(i-1))== smallest){
                result.add( arr.get(i-1) );
                result.add(arr.get(i));
            }
        }
        return result;
    }
    
    public static int numToCompare(int n, int m){
        return Math.abs(n-m);
    }

    
    
    /*
        Given an array of positive integer and given value X, find Contiguous sub array whose sum is equal to X.
        
        For example:
        
        arr[]={14, 12, 70, 15, 99, 65, 21, 90};
        X = 97
        Sum found between index 1 to 3
        Elements are 12, 70 and 15
     */

    public static List<Integer> contiguousSubarray(int[] array, int x) {
        List <Integer> answer = new ArrayList<>();
        int pointer = 0;
        int sum = 0;

        for (int i = 0; i<array.length;i++) {
            if (sum == x) {
                return answer;      // breaks loop if answer is found
            }
            if (sum + array[i] <= x) {
                sum += array[i];
                answer.add(array[i]);
            } else if (sum + array[i] > x) {
                answer.clear();     // resets//de-references the answer list if sum > x
                sum = 0;            // resets the sum to 0
                pointer++;
                i = pointer-1;
            }
        }
        
        // Return a list of the contiguous values that add up to x
        return answer;
    }
    /**
     * length of max substring in 2 strings
     * **/
    public static int longestSubstring(String s1, String s2){
        char[] s1a = s1.toCharArray();
        char[] s2a = s2.toCharArray();
        int max = 0;
        int temp = 0;
        for (int i = 0; i < s1a.length; i++) {
            if(s1a[i] == s2a[i]){
                temp+=1;
            }else{
                if(temp > max){
                    max = temp;
                }
                temp = 0;
                i = i-1;
            }


        }
        System.out.println(max);
        return max;

    }

}
class Stackk{
    //empty() peek() pop() push(E item) search(Object o)
    private InternalStack internalStack;

    public Stackk() {
        internalStack = new InternalStack();
    }

    private class InternalStack extends LinkedList {}

    public boolean empty() {
        return internalStack.isEmpty();
    }
    public Object peek() {
        return internalStack.peek();
    }

    public Object pop(){
        return internalStack.pop();
    }

    public Object push(Object o){
        internalStack.addFirst(o);
        return internalStack.getFirst();
    }

    public int search(Object o){
        return internalStack.indexOf(o);
    }

    public String toString() {
        // it works!... shame about having to use a loop though
        String s = "";
        for (Object item : internalStack) {
            s += " " + item;
        }
        s = "{" + s + " }";
        return s;
    }
}

class Solution {
    public static void main(String[] args) throws IOException {

        //longest subString problem

        System.out.println( Result.longestSubstring("Minnesota","Minute"));
        // contiguousSubarray problem
//        List<Integer> subArray = Result.contiguousSubarray(new int[]{14, 12, 70, 15, 99, 65, 21, 90}, 97);
//        System.out.println(subArray);
//        Stackk ourStack = new Stackk();
//        ourStack.push(1);
//        System.out.println(ourStack);
//        ourStack.pop();
//        System.out.println(ourStack);


//        //coding challenge:
//        Scanner in = new Scanner(System.in);
//        int k = in.nextInt();
//        int n = in.nextInt();
//        //float percent = (1/k);
//        double prob = Math.pow((1.0/k),n)*100;
//        StringBuilder sb = new StringBuilder();
//        sb.append(prob);
//        sb.append("%");
//        System.out.println(sb);

//        List<Integer> arr = new ArrayList<>();
//        //-20 -3916237 -357920 -3620601 7374819 -7330761 30 6246457 -6461594 266854 -520 -470
//        arr.add(-20);
//        arr.add(-3916237);
//        arr.add(-357920);
//        arr.add(-3620601);
//        arr.add(7374819);
//        arr.add(-7330761);
//        arr.add(30);
//        arr.add(6246457);
//        arr.add(-6461594);
//        arr.add(266854);
//        arr.add(-520);
//        arr.add(-470);
//
//        System.out.println(Result.closestNumbers(arr));

    }
}
