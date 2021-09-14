package practice.SingletonProject.src;

public class Singleton {
    private String message = "Fuck you bitch!";
    private static Singleton obj = new Singleton();

    private Singleton(){}

    public String getMessage() {
        return message;
    }

    public static Singleton getInstance() {
        return obj;
    }
}