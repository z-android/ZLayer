package com.prin.zlayer.lib.net;

/**
 * Created by prin on 2016/8/22.
 */
public interface ContentDescriptor {
    String getMimeType();

    String getMediaType();

    String getSubType();

    String getCharset();

    String getTransferEncoding();

    long getContentLength();

}
