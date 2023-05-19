DROP TABLE IF EXISTS BUYR_ORDER;
CREATE TABLE BUYR_ORDER(
                           ORDER_ID VARCHAR(32) NOT NULL   COMMENT '订单ID' ,
                           USER_ID VARCHAR(32) NOT NULL   COMMENT '用户ID' ,
                           CART_ID VARCHAR(32) NOT NULL   COMMENT '购物车ID' ,
                           ADDRESS_ID VARCHAR(32)    COMMENT '地址ID' ,
                           COUPON_ID VARCHAR(32)    COMMENT '优惠券ID' ,
                           TOTAL_PRICE DECIMAL(24,6)    COMMENT '总金额' ,
                           COUPON_PRICE DECIMAL(24,6)    COMMENT '优惠金额' ,
                           PAYABLE_PRICE DECIMAL(24,6)    COMMENT '应付金额' ,
                           PAY_METHOD VARCHAR(32)    COMMENT '支付方式' ,
                           INVOICE_TPL_ID VARCHAR(32)    COMMENT '开票设置ID' ,
                           LEAVE_COMMENT VARCHAR(1000)    COMMENT '订单留言备注' ,
                           ORDER_STATUS VARCHAR(32)    COMMENT '订单状态' ,
                           REVISION INT    COMMENT '乐观锁' ,
                           CREATED_BY VARCHAR(32)    COMMENT '创建人' ,
                           CREATED_TIME DATETIME    COMMENT '创建时间' ,
                           UPDATED_BY VARCHAR(32)    COMMENT '更新人' ,
                           UPDATED_TIME DATETIME    COMMENT '更新时间' ,
                           PRIMARY KEY (ORDER_ID)
)  COMMENT = '订单';

DROP TABLE IF EXISTS BUYR_USER;
CREATE TABLE BUYR_USER(
                          USER_ID VARCHAR(32) NOT NULL   COMMENT '用户ID' ,
                          USER_NAME VARCHAR(90) NOT NULL   COMMENT '用户名称' ,
                          NICK_NAME VARCHAR(90)    COMMENT '用户昵称' ,
                          USER_INTRO VARCHAR(300)    COMMENT '个性签名' ,
                          AVATAR VARCHAR(1000)    COMMENT '头像图片' ,
                          EMAIL VARCHAR(255)    COMMENT '邮件地址' ,
                          PHONE VARCHAR(255)    COMMENT '手机号' ,
                          USER_PASS VARCHAR(255)    COMMENT '密码' ,
                          PASS_SALT VARCHAR(255)    COMMENT '密码盐' ,
                          USER_STATUS VARCHAR(32)   DEFAULT '1' COMMENT '用户状态' ,
                          USER_SCORE INT    COMMENT '用户打分' ,
                          TOTAL_COST_AMT DECIMAL(24,6)    COMMENT '累计消费金额' ,
                          LAST_LOGIN_TIME DATETIME    COMMENT '最后登录时间' ,
                          REVISION INT    COMMENT '乐观锁' ,
                          CREATED_BY VARCHAR(32)    COMMENT '创建人' ,
                          CREATED_TIME DATETIME    COMMENT '创建时间' ,
                          UPDATED_BY VARCHAR(32)    COMMENT '更新人' ,
                          UPDATED_TIME DATETIME    COMMENT '更新时间' ,
                          PRIMARY KEY (USER_ID)
)  COMMENT = '买家';


