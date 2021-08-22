CREATE TABLE `hg_customer` (
                               `id` bigint(20) NOT NULL,
                               `union_id` varchar(64) NOT NULL DEFAULT '' COMMENT '微信unionId',
                               `open_id` varchar(64) NOT NULL DEFAULT '' COMMENT '微信openId',
                               `nick_name` varchar(64) NOT NULL DEFAULT '' COMMENT '昵称',
                               `gender` tinyint(2) NOT NULL DEFAULT 30 COMMENT '性别',
                               `age` int(3) NOT NULL DEFAULT 999 COMMENT '年龄',
                               `phone` varchar(11) NOT NULL DEFAULT '' COMMENT '手机号',
                               `pull_time` datetime DEFAULT NULL COMMENT '拉新时间',
                               `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                               `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='客户表';

CREATE TABLE hg_customer_invitation(
                                       id bigint(20) NOT NULL,
                                       invite_id bigint(20) NOT NULL COMMENT '邀请人ID' ,
                                       be_invited_id bigint(20) NOT NULL COMMENT '被邀请人ID' ,
                                       entered TINYINT(1) NOT NULL DEFAULT 0 COMMENT '是否报名' ,
                                       activity_id bigint(20) NULL COMMENT '活动ID' ,
                                       phone VARCHAR(11) NOT NULL DEFAULT '' COMMENT '手机号' ,
                                       pull_time DATETIME NULL COMMENT '拉新时间' ,
                                       create_time DATETIME NULL COMMENT '创建时间' ,
                                       update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP NULL COMMENT '更新时间',
                                       PRIMARY KEY (`id`)
) COMMENT '客户邀请关系表' charset = utf8mb4;

CREATE TABLE hg_group(
                         id bigint(20) NOT NULL,
                         salesmen_id bigint(20) NOT NULL COMMENT '销售人员ID' ,
                         customer_count INT NOT NULL DEFAULT 0 COMMENT '客户数量' ,
                         group_limit INT(3) NOT NULL DEFAULT 200 COMMENT '分组上限' ,
                         version INT NOT NULL DEFAULT 0 COMMENT '更新版本' ,
                         create_time DATETIME NULL COMMENT '创建时间' ,
                         update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP NULL COMMENT '更新时间',
                         PRIMARY KEY (`id`)
) COMMENT '班级表' charset = utf8mb4;

CREATE TABLE `hg_promotion` (
                                `id` bigint(20) NOT NULL,
                                `service_type` TINYINT(3) NOT NULL DEFAULT 100 COMMENT '服务类型',
                                `pic_url` varchar(128) NOT NULL DEFAULT '' COMMENT '图片地址',
                                `web_pic_url` varchar(128) NOT NULL DEFAULT '' COMMENT '页面内图片地址',
                                `amount` DECIMAL(14,2) NOT NULL DEFAULT 0 COMMENT '金额',
                                `web_page_type` TINYINT(10) NOT NULL DEFAULT 10 COMMENT '页面类型',
                                `web_age_position` TINYINT(10) NOT NULL DEFAULT 10 COMMENT '页面位置',
                                `start_time` datetime DEFAULT NULL COMMENT '活动开始时间',
                                `end_time` datetime DEFAULT NULL COMMENT '活动结束时间',
                                `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP NULL COMMENT '更新时间',
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='活动表';

CREATE TABLE `hg_salesmen` (
                               `id` bigint(20) NOT NULL,
                               `nick_name` varchar(64) NOT NULL DEFAULT '' COMMENT '昵称',
                               `phone` varchar(11) NOT NULL DEFAULT '' COMMENT '手机号',
                               `RQ_code1` varchar(128) NOT NULL DEFAULT '' COMMENT '二维码1',
                               `RQ_code2` varchar(128) NOT NULL DEFAULT '' COMMENT '二维码2',
                               `RQ_code3` varchar(128) NOT NULL DEFAULT '' COMMENT '二维码3',
                               `service_type` TINYINT(3) NOT NULL DEFAULT 100 COMMENT '服务类型',
                               `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                               `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP NULL COMMENT '更新时间',
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='销售人员表';

CREATE TABLE `hg_rf_salesmen_customer_group` (
                                              `salesmen_id` bigint(20) DEFAULT NULL,
                                              `customer_id` bigint(20) DEFAULT NULL,
                                              `group_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='销售客户班级表';

ALTER TABLE `hg_customer` ADD `head_img` varchar(200) NOT NULL DEFAULT '' COMMENT '头像url';

ALTER TABLE `hg_group` ADD COLUMN `RQ_code` varchar(128) NOT NULL DEFAULT '' COMMENT '销售人员二维码' AFTER `salesmen_id`;

ALTER TABLE  `hg_customer` ADD `province` varchar(64) NOT NULL DEFAULT '' COMMENT '省' AFTER `head_img`;

ALTER TABLE  `hg_customer` ADD `city` varchar(64) NOT NULL DEFAULT '' COMMENT '市' AFTER `head_img`;

ALTER TABLE `hg_promotion` ADD COLUMN `title` varchar(128) NOT NULL DEFAULT '' COMMENT '活动标题' AFTER `name`,
    ADD COLUMN `content` text NOT NULL COMMENT '富文本活动内容' AFTER `title`;