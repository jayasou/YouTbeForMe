package com.sapher.youtubedl.main;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.sapher.manageApp.DownloadVideo;
import com.sapher.manageApp.WebCrawler;
import com.sapher.youtubedl.YoutubeDL;
import com.sapher.youtubedl.YoutubeDLException;
import com.sapher.youtubedl.mapper.VideoInfo;

public class Main {
	public static void main(String[] args) throws YoutubeDLException {
		String url = "https://www.youtube.com" +
		"/playlist?list=PLuHgQVnccGMBe0848t2_ZUgFNJdanOA_I";

		/*String url2 = "https://www.youtube.com/watch?v=-VRfO2hlf54&list=PLuHgQVnccGMBe0848t2_ZUgFNJdanOA_I&index=2&t=0s";

		VideoInfo info = YoutubeDL.getVideoInfo(url2);

		System.out.println(info.getClass().getName());
		System.out.println(info.title.getClass().getName());
		System.out.println(info.title.toString().getClass().getName());
*/




		List<VideoInfo> videoInfos = new ArrayList<>();
		if(url.contains("playlist")) {
			List<String> urlList = WebCrawler.webCrawling(url);

			for (String URL : urlList) {
				videoInfos.add(YoutubeDL.getVideoInfo(URL));
			}


		}


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
