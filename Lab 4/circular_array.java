package Lab6;

public class circular_array{
   
    public static void main(String[] args){
        
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++){
            array[i] = i + 1;
        }

        int[] T = new int[10];
        for (int i = 0; i < 3214; i++) {
            T[i % T.length] = i + 1;
        }
        for(int i = 0; i < 10; i++){
            System.out.println(T[i]);
        }
    }
}