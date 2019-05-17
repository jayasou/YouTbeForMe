package com.sapher.service;

import com.sapher.youtubedl.YoutubeDLException;
import com.sapher.youtubedl.mapper.VideoInfo;

import java.util.List;

public interface YutbeDownService {

    List<VideoInfo> getVideoList(String url) throws YoutubeDLException;

    String getDownloadPath();

    void download(List<String> url, String downloadPath);
}
