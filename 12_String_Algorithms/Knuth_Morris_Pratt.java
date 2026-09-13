/**
 * Knuth-Morris-Pratt
 */
public class Knuth_Morris_Pratt {
  public static void main(String[] args){
    String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";

        int index = search(text, pattern);
        if(index==-1) System.out.println("Not Found");
        else
        System.out.println("Pattern found at index: " + index);
  }  
  public static  int search(String text, String pattern){
    int lps[]= buildlsp(pattern);
    int i =0; //test pointer
    int j=0; //pattern pointer
    while(i<text.length()){
        if(text.charAt(i)==pattern.charAt(j)){
            i++;
            j++;
            if(j==pattern.length()){
                return i-j;
            }
        }else{
            if(j!=0){
                j=lps[j-1];
            }else{
                i++;
            }
        }
    }
    return -1;
  }
  public static int[] buildlsp(String pattern){
    int n= pattern.length();
    int[] lps =new int[n];
    int len =0;
    int i=1;
    while(i<n){
        if(pattern.charAt(len)==pattern.charAt(i)){
            len++;
            lps[i]=len;
            i++;
        }else{
             // Characters don't match, but we already have a matching prefix
            if(len!=0){
                // Try a smaller previously-known matching prefix
            // We don't move 'i' because we haven't checked this character
            // with the new prefix yet
                len=lps[len-1];
            }else{
               lps[i]=0;
                i++;
            }
        }
    }
    return lps;
  }
}

/*
KMP Algorithm — Knuth-Morris-Pratt

KMP (Knuth-Morris-Pratt) is a string pattern-searching algorithm used to find a pattern inside a text efficiently.

The main idea is:

When a mismatch occurs, don't start comparing from the beginning again. Use information from the pattern that we already matched.
| Part      | Complexity     |
| --------- | -------------- |
| Build LPS | **O(n)** time  |
| LPS array | **O(n)** space |

*/