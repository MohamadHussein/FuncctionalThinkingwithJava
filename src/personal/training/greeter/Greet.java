package personal.training.greeter;

public class Greet {
    public static void main(String[] args) {
        System.out.println(appendToMsg("Ahmad"));
    }
    public static String appendToMsg(String msg){
        String baseMsg = "hasta la vista and good luck ";
        return baseMsg + msg;
    }
}
