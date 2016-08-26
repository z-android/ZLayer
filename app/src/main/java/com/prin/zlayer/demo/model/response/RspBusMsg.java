package com.prin.zlayer.demo.model.response;

import java.util.List;

/**
 * Created by prin on 2016/8/25.
 */
public class RspBusMsg extends RspBase{

    /**
     * reason : 查询成功
     * result : {"title":"高淳长途汽车站_时刻表","list":[{"name":"南京高淳汽车客运站","tel":"025-57335209/57335212","adds":"高淳县淳溪镇丹阳湖北路28号"}]}
     * error_code : 0
     */

    private String reason;
    /**
     * title : 高淳长途汽车站_时刻表
     * list : [{"name":"南京高淳汽车客运站","tel":"025-57335209/57335212","adds":"高淳县淳溪镇丹阳湖北路28号"}]
     */

    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        private String title;
        /**
         * name : 南京高淳汽车客运站
         * tel : 025-57335209/57335212
         * adds : 高淳县淳溪镇丹阳湖北路28号
         */

        private List<ListBean> list;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            private String name;
            private String tel;
            private String adds;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getTel() {
                return tel;
            }

            public void setTel(String tel) {
                this.tel = tel;
            }

            public String getAdds() {
                return adds;
            }

            public void setAdds(String adds) {
                this.adds = adds;
            }
        }
    }
}
