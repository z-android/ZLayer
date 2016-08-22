package com.prin.zlayer.lib.net;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by prin on 2016/8/22.
 */
public interface ContentBody extends ContentDescriptor {
String getFilename();

void writeTo(OutputStream os,WriteByteListener var2) throws IOException;
}
