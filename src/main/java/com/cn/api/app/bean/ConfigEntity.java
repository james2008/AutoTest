package com.cn.api.app.bean;

public class ConfigEntity extends BaseEntity<ConfigEntity.DataEntity> {

    public static class DataEntity {
        /**
         * signature : f06c6d35058f2168e0d14f4d81ccec5d4bff4b2c
         * appId : wxc1e8e84968f23d0d
         * nonceStr : 1584431971739
         * timestamp : 1584431971
         */
        private String signature;
        private String appId;
        private String nonceStr;
        private String timestamp;

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public void setAppId(String appId) {
            this.appId = appId;
        }

        public void setNonceStr(String nonceStr) {
            this.nonceStr = nonceStr;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public String getSignature() {
            return signature;
        }

        public String getAppId() {
            return appId;
        }

        public String getNonceStr() {
            return nonceStr;
        }

        public String getTimestamp() {
            return timestamp;
        }
    }
}
