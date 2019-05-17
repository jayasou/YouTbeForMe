package com.sapher.youtubedl.main;

import com.sapher.youtubedl.YoutubeDLException;
import com.sun.deploy.Environment;

public class Main {
	public static void main(String[] args) throws YoutubeDLException {
		String url = "https://www.youtube.com/playlist?list=PLuHgQVnccGMBe0848t2_ZUgFNJdanOA_I";

		/*String url2 = "https://www.youtube.com/watch?v=-VRfO2hlf54&list=PLuHgQVnccGMBe0848t2_ZUgFNJdanOA_I&index=2&t=0s";

		VideoInfo info = YoutubeDL.getVideoInfo(url2);

		System.out.println(info.getClass().getName());
		System.out.println(info.title.getClass().getName());
		System.out.println(info.title.toString().getClass().getName());
*/

		String env = Environment.getenv("ProgramFiles");
		System.out.println(env);
		System.out.println( System.getProperty("os.name").toLowerCase());
		System.out.println( System.getProperty("user.name").toLowerCase());
//		System.out.println(System.getenv());

		String osName = System.getProperty("os.name").toLowerCase();
		String user = System.getProperty("user.name");

//		osName = "window";
		System.out.println(osName.contains("x"));
		if(osName.contains("mac")) {
			String downloadPath = "/Users/" + user + "/Downloads/";
			System.out.println(downloadPath);
		} else {
			String downloadPath = "C:\\Users\\" + user + "\\Downloads\\";
			System.out.println(downloadPath);
		}

		/*List<VideoInfo> videoInfos = new ArrayList();
		if(url.contains("playlist")) {
			List<String> urlList = WebCrawler.webCrawling(url);

			for (String URL : urlList) {
				videoInfos.add(YoutubeDL.getVideoInfo(URL));
			}
/Users/jisu/eclipse-workspace/youtubedl/src/main/java/com/sapher/youtubedl/main/Main.java

		}*/

		/*/Users/jisu/Downloads
		C:\Users\jisu\Downloads*/


		/*videoInfos.forEach(
				(videoInfo -> System.out.println(videoInfo.title))
		);*/
		/*DownloadVideo dv = new DownloadVideo("/Users/jisu/Downloads/testDown/");
		videoList.stream().forEach((s) -> {
			try {
				dv.download(s);
			} catch (YoutubeDLException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		});*/
	}

}
