package com.woker.choosehotspot.activity.model;

import java.util.List;

/**
 * Created by T on 2017/12/6.
 * popupwindow弹窗中选择负责人
 */

public class ResonsibleModel {

    /**
     * code : 200
     * message : 获取成功
     * data : [{"name":"陈术","mobile":"13809539969"},{"name":"陆廷尧","mobile":"15060068871"},{"name":"檀飞雪","mobile":"15396028377"},{"name":"林仙彪","mobile":"18950221559"},{"name":"程志江","mobile":"18059123779"},{"name":"郑孔恒","mobile":"18059128789"},{"name":"侯仰嵩","mobile":"13774595795"},{"name":"王彬","mobile":"18950220667"},{"name":"张水银","mobile":"18950219739"}]
     */

    private String code;
    private String message;
    private List<DataBean> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * name : 陈术
         * mobile : 13809539969
         */

        private String name;
        private String mobile;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }
    }
}
