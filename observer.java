import java.util.*;

interface Channel{

    public void subscribe(Subscriber sub);
    public void unsubscribe(Subscriber sub);
    public void notifySubscribers();
}

class YoutubeChannel implements Channel{
    List<Subscriber>subscribers=new ArrayList<>();
    String channelName;

    YoutubeChannel(String channelName){
        this.channelName=channelName;
    }

    void uploadVideo(String videoTitle){
        System.out.println("Video Uploaded: "+videoTitle);
        notifySubscribers();
    }

    public void subscribe(Subscriber sub){
        subscribers.add(sub);
    }
    public void unsubscribe(Subscriber sub){
        subscribers.remove(sub);
    }
    public void notifySubscribers(){

        for(Subscriber sub:subscribers){
            sub.update();
        }
    }
}


interface Subscriber{
    public void update();
}

class EmailSubscriber implements Subscriber{
    private String email;

    EmailSubscriber(String email){
        this.email=email;
    }
    public void update(){
        System.out.println("Email sent to: "+email);
    }
}

class MobileAppSubscriber implements Subscriber{
    private String username;

    MobileAppSubscriber(String username){
        this.username=username;
    }
    public void update(){
        System.out.println("Notification sent to mobile app user: "+username);  
    }
}

public class observer { 
    public static void main(String[] args){
        
        YoutubeChannel channel=new YoutubeChannel("Tech Tutorials");

        Subscriber emailSub1=new EmailSubscriber("navaneeth");
        Subscriber emailSub2=new EmailSubscriber("preethi");
        Subscriber mobileSub1=new MobileAppSubscriber("user123");
         
        channel.subscribe(emailSub1);
        channel.subscribe(emailSub2);
        channel.subscribe(mobileSub1);
        channel.uploadVideo("Java Observer Pattern Tutorial");  
    }
    
}
