package com.sapher.manageApp;

import com.sapher.youtubedl.YoutubeDL;
import com.sapher.youtubedl.YoutubeDLException;
import com.sapher.youtubedl.YoutubeDLRequest;
import com.sapher.youtubedl.YoutubeDLResponse;
import com.sapher.youtubedl.mapper.VideoInfo;

import java.io.File;

public class DownloadVideo {

    private static String directory;

    private static YoutubeDLRequest youtubeDLRequest;

    public DownloadVideo(String videoUrl, String directory) {
        this.youtubeDLRequest = new YoutubeDLRequest(videoUrl, directory);
        this.directory = directory;
    }

    public static void download(String videoUrl) throws YoutubeDLException {

        // Build request
        YoutubeDL.setExecutablePath("/usr/local/bin/youtube-dl");
        youtubeDLRequest.setOption("ignore-errors");		// --ignore-errors
        youtubeDLRequest.setOption("output", "%(id)s");	// --output "%(id)s"
        youtubeDLRequest.setOption("retries", 10);		// --retries 10

        // Make request and return response
        YoutubeDLResponse response = YoutubeDL.execute(youtubeDLRequest);
		/*YoutubeDLResponse response = YoutubeDL.execute(request, new DownloadProgressCallback() {
	          @Override
	          public void onProgressUpdate(float progress, long etaInSeconds) {
	              System.out.println(String.valueOf(progress) + "%");
	          }
	      });*/


        VideoInfo videoInfo = YoutubeDL.getVideoInfo(videoUrl);
        String downloadName = directory + videoInfo.id;
        File chkFile = new File(downloadName);


        System.out.println(chkFile.exists());
        if(chkFile.exists()) {
            String fullName = directory + videoInfo.title + ".mp4";
            chkFile.renameTo(new File(fullName));
        }

        // Response
        String stdOut = response.getOut(); // Executable output
    }

}
