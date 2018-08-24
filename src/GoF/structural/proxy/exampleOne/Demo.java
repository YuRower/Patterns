package GoF.structural.proxy.exampleOne;

import java.util.HashMap;

interface ThirdPartyYoutubeLib {
	public HashMap<String, Video> popularVideos();

	public Video getVideo(String videoId);
}

class ThirdPartyYoutubeClass implements ThirdPartyYoutubeLib {

	@Override
	public HashMap<String, Video> popularVideos() {
		connectToServer("http://www.youtube.com");
		return getRandomVideos();
	}

	@Override
	public Video getVideo(String videoId) {
		connectToServer("http://www.youtube.com/" + videoId);
		return getSomeVideo(videoId);
	}

	private int random(int min, int max) {
		return min + (int) (Math.random() * ((max - min) + 1));
	}

	private void experienceNetworkLatency() {
		int randomLatency = random(5, 10);
		for (int i = 0; i < randomLatency; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

	private void connectToServer(String server) {
		System.out.print("Connecting to " + server + "... ");
		experienceNetworkLatency();
		System.out.print("Connected!" + "\n");
	}

	private HashMap<String, Video> getRandomVideos() {
		System.out.print("Downloading populars... ");

		experienceNetworkLatency();
		HashMap<String, Video> hmap = new HashMap<String, Video>();
		hmap.put("catzzzzzzzzz", new Video("sadgahasgdas", "Catzzzz.avi"));
		hmap.put("mkafksangasj", new Video("mkafksangasj", "Dog play with ball.mp4"));
		hmap.put("dancescideoo", new Video("asdfas3ffasd", "Dancing video.mpq"));
		hmap.put("dlsdk5jfslaf", new Video("dlsdk5jfslaf", "Barcelona vs RealM.mov"));
		hmap.put("3sdfgsd1j333", new Video("3sdfgsd1j333", "Programing lesson#1.avi"));

		System.out.print("Done!" + "\n");
		return hmap;
	}

	private Video getSomeVideo(String videoId) {
		System.out.print("Downloading video... ");

		experienceNetworkLatency();
		Video video = new Video(videoId, "Some video title");

		System.out.print("Done!" + "\n");
		return video;
	}

}

class Video {
	public String id;
	public String title;
	public String data;

	Video(String id, String title) {
		this.id = id;
		this.title = title;
		this.data = "Random video.";
	}
}

class YoutubeCacheProxy implements ThirdPartyYoutubeLib {
	private ThirdPartyYoutubeLib youtubeService;
	private HashMap<String, Video> cachePopular = new HashMap<String, Video>();
	private HashMap<String, Video> cacheAll = new HashMap<String, Video>();

	public YoutubeCacheProxy() {
		this.youtubeService = new ThirdPartyYoutubeClass();
	}

	@Override
	public HashMap<String, Video> popularVideos() {
		if (cachePopular.isEmpty()) {
			cachePopular = youtubeService.popularVideos();
		} else {
			System.out.println("Retrieved list from cache.");
		}
		return cachePopular;
	}

	@Override
	public Video getVideo(String videoId) {
		Video video = cacheAll.get(videoId);
		if (video == null) {
			video = youtubeService.getVideo(videoId);
			cacheAll.put(videoId, video);
		} else {
			System.out.println("Retrieved video '" + videoId + "' from cache.");
		}
		return video;
	}

	public void reset() {
		cachePopular.clear();
		cacheAll.clear();
	}
}

class YoutubeDownloader {
	private ThirdPartyYoutubeLib api;

	public YoutubeDownloader(ThirdPartyYoutubeLib api) {
		this.api = api;
	}

	public void renderVideoPage(String videoId) {
		Video video = api.getVideo(videoId);
		System.out.println("\n-------------------------------");
		System.out.println("Video page (imagine fancy HTML)");
		System.out.println("ID: " + video.id);
		System.out.println("Title: " + video.title);
		System.out.println("Video: " + video.data);
		System.out.println("-------------------------------\n");
	}

	public void renderPopularVideos() {
		HashMap<String, Video> list = api.popularVideos();
		System.out.println("\n-------------------------------");
		System.out.println("Most popular videos on Youtube (imagine fancy HTML)");
		for (Video video : list.values()) {
			System.out.println("ID: " + video.id + " / Title: " + video.title);
		}
		System.out.println("-------------------------------\n");
	}

}
public class Demo {

    public static void main(String[] args) {
        YoutubeDownloader naiveDownloader = new YoutubeDownloader(new ThirdPartyYoutubeClass());
        YoutubeDownloader smartDownloader = new YoutubeDownloader(new YoutubeCacheProxy());

        long naive = test(naiveDownloader);
        long smart = test(smartDownloader);
        System.out.print("Time saved by caching proxy: " + (naive - smart) + "ms");

    }

    private static long test(YoutubeDownloader downloader) {
        long startTime = System.currentTimeMillis();

        downloader.renderPopularVideos();
        downloader.renderVideoPage("catzzzzzzzzz");
        downloader.renderPopularVideos();
        downloader.renderVideoPage("dancesvideoo");
        
        downloader.renderVideoPage("catzzzzzzzzz");
        downloader.renderVideoPage("someothervid");

        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.print("Time elapsed: " + estimatedTime + "ms\n");
        return estimatedTime;
    }
}