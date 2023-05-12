package aop00;

public class ProxyClient {
    public static void main(String[] args) {
        //Internet internet = new MyInternet();
        Internet internet = new ProxyInternet();
        String host1 = "www.medium.com";
        String host2 = "www.facebook.com";
        Status status = internet.openConnection(host1);
        System.out.println(host1 + " Connection status: " + status);
        status = internet.openConnection(host2);
        System.out.println(host2 + " Connection status: " + status);
    }
}
