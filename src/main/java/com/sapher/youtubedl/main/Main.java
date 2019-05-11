package com.sapher.youtubedl.main;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.sapher.manageApp.DownloadVideo;
import com.sapher.manageApp.WebCrawler;
import com.sapher.youtubedl.YoutubeDL;
import com.sapher.youtubedl.YoutubeDLException;
import com.sapher.youtubedl.mapper.VideoInfo;
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
		System.out.println(System.getenv());

		String osName = System.getProperty("os.name");
		String user = System.getProperty("user.name");

		osName = "window";

		if(osName.contains("mac")) {
			String downloadPath = "/Users/" + user + "/Downloads";
			System.out.println(downloadPath);
		} else {
			String downloadPath = "C:\\Users\\" + user + "\\Downloads";
			System.out.println(downloadPath);
		}

		/*List<VideoInfo> videoInfos = new ArrayList();
		if(url.contains("playlist")) {
			List<String> urlList = WebCrawler.webCrawling(url);

			for (String URL : urlList) {
				videoInfos.add(YoutubeDL.getVideoInfo(URL));
			}


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
