class Solution {
    public void reverseString(char[] s) {
        int i=0;
        int j = s.length-1;

        while (i <= j) {
            swapChar(s, i, j);
            i++;
            j--;
        }
    }


    void swapChar(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}