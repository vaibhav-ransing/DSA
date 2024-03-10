import java.util.ArrayList;
import java.util.List;

public class YoutubeChannel implements Subject {

    List<Observer> observers = new ArrayList<>();

    @Override
    public void subscriber(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void un_subscriber(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void videoUploaded(String title) {
        for(Observer ob : this.observers){
            ob.customNotificaiton(title);
        }
    }
    
}
