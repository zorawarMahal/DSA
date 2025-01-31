class Solution {
    public void reverseString(char[] s) {
        // simply use two pointers to swap the elements of the character array. The iterative approach is better because of obvious reasons like time complexity and does not use any extra space

        // now using the recursive approach
        swapChar(s, 0, s.length-1);
    }


    void swapChar (char[] s, int start, int end) {
        if (start > end) {
            return;
        }

        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;

        swapChar(s, start+1, end-1);
    }
}