package com.sapher.youtubedl.main;

import java.util.List;

import com.sapher.manageApp.DownloadVideo;
import com.sapher.manageApp.WebCrawler;
import com.sapher.youtubedl.YoutubeDLException;

public class Main {
	public static void main(String[] args) {

		WebCrawler crawler = new WebCrawler();
		List<String> videoList = crawler.webCrawling("https://www.youtube.com/playlist?list=PLuHgQVnccGMBe0848t2_ZUgFNJdanOA_I");


		DownloadVideo dv = new DownloadVideo("/Users/jisu/Downloads/testDown/");
		videoList.stream().forEach((s) -> {
			try {
				dv.download(s);
			} catch (YoutubeDLException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		});
	}
}
