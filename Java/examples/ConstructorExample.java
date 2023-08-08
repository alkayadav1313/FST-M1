package examples;

public class ConstructorExample {

    String name;
    String colour;
    String breed;

    ConstructorExample(String name, String colour, String breed)
    {
        this.name= name;
        this.colour=colour;
        this.breed=breed;
    }

    public void barking()
    {
        System.out.println(name + " is barking");
    }

    public void sleeping()
    {
        System.out.println(name + " is sleeping");
    }

    public void running()
    {
        System.out.println(name + " is running");
    }

    public static void main(String[]args)
    {
        ConstructorExample dog1 = new ConstructorExample("Riley","black","labrador");
        ConstructorExample dog2 = new ConstructorExample("Shadow","brown","Golden Retriever");

        dog1.barking();
        dog1.sleeping();
        dog1.running();

        dog2.barking();
        dog2.sleeping();
        dog2.running();
    }

}
