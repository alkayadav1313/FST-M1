package examples;

public class MethodOverloadingExample {

    public void dis(String name)
    {
        System.out.println("My name is :" +name);
    }

    public void dis(String firstname,String lastname)
    {
        System.out.println("My name is :" +firstname+" "+lastname);

    }

    public void dis(int num)
    {
        System.out.println("The name is :" +num);

    }

    public static void main(String[]args)
    {
        MethodOverloadingExample obj = new MethodOverloadingExample();
        obj.dis("Alka");
        obj.dis("Amanda","Johnson");
        obj.dis(12345);

    }
}
