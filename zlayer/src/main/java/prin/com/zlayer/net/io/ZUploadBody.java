package prin.com.zlayer.net.io;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

/**
 * Created by prin on 2016/8/27.
 * 上传体包装，用于处理进度
 */
public class ZUploadBody extends RequestBody {

    private RequestBody mRequestBody;   //实际的代包装请求体
    private ZUploadListener mListener;  //进度回调接口
    private BufferedSink mBufferedSink; //包装完成的BufferedSink

    public ZUploadBody(RequestBody requestBody, ZUploadListener listener) {
        mRequestBody = requestBody;
        mListener = listener;
    }

    /**
     * 重写调用实际请求体的contentType
     *
     * @return
     */
    @Override
    public MediaType contentType() {
        return mRequestBody.contentType();
    }

    /**
     * 重写调用实际请求体的contentLength
     *
     * @return
     * @throws IOException
     */
    @Override
    public long contentLength() throws IOException {
        return mRequestBody.contentLength();
    }

    /**
     * 重新进行写入
     *
     * @param sink
     * @throws IOException
     */
    @Override
    public void writeTo(BufferedSink sink) throws IOException {
        if (mBufferedSink == null) {
            mBufferedSink = Okio.buffer(sink(sink));
        }
        //写入
        mRequestBody.writeTo(mBufferedSink);
        //必须调用flush 否则最后一部分的数据可能不会被写入
        mBufferedSink.flush();
    }

    /**
     * 写入 回调进度接口
     */
    private Sink sink(Sink sink) {
        return new ForwardingSink(sink) {
            //当前写入字节数
            long byteWritten = 0L;
            //总字节长度 避免多次调用contentLength()
            long contentLength = 0L;

            @Override
            public void write(Buffer source, long byteCount) throws IOException {
                super.write(source, byteCount);
                if (contentLength == 0) {
                    //获得contentLength的值 后续不用再调用
                    contentLength = contentLength();
                }
                //增加当前写入字节数
                byteWritten += byteCount;
                //回调
                if (mListener != null) {
                    mListener.onUploadProgress(byteWritten, contentLength, byteWritten == contentLength);
                }
            }
        };
    }
}
