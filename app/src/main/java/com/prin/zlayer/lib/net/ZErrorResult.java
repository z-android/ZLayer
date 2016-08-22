package com.prin.zlayer.lib.net;

/**
 * Created by prin on 2016/8/22.
 */
public class ZErrorResult {
    private int errCode;
    private String errMsg;

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getMessage() {
        return "错误码：" + errCode + " 错误信息：" + errMsg;
    }
}
