package prin.com.retrofit.model;

import java.util.List;

/**
 * Created by prin on 2016/8/24.
 */
public class RspFamous extends RspBase{
    /**
     * total : 10
     * result : [{"famous_name":"佚名","famous_saying":"婚姻是一家私人专门银行，存储真爱和默契，提取幸福和快乐。夫妻双方互为账户，且存折是活期的，可以随存随取，而家庭则是这家银行里的柜台，通过它，夫妻双方可以把自己的喜怒哀乐尽情地存进对方的银行里，并可随时提取微笑、鼓励、安慰、体贴、温柔等利息。"},{"famous_name":"英国","famous_saying":"真爱无坦途"},{"famous_name":"狄太人","famous_saying":"一个人真爱的时候，甚至会想不到自己是爱着对方。"},{"famous_name":"佚名","famous_saying":"所有的阻碍，全是对真爱的淬炼。"},{"famous_name":"罗兰","famous_saying":"当你真爱一个人的时候，你是会忘记自己的苦乐得失，而只是关心对方的苦乐得失的。"},{"famous_name":"罗兰","famous_saying":"当两人之间有真爱情的时候，是不会考虑到年龄的问题，经济的条件，相貌的美丑，个子的高矮，等等外在的无关紧要的因素的。假如你们之间存在着这种问题，那你要先问问自己，是否真正在爱才好。"},{"famous_name":"佚名","famous_saying":"真正的勇气是来自内心的真爱。"},{"famous_name":"佚名","famous_saying":"天国般的幸福，存在于对真爱的希望。"},{"famous_name":"狄太人","famous_saying":"一个人真爱的时候，甚至会想不到自己是爱着对方"},{"famous_name":"Shakespeare","famous_saying":"通向真爱的路从无坦途。"}]
     * error_code : 0
     * reason : Succes
     */

    private int total;
    private int error_code;
    private String reason;
    /**
     * famous_name : 佚名
     * famous_saying : 婚姻是一家私人专门银行，存储真爱和默契，提取幸福和快乐。夫妻双方互为账户，且存折是活期的，可以随存随取，而家庭则是这家银行里的柜台，通过它，夫妻双方可以把自己的喜怒哀乐尽情地存进对方的银行里，并可随时提取微笑、鼓励、安慰、体贴、温柔等利息。
     */

    private List<ResultBean> result;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        private String famous_name;
        private String famous_saying;

        public String getFamous_name() {
            return famous_name;
        }

        public void setFamous_name(String famous_name) {
            this.famous_name = famous_name;
        }

        public String getFamous_saying() {
            return famous_saying;
        }

        public void setFamous_saying(String famous_saying) {
            this.famous_saying = famous_saying;
        }
    }
}
