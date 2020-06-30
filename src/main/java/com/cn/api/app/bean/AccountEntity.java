package com.cn.api.app.bean;


public class AccountEntity extends BaseEntity<AccountEntity.ResultEntity> {

    /**
     * result : {"result":{"unreadMsgCount":0,"shop":{},"memberPattner":[],"coupon_count":0,"member":{}},"errCode":"USER_200","errMsg":"执行成功"}
     * errCode : USER_200
     * errMsg : 接口调用成功
     */

    public static class ResultEntity {
        /**
         * result : {"unreadMsgCount":0,"shop":{},"memberPattner":[],"coupon_count":0,"member":{}}
         * errCode : USER_200
         * errMsg : 执行成功
         */
//        private UserEntity result;
        private String errCode;
        private String errMsg;

//        public void setResult(UserEntity result) {
//            this.result = result;
//        }

        public void setErrCode(String errCode) {
            this.errCode = errCode;
        }

        public void setErrMsg(String errMsg) {
            this.errMsg = errMsg;
        }

//        public UserEntity getResult() {
//            return result;
//        }

        public String getErrCode() {
            return errCode;
        }

        public String getErrMsg() {
            return errMsg;
        }

//        public static class UserEntity {
//            /**
//             * unreadMsgCount : 0
//             * shop : {}
//             * memberPattner : []
//             * coupon_count : 0
//             * member : {}
//             */
//            private int unreadMsgCount;
//            private ShopEntity shop;
//            private List<?> memberPattner;
//            private int coupon_count;
//            private MemberEntity member;
//
//            public void setUnreadMsgCount(int unreadMsgCount) {
//                this.unreadMsgCount = unreadMsgCount;
//            }
//
//            public void setShop(ShopEntity shop) {
//                this.shop = shop;
//            }
//
//            public void setMemberPattner(List<?> memberPattner) {
//                this.memberPattner = memberPattner;
//            }
//
//            public void setCoupon_count(int coupon_count) {
//                this.coupon_count = coupon_count;
//            }
//
//            public void setMember(MemberEntity member) {
//                this.member = member;
//            }
//
//            public int getUnreadMsgCount() {
//                return unreadMsgCount;
//            }
//
//            public ShopEntity getShop() {
//                return shop;
//            }
//
//            public List<?> getMemberPattner() {
//                return memberPattner;
//            }
//
//            public int getCoupon_count() {
//                return coupon_count;
//            }
//
//            public MemberEntity getMember() {
//                return member;
//            }
//
//            public class ShopEntity {
//            }
//
//            public class MemberEntity {
//            }
//        }
    }
}
