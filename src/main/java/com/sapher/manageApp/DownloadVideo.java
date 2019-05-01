package com.sapher.manageApp;

import com.sapher.youtubedl.YoutubeDL;
import com.sapher.youtubedl.YoutubeDLException;
import com.sapher.youtubedl.YoutubeDLRequest;
import com.sapher.youtubedl.YoutubeDLResponse;
import com.sapher.youtubedl.mapper.VideoInfo;

import java.io.File;

public class DownloadVideo {

    private static String directory;

    public DownloadVideo(String directory) {
        this.directory = directory;
    }

    public static void download(String videoUrl) throws YoutubeDLException {

        // Build request
        YoutubeDL.setExecutablePath("/usr/local/bin/youtube-dl");
        YoutubeDLRequest request = new YoutubeDLRequest(videoUrl, directory);
        request.setOption("ignore-errors");		// --ignore-errors
        request.setOption("output", "%(id)s");	// --output "%(id)s"
        request.setOption("retries", 10);		// --retries 10

        // Make request and return response
        YoutubeDLResponse response = YoutubeDL.execute(request);
		/*YoutubeDLResponse response = YoutubeDL.execute(request, new DownloadProgressCallback() {
	          @Override
	          public void onProgressUpdate(float progress, long etaInSeconds) {
	              System.out.println(String.valueOf(progress) + "%");
	          }
	      });*/


        VideoInfo videoInfo = YoutubeDL.getVideoInfo(videoUrl);
        String downloadName = directory + videoInfo.id;
        System.out.println(downloadName);
        System.out.println(videoInfo.id);

        File chkFile = new File(downloadName);
        if(chkFile.exists()) {
            chkFile.renameTo(new File(directory + videoInfo.title + ".mp4"));
            System.out.println(directory + videoInfo.title + ".mp4");
        }

        // Response
        String stdOut = response.getOut(); // Executable output
    }

}
