CREATE TABLE `account` (
  `uid` int(11) NOT NULL,
  `balance` decimal(8,2) NOT NULL DEFAULT '0.00',
  `credit` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '信用额度',
  `type` tinyint(4) NOT NULL DEFAULT '2' COMMENT '1.后付费 2.预付费',
  `createTime` datetime NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `region` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '名称',
  `parentId` int(8) NOT NULL DEFAULT '0' COMMENT '父 ID',
  `pinyin` varchar(45) NOT NULL DEFAULT '' COMMENT '拼音',
  `suffix` varchar(15) NOT NULL DEFAULT '' COMMENT '行政级别',
  `zipCode` char(7) NOT NULL DEFAULT '' COMMENT '邮政编码',
  `code` char(4) NOT NULL DEFAULT '' COMMENT '区号',
  `sort` tinyint(2) NOT NULL COMMENT '排序',
  `level` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='行政区域';

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL DEFAULT '',
  `contact` varchar(20) NOT NULL DEFAULT '' COMMENT '联系人',
  `type` tinyint(1) NOT NULL DEFAULT '1' COMMENT '用户类型 1.个人用户 2.商业用户',
  `phone` varchar(20) NOT NULL DEFAULT '' COMMENT '手机号',
  `state` tinyint(1) NOT NULL DEFAULT '1' COMMENT '用户状态 0.禁用 1.正常',
  `location` int(11) NOT NULL DEFAULT '0',
  `address` varchar(500) NOT NULL DEFAULT '',
  `createTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

## 存储过程
CREATE DEFINER=`root`@`localhost` PROCEDURE `createTables`()
  BEGIN

    DECLARE i INT;
    DECLARE table_name VARCHAR(20);
    DECLARE table_pre VARCHAR(20);
    DECLARE sql_text VARCHAR(2000);
    SET i=0;
    SET table_name='';
    SET table_pre='recharge';
    SET sql_text='';
    WHILE i<100 DO
      SET table_name=CONCAT(table_pre,i);

      SET sql_text=CONCAT('CREATE TABLE ', table_name, ' (`id` bigint(20) NOT NULL COMMENT \'分片主键\',
  `tradeNo` varchar(50) NOT NULL,
  `uid` int(11) NOT NULL DEFAULT \'0\' COMMENT \'分库键\',
  `source` tinyint(1) NOT NULL DEFAULT \'1\' COMMENT \'支付方式：1.支付宝 2.微信 3.现金 4.银联 5.苹果支付\',
  `type` tinyint(1) NOT NULL DEFAULT \'0\' COMMENT \'付款类型 1.缴费 2.充值\',
  `payAccount` varchar(45) NOT NULL DEFAULT \'\' COMMENT \'付款账号\',
  `state` tinyint(1) NOT NULL DEFAULT \'1\' COMMENT \'交易状态 0.失败 1.成功\',
  `amount` decimal(8,2) NOT NULL DEFAULT \'0.00\' COMMENT \'交易金额\',
  `payTime` datetime NOT NULL COMMENT \'付款时间\',
  PRIMARY KEY (`id`),
  UNIQUE KEY `tradeNo_UNIQUE` (`tradeNo`),
  KEY `uid_index` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT=\'充值记录\'');

      SELECT sql_text;
      SET @sql_text=sql_text;
      PREPARE stmt FROM @sql_text;
      EXECUTE stmt;
      DEALLOCATE PREPARE stmt;
      SET i=i+1;
    END WHILE;

  END