package prin.com.zlayer.net.io;

/**
 * Created by prin on 2016/8/27.
 * 上传监听
 */
public interface ZUploadListener extends ZIOListener{
    void onUploadProgress(long byteWritten, long contentLength, boolean done);
}
