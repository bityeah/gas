package cn.demo.gas.pay.util;

/**
 * Created by zhaohg on 2017/7/28.
 */
public class  StatusCode {
    public enum LEVEL {
        SERVER {
            @Override
            public int getCode(){
                return 1;
            }
        };

        public abstract int getCode();
    }

    public enum MODEL {

        ACCOUNT {
            @Override
            public int getCode() {
                return 1;
            }

            @Override
            public String getMsg() {
                return "账号";
            }
        },

        USERTYPE {
            @Override
            public int getCode() {
                return 2;
            }

            @Override
            public String getMsg() {
                return "3";
            }
        },

        MOBILE {
            @Override
            public int getCode() {
                return 4;
            }

            @Override
            public String getMsg() {
                return "手机号码";
            }
        };


        public abstract int getCode();
        public abstract String getMsg();
    }


    public enum ERROR {

        NOT_FOUND {
            @Override
            public int getCode() {
                return 1;
            }

            @Override
            public String getMsg() {
                return "未找到";
            }
        },

        NOT_NULL {
            @Override
            public int getCode() {
                return 2;
            }

            @Override
            public String getMsg() {
                return "不能为空";
            }
        },

        NOT_CORRECT {
            @Override
            public int getCode() {
                return 3;
            }

            @Override
            public String getMsg() {
                return "不正确";
            }
        },

        FAILED {
            @Override
            public int getCode() {
                return 4;
            }

            @Override
            public String getMsg() {
                return "失败";
            }
        },

        PARAMETER_ERROR {

            @Override
            public int getCode() {
                return 5;
            }

            @Override
            public String getMsg() {
                return "参数错误";
            }
        },

        NOT_SUPPORT_METHOD {
            @Override
            public int getCode() {
                return 6;
            }

            @Override
            public String getMsg() {
                return "不支持该方法";
            }
        },

        PROCESS_ERROR {
            @Override
            public int getCode() {
                return 7;
            }

            @Override
            public String getMsg() {
                return "执行出错";
            }
        },

        INVALID {
            @Override
            public int getCode() {
                return 8;
            }

            @Override
            public String getMsg() {
                return "失效";
            }
        },

        EXIST {
            @Override
            public int getCode() {
                return 9;
            }

            @Override
            public String getMsg() {
                return "已经存在";
            }
        },

        FORMAT_ERROR {
            @Override
            public int getCode() {
                return 10;
            }

            @Override
            public String getMsg() {
                return "格式错误";
            }
        };


        public abstract int getCode();
        public abstract String getMsg();
    }


    public static class Status{
        public int code;
        public String msg;
        public Status(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }

    public static Status getOKStatus(String overMsg) {
        return new Status(200, overMsg);
    }
}
