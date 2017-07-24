-- ----------------------------
--  Table structure for `gas_trading`
-- ----------------------------
DROP TABLE IF EXISTS `gas_trading`;
CREATE TABLE `gas_trading` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` bigint(20) DEFAULT NULL COMMENT '用户uid',
  `serial` varchar(45) DEFAULT NULL COMMENT '流水号',
  `payment` int(11) DEFAULT NULL COMMENT '支付方式 1:支付宝 2:微信 3:现金 4:银联 5:苹果支付',
  `amount` decimal(8,2) DEFAULT NULL COMMENT '交易金额',
  `payType` int(11) DEFAULT NULL COMMENT '付款类型',
  `state` int(11) DEFAULT NULL COMMENT '交易状态：1：待支付 2：已支付 3….',
  `payTime` datetime DEFAULT NULL COMMENT '付款时间',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='交易流水';

-- ----------------------------
--  Table structure for `gas_account`
-- ----------------------------
DROP TABLE IF EXISTS `gas_account`;
CREATE TABLE `gas_account` (
  `id` bigint(20) NOT NULL,
  `balance` decimal(8,2) DEFAULT NULL COMMENT '余额',
  `credit` decimal(8,2) DEFAULT NULL COMMENT '信用额度',
  `accountType` int(11) DEFAULT NULL COMMENT '0.后付费 1.预付费',
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户账户信息';

-- ----------------------------
--  Table structure for `gas_user`
-- ----------------------------
DROP TABLE IF EXISTS `gas_user`;
CREATE TABLE `gas_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` varchar(45) DEFAULT NULL COMMENT '用户ID',
  `userName` varchar(45) DEFAULT NULL COMMENT '用户名',
  `address` varchar(45) DEFAULT NULL COMMENT '地址',
  `type` int(11) DEFAULT NULL COMMENT '用户类型 1:个人 2:商业',
  `state` varchar(45) DEFAULT NULL COMMENT '用户状态 0.禁用 1.正常',
  `contact` varchar(45) DEFAULT NULL COMMENT '联系人',
  `phone` varchar(45) DEFAULT NULL COMMENT '手机',
  `tel` varchar(45) DEFAULT NULL COMMENT '固定电话',
  `location` varchar(45) DEFAULT NULL COMMENT '经纬度',
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户基本信息表';

SET FOREIGN_KEY_CHECKS = 1;
