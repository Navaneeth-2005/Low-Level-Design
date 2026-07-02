import java.util.*;

interface VideoDownloader{
    String downloadVideo(String videoUrl);
}

class RealVideoDownloader implements VideoDownloader{

    @Override
    public String downloadVideo(String url){
        return "downloading video from"+url;
    }
}
//proxy class
class cachedVideoDownloader implements VideoDownloader{
    private RealVideoDownloader realVideoDownloader;
    private Map<String,String>cache;

    public cachedVideoDownloader(){
        this.realVideoDownloader = new RealVideoDownloader();
        this.cache = new HashMap<>();
    }

    @Override
    public String downloadVideo(String url){
        if(cache.containsKey(url)){
            return cache.get(url);
        }
        String result = realVideoDownloader.downloadVideo(url);
        cache.put(url, result);
        return result;
    }
}
public class proxy {
    public static void main(String[] args) {
        VideoDownloader cacheVideoDownloader = new cachedVideoDownloader();
        System.out.println("User 1 tries to download the video.");
        cacheVideoDownloader.downloadVideo("https://video.com/proxy-pattern");

        System.out.println();

        System.out.println("User 2 tries to download the same video again.");
        cacheVideoDownloader.downloadVideo("https://video.com/proxy-pattern");
    }
}
