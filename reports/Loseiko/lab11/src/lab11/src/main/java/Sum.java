public class Sum {
    public static int accum ( int ... values ) {
        int result = 0;
        for ( int i = 0; i < values . length ; i ++) {
            result += values [ i ];
        }
        return result ;
    }
    public static long modaccum(long ... values){
        long result = 0;
        for ( int i = 0; i < values.length;i++){
            result += values [i];
        }
        return result ;
    }
}
