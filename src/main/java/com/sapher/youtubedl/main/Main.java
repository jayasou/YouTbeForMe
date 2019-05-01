package com.sapher.youtubedl.main;

import java.io.File;

import com.sapher.youtubedl.DownloadProgressCallback;
import com.sapher.youtubedl.YoutubeDL;
import com.sapher.youtubedl.YoutubeDLException;
import com.sapher.youtubedl.YoutubeDLRequest;
import com.sapher.youtubedl.YoutubeDLResponse;

public class Main {
	public static void main(String[] args) throws YoutubeDLException {
		// Video url to download
		String videoUrl = "https://www.youtube.com/watch?v=yQyTdZiNugY";

		// Build request
		YoutubeDL.setExecutablePath("/usr/local/bin/youtube-dl");
		YoutubeDLRequest request = new YoutubeDLRequest(videoUrl, "/Users/jisu/Downloads");
		request.setOption("ignore-errors");		// --ignore-errors
		request.setOption("output", "%(id)s");	// --output "%(id)s"
		request.setOption("retries", 10);		// --retries 10

		// Make request and return response
//		YoutubeDLResponse response = YoutubeDL.execute(request);
		YoutubeDLResponse response = YoutubeDL.execute(request, new DownloadProgressCallback() {
	          @Override
	          public void onProgressUpdate(float progress, long etaInSeconds) {
	              System.out.println(String.valueOf(progress) + "%");
	          }
	      });
		
		File chkFile = new File("/Users/jisu/Downloads/yQyTdZiNugY");
		if(chkFile.exists()) {
			System.out.println("exist !!");
			chkFile.renameTo(new File("/Users/jisu/Downloads/yQyTdZiNugY.mp4"));
		}

		// Response
		String stdOut = response.getOut(); // Executable output
	}
}
