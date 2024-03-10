public interface Subject {

    void subscriber(Observer observer);
    void un_subscriber(Observer observer);
    
    void videoUploaded(String title);
}
