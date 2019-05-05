package com.sapher.youtubedl;

import com.sapher.youtubedl.mapper.VideoFormat;
import com.sapher.youtubedl.mapper.VideoInfo;
import com.sapher.youtubedl.mapper.VideoThumbnail;
import org.junit.Test;
import org.junit.Assert;

import java.util.List;

public class YoutubeDLTest {

    private final static String DIRECTORY = System.getProperty("java.io.tmpdir");
    private final static String VIDEO_URL = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";
    private final static String NONE_EXISTENT_VIDEO_URL = "https://www.youtube.com/watch?v=dQw4w9WgXcZ";

    /*@Test
    public void testUsingOwnExecutablePath() throws YoutubeDLException {
        YoutubeDL.setExecutablePath("/usr/local/bin/youtube-dl");
        Assert.assertNotNull(YoutubeDL.getVersion());
    }

    @Test
    public void testGetVersion() throws YoutubeDLException {
    	YoutubeDL.setExecutablePath("/usr/local/bin/youtube-dl");
        Assert.assertNotNull(YoutubeDL.getVersion());
    }

    @Test
    public void testElapsedTime() throws YoutubeDLException {

        long startTime = System.nanoTime();

        YoutubeDLRequest request = new YoutubeDLRequest();
        request.setOption("version");
        YoutubeDLResponse response = YoutubeDL.execute(request);

        int elapsedTime = (int) (System.nanoTime() - startTime);

        Assert.assertTrue(elapsedTime > response.getElapsedTime());
    }


    @Test
    public void testSimulateDownload() throws YoutubeDLException {

        YoutubeDLRequest request = new YoutubeDLRequest();
        request.setUrl(VIDEO_URL);
        request.setOption("simulate");

        YoutubeDLResponse response = YoutubeDL.execute(request);

        Assert.assertEquals("youtube-dl " + VIDEO_URL + " --simulate", response.getCommand());
    }

    @Test
    public void testDirectory() throws YoutubeDLException {

        YoutubeDLRequest request = new YoutubeDLRequest(VIDEO_URL, DIRECTORY);
        request.setOption("simulate");

        YoutubeDLResponse response = YoutubeDL.execute(request);

        Assert.assertEquals(DIRECTORY, response.getDirectory());
    }*/

    @Test
    public void testGetVideoInfo() throws YoutubeDLException {
        YoutubeDL.setExecutablePath("/usr/local/bin/youtube-dl");
        VideoInfo videoInfo = YoutubeDL.getVideoInfo("https://www.youtube.com/watch?v=7cR8rOx-f3A");

        System.out.println("title : "  + videoInfo.title);
        System.out.println("discription : " +videoInfo.description);
        System.out.println("duration : "  + videoInfo.duration);
        System.out.println("ext : "  + videoInfo.ext);
        System.out.println("format : "  + videoInfo.format);
        System.out.println("thumbnail : "  + videoInfo.thumbnail);
        System.out.println("httpHeader : "  + videoInfo.httpHeader);
        System.out.println("resolution : "  + videoInfo.resolution);
        System.out.println("fulltitle : "  + videoInfo.fulltitle);
        System.out.println("width : "  + videoInfo.width);
        System.out.println("height : "  + videoInfo.height);



        Assert.assertNotNull(videoInfo);
    }

    /*@Test
    public void testGetFormats() throws YoutubeDLException {
        List<VideoFormat> formats = YoutubeDL.getFormats(VIDEO_URL);
        Assert.assertNotNull(formats);
        Assert.assertTrue(formats.size() > 0);
    }

    @Test
    public void testGetThumbnails() throws YoutubeDLException {
        List<VideoThumbnail> thumbnails = YoutubeDL.getThumbnails(VIDEO_URL);
        Assert.assertNotNull(thumbnails);
        Assert.assertTrue(thumbnails.size() > 0);
    }

    @Test
    public void testGetTags() throws YoutubeDLException {
        List<String> tags = YoutubeDL.getTags(VIDEO_URL);
        Assert.assertNotNull(tags);
        Assert.assertTrue(tags.size() > 0);
    }

    @Test
    public void testGetCategories() throws YoutubeDLException {
        List<String> categories = YoutubeDL.getCategories(VIDEO_URL);
        Assert.assertNotNull(categories);
        Assert.assertTrue(categories.size() > 0);
    }

    @Test(expected = YoutubeDLException.class)
    public void testFailGetNonExistentVideoInfo() throws YoutubeDLException {
        YoutubeDL.getVideoInfo(NONE_EXISTENT_VIDEO_URL);
    }*/
}