package com.prin.zlayer.demo.model.response;

import java.util.List;

/**
 * Created by prin on 2016/8/25.
 */
public class RspQueryAb extends RspBase{
    /**
     * reason : 查询成功
     * result : {"title":"南京到南陵_汽车时刻及票价查询","list":[{"start":"南京汽车客运站","arrive":"南陵","date":"07:40","price":"53元"},{"start":"南京汽车客运站","arrive":"南陵","date":"07:40","price":"53元"},{"start":"南京汽车客运站","arrive":"南陵","date":"07:40","price":"53元"},{"start":"南京汽车客运站","arrive":"南陵","date":"08:30","price":"53元"},{"start":"南京汽车客运站","arrive":"南陵","date":"08:30","price":"53元"},{"start":"南京汽车客运站","arrive":"南陵","date":"08:30","price":"53元"},{"start":"南京客运南站","arrive":"南陵","date":"08:50","price":"52元"},{"start":"南京客运南站","arrive":"南陵","date":"09:25","price":"52元"},{"start":"南京客运南站","arrive":"南陵","date":"09:25","price":"52元"},{"start":"南京客运南站","arrive":"南陵","date":"09:25","price":"52元"},{"start":"南京汽车客运站","arrive":"南陵","date":"09:40","price":"53元"},{"start":"南京汽车客运站","arrive":"南陵","date":"09:40","price":"53元"},{"start":"南京汽车客运站","arrive":"南陵","date":"09:40","price":"53元"},{"start":"南京东站","arrive":"南陵","date":"10:00","price":"53元"},{"start":"南京东站","arrive":"南陵","date":"10:00","price":"53元"},{"start":"南京东站","arrive":"南陵","date":"10:00","price":"53元"},{"start":"南京东站","arrive":"南陵","date":"11:20","price":"52元"},{"start":"南京东站","arrive":"南陵","date":"11:20","price":"52元"},{"start":"南京东站","arrive":"南陵","date":"11:20","price":"52元"},{"start":"南京客运南站","arrive":"南陵","date":"11:55","price":"52元"},{"start":"南京客运南站","arrive":"南陵","date":"11:55","price":"52元"},{"start":"南京客运南站","arrive":"南陵","date":"11:55","price":"52元"},{"start":"南京汽车客运站","arrive":"南陵","date":"12:20","price":"53元"},{"start":"南京汽车客运站","arrive":"南陵","date":"12:20","price":"53元"},{"start":"南京汽车客运站","arrive":"南陵","date":"12:20","price":"53元"},{"start":"南京汽车客运站","arrive":"南陵","date":"13:00","price":"53元"},{"start":"南京汽车客运站","arrive":"南陵","date":"13:00","price":"53元"},{"start":"南京汽车客运站","arrive":"南陵","date":"13:00","price":"53元"},{"start":"南京客运南站","arrive":"南陵","date":"14:00","price":"52元"},{"start":"南京客运南站","arrive":"南陵","date":"14:00","price":"52元"},{"start":"南京客运南站","arrive":"南陵","date":"14:00","price":"52元"},{"start":"南京汽车客运站","arrive":"南陵","date":"14:00","price":"52元"},{"start":"南京汽车客运站","arrive":"南陵","date":"14:00","price":"52元"},{"start":"南京汽车客运站","arrive":"南陵","date":"14:00","price":"52元"},{"start":"南京汽车客运站","arrive":"南陵","date":"14:20","price":"53元"},{"start":"南京汽车客运站","arrive":"南陵","date":"14:20","price":"53元"},{"start":"南京汽车客运站","arrive":"南陵","date":"14:20","price":"53元"},{"start":"南京汽车客运站","arrive":"南陵","date":"14:50","price":"52元"},{"start":"南京东站","arrive":"南陵","date":"16:00","price":"53元"},{"start":"南京汽车客运站","arrive":"南陵","date":"16:00","price":"52元"},{"start":"南京汽车客运站","arrive":"南陵","date":"16:00","price":"52元"},{"start":"南京汽车客运站","arrive":"南陵","date":"16:00","price":"52元"},{"start":"南京客运南站","arrive":"南陵","date":"16:10","price":"52元"},{"start":"南京客运南站","arrive":"南陵","date":"16:10","price":"52元"},{"start":"南京客运南站","arrive":"南陵","date":"16:10","price":"52元"},{"start":"南京汽车客运站","arrive":"南陵","date":"16:20","price":"53元"},{"start":"南京东站","arrive":"南陵","date":"18:40","price":"53元"},{"start":"南京东站","arrive":"南陵","date":"18:40","price":"53元"},{"start":"南京东站","arrive":"南陵","date":"18:40","price":"53元"},{"start":"南京汽车客运站","arrive":"南陵","date":"19:00","price":"53元"},{"start":"南京汽车客运站","arrive":"南陵","date":"19:00","price":"53元"},{"start":"南京汽车客运站","arrive":"南陵","date":"19:00","price":"53元"}]}
     * error_code : 0
     */

    private String reason;
    /**
     * title : 南京到南陵_汽车时刻及票价查询
     * list : [{"start":"南京汽车客运站","arrive":"南陵","date":"07:40","price":"53元"},{"start":"南京汽车客运站","arrive":"南陵","date":"07:40","price":"53元"},{"start":"南京汽车客运站","arrive":"南陵","date":"07:40","price":"53元"},{"start":"南京汽车客运站","arrive":"南陵","date":"08:30","price":"53元"},{"start":"南京汽车客运站","arrive":"南陵","date":"08:30","price":"53元"},{"start":"南京汽车客运站","arrive":"南陵","date":"08:30","price":"53元"},{"start":"南京客运南站","arrive":"南陵","date":"08:50","price":"52元"},{"start":"南京客运南站","arrive":"南陵","date":"09:25","price":"52元"},{"start":"南京客运南站","arrive":"南陵","date":"09:25","price":"52元"},{"start":"南京客运南站","arrive":"南陵","date":"09:25","price":"52元"},{"start":"南京汽车客运站","arrive":"南陵","date":"09:40","price":"53元"},{"start":"南京汽车客运站","arrive":"南陵","date":"09:40","price":"53元"},{"start":"南京汽车客运站","arrive":"南陵","date":"09:40","price":"53元"},{"start":"南京东站","arrive":"南陵","date":"10:00","price":"53元"},{"start":"南京东站","arrive":"南陵","date":"10:00","price":"53元"},{"start":"南京东站","arrive":"南陵","date":"10:00","price":"53元"},{"start":"南京东站","arrive":"南陵","date":"11:20","price":"52元"},{"start":"南京东站","arrive":"南陵","date":"11:20","price":"52元"},{"start":"南京东站","arrive":"南陵","date":"11:20","price":"52元"},{"start":"南京客运南站","arrive":"南陵","date":"11:55","price":"52元"},{"start":"南京客运南站","arrive":"南陵","date":"11:55","price":"52元"},{"start":"南京客运南站","arrive":"南陵","date":"11:55","price":"52元"},{"start":"南京汽车客运站","arrive":"南陵","date":"12:20","price":"53元"},{"start":"南京汽车客运站","arrive":"南陵","date":"12:20","price":"53元"},{"start":"南京汽车客运站","arrive":"南陵","date":"12:20","price":"53元"},{"start":"南京汽车客运站","arrive":"南陵","date":"13:00","price":"53元"},{"start":"南京汽车客运站","arrive":"南陵","date":"13:00","price":"53元"},{"start":"南京汽车客运站","arrive":"南陵","date":"13:00","price":"53元"},{"start":"南京客运南站","arrive":"南陵","date":"14:00","price":"52元"},{"start":"南京客运南站","arrive":"南陵","date":"14:00","price":"52元"},{"start":"南京客运南站","arrive":"南陵","date":"14:00","price":"52元"},{"start":"南京汽车客运站","arrive":"南陵","date":"14:00","price":"52元"},{"start":"南京汽车客运站","arrive":"南陵","date":"14:00","price":"52元"},{"start":"南京汽车客运站","arrive":"南陵","date":"14:00","price":"52元"},{"start":"南京汽车客运站","arrive":"南陵","date":"14:20","price":"53元"},{"start":"南京汽车客运站","arrive":"南陵","date":"14:20","price":"53元"},{"start":"南京汽车客运站","arrive":"南陵","date":"14:20","price":"53元"},{"start":"南京汽车客运站","arrive":"南陵","date":"14:50","price":"52元"},{"start":"南京东站","arrive":"南陵","date":"16:00","price":"53元"},{"start":"南京汽车客运站","arrive":"南陵","date":"16:00","price":"52元"},{"start":"南京汽车客运站","arrive":"南陵","date":"16:00","price":"52元"},{"start":"南京汽车客运站","arrive":"南陵","date":"16:00","price":"52元"},{"start":"南京客运南站","arrive":"南陵","date":"16:10","price":"52元"},{"start":"南京客运南站","arrive":"南陵","date":"16:10","price":"52元"},{"start":"南京客运南站","arrive":"南陵","date":"16:10","price":"52元"},{"start":"南京汽车客运站","arrive":"南陵","date":"16:20","price":"53元"},{"start":"南京东站","arrive":"南陵","date":"18:40","price":"53元"},{"start":"南京东站","arrive":"南陵","date":"18:40","price":"53元"},{"start":"南京东站","arrive":"南陵","date":"18:40","price":"53元"},{"start":"南京汽车客运站","arrive":"南陵","date":"19:00","price":"53元"},{"start":"南京汽车客运站","arrive":"南陵","date":"19:00","price":"53元"},{"start":"南京汽车客运站","arrive":"南陵","date":"19:00","price":"53元"}]
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
         * start : 南京汽车客运站
         * arrive : 南陵
         * date : 07:40
         * price : 53元
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
            private String start;
            private String arrive;
            private String date;
            private String price;

            public String getStart() {
                return start;
            }

            public void setStart(String start) {
                this.start = start;
            }

            public String getArrive() {
                return arrive;
            }

            public void setArrive(String arrive) {
                this.arrive = arrive;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }
        }
    }
}
