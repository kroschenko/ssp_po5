public class Task1{
    public static void main(String args[]){
        int answer = sum(-2, 5, 0, 8, -1, 3, 5);
        System.out.println("Sum: " + answer);
    }  

    public static int sum(int ...nums){
        int result = 0;
        for (int i : nums){
            if(i < 0){
                result += i*i;
            }
        }
        return result;
    }
}


