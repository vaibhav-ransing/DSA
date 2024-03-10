public class Main {
    
    public static void main(String[] args) {
        
        YoutubeChannel yt = new YoutubeChannel();

        Subscriber subscriber = new Subscriber();
        subscriber.setAge("24");
        subscriber.setName("Vaibhav");
        
        Subscriber subscriber2 = new Subscriber();

        yt.subscriber(subscriber);
        yt.subscriber(subscriber2);

        yt.videoUploaded("Nigaa in run");
    }
}
