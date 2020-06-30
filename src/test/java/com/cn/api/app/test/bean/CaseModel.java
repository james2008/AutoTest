package com.cn.api.app.test.bean;

import com.google.gson.annotations.SerializedName;
import lombok.ToString;

import java.util.List;


@ToString
public class CaseModel<T> {

    private String id;
    @SerializedName("case")
    private List<CheckCase> checkCase;
    private String desc;

    public List<CheckCase> getCheckCase() {
        return checkCase;
    }

    public void setCheckCase(List<CheckCase> caseList) {
        this.checkCase = caseList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @ToString
    public class CheckCase {
        private String log;
        private String param;
        private String service;
        private String id;
        private String desc;

        public String getLog() {
            return log;
        }

        public void setLog(String log) {
            this.log = log;
        }

        public String getParam() {
            return param;
        }

        public void setParam(String param) {
            this.param = param;
        }

        public String getService() {
            return service;
        }

        public void setService(String service) {
            this.service = service;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}
