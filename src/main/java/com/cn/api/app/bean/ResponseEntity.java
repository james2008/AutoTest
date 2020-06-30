package com.cn.api.app.bean;

public class ResponseEntity extends BaseEntity<ResponseEntity.ResultEntity> {

    public static class ResultEntity {
        private String errCode;
        private String errMsg;

        public void setErrCode(String errCode) {
            this.errCode = errCode;
        }

        public void setErrMsg(String errMsg) {
            this.errMsg = errMsg;
        }


        public String getErrCode() {
            return errCode;
        }

        public String getErrMsg() {
            return errMsg;
        }
    }
}
