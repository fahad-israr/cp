// My CF Template


import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader bufferedReader;
    public static void main(String args[]) throws IOException {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine());
        while(t-->0){
            int n = Integer.parseInt(bufferedReader.readLine());
            String[] inp = bufferedReader.readLine().split(" ");
            int[] arr = new int[inp.length];
            int pos = 0;
            long total = 0L;
            for(String s: inp){
                int val= Integer.parseInt(s);
                total += val;
                arr[pos++]  = val;
            }
           for(int grp = 2; grp <= n; grp  *= grp){
            
           }
            System.out.println(pos);
            // System.out.println("===== TC"+t+1 +"ENDS =====");
        }

    
    }

    static int inputInt(){
        try {
            return Integer.parseInt(bufferedReader.readLine());
        } catch (NumberFormatException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return Integer.MIN_VALUE;
        }
    }
    static String inputString(){
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "ERROR";
        }
    }

    static long inputLong() {
        try {
            return Long.parseLong(bufferedReader.readLine());
        } catch (NumberFormatException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return Long.MIN_VALUE;
        }
    }

    static double inputDouble(){
        try {
            return Double.parseDouble(bufferedReader.readLine());
        } catch (NumberFormatException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return 0.0;
        }
    }

    static int[] inputIntegerArray(){
        try {
            int[] input = Arrays.stream(bufferedReader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            return input;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new int[0];
        }
    }
   
}
