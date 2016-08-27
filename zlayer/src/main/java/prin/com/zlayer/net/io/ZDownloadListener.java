package prin.com.zlayer.net.io;

/**
 * Created by prin on 2016/8/27.
 * 下载监听
 */
public interface ZDownloadListener extends ZIOListener{

    void onDownloadProgress(long byteRead, long contentLength, boolean done);

}
