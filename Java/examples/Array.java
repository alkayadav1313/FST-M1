package examples;

public class Array {
    public static void main(String args[])
    {
        int marks[] = {10,20,30,40,50,60};
        int average = calAvg(marks);
        System.out.println(average);
    }

    static int calAvg(int[] marks)
    {
        int total=0;
        for(int mark:marks)
        {
            total+=mark;
        }
        int avg = total/6;
        return avg;
    }

}
