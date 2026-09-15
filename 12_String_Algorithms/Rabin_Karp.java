/**
 * Rabin_Karp
 */
public class Rabin_Karp {

    static final int base= 256;
    static final int MOD = 101;
    public static int search(String text, String pattern){
        int n = text.length();
        int m = pattern.length();
        if(m>m) return -1;
        int patternhash= 0;
        int texthash=0;
        //BASE^(m-1) %MOD
        int highestPower= 1;
        for(int i=0;i<m-1;i++){
            highestPower=(highestPower * base)%MOD;
        }
        //initial hashes
        for(int i=0;i<m;i++){
            patternhash=(base*patternhash+pattern.charAt(i))% MOD;
            texthash= (base*texthash+text.charAt(i))%MOD;
        }
        //Slide the pattern over the text
        for(int i=0;i<=n-m;i++){
            if(patternhash==texthash){
                if(text.substring(i,i+m).equals(pattern)){
                    return i;
                }
            }
            //hash of next window
            if(i<n-m){
                texthash=(base*(texthash-text.charAt(i)*highestPower)+text.charAt(i+m))%MOD;
                //make hash positive
                if(texthash<0){
                    texthash+=MOD;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args){
        String text="ABCCDAB";
        String pattern= "CDA";
        int index= search(text, pattern);
        if(index==-1) System.out.println("Pattern nor Found");
        else
        System.out.println("Pattern found at index: "+index);
    }
}

/*
Rabin-Karp is a string pattern searching algorithm that uses hashing to find a pattern inside a text.

| Case           | Time         |
| -------------- | ------------ |
| Best / Average | **O(n + m)** |
| Worst          | **O(nm)**    |
| Space          | **O(1)**     |

*/