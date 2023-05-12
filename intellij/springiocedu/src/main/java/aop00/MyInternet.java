package aop00;

public class MyInternet implements Internet {
    @Override
    public Status openConnection(String host) {
        System.out.println("Connecting to host: " + host);
        return Status.SUCCESS;
    }
}
