import java.util.*;

interface videoQuality{
    void load(String title);
}

class SDQuality implements videoQuality{
    public void load(String title){
        System.out.println("Loading " + title + " in SD quality.");
    }
}
class HDQuality implements videoQuality{
    public void load(String title){
        System.out.println("Loading " + title + " in HD quality.");
    }
}
class UltraHDQuality implements videoQuality{
    public void load(String title){
        System.out.println("Loading " + title + " in Ultra HD quality.");
    }
}

abstract class VideoPlayer{
    videoQuality quality;

    public VideoPlayer(videoQuality quality){
        this.quality = quality;
    }

    void play(String title){
        System.out.println("Playing video.");
        quality.load(title);
    }
}

class WebPlayer extends VideoPlayer{
    public WebPlayer(videoQuality quality){
        super(quality);
    }

    public void play(String title){
        System.out.println("Playing video on Web Player.");
        quality.load(title);
    }
}

class MobilePlayer extends VideoPlayer{
    public MobilePlayer(videoQuality quality){
        super(quality);
    }

    public void play(String title){
        System.out.println("Playing video on Mobile Player.");
        quality.load(title);
    }
}
public class bridge {

    public static void main(String[] args) {
       // Playing on Web with HD Quality
        VideoPlayer player1 = new WebPlayer(new HDQuality());
        player1.play("Interstellar");

        // Playing on Mobile with Ultra HD Quality
        VideoPlayer player2 = new MobilePlayer(new UltraHDQuality());
        player2.play("Inception");
    
    }
    
}
