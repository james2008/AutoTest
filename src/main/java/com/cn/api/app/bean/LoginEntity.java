package com.cn.api.app.bean;


public class LoginEntity extends BaseEntity<LoginEntity.ResultEntity.UserEntity> {

    /**
     * result : {"result":{"mPriceConsume":40763.48,"mnickname":"6LaF6LaK5qKm5oOz","mallOrderFlag":0,"mpwd":"","mPartnerShopId":10002050,"mfkm":"20021716590000009","mPartnerInviterType":"0","mcommission":0,"mbirthday":1137513600000,"mPartnerExpiry":"2023-02-18","uuid":"","mPartnerInviter":0,"mtype":0,"mclientSource":"","mlevel":"","maddtime":1574668492390,"m_token":"","mtruename":"","mInitInviterShopId":0,"mInitInviter":0,"mprice":40765.47,"mVipExpiry":"2021-01-02","mLon":116.352418,"readBonusFlag":0,"mbean":408.81,"mInviterShopId":0,"movertime":1582013997173,"mPartnerFlag":"1","mLat":39.914204,"shop":"","mheadurl":"https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLUyf1TicEccia9b37xrhKxD9iatdxDVKgEOyicVQAvjsQibn4Fg1fa88syc5JqMvhWpuXqlyQvKBXLJtg/132","mid":26251,"mfkmState":"0","mVipFlag":"1","groupOrderFlag":0,"minviter":0,"mrecommend":-1,"mPayPwd":"","mvalidtime":1581930249785,"mInviterType":"0","mPartnerInviterShopId":0,"groupPhoneFlag":0,"shopOrderFlag":0,"mAddrDetail":"12可口可乐了看看","mgrade":0,"msex":0,"token":"c8dad46ba8cb3c55e57933fb09ee0b05","mbindphonetime":1574668577085,"mcity":"北京市","mPriceWithdraw":1.99,"mInitInviterType":"0","mphone":"15801335965"},"errCode":"USER_200","errMsg":"成功"}
     * errCode : USER_200
     * errMsg : 成功
     */
    public static class ResultEntity {
        /**
         * result : {"mPriceConsume":40763.48,"mnickname":"6LaF6LaK5qKm5oOz","mallOrderFlag":0,"mpwd":"","mPartnerShopId":10002050,"mfkm":"20021716590000009","mPartnerInviterType":"0","mcommission":0,"mbirthday":1137513600000,"mPartnerExpiry":"2023-02-18","uuid":"","mPartnerInviter":0,"mtype":0,"mclientSource":"","mlevel":"","maddtime":1574668492390,"m_token":"","mtruename":"","mInitInviterShopId":0,"mInitInviter":0,"mprice":40765.47,"mVipExpiry":"2021-01-02","mLon":116.352418,"readBonusFlag":0,"mbean":408.81,"mInviterShopId":0,"movertime":1582013997173,"mPartnerFlag":"1","mLat":39.914204,"shop":"","mheadurl":"https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLUyf1TicEccia9b37xrhKxD9iatdxDVKgEOyicVQAvjsQibn4Fg1fa88syc5JqMvhWpuXqlyQvKBXLJtg/132","mid":26251,"mfkmState":"0","mVipFlag":"1","groupOrderFlag":0,"minviter":0,"mrecommend":-1,"mPayPwd":"","mvalidtime":1581930249785,"mInviterType":"0","mPartnerInviterShopId":0,"groupPhoneFlag":0,"shopOrderFlag":0,"mAddrDetail":"12可口可乐了看看","mgrade":0,"msex":0,"token":"c8dad46ba8cb3c55e57933fb09ee0b05","mbindphonetime":1574668577085,"mcity":"北京市","mPriceWithdraw":1.99,"mInitInviterType":"0","mphone":"15801335965"}
         * errCode : USER_200
         * errMsg : 成功
         */
        private String errMsg;

        private String errCode;

        private UserEntity userEntity;

        public String getErrMsg() {
            return errMsg;
        }

        public void setErrMsg(String errMsg) {
            this.errMsg = errMsg;
        }

        public String getErrCode() {
            return errCode;
        }

        public void setErrCode(String errCode) {
            this.errCode = errCode;
        }

        public UserEntity getUserEntity() {
            return userEntity;
        }

        public void setUserEntity(UserEntity userEntity) {
            this.userEntity = userEntity;
        }

        public static class UserEntity {
            /**
             * mPriceConsume : 40763.48
             * mnickname : 6LaF6LaK5qKm5oOz
             * mallOrderFlag : 0
             * mpwd :
             * mPartnerShopId : 10002050
             * mfkm : 20021716590000009
             * mPartnerInviterType : 0
             * mcommission : 0
             * mbirthday : 1137513600000
             * mPartnerExpiry : 2023-02-18
             * uuid :
             * mPartnerInviter : 0
             * mtype : 0
             * mclientSource :
             * mlevel :
             * maddtime : 1574668492390
             * m_token :
             * mtruename :
             * mInitInviterShopId : 0
             * mInitInviter : 0
             * mprice : 40765.47
             * mVipExpiry : 2021-01-02
             * mLon : 116.352418
             * readBonusFlag : 0
             * mbean : 408.81
             * mInviterShopId : 0
             * movertime : 1582013997173
             * mPartnerFlag : 1
             * mLat : 39.914204
             * shop :
             * mheadurl : https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLUyf1TicEccia9b37xrhKxD9iatdxDVKgEOyicVQAvjsQibn4Fg1fa88syc5JqMvhWpuXqlyQvKBXLJtg/132
             * mid : 26251
             * mfkmState : 0
             * mVipFlag : 1
             * groupOrderFlag : 0
             * minviter : 0
             * mrecommend : -1
             * mPayPwd :
             * mvalidtime : 1581930249785
             * mInviterType : 0
             * mPartnerInviterShopId : 0
             * groupPhoneFlag : 0
             * shopOrderFlag : 0
             * mAddrDetail : 12可口可乐了看看
             * mgrade : 0
             * msex : 0
             * token : c8dad46ba8cb3c55e57933fb09ee0b05
             * mbindphonetime : 1574668577085
             * mcity : 北京市
             * mPriceWithdraw : 1.99
             * mInitInviterType : 0
             * mphone : 15801335965
             */
            private double mPriceConsume;
            private String mnickname;
            private int mallOrderFlag;
            private String mpwd;
            private int mPartnerShopId;
            private String mfkm;
            private String mPartnerInviterType;
            private int mcommission;
            private long mbirthday;
            private String mPartnerExpiry;
            private String uuid;
            private int mPartnerInviter;
            private int mtype;
            private String mclientSource;
            private String mlevel;
            private long maddtime;
            private String m_token;
            private String mtruename;
            private int mInitInviterShopId;
            private int mInitInviter;
            private double mprice;
            private String mVipExpiry;
            private double mLon;
            private int readBonusFlag;
            private double mbean;
            private int mInviterShopId;
            private long movertime;
            private String mPartnerFlag;
            private double mLat;
            private String shop;
            private String mheadurl;
            private int mid;
            private String mfkmState;
            private String mVipFlag;
            private int groupOrderFlag;
            private int minviter;
            private int mrecommend;
            private String mPayPwd;
            private long mvalidtime;
            private String mInviterType;
            private int mPartnerInviterShopId;
            private int groupPhoneFlag;
            private int shopOrderFlag;
            private String mAddrDetail;
            private int mgrade;
            private int msex;
            private String token;
            private long mbindphonetime;
            private String mcity;
            private double mPriceWithdraw;
            private String mInitInviterType;
            private String mphone;

            @Override
            public String toString() {
                return "ResultUserEntity{" +
                        "mPriceConsume=" + mPriceConsume +
                        ", mnickname='" + mnickname + '\'' +
                        ", mallOrderFlag=" + mallOrderFlag +
                        ", mpwd='" + mpwd + '\'' +
                        ", mPartnerShopId=" + mPartnerShopId +
                        ", mfkm='" + mfkm + '\'' +
                        ", mPartnerInviterType='" + mPartnerInviterType + '\'' +
                        ", mcommission=" + mcommission +
                        ", mbirthday=" + mbirthday +
                        ", mPartnerExpiry='" + mPartnerExpiry + '\'' +
                        ", uuid='" + uuid + '\'' +
                        ", mPartnerInviter=" + mPartnerInviter +
                        ", mtype=" + mtype +
                        ", mclientSource='" + mclientSource + '\'' +
                        ", mlevel='" + mlevel + '\'' +
                        ", maddtime=" + maddtime +
                        ", m_token='" + m_token + '\'' +
                        ", mtruename='" + mtruename + '\'' +
                        ", mInitInviterShopId=" + mInitInviterShopId +
                        ", mInitInviter=" + mInitInviter +
                        ", mprice=" + mprice +
                        ", mVipExpiry='" + mVipExpiry + '\'' +
                        ", mLon=" + mLon +
                        ", readBonusFlag=" + readBonusFlag +
                        ", mbean=" + mbean +
                        ", mInviterShopId=" + mInviterShopId +
                        ", movertime=" + movertime +
                        ", mPartnerFlag='" + mPartnerFlag + '\'' +
                        ", mLat=" + mLat +
                        ", shop='" + shop + '\'' +
                        ", mheadurl='" + mheadurl + '\'' +
                        ", mid=" + mid +
                        ", mfkmState='" + mfkmState + '\'' +
                        ", mVipFlag='" + mVipFlag + '\'' +
                        ", groupOrderFlag=" + groupOrderFlag +
                        ", minviter=" + minviter +
                        ", mrecommend=" + mrecommend +
                        ", mPayPwd='" + mPayPwd + '\'' +
                        ", mvalidtime=" + mvalidtime +
                        ", mInviterType='" + mInviterType + '\'' +
                        ", mPartnerInviterShopId=" + mPartnerInviterShopId +
                        ", groupPhoneFlag=" + groupPhoneFlag +
                        ", shopOrderFlag=" + shopOrderFlag +
                        ", mAddrDetail='" + mAddrDetail + '\'' +
                        ", mgrade=" + mgrade +
                        ", msex=" + msex +
                        ", token='" + token + '\'' +
                        ", mbindphonetime=" + mbindphonetime +
                        ", mcity='" + mcity + '\'' +
                        ", mPriceWithdraw=" + mPriceWithdraw +
                        ", mInitInviterType='" + mInitInviterType + '\'' +
                        ", mphone='" + mphone + '\'' +
                        '}';
            }

            public void setMPriceConsume(double mPriceConsume) {
                this.mPriceConsume = mPriceConsume;
            }

            public void setMnickname(String mnickname) {
                this.mnickname = mnickname;
            }

            public void setMallOrderFlag(int mallOrderFlag) {
                this.mallOrderFlag = mallOrderFlag;
            }

            public void setMpwd(String mpwd) {
                this.mpwd = mpwd;
            }

            public void setMPartnerShopId(int mPartnerShopId) {
                this.mPartnerShopId = mPartnerShopId;
            }

            public void setMfkm(String mfkm) {
                this.mfkm = mfkm;
            }

            public void setMPartnerInviterType(String mPartnerInviterType) {
                this.mPartnerInviterType = mPartnerInviterType;
            }

            public void setMcommission(int mcommission) {
                this.mcommission = mcommission;
            }

            public void setMbirthday(long mbirthday) {
                this.mbirthday = mbirthday;
            }

            public void setMPartnerExpiry(String mPartnerExpiry) {
                this.mPartnerExpiry = mPartnerExpiry;
            }

            public void setUuid(String uuid) {
                this.uuid = uuid;
            }

            public void setMPartnerInviter(int mPartnerInviter) {
                this.mPartnerInviter = mPartnerInviter;
            }

            public void setMtype(int mtype) {
                this.mtype = mtype;
            }

            public void setMclientSource(String mclientSource) {
                this.mclientSource = mclientSource;
            }

            public void setMlevel(String mlevel) {
                this.mlevel = mlevel;
            }

            public void setMaddtime(long maddtime) {
                this.maddtime = maddtime;
            }

            public void setM_token(String m_token) {
                this.m_token = m_token;
            }

            public void setMtruename(String mtruename) {
                this.mtruename = mtruename;
            }

            public void setMInitInviterShopId(int mInitInviterShopId) {
                this.mInitInviterShopId = mInitInviterShopId;
            }

            public void setMInitInviter(int mInitInviter) {
                this.mInitInviter = mInitInviter;
            }

            public void setMprice(double mprice) {
                this.mprice = mprice;
            }

            public void setMVipExpiry(String mVipExpiry) {
                this.mVipExpiry = mVipExpiry;
            }

            public void setMLon(double mLon) {
                this.mLon = mLon;
            }

            public void setReadBonusFlag(int readBonusFlag) {
                this.readBonusFlag = readBonusFlag;
            }

            public void setMbean(double mbean) {
                this.mbean = mbean;
            }

            public void setMInviterShopId(int mInviterShopId) {
                this.mInviterShopId = mInviterShopId;
            }

            public void setMovertime(long movertime) {
                this.movertime = movertime;
            }

            public void setMPartnerFlag(String mPartnerFlag) {
                this.mPartnerFlag = mPartnerFlag;
            }

            public void setMLat(double mLat) {
                this.mLat = mLat;
            }

            public void setShop(String shop) {
                this.shop = shop;
            }

            public void setMheadurl(String mheadurl) {
                this.mheadurl = mheadurl;
            }

            public void setMid(int mid) {
                this.mid = mid;
            }

            public void setMfkmState(String mfkmState) {
                this.mfkmState = mfkmState;
            }

            public void setMVipFlag(String mVipFlag) {
                this.mVipFlag = mVipFlag;
            }

            public void setGroupOrderFlag(int groupOrderFlag) {
                this.groupOrderFlag = groupOrderFlag;
            }

            public void setMinviter(int minviter) {
                this.minviter = minviter;
            }

            public void setMrecommend(int mrecommend) {
                this.mrecommend = mrecommend;
            }

            public void setMPayPwd(String mPayPwd) {
                this.mPayPwd = mPayPwd;
            }

            public void setMvalidtime(long mvalidtime) {
                this.mvalidtime = mvalidtime;
            }

            public void setMInviterType(String mInviterType) {
                this.mInviterType = mInviterType;
            }

            public void setMPartnerInviterShopId(int mPartnerInviterShopId) {
                this.mPartnerInviterShopId = mPartnerInviterShopId;
            }

            public void setGroupPhoneFlag(int groupPhoneFlag) {
                this.groupPhoneFlag = groupPhoneFlag;
            }

            public void setShopOrderFlag(int shopOrderFlag) {
                this.shopOrderFlag = shopOrderFlag;
            }

            public void setMAddrDetail(String mAddrDetail) {
                this.mAddrDetail = mAddrDetail;
            }

            public void setMgrade(int mgrade) {
                this.mgrade = mgrade;
            }

            public void setMsex(int msex) {
                this.msex = msex;
            }

            public void setToken(String token) {
                this.token = token;
            }

            public void setMbindphonetime(long mbindphonetime) {
                this.mbindphonetime = mbindphonetime;
            }

            public void setMcity(String mcity) {
                this.mcity = mcity;
            }

            public void setMPriceWithdraw(double mPriceWithdraw) {
                this.mPriceWithdraw = mPriceWithdraw;
            }

            public void setMInitInviterType(String mInitInviterType) {
                this.mInitInviterType = mInitInviterType;
            }

            public void setMphone(String mphone) {
                this.mphone = mphone;
            }

            public double getMPriceConsume() {
                return mPriceConsume;
            }

            public String getMnickname() {
                return mnickname;
            }

            public int getMallOrderFlag() {
                return mallOrderFlag;
            }

            public String getMpwd() {
                return mpwd;
            }

            public int getMPartnerShopId() {
                return mPartnerShopId;
            }

            public String getMfkm() {
                return mfkm;
            }

            public String getMPartnerInviterType() {
                return mPartnerInviterType;
            }

            public int getMcommission() {
                return mcommission;
            }

            public long getMbirthday() {
                return mbirthday;
            }

            public String getMPartnerExpiry() {
                return mPartnerExpiry;
            }

            public String getUuid() {
                return uuid;
            }

            public int getMPartnerInviter() {
                return mPartnerInviter;
            }

            public int getMtype() {
                return mtype;
            }

            public String getMclientSource() {
                return mclientSource;
            }

            public String getMlevel() {
                return mlevel;
            }

            public long getMaddtime() {
                return maddtime;
            }

            public String getM_token() {
                return m_token;
            }

            public String getMtruename() {
                return mtruename;
            }

            public int getMInitInviterShopId() {
                return mInitInviterShopId;
            }

            public int getMInitInviter() {
                return mInitInviter;
            }

            public double getMprice() {
                return mprice;
            }

            public String getMVipExpiry() {
                return mVipExpiry;
            }

            public double getMLon() {
                return mLon;
            }

            public int getReadBonusFlag() {
                return readBonusFlag;
            }

            public double getMbean() {
                return mbean;
            }

            public int getMInviterShopId() {
                return mInviterShopId;
            }

            public long getMovertime() {
                return movertime;
            }

            public String getMPartnerFlag() {
                return mPartnerFlag;
            }

            public double getMLat() {
                return mLat;
            }

            public String getShop() {
                return shop;
            }

            public String getMheadurl() {
                return mheadurl;
            }

            public int getMid() {
                return mid;
            }

            public String getMfkmState() {
                return mfkmState;
            }

            public String getMVipFlag() {
                return mVipFlag;
            }

            public int getGroupOrderFlag() {
                return groupOrderFlag;
            }

            public int getMinviter() {
                return minviter;
            }

            public int getMrecommend() {
                return mrecommend;
            }

            public String getMPayPwd() {
                return mPayPwd;
            }

            public long getMvalidtime() {
                return mvalidtime;
            }

            public String getMInviterType() {
                return mInviterType;
            }

            public int getMPartnerInviterShopId() {
                return mPartnerInviterShopId;
            }

            public int getGroupPhoneFlag() {
                return groupPhoneFlag;
            }

            public int getShopOrderFlag() {
                return shopOrderFlag;
            }

            public String getMAddrDetail() {
                return mAddrDetail;
            }

            public int getMgrade() {
                return mgrade;
            }

            public int getMsex() {
                return msex;
            }

            public String getToken() {
                return token;
            }

            public long getMbindphonetime() {
                return mbindphonetime;
            }

            public String getMcity() {
                return mcity;
            }

            public double getMPriceWithdraw() {
                return mPriceWithdraw;
            }

            public String getMInitInviterType() {
                return mInitInviterType;
            }

            public String getMphone() {
                return mphone;
            }
        }
    }
}
