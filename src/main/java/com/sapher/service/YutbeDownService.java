package com.sapher.service;

import com.sapher.youtubedl.YoutubeDLException;
import com.sapher.youtubedl.mapper.VideoInfo;

import java.util.List;

public interface YutbeDownService {

    List<VideoInfo> youtubeDownload(String url) throws YoutubeDLException;

}
