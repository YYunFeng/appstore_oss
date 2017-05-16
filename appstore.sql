/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.119
Source Server Version : 50529
Source Host           : 192.168.1.119:3306
Source Database       : appstore

Target Server Type    : MYSQL
Target Server Version : 50529
File Encoding         : 65001

Date: 2013-03-12 12:15:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sequence_value`
-- ----------------------------
DROP TABLE IF EXISTS `sequence_value`;
CREATE TABLE `sequence_value` (
  `name` varchar(50) NOT NULL,
  `id` int(11) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sequence_value
-- ----------------------------
INSERT INTO `sequence_value` VALUES ('ANDROID_OS_SEQUENCE', '20');
INSERT INTO `sequence_value` VALUES ('ANDROID_SCREEN_SEQUENCE', '0');
INSERT INTO `sequence_value` VALUES ('APPS', '0');
INSERT INTO `sequence_value` VALUES ('APP_DETAILS', '0');
INSERT INTO `sequence_value` VALUES ('APP_DETAILS_LOG', '0');
INSERT INTO `sequence_value` VALUES ('APP_DETAIL_LOG', '0');
INSERT INTO `sequence_value` VALUES ('APP_DOWNLOAD_STAT', '0');
INSERT INTO `sequence_value` VALUES ('APP_LOG', '0');
INSERT INTO `sequence_value` VALUES ('APP_RESOURCE', '0');
INSERT INTO `sequence_value` VALUES ('APP_SKU', '0');
INSERT INTO `sequence_value` VALUES ('CATEGORY_SEQUENCE', '40');
INSERT INTO `sequence_value` VALUES ('CHANNELTOPIC_SEQUENCE', '0');
INSERT INTO `sequence_value` VALUES ('CMS_ADMINLOG_SEQUENCE', '0');
INSERT INTO `sequence_value` VALUES ('CMS_ANDROID_DRIVER_SEQUENCE', '0');
INSERT INTO `sequence_value` VALUES ('CMS_BACKEND_TASK_SEQUENCE', '10');
INSERT INTO `sequence_value` VALUES ('CMS_CLIENTMANAGER_VERSION_SEQUENCE', '0');
INSERT INTO `sequence_value` VALUES ('CMS_HOTWORD_SEQUENCE', '0');
INSERT INTO `sequence_value` VALUES ('CMS_IMPORTAPPLOG_SEQUENCE', '0');
INSERT INTO `sequence_value` VALUES ('CMS_NOTICE_SEQUENCE', '0');
INSERT INTO `sequence_value` VALUES ('CMS_OFFLINEINSTALLSTAT_SEQUENCE', '0');
INSERT INTO `sequence_value` VALUES ('CMS_ONLINEINSTALLSTAT_SEQUENCE', '0');
INSERT INTO `sequence_value` VALUES ('CMS_RANKING_APP', '0');
INSERT INTO `sequence_value` VALUES ('CMS_RECOMMEND_PAD_SEQ_SEQUENCE', '0');
INSERT INTO `sequence_value` VALUES ('CMS_RECOMMEND_PHONE_SEQ_SEQUENCE', '0');
INSERT INTO `sequence_value` VALUES ('CMS_RECOMMEND_SEQUENCE', '0');
INSERT INTO `sequence_value` VALUES ('CMS_RECOMMEND_SEQ_SEQUENCE', '0');
INSERT INTO `sequence_value` VALUES ('CMS_SUPPERROLEMODULE_SEQUENCE', '300');
INSERT INTO `sequence_value` VALUES ('CMS_SUPPERROLE_SEQUENCE', '1');
INSERT INTO `sequence_value` VALUES ('CMS_SUPPERUSERS_SEQUENCE', '1');
INSERT INTO `sequence_value` VALUES ('CMS_TOPIC_APP_SEQUENCE', '0');
INSERT INTO `sequence_value` VALUES ('CMS_TOPIC_SEQUENCE', '0');
INSERT INTO `sequence_value` VALUES ('CP_APP_LOG', '0');
INSERT INTO `sequence_value` VALUES ('CP_BASEINFO_SEQUENCE', '0');
INSERT INTO `sequence_value` VALUES ('CP_REGINFO_SEQUENCE', '0');
INSERT INTO `sequence_value` VALUES ('FEEDBACK_SEQUENCE', '0');
INSERT INTO `sequence_value` VALUES ('OFFLINEAPP_SALE_LOG', '0');
INSERT INTO `sequence_value` VALUES ('ONLINEAPP_SALE_LOG', '0');
INSERT INTO `sequence_value` VALUES ('PADCHANNEL_SEQUENCE', '0');
INSERT INTO `sequence_value` VALUES ('ACTIVITY', '0');
INSERT INTO `sequence_value` VALUES ('ACTIVITYCHANNEL', '0');



-- ----------------------------
-- Table structure for `tb_admin_log`
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin_log`;
CREATE TABLE `tb_admin_log` (
  `id` int(11) NOT NULL,
  `adminid` int(11) DEFAULT NULL,
  `operation_type` tinyint(4) DEFAULT NULL COMMENT '0：登录；1：登出；......',
  `operation_time` datetime DEFAULT NULL,
  `ip` varchar(32) DEFAULT NULL,
  `ua` varchar(256) DEFAULT NULL,
  `memo` varchar(256) DEFAULT NULL,
  `created` datetime DEFAULT '1970-01-01 00:00:00',
  `modified` datetime DEFAULT '1970-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_admin_log
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_android_app_osversion`
-- ----------------------------
DROP TABLE IF EXISTS `tb_android_app_osversion`;
CREATE TABLE `tb_android_app_osversion` (
  `os_version_id` int(11) NOT NULL,
  `os_version_name` varchar(30) DEFAULT NULL,
  `os_version_code` smallint(6) DEFAULT NULL,
  `intro` varchar(100) DEFAULT NULL,
  `online` tinyint(4) DEFAULT NULL COMMENT '1：上线；2：下线',
  `created` datetime DEFAULT '1970-01-01 00:00:00',
  `modified` datetime DEFAULT '1970-01-01 00:00:00',
  PRIMARY KEY (`os_version_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_android_app_osversion
-- ----------------------------
INSERT INTO `tb_android_app_osversion` VALUES ('1', 'Android 1.0', '1', 'Base', '1', '2013-01-10 14:38:53', '2013-01-10 14:38:53');
INSERT INTO `tb_android_app_osversion` VALUES ('2', 'Android 1.1', '2', 'BASE_1_1', '1', '2013-01-10 14:38:53', '2013-01-10 14:38:53');
INSERT INTO `tb_android_app_osversion` VALUES ('3', 'Android 1.5', '3', 'CUPCAKE', '1', '2013-01-10 14:38:53', '2013-01-10 14:38:53');
INSERT INTO `tb_android_app_osversion` VALUES ('4', 'Android 1.6', '4', 'DONUT', '1', '2013-01-10 14:38:53', '2013-01-10 14:38:53');
INSERT INTO `tb_android_app_osversion` VALUES ('5', 'Android 2.0', '5', 'ECLAIR', '1', '2013-01-10 14:38:53', '2013-01-10 14:38:53');
INSERT INTO `tb_android_app_osversion` VALUES ('6', 'Android 2.0.1', '6', 'ECLAIR_0_1', '1', '2013-01-10 14:38:53', '2013-01-10 14:38:53');
INSERT INTO `tb_android_app_osversion` VALUES ('7', 'Android 2.1', '7', 'Eclair (法式奶油夹心甜点) / Flan (水果馅饼)', '1', '2013-01-10 14:38:53', '2013-01-10 14:38:53');
INSERT INTO `tb_android_app_osversion` VALUES ('8', 'Android 2.2', '8', 'Froyo ( 冻酸奶)', '1', '2013-01-10 14:38:53', '2013-01-10 14:38:53');
INSERT INTO `tb_android_app_osversion` VALUES ('9', 'Android 2.3', '9', 'Gingerbread (姜饼)', '1', '2013-01-10 14:38:53', '2013-01-10 14:38:53');
INSERT INTO `tb_android_app_osversion` VALUES ('10', 'Android 2.3.3', '10', 'Gingerbread (姜饼)', '1', '2013-01-10 14:38:54', '2013-01-10 14:38:54');
INSERT INTO `tb_android_app_osversion` VALUES ('11', 'Android 3.0', '11', 'Honeycomb (蜂巢)', '1', '2013-01-10 14:38:54', '2013-01-10 14:38:54');
INSERT INTO `tb_android_app_osversion` VALUES ('12', 'Android 3.1', '12', 'Honeycomb', '1', '2013-01-10 14:38:54', '2013-01-10 14:38:54');
INSERT INTO `tb_android_app_osversion` VALUES ('13', 'Android 3.2', '13', 'Honeycomb', '1', '2013-01-10 14:38:54', '2013-01-10 14:38:54');
INSERT INTO `tb_android_app_osversion` VALUES ('14', 'Android 4.0', '14', 'Ice Cream Sandwich（简称ICS，冰淇淋三明治）', '1', '2013-01-10 14:38:54', '2013-01-10 14:38:54');
INSERT INTO `tb_android_app_osversion` VALUES ('15', 'Android 4.0.3', '15', 'Ice Cream Sandwich', '1', '2013-01-10 14:38:54', '2013-01-10 14:38:54');
INSERT INTO `tb_android_app_osversion` VALUES ('16', 'Android 4.1', '16', 'Jelly Bean/果冻豆', '1', '2013-01-10 14:38:54', '2013-01-10 14:38:54');

-- ----------------------------
-- Table structure for `tb_android_app_screentype`
-- ----------------------------
DROP TABLE IF EXISTS `tb_android_app_screentype`;
CREATE TABLE `tb_android_app_screentype` (
  `screen_size_id` int(11) NOT NULL,
  `screen_size_name` varchar(30) DEFAULT NULL,
  `intro` varchar(100) DEFAULT NULL,
  `online` tinyint(4) DEFAULT NULL COMMENT '1：上线；2：下线',
  `created` datetime DEFAULT '1970-01-01 00:00:00',
  `modified` datetime DEFAULT '1970-01-01 00:00:00',
  PRIMARY KEY (`screen_size_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_android_app_screentype
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_android_driver`
-- ----------------------------
DROP TABLE IF EXISTS `tb_android_driver`;
CREATE TABLE `tb_android_driver` (
  `id` int(11) NOT NULL COMMENT '0：同步商品基本信息；1：同步价格；2：同步上下架状态；3：同步商品类目；4：同步供应商信息；5：生成下载统计日报；',
  `vid` varchar(10) NOT NULL,
  `vname` varchar(50) DEFAULT NULL,
  `pid` varchar(10) DEFAULT NULL COMMENT '0：一次性任务；1：周期性循环重复任务；',
  `pname` varchar(50) DEFAULT NULL,
  `driver_url` varchar(256) NOT NULL COMMENT '0：不需要；1：需要；',
  `mainfile` varchar(100) NOT NULL,
  `created` datetime NOT NULL COMMENT '创建时间',
  `modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_android_driver
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_app_detail_log`
-- ----------------------------
DROP TABLE IF EXISTS `tb_app_detail_log`;
CREATE TABLE `tb_app_detail_log` (
  `id` int(11) NOT NULL,
  `appid` int(11) DEFAULT NULL COMMENT '即SKU，按照规则自增',
  `accountid` int(11) DEFAULT NULL,
  `fee_mode` tinyint(4) DEFAULT NULL COMMENT '0：免费；1：分成，无预付模式；2：分成，有预付款模式；3：买断模式；',
  `price` int(11) DEFAULT NULL,
  `percent` tinyint(4) DEFAULT NULL,
  `period1_begin` datetime DEFAULT '1970-01-01 00:00:00',
  `period1_end` datetime DEFAULT '1970-01-01 00:00:00',
  `percent2` tinyint(4) DEFAULT NULL,
  `period2_begin` datetime DEFAULT '1970-01-01 00:00:00',
  `period2_end` datetime DEFAULT '1970-01-01 00:00:00',
  `percent3` tinyint(4) DEFAULT NULL,
  `period3_begin` datetime DEFAULT '1970-01-01 00:00:00',
  `period3_end` datetime DEFAULT '1970-01-01 00:00:00',
  `prepay` int(11) DEFAULT NULL,
  `buyout` int(11) DEFAULT NULL,
  `buyout_begin` datetime DEFAULT '1970-01-01 00:00:00',
  `buyout_end` datetime DEFAULT '1970-01-01 00:00:00',
  `price_sync_flag` tinyint(4) DEFAULT '0' COMMENT '0：不需要同步；1：需要同步；',
  `logo_url` varchar(200) DEFAULT NULL,
  `is_app_logo` tinyint(1) DEFAULT '0' COMMENT '1：是，主图；0：否。',
  `app_version` varchar(10) DEFAULT NULL,
  `app_version_code` int(11) DEFAULT NULL,
  `os_version_id` int(11) DEFAULT NULL,
  `pkg_size` int(11) DEFAULT NULL,
  `pub_time` datetime DEFAULT NULL,
  `ad_text` varchar(100) DEFAULT NULL,
  `app_tag` varchar(200) DEFAULT NULL,
  `new_features` varchar(1000) DEFAULT NULL,
  `app_introduce` varchar(2000) DEFAULT NULL,
  `online` tinyint(4) DEFAULT NULL COMMENT '0：未上架；1：已上架；2：已下架',
  `update_status` tinyint(4) DEFAULT '0' COMMENT '0：无更新；1：提交待审核；2：审核不通过；\n            注：审核通过后，将应用更新状态归0',
  `comment` varchar(200) DEFAULT NULL,
  `valid` tinyint(1) DEFAULT NULL COMMENT '审核通过，且需要同步的步骤全部同步成功，则复制应用详情，复制完毕后置为已生效；\n            0：未生效；1：已生效；',
  `created` datetime DEFAULT '1970-01-01 00:00:00',
  `modified` datetime DEFAULT '1970-01-01 00:00:00',
  `zhuowangMark` int(11) DEFAULT NULL,
  `apkcode` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_app_detail_log
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_app_details`
-- ----------------------------
DROP TABLE IF EXISTS `tb_app_details`;
CREATE TABLE `tb_app_details` (
  `id` int(11) NOT NULL,
  `appid` int(11) DEFAULT NULL COMMENT '即SKU，按照规则自增',
  `accountid` int(11) DEFAULT NULL,
  `fee_mode` tinyint(4) DEFAULT NULL COMMENT '0：免费；1：分成，无预付模式；2：分成，有预付款模式；3：买断模式；',
  `price` int(11) DEFAULT NULL,
  `percent` tinyint(4) DEFAULT NULL,
  `period1_begin` datetime DEFAULT '1970-01-01 00:00:00',
  `period1_end` datetime DEFAULT '1970-01-01 00:00:00',
  `percent2` tinyint(4) DEFAULT NULL,
  `period2_begin` datetime DEFAULT '1970-01-01 00:00:00',
  `period2_end` datetime DEFAULT '1970-01-01 00:00:00',
  `percent3` tinyint(4) DEFAULT NULL,
  `period3_begin` datetime DEFAULT '1970-01-01 00:00:00',
  `period3_end` datetime DEFAULT '1970-01-01 00:00:00',
  `prepay` int(11) DEFAULT NULL,
  `buyout` int(11) DEFAULT NULL,
  `buyout_begin` datetime DEFAULT '1970-01-01 00:00:00',
  `buyout_end` datetime DEFAULT '1970-01-01 00:00:00',
  `app_version` varchar(10) DEFAULT NULL,
  `app_version_code` int(11) DEFAULT NULL,
  `logo_url` varchar(200) DEFAULT NULL,
  `is_app_logo` tinyint(1) DEFAULT '0' COMMENT '1：是，主图；0：否。',
  `os_version_id` int(11) DEFAULT NULL,
  `pkg_size` int(11) DEFAULT NULL,
  `online` tinyint(4) DEFAULT NULL COMMENT '0：未上架；1：已上架；2：已下架',
  `update_status` tinyint(4) DEFAULT '0' COMMENT '0：无更新；1：提交待审核；2：审核不通过；3：审核通过同步中；4：同步失败\r\n            注：同步成功后，将应用更新状态归0',
  `pub_time` datetime DEFAULT NULL,
  `ad_text` varchar(100) DEFAULT NULL,
  `app_tag` varchar(200) DEFAULT NULL,
  `new_features` varchar(1000) DEFAULT NULL,
  `app_introduce` varchar(2000) DEFAULT NULL,
  `created` datetime DEFAULT '1970-01-01 00:00:00',
  `modified` datetime DEFAULT '1970-01-01 00:00:00',
  `zhuowangMark` int(11) DEFAULT NULL,
   `apkcode` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_app_details
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_app_download_log`
-- ----------------------------
DROP TABLE IF EXISTS `tb_app_download_log`;
CREATE TABLE `tb_app_download_log` (
  `id` int(11) NOT NULL,
  `pin` varchar(30) DEFAULT NULL,
  `appid` int(11) DEFAULT NULL,
  `orderid` int(11) DEFAULT NULL,
  `download_time` datetime DEFAULT NULL,
  `download_succeed` tinyint(1) DEFAULT NULL COMMENT '0：否；1：是',
  `client_type` tinyint(4) DEFAULT NULL COMMENT '0：手机客户端；1：PAD客户端；2：PC客户端；3：Web网站；',
  `uuid` varchar(64) DEFAULT NULL COMMENT 'uuid=IMEI+"-"+mac地址',
  `IP` varchar(32) DEFAULT NULL,
  `terminal_model` varchar(20) DEFAULT NULL,
  `created` datetime DEFAULT '1970-01-01 00:00:00',
  `modified` datetime DEFAULT '1970-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_app_download_log
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_app_download_stat`
-- ----------------------------
DROP TABLE IF EXISTS `tb_app_download_stat`;
CREATE TABLE `tb_app_download_stat` (
  `id` int(11) NOT NULL,
  `appid` int(11) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `month` smallint(6) DEFAULT NULL,
  `day` smallint(6) DEFAULT NULL,
  `download_times` int(11) DEFAULT NULL,
  `created` datetime DEFAULT '1970-01-01 00:00:00',
  `modified` datetime DEFAULT '1970-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_app_download_stat
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_app_log`
-- ----------------------------
DROP TABLE IF EXISTS `tb_app_log`;
CREATE TABLE `tb_app_log` (
  `id` int(11) NOT NULL,
  `appid` int(11) DEFAULT NULL COMMENT '即SKU，按照规则自增',
  `app_name` varchar(30) DEFAULT NULL,
  `package` varchar(150) DEFAULT NULL,
  `app_type` tinyint(4) DEFAULT NULL COMMENT '0：android-phone；1：android-PAD；2：android-ALL；3：web-flash；4：web-iframe',
  `categoryid_l2` int(11) DEFAULT NULL,
  `categoryid1` int(11) DEFAULT NULL,
  `categoryid2` int(11) DEFAULT NULL,
  `default_detail_id` int(11) DEFAULT NULL,
  `base_check_status` tinyint(4) DEFAULT NULL COMMENT '该应用整体未上架时，标记当前信息的提交、审核状态。\n            1：未提交；2：已提交，待审核；3：审核通过；4：审核不通过',
  `base_sync_flag` tinyint(4) DEFAULT '0' COMMENT '0：不需要同步；1：需要同步；',
  `online_sync_flag` tinyint(4) DEFAULT NULL COMMENT '0：不需要同步；1：需要同步；',
  `online_opt_type` tinyint(4) DEFAULT '2' COMMENT '0：下架操作；1：上架操作；2：不操作；',
  `newst_flag` tinyint(1) DEFAULT NULL COMMENT '每个应用的最新记录标记。\n            0：否；1：是最新；',
  `created` datetime DEFAULT '1970-01-01 00:00:00',
  `modified` datetime DEFAULT '1970-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_app_log
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_app_os_adapter`
-- ----------------------------
DROP TABLE IF EXISTS `tb_app_os_adapter`;
CREATE TABLE `tb_app_os_adapter` (
  `id` int(11) NOT NULL,
  `appid` int(11) NOT NULL,
  `accountid` int(11) NOT NULL,
  `os_version_id` int(11) NOT NULL,
  `created` datetime DEFAULT '1970-01-01 00:00:00',
  `modified` datetime DEFAULT '1970-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_app_os_adapter
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_app_resource`
-- ----------------------------
DROP TABLE IF EXISTS `tb_app_resource`;
CREATE TABLE `tb_app_resource` (
  `res_id` int(11) NOT NULL,
  `appid` int(11) DEFAULT NULL COMMENT '即SKU，按照规则自增',
  `accountid` int(11) DEFAULT NULL,
  `res_type` tinyint(4) DEFAULT '0' COMMENT '0：截图；1：android应用安装包；2：web应用包',
  `cap_seq` smallint(6) DEFAULT NULL,
  `res_url` varchar(200) DEFAULT NULL,
  `is_copy` tinyint(1) DEFAULT NULL COMMENT '0：否；1：是；',
  `created` datetime DEFAULT '1970-01-01 00:00:00',
  `modified` datetime DEFAULT '1970-01-01 00:00:00',
  `zhuowangMark` int(11) DEFAULT NULL,
  PRIMARY KEY (`res_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_app_resource
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_app_scr_adapter`
-- ----------------------------
DROP TABLE IF EXISTS `tb_app_scr_adapter`;
CREATE TABLE `tb_app_scr_adapter` (
  `id` int(11) NOT NULL,
  `appid` int(11) NOT NULL,
  `accountid` int(11) NOT NULL,
  `screen_size_id` int(11) NOT NULL,
  `created` datetime DEFAULT '1970-01-01 00:00:00',
  `modified` datetime DEFAULT '1970-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_app_scr_adapter
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_app_user_log`
-- ----------------------------
DROP TABLE IF EXISTS `tb_app_user_log`;
CREATE TABLE `tb_app_user_log` (
  `id` int(11) NOT NULL,
  `pin` varchar(30) DEFAULT NULL,
  `token` varchar(256) DEFAULT NULL,
  `log_type` tinyint(4) DEFAULT NULL COMMENT '0：登录；1：登出；2：注册',
  `action_time` datetime DEFAULT NULL,
  `client_type` tinyint(4) DEFAULT NULL COMMENT '0：android手机客户端；1：android PAD客户端；2：PC客户端；3：Web网站；',
  `channel_id` tinyint(4) DEFAULT NULL,
  `client_version` varchar(20) DEFAULT NULL,
  `uuid` varchar(64) DEFAULT NULL COMMENT 'uuid=IMEI+"-"+mac地址',
  `IP` varchar(32) DEFAULT NULL,
  `terminal_model` varchar(20) DEFAULT NULL,
  `created` datetime DEFAULT '1970-01-01 00:00:00',
  `modified` datetime DEFAULT '1970-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_app_user_log
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_apps`
-- ----------------------------
DROP TABLE IF EXISTS `tb_apps`;
CREATE TABLE `tb_apps` (
  `appid` int(11) NOT NULL COMMENT '即SKU，按照规则自增',
  `app_name` varchar(30) DEFAULT NULL,
  `package` varchar(150) DEFAULT NULL,
  `app_type` tinyint(4) DEFAULT NULL COMMENT '0：android-phone；1：android-PAD；2：android-ALL；3：web-flash；4：web-iframe',
  `categoryid_l2` int(11) DEFAULT NULL,
  `categoryid1` int(11) DEFAULT NULL,
  `categoryid2` int(11) DEFAULT NULL,
  `default_detail_id` int(11) DEFAULT NULL,
  `online` tinyint(4) DEFAULT NULL COMMENT '0：未上架；1：已上架；2：已下架',
  `created` datetime DEFAULT '1970-01-01 00:00:00',
  `modified` datetime DEFAULT '1970-01-01 00:00:00',
  `zhuowangMark` int(10) DEFAULT NULL,
  PRIMARY KEY (`appid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_apps
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_backend_task`
-- ----------------------------
DROP TABLE IF EXISTS `tb_backend_task`;
CREATE TABLE `tb_backend_task` (
  `id` int(11) NOT NULL,
  `task_type_id` int(11) NOT NULL COMMENT '1：同步商品基本信息；2：同步价格；3：同步上下架状态；4：同步商品类目；5：生成下载统计日报；6：更新排行榜；7：合到期预警检测；8：上传主图',
  `related_id` int(11) DEFAULT NULL,
  `related_type` tinyint(4) DEFAULT NULL,
  `status` tinyint(4) NOT NULL COMMENT '0：待执行；1：已启动；2：执行成功；3：执行失败；4：已停用\n            执行失败，如果是自动重试，则直接变为“待执行状态”',
  `admin_id` varchar(50) NOT NULL,
  `ip` varchar(32) NOT NULL,
  `start_time_plan` datetime DEFAULT NULL,
  `start_time_fact` datetime DEFAULT NULL,
  `comment` varchar(256) DEFAULT NULL,
  `retry_times` tinyint(4) NOT NULL,
  `auto_retry` tinyint(1) NOT NULL COMMENT '0：不需要；1：需要；',
  `created` datetime NOT NULL COMMENT '创建时间',
  `modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_backend_task
-- ----------------------------
INSERT INTO `tb_backend_task` VALUES ('1', '4', '0', null, '0', 'admin', '127.0.0.1', null, null, '同步商品类目', '0', '0', '2013-03-01 17:41:48', '2013-03-01 17:41:48');
INSERT INTO `tb_backend_task` VALUES ('2', '5', '0', null, '0', 'admin', '127.0.0.1', null, '2013-03-12 00:30:00', '生成下载统计日报', '0', '0', '2013-03-01 17:41:48', '2013-03-01 17:41:48');
INSERT INTO `tb_backend_task` VALUES ('3', '6', '0', null, '4', 'admin', '127.0.0.1', null, null, '更新排行榜', '0', '0', '2013-03-01 17:41:48', '2013-03-01 17:41:48');
INSERT INTO `tb_backend_task` VALUES ('4', '9', '0', null, '0', 'admin', '127.0.0.1', null, '2013-03-12 00:30:00', '应用安装统计日报', '0', '0', '2013-03-01 17:41:48', '2013-03-01 17:41:48');
INSERT INTO `tb_backend_task` VALUES ('5', '10', '0', null, '0', 'admin', '127.0.0.1', null, '2013-03-08 18:50:01', '同步卓望增量接口数据', '10', '0', '2013-03-08 16:36:14', '2013-03-08 16:36:21');

-- ----------------------------
-- Table structure for `tb_category`
-- ----------------------------
DROP TABLE IF EXISTS `tb_category`;
CREATE TABLE `tb_category` (
  `categoryid` int(11) NOT NULL,
  `category_name` varchar(30) DEFAULT NULL,
  `level` tinyint(4) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `is_leaf` tinyint(1) DEFAULT NULL,
  `pubed_status` tinyint(4) DEFAULT NULL,
  `created` datetime DEFAULT '1970-01-01 00:00:00',
  `modified` datetime DEFAULT '1970-01-01 00:00:00',
  `logo_url` varchar(200) DEFAULT NULL,
  `expired_status` tinyint(4) DEFAULT NULL,
  `intro` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`categoryid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_category
-- ----------------------------
INSERT INTO `tb_category` VALUES ('100000', '应用商店', '1', '0', '1', '1', '2013-03-12 12:09:42', '2013-03-12 12:09:42', '', '0', '');
INSERT INTO `tb_category` VALUES ('100001', '移动游戏', '2', '100000', '2', '1', '2013-03-12 12:09:42', '2013-03-12 12:09:42', '', '0', '');
INSERT INTO `tb_category` VALUES ('100002', '移动软件', '2', '100000', '2', '1', '2013-03-12 12:09:42', '2013-03-12 12:09:42', '', '0', '');
INSERT INTO `tb_category` VALUES ('3', '浏览器', '3', '100002', '3', '1', '2013-03-12 12:09:42', '2013-03-12 12:09:42', '', '0', '');
INSERT INTO `tb_category` VALUES ('8', '输入法', '3', '100002', '3', '1', '2013-03-12 12:09:42', '2013-03-12 12:09:42', '', '0', '');
INSERT INTO `tb_category` VALUES ('4', '社区交友', '3', '100002', '3', '1', '2013-03-12 12:09:42', '2013-03-12 12:09:42', '', '0', '');
INSERT INTO `tb_category` VALUES ('18', '安全防护', '3', '100002', '3', '1', '2013-03-12 12:09:42', '2013-03-12 12:09:42', '', '0', '');
INSERT INTO `tb_category` VALUES ('13', '系统工具', '3', '100002', '3', '1', '2013-03-12 12:09:42', '2013-03-12 12:09:42', '', '0', '');
INSERT INTO `tb_category` VALUES ('10', '新闻资讯', '3', '100002', '3', '1', '2013-03-12 12:09:42', '2013-03-12 12:09:42', '', '0', '');
INSERT INTO `tb_category` VALUES ('1', '报刊杂志', '3', '100002', '3', '1', '2013-03-12 12:09:42', '2013-03-12 12:09:42', '', '0', '');
INSERT INTO `tb_category` VALUES ('19', '摄影录像', '3', '100002', '3', '1', '2013-03-12 12:09:42', '2013-03-12 12:09:42', '', '0', '');
INSERT INTO `tb_category` VALUES ('11', '金融理财', '3', '100002', '3', '1', '2013-03-12 12:09:42', '2013-03-12 12:09:42', '', '0', '');
INSERT INTO `tb_category` VALUES ('12', '通话通信', '3', '100002', '3', '1', '2013-03-12 12:09:42', '2013-03-12 12:09:42', '', '0', '');
INSERT INTO `tb_category` VALUES ('14', '商务办公', '3', '100002', '3', '1', '2013-03-12 12:09:42', '2013-03-12 12:09:42', '', '0', '');
INSERT INTO `tb_category` VALUES ('9', '交通导航', '3', '100002', '3', '1', '2013-03-12 12:09:42', '2013-03-12 12:09:42', '', '0', '');
INSERT INTO `tb_category` VALUES ('15', '旅游出行', '3', '100002', '3', '1', '2013-03-12 12:09:42', '2013-03-12 12:09:42', '', '0', '');
INSERT INTO `tb_category` VALUES ('2', '网络购物', '3', '100002', '3', '1', '2013-03-12 12:09:42', '2013-03-12 12:09:42', '', '0', '');
INSERT INTO `tb_category` VALUES ('16', '生活助手', '3', '100002', '3', '1', '2013-03-12 12:09:42', '2013-03-12 12:09:42', '', '0', '');
INSERT INTO `tb_category` VALUES ('17', '教育教学', '3', '100002', '3', '1', '2013-03-12 12:09:42', '2013-03-12 12:09:42', '', '0', '');
INSERT INTO `tb_category` VALUES ('21', '卡通动漫', '3', '100002', '3', '1', '2013-03-12 12:09:42', '2013-03-12 12:09:42', '', '0', '');
INSERT INTO `tb_category` VALUES ('22', '健康医疗', '3', '100002', '3', '1', '2013-03-12 12:09:42', '2013-03-12 12:09:42', '', '0', '');
INSERT INTO `tb_category` VALUES ('23', '电子书籍', '3', '100002', '3', '1', '2013-03-12 12:09:42', '2013-03-12 12:09:42', '', '0', '');
INSERT INTO `tb_category` VALUES ('24', '儿童应用', '3', '100002', '3', '1', '2013-03-12 12:09:42', '2013-03-12 12:09:42', '', '0', '');
INSERT INTO `tb_category` VALUES ('20', '娱乐八卦', '3', '100002', '3', '1', '2013-03-12 12:09:42', '2013-03-12 12:09:42', '', '0', '');
INSERT INTO `tb_category` VALUES ('5', '网络视频', '3', '100002', '3', '1', '2013-03-12 12:09:42', '2013-03-12 12:09:42', '', '0', '');
INSERT INTO `tb_category` VALUES ('6', '数字音乐', '3', '100002', '3', '1', '2013-03-12 12:09:42', '2013-03-12 12:09:42', '', '0', '');
INSERT INTO `tb_category` VALUES ('7', '影音工具', '3', '100002', '3', '1', '2013-03-12 12:09:42', '2013-03-12 12:09:42', '', '0', '');
INSERT INTO `tb_category` VALUES ('25', '美化壁纸', '3', '100002', '3', '1', '2013-03-12 12:09:42', '2013-03-12 12:09:42', '', '0', '');
INSERT INTO `tb_category` VALUES ('26', '动作冒险', '3', '100001', '3', '1', '2013-03-12 12:09:43', '2013-03-12 12:09:43', '', '0', '');
INSERT INTO `tb_category` VALUES ('27', '经营养成', '3', '100001', '3', '1', '2013-03-12 12:09:43', '2013-03-12 12:09:43', '', '0', '');
INSERT INTO `tb_category` VALUES ('28', '射击游戏', '3', '100001', '3', '1', '2013-03-12 12:09:43', '2013-03-12 12:09:43', '', '0', '');
INSERT INTO `tb_category` VALUES ('29', '休闲益智', '3', '100001', '3', '1', '2013-03-12 12:09:43', '2013-03-12 12:09:43', '', '0', '');
INSERT INTO `tb_category` VALUES ('30', '角色扮演', '3', '100001', '3', '1', '2013-03-12 12:09:43', '2013-03-12 12:09:43', '', '0', '');
INSERT INTO `tb_category` VALUES ('31', '体育赛车', '3', '100001', '3', '1', '2013-03-12 12:09:43', '2013-03-12 12:09:43', '', '0', '');
INSERT INTO `tb_category` VALUES ('32', '棋牌游戏', '3', '100001', '3', '1', '2013-03-12 12:09:43', '2013-03-12 12:09:43', '', '0', '');
INSERT INTO `tb_category` VALUES ('33', '策略游戏', '3', '100001', '3', '1', '2013-03-12 12:09:43', '2013-03-12 12:09:43', '', '0', '');
INSERT INTO `tb_category` VALUES ('34', '儿童游戏', '3', '100001', '3', '1', '2013-03-12 12:09:43', '2013-03-12 12:09:43', '', '0', '');
INSERT INTO `tb_category` VALUES ('35', '文字游戏', '3', '100001', '3', '1', '2013-03-12 12:09:43', '2013-03-12 12:09:43', '', '0', '');
INSERT INTO `tb_category` VALUES ('36', '网络游戏', '3', '100001', '3', '1', '2013-03-12 12:09:43', '2013-03-12 12:09:43', '', '0', '');
INSERT INTO `tb_category` VALUES ('37', '其他游戏', '3', '100001', '3', '1', '2013-03-12 12:09:43', '2013-03-12 12:09:43', '', '0', '');

-- ----------------------------
-- Table structure for `tb_channel_cp`
-- ----------------------------
DROP TABLE IF EXISTS `tb_channel_cp`;
CREATE TABLE `tb_channel_cp` (
  `id` int(11) NOT NULL COMMENT '0：同步商品基本信息；1：同步价格；2：同步上下架状态；3：同步商品类目；4：同步供应商信息；5：生成下载统计日报；',
  `cpid` int(11) NOT NULL,
  `created` datetime NOT NULL COMMENT '创建时间',
  `modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_channel_cp
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_channel_topic`
-- ----------------------------
DROP TABLE IF EXISTS `tb_channel_topic`;
CREATE TABLE `tb_channel_topic` (
  `id` int(11) NOT NULL,
  `cid` int(11) NOT NULL COMMENT '0：同步商品基本信息；1：同步价格；2：同步上下架状态；3：同步商品类目；4：同步供应商信息；5：生成下载统计日报；',
  `topicid` int(11) NOT NULL,
  `topicseq` int(11) NOT NULL,
  `created` datetime NOT NULL COMMENT '创建时间',
  `modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_channel_topic
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_city_district`
-- ----------------------------
DROP TABLE IF EXISTS `tb_city_district`;
CREATE TABLE `tb_city_district` (
  `id` int(11) NOT NULL,
  `city_id` int(11) NOT NULL,
  `district` varchar(50) NOT NULL,
  `created` datetime DEFAULT '1970-01-01 00:00:00',
  `modified` datetime DEFAULT '1970-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_city_district
-- ----------------------------
INSERT INTO `tb_city_district` VALUES ('1', '1', '东城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2', '1', '西城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3', '1', '朝阳区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('4', '1', '丰台区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('5', '1', '石景山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('6', '1', '海淀区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('7', '1', '门头沟区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('8', '1', '房山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('9', '1', '通州区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('10', '1', '顺义区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('11', '1', '昌平区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('12', '1', '大兴区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('13', '1', '怀柔区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('14', '1', '平谷区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('15', '2', '密云县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('16', '2', '延庆县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('17', '3', '和平区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('18', '3', '河东区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('19', '3', '河西区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('20', '3', '南开区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('21', '3', '河北区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('22', '3', '红桥区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('23', '3', '东丽区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('24', '3', '西青区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('25', '3', '津南区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('26', '3', '北辰区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('27', '3', '武清区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('28', '3', '宝坻区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('29', '3', '滨海新区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('30', '4', '宁河县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('31', '4', '静海县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('32', '4', '蓟县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('33', '5', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('34', '5', '长安区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('35', '5', '桥东区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('36', '5', '桥西区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('37', '5', '新华区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('38', '5', '井陉矿区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('39', '5', '裕华区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('40', '5', '井陉县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('41', '5', '正定县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('42', '5', '栾城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('43', '5', '行唐县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('44', '5', '灵寿县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('45', '5', '高邑县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('46', '5', '深泽县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('47', '5', '赞皇县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('48', '5', '无极县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('49', '5', '平山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('50', '5', '元氏县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('51', '5', '赵县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('52', '5', '辛集市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('53', '5', '藁城市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('54', '5', '晋州市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('55', '5', '新乐市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('56', '5', '鹿泉市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('57', '6', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('58', '6', '路南区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('59', '6', '路北区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('60', '6', '古冶区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('61', '6', '开平区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('62', '6', '丰南区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('63', '6', '丰润区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('64', '6', '滦县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('65', '6', '滦南县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('66', '6', '乐亭县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('67', '6', '迁西县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('68', '6', '玉田县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('69', '6', '唐海县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('70', '6', '遵化市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('71', '6', '迁安市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('72', '7', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('73', '7', '海港区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('74', '7', '山海关区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('75', '7', '北戴河区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('76', '7', '青龙满族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('77', '7', '昌黎县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('78', '7', '抚宁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('79', '7', '卢龙县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('80', '8', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('81', '8', '邯山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('82', '8', '丛台区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('83', '8', '复兴区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('84', '8', '峰峰矿区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('85', '8', '邯郸县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('86', '8', '临漳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('87', '8', '成安县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('88', '8', '大名县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('89', '8', '涉县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('90', '8', '磁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('91', '8', '肥乡县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('92', '8', '永年县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('93', '8', '邱县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('94', '8', '鸡泽县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('95', '8', '广平县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('96', '8', '馆陶县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('97', '8', '魏县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('98', '8', '曲周县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('99', '8', '武安市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('100', '9', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('101', '9', '桥东区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('102', '9', '桥西区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('103', '9', '邢台县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('104', '9', '临城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('105', '9', '内丘县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('106', '9', '柏乡县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('107', '9', '隆尧县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('108', '9', '任县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('109', '9', '南和县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('110', '9', '宁晋县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('111', '9', '巨鹿县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('112', '9', '新河县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('113', '9', '广宗县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('114', '9', '平乡县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('115', '9', '威县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('116', '9', '清河县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('117', '9', '临西县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('118', '9', '南宫市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('119', '9', '沙河市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('120', '10', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('121', '10', '新市区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('122', '10', '北市区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('123', '10', '南市区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('124', '10', '满城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('125', '10', '清苑县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('126', '10', '涞水县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('127', '10', '阜平县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('128', '10', '徐水县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('129', '10', '定兴县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('130', '10', '唐县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('131', '10', '高阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('132', '10', '容城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('133', '10', '涞源县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('134', '10', '望都县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('135', '10', '安新县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('136', '10', '易县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('137', '10', '曲阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('138', '10', '蠡县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('139', '10', '顺平县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('140', '10', '博野县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('141', '10', '雄县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('142', '10', '涿州市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('143', '10', '定州市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('144', '10', '安国市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('145', '10', '高碑店市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('146', '11', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('147', '11', '桥东区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('148', '11', '桥西区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('149', '11', '宣化区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('150', '11', '下花园区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('151', '11', '宣化县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('152', '11', '张北县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('153', '11', '康保县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('154', '11', '沽源县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('155', '11', '尚义县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('156', '11', '蔚县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('157', '11', '阳原县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('158', '11', '怀安县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('159', '11', '万全县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('160', '11', '怀来县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('161', '11', '涿鹿县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('162', '11', '赤城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('163', '11', '崇礼县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('164', '12', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('165', '12', '双桥区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('166', '12', '双滦区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('167', '12', '鹰手营子矿区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('168', '12', '承德县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('169', '12', '兴隆县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('170', '12', '平泉县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('171', '12', '滦平县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('172', '12', '隆化县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('173', '12', '丰宁满族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('174', '12', '宽城满族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('175', '12', '围场满族蒙古族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('176', '13', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('177', '13', '新华区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('178', '13', '运河区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('179', '13', '沧县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('180', '13', '青县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('181', '13', '东光县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('182', '13', '海兴县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('183', '13', '盐山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('184', '13', '肃宁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('185', '13', '南皮县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('186', '13', '吴桥县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('187', '13', '献县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('188', '13', '孟村回族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('189', '13', '泊头市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('190', '13', '任丘市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('191', '13', '黄骅市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('192', '13', '河间市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('193', '14', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('194', '14', '安次区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('195', '14', '广阳区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('196', '14', '固安县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('197', '14', '永清县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('198', '14', '香河县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('199', '14', '大城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('200', '14', '文安县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('201', '14', '大厂回族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('202', '14', '霸州市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('203', '14', '三河市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('204', '15', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('205', '15', '桃城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('206', '15', '枣强县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('207', '15', '武邑县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('208', '15', '武强县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('209', '15', '饶阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('210', '15', '安平县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('211', '15', '故城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('212', '15', '景县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('213', '15', '阜城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('214', '15', '冀州市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('215', '15', '深州市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('216', '16', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('217', '16', '小店区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('218', '16', '迎泽区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('219', '16', '杏花岭区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('220', '16', '尖草坪区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('221', '16', '万柏林区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('222', '16', '晋源区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('223', '16', '清徐县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('224', '16', '阳曲县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('225', '16', '娄烦县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('226', '16', '古交市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('227', '17', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('228', '17', '城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('229', '17', '矿区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('230', '17', '南郊区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('231', '17', '新荣区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('232', '17', '阳高县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('233', '17', '天镇县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('234', '17', '广灵县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('235', '17', '灵丘县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('236', '17', '浑源县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('237', '17', '左云县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('238', '17', '大同县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('239', '18', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('240', '18', '城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('241', '18', '矿区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('242', '18', '郊区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('243', '18', '平定县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('244', '18', '盂县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('245', '19', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('246', '19', '城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('247', '19', '郊区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('248', '19', '长治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('249', '19', '襄垣县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('250', '19', '屯留县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('251', '19', '平顺县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('252', '19', '黎城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('253', '19', '壶关县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('254', '19', '长子县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('255', '19', '武乡县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('256', '19', '沁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('257', '19', '沁源县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('258', '19', '潞城市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('259', '20', '城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('260', '20', '沁水县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('261', '20', '阳城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('262', '20', '陵川县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('263', '20', '泽州县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('264', '20', '高平市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('265', '21', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('266', '21', '朔城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('267', '21', '平鲁区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('268', '21', '山阴县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('269', '21', '应县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('270', '21', '右玉县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('271', '21', '怀仁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('272', '22', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('273', '22', '榆次区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('274', '22', '榆社县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('275', '22', '左权县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('276', '22', '和顺县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('277', '22', '昔阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('278', '22', '寿阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('279', '22', '太谷县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('280', '22', '祁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('281', '22', '平遥县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('282', '22', '灵石县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('283', '22', '介休市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('284', '23', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('285', '23', '盐湖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('286', '23', '临猗县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('287', '23', '万荣县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('288', '23', '闻喜县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('289', '23', '稷山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('290', '23', '新绛县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('291', '23', '绛县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('292', '23', '垣曲县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('293', '23', '夏县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('294', '23', '平陆县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('295', '23', '芮城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('296', '23', '永济市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('297', '23', '河津市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('298', '24', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('299', '24', '忻府区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('300', '24', '定襄县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('301', '24', '五台县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('302', '24', '代县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('303', '24', '繁峙县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('304', '24', '宁武县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('305', '24', '静乐县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('306', '24', '神池县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('307', '24', '五寨县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('308', '24', '岢岚县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('309', '24', '河曲县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('310', '24', '保德县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('311', '24', '偏关县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('312', '24', '原平市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('313', '25', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('314', '25', '尧都区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('315', '25', '曲沃县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('316', '25', '翼城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('317', '25', '襄汾县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('318', '25', '洪洞县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('319', '25', '古县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('320', '25', '安泽县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('321', '25', '浮山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('322', '25', '吉县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('323', '25', '乡宁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('324', '25', '大宁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('325', '25', '隰县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('326', '25', '永和县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('327', '25', '蒲县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('328', '25', '汾西县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('329', '25', '侯马市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('330', '25', '霍州市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('331', '26', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('332', '26', '离石区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('333', '26', '文水县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('334', '26', '交城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('335', '26', '兴县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('336', '26', '临县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('337', '26', '柳林县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('338', '26', '石楼县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('339', '26', '岚县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('340', '26', '方山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('341', '26', '中阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('342', '26', '交口县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('343', '26', '孝义市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('344', '26', '汾阳市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('345', '27', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('346', '27', '新城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('347', '27', '回民区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('348', '27', '玉泉区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('349', '27', '赛罕区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('350', '27', '土默特左旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('351', '27', '托克托县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('352', '27', '和林格尔县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('353', '27', '清水河县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('354', '27', '武川县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('355', '28', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('356', '28', '东河区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('357', '28', '昆都仑区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('358', '28', '青山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('359', '28', '石拐区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('360', '28', '白云鄂博矿区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('361', '28', '九原区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('362', '28', '土默特右旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('363', '28', '固阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('364', '28', '达尔罕茂明安联合旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('365', '29', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('366', '29', '海勃湾区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('367', '29', '海南区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('368', '29', '乌达区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('369', '30', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('370', '30', '红山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('371', '30', '元宝山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('372', '30', '松山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('373', '30', '阿鲁科尔沁旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('374', '30', '巴林左旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('375', '30', '巴林右旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('376', '30', '林西县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('377', '30', '克什克腾旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('378', '30', '翁牛特旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('379', '30', '喀喇沁旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('380', '30', '宁城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('381', '30', '敖汉旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('382', '31', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('383', '31', '科尔沁区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('384', '31', '科尔沁左翼中旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('385', '31', '科尔沁左翼后旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('386', '31', '开鲁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('387', '31', '库伦旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('388', '31', '奈曼旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('389', '31', '扎鲁特旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('390', '31', '霍林郭勒市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('391', '32', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('392', '32', '东胜区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('393', '32', '达拉特旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('394', '32', '准格尔旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('395', '32', '鄂托克前旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('396', '32', '鄂托克旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('397', '32', '杭锦旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('398', '32', '乌审旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('399', '32', '伊金霍洛旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('400', '33', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('401', '33', '海拉尔区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('402', '33', '阿荣旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('403', '33', '莫力达瓦达斡尔族自治旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('404', '33', '鄂伦春自治旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('405', '33', '鄂温克族自治旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('406', '33', '陈巴尔虎旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('407', '33', '新巴尔虎左旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('408', '33', '新巴尔虎右旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('409', '33', '满洲里市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('410', '33', '牙克石市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('411', '33', '扎兰屯市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('412', '33', '额尔古纳市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('413', '33', '根河市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('414', '34', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('415', '34', '临河区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('416', '34', '五原县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('417', '34', '磴口县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('418', '34', '乌拉特前旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('419', '34', '乌拉特中旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('420', '34', '乌拉特后旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('421', '34', '杭锦后旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('422', '35', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('423', '35', '集宁区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('424', '35', '卓资县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('425', '35', '化德县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('426', '35', '商都县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('427', '35', '兴和县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('428', '35', '凉城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('429', '35', '察哈尔右翼前旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('430', '35', '察哈尔右翼中旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('431', '35', '察哈尔右翼后旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('432', '35', '四子王旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('433', '35', '丰镇市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('434', '36', '乌兰浩特市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('435', '36', '阿尔山市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('436', '36', '科尔沁右翼前旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('437', '36', '科尔沁右翼中旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('438', '36', '扎赉特旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('439', '36', '突泉县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('440', '37', '二连浩特市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('441', '37', '锡林浩特市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('442', '37', '阿巴嘎旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('443', '37', '苏尼特左旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('444', '37', '苏尼特右旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('445', '37', '东乌珠穆沁旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('446', '37', '西乌珠穆沁旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('447', '37', '太仆寺旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('448', '37', '镶黄旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('449', '37', '正镶白旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('450', '37', '正蓝旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('451', '37', '多伦县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('452', '38', '阿拉善左旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('453', '38', '阿拉善右旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('454', '38', '额济纳旗', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('455', '39', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('456', '39', '和平区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('457', '39', '沈河区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('458', '39', '大东区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('459', '39', '皇姑区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('460', '39', '铁西区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('461', '39', '苏家屯区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('462', '39', '东陵区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('463', '39', '沈北新区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('464', '39', '于洪区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('465', '39', '辽中县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('466', '39', '康平县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('467', '39', '法库县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('468', '39', '新民市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('469', '40', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('470', '40', '中山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('471', '40', '西岗区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('472', '40', '沙河口区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('473', '40', '甘井子区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('474', '40', '旅顺口区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('475', '40', '金州区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('476', '40', '长海县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('477', '40', '瓦房店市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('478', '40', '普兰店市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('479', '40', '庄河市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('480', '41', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('481', '41', '铁东区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('482', '41', '铁西区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('483', '41', '立山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('484', '41', '千山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('485', '41', '台安县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('486', '41', '岫岩满族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('487', '41', '海城市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('488', '42', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('489', '42', '新抚区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('490', '42', '东洲区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('491', '42', '望花区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('492', '42', '顺城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('493', '42', '抚顺县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('494', '42', '新宾满族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('495', '42', '清原满族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('496', '43', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('497', '43', '平山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('498', '43', '溪湖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('499', '43', '明山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('500', '43', '南芬区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('501', '43', '本溪满族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('502', '43', '桓仁满族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('503', '44', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('504', '44', '元宝区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('505', '44', '振兴区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('506', '44', '振安区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('507', '44', '宽甸满族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('508', '44', '东港市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('509', '44', '凤城市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('510', '45', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('511', '45', '古塔区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('512', '45', '凌河区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('513', '45', '太和区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('514', '45', '黑山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('515', '45', '义县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('516', '45', '凌海市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('517', '45', '北镇市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('518', '46', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('519', '46', '站前区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('520', '46', '西市区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('521', '46', '鲅鱼圈区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('522', '46', '老边区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('523', '46', '盖州市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('524', '46', '大石桥市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('525', '47', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('526', '47', '海州区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('527', '47', '新邱区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('528', '47', '太平区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('529', '47', '清河门区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('530', '47', '细河区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('531', '47', '阜新蒙古族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('532', '47', '彰武县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('533', '48', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('534', '48', '白塔区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('535', '48', '文圣区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('536', '48', '宏伟区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('537', '48', '弓长岭区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('538', '48', '太子河区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('539', '48', '辽阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('540', '48', '灯塔市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('541', '49', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('542', '49', '双台子区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('543', '49', '兴隆台区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('544', '49', '大洼县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('545', '49', '盘山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('546', '50', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('547', '50', '银州区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('548', '50', '清河区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('549', '50', '铁岭县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('550', '50', '西丰县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('551', '50', '昌图县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('552', '50', '调兵山市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('553', '50', '开原市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('554', '51', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('555', '51', '双塔区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('556', '51', '龙城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('557', '51', '朝阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('558', '51', '建平县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('559', '51', '喀喇沁左翼蒙古族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('560', '51', '北票市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('561', '51', '凌源市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('562', '52', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('563', '52', '连山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('564', '52', '龙港区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('565', '52', '南票区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('566', '52', '绥中县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('567', '52', '建昌县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('568', '52', '兴城市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('569', '53', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('570', '53', '南关区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('571', '53', '宽城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('572', '53', '朝阳区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('573', '53', '二道区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('574', '53', '绿园区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('575', '53', '双阳区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('576', '53', '农安县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('577', '53', '九台市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('578', '53', '榆树市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('579', '53', '德惠市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('580', '54', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('581', '54', '昌邑区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('582', '54', '龙潭区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('583', '54', '船营区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('584', '54', '丰满区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('585', '54', '永吉县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('586', '54', '蛟河市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('587', '54', '桦甸市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('588', '54', '舒兰市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('589', '54', '磐石市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('590', '55', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('591', '55', '铁西区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('592', '55', '铁东区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('593', '55', '梨树县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('594', '55', '伊通满族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('595', '55', '公主岭市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('596', '55', '双辽市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('597', '56', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('598', '56', '龙山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('599', '56', '西安区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('600', '56', '东丰县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('601', '56', '东辽县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('602', '57', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('603', '57', '东昌区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('604', '57', '二道江区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('605', '57', '通化县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('606', '57', '辉南县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('607', '57', '柳河县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('608', '57', '梅河口市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('609', '57', '集安市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('610', '58', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('611', '58', '八道江区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('612', '58', '江源区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('613', '58', '抚松县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('614', '58', '靖宇县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('615', '58', '长白朝鲜族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('616', '58', '临江市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('617', '59', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('618', '59', '宁江区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('619', '59', '前郭尔罗斯蒙古族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('620', '59', '长岭县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('621', '59', '乾安县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('622', '59', '扶余县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('623', '60', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('624', '60', '洮北区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('625', '60', '镇赉县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('626', '60', '通榆县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('627', '60', '洮南市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('628', '60', '大安市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('629', '61', '延吉市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('630', '61', '图们市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('631', '61', '敦化市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('632', '61', '珲春市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('633', '61', '龙井市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('634', '61', '和龙市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('635', '61', '汪清县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('636', '61', '安图县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('637', '62', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('638', '62', '道里区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('639', '62', '南岗区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('640', '62', '道外区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('641', '62', '平房区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('642', '62', '松北区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('643', '62', '香坊区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('644', '62', '呼兰区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('645', '62', '阿城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('646', '62', '依兰县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('647', '62', '方正县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('648', '62', '宾县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('649', '62', '巴彦县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('650', '62', '木兰县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('651', '62', '通河县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('652', '62', '延寿县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('653', '62', '双城市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('654', '62', '尚志市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('655', '62', '五常市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('656', '63', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('657', '63', '龙沙区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('658', '63', '建华区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('659', '63', '铁锋区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('660', '63', '昂昂溪区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('661', '63', '富拉尔基区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('662', '63', '碾子山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('663', '63', '梅里斯达斡尔族区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('664', '63', '龙江县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('665', '63', '依安县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('666', '63', '泰来县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('667', '63', '甘南县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('668', '63', '富裕县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('669', '63', '克山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('670', '63', '克东县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('671', '63', '拜泉县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('672', '63', '讷河市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('673', '64', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('674', '64', '鸡冠区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('675', '64', '恒山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('676', '64', '滴道区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('677', '64', '梨树区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('678', '64', '城子河区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('679', '64', '麻山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('680', '64', '鸡东县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('681', '64', '虎林市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('682', '64', '密山市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('683', '65', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('684', '65', '向阳区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('685', '65', '工农区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('686', '65', '南山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('687', '65', '兴安区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('688', '65', '东山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('689', '65', '兴山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('690', '65', '萝北县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('691', '65', '绥滨县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('692', '66', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('693', '66', '尖山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('694', '66', '岭东区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('695', '66', '四方台区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('696', '66', '宝山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('697', '66', '集贤县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('698', '66', '友谊县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('699', '66', '宝清县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('700', '66', '饶河县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('701', '67', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('702', '67', '萨尔图区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('703', '67', '龙凤区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('704', '67', '让胡路区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('705', '67', '红岗区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('706', '67', '大同区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('707', '67', '肇州县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('708', '67', '肇源县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('709', '67', '林甸县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('710', '67', '杜尔伯特蒙古族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('711', '68', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('712', '68', '伊春区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('713', '68', '南岔区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('714', '68', '友好区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('715', '68', '西林区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('716', '68', '翠峦区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('717', '68', '新青区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('718', '68', '美溪区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('719', '68', '金山屯区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('720', '68', '五营区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('721', '68', '乌马河区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('722', '68', '汤旺河区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('723', '68', '带岭区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('724', '68', '乌伊岭区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('725', '68', '红星区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('726', '68', '上甘岭区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('727', '68', '嘉荫县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('728', '68', '铁力市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('729', '69', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('730', '69', '向阳区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('731', '69', '前进区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('732', '69', '东风区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('733', '69', '郊区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('734', '69', '桦南县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('735', '69', '桦川县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('736', '69', '汤原县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('737', '69', '抚远县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('738', '69', '同江市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('739', '69', '富锦市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('740', '70', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('741', '70', '新兴区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('742', '70', '桃山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('743', '70', '茄子河区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('744', '70', '勃利县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('745', '71', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('746', '71', '东安区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('747', '71', '阳明区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('748', '71', '爱民区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('749', '71', '西安区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('750', '71', '东宁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('751', '71', '林口县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('752', '71', '绥芬河市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('753', '71', '海林市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('754', '71', '宁安市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('755', '71', '穆棱市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('756', '72', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('757', '72', '爱辉区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('758', '72', '嫩江县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('759', '72', '逊克县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('760', '72', '孙吴县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('761', '72', '北安市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('762', '72', '五大连池市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('763', '73', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('764', '73', '北林区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('765', '73', '望奎县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('766', '73', '兰西县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('767', '73', '青冈县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('768', '73', '庆安县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('769', '73', '明水县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('770', '73', '绥棱县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('771', '73', '安达市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('772', '73', '肇东市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('773', '73', '海伦市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('774', '74', '加格达奇区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('775', '74', '松岭区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('776', '74', '新林区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('777', '74', '呼中区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('778', '74', '呼玛县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('779', '74', '塔河县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('780', '74', '漠河县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('781', '75', '黄浦区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('782', '75', '徐汇区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('783', '75', '长宁区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('784', '75', '静安区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('785', '75', '普陀区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('786', '75', '闸北区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('787', '75', '虹口区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('788', '75', '杨浦区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('789', '75', '闵行区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('790', '75', '宝山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('791', '75', '嘉定区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('792', '75', '浦东新区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('793', '75', '金山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('794', '75', '松江区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('795', '75', '青浦区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('796', '75', '奉贤区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('797', '76', '崇明县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('798', '77', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('799', '77', '玄武区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('800', '77', '白下区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('801', '77', '秦淮区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('802', '77', '建邺区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('803', '77', '鼓楼区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('804', '77', '下关区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('805', '77', '浦口区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('806', '77', '栖霞区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('807', '77', '雨花台区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('808', '77', '江宁区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('809', '77', '六合区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('810', '77', '溧水县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('811', '77', '高淳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('812', '78', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('813', '78', '崇安区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('814', '78', '南长区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('815', '78', '北塘区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('816', '78', '锡山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('817', '78', '惠山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('818', '78', '滨湖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('819', '78', '江阴市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('820', '78', '宜兴市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('821', '79', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('822', '79', '鼓楼区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('823', '79', '云龙区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('824', '79', '贾汪区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('825', '79', '泉山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('826', '79', '铜山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('827', '79', '丰县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('828', '79', '沛县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('829', '79', '睢宁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('830', '79', '新沂市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('831', '79', '邳州市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('832', '80', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('833', '80', '天宁区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('834', '80', '钟楼区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('835', '80', '戚墅堰区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('836', '80', '新北区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('837', '80', '武进区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('838', '80', '溧阳市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('839', '80', '金坛市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('840', '81', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('841', '81', '沧浪区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('842', '81', '平江区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('843', '81', '金阊区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('844', '81', '虎丘区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('845', '81', '吴中区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('846', '81', '相城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('847', '81', '常熟市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('848', '81', '张家港市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('849', '81', '昆山市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('850', '81', '吴江市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('851', '81', '太仓市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('852', '82', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('853', '82', '崇川区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('854', '82', '港闸区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('855', '82', '通州区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('856', '82', '海安县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('857', '82', '如东县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('858', '82', '启东市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('859', '82', '如皋市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('860', '82', '海门市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('861', '83', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('862', '83', '连云区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('863', '83', '新浦区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('864', '83', '海州区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('865', '83', '赣榆县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('866', '83', '东海县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('867', '83', '灌云县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('868', '83', '灌南县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('869', '84', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('870', '84', '清河区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('871', '84', '楚州区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('872', '84', '淮阴区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('873', '84', '清浦区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('874', '84', '涟水县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('875', '84', '洪泽县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('876', '84', '盱眙县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('877', '84', '金湖县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('878', '85', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('879', '85', '亭湖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('880', '85', '盐都区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('881', '85', '响水县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('882', '85', '滨海县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('883', '85', '阜宁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('884', '85', '射阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('885', '85', '建湖县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('886', '85', '东台市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('887', '85', '大丰市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('888', '86', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('889', '86', '广陵区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('890', '86', '邗江区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('891', '86', '江都区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('892', '86', '宝应县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('893', '86', '仪征市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('894', '86', '高邮市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('895', '87', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('896', '87', '京口区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('897', '87', '润州区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('898', '87', '丹徒区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('899', '87', '丹阳市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('900', '87', '扬中市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('901', '87', '句容市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('902', '88', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('903', '88', '海陵区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('904', '88', '高港区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('905', '88', '兴化市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('906', '88', '靖江市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('907', '88', '泰兴市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('908', '88', '姜堰市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('909', '89', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('910', '89', '宿城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('911', '89', '宿豫区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('912', '89', '沭阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('913', '89', '泗阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('914', '89', '泗洪县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('915', '90', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('916', '90', '上城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('917', '90', '下城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('918', '90', '江干区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('919', '90', '拱墅区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('920', '90', '西湖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('921', '90', '滨江区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('922', '90', '萧山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('923', '90', '余杭区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('924', '90', '桐庐县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('925', '90', '淳安县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('926', '90', '建德市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('927', '90', '富阳市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('928', '90', '临安市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('929', '91', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('930', '91', '海曙区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('931', '91', '江东区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('932', '91', '江北区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('933', '91', '北仑区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('934', '91', '镇海区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('935', '91', '鄞州区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('936', '91', '象山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('937', '91', '宁海县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('938', '91', '余姚市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('939', '91', '慈溪市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('940', '91', '奉化市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('941', '92', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('942', '92', '鹿城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('943', '92', '龙湾区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('944', '92', '瓯海区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('945', '92', '洞头县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('946', '92', '永嘉县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('947', '92', '平阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('948', '92', '苍南县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('949', '92', '文成县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('950', '92', '泰顺县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('951', '92', '瑞安市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('952', '92', '乐清市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('953', '93', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('954', '93', '南湖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('955', '93', '秀洲区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('956', '93', '嘉善县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('957', '93', '海盐县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('958', '93', '海宁市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('959', '93', '平湖市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('960', '93', '桐乡市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('961', '94', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('962', '94', '吴兴区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('963', '94', '南浔区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('964', '94', '德清县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('965', '94', '长兴县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('966', '94', '安吉县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('967', '95', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('968', '95', '越城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('969', '95', '绍兴县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('970', '95', '新昌县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('971', '95', '诸暨市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('972', '95', '上虞市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('973', '95', '嵊州市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('974', '96', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('975', '96', '婺城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('976', '96', '金东区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('977', '96', '武义县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('978', '96', '浦江县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('979', '96', '磐安县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('980', '96', '兰溪市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('981', '96', '义乌市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('982', '96', '东阳市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('983', '96', '永康市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('984', '97', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('985', '97', '柯城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('986', '97', '衢江区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('987', '97', '常山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('988', '97', '开化县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('989', '97', '龙游县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('990', '97', '江山市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('991', '98', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('992', '98', '定海区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('993', '98', '普陀区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('994', '98', '岱山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('995', '98', '嵊泗县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('996', '99', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('997', '99', '椒江区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('998', '99', '黄岩区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('999', '99', '路桥区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1000', '99', '玉环县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1001', '99', '三门县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1002', '99', '天台县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1003', '99', '仙居县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1004', '99', '温岭市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1005', '99', '临海市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1006', '100', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1007', '100', '莲都区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1008', '100', '青田县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1009', '100', '缙云县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1010', '100', '遂昌县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1011', '100', '松阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1012', '100', '云和县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1013', '100', '庆元县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1014', '100', '景宁畲族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1015', '100', '龙泉市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1016', '101', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1017', '101', '瑶海区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1018', '101', '庐阳区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1019', '101', '蜀山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1020', '101', '包河区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1021', '101', '长丰县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1022', '101', '肥东县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1023', '101', '肥西县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1024', '101', '庐江县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1025', '101', '巢湖市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1026', '102', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1027', '102', '镜湖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1028', '102', '弋江区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1029', '102', '鸠江区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1030', '102', '三山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1031', '102', '芜湖县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1032', '102', '繁昌县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1033', '102', '南陵县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1034', '102', '无为县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1035', '103', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1036', '103', '龙子湖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1037', '103', '蚌山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1038', '103', '禹会区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1039', '103', '淮上区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1040', '103', '怀远县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1041', '103', '五河县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1042', '103', '固镇县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1043', '104', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1044', '104', '大通区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1045', '104', '田家庵区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1046', '104', '谢家集区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1047', '104', '八公山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1048', '104', '潘集区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1049', '104', '凤台县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1050', '105', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1051', '105', '金家庄区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1052', '105', '花山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1053', '105', '雨山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1054', '105', '当涂县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1055', '105', '含山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1056', '105', '和县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1057', '106', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1058', '106', '杜集区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1059', '106', '相山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1060', '106', '烈山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1061', '106', '濉溪县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1062', '107', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1063', '107', '铜官山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1064', '107', '狮子山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1065', '107', '郊区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1066', '107', '铜陵县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1067', '108', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1068', '108', '迎江区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1069', '108', '大观区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1070', '108', '宜秀区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1071', '108', '怀宁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1072', '108', '枞阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1073', '108', '潜山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1074', '108', '太湖县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1075', '108', '宿松县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1076', '108', '望江县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1077', '108', '岳西县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1078', '108', '桐城市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1079', '109', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1080', '109', '屯溪区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1081', '109', '黄山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1082', '109', '徽州区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1083', '109', '歙县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1084', '109', '休宁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1085', '109', '黟县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1086', '109', '祁门县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1087', '110', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1088', '110', '琅琊区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1089', '110', '南谯区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1090', '110', '来安县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1091', '110', '全椒县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1092', '110', '定远县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1093', '110', '凤阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1094', '110', '天长市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1095', '110', '明光市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1096', '111', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1097', '111', '颍州区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1098', '111', '颍东区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1099', '111', '颍泉区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1100', '111', '临泉县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1101', '111', '太和县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1102', '111', '阜南县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1103', '111', '颍上县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1104', '111', '界首市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1105', '112', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1106', '112', '埇桥区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1107', '112', '砀山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1108', '112', '萧县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1109', '112', '灵璧县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1110', '112', '泗县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1111', '113', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1112', '113', '金安区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1113', '113', '裕安区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1114', '113', '寿县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1115', '113', '霍邱县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1116', '113', '舒城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1117', '113', '金寨县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1118', '113', '霍山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1119', '114', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1120', '114', '谯城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1121', '114', '涡阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1122', '114', '蒙城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1123', '114', '利辛县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1124', '115', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1125', '115', '贵池区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1126', '115', '东至县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1127', '115', '石台县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1128', '115', '青阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1129', '116', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1130', '116', '宣州区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1131', '116', '郎溪县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1132', '116', '广德县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1133', '116', '泾县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1134', '116', '绩溪县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1135', '116', '旌德县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1136', '116', '宁国市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1137', '117', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1138', '117', '鼓楼区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1139', '117', '台江区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1140', '117', '仓山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1141', '117', '马尾区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1142', '117', '晋安区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1143', '117', '闽侯县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1144', '117', '连江县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1145', '117', '罗源县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1146', '117', '闽清县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1147', '117', '永泰县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1148', '117', '平潭县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1149', '117', '福清市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1150', '117', '长乐市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1151', '118', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1152', '118', '思明区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1153', '118', '海沧区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1154', '118', '湖里区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1155', '118', '集美区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1156', '118', '同安区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1157', '118', '翔安区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1158', '119', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1159', '119', '城厢区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1160', '119', '涵江区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1161', '119', '荔城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1162', '119', '秀屿区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1163', '119', '仙游县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1164', '120', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1165', '120', '梅列区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1166', '120', '三元区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1167', '120', '明溪县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1168', '120', '清流县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1169', '120', '宁化县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1170', '120', '大田县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1171', '120', '尤溪县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1172', '120', '沙县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1173', '120', '将乐县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1174', '120', '泰宁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1175', '120', '建宁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1176', '120', '永安市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1177', '121', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1178', '121', '鲤城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1179', '121', '丰泽区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1180', '121', '洛江区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1181', '121', '泉港区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1182', '121', '惠安县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1183', '121', '安溪县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1184', '121', '永春县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1185', '121', '德化县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1186', '121', '石狮市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1187', '121', '晋江市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1188', '121', '南安市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1189', '122', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1190', '122', '芗城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1191', '122', '龙文区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1192', '122', '云霄县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1193', '122', '漳浦县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1194', '122', '诏安县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1195', '122', '长泰县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1196', '122', '东山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1197', '122', '南靖县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1198', '122', '平和县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1199', '122', '华安县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1200', '122', '龙海市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1201', '123', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1202', '123', '延平区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1203', '123', '顺昌县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1204', '123', '浦城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1205', '123', '光泽县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1206', '123', '松溪县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1207', '123', '政和县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1208', '123', '邵武市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1209', '123', '武夷山市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1210', '123', '建瓯市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1211', '123', '建阳市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1212', '124', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1213', '124', '新罗区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1214', '124', '长汀县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1215', '124', '永定县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1216', '124', '上杭县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1217', '124', '武平县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1218', '124', '连城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1219', '124', '漳平市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1220', '125', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1221', '125', '蕉城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1222', '125', '霞浦县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1223', '125', '古田县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1224', '125', '屏南县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1225', '125', '寿宁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1226', '125', '周宁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1227', '125', '柘荣县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1228', '125', '福安市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1229', '125', '福鼎市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1230', '126', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1231', '126', '东湖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1232', '126', '西湖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1233', '126', '青云谱区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1234', '126', '湾里区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1235', '126', '青山湖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1236', '126', '南昌县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1237', '126', '新建县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1238', '126', '安义县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1239', '126', '进贤县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1240', '127', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1241', '127', '昌江区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1242', '127', '珠山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1243', '127', '浮梁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1244', '127', '乐平市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1245', '128', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1246', '128', '安源区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1247', '128', '湘东区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1248', '128', '莲花县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1249', '128', '上栗县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1250', '128', '芦溪县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1251', '129', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1252', '129', '庐山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1253', '129', '浔阳区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1254', '129', '九江县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1255', '129', '武宁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1256', '129', '修水县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1257', '129', '永修县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1258', '129', '德安县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1259', '129', '星子县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1260', '129', '都昌县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1261', '129', '湖口县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1262', '129', '彭泽县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1263', '129', '瑞昌市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1264', '129', '共青城市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1265', '130', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1266', '130', '渝水区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1267', '130', '分宜县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1268', '131', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1269', '131', '月湖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1270', '131', '余江县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1271', '131', '贵溪市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1272', '132', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1273', '132', '章贡区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1274', '132', '赣县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1275', '132', '信丰县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1276', '132', '大余县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1277', '132', '上犹县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1278', '132', '崇义县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1279', '132', '安远县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1280', '132', '龙南县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1281', '132', '定南县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1282', '132', '全南县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1283', '132', '宁都县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1284', '132', '于都县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1285', '132', '兴国县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1286', '132', '会昌县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1287', '132', '寻乌县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1288', '132', '石城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1289', '132', '瑞金市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1290', '132', '南康市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1291', '133', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1292', '133', '吉州区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1293', '133', '青原区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1294', '133', '吉安县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1295', '133', '吉水县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1296', '133', '峡江县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1297', '133', '新干县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1298', '133', '永丰县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1299', '133', '泰和县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1300', '133', '遂川县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1301', '133', '万安县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1302', '133', '安福县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1303', '133', '永新县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1304', '133', '井冈山市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1305', '134', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1306', '134', '袁州区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1307', '134', '奉新县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1308', '134', '万载县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1309', '134', '上高县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1310', '134', '宜丰县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1311', '134', '靖安县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1312', '134', '铜鼓县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1313', '134', '丰城市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1314', '134', '樟树市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1315', '134', '高安市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1316', '135', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1317', '135', '临川区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1318', '135', '南城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1319', '135', '黎川县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1320', '135', '南丰县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1321', '135', '崇仁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1322', '135', '乐安县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1323', '135', '宜黄县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1324', '135', '金溪县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1325', '135', '资溪县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1326', '135', '东乡县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1327', '135', '广昌县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1328', '136', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1329', '136', '信州区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1330', '136', '上饶县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1331', '136', '广丰县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1332', '136', '玉山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1333', '136', '铅山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1334', '136', '横峰县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1335', '136', '弋阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1336', '136', '余干县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1337', '136', '鄱阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1338', '136', '万年县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1339', '136', '婺源县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1340', '136', '德兴市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1341', '137', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1342', '137', '历下区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1343', '137', '市中区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1344', '137', '槐荫区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1345', '137', '天桥区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1346', '137', '历城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1347', '137', '长清区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1348', '137', '平阴县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1349', '137', '济阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1350', '137', '商河县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1351', '137', '章丘市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1352', '138', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1353', '138', '市南区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1354', '138', '市北区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1355', '138', '四方区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1356', '138', '黄岛区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1357', '138', '崂山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1358', '138', '李沧区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1359', '138', '城阳区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1360', '138', '胶州市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1361', '138', '即墨市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1362', '138', '平度市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1363', '138', '胶南市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1364', '138', '莱西市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1365', '139', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1366', '139', '淄川区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1367', '139', '张店区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1368', '139', '博山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1369', '139', '临淄区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1370', '139', '周村区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1371', '139', '桓台县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1372', '139', '高青县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1373', '139', '沂源县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1374', '140', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1375', '140', '市中区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1376', '140', '薛城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1377', '140', '峄城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1378', '140', '台儿庄区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1379', '140', '山亭区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1380', '140', '滕州市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1381', '141', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1382', '141', '东营区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1383', '141', '河口区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1384', '141', '垦利县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1385', '141', '利津县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1386', '141', '广饶县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1387', '142', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1388', '142', '芝罘区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1389', '142', '福山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1390', '142', '牟平区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1391', '142', '莱山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1392', '142', '长岛县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1393', '142', '龙口市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1394', '142', '莱阳市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1395', '142', '莱州市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1396', '142', '蓬莱市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1397', '142', '招远市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1398', '142', '栖霞市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1399', '142', '海阳市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1400', '143', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1401', '143', '潍城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1402', '143', '寒亭区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1403', '143', '坊子区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1404', '143', '奎文区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1405', '143', '临朐县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1406', '143', '昌乐县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1407', '143', '青州市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1408', '143', '诸城市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1409', '143', '寿光市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1410', '143', '安丘市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1411', '143', '高密市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1412', '143', '昌邑市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1413', '144', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1414', '144', '市中区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1415', '144', '任城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1416', '144', '微山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1417', '144', '鱼台县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1418', '144', '金乡县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1419', '144', '嘉祥县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1420', '144', '汶上县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1421', '144', '泗水县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1422', '144', '梁山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1423', '144', '曲阜市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1424', '144', '兖州市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1425', '144', '邹城市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1426', '145', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1427', '145', '泰山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1428', '145', '岱岳区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1429', '145', '宁阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1430', '145', '东平县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1431', '145', '新泰市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1432', '145', '肥城市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1433', '146', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1434', '146', '环翠区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1435', '146', '文登市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1436', '146', '荣成市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1437', '146', '乳山市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1438', '147', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1439', '147', '东港区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1440', '147', '岚山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1441', '147', '五莲县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1442', '147', '莒县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1443', '148', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1444', '148', '莱城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1445', '148', '钢城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1446', '149', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1447', '149', '兰山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1448', '149', '罗庄区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1449', '149', '河东区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1450', '149', '沂南县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1451', '149', '郯城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1452', '149', '沂水县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1453', '149', '苍山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1454', '149', '费县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1455', '149', '平邑县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1456', '149', '莒南县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1457', '149', '蒙阴县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1458', '149', '临沭县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1459', '150', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1460', '150', '德城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1461', '150', '陵县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1462', '150', '宁津县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1463', '150', '庆云县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1464', '150', '临邑县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1465', '150', '齐河县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1466', '150', '平原县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1467', '150', '夏津县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1468', '150', '武城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1469', '150', '乐陵市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1470', '150', '禹城市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1471', '151', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1472', '151', '东昌府区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1473', '151', '阳谷县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1474', '151', '莘县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1475', '151', '茌平县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1476', '151', '东阿县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1477', '151', '冠县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1478', '151', '高唐县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1479', '151', '临清市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1480', '152', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1481', '152', '滨城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1482', '152', '惠民县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1483', '152', '阳信县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1484', '152', '无棣县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1485', '152', '沾化县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1486', '152', '博兴县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1487', '152', '邹平县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1488', '153', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1489', '153', '牡丹区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1490', '153', '曹县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1491', '153', '单县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1492', '153', '成武县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1493', '153', '巨野县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1494', '153', '郓城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1495', '153', '鄄城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1496', '153', '定陶县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1497', '153', '东明县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1498', '154', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1499', '154', '中原区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1500', '154', '二七区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1501', '154', '管城回族区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1502', '154', '金水区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1503', '154', '上街区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1504', '154', '惠济区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1505', '154', '中牟县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1506', '154', '巩义市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1507', '154', '荥阳市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1508', '154', '新密市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1509', '154', '新郑市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1510', '154', '登封市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1511', '155', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1512', '155', '龙亭区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1513', '155', '顺河回族区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1514', '155', '鼓楼区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1515', '155', '禹王台区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1516', '155', '金明区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1517', '155', '杞县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1518', '155', '通许县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1519', '155', '尉氏县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1520', '155', '开封县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1521', '155', '兰考县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1522', '156', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1523', '156', '老城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1524', '156', '西工区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1525', '156', '瀍河回族区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1526', '156', '涧西区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1527', '156', '吉利区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1528', '156', '洛龙区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1529', '156', '孟津县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1530', '156', '新安县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1531', '156', '栾川县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1532', '156', '嵩县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1533', '156', '汝阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1534', '156', '宜阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1535', '156', '洛宁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1536', '156', '伊川县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1537', '156', '偃师市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1538', '157', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1539', '157', '新华区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1540', '157', '卫东区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1541', '157', '石龙区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1542', '157', '湛河区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1543', '157', '宝丰县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1544', '157', '叶县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1545', '157', '鲁山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1546', '157', '郏县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1547', '157', '舞钢市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1548', '157', '汝州市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1549', '158', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1550', '158', '文峰区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1551', '158', '北关区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1552', '158', '殷都区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1553', '158', '龙安区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1554', '158', '安阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1555', '158', '汤阴县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1556', '158', '滑县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1557', '158', '内黄县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1558', '158', '林州市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1559', '159', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1560', '159', '鹤山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1561', '159', '山城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1562', '159', '淇滨区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1563', '159', '浚县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1564', '159', '淇县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1565', '160', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1566', '160', '红旗区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1567', '160', '卫滨区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1568', '160', '凤泉区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1569', '160', '牧野区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1570', '160', '新乡县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1571', '160', '获嘉县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1572', '160', '原阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1573', '160', '延津县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1574', '160', '封丘县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1575', '160', '长垣县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1576', '160', '卫辉市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1577', '160', '辉县市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1578', '161', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1579', '161', '解放区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1580', '161', '中站区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1581', '161', '马村区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1582', '161', '山阳区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1583', '161', '修武县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1584', '161', '博爱县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1585', '161', '武陟县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1586', '161', '温县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1587', '161', '沁阳市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1588', '161', '孟州市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1589', '162', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1590', '162', '华龙区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1591', '162', '清丰县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1592', '162', '南乐县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1593', '162', '范县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1594', '162', '台前县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1595', '162', '濮阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1596', '163', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1597', '163', '魏都区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1598', '163', '许昌县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1599', '163', '鄢陵县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1600', '163', '襄城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1601', '163', '禹州市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1602', '163', '长葛市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1603', '164', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1604', '164', '源汇区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1605', '164', '郾城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1606', '164', '召陵区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1607', '164', '舞阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1608', '164', '临颍县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1609', '165', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1610', '165', '湖滨区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1611', '165', '渑池县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1612', '165', '陕县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1613', '165', '卢氏县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1614', '165', '义马市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1615', '165', '灵宝市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1616', '166', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1617', '166', '宛城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1618', '166', '卧龙区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1619', '166', '南召县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1620', '166', '方城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1621', '166', '西峡县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1622', '166', '镇平县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1623', '166', '内乡县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1624', '166', '淅川县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1625', '166', '社旗县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1626', '166', '唐河县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1627', '166', '新野县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1628', '166', '桐柏县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1629', '166', '邓州市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1630', '167', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1631', '167', '梁园区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1632', '167', '睢阳区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1633', '167', '民权县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1634', '167', '睢县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1635', '167', '宁陵县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1636', '167', '柘城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1637', '167', '虞城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1638', '167', '夏邑县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1639', '167', '永城市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1640', '168', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1641', '168', '浉河区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1642', '168', '平桥区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1643', '168', '罗山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1644', '168', '光山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1645', '168', '新县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1646', '168', '商城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1647', '168', '固始县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1648', '168', '潢川县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1649', '168', '淮滨县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1650', '168', '息县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1651', '169', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1652', '169', '川汇区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1653', '169', '扶沟县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1654', '169', '西华县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1655', '169', '商水县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1656', '169', '沈丘县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1657', '169', '郸城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1658', '169', '淮阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1659', '169', '太康县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1660', '169', '鹿邑县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1661', '169', '项城市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1662', '170', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1663', '170', '驿城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1664', '170', '西平县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1665', '170', '上蔡县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1666', '170', '平舆县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1667', '170', '正阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1668', '170', '确山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1669', '170', '泌阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1670', '170', '汝南县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1671', '170', '遂平县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1672', '170', '新蔡县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1673', '171', '济源市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1674', '172', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1675', '172', '江岸区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1676', '172', '江汉区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1677', '172', '硚口区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1678', '172', '汉阳区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1679', '172', '武昌区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1680', '172', '青山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1681', '172', '洪山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1682', '172', '东西湖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1683', '172', '汉南区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1684', '172', '蔡甸区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1685', '172', '江夏区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1686', '172', '黄陂区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1687', '172', '新洲区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1688', '173', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1689', '173', '黄石港区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1690', '173', '西塞山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1691', '173', '下陆区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1692', '173', '铁山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1693', '173', '阳新县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1694', '173', '大冶市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1695', '174', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1696', '174', '茅箭区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1697', '174', '张湾区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1698', '174', '郧县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1699', '174', '郧西县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1700', '174', '竹山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1701', '174', '竹溪县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1702', '174', '房县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1703', '174', '丹江口市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1704', '175', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1705', '175', '西陵区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1706', '175', '伍家岗区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1707', '175', '点军区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1708', '175', '猇亭区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1709', '175', '夷陵区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1710', '175', '远安县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1711', '175', '兴山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1712', '175', '秭归县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1713', '175', '长阳土家族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1714', '175', '五峰土家族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1715', '175', '宜都市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1716', '175', '当阳市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1717', '175', '枝江市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1718', '176', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1719', '176', '襄城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1720', '176', '樊城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1721', '176', '襄州区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1722', '176', '南漳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1723', '176', '谷城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1724', '176', '保康县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1725', '176', '老河口市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1726', '176', '枣阳市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1727', '176', '宜城市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1728', '177', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1729', '177', '梁子湖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1730', '177', '华容区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1731', '177', '鄂城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1732', '178', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1733', '178', '东宝区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1734', '178', '掇刀区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1735', '178', '京山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1736', '178', '沙洋县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1737', '178', '钟祥市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1738', '179', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1739', '179', '孝南区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1740', '179', '孝昌县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1741', '179', '大悟县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1742', '179', '云梦县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1743', '179', '应城市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1744', '179', '安陆市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1745', '179', '汉川市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1746', '180', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1747', '180', '沙市区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1748', '180', '荆州区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1749', '180', '公安县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1750', '180', '监利县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1751', '180', '江陵县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1752', '180', '石首市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1753', '180', '洪湖市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1754', '180', '松滋市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1755', '181', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1756', '181', '黄州区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1757', '181', '团风县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1758', '181', '红安县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1759', '181', '罗田县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1760', '181', '英山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1761', '181', '浠水县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1762', '181', '蕲春县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1763', '181', '黄梅县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1764', '181', '麻城市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1765', '181', '武穴市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1766', '182', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1767', '182', '咸安区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1768', '182', '嘉鱼县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1769', '182', '通城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1770', '182', '崇阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1771', '182', '通山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1772', '182', '赤壁市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1773', '183', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1774', '183', '曾都区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1775', '183', '随县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1776', '183', '广水市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1777', '184', '恩施市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1778', '184', '利川市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1779', '184', '建始县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1780', '184', '巴东县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1781', '184', '宣恩县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1782', '184', '咸丰县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1783', '184', '来凤县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1784', '184', '鹤峰县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1785', '185', '仙桃市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1786', '185', '潜江市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1787', '185', '天门市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1788', '185', '神农架林区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1789', '186', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1790', '186', '芙蓉区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1791', '186', '天心区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1792', '186', '岳麓区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1793', '186', '开福区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1794', '186', '雨花区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1795', '186', '望城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1796', '186', '长沙县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1797', '186', '宁乡县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1798', '186', '浏阳市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1799', '187', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1800', '187', '荷塘区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1801', '187', '芦淞区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1802', '187', '石峰区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1803', '187', '天元区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1804', '187', '株洲县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1805', '187', '攸县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1806', '187', '茶陵县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1807', '187', '炎陵县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1808', '187', '醴陵市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1809', '188', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1810', '188', '雨湖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1811', '188', '岳塘区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1812', '188', '湘潭县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1813', '188', '湘乡市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1814', '188', '韶山市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1815', '189', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1816', '189', '珠晖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1817', '189', '雁峰区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1818', '189', '石鼓区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1819', '189', '蒸湘区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1820', '189', '南岳区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1821', '189', '衡阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1822', '189', '衡南县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1823', '189', '衡山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1824', '189', '衡东县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1825', '189', '祁东县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1826', '189', '耒阳市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1827', '189', '常宁市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1828', '190', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1829', '190', '双清区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1830', '190', '大祥区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1831', '190', '北塔区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1832', '190', '邵东县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1833', '190', '新邵县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1834', '190', '邵阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1835', '190', '隆回县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1836', '190', '洞口县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1837', '190', '绥宁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1838', '190', '新宁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1839', '190', '城步苗族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1840', '190', '武冈市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1841', '191', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1842', '191', '岳阳楼区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1843', '191', '云溪区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1844', '191', '君山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1845', '191', '岳阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1846', '191', '华容县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1847', '191', '湘阴县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1848', '191', '平江县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1849', '191', '汨罗市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1850', '191', '临湘市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1851', '192', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1852', '192', '武陵区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1853', '192', '鼎城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1854', '192', '安乡县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1855', '192', '汉寿县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1856', '192', '澧县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1857', '192', '临澧县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1858', '192', '桃源县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1859', '192', '石门县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1860', '192', '津市市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1861', '193', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1862', '193', '永定区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1863', '193', '武陵源区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1864', '193', '慈利县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1865', '193', '桑植县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1866', '194', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1867', '194', '资阳区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1868', '194', '赫山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1869', '194', '南县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1870', '194', '桃江县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1871', '194', '安化县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1872', '194', '沅江市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1873', '195', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1874', '195', '北湖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1875', '195', '苏仙区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1876', '195', '桂阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1877', '195', '宜章县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1878', '195', '永兴县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1879', '195', '嘉禾县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1880', '195', '临武县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1881', '195', '汝城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1882', '195', '桂东县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1883', '195', '安仁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1884', '195', '资兴市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1885', '196', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1886', '196', '零陵区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1887', '196', '冷水滩区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1888', '196', '祁阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1889', '196', '东安县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1890', '196', '双牌县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1891', '196', '道县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1892', '196', '江永县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1893', '196', '宁远县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1894', '196', '蓝山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1895', '196', '新田县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1896', '196', '江华瑶族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1897', '197', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1898', '197', '鹤城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1899', '197', '中方县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1900', '197', '沅陵县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1901', '197', '辰溪县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1902', '197', '溆浦县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1903', '197', '会同县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1904', '197', '麻阳苗族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1905', '197', '新晃侗族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1906', '197', '芷江侗族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1907', '197', '靖州苗族侗族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1908', '197', '通道侗族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1909', '197', '洪江市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1910', '198', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1911', '198', '娄星区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1912', '198', '双峰县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1913', '198', '新化县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1914', '198', '冷水江市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1915', '198', '涟源市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1916', '199', '吉首市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1917', '199', '泸溪县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1918', '199', '凤凰县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1919', '199', '花垣县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1920', '199', '保靖县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1921', '199', '古丈县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1922', '199', '永顺县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1923', '199', '龙山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1924', '200', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1925', '200', '荔湾区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1926', '200', '越秀区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1927', '200', '海珠区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1928', '200', '天河区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1929', '200', '白云区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1930', '200', '黄埔区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1931', '200', '番禺区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1932', '200', '花都区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1933', '200', '南沙区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1934', '200', '萝岗区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1935', '200', '增城市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1936', '200', '从化市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1937', '201', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1938', '201', '武江区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1939', '201', '浈江区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1940', '201', '曲江区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1941', '201', '始兴县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1942', '201', '仁化县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1943', '201', '翁源县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1944', '201', '乳源瑶族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1945', '201', '新丰县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1946', '201', '乐昌市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1947', '201', '南雄市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1948', '202', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1949', '202', '罗湖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1950', '202', '福田区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1951', '202', '南山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1952', '202', '宝安区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1953', '202', '龙岗区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1954', '202', '盐田区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1955', '203', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1956', '203', '香洲区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1957', '203', '斗门区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1958', '203', '金湾区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1959', '204', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1960', '204', '龙湖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1961', '204', '金平区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1962', '204', '濠江区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1963', '204', '潮阳区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1964', '204', '潮南区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1965', '204', '澄海区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1966', '204', '南澳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1967', '205', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1968', '205', '禅城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1969', '205', '南海区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1970', '205', '顺德区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1971', '205', '三水区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1972', '205', '高明区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1973', '206', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1974', '206', '蓬江区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1975', '206', '江海区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1976', '206', '新会区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1977', '206', '台山市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1978', '206', '开平市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1979', '206', '鹤山市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1980', '206', '恩平市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1981', '207', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1982', '207', '赤坎区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1983', '207', '霞山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1984', '207', '坡头区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1985', '207', '麻章区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1986', '207', '遂溪县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1987', '207', '徐闻县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1988', '207', '廉江市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1989', '207', '雷州市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1990', '207', '吴川市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1991', '208', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1992', '208', '茂南区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1993', '208', '茂港区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1994', '208', '电白县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1995', '208', '高州市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1996', '208', '化州市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1997', '208', '信宜市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1998', '209', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('1999', '209', '端州区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2000', '209', '鼎湖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2001', '209', '广宁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2002', '209', '怀集县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2003', '209', '封开县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2004', '209', '德庆县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2005', '209', '高要市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2006', '209', '四会市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2007', '210', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2008', '210', '惠城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2009', '210', '惠阳区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2010', '210', '博罗县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2011', '210', '惠东县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2012', '210', '龙门县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2013', '211', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2014', '211', '梅江区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2015', '211', '梅县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2016', '211', '大埔县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2017', '211', '丰顺县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2018', '211', '五华县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2019', '211', '平远县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2020', '211', '蕉岭县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2021', '211', '兴宁市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2022', '212', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2023', '212', '城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2024', '212', '海丰县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2025', '212', '陆河县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2026', '212', '陆丰市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2027', '213', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2028', '213', '源城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2029', '213', '紫金县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2030', '213', '龙川县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2031', '213', '连平县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2032', '213', '和平县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2033', '213', '东源县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2034', '214', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2035', '214', '江城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2036', '214', '阳西县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2037', '214', '阳东县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2038', '214', '阳春市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2039', '215', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2040', '215', '清城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2041', '215', '佛冈县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2042', '215', '阳山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2043', '215', '连山壮族瑶族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2044', '215', '连南瑶族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2045', '215', '清新县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2046', '215', '英德市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2047', '215', '连州市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2048', '216', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2049', '216', '湘桥区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2050', '216', '潮安县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2051', '216', '饶平县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2052', '217', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2053', '217', '榕城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2054', '217', '揭东县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2055', '217', '揭西县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2056', '217', '惠来县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2057', '217', '普宁市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2058', '218', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2059', '218', '云城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2060', '218', '新兴县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2061', '218', '郁南县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2062', '218', '云安县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2063', '218', '罗定市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2064', '219', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2065', '219', '兴宁区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2066', '219', '青秀区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2067', '219', '江南区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2068', '219', '西乡塘区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2069', '219', '良庆区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2070', '219', '邕宁区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2071', '219', '武鸣县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2072', '219', '隆安县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2073', '219', '马山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2074', '219', '上林县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2075', '219', '宾阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2076', '219', '横县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2077', '220', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2078', '220', '城中区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2079', '220', '鱼峰区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2080', '220', '柳南区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2081', '220', '柳北区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2082', '220', '柳江县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2083', '220', '柳城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2084', '220', '鹿寨县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2085', '220', '融安县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2086', '220', '融水苗族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2087', '220', '三江侗族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2088', '221', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2089', '221', '秀峰区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2090', '221', '叠彩区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2091', '221', '象山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2092', '221', '七星区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2093', '221', '雁山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2094', '221', '阳朔县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2095', '221', '临桂县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2096', '221', '灵川县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2097', '221', '全州县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2098', '221', '兴安县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2099', '221', '永福县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2100', '221', '灌阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2101', '221', '龙胜各族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2102', '221', '资源县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2103', '221', '平乐县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2104', '221', '荔蒲县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2105', '221', '恭城瑶族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2106', '222', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2107', '222', '万秀区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2108', '222', '蝶山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2109', '222', '长洲区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2110', '222', '苍梧县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2111', '222', '藤县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2112', '222', '蒙山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2113', '222', '岑溪市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2114', '223', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2115', '223', '海城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2116', '223', '银海区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2117', '223', '铁山港区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2118', '223', '合浦县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2119', '224', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2120', '224', '港口区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2121', '224', '防城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2122', '224', '上思县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2123', '224', '东兴市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2124', '225', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2125', '225', '钦南区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2126', '225', '钦北区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2127', '225', '灵山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2128', '225', '浦北县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2129', '226', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2130', '226', '港北区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2131', '226', '港南区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2132', '226', '覃塘区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2133', '226', '平南县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2134', '226', '桂平市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2135', '227', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2136', '227', '玉州区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2137', '227', '容县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2138', '227', '陆川县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2139', '227', '博白县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2140', '227', '兴业县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2141', '227', '北流市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2142', '228', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2143', '228', '右江区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2144', '228', '田阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2145', '228', '田东县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2146', '228', '平果县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2147', '228', '德保县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2148', '228', '靖西县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2149', '228', '那坡县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2150', '228', '凌云县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2151', '228', '乐业县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2152', '228', '田林县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2153', '228', '西林县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2154', '228', '隆林各族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2155', '229', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2156', '229', '八步区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2157', '229', '平桂管理区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2158', '229', '昭平县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2159', '229', '钟山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2160', '229', '富川瑶族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2161', '230', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2162', '230', '金城江区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2163', '230', '南丹县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2164', '230', '天峨县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2165', '230', '凤山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2166', '230', '东兰县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2167', '230', '罗城仫佬族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2168', '230', '环江毛南族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2169', '230', '巴马瑶族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2170', '230', '都安瑶族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2171', '230', '大化瑶族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2172', '230', '宜州市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2173', '231', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2174', '231', '兴宾区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2175', '231', '忻城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2176', '231', '象州县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2177', '231', '武宣县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2178', '231', '金秀瑶族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2179', '231', '合山市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2180', '232', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2181', '232', '江洲区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2182', '232', '扶绥县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2183', '232', '宁明县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2184', '232', '龙州县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2185', '232', '大新县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2186', '232', '天等县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2187', '232', '凭祥市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2188', '233', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2189', '233', '秀英区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2190', '233', '龙华区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2191', '233', '琼山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2192', '233', '美兰区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2193', '234', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2194', '235', '五指山市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2195', '235', '琼海市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2196', '235', '儋州市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2197', '235', '文昌市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2198', '235', '万宁市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2199', '235', '东方市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2200', '235', '定安县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2201', '235', '屯昌县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2202', '235', '澄迈县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2203', '235', '临高县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2204', '235', '白沙黎族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2205', '235', '昌江黎族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2206', '235', '乐东黎族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2207', '235', '陵水黎族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2208', '235', '保亭黎族苗族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2209', '235', '琼中黎族苗族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2210', '235', '西沙群岛', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2211', '235', '南沙群岛', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2212', '235', '中沙群岛的岛礁及其海域', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2213', '236', '万州区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2214', '236', '涪陵区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2215', '236', '渝中区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2216', '236', '大渡口区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2217', '236', '江北区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2218', '236', '沙坪坝区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2219', '236', '九龙坡区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2220', '236', '南岸区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2221', '236', '北碚区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2222', '236', '綦江区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2223', '236', '大足区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2224', '236', '渝北区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2225', '236', '巴南区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2226', '236', '黔江区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2227', '236', '长寿区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2228', '236', '江津区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2229', '236', '合川区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2230', '236', '永川区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2231', '236', '南川区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2232', '237', '潼南县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2233', '237', '铜梁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2234', '237', '荣昌县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2235', '237', '璧山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2236', '237', '梁平县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2237', '237', '城口县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2238', '237', '丰都县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2239', '237', '垫江县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2240', '237', '武隆县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2241', '237', '忠县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2242', '237', '开县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2243', '237', '云阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2244', '237', '奉节县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2245', '237', '巫山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2246', '237', '巫溪县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2247', '237', '石柱土家族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2248', '237', '秀山土家族苗族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2249', '237', '酉阳土家族苗族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2250', '237', '彭水苗族土家族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2251', '238', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2252', '238', '锦江区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2253', '238', '青羊区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2254', '238', '金牛区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2255', '238', '武侯区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2256', '238', '成华区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2257', '238', '龙泉驿区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2258', '238', '青白江区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2259', '238', '新都区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2260', '238', '温江区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2261', '238', '金堂县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2262', '238', '双流县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2263', '238', '郫县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2264', '238', '大邑县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2265', '238', '蒲江县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2266', '238', '新津县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2267', '238', '都江堰市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2268', '238', '彭州市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2269', '238', '邛崃市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2270', '238', '崇州市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2271', '239', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2272', '239', '自流井区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2273', '239', '贡井区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2274', '239', '大安区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2275', '239', '沿滩区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2276', '239', '荣县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2277', '239', '富顺县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2278', '240', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2279', '240', '东区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2280', '240', '西区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2281', '240', '仁和区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2282', '240', '米易县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2283', '240', '盐边县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2284', '241', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2285', '241', '江阳区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2286', '241', '纳溪区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2287', '241', '龙马潭区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2288', '241', '泸县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2289', '241', '合江县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2290', '241', '叙永县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2291', '241', '古蔺县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2292', '242', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2293', '242', '旌阳区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2294', '242', '中江县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2295', '242', '罗江县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2296', '242', '广汉市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2297', '242', '什邡市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2298', '242', '绵竹市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2299', '243', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2300', '243', '涪城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2301', '243', '游仙区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2302', '243', '三台县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2303', '243', '盐亭县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2304', '243', '安县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2305', '243', '梓潼县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2306', '243', '北川羌族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2307', '243', '平武县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2308', '243', '江油市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2309', '244', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2310', '244', '利州区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2311', '244', '元坝区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2312', '244', '朝天区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2313', '244', '旺苍县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2314', '244', '青川县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2315', '244', '剑阁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2316', '244', '苍溪县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2317', '245', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2318', '245', '船山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2319', '245', '安居区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2320', '245', '蓬溪县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2321', '245', '射洪县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2322', '245', '大英县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2323', '246', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2324', '246', '市中区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2325', '246', '东兴区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2326', '246', '威远县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2327', '246', '资中县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2328', '246', '隆昌县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2329', '247', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2330', '247', '市中区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2331', '247', '沙湾区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2332', '247', '五通桥区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2333', '247', '金口河区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2334', '247', '犍为县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2335', '247', '井研县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2336', '247', '夹江县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2337', '247', '沐川县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2338', '247', '峨边彝族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2339', '247', '马边彝族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2340', '247', '峨眉山市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2341', '248', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2342', '248', '顺庆区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2343', '248', '高坪区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2344', '248', '嘉陵区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2345', '248', '南部县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2346', '248', '营山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2347', '248', '蓬安县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2348', '248', '仪陇县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2349', '248', '西充县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2350', '248', '阆中市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2351', '249', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2352', '249', '东坡区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2353', '249', '仁寿县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2354', '249', '彭山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2355', '249', '洪雅县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2356', '249', '丹棱县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2357', '249', '青神县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2358', '250', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2359', '250', '翠屏区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2360', '250', '南溪区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2361', '250', '宜宾县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2362', '250', '江安县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2363', '250', '长宁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2364', '250', '高县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2365', '250', '珙县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2366', '250', '筠连县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2367', '250', '兴文县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2368', '250', '屏山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2369', '251', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2370', '251', '广安区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2371', '251', '岳池县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2372', '251', '武胜县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2373', '251', '邻水县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2374', '251', '华蓥市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2375', '252', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2376', '252', '通川区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2377', '252', '达县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2378', '252', '宣汉县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2379', '252', '开江县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2380', '252', '大竹县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2381', '252', '渠县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2382', '252', '万源市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2383', '253', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2384', '253', '雨城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2385', '253', '荥经县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2386', '253', '汉源县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2387', '253', '石棉县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2388', '253', '天全县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2389', '253', '芦山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2390', '253', '宝兴县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2391', '253', '名山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2392', '254', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2393', '254', '巴州区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2394', '254', '通江县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2395', '254', '南江县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2396', '254', '平昌县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2397', '255', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2398', '255', '雁江区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2399', '255', '安岳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2400', '255', '乐至县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2401', '255', '简阳市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2402', '256', '汶川县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2403', '256', '理县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2404', '256', '茂县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2405', '256', '松潘县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2406', '256', '九寨沟县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2407', '256', '金川县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2408', '256', '小金县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2409', '256', '黑水县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2410', '256', '马尔康县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2411', '256', '壤塘县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2412', '256', '阿坝县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2413', '256', '若尔盖县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2414', '256', '红原县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2415', '257', '康定县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2416', '257', '泸定县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2417', '257', '丹巴县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2418', '257', '九龙县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2419', '257', '雅江县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2420', '257', '道孚县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2421', '257', '炉霍县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2422', '257', '甘孜县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2423', '257', '新龙县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2424', '257', '德格县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2425', '257', '白玉县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2426', '257', '石渠县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2427', '257', '色达县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2428', '257', '理塘县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2429', '257', '巴塘县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2430', '257', '乡城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2431', '257', '稻城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2432', '257', '得荣县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2433', '258', '西昌市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2434', '258', '木里藏族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2435', '258', '盐源县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2436', '258', '德昌县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2437', '258', '会理县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2438', '258', '会东县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2439', '258', '宁南县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2440', '258', '普格县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2441', '258', '布拖县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2442', '258', '金阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2443', '258', '昭觉县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2444', '258', '喜德县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2445', '258', '冕宁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2446', '258', '越西县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2447', '258', '甘洛县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2448', '258', '美姑县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2449', '258', '雷波县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2450', '259', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2451', '259', '南明区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2452', '259', '云岩区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2453', '259', '花溪区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2454', '259', '乌当区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2455', '259', '白云区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2456', '259', '小河区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2457', '259', '开阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2458', '259', '息烽县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2459', '259', '修文县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2460', '259', '清镇市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2461', '260', '钟山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2462', '260', '六枝特区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2463', '260', '水城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2464', '260', '盘县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2465', '261', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2466', '261', '红花岗区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2467', '261', '汇川区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2468', '261', '遵义县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2469', '261', '桐梓县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2470', '261', '绥阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2471', '261', '正安县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2472', '261', '道真仡佬族苗族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2473', '261', '务川仡佬族苗族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2474', '261', '凤冈县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2475', '261', '湄潭县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2476', '261', '余庆县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2477', '261', '习水县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2478', '261', '赤水市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2479', '261', '仁怀市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2480', '262', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2481', '262', '西秀区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2482', '262', '平坝县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2483', '262', '普定县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2484', '262', '镇宁布依族苗族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2485', '262', '关岭布依族苗族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2486', '262', '紫云苗族布依族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2487', '263', '七星关区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2488', '263', '大方县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2489', '263', '黔西县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2490', '263', '金沙县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2491', '263', '织金县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2492', '263', '纳雍县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2493', '263', '威宁彝族回族苗族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2494', '263', '赫章县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2495', '264', '碧江区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2496', '264', '万山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2497', '264', '江口县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2498', '264', '玉屏侗族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2499', '264', '石阡县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2500', '264', '思南县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2501', '264', '印江土家族苗族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2502', '264', '德江县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2503', '264', '沿河土家族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2504', '264', '松桃苗族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2505', '265', '兴义市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2506', '265', '兴仁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2507', '265', '普安县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2508', '265', '晴隆县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2509', '265', '贞丰县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2510', '265', '望谟县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2511', '265', '册亨县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2512', '265', '安龙县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2513', '266', '凯里市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2514', '266', '黄平县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2515', '266', '施秉县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2516', '266', '三穗县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2517', '266', '镇远县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2518', '266', '岑巩县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2519', '266', '天柱县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2520', '266', '锦屏县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2521', '266', '剑河县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2522', '266', '台江县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2523', '266', '黎平县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2524', '266', '榕江县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2525', '266', '从江县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2526', '266', '雷山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2527', '266', '麻江县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2528', '266', '丹寨县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2529', '267', '都匀市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2530', '267', '福泉市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2531', '267', '荔波县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2532', '267', '贵定县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2533', '267', '瓮安县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2534', '267', '独山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2535', '267', '平塘县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2536', '267', '罗甸县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2537', '267', '长顺县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2538', '267', '龙里县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2539', '267', '惠水县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2540', '267', '三都水族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2541', '268', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2542', '268', '五华区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2543', '268', '盘龙区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2544', '268', '官渡区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2545', '268', '西山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2546', '268', '东川区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2547', '268', '呈贡区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2548', '268', '晋宁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2549', '268', '富民县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2550', '268', '宜良县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2551', '268', '石林彝族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2552', '268', '嵩明县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2553', '268', '禄劝彝族苗族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2554', '268', '寻甸回族彝族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2555', '268', '安宁市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2556', '269', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2557', '269', '麒麟区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2558', '269', '马龙县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2559', '269', '陆良县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2560', '269', '师宗县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2561', '269', '罗平县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2562', '269', '富源县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2563', '269', '会泽县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2564', '269', '沾益县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2565', '269', '宣威市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2566', '270', '红塔区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2567', '270', '江川县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2568', '270', '澄江县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2569', '270', '通海县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2570', '270', '华宁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2571', '270', '易门县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2572', '270', '峨山彝族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2573', '270', '新平彝族傣族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2574', '270', '元江哈尼族彝族傣族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2575', '271', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2576', '271', '隆阳区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2577', '271', '施甸县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2578', '271', '腾冲县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2579', '271', '龙陵县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2580', '271', '昌宁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2581', '272', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2582', '272', '昭阳区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2583', '272', '鲁甸县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2584', '272', '巧家县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2585', '272', '盐津县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2586', '272', '大关县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2587', '272', '永善县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2588', '272', '绥江县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2589', '272', '镇雄县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2590', '272', '彝良县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2591', '272', '威信县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2592', '272', '水富县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2593', '273', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2594', '273', '古城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2595', '273', '玉龙纳西族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2596', '273', '永胜县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2597', '273', '华坪县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2598', '273', '宁蒗彝族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2599', '274', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2600', '274', '思茅区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2601', '274', '宁洱哈尼族彝族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2602', '274', '墨江哈尼族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2603', '274', '景东彝族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2604', '274', '景谷傣族彝族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2605', '274', '镇沅彝族哈尼族拉祜族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2606', '274', '江城哈尼族彝族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2607', '274', '孟连傣族拉祜族佤族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2608', '274', '澜沧拉祜族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2609', '274', '西盟佤族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2610', '275', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2611', '275', '临翔区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2612', '275', '凤庆县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2613', '275', '云县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2614', '275', '永德县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2615', '275', '镇康县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2616', '275', '双江拉祜族佤族布朗族傣族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2617', '275', '耿马傣族佤族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2618', '275', '沧源佤族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2619', '276', '楚雄市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2620', '276', '双柏县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2621', '276', '牟定县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2622', '276', '南华县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2623', '276', '姚安县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2624', '276', '大姚县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2625', '276', '永仁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2626', '276', '元谋县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2627', '276', '武定县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2628', '276', '禄丰县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2629', '277', '个旧市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2630', '277', '开远市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2631', '277', '蒙自市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2632', '277', '屏边苗族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2633', '277', '建水县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2634', '277', '石屏县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2635', '277', '弥勒县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2636', '277', '泸西县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2637', '277', '元阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2638', '277', '红河县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2639', '277', '金平苗族瑶族傣族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2640', '277', '绿春县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2641', '277', '河口瑶族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2642', '278', '文山市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2643', '278', '砚山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2644', '278', '西畴县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2645', '278', '麻栗坡县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2646', '278', '马关县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2647', '278', '丘北县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2648', '278', '广南县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2649', '278', '富宁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2650', '279', '景洪市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2651', '279', '勐海县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2652', '279', '勐腊县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2653', '280', '大理市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2654', '280', '漾濞彝族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2655', '280', '祥云县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2656', '280', '宾川县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2657', '280', '弥渡县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2658', '280', '南涧彝族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2659', '280', '巍山彝族回族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2660', '280', '永平县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2661', '280', '云龙县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2662', '280', '洱源县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2663', '280', '剑川县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2664', '280', '鹤庆县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2665', '281', '瑞丽市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2666', '281', '芒市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2667', '281', '梁河县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2668', '281', '盈江县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2669', '281', '陇川县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2670', '282', '泸水县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2671', '282', '福贡县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2672', '282', '贡山独龙族怒族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2673', '282', '兰坪白族普米族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2674', '283', '香格里拉县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2675', '283', '德钦县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2676', '283', '维西傈僳族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2677', '284', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2678', '284', '城关区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2679', '284', '林周县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2680', '284', '当雄县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2681', '284', '尼木县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2682', '284', '曲水县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2683', '284', '堆龙德庆县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2684', '284', '达孜县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2685', '284', '墨竹工卡县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2686', '285', '昌都县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2687', '285', '江达县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2688', '285', '贡觉县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2689', '285', '类乌齐县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2690', '285', '丁青县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2691', '285', '察雅县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2692', '285', '八宿县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2693', '285', '左贡县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2694', '285', '芒康县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2695', '285', '洛隆县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2696', '285', '边坝县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2697', '286', '乃东县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2698', '286', '扎囊县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2699', '286', '贡嘎县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2700', '286', '桑日县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2701', '286', '琼结县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2702', '286', '曲松县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2703', '286', '措美县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2704', '286', '洛扎县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2705', '286', '加查县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2706', '286', '隆子县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2707', '286', '错那县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2708', '286', '浪卡子县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2709', '287', '日喀则市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2710', '287', '南木林县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2711', '287', '江孜县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2712', '287', '定日县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2713', '287', '萨迦县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2714', '287', '拉孜县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2715', '287', '昂仁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2716', '287', '谢通门县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2717', '287', '白朗县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2718', '287', '仁布县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2719', '287', '康马县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2720', '287', '定结县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2721', '287', '仲巴县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2722', '287', '亚东县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2723', '287', '吉隆县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2724', '287', '聂拉木县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2725', '287', '萨嘎县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2726', '287', '岗巴县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2727', '288', '那曲县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2728', '288', '嘉黎县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2729', '288', '比如县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2730', '288', '聂荣县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2731', '288', '安多县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2732', '288', '申扎县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2733', '288', '索县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2734', '288', '班戈县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2735', '288', '巴青县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2736', '288', '尼玛县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2737', '289', '普兰县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2738', '289', '札达县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2739', '289', '噶尔县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2740', '289', '革吉县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2741', '289', '改则县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2742', '289', '措勤县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2743', '289', '日土县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2744', '290', '林芝县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2745', '290', '工布江达县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2746', '290', '米林县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2747', '290', '墨脱县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2748', '290', '波密县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2749', '290', '察隅县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2750', '290', '朗县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2751', '291', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2752', '291', '新城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2753', '291', '碑林区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2754', '291', '莲湖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2755', '291', '灞桥区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2756', '291', '未央区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2757', '291', '雁塔区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2758', '291', '阎良区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2759', '291', '临潼区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2760', '291', '长安区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2761', '291', '蓝田县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2762', '291', '周至县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2763', '291', '户县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2764', '291', '高陵县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2765', '292', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2766', '292', '王益区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2767', '292', '印台区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2768', '292', '耀州区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2769', '292', '宜君县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2770', '293', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2771', '293', '渭滨区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2772', '293', '金台区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2773', '293', '陈仓区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2774', '293', '凤翔县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2775', '293', '岐山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2776', '293', '扶风县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2777', '293', '眉县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2778', '293', '陇县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2779', '293', '千阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2780', '293', '麟游县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2781', '293', '凤县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2782', '293', '太白县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2783', '294', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2784', '294', '秦都区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2785', '294', '杨陵区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2786', '294', '渭城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2787', '294', '三原县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2788', '294', '泾阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2789', '294', '乾县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2790', '294', '礼泉县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2791', '294', '永寿县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2792', '294', '彬县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2793', '294', '长武县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2794', '294', '旬邑县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2795', '294', '淳化县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2796', '294', '武功县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2797', '294', '兴平市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2798', '295', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2799', '295', '临渭区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2800', '295', '华县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2801', '295', '潼关县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2802', '295', '大荔县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2803', '295', '合阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2804', '295', '澄城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2805', '295', '蒲城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2806', '295', '白水县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2807', '295', '富平县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2808', '295', '韩城市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2809', '295', '华阴市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2810', '296', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2811', '296', '宝塔区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2812', '296', '延长县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2813', '296', '延川县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2814', '296', '子长县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2815', '296', '安塞县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2816', '296', '志丹县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2817', '296', '吴起县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2818', '296', '甘泉县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2819', '296', '富县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2820', '296', '洛川县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2821', '296', '宜川县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2822', '296', '黄龙县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2823', '296', '黄陵县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2824', '297', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2825', '297', '汉台区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2826', '297', '南郑县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2827', '297', '城固县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2828', '297', '洋县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2829', '297', '西乡县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2830', '297', '勉县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2831', '297', '宁强县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2832', '297', '略阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2833', '297', '镇巴县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2834', '297', '留坝县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2835', '297', '佛坪县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2836', '298', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2837', '298', '榆阳区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2838', '298', '神木县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2839', '298', '府谷县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2840', '298', '横山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2841', '298', '靖边县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2842', '298', '定边县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2843', '298', '绥德县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2844', '298', '米脂县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2845', '298', '佳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2846', '298', '吴堡县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2847', '298', '清涧县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2848', '298', '子洲县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2849', '299', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2850', '299', '汉滨区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2851', '299', '汉阴县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2852', '299', '石泉县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2853', '299', '宁陕县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2854', '299', '紫阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2855', '299', '岚皋县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2856', '299', '平利县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2857', '299', '镇坪县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2858', '299', '旬阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2859', '299', '白河县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2860', '300', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2861', '300', '商州区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2862', '300', '洛南县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2863', '300', '丹凤县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2864', '300', '商南县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2865', '300', '山阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2866', '300', '镇安县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2867', '300', '柞水县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2868', '301', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2869', '301', '城关区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2870', '301', '七里河区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2871', '301', '西固区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2872', '301', '安宁区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2873', '301', '红古区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2874', '301', '永登县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2875', '301', '皋兰县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2876', '301', '榆中县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2877', '302', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2878', '303', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2879', '303', '金川区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2880', '303', '永昌县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2881', '304', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2882', '304', '白银区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2883', '304', '平川区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2884', '304', '靖远县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2885', '304', '会宁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2886', '304', '景泰县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2887', '305', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2888', '305', '秦州区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2889', '305', '麦积区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2890', '305', '清水县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2891', '305', '秦安县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2892', '305', '甘谷县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2893', '305', '武山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2894', '305', '张家川回族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2895', '306', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2896', '306', '凉州区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2897', '306', '民勤县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2898', '306', '古浪县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2899', '306', '天祝藏族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2900', '307', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2901', '307', '甘州区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2902', '307', '肃南裕固族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2903', '307', '民乐县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2904', '307', '临泽县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2905', '307', '高台县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2906', '307', '山丹县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2907', '308', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2908', '308', '崆峒区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2909', '308', '泾川县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2910', '308', '灵台县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2911', '308', '崇信县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2912', '308', '华亭县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2913', '308', '庄浪县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2914', '308', '静宁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2915', '309', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2916', '309', '肃州区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2917', '309', '金塔县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2918', '309', '瓜州县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2919', '309', '肃北蒙古族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2920', '309', '阿克塞哈萨克族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2921', '309', '玉门市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2922', '309', '敦煌市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2923', '310', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2924', '310', '西峰区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2925', '310', '庆城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2926', '310', '环县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2927', '310', '华池县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2928', '310', '合水县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2929', '310', '正宁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2930', '310', '宁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2931', '310', '镇原县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2932', '311', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2933', '311', '安定区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2934', '311', '通渭县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2935', '311', '陇西县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2936', '311', '渭源县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2937', '311', '临洮县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2938', '311', '漳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2939', '311', '岷县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2940', '312', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2941', '312', '武都区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2942', '312', '成县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2943', '312', '文县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2944', '312', '宕昌县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2945', '312', '康县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2946', '312', '西和县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2947', '312', '礼县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2948', '312', '徽县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2949', '312', '两当县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2950', '313', '临夏市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2951', '313', '临夏县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2952', '313', '康乐县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2953', '313', '永靖县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2954', '313', '广河县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2955', '313', '和政县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2956', '313', '东乡族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2957', '313', '积石山保安族东乡族撒拉族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2958', '314', '合作市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2959', '314', '临潭县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2960', '314', '卓尼县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2961', '314', '舟曲县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2962', '314', '迭部县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2963', '314', '玛曲县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2964', '314', '碌曲县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2965', '314', '夏河县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2966', '315', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2967', '315', '城东区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2968', '315', '城中区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2969', '315', '城西区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2970', '315', '城北区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2971', '315', '大通回族土族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2972', '315', '湟中县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2973', '315', '湟源县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2974', '316', '平安县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2975', '316', '民和回族土族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2976', '316', '乐都县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2977', '316', '互助土族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2978', '316', '化隆回族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2979', '316', '循化撒拉族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2980', '317', '门源回族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2981', '317', '祁连县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2982', '317', '海晏县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2983', '317', '刚察县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2984', '318', '同仁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2985', '318', '尖扎县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2986', '318', '泽库县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2987', '318', '河南蒙古族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2988', '319', '共和县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2989', '319', '同德县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2990', '319', '贵德县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2991', '319', '兴海县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2992', '319', '贵南县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2993', '320', '玛沁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2994', '320', '班玛县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2995', '320', '甘德县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2996', '320', '达日县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2997', '320', '久治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2998', '320', '玛多县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('2999', '321', '玉树县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3000', '321', '杂多县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3001', '321', '称多县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3002', '321', '治多县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3003', '321', '囊谦县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3004', '321', '曲麻莱县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3005', '322', '格尔木市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3006', '322', '德令哈市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3007', '322', '乌兰县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3008', '322', '都兰县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3009', '322', '天峻县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3010', '323', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3011', '323', '兴庆区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3012', '323', '西夏区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3013', '323', '金凤区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3014', '323', '永宁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3015', '323', '贺兰县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3016', '323', '灵武市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3017', '324', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3018', '324', '大武口区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3019', '324', '惠农区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3020', '324', '平罗县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3021', '325', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3022', '325', '利通区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3023', '325', '红寺堡区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3024', '325', '盐池县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3025', '325', '同心县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3026', '325', '青铜峡市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3027', '326', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3028', '326', '原州区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3029', '326', '西吉县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3030', '326', '隆德县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3031', '326', '泾源县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3032', '326', '彭阳县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3033', '327', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3034', '327', '沙坡头区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3035', '327', '中宁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3036', '327', '海原县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3037', '328', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3038', '328', '天山区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3039', '328', '沙依巴克区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3040', '328', '新市区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3041', '328', '水磨沟区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3042', '328', '头屯河区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3043', '328', '达坂城区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3044', '328', '米东区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3045', '328', '乌鲁木齐县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3046', '329', '市辖区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3047', '329', '独山子区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3048', '329', '克拉玛依区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3049', '329', '白碱滩区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3050', '329', '乌尔禾区', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3051', '330', '吐鲁番市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3052', '330', '鄯善县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3053', '330', '托克逊县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3054', '331', '哈密市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3055', '331', '巴里坤哈萨克自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3056', '331', '伊吾县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3057', '332', '昌吉市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3058', '332', '阜康市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3059', '332', '呼图壁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3060', '332', '玛纳斯县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3061', '332', '奇台县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3062', '332', '吉木萨尔县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3063', '332', '木垒哈萨克自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3064', '333', '博乐市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3065', '333', '精河县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3066', '333', '温泉县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3067', '334', '库尔勒市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3068', '334', '轮台县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3069', '334', '尉犁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3070', '334', '若羌县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3071', '334', '且末县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3072', '334', '焉耆回族自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3073', '334', '和静县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3074', '334', '和硕县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3075', '334', '博湖县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3076', '335', '阿克苏市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3077', '335', '温宿县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3078', '335', '库车县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3079', '335', '沙雅县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3080', '335', '新和县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3081', '335', '拜城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3082', '335', '乌什县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3083', '335', '阿瓦提县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3084', '335', '柯坪县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3085', '336', '阿图什市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3086', '336', '阿克陶县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3087', '336', '阿合奇县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3088', '336', '乌恰县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3089', '337', '喀什市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3090', '337', '疏附县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3091', '337', '疏勒县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3092', '337', '英吉沙县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3093', '337', '泽普县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3094', '337', '莎车县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3095', '337', '叶城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3096', '337', '麦盖提县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3097', '337', '岳普湖县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3098', '337', '伽师县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3099', '337', '巴楚县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3100', '337', '塔什库尔干塔吉克自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3101', '338', '和田市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3102', '338', '和田县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3103', '338', '墨玉县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3104', '338', '皮山县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3105', '338', '洛浦县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3106', '338', '策勒县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3107', '338', '于田县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3108', '338', '民丰县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3109', '339', '伊宁市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3110', '339', '奎屯市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3111', '339', '伊宁县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3112', '339', '察布查尔锡伯自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3113', '339', '霍城县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3114', '339', '巩留县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3115', '339', '新源县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3116', '339', '昭苏县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3117', '339', '特克斯县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3118', '339', '尼勒克县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3119', '340', '塔城市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3120', '340', '乌苏市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3121', '340', '额敏县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3122', '340', '沙湾县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3123', '340', '托里县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3124', '340', '裕民县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3125', '340', '和布克赛尔蒙古自治县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3126', '341', '阿勒泰市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3127', '341', '布尔津县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3128', '341', '富蕴县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3129', '341', '福海县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3130', '341', '哈巴河县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3131', '341', '青河县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3132', '341', '吉木乃县', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3133', '342', '石河子市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3134', '342', '阿拉尔市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3135', '342', '图木舒克市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_city_district` VALUES ('3136', '342', '五家渠市', '1970-01-01 00:00:00', '1970-01-01 00:00:00');

-- ----------------------------
-- Table structure for `tb_client_package`
-- ----------------------------
DROP TABLE IF EXISTS `tb_client_package`;
CREATE TABLE `tb_client_package` (
  `id` int(11) NOT NULL,
  `version` varchar(20) NOT NULL,
  `version_code` int(11) NOT NULL,
  `intro` varchar(2000) NOT NULL,
  `client_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '1：android手机客户端安装包；2：android PAD客户端安装包；3：PC客户端安装包',
  `package_url` varchar(200) NOT NULL,
  `is_valid` tinyint(1) NOT NULL COMMENT '0：否；1：是；',
  `created` datetime DEFAULT '1970-01-01 00:00:00',
  `modified` datetime DEFAULT '1970-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Leapp客户端安装包';

-- ----------------------------
-- Records of tb_client_package
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_cp_baseinfo`
-- ----------------------------
DROP TABLE IF EXISTS `tb_cp_baseinfo`;
CREATE TABLE `tb_cp_baseinfo` (
  `id` int(11) NOT NULL,
  `account` varchar(20) NOT NULL,
  `password` varchar(32) DEFAULT NULL COMMENT 'MD5后存储',
  `cp_name` varchar(50) DEFAULT NULL,
  `supplier_no` varchar(30) DEFAULT NULL,
  `reg_time` datetime DEFAULT NULL,
  `cp_property` tinyint(4) DEFAULT NULL COMMENT '1：个人；2：公司',
  `cp_type` tinyint(4) DEFAULT NULL COMMENT '1：开发者；2：内容提供商',
  `fee_status` tinyint(4) DEFAULT NULL COMMENT '1：未申请；2：审核中；3：审核通过；4：审核不通过',
  `account_status` tinyint(4) DEFAULT NULL COMMENT '0：未启用；1：启用；2：已停用',
  `update_status` tinyint(4) DEFAULT '0' COMMENT '0：无更新；1：待审核；2：审核不通过；\n            注：更新审核通过更新状态归0，改为“无更新”',
  `update_comment` varchar(200) DEFAULT NULL,
  `contract_number` varchar(50) DEFAULT NULL,
  `valid_period_begin` date DEFAULT NULL,
  `valid_period_end` date DEFAULT NULL,
  `default_fee_mode` tinyint(4) DEFAULT NULL COMMENT '0：免费；1：分成，无预付模式；2：分成，有预付款模式；3：买断模式；',
  `default_percent` tinyint(4) DEFAULT NULL,
  `comment` varchar(200) DEFAULT NULL,
  `mail_sent1` tinyint(1) DEFAULT '0' COMMENT '是否发送预警邮件给管理员，0：否；1：是',
  `mail_sent2` tinyint(1) DEFAULT '0' COMMENT '是否发送预警邮件给CP，0：否；1：是',
  `sms_sent2` tinyint(1) DEFAULT '0' COMMENT '是否发送预警短信给CP，0：否；1：是',
  `created` datetime DEFAULT '1970-01-01 00:00:00',
  `modified` datetime DEFAULT '1970-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='存储CP的基本账户信息';

-- ----------------------------
-- Records of tb_cp_baseinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_cp_log`
-- ----------------------------
DROP TABLE IF EXISTS `tb_cp_log`;
CREATE TABLE `tb_cp_log` (
  `id` int(11) NOT NULL,
  `accountid` int(11) DEFAULT NULL,
  `operation_type` tinyint(4) DEFAULT NULL COMMENT '0：登录；1：登出；......',
  `operation_time` datetime DEFAULT NULL,
  `ip` varchar(32) DEFAULT NULL,
  `ua` varchar(256) DEFAULT NULL,
  `comment` varchar(256) DEFAULT NULL,
  `created` datetime DEFAULT '1970-01-01 00:00:00',
  `modified` datetime DEFAULT '1970-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_cp_log
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_cp_reginfo`
-- ----------------------------
DROP TABLE IF EXISTS `tb_cp_reginfo`;
CREATE TABLE `tb_cp_reginfo` (
  `id` int(11) NOT NULL,
  `accountid` int(11) NOT NULL,
  `is_copy` tinyint(1) NOT NULL COMMENT '0：正本；1：副本，用于修改时存储待审核信息',
  `ename` varchar(100) DEFAULT NULL,
  `certificate_type` tinyint(4) DEFAULT NULL COMMENT '0：身份证；1：护照；2：营业执照',
  `certificate_no` varchar(30) DEFAULT NULL,
  `certificate_photo` varchar(200) DEFAULT NULL,
  `webadd` varchar(200) DEFAULT NULL,
  `contacter` varchar(30) DEFAULT NULL,
  `province_id` int(11) DEFAULT NULL,
  `province` varchar(50) DEFAULT NULL,
  `city_id` int(11) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `district_id` int(11) DEFAULT NULL,
  `district` varchar(50) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `fax` varchar(20) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `mobile_binded` tinyint(1) DEFAULT NULL COMMENT '0：未绑定；1：已绑定',
  `email` varchar(80) DEFAULT NULL,
  `email_checked` tinyint(1) DEFAULT NULL COMMENT '0：未验证；1：已验证',
  `intro` varchar(500) DEFAULT NULL,
  `other_contact` varchar(100) DEFAULT NULL,
  `created` datetime DEFAULT '1970-01-01 00:00:00',
  `modified` datetime DEFAULT '1970-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='存储CP注册时候填写的注册信息';

-- ----------------------------
-- Records of tb_cp_reginfo
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_download_totalstat`
-- ----------------------------
DROP TABLE IF EXISTS `tb_download_totalstat`;
CREATE TABLE `tb_download_totalstat` (
  `id` int(11) NOT NULL,
  `appid` int(11) DEFAULT NULL,
  `download_times` int(11) DEFAULT NULL,
  `created` datetime DEFAULT '1970-01-01 00:00:00',
  `modified` datetime DEFAULT '1970-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_download_totalstat
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_feedback`
-- ----------------------------
DROP TABLE IF EXISTS `tb_feedback`;
CREATE TABLE `tb_feedback` (
  `id` int(11) NOT NULL,
  `ftype` varchar(20) NOT NULL,
  `content` varchar(200) NOT NULL,
  `fuser` varchar(200) DEFAULT NULL COMMENT '0：不发布；1：发布；',
  `created` datetime DEFAULT '1970-01-01 00:00:00',
  `modified` datetime DEFAULT '1970-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_feedback
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_hot_words`
-- ----------------------------
DROP TABLE IF EXISTS `tb_hot_words`;
CREATE TABLE `tb_hot_words` (
  `id` int(11) NOT NULL,
  `word` varchar(20) NOT NULL,
  `order_seq` smallint(6) DEFAULT NULL,
  `published` tinyint(1) DEFAULT NULL COMMENT '0：不发布；1：发布；',
  `created` datetime DEFAULT '1970-01-01 00:00:00',
  `modified` datetime DEFAULT '1970-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_hot_words
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_import_app_log`
-- ----------------------------
DROP TABLE IF EXISTS `tb_import_app_log`;
CREATE TABLE `tb_import_app_log` (
  `id` int(11) NOT NULL,
  `adminid` int(11) NOT NULL,
  `cp_account` int(11) DEFAULT NULL,
  `app_type` tinyint(1) NOT NULL COMMENT '1：移动应用；2：web应用',
  `total` int(11) DEFAULT '0',
  `processed` int(11) DEFAULT '0',
  `succeed` int(11) DEFAULT '0',
  `failed` int(11) DEFAULT '0',
  `excel_url` varchar(256) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL COMMENT '0：处理中；1：处理完成；2：结果Excel已上传；',
  `downloaded` tinyint(1) DEFAULT NULL,
  `created` datetime DEFAULT '1970-01-01 00:00:00',
  `modified` datetime DEFAULT '1970-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_import_app_log
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_offlineapp_install_stat`
-- ----------------------------
DROP TABLE IF EXISTS `tb_offlineapp_install_stat`;
CREATE TABLE `tb_offlineapp_install_stat` (
  `id` int(11) NOT NULL,
  `appid` int(11) DEFAULT NULL COMMENT '应用编号',
  `cid` int(11) DEFAULT NULL COMMENT 'PAD渠道号',
  `saler` varchar(40) DEFAULT NULL COMMENT 'PAD IMEI+促销员登录名 拼在一起',
  `year` int(11) DEFAULT NULL COMMENT '年',
  `month` smallint(6) DEFAULT NULL COMMENT '月',
  `day` smallint(6) DEFAULT NULL COMMENT '日',
  `install_times` int(11) DEFAULT NULL COMMENT '安装次数',
  `created` datetime DEFAULT '1970-01-01 00:00:00',
  `modified` datetime DEFAULT '1970-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_offlineapp_install_stat
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_offlineapp_sale_log`
-- ----------------------------
DROP TABLE IF EXISTS `tb_offlineapp_sale_log`;
CREATE TABLE `tb_offlineapp_sale_log` (
  `id` int(11) NOT NULL,
  `cid` int(11) NOT NULL COMMENT 'PAD渠道号',
  `pad_imei` varchar(20) DEFAULT NULL COMMENT 'PAD IMEI',
  `login_user` varchar(20) DEFAULT NULL COMMENT '促销员登录名',
  `saler_name` varchar(20) DEFAULT NULL COMMENT '促销员姓名',
  `saler_no` varchar(20) DEFAULT NULL COMMENT '促销员工号',
  `shop_name` varchar(50) DEFAULT NULL COMMENT '促销员所在店名',
  `phone_imei` varchar(20) DEFAULT NULL COMMENT '手机IMEI',
  `phone_os_ver` varchar(20) DEFAULT NULL COMMENT '手机OS版本',
  `phone_vender_name` varchar(50) DEFAULT NULL COMMENT '手机厂商名',
  `phone_model_name` varchar(50) DEFAULT NULL COMMENT '手机型号名',
  `install_model` tinyint(1) DEFAULT NULL COMMENT '安装方式，0：一键安装；1：单个安装',
  `appid` int(11) DEFAULT NULL COMMENT '应用ID',
  `cpid` int(11) DEFAULT NULL COMMENT 'CP ID',
  `app_version_name` varchar(20) DEFAULT NULL COMMENT '应用版本号',
  `install_time` datetime DEFAULT NULL COMMENT '安装时间',
  `statisticsflag`       int comment '统计标示',
  `statisticstime`       datetime comment '统计时间',
  `created` datetime NOT NULL COMMENT '创建时间',
  `modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_offlineapp_sale_log
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_onlineapp_install_stat`
-- ----------------------------
DROP TABLE IF EXISTS `tb_onlineapp_install_stat`;
CREATE TABLE `tb_onlineapp_install_stat` (
  `id` int(11) NOT NULL,
  `appid` int(11) DEFAULT NULL COMMENT '应用编号',
  `cid` int(11) DEFAULT NULL COMMENT 'PAD渠道号',
  `saler` varchar(40) DEFAULT NULL COMMENT 'PAD IMEI+促销员登录名 拼在一起',
  `year` int(11) DEFAULT NULL COMMENT '年',
  `month` smallint(6) DEFAULT NULL COMMENT '月',
  `day` smallint(6) DEFAULT NULL COMMENT '日',
  `install_times` int(11) DEFAULT NULL COMMENT '安装次数',
  `created` datetime DEFAULT '1970-01-01 00:00:00',
  `modified` datetime DEFAULT '1970-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_onlineapp_install_stat
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_onlineapp_sale_log`
-- ----------------------------
DROP TABLE IF EXISTS `tb_onlineapp_sale_log`;
CREATE TABLE `tb_onlineapp_sale_log` (
  `id` int(11) NOT NULL,
  `cid` int(11) NOT NULL COMMENT 'PAD渠道号',
  `pad_imei` varchar(20) DEFAULT NULL COMMENT 'PAD IMEI',
  `login_user` varchar(20) DEFAULT NULL COMMENT '促销员登录名',
  `saler_name` varchar(20) DEFAULT NULL COMMENT '促销员姓名',
  `saler_no` varchar(20) DEFAULT NULL COMMENT '促销员工号',
  `shop_name` varchar(50) DEFAULT NULL COMMENT '促销员所在店名',
  `phone_imei` varchar(20) DEFAULT NULL COMMENT '手机IMEI',
  `phone_os_ver` varchar(20) DEFAULT NULL COMMENT '手机OS版本',
  `phone_vender_name` varchar(50) DEFAULT NULL COMMENT '手机厂商名',
  `phone_model_name` varchar(50) DEFAULT NULL COMMENT '手机型号名',
  `install_model` tinyint(1) DEFAULT NULL COMMENT '安装方式，0：一键安装；1：单个安装',
  `appid` int(11) DEFAULT NULL COMMENT '应用ID',
  `cpid` int(11) DEFAULT NULL COMMENT 'CP ID',
  `app_version_name` varchar(20) DEFAULT NULL COMMENT '应用版本号',
  `install_time` datetime DEFAULT NULL COMMENT '安装时间',
  `created` datetime NOT NULL COMMENT '创建时间',
  `statisticsflag`       int comment '统计标示',
  `statisticstime`       datetime comment '统计时间',
  `modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_onlineapp_sale_log
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_pad_channel`
-- ----------------------------
DROP TABLE IF EXISTS `tb_pad_channel`;
CREATE TABLE `tb_pad_channel` (
  `id` int(11) NOT NULL COMMENT '0：同步商品基本信息；1：同步价格；2：同步上下架状态；3：同步商品类目；4：同步供应商信息；5：生成下载统计日报；',
  `cname` varchar(50) NOT NULL,
  `intro` varchar(500) DEFAULT NULL,
  `gw` varchar(100) DEFAULT NULL,
  `created` datetime NOT NULL COMMENT '创建时间',
  `modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_pad_channel
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_province`
-- ----------------------------
DROP TABLE IF EXISTS `tb_province`;
CREATE TABLE `tb_province` (
  `id` int(11) NOT NULL,
  `province` varchar(50) NOT NULL,
  `subordinate` tinyint(1) NOT NULL COMMENT '0：没有；1：有',
  `created` datetime DEFAULT '1970-01-01 00:00:00',
  `modified` datetime DEFAULT '1970-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_province
-- ----------------------------
INSERT INTO `tb_province` VALUES ('1', '北京', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province` VALUES ('2', '天津', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province` VALUES ('3', '河北', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province` VALUES ('4', '山西', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province` VALUES ('5', '内蒙古', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province` VALUES ('6', '辽宁', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province` VALUES ('7', '吉林', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province` VALUES ('8', '黑龙江', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province` VALUES ('9', '上海', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province` VALUES ('10', '江苏', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province` VALUES ('11', '浙江', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province` VALUES ('12', '安徽', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province` VALUES ('13', '福建', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province` VALUES ('14', '江西', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province` VALUES ('15', '山东', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province` VALUES ('16', '河南', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province` VALUES ('17', '湖北', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province` VALUES ('18', '湖南', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province` VALUES ('19', '广东', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province` VALUES ('20', '广西', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province` VALUES ('21', '海南', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province` VALUES ('22', '重庆', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province` VALUES ('23', '四川', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province` VALUES ('24', '贵州', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province` VALUES ('25', '云南', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province` VALUES ('26', '西藏', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province` VALUES ('27', '陕西', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province` VALUES ('28', '甘肃', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province` VALUES ('29', '青海', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province` VALUES ('30', '宁夏', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province` VALUES ('31', '新疆', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');

-- ----------------------------
-- Table structure for `tb_province_city`
-- ----------------------------
DROP TABLE IF EXISTS `tb_province_city`;
CREATE TABLE `tb_province_city` (
  `id` int(11) NOT NULL,
  `province_id` int(11) NOT NULL,
  `city` varchar(50) NOT NULL,
  `subordinate` tinyint(1) NOT NULL COMMENT '0：没有；1：有',
  `created` datetime DEFAULT '1970-01-01 00:00:00',
  `modified` datetime DEFAULT '1970-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_province_city
-- ----------------------------
INSERT INTO `tb_province_city` VALUES ('1', '1', '市辖区', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('2', '1', '县', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('3', '2', '市辖区', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('4', '2', '县', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('5', '3', '石家庄市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('6', '3', '唐山市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('7', '3', '秦皇岛市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('8', '3', '邯郸市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('9', '3', '邢台市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('10', '3', '保定市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('11', '3', '张家口市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('12', '3', '承德市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('13', '3', '沧州市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('14', '3', '廊坊市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('15', '3', '衡水市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('16', '4', '太原市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('17', '4', '大同市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('18', '4', '阳泉市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('19', '4', '长治市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('20', '4', '晋城市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('21', '4', '朔州市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('22', '4', '晋中市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('23', '4', '运城市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('24', '4', '忻州市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('25', '4', '临汾市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('26', '4', '吕梁市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('27', '5', '呼和浩特市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('28', '5', '包头市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('29', '5', '乌海市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('30', '5', '赤峰市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('31', '5', '通辽市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('32', '5', '鄂尔多斯市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('33', '5', '呼伦贝尔市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('34', '5', '巴彦淖尔市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('35', '5', '乌兰察布市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('36', '5', '兴安盟', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('37', '5', '锡林郭勒盟', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('38', '5', '阿拉善盟', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('39', '6', '沈阳市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('40', '6', '大连市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('41', '6', '鞍山市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('42', '6', '抚顺市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('43', '6', '本溪市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('44', '6', '丹东市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('45', '6', '锦州市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('46', '6', '营口市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('47', '6', '阜新市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('48', '6', '辽阳市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('49', '6', '盘锦市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('50', '6', '铁岭市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('51', '6', '朝阳市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('52', '6', '葫芦岛市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('53', '7', '长春市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('54', '7', '吉林市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('55', '7', '四平市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('56', '7', '辽源市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('57', '7', '通化市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('58', '7', '白山市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('59', '7', '松原市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('60', '7', '白城市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('61', '7', '延边朝鲜族自治州', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('62', '8', '哈尔滨市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('63', '8', '齐齐哈尔市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('64', '8', '鸡西市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('65', '8', '鹤岗市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('66', '8', '双鸭山市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('67', '8', '大庆市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('68', '8', '伊春市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('69', '8', '佳木斯市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('70', '8', '七台河市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('71', '8', '牡丹江市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('72', '8', '黑河市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('73', '8', '绥化市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('74', '8', '大兴安岭地区', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('75', '9', '市辖区', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('76', '9', '县', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('77', '10', '南京市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('78', '10', '无锡市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('79', '10', '徐州市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('80', '10', '常州市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('81', '10', '苏州市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('82', '10', '南通市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('83', '10', '连云港市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('84', '10', '淮安市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('85', '10', '盐城市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('86', '10', '扬州市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('87', '10', '镇江市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('88', '10', '泰州市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('89', '10', '宿迁市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('90', '11', '杭州市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('91', '11', '宁波市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('92', '11', '温州市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('93', '11', '嘉兴市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('94', '11', '湖州市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('95', '11', '绍兴市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('96', '11', '金华市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('97', '11', '衢州市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('98', '11', '舟山市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('99', '11', '台州市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('100', '11', '丽水市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('101', '12', '合肥市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('102', '12', '芜湖市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('103', '12', '蚌埠市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('104', '12', '淮南市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('105', '12', '马鞍山市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('106', '12', '淮北市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('107', '12', '铜陵市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('108', '12', '安庆市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('109', '12', '黄山市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('110', '12', '滁州市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('111', '12', '阜阳市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('112', '12', '宿州市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('113', '12', '六安市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('114', '12', '亳州市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('115', '12', '池州市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('116', '12', '宣城市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('117', '13', '福州市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('118', '13', '厦门市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('119', '13', '莆田市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('120', '13', '三明市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('121', '13', '泉州市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('122', '13', '漳州市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('123', '13', '南平市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('124', '13', '龙岩市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('125', '13', '宁德市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('126', '14', '南昌市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('127', '14', '景德镇市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('128', '14', '萍乡市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('129', '14', '九江市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('130', '14', '新余市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('131', '14', '鹰潭市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('132', '14', '赣州市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('133', '14', '吉安市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('134', '14', '宜春市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('135', '14', '抚州市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('136', '14', '上饶市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('137', '15', '济南市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('138', '15', '青岛市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('139', '15', '淄博市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('140', '15', '枣庄市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('141', '15', '东营市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('142', '15', '烟台市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('143', '15', '潍坊市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('144', '15', '济宁市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('145', '15', '泰安市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('146', '15', '威海市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('147', '15', '日照市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('148', '15', '莱芜市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('149', '15', '临沂市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('150', '15', '德州市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('151', '15', '聊城市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('152', '15', '滨州市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('153', '15', '菏泽市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('154', '16', '郑州市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('155', '16', '开封市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('156', '16', '洛阳市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('157', '16', '平顶山市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('158', '16', '安阳市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('159', '16', '鹤壁市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('160', '16', '新乡市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('161', '16', '焦作市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('162', '16', '濮阳市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('163', '16', '许昌市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('164', '16', '漯河市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('165', '16', '三门峡市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('166', '16', '南阳市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('167', '16', '商丘市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('168', '16', '信阳市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('169', '16', '周口市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('170', '16', '驻马店市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('171', '16', '省直辖县级行政区划', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('172', '17', '武汉市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('173', '17', '黄石市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('174', '17', '十堰市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('175', '17', '宜昌市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('176', '17', '襄阳市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('177', '17', '鄂州市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('178', '17', '荆门市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('179', '17', '孝感市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('180', '17', '荆州市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('181', '17', '黄冈市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('182', '17', '咸宁市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('183', '17', '随州市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('184', '17', '恩施土家族苗族自治州', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('185', '17', '省直辖县级行政区划', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('186', '18', '长沙市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('187', '18', '株洲市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('188', '18', '湘潭市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('189', '18', '衡阳市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('190', '18', '邵阳市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('191', '18', '岳阳市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('192', '18', '常德市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('193', '18', '张家界市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('194', '18', '益阳市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('195', '18', '郴州市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('196', '18', '永州市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('197', '18', '怀化市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('198', '18', '娄底市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('199', '18', '湘西土家族苗族自治州', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('200', '19', '广州市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('201', '19', '韶关市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('202', '19', '深圳市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('203', '19', '珠海市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('204', '19', '汕头市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('205', '19', '佛山市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('206', '19', '江门市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('207', '19', '湛江市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('208', '19', '茂名市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('209', '19', '肇庆市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('210', '19', '惠州市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('211', '19', '梅州市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('212', '19', '汕尾市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('213', '19', '河源市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('214', '19', '阳江市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('215', '19', '清远市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('216', '19', '潮州市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('217', '19', '揭阳市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('218', '19', '云浮市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('219', '20', '南宁市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('220', '20', '柳州市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('221', '20', '桂林市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('222', '20', '梧州市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('223', '20', '北海市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('224', '20', '防城港市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('225', '20', '钦州市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('226', '20', '贵港市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('227', '20', '玉林市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('228', '20', '百色市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('229', '20', '贺州市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('230', '20', '河池市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('231', '20', '来宾市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('232', '20', '崇左市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('233', '21', '海口市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('234', '21', '三亚市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('235', '21', '省直辖县级行政区划', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('236', '22', '市辖区', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('237', '22', '县', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('238', '23', '成都市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('239', '23', '自贡市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('240', '23', '攀枝花市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('241', '23', '泸州市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('242', '23', '德阳市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('243', '23', '绵阳市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('244', '23', '广元市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('245', '23', '遂宁市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('246', '23', '内江市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('247', '23', '乐山市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('248', '23', '南充市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('249', '23', '眉山市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('250', '23', '宜宾市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('251', '23', '广安市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('252', '23', '达州市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('253', '23', '雅安市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('254', '23', '巴中市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('255', '23', '资阳市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('256', '23', '阿坝藏族羌族自治州', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('257', '23', '甘孜藏族自治州', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('258', '23', '凉山彝族自治州', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('259', '24', '贵阳市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('260', '24', '六盘水市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('261', '24', '遵义市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('262', '24', '安顺市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('263', '24', '毕节市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('264', '24', '铜仁市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('265', '24', '黔西南布依族苗族自治州', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('266', '24', '黔东南苗族侗族自治州', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('267', '24', '黔南布依族苗族自治州', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('268', '25', '昆明市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('269', '25', '曲靖市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('270', '25', '玉溪市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('271', '25', '保山市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('272', '25', '昭通市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('273', '25', '丽江市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('274', '25', '普洱市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('275', '25', '临沧市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('276', '25', '楚雄彝族自治州', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('277', '25', '红河哈尼族彝族自治州', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('278', '25', '文山壮族苗族自治州', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('279', '25', '西双版纳傣族自治州', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('280', '25', '大理白族自治州', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('281', '25', '德宏傣族景颇族自治州', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('282', '25', '怒江傈僳族自治州', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('283', '25', '迪庆藏族自治州', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('284', '26', '拉萨市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('285', '26', '昌都地区', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('286', '26', '山南地区', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('287', '26', '日喀则地区', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('288', '26', '那曲地区', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('289', '26', '阿里地区', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('290', '26', '林芝地区', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('291', '27', '西安市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('292', '27', '铜川市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('293', '27', '宝鸡市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('294', '27', '咸阳市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('295', '27', '渭南市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('296', '27', '延安市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('297', '27', '汉中市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('298', '27', '榆林市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('299', '27', '安康市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('300', '27', '商洛市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('301', '28', '兰州市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('302', '28', '嘉峪关市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('303', '28', '金昌市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('304', '28', '白银市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('305', '28', '天水市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('306', '28', '武威市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('307', '28', '张掖市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('308', '28', '平凉市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('309', '28', '酒泉市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('310', '28', '庆阳市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('311', '28', '定西市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('312', '28', '陇南市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('313', '28', '临夏回族自治州', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('314', '28', '甘南藏族自治州', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('315', '29', '西宁市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('316', '29', '海东地区', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('317', '29', '海北藏族自治州', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('318', '29', '黄南藏族自治州', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('319', '29', '海南藏族自治州', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('320', '29', '果洛藏族自治州', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('321', '29', '玉树藏族自治州', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('322', '29', '海西蒙古族藏族自治州', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('323', '30', '银川市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('324', '30', '石嘴山市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('325', '30', '吴忠市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('326', '30', '固原市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('327', '30', '中卫市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('328', '31', '乌鲁木齐市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('329', '31', '克拉玛依市', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('330', '31', '吐鲁番地区', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('331', '31', '哈密地区', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('332', '31', '昌吉回族自治州', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('333', '31', '博尔塔拉蒙古自治州', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('334', '31', '巴音郭楞蒙古自治州', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('335', '31', '阿克苏地区', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('336', '31', '克孜勒苏柯尔克孜自治州', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('337', '31', '喀什地区', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('338', '31', '和田地区', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('339', '31', '伊犁哈萨克自治州', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('340', '31', '塔城地区', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('341', '31', '阿勒泰地区', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_province_city` VALUES ('342', '31', '自治区直辖县级行政区划', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');

-- ----------------------------
-- Table structure for `tb_ranking_app`
-- ----------------------------
DROP TABLE IF EXISTS `tb_ranking_app`;
CREATE TABLE `tb_ranking_app` (
  `id` int(11) NOT NULL,
  `ranking_style` tinyint(4) NOT NULL COMMENT '0：移动软件排行；1：移动游戏排行；2：Web应用排行；',
  `ranking_type` tinyint(4) NOT NULL COMMENT '0：最新上架；1：上升最快；2：热门收费；3：热门免费',
  `appid` int(11) NOT NULL,
  `pub_time` datetime DEFAULT NULL,
  `order_seq` smallint(6) DEFAULT NULL,
  `pubed_status` tinyint(4) DEFAULT NULL COMMENT '0：未发布；1：已发布',
  `locked` tinyint(4) DEFAULT NULL,
  `created` datetime DEFAULT '1970-01-01 00:00:00',
  `modified` datetime DEFAULT '1970-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='最新上架、上升最快、热门收费、热门免费四种排行榜';

-- ----------------------------
-- Records of tb_ranking_app
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_recommend`
-- ----------------------------
DROP TABLE IF EXISTS `tb_recommend`;
CREATE TABLE `tb_recommend` (
  `id` int(11) NOT NULL,
  `client_type` tinyint(4) NOT NULL COMMENT '0：手机客户端；1：PAD客户端；2：PC客户端；3：Web网站；',
  `moduleid` tinyint(4) NOT NULL COMMENT '0：首页；1：移动软件；2：移动游戏；3：Web应用；',
  `areaid` tinyint(4) NOT NULL COMMENT '0：Banner；1/banner右侧区域；2：热门推荐(W)；3：新品推荐；4：精品手机软件；5：精品手机游戏；6：精品网页应用；7：男生专区；8：女生专区；9：热门专题；10：手机首页热门；11：PAD首页热门；12：热门推荐(P)；13：CP首页；\n            21～29：通栏广告1～通栏广告9',
  `home_areaid` tinyint(4) DEFAULT NULL,
  `home_areatype` tinyint(4) DEFAULT NULL COMMENT '只针对Android手机/PAD客户端的首页热门推荐，共提供3种版型',
  `home_areapos` tinyint(4) DEFAULT NULL COMMENT '只针对Android手机/PAD客户端的首页热门推荐，每种版型下属3个版位，编号为1、2、3，顺序为先由左至右再由上至下。比如左边有两个图片，右边有一个图片，那么左边两个图片从上到下版位分别为1、2，右边图片版位为3.',
  `seq` tinyint(4) NOT NULL,
  `url` varchar(150) DEFAULT NULL,
  `is_app_logo` tinyint(1) DEFAULT NULL,
  `is_default_img` tinyint(1) DEFAULT NULL COMMENT '0：否；1：是',
  `link_type` tinyint(4) DEFAULT NULL COMMENT '0：应用；1：专题；2：类目；3：外链；',
  `linked_appid` int(11) DEFAULT NULL COMMENT '应用id、专题id、类目id',
  `linked_url` varchar(256) DEFAULT NULL,
  `intro` varchar(60) DEFAULT NULL,
  `pubed_status` tinyint(4) DEFAULT NULL COMMENT '0：未发布；1：发布',
  `created` datetime DEFAULT '1970-01-01 00:00:00',
  `modified` datetime DEFAULT '1970-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='存储Banner、通栏广告、热门推荐、精品应用、男女生专区、热门专题等几个区域的推广内容';

-- ----------------------------
-- Records of tb_recommend
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_support_module`
-- ----------------------------
DROP TABLE IF EXISTS `tb_support_module`;
CREATE TABLE `tb_support_module` (
  `moduleid` int(11) NOT NULL,
  `parentid` int(11) DEFAULT NULL,
  `level` tinyint(4) NOT NULL,
  `module_name` varchar(30) NOT NULL,
  `module_url` varchar(100) NOT NULL,
  `module_intro` varchar(100) DEFAULT NULL,
  `module_status` tinyint(4) DEFAULT NULL,
  `created` datetime DEFAULT '1970-01-01 00:00:00',
  `modified` datetime DEFAULT '1970-01-01 00:00:00',
  PRIMARY KEY (`moduleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='定义运营支撑系统功能模块，用来制定角色权限';

-- ----------------------------
-- Records of tb_support_module
-- ----------------------------
INSERT INTO `tb_support_module` VALUES ('1', '0', '1', 'CP资质管理', '/cpQualityManagement/init.action', '管理应用服务商资质', '0', '2013-01-10 14:51:28', '2013-01-10 14:51:28');
INSERT INTO `tb_support_module` VALUES ('2', '0', '1', '终端信息管理', '/os/init.action', '终端信息管理', '0', '2013-01-10 14:51:28', '2013-01-10 14:51:28');
INSERT INTO `tb_support_module` VALUES ('3', '0', '1', '应用管理', '/appManagement/init.action', '应用管理', '0', '2013-01-10 14:51:29', '2013-01-10 14:51:29');
INSERT INTO `tb_support_module` VALUES ('4', '0', '1', '客户端管理', '/recommendManager/init.action', '客户端管理', '0', '2013-01-10 14:51:29', '2013-01-10 14:51:29');
INSERT INTO `tb_support_module` VALUES ('6', '0', '1', '用户管理', '/accountManager/init.action', '用户管理', '0', '2013-01-10 14:51:29', '2013-01-10 14:51:29');
INSERT INTO `tb_support_module` VALUES ('7', '0', '1', '系统维护', '/categoryMaintenance/init.action', '系统维护', '0', '2013-01-10 14:51:29', '2013-01-10 14:51:29');
INSERT INTO `tb_support_module` VALUES ('8', '6', '2', '帐号管理', '/accountManager/list.action', '用户管理-帐号管理', '0', '2013-01-10 14:51:29', '2013-01-10 14:51:29');
INSERT INTO `tb_support_module` VALUES ('9', '6', '2', '角色管理', '/roleManager/list.action', '用户管理-角色管理', '0', '2013-01-10 14:51:29', '2013-01-10 14:51:29');
INSERT INTO `tb_support_module` VALUES ('10', '7', '2', '类目管理', '/categoryMaintenance/categoryList.action', '系统维护-类目管理', '0', '2013-01-10 14:51:29', '2013-01-10 14:51:29');
INSERT INTO `tb_support_module` VALUES ('11', '7', '2', '任务管理', '', '系统维护-任务管理', '0', '2013-01-10 14:51:29', '2013-01-10 14:51:29');
INSERT INTO `tb_support_module` VALUES ('15', '11', '3', '周期性任务', '/taskManager/loopList.action', '系统维护-任务管理-周期性任务', '0', '2013-01-10 14:51:29', '2013-01-10 14:51:29');
INSERT INTO `tb_support_module` VALUES ('16', '11', '3', 'ERP同步任务', '/taskManager/erpList.action', '系统维护-任务管理-ERP同步任务', '0', '2013-01-10 14:51:29', '2013-01-10 14:51:29');
INSERT INTO `tb_support_module` VALUES ('17', '8', '4', '添加新用户', '/accountManager/add.action', '用户管理-帐号管理-添加新用户', '1', '2013-01-10 14:51:29', '2013-01-10 14:51:29');
INSERT INTO `tb_support_module` VALUES ('18', '8', '4', '修改密码', '/accountManager/modifiedPassWord.action', '用户管理-帐号管理-修改密码', '1', '2013-01-10 14:51:30', '2013-01-10 14:51:30');
INSERT INTO `tb_support_module` VALUES ('19', '8', '4', '设定角色', '/accountManager/modifiedRole.action', '用户管理-帐号管理-设定角色', '1', '2013-01-10 14:51:30', '2013-01-10 14:51:30');
INSERT INTO `tb_support_module` VALUES ('20', '8', '4', '启用/停用', '/accountManager/doModifiedStatus.action', '用户管理-帐号管理-启用/停用', '1', '2013-01-10 14:51:30', '2013-01-10 14:51:30');
INSERT INTO `tb_support_module` VALUES ('21', '8', '4', '检查用户名是否存在', '/accountManager/checkedAccount.action', '用户管理-帐号管理-检查用户名是否存在', '1', '2013-01-10 14:51:30', '2013-01-10 14:51:30');
INSERT INTO `tb_support_module` VALUES ('22', '8', '4', '确定添加新用户', '/accountManager/doAdd.action', '用户管理-帐号管理-确定添加新用户', '1', '2013-01-10 14:51:30', '2013-01-10 14:51:30');
INSERT INTO `tb_support_module` VALUES ('23', '8', '4', '确定修改密码', '/accountManager/doModifiedPassWord.action', '用户管理-帐号管理-确定修改密码', '1', '2013-01-10 14:51:30', '2013-01-10 14:51:30');
INSERT INTO `tb_support_module` VALUES ('24', '8', '4', '确定修改角色', '/accountManager/doModifiedRole.action', '用户管理-帐号管理-确定修改角色', '1', '2013-01-10 14:51:30', '2013-01-10 14:51:30');
INSERT INTO `tb_support_module` VALUES ('25', '9', '4', '添加新角色', '/roleManager/add.action', '用户管理-角色管理-添加新角色', '1', '2013-01-10 14:51:30', '2013-01-10 14:51:30');
INSERT INTO `tb_support_module` VALUES ('26', '9', '4', '修改角色', '/roleManager/modifiedRole.action', '用户管理-角色管理-修改角色', '1', '2013-01-10 14:51:30', '2013-01-10 14:51:30');
INSERT INTO `tb_support_module` VALUES ('27', '9', '4', '删除角色', '/roleManager/deleteRole.action', '用户管理-角色管理-删除角色', '1', '2013-01-10 14:51:30', '2013-01-10 14:51:30');
INSERT INTO `tb_support_module` VALUES ('28', '9', '4', '检查角色名是否存在', '/roleManager/checkedRole.action', '用户管理-角色管理-检查角色名是否存在', '1', '2013-01-10 14:51:30', '2013-01-10 14:51:30');
INSERT INTO `tb_support_module` VALUES ('29', '9', '4', '确定添加新角色', '/roleManager/doAdd.action', '用户管理-角色管理-确定添加新角色', '1', '2013-01-10 14:51:31', '2013-01-10 14:51:31');
INSERT INTO `tb_support_module` VALUES ('30', '9', '4', '确定修改权限', '/roleManager/doModifiedRole.action', '用户管理-角色管理-确定修改权限', '1', '2013-01-10 14:51:31', '2013-01-10 14:51:31');
INSERT INTO `tb_support_module` VALUES ('31', '10', '4', '更改类目图标', '/categoryMaintenance/uploadPic.action', '系统维护-类目管理-移动游戏-更改类目图标', '1', '2013-01-10 14:51:31', '2013-01-10 14:51:31');
INSERT INTO `tb_support_module` VALUES ('36', '10', '4', '删除类目图标', '/categoryMaintenance/deleteImage.action', '系统维护-类目管理-移动游戏-删除类目图标', '1', '2013-01-10 14:51:31', '2013-01-10 14:51:31');
INSERT INTO `tb_support_module` VALUES ('37', '15', '4', '立即执行', '/taskManager/immediatelyExec.action', '系统维护-任务管理-周期性任务-立即执行', '1', '2013-01-10 14:51:31', '2013-01-10 14:51:31');
INSERT INTO `tb_support_module` VALUES ('38', '15', '4', '停用', '/taskManager/disable.action', '系统维护-任务管理-周期性任务-停用', '1', '2013-01-10 14:51:31', '2013-01-10 14:51:31');
INSERT INTO `tb_support_module` VALUES ('39', '15', '4', '启用', '/taskManager/enable.action', '系统维护-任务管理-周期性任务-启用', '1', '2013-01-10 14:51:31', '2013-01-10 14:51:31');
INSERT INTO `tb_support_module` VALUES ('40', '16', '4', '重新同步', '/taskManager/resetErpTask.action', '系统维护-任务管理-ERP同步任务-重新同步', '1', '2013-01-10 14:51:31', '2013-01-10 14:51:31');
INSERT INTO `tb_support_module` VALUES ('41', '1', '2', 'CP账号管理', '/cpQualityManagement/findCpPage.action', 'CP账号管理', '0', '2013-01-10 14:51:31', '2013-01-10 14:51:31');
INSERT INTO `tb_support_module` VALUES ('42', '1', '2', '收费资质管理', '/cpChargeQualification/findCpChargePage.action', '收费资质管理', '0', '2013-01-10 14:51:31', '2013-01-10 14:51:31');
INSERT INTO `tb_support_module` VALUES ('43', '41', '3', 'CP帐号查询', '/cpQualityManagement/findCpPage.action', 'CP帐号查询', '1', '2013-01-10 14:51:32', '2013-01-10 14:51:32');
INSERT INTO `tb_support_module` VALUES ('44', '42', '3', '收费资质审核查询', '/cpChargeQualification/findCpChargePage.action', '收费资质审核查询', '1', '2013-01-10 14:51:32', '2013-01-10 14:51:32');
INSERT INTO `tb_support_module` VALUES ('45', '41', '3', 'CP帐号的启用停用操作', '/cpQualityManagement/upAccountStatus.action', 'CP帐号的启用停用操作', '1', '2013-01-10 14:51:32', '2013-01-10 14:51:32');
INSERT INTO `tb_support_module` VALUES ('46', '42', '3', '收费资质审核待审核操作', '/cpChargeQualification/upCpFeeStatus.action', '收费资质审核待审核操作', '1', '2013-01-10 14:51:32', '2013-01-10 14:51:32');
INSERT INTO `tb_support_module` VALUES ('47', '41', '3', 'CP帐号的删除', '/cpQualityManagement/delCp.action', 'CP帐号的删除', '1', '2013-01-10 14:51:32', '2013-01-10 14:51:32');
INSERT INTO `tb_support_module` VALUES ('48', '41', '3', 'CP帐号管理查看详情操作', '/cpQualityManagement/findCpExpatiation.action', 'CP帐号管理查看详情操作', '1', '2013-01-10 14:51:32', '2013-01-10 14:51:32');
INSERT INTO `tb_support_module` VALUES ('49', '42', '3', '收费资质审核信息查询', '/cpChargeQualification/findCpChargeExpatiation.action', '收费资质审核信息查询', '1', '2013-01-10 14:51:32', '2013-01-10 14:51:32');
INSERT INTO `tb_support_module` VALUES ('50', '42', '3', '收费资质审核不通过操作', '/cpChargeQualification/upCpFeeStatus.action', '收费资质审核不通过操作', '1', '2013-01-10 14:51:32', '2013-01-10 14:51:32');
INSERT INTO `tb_support_module` VALUES ('51', '42', '3', '收费资质审核通过操作', '/cpChargeQualification/upCpChargeFeeStatusByOne.action', '收费资质审核通过操作', '1', '2013-01-10 14:51:32', '2013-01-10 14:51:32');
INSERT INTO `tb_support_module` VALUES ('52', '2', '2', '平台管理', '/os/findOsPage.action', '平台管理', '0', '2013-01-10 14:51:32', '2013-01-10 14:51:32');
INSERT INTO `tb_support_module` VALUES ('53', '2', '2', '屏幕管理', '/screen/findScreenPage.action', '屏幕管理', '0', '2013-01-10 14:51:32', '2013-01-10 14:51:32');
INSERT INTO `tb_support_module` VALUES ('54', '52', '3', '平台列表查询', '/os/findOsPage.action', '平台列表查询', '1', '2013-01-10 14:51:33', '2013-01-10 14:51:33');
INSERT INTO `tb_support_module` VALUES ('55', '53', '3', '屏幕列表查询', '/screen/findScreenPage.action', '屏幕列表查询', '1', '2013-01-10 14:51:33', '2013-01-10 14:51:33');
INSERT INTO `tb_support_module` VALUES ('56', '52', '3', '平台上下架操作', '/os/upOsOnline.action', '平台上下架操作', '1', '2013-01-10 14:51:33', '2013-01-10 14:51:33');
INSERT INTO `tb_support_module` VALUES ('57', '53', '3', '屏幕上下架操作', '/screen/upScreenOnline.action', '屏幕上下架操作', '1', '2013-01-10 14:51:33', '2013-01-10 14:51:33');
INSERT INTO `tb_support_module` VALUES ('58', '52', '3', '删除平台操作', '/os/delOs.action', '删除系统操作', '1', '2013-01-10 14:51:33', '2013-01-10 14:51:33');
INSERT INTO `tb_support_module` VALUES ('59', '53', '3', '删除屏幕操作', '/screen/delScreen.action', '删除屏幕操作', '1', '2013-01-10 14:51:33', '2013-01-10 14:51:33');
INSERT INTO `tb_support_module` VALUES ('60', '52', '3', '更新平台查询', '/os/findOsById.action', '更新平台查询', '1', '2013-01-10 14:51:33', '2013-01-10 14:51:33');
INSERT INTO `tb_support_module` VALUES ('61', '53', '3', '更新屏幕查询', '/screen/findScreenById.action', '更新屏幕查询', '1', '2013-01-10 14:51:33', '2013-01-10 14:51:33');
INSERT INTO `tb_support_module` VALUES ('62', '52', '3', '增加平台按钮操作', '/os/addOsButton.action', '增加平台按钮操作', '1', '2013-01-10 14:51:33', '2013-01-10 14:51:33');
INSERT INTO `tb_support_module` VALUES ('63', '53', '3', '增加屏幕按钮操作', '/screen/addScreenButton.action', '增加屏幕按钮操作', '1', '2013-01-10 14:51:34', '2013-01-10 14:51:34');
INSERT INTO `tb_support_module` VALUES ('64', '52', '3', '检查平台名', '/os/checkOsName.action', '检查平台名', '1', '2013-01-10 14:51:34', '2013-01-10 14:51:34');
INSERT INTO `tb_support_module` VALUES ('65', '53', '3', '检查屏幕名', '/screen/checkScreenName.action', '检查屏幕名', '1', '2013-01-10 14:51:34', '2013-01-10 14:51:34');
INSERT INTO `tb_support_module` VALUES ('66', '53', '3', '屏幕更新操作', '/screen/upScreen.action', '屏幕更新操作', '1', '2013-01-10 14:51:34', '2013-01-10 14:51:34');
INSERT INTO `tb_support_module` VALUES ('67', '53', '3', '增加新屏幕', '/screen/createScreen.action', '增加新屏幕', '1', '2013-01-10 14:51:34', '2013-01-10 14:51:34');
INSERT INTO `tb_support_module` VALUES ('68', '52', '3', '平台版本码校验', '/os/checkOsCode.action', '平台版本码校验', '1', '2013-01-10 14:51:34', '2013-01-10 14:51:34');
INSERT INTO `tb_support_module` VALUES ('69', '52', '3', '增加新平台', '/os/createOs.action', '增加新平台', '1', '2013-01-10 14:51:34', '2013-01-10 14:51:34');
INSERT INTO `tb_support_module` VALUES ('70', '52', '3', '平台更新操作', '/os/upOs.action', '平台更新操作', '1', '2013-01-10 14:51:34', '2013-01-10 14:51:34');
INSERT INTO `tb_support_module` VALUES ('71', '3', '2', '应用浏览', '', '应用浏览', '0', '2013-01-10 14:51:34', '2013-01-10 14:51:34');
INSERT INTO `tb_support_module` VALUES ('72', '3', '2', '审核应用', '', '审核应用', '0', '2013-01-10 14:51:34', '2013-01-10 14:51:34');
INSERT INTO `tb_support_module` VALUES ('73', '71', '3', '浏览移动应用', '/appBrowse/findMobileBrowsePage.action', '浏览移动应用', '0', '2013-01-10 14:51:34', '2013-01-10 14:51:34');
INSERT INTO `tb_support_module` VALUES ('74', '71', '3', '浏览网页应用', '/appBrowse/findWebBrowsePage.action', '浏览网页应用', '0', '2013-01-10 14:51:35', '2013-01-10 14:51:35');
INSERT INTO `tb_support_module` VALUES ('75', '72', '3', '审核移动应用', '/appManagement/findMobileDetailsPage.action', '审核移动应用', '0', '2013-01-10 14:51:35', '2013-01-10 14:51:35');
INSERT INTO `tb_support_module` VALUES ('76', '72', '3', '审核网页应用', '/appManagement/findWebDetailsPage.action', '审核网页应用', '0', '2013-01-10 14:51:35', '2013-01-10 14:51:35');
INSERT INTO `tb_support_module` VALUES ('77', '75', '4', '审核移动应用查询', '/appManagement/findMobileDetailsPage.action', '审核移动应用查询', '1', '2013-01-10 14:51:35', '2013-01-10 14:51:35');
INSERT INTO `tb_support_module` VALUES ('78', '76', '4', '审核网页应用查询', '/appManagement/findWebDetailsPage.action', '审核网页应用查询', '1', '2013-01-10 14:51:35', '2013-01-10 14:51:35');
INSERT INTO `tb_support_module` VALUES ('79', '73', '4', '浏览移动应用查询', '/appBrowse/findMobileBrowsePage.action', '浏览移动应用查询', '1', '2013-01-10 14:51:35', '2013-01-10 14:51:35');
INSERT INTO `tb_support_module` VALUES ('80', '74', '4', '浏览网页应用查询', '/appBrowse/findWebBrowsePage.action', '浏览网页应用查询', '1', '2013-01-10 14:51:35', '2013-01-10 14:51:35');
INSERT INTO `tb_support_module` VALUES ('81', '75', '4', '移动应用审核按钮查询', '/appManagement/findAppMobileDetails.action', '移动应用审核按钮查询', '1', '2013-01-10 14:51:35', '2013-01-10 14:51:35');
INSERT INTO `tb_support_module` VALUES ('82', '76', '4', '网页应用审核按钮查询', '/appManagement/findAppWebDetails.action', '网页应用审核按钮查询', '1', '2013-01-10 14:51:35', '2013-01-10 14:51:35');
INSERT INTO `tb_support_module` VALUES ('83', '75', '4', '移动审核不通过操作', '/appManagement/updateStatusMobileOff.action', '移动审核不通过操作', '1', '2013-01-10 14:51:35', '2013-01-10 14:51:35');
INSERT INTO `tb_support_module` VALUES ('84', '76', '4', '网页审核不通过操作', '/appManagement/updateStatusWebOff.action', '网页审核不通过操作', '1', '2013-01-10 14:51:35', '2013-01-10 14:51:35');
INSERT INTO `tb_support_module` VALUES ('85', '75', '4', '移动审核通过操作', '/appManagement/updateStatusMobileOn.action', '移动审核通过操作', '1', '2013-01-10 14:51:36', '2013-01-10 14:51:36');
INSERT INTO `tb_support_module` VALUES ('86', '76', '4', '网页审核通过操作', '/appManagement/updateStatusWebOn.action', '网页审核通过操作', '1', '2013-01-10 14:51:36', '2013-01-10 14:51:36');
INSERT INTO `tb_support_module` VALUES ('87', '73', '4', '批量更新移动上下架', '/appBrowse/upMobileOnline.action', '批量更新移动上下架', '1', '2013-01-10 14:51:36', '2013-01-10 14:51:36');
INSERT INTO `tb_support_module` VALUES ('88', '74', '4', '批量更新网页上下架', '/appBrowse/upWebOnline.action', '批量更新网页上下架', '1', '2013-01-10 14:51:36', '2013-01-10 14:51:36');
INSERT INTO `tb_support_module` VALUES ('89', '73', '4', '更新一个移动上下架', '/appBrowse/upMobileOnlineById.action', '更新一个移动上下架', '1', '2013-01-10 14:51:36', '2013-01-10 14:51:36');
INSERT INTO `tb_support_module` VALUES ('90', '74', '4', '更新一个网页上下架', '/appBrowse/upWebOnlineById.action', '更新一个网页上下架', '1', '2013-01-10 14:51:36', '2013-01-10 14:51:36');
INSERT INTO `tb_support_module` VALUES ('91', '73', '4', '查看移动应用详情查询', '/appBrowse/findMobileExpatiation.action', '查看移动应用详情查询', '1', '2013-01-10 14:51:36', '2013-01-10 14:51:36');
INSERT INTO `tb_support_module` VALUES ('92', '74', '4', '查看网页应用详情查询', '/appBrowse/findWebExpatiation.action', '查看网页应用详情查询', '1', '2013-01-10 14:51:36', '2013-01-10 14:51:36');
INSERT INTO `tb_support_module` VALUES ('93', '73', '4', '移动详情上下架', '/appBrowse/upAppDetailsOnline.action', '移动详情上下架', '1', '2013-01-10 14:51:36', '2013-01-10 14:51:36');
INSERT INTO `tb_support_module` VALUES ('94', '72', '4', '通过2级类目查3级类目', '/appManagement/findCategory.action', '通过2级类目查3级类目', '1', '2013-01-10 14:51:37', '2013-01-10 14:51:37');
INSERT INTO `tb_support_module` VALUES ('95', '73', '4', '编辑移动应用详情查询', '/appBrowse/findMobileExpatiationEdit.action', '编辑移动应用详情查询', '1', '2013-01-10 14:51:37', '2013-01-10 14:51:37');
INSERT INTO `tb_support_module` VALUES ('96', '74', '4', '编辑网页应用详情查询', '/appBrowse/findWebExpatiationEdit.action', '编辑网页应用详情查询', '1', '2013-01-10 14:51:37', '2013-01-10 14:51:37');
INSERT INTO `tb_support_module` VALUES ('97', '71', '4', '更新为默认详情', '/appBrowse/upAppDefaultDetaild.action', '更新为默认详情', '1', '2013-01-10 14:51:37', '2013-01-10 14:51:37');
INSERT INTO `tb_support_module` VALUES ('98', '73', '4', '编辑移动保存', '/appBrowse/saveMobileAppAndDetailInformation.action', '编辑移动保存', '1', '2013-01-10 14:51:37', '2013-01-10 14:51:37');
INSERT INTO `tb_support_module` VALUES ('99', '74', '4', '编辑网页保存', '/appBrowse/saveWebAppAndDetailInformation.action', '编辑网页保存', '1', '2013-01-10 14:51:37', '2013-01-10 14:51:37');
INSERT INTO `tb_support_module` VALUES ('100', '4', '2', '推广应用管理', ' ', '推广应用管理', '0', '2013-01-10 14:51:37', '2013-01-10 14:51:37');
INSERT INTO `tb_support_module` VALUES ('101', '100', '3', '手机客户端', '/recommendManager/getPhoneRecommend.action', '手机客户端推广内容列表', '0', '2013-01-10 14:51:37', '2013-01-10 14:51:37');
INSERT INTO `tb_support_module` VALUES ('102', '101', '4', '增加手机客户端推荐版型', '/recommendManager/addHomeAreaType.action', '增加手机客户端推荐版型', '1', '2013-01-10 14:51:37', '2013-01-10 14:51:37');
INSERT INTO `tb_support_module` VALUES ('103', '101', '4', '初始化编辑手机客户端推荐内容界面', '/recommendManager/load.action', '初始化编辑手机客户端推荐内容界面', '1', '2013-01-10 14:51:37', '2013-01-10 14:51:37');
INSERT INTO `tb_support_module` VALUES ('104', '101', '4', '上传图片', '/upload/uploadImg.action', '上传图片', '1', '2013-01-10 14:51:38', '2013-01-10 14:51:38');
INSERT INTO `tb_support_module` VALUES ('105', '101', '4', '初始化类目二级菜单', '/recommendManager/initParentId.action', '初始化类目二级菜单', '1', '2013-01-10 14:51:38', '2013-01-10 14:51:38');
INSERT INTO `tb_support_module` VALUES ('106', '101', '4', '查询三级类目', '/search/searchCategoryJson.action', '查询二级类目对应的三级类目', '1', '2013-01-10 14:51:38', '2013-01-10 14:51:38');
INSERT INTO `tb_support_module` VALUES ('107', '101', '4', '搜索应用', '/search/SearchAppForRecommend.action', '搜索应用', '1', '2013-01-10 14:51:38', '2013-01-10 14:51:38');
INSERT INTO `tb_support_module` VALUES ('108', '101', '4', '搜索专题', '/search/SearchTopicForRecommend.action', '搜索专题', '1', '2013-01-10 14:51:38', '2013-01-10 14:51:38');
INSERT INTO `tb_support_module` VALUES ('109', '101', '4', '更新手机客户端推荐内容', '/recommendManager/updatePhoneRecommend.action', '更新手机客户端推荐内容', '1', '2013-01-10 14:51:38', '2013-01-10 14:51:38');
INSERT INTO `tb_support_module` VALUES ('110', '101', '4', '修改手机客户端推荐内容', '/recommendManager/editPhoneRecommend.action', '修改客户端推荐内容', '1', '2013-01-10 14:51:38', '2013-01-10 14:51:38');
INSERT INTO `tb_support_module` VALUES ('111', '101', '4', '更新修改后的推荐内容', '/recommendManager/updateRecommend.action', '更新修改后的推荐内容', '1', '2013-01-10 14:51:38', '2013-01-10 14:51:38');
INSERT INTO `tb_support_module` VALUES ('112', '101', '4', '修改手机客户端推荐内容的排序', '/recommendManager/updatePhoneRecommendSeq.action', '修改手机客户端推荐内容的排序', '1', '2013-01-10 14:51:38', '2013-01-10 14:51:38');
INSERT INTO `tb_support_module` VALUES ('113', '101', '4', '删除手机客户端的推荐内容', '/recommendManager/deletePhoneRecommend.action', '删除手机客户端的推荐内容', '1', '2013-01-10 14:51:38', '2013-01-10 14:51:38');
INSERT INTO `tb_support_module` VALUES ('114', '101', '4', '更新手机客户端推荐内容的上下线状态', '/recommendManager/updatePhonePubedStatus.action', '更新手机客户端推荐内容的上下线状态', '1', '2013-01-10 14:51:39', '2013-01-10 14:51:39');
INSERT INTO `tb_support_module` VALUES ('115', '100', '3', 'Pad客户端', '/recommendManager/getPadRecommend.action', 'Pad客户端推荐内容列表', '0', '2013-01-10 14:51:39', '2013-01-10 14:51:39');
INSERT INTO `tb_support_module` VALUES ('116', '115', '4', '增加Pad客户端的版型', '/recommendManager/addPadHomeAreaType.action', '增加Pad客户端版型', '1', '2013-01-10 14:51:39', '2013-01-10 14:51:39');
INSERT INTO `tb_support_module` VALUES ('117', '115', '4', '初始化编辑Pad客户端推荐内容界面', '/recommendManager/loadPad.action', '初始化编辑Pad客户端推荐内容界面', '1', '2013-01-10 14:51:39', '2013-01-10 14:51:39');
INSERT INTO `tb_support_module` VALUES ('118', '115', '4', '上传图片', '/upload/uploadImg.action', '上传图片', '1', '2013-01-10 14:51:39', '2013-01-10 14:51:39');
INSERT INTO `tb_support_module` VALUES ('119', '115', '4', '初始化类目二级菜单', '/recommendManager/initParentId.action', '初始化类目二级菜单', '1', '2013-01-10 14:51:39', '2013-01-10 14:51:39');
INSERT INTO `tb_support_module` VALUES ('120', '115', '4', '查询三级类目', '/search/searchCategoryJson.action', '查询三级类目', '1', '2013-01-10 14:51:39', '2013-01-10 14:51:39');
INSERT INTO `tb_support_module` VALUES ('121', '115', '4', '搜索应用', '/search/SerAppForRecommend.action', '搜索应用', '1', '2013-01-10 14:51:39', '2013-01-10 14:51:39');
INSERT INTO `tb_support_module` VALUES ('122', '115', '4', '搜索专题', '/search/SearchAppFoRecommend.action', '搜索专题', '1', '2013-01-10 14:51:39', '2013-01-10 14:51:39');
INSERT INTO `tb_support_module` VALUES ('123', '115', '4', '更新Pad客户端的推荐内容', '/recommendManager/updatePhoneRecommend.action', '更新Pad客户端的推荐内容', '1', '2013-01-10 14:51:39', '2013-01-10 14:51:39');
INSERT INTO `tb_support_module` VALUES ('124', '115', '4', '修改Pad客户端的推荐内容', '/recommendManager/editPadRecommend.action', '更新Pad客户端的推荐内容', '1', '2013-01-10 14:51:40', '2013-01-10 14:51:40');
INSERT INTO `tb_support_module` VALUES ('125', '115', '4', '更新Pad客户端修改后的推荐内容', '/recommendManager/updateRecommend.action', '更新Pad客户端修改后的推广内容', '1', '2013-01-10 14:51:40', '2013-01-10 14:51:40');
INSERT INTO `tb_support_module` VALUES ('126', '115', '4', '修改Pad客户端推荐内容的排序', '/recommendManager/updatePhoneRecommendSeq.action', '修改Pad客户端推荐内容的排序', '1', '2013-01-10 14:51:40', '2013-01-10 14:51:40');
INSERT INTO `tb_support_module` VALUES ('127', '115', '4', '删除Pad客户端的推荐内容', '/recommendManager/deletePhoneRecommend.action', '删除Pad客户端的推荐内容', '1', '2013-01-10 14:51:40', '2013-01-10 14:51:40');
INSERT INTO `tb_support_module` VALUES ('128', '115', '4', '更新Pad客户端推荐内容的上下线状态', '/recommendManager/updatePhonePubedStatus.action', '更新Pad客户端推荐内容的上下线状态', '1', '2013-01-10 14:51:40', '2013-01-10 14:51:40');
INSERT INTO `tb_support_module` VALUES ('129', '100', '3', 'PC客户端&网站', '/recommendManager/getPCRecommend.action', 'PC&WEB客户端推荐内容列表', '0', '2013-01-10 14:51:40', '2013-01-10 14:51:40');
INSERT INTO `tb_support_module` VALUES ('130', '129', '4', 'PC&WEB客户端推荐内容列表', '/recommendManager/getWebRecommend.action', 'PC&WEB客户端推荐内容列表', '1', '2013-01-10 14:51:40', '2013-01-10 14:51:40');
INSERT INTO `tb_support_module` VALUES ('131', '129', '4', '初始化增加PC&WEB客户端推荐页面', '/recommendManager/addPCRecommend.action', '初始化增加PC&WEB客户端推荐页面', '1', '2013-01-10 14:51:40', '2013-01-10 14:51:40');
INSERT INTO `tb_support_module` VALUES ('132', '129', '4', '上传图片', '/upload/uploadImg.action', '上传图片', '1', '2013-01-10 14:51:40', '2013-01-10 14:51:40');
INSERT INTO `tb_support_module` VALUES ('133', '129', '4', '初始化二级类目', '/recommendManager/initParentId.action', '初始化二级类目', '1', '2013-01-10 14:51:40', '2013-01-10 14:51:40');
INSERT INTO `tb_support_module` VALUES ('134', '129', '4', '查找三级类目', '/search/searchCategoryJson.action', '查找三级类目', '1', '2013-01-10 14:51:41', '2013-01-10 14:51:41');
INSERT INTO `tb_support_module` VALUES ('135', '129', '4', '新增PC&WEB客户端推荐内容', '/recommendManager/doAddRecommend.action', '新增PC&WEB客户端推荐内容', '1', '2013-01-10 14:51:41', '2013-01-10 14:51:41');
INSERT INTO `tb_support_module` VALUES ('136', '129', '4', '更新推广内容的排序', '/recommendManager/updateRecommendSeq.action', '修改推广内容的排序', '1', '2013-01-10 14:51:41', '2013-01-10 14:51:41');
INSERT INTO `tb_support_module` VALUES ('137', '129', '4', '更新推广内容的上下线状态', '/recommendManager/updateRecommendPub.action', '更新推广内容的上下线状态', '1', '2013-01-10 14:51:41', '2013-01-10 14:51:41');
INSERT INTO `tb_support_module` VALUES ('138', '129', '4', '初始化编辑推广内容', '/recommendManager/editPCRecommend.action', '初始化编辑PC&WEB推广内容页', '1', '2013-01-10 14:51:41', '2013-01-10 14:51:41');
INSERT INTO `tb_support_module` VALUES ('139', '129', '4', '删除推广内容', '/recommendManager/deleteRecommend.action', '删除推广内容', '1', '2013-01-10 14:51:41', '2013-01-10 14:51:41');
INSERT INTO `tb_support_module` VALUES ('140', '129', '4', '更新推广内容', '/recommendManager/updateWebRecommend.action', '更新推广内容', '1', '2013-01-10 14:51:41', '2013-01-10 14:51:41');
INSERT INTO `tb_support_module` VALUES ('141', '4', '2', '排行榜管理', '/rankingManager/getRankingList.action', '排行榜管理', '0', '2013-01-10 14:51:41', '2013-01-10 14:51:41');
INSERT INTO `tb_support_module` VALUES ('144', '141', '3', '更新排行榜中应用的锁定状态', '/rankingManager/updateRankingLocked.action', '更新排行榜中应用的位置锁定状态', '1', '2013-01-10 14:51:41', '2013-01-10 14:51:41');
INSERT INTO `tb_support_module` VALUES ('145', '141', '3', '修改排行榜的排序', '/rankingManager/updateRankingSeq.action', '修改排行榜中的排序顺序', '1', '2013-01-10 14:51:41', '2013-01-10 14:51:41');
INSERT INTO `tb_support_module` VALUES ('146', '141', '3', '初始化排行榜编辑页面', '/rankingManager/editRanking.action', '初始化排行榜编辑页面', '1', '2013-01-10 14:51:42', '2013-01-10 14:51:42');
INSERT INTO `tb_support_module` VALUES ('147', '141', '3', '搜索排行榜中的应用', '/search/SearchRankingApp.action', '搜索排行榜中的应用', '1', '2013-01-10 14:51:42', '2013-01-10 14:51:42');
INSERT INTO `tb_support_module` VALUES ('148', '141', '3', '更新排行榜内容', '/rankingManager/updateRanking.action', '更新排行榜内容', '1', '2013-01-10 14:51:42', '2013-01-10 14:51:42');
INSERT INTO `tb_support_module` VALUES ('149', '4', '2', '专题管理', '/topicManager/getTopicListByPub.action', '获取专题列表', '0', '2013-01-10 14:51:42', '2013-01-10 14:51:42');
INSERT INTO `tb_support_module` VALUES ('150', '149', '3', '初始化增加专题页面', '/topicManager/addTopic.action', '初始化增加专题页面', '1', '2013-01-10 14:51:42', '2013-01-10 14:51:42');
INSERT INTO `tb_support_module` VALUES ('151', '149', '3', '上传图片', '/upload/uploadImg.action', '上传图片', '1', '2013-01-10 14:51:42', '2013-01-10 14:51:42');
INSERT INTO `tb_support_module` VALUES ('152', '149', '3', '新增专题', '/topicManager/doAddTopic.action', '新增专题', '1', '2013-01-10 14:51:42', '2013-01-10 14:51:42');
INSERT INTO `tb_support_module` VALUES ('153', '149', '3', '搜索应用', '/search/SearchApp.action', '搜索应用', '1', '2013-01-10 14:51:42', '2013-01-10 14:51:42');
INSERT INTO `tb_support_module` VALUES ('154', '149', '3', '更新专题的排序', '/topicManager/updateTopicSeq.action', '更新专题的排序', '1', '2013-01-10 14:51:42', '2013-01-10 14:51:42');
INSERT INTO `tb_support_module` VALUES ('155', '149', '3', '更新专题的上下线状态', '/topicManager/updateTopicPubedStatus.action', '更新专题的上下线状态', '1', '2013-01-10 14:51:42', '2013-01-10 14:51:42');
INSERT INTO `tb_support_module` VALUES ('156', '149', '3', '删除专题', '/topicManager/deleteTopic.action', '删除专题', '1', '2013-01-10 14:51:42', '2013-01-10 14:51:42');
INSERT INTO `tb_support_module` VALUES ('157', '149', '3', '初始化编辑专题页面', '/topicManager/editTopic.action', '初始化编辑专题页面', '1', '2013-01-10 14:51:43', '2013-01-10 14:51:43');
INSERT INTO `tb_support_module` VALUES ('158', '149', '3', '移除专题中的关联应用', '/topicManager/deleteTopicAppById.action', '移除专题中的关联应用', '1', '2013-01-10 14:51:43', '2013-01-10 14:51:43');
INSERT INTO `tb_support_module` VALUES ('159', '149', '3', '更新专题内容', '/topicManager/updateTopic.action', '更新专题内容', '1', '2013-01-10 14:51:43', '2013-01-10 14:51:43');
INSERT INTO `tb_support_module` VALUES ('160', '149', '3', '更新专题的排序', '/topicManager/updateTopicAppSeq.action', '更新专题的排序', '1', '2013-01-10 14:51:43', '2013-01-10 14:51:43');
INSERT INTO `tb_support_module` VALUES ('161', '4', '2', '资讯管理', '/noticeManager/getNoticeListByPub.action', '资讯管理', '0', '2013-01-10 14:51:43', '2013-01-10 14:51:43');
INSERT INTO `tb_support_module` VALUES ('162', '161', '3', '新增资讯', '/noticeManager/doAddNotice.action', '新增资讯', '1', '2013-01-10 14:51:43', '2013-01-10 14:51:43');
INSERT INTO `tb_support_module` VALUES ('163', '161', '3', '初始化编辑资讯页面', '/noticeManager/findNoticeById.action', '初始化编辑资讯页面', '1', '2013-01-10 14:51:43', '2013-01-10 14:51:43');
INSERT INTO `tb_support_module` VALUES ('164', '161', '3', '更新资讯', '/noticeManager/updateNotice.action', '更新资讯', '1', '2013-01-10 14:51:43', '2013-01-10 14:51:43');
INSERT INTO `tb_support_module` VALUES ('165', '161', '3', '更新资讯的上下线状态', '/noticeManager/updateNoticePubedStatus.action', '更新资讯的上下线状态', '1', '2013-01-10 14:51:43', '2013-01-10 14:51:43');
INSERT INTO `tb_support_module` VALUES ('166', '161', '3', '初始化编辑资讯页面', '/noticeManager/findNoticeById.action', '初始化编辑资讯页面', '1', '2013-01-10 14:51:43', '2013-01-10 14:51:43');
INSERT INTO `tb_support_module` VALUES ('167', '161', '3', '删除资讯', '/noticeManager/deleteNotice.action', '删除资讯', '1', '2013-01-10 14:51:43', '2013-01-10 14:51:43');
INSERT INTO `tb_support_module` VALUES ('168', '4', '2', '热门搜索列表', '/hotWordManager/getHotWords.action', '热门搜索列表', '0', '2013-01-10 14:51:44', '2013-01-10 14:51:44');
INSERT INTO `tb_support_module` VALUES ('169', '168', '3', '初始化增加热门搜索页面', '/hotWordManager/addHotWords.action', '初始化增加热门搜索页面', '1', '2013-01-10 14:51:44', '2013-01-10 14:51:44');
INSERT INTO `tb_support_module` VALUES ('170', '168', '3', '初始化编辑热门搜索页面', '/hotWordManager/editHotWord.action', '初始化编辑热门搜索页面', '1', '2013-01-10 14:51:44', '2013-01-10 14:51:44');
INSERT INTO `tb_support_module` VALUES ('171', '168', '3', '更新热门搜索的排序', '/hotWordManager/updateHotWordSeq.action', '更新热门搜索的排序', '1', '2013-01-10 14:51:44', '2013-01-10 14:51:44');
INSERT INTO `tb_support_module` VALUES ('172', '168', '3', '更新热门搜索的上下线状态', '/hotWordManager/updateHotWordPublished.action', '更新热门搜索的上下线状态', '1', '2013-01-10 14:51:44', '2013-01-10 14:51:44');
INSERT INTO `tb_support_module` VALUES ('173', '168', '3', '删除热门搜索', '/hotWordManager/deleteHotWord.action', '删除热门搜索词', '1', '2013-01-10 14:51:44', '2013-01-10 14:51:44');
INSERT INTO `tb_support_module` VALUES ('174', '168', '3', '新增热门搜索词', '/hotWordManager/doAddHotWord.action', '新增热门搜索词', '1', '2013-01-10 14:51:44', '2013-01-10 14:51:44');
INSERT INTO `tb_support_module` VALUES ('175', '168', '3', '更新热门搜索词', '/hotWordManager/updateHotWord.action', '更新热门搜索词', '1', '2013-01-10 14:51:44', '2013-01-10 14:51:44');
INSERT INTO `tb_support_module` VALUES ('176', '7', '2', '客户端版本管理', '/versionManager/loadVersionList.action', '客户端版本管理', '0', '2013-01-10 14:51:44', '2013-01-10 14:51:44');
INSERT INTO `tb_support_module` VALUES ('177', '176', '3', '获取客户端版本列表', '/versionManager/getVersionList.action', '获取客户端版本列表', '1', '2013-01-10 14:51:44', '2013-01-10 14:51:44');
INSERT INTO `tb_support_module` VALUES ('178', '176', '3', '新增版本', '/versionManager/addClientVersion.action', '新增版本', '1', '2013-01-10 14:51:45', '2013-01-10 14:51:45');
INSERT INTO `tb_support_module` VALUES ('179', '176', '3', '初始化编辑版本页面', '/versionManager/editClientVersion.action', '初始化编辑版本页面', '1', '2013-01-10 14:51:45', '2013-01-10 14:51:45');
INSERT INTO `tb_support_module` VALUES ('180', '176', '3', '删除版本', '/versionManager/deleteClientVersion.action', '删除版本', '1', '2013-01-10 14:51:45', '2013-01-10 14:51:45');
INSERT INTO `tb_support_module` VALUES ('181', '176', '3', '更新版本可用状态', '/versionManager/updateClientVersionValid.action', '更新版本可用状态', '1', '2013-01-10 14:51:45', '2013-01-10 14:51:45');
INSERT INTO `tb_support_module` VALUES ('182', '176', '3', '上传版本', '/upload/uploadClientVersion.action', '上传版本', '1', '2013-01-10 14:51:45', '2013-01-10 14:51:45');
INSERT INTO `tb_support_module` VALUES ('183', '176', '3', '更新版本', '/versionManager/updateClientVersion.action', '更新版本', '1', '2013-01-10 14:51:45', '2013-01-10 14:51:45');
INSERT INTO `tb_support_module` VALUES ('184', '7', '2', '初始化批量上传页面', '/versionManager/loadVersionList.action', '初始化批量上传页面', '0', '2013-01-10 14:51:45', '2013-01-10 14:51:45');
INSERT INTO `tb_support_module` VALUES ('185', '184', '3', '上传Excel', '/bulkUpload/uploadExcel.action', '上传Excel', '1', '2013-01-10 14:51:45', '2013-01-10 14:51:45');
INSERT INTO `tb_support_module` VALUES ('186', '184', '3', '初始化上传页面', '/bulkUpload/load.action', '初始化上传页面', '1', '2013-01-10 14:51:45', '2013-01-10 14:51:45');
INSERT INTO `tb_support_module` VALUES ('187', '101', '4', '增加版位', '/recommendManager/doAddHomeAreaType.action', '增加版位', '1', '2013-01-10 14:51:45', '2013-01-10 14:51:45');
INSERT INTO `tb_support_module` VALUES ('188', '115', '4', '增加版位', '/recommendManager/doAddPadHomeAreaType.action', '增加版位', '1', '2013-01-10 14:51:45', '2013-01-10 14:51:45');
INSERT INTO `tb_support_module` VALUES ('189', '11', '3', '批量上传', '/bulkUpload/bulkUploadStart.action', '批量上传', '0', '2013-01-10 14:51:46', '2013-01-10 14:51:46');
INSERT INTO `tb_support_module` VALUES ('190', '7', '2', '问题反馈', '/feedBack/findfeedBackList.action', '问题反馈', '0', '2013-01-10 14:51:46', '2013-01-10 14:51:46');
INSERT INTO `tb_support_module` VALUES ('192', '190', '3', '删除问题反馈', '/feedBack/delFeedBack.action', '删除问题反馈', '1', '2013-01-10 14:51:46', '2013-01-10 14:51:46');
INSERT INTO `tb_support_module` VALUES ('193', '176', '4', '增加版本', '/versionManager/doAddClientVersion.action', '增加版本', '1', '2013-01-10 14:51:46', '2013-01-10 14:51:46');
INSERT INTO `tb_support_module` VALUES ('194', '149', '3', '', '/topicManager/addTopicApp.action', '增加专题关联应用', '1', '2013-01-10 14:51:46', '2013-01-10 14:51:46');
INSERT INTO `tb_support_module` VALUES ('195', '10', '3', '打开更新类目描述页', '/categoryMaintenance/updateCategoryIntro.action', '打开更新类目描述页', '1', '2013-01-10 14:51:46', '2013-01-10 14:51:46');
INSERT INTO `tb_support_module` VALUES ('196', '10', '3', '更新类目描述', '/categoryMaintenance/doUpdateCategoryIntro.action', '更新类目描述', '1', '2013-01-10 14:51:46', '2013-01-10 14:51:46');
INSERT INTO `tb_support_module` VALUES ('197', '7', '2', '获取设备管理列表', '/driverManager/findAndroidDriver.action', '获取设备管理列表', '0', '2013-01-10 14:51:46', '2013-01-10 14:51:46');
INSERT INTO `tb_support_module` VALUES ('198', '197', '3', '删除设备信息', '/driverManager/deleteAndroidDriver.action', '删除设备信息', '1', '2013-01-10 14:51:46', '2013-01-10 14:51:46');
INSERT INTO `tb_support_module` VALUES ('199', '197', '3', '增加设备信息', '/driverManager/addAndroidDriver.action', '增加设备信息', '1', '2013-01-10 14:51:46', '2013-01-10 14:51:46');
INSERT INTO `tb_support_module` VALUES ('200', '197', '3', '确认增加设备信息', '/driverManager/doAddAndroidDriver.action', '确认增加设备信息', '1', '2013-01-10 14:51:46', '2013-01-10 14:51:46');
INSERT INTO `tb_support_module` VALUES ('201', '197', '3', '上传驱动包', '/upload/uploadClientVersion.action', '上传驱动', '1', '2013-01-10 14:51:47', '2013-01-10 14:51:47');
INSERT INTO `tb_support_module` VALUES ('202', '197', '3', '初始化编辑设备信息页面', '/driverManager/findAndroidDriverById.action', '初始化编辑设备信息页面', '1', '2013-01-10 14:51:47', '2013-01-10 14:51:47');
INSERT INTO `tb_support_module` VALUES ('203', '101', '4', '初始化二级类目', '/recommendManager/initWebParentId.action', '初始化二级类目', '1', '2013-01-10 14:51:47', '2013-01-10 14:51:47');
INSERT INTO `tb_support_module` VALUES ('204', '197', '3', '下载驱动', '/driverManager/downloadDriver.action', '下载驱动', '1', '2013-01-10 14:51:47', '2013-01-10 14:51:47');
INSERT INTO `tb_support_module` VALUES ('205', '73', '4', '浏览移动应用下载获取token', '/appBrowse/getToken.action', '浏览应用下载获取token', '1', '2013-01-10 14:51:47', '2013-01-10 14:51:47');
INSERT INTO `tb_support_module` VALUES ('206', '75', '4', '审核移动应用下载获取token', '/appManagement/getToken.action', '审核应用下载获取token', '1', '2013-01-10 14:51:47', '2013-01-10 14:51:47');
INSERT INTO `tb_support_module` VALUES ('207', '74', '4', '浏览网页应用下载获取token', '/appBrowse/getToken.action', '浏览网页应用下载获取token', '1', '2013-01-10 14:51:47', '2013-01-10 14:51:47');
INSERT INTO `tb_support_module` VALUES ('208', '76', '4', '审核网页应用下载获取token', '/appManagement/getToken.action', '审核网页应用下载获取token', '1', '2013-01-10 14:51:47', '2013-01-10 14:51:47');
INSERT INTO `tb_support_module` VALUES ('209', '115', '4', '搜索应用', '/search/SearchAppForTopic.action', '搜索应用', '1', '2013-01-10 14:51:47', '2013-01-10 14:51:47');
INSERT INTO `tb_support_module` VALUES ('210', '100', '3', 'CP首页系统推荐', '/recommendManager/getCPServer.action', 'CP首页推荐', '0', '2013-01-10 14:51:47', '2013-01-10 14:51:47');
INSERT INTO `tb_support_module` VALUES ('211', '100', '3', '新增CP推荐', '/recommendManager/addCPRecommend.action', '新增首页推荐', '1', '2013-01-10 14:51:47', '2013-01-10 14:51:47');
INSERT INTO `tb_support_module` VALUES ('212', '100', '4', '确认新增CP推荐', '/recommendManager/doAddCPRecommend.action', '确认新增CP推荐', '1', '2013-01-10 14:51:48', '2013-01-10 14:51:48');
INSERT INTO `tb_support_module` VALUES ('213', '100', '3', '编辑CP推荐', '/recommendManager/editCPRecommend.action', '编辑CP推荐', '1', '2013-01-10 14:51:48', '2013-01-10 14:51:48');
INSERT INTO `tb_support_module` VALUES ('214', '100', '3', '更新CP推荐', '/recommendManager/updateCPRecommend.action', '更新CP推荐', '1', '2013-01-10 14:51:48', '2013-01-10 14:51:48');
INSERT INTO `tb_support_module` VALUES ('215', '101', '4', '查找应用', '/search/SearchAppForMobile.action', '查找应用', '1', '2013-01-10 14:51:48', '2013-01-10 14:51:48');
INSERT INTO `tb_support_module` VALUES ('216', '101', '4', '查找应用', '/search/SearchAppForSoft.action', '查找应用', '1', '2013-01-10 14:51:48', '2013-01-10 14:51:48');
INSERT INTO `tb_support_module` VALUES ('217', '101', '4', '查找应用', '/search/SearchAppForGame.action', '查找应用', '1', '2013-01-10 14:51:48', '2013-01-10 14:51:48');
INSERT INTO `tb_support_module` VALUES ('218', '101', '4', '查找应用', '/search/SearchAppForWeb.action', '查找应用', '1', '2013-01-10 14:51:48', '2013-01-10 14:51:48');
INSERT INTO `tb_support_module` VALUES ('219', '189', '4', '查找CP', '/bulkUpload/findCPList.action', '查找CP', '1', '2013-01-10 14:51:48', '2013-01-10 14:51:48');
INSERT INTO `tb_support_module` VALUES ('220', '189', '4', '更新导入日志表', '/bulkUpload/updateImport.action', '更新导入日志表', '1', '2013-01-10 14:51:48', '2013-01-10 14:51:48');
INSERT INTO `tb_support_module` VALUES ('221', '189', '4', '忽略上传', '/bulkUpload/deleteImportLog.action', '忽略上传', '1', '2013-01-10 14:51:48', '2013-01-10 14:51:48');
INSERT INTO `tb_support_module` VALUES ('222', '197', '4', '更新驱动', '/driverManager/updateAndroidDriver.action', '更新驱动', '1', '2013-01-10 14:51:48', '2013-01-10 14:51:48');
INSERT INTO `tb_support_module` VALUES ('223', '161', '3', '更新资讯排序', '/noticeManager/updateNoticeSeq.action', '更新资讯排序', '1', '2013-01-10 14:51:49', '2013-01-10 14:51:49');
INSERT INTO `tb_support_module` VALUES ('224', '3', '2', '数据统计', '/appStatistics/appStatistics.action', '应用管理-数据统计', '0', '2013-01-10 14:51:49', '2013-01-10 14:51:49');
INSERT INTO `tb_support_module` VALUES ('225', '224', '3', '全站数据统计', '/appStatistics/getDownload.action', '应用管理-数据统计-全站数据统计', '1', '2013-01-10 14:51:49', '2013-01-10 14:51:49');
INSERT INTO `tb_support_module` VALUES ('226', '224', '3', '全站数据按日期统计', '/appStatistics/allStatisticsCount.action', '应用管理-数据统计-全站数据按日期统计', '1', '2013-01-10 14:51:49', '2013-01-10 14:51:49');
INSERT INTO `tb_support_module` VALUES ('227', '224', '3', '应用数据按日期统计', '/appStatistics/findAppStatisticsByDate.action', '应用管理-数据统计-应用数据按日期统计', '1', '2013-01-10 14:51:49', '2013-01-10 14:51:49');
INSERT INTO `tb_support_module` VALUES ('228', '224', '3', 'top数据按日期统计', '/appStatistics/findTopAppStatisticsByDate.action', '应用管理-数据统计-top数据按日期统计', '1', '2013-01-10 14:51:49', '2013-01-10 14:51:49');
INSERT INTO `tb_support_module` VALUES ('229', '75', '4', '批量基本信息同步', '/appManagement/syncAllAppBaseInfo.action', '批量基本信息同步', '1', '2013-01-10 14:51:49', '2013-01-10 14:51:49');
INSERT INTO `tb_support_module` VALUES ('230', '10', '3', '添加类目', '/categoryMaintenance/addCategory.action', '添加类目', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('231', '10', '3', '保存类目', '/categoryMaintenance/saveCategory.action', '保存类目', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('232', '10', '3', '删除类目', '/categoryMaintenance/deleteCategory.action', '删除类目', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('233', '1', '2', 'PAD渠道管理', '', 'PAD渠道管理', '0', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('234', '233', '3', 'PAD渠道维护', '/cpQualityManagement/findPadChannel.action', 'PAD渠道维护', '0', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('235', '234', '4', '添加渠道', '/cpQualityManagement/addPadChannel.action', '添加渠道', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('236', '234', '4', '保存渠道', '/cpQualityManagement/savePadChannel.action', '保存渠道', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('237', '234', '4', '删除渠道', '/cpQualityManagement/deletePadChannel.action', '删除渠道', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('238', '234', '4', '修改渠道', '/cpQualityManagement/modifyChannel.action', '修改渠道', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('239', '234', '4', '保存修改渠道', '/cpQualityManagement/updatePadChannel.action', '保存渠道', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('240', '234', '4', '关联CP', '/cpQualityManagement/relevanceCp.action', '关联CP', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('241', '234', '4', '保存渠道关联CP', '/cpQualityManagement/createRelevanceCp.action', '保存渠道关联CP', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('242', '148', '3', '专题关联渠道', '/topicManager/padRelevanceTopic.action', '专题关联渠道', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('243', '148', '3', '保存专题关联渠道', '/topicManager/saveRelenvanceTopic.action', '保存专题关联渠道', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('244', '75', '4', '卓望全量数据同步', '/bulkUpload/zhuoWangApp.action', '卓望全量数据同步', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('245', '3', '2', '营销统计', '/marketStatistics/marketStatistics.action', '营销统计', '0', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('246', '245', '3', '按应用统计安装次数', '/marketStatistics/getMarketStatisticsByApps.action', '按应用统计安装次数', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('247', '245', '3', '应用按渠道统计安装次数', '/marketStatistics/appGetMarketStatByChannel.action', '应用按渠道统计安装次数', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('248', '245', '3', '按应用查看', '/marketStatistics/statByApp.action', '按应用查看', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('249', '245', '3', '应用每个渠道下按促销员查看', '/marketStatistics/appStatsChannelBySaler.action', '应用每个渠道下按促销员查看', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('250', '245', '3', '按渠道查看', '/marketStatistics/statByChannel.action', '按渠道查看', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('250', '245', '3', '按渠道查看', '/marketStatistics/statChannelByApps.action', '按渠道查看', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('251', '245', '3', '渠道下按应用查看', '/marketStatistics/statChannelByApps.action', '渠道下按应用查看', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('252', '245', '3', '渠道下按促销员查看安装次数', '/marketStatistics/channlStatBySaler.action', '渠道下按促销员查看安装次数', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('253', '245', '3', '促销员按应用查看安装次数', '/marketStatistics/salerStatsByApps.action', '促销员按应用查看安装次数', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('254', '245', '3', '导出下载统计报表', '/marketStatistics/exportExcel.action', '导出下载统计报表', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');

-- ----------------------------
-- Table structure for `tb_support_role`
-- ----------------------------
DROP TABLE IF EXISTS `tb_support_role`;
CREATE TABLE `tb_support_role` (
  `roleid` int(11) NOT NULL,
  `role_name` varchar(20) DEFAULT NULL,
  `created` datetime DEFAULT '1970-01-01 00:00:00',
  `modified` datetime DEFAULT '1970-01-01 00:00:00',
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_support_role
-- ----------------------------
INSERT INTO `tb_support_role` VALUES ('1', 'admin', '2013-01-10 14:51:59', '2013-01-23 14:05:50');

-- ----------------------------
-- Table structure for `tb_support_role_module`
-- ----------------------------
DROP TABLE IF EXISTS `tb_support_role_module`;
CREATE TABLE `tb_support_role_module` (
  `id` int(11) NOT NULL,
  `roleid` int(11) NOT NULL,
  `moduleid` int(11) NOT NULL,
  `created` datetime DEFAULT '1970-01-01 00:00:00',
  `modified` datetime DEFAULT '1970-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_support_role_module
-- ----------------------------
INSERT INTO `tb_support_role_module` VALUES ('301', '1', '1', '2013-01-23 14:05:50', '2013-01-23 14:05:50');
INSERT INTO `tb_support_role_module` VALUES ('302', '1', '41', '2013-01-23 14:05:50', '2013-01-23 14:05:50');
INSERT INTO `tb_support_role_module` VALUES ('303', '1', '43', '2013-01-23 14:05:50', '2013-01-23 14:05:50');
INSERT INTO `tb_support_role_module` VALUES ('304', '1', '45', '2013-01-23 14:05:50', '2013-01-23 14:05:50');
INSERT INTO `tb_support_role_module` VALUES ('305', '1', '47', '2013-01-23 14:05:50', '2013-01-23 14:05:50');
INSERT INTO `tb_support_role_module` VALUES ('306', '1', '48', '2013-01-23 14:05:50', '2013-01-23 14:05:50');
INSERT INTO `tb_support_role_module` VALUES ('307', '1', '42', '2013-01-23 14:05:50', '2013-01-23 14:05:50');
INSERT INTO `tb_support_role_module` VALUES ('308', '1', '44', '2013-01-23 14:05:50', '2013-01-23 14:05:50');
INSERT INTO `tb_support_role_module` VALUES ('309', '1', '46', '2013-01-23 14:05:50', '2013-01-23 14:05:50');
INSERT INTO `tb_support_role_module` VALUES ('310', '1', '49', '2013-01-23 14:05:50', '2013-01-23 14:05:50');
INSERT INTO `tb_support_role_module` VALUES ('311', '1', '50', '2013-01-23 14:05:50', '2013-01-23 14:05:50');
INSERT INTO `tb_support_role_module` VALUES ('312', '1', '51', '2013-01-23 14:05:50', '2013-01-23 14:05:50');
INSERT INTO `tb_support_role_module` VALUES ('313', '1', '233', '2013-01-23 14:05:50', '2013-01-23 14:05:50');
INSERT INTO `tb_support_role_module` VALUES ('314', '1', '234', '2013-01-23 14:05:50', '2013-01-23 14:05:50');
INSERT INTO `tb_support_role_module` VALUES ('315', '1', '2', '2013-01-23 14:05:50', '2013-01-23 14:05:50');
INSERT INTO `tb_support_role_module` VALUES ('316', '1', '52', '2013-01-23 14:05:50', '2013-01-23 14:05:50');
INSERT INTO `tb_support_role_module` VALUES ('317', '1', '54', '2013-01-23 14:05:50', '2013-01-23 14:05:50');
INSERT INTO `tb_support_role_module` VALUES ('318', '1', '56', '2013-01-23 14:05:50', '2013-01-23 14:05:50');
INSERT INTO `tb_support_role_module` VALUES ('319', '1', '58', '2013-01-23 14:05:50', '2013-01-23 14:05:50');
INSERT INTO `tb_support_role_module` VALUES ('320', '1', '60', '2013-01-23 14:05:50', '2013-01-23 14:05:50');
INSERT INTO `tb_support_role_module` VALUES ('321', '1', '62', '2013-01-23 14:05:50', '2013-01-23 14:05:50');
INSERT INTO `tb_support_role_module` VALUES ('322', '1', '64', '2013-01-23 14:05:50', '2013-01-23 14:05:50');
INSERT INTO `tb_support_role_module` VALUES ('323', '1', '68', '2013-01-23 14:05:50', '2013-01-23 14:05:50');
INSERT INTO `tb_support_role_module` VALUES ('324', '1', '69', '2013-01-23 14:05:50', '2013-01-23 14:05:50');
INSERT INTO `tb_support_role_module` VALUES ('325', '1', '70', '2013-01-23 14:05:50', '2013-01-23 14:05:50');
INSERT INTO `tb_support_role_module` VALUES ('326', '1', '53', '2013-01-23 14:05:50', '2013-01-23 14:05:50');
INSERT INTO `tb_support_role_module` VALUES ('327', '1', '55', '2013-01-23 14:05:50', '2013-01-23 14:05:50');
INSERT INTO `tb_support_role_module` VALUES ('328', '1', '57', '2013-01-23 14:05:50', '2013-01-23 14:05:50');
INSERT INTO `tb_support_role_module` VALUES ('329', '1', '59', '2013-01-23 14:05:50', '2013-01-23 14:05:50');
INSERT INTO `tb_support_role_module` VALUES ('330', '1', '61', '2013-01-23 14:05:50', '2013-01-23 14:05:50');
INSERT INTO `tb_support_role_module` VALUES ('331', '1', '63', '2013-01-23 14:05:50', '2013-01-23 14:05:50');
INSERT INTO `tb_support_role_module` VALUES ('332', '1', '65', '2013-01-23 14:05:50', '2013-01-23 14:05:50');
INSERT INTO `tb_support_role_module` VALUES ('333', '1', '66', '2013-01-23 14:05:50', '2013-01-23 14:05:50');
INSERT INTO `tb_support_role_module` VALUES ('334', '1', '67', '2013-01-23 14:05:50', '2013-01-23 14:05:50');
INSERT INTO `tb_support_role_module` VALUES ('335', '1', '3', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('336', '1', '71', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('337', '1', '73', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('338', '1', '79', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('339', '1', '87', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('340', '1', '89', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('341', '1', '91', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('342', '1', '93', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('343', '1', '95', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('344', '1', '98', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('345', '1', '205', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('346', '1', '74', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('347', '1', '80', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('348', '1', '88', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('349', '1', '90', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('350', '1', '92', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('351', '1', '96', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('352', '1', '99', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('353', '1', '207', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('354', '1', '97', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('355', '1', '72', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('356', '1', '75', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('357', '1', '77', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('358', '1', '81', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('359', '1', '83', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('360', '1', '85', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('361', '1', '206', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('362', '1', '229', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('363', '1', '76', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('364', '1', '78', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('365', '1', '82', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('366', '1', '84', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('367', '1', '86', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('368', '1', '208', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('369', '1', '94', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('370', '1', '224', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('371', '1', '225', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('372', '1', '226', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('373', '1', '227', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('374', '1', '228', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('375', '1', '4', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('376', '1', '100', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('377', '1', '101', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('378', '1', '102', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('379', '1', '103', '2013-01-23 14:05:51', '2013-01-23 14:05:51');
INSERT INTO `tb_support_role_module` VALUES ('380', '1', '104', '2013-01-23 14:05:52', '2013-01-23 14:05:52');
INSERT INTO `tb_support_role_module` VALUES ('381', '1', '105', '2013-01-23 14:05:52', '2013-01-23 14:05:52');
INSERT INTO `tb_support_role_module` VALUES ('382', '1', '106', '2013-01-23 14:05:52', '2013-01-23 14:05:52');
INSERT INTO `tb_support_role_module` VALUES ('383', '1', '107', '2013-01-23 14:05:52', '2013-01-23 14:05:52');
INSERT INTO `tb_support_role_module` VALUES ('384', '1', '108', '2013-01-23 14:05:52', '2013-01-23 14:05:52');
INSERT INTO `tb_support_role_module` VALUES ('385', '1', '109', '2013-01-23 14:05:52', '2013-01-23 14:05:52');
INSERT INTO `tb_support_role_module` VALUES ('386', '1', '110', '2013-01-23 14:05:52', '2013-01-23 14:05:52');
INSERT INTO `tb_support_role_module` VALUES ('387', '1', '111', '2013-01-23 14:05:52', '2013-01-23 14:05:52');
INSERT INTO `tb_support_role_module` VALUES ('388', '1', '112', '2013-01-23 14:05:52', '2013-01-23 14:05:52');
INSERT INTO `tb_support_role_module` VALUES ('389', '1', '113', '2013-01-23 14:05:52', '2013-01-23 14:05:52');
INSERT INTO `tb_support_role_module` VALUES ('390', '1', '114', '2013-01-23 14:05:52', '2013-01-23 14:05:52');
INSERT INTO `tb_support_role_module` VALUES ('391', '1', '187', '2013-01-23 14:05:52', '2013-01-23 14:05:52');
INSERT INTO `tb_support_role_module` VALUES ('392', '1', '203', '2013-01-23 14:05:52', '2013-01-23 14:05:52');
INSERT INTO `tb_support_role_module` VALUES ('393', '1', '215', '2013-01-23 14:05:52', '2013-01-23 14:05:52');
INSERT INTO `tb_support_role_module` VALUES ('394', '1', '216', '2013-01-23 14:05:52', '2013-01-23 14:05:52');
INSERT INTO `tb_support_role_module` VALUES ('395', '1', '217', '2013-01-23 14:05:52', '2013-01-23 14:05:52');
INSERT INTO `tb_support_role_module` VALUES ('396', '1', '218', '2013-01-23 14:05:52', '2013-01-23 14:05:52');
INSERT INTO `tb_support_role_module` VALUES ('397', '1', '115', '2013-01-23 14:05:52', '2013-01-23 14:05:52');
INSERT INTO `tb_support_role_module` VALUES ('398', '1', '116', '2013-01-23 14:05:52', '2013-01-23 14:05:52');
INSERT INTO `tb_support_role_module` VALUES ('399', '1', '117', '2013-01-23 14:05:52', '2013-01-23 14:05:52');
INSERT INTO `tb_support_role_module` VALUES ('400', '1', '118', '2013-01-23 14:05:52', '2013-01-23 14:05:52');
INSERT INTO `tb_support_role_module` VALUES ('401', '1', '119', '2013-01-23 14:05:52', '2013-01-23 14:05:52');
INSERT INTO `tb_support_role_module` VALUES ('402', '1', '120', '2013-01-23 14:05:52', '2013-01-23 14:05:52');
INSERT INTO `tb_support_role_module` VALUES ('403', '1', '121', '2013-01-23 14:05:52', '2013-01-23 14:05:52');
INSERT INTO `tb_support_role_module` VALUES ('404', '1', '122', '2013-01-23 14:05:52', '2013-01-23 14:05:52');
INSERT INTO `tb_support_role_module` VALUES ('405', '1', '123', '2013-01-23 14:05:52', '2013-01-23 14:05:52');
INSERT INTO `tb_support_role_module` VALUES ('406', '1', '124', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('407', '1', '125', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('408', '1', '126', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('409', '1', '127', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('410', '1', '128', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('411', '1', '188', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('412', '1', '209', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('413', '1', '129', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('414', '1', '130', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('415', '1', '131', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('416', '1', '132', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('417', '1', '133', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('418', '1', '134', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('419', '1', '135', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('420', '1', '136', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('421', '1', '137', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('422', '1', '138', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('423', '1', '139', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('424', '1', '140', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('425', '1', '210', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('426', '1', '211', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('427', '1', '212', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('428', '1', '213', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('429', '1', '214', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('430', '1', '141', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('431', '1', '144', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('432', '1', '145', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('433', '1', '146', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('434', '1', '147', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('435', '1', '148', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('436', '1', '149', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('437', '1', '150', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('438', '1', '151', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('439', '1', '152', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('440', '1', '153', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('441', '1', '154', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('442', '1', '155', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('443', '1', '156', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('444', '1', '157', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('445', '1', '158', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('446', '1', '159', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('447', '1', '160', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('448', '1', '194', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('449', '1', '161', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('450', '1', '162', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('451', '1', '163', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('452', '1', '164', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('453', '1', '165', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('454', '1', '166', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('455', '1', '167', '2013-01-23 14:05:53', '2013-01-23 14:05:53');
INSERT INTO `tb_support_role_module` VALUES ('456', '1', '223', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('457', '1', '168', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('458', '1', '169', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('459', '1', '170', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('460', '1', '171', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('461', '1', '172', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('462', '1', '173', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('463', '1', '174', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('464', '1', '175', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('465', '1', '6', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('466', '1', '8', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('467', '1', '17', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('468', '1', '18', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('469', '1', '19', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('470', '1', '20', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('471', '1', '21', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('472', '1', '22', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('473', '1', '23', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('474', '1', '24', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('475', '1', '9', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('476', '1', '25', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('477', '1', '26', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('478', '1', '27', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('479', '1', '28', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('480', '1', '29', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('481', '1', '30', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('482', '1', '7', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('483', '1', '10', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('484', '1', '31', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('485', '1', '36', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('486', '1', '195', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('487', '1', '196', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('488', '1', '230', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('489', '1', '231', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('490', '1', '232', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('491', '1', '11', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('492', '1', '15', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('493', '1', '37', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('494', '1', '38', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('495', '1', '39', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('496', '1', '16', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('497', '1', '40', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('498', '1', '189', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('499', '1', '219', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('500', '1', '220', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('501', '1', '221', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('502', '1', '176', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('503', '1', '177', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('504', '1', '178', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('505', '1', '179', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('506', '1', '180', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('507', '1', '181', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('508', '1', '182', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('509', '1', '183', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('510', '1', '193', '2013-01-23 14:05:54', '2013-01-23 14:05:54');
INSERT INTO `tb_support_role_module` VALUES ('511', '1', '184', '2013-01-23 14:05:55', '2013-01-23 14:05:55');
INSERT INTO `tb_support_role_module` VALUES ('512', '1', '185', '2013-01-23 14:05:55', '2013-01-23 14:05:55');
INSERT INTO `tb_support_role_module` VALUES ('513', '1', '186', '2013-01-23 14:05:55', '2013-01-23 14:05:55');
INSERT INTO `tb_support_role_module` VALUES ('514', '1', '190', '2013-01-23 14:05:55', '2013-01-23 14:05:55');
INSERT INTO `tb_support_role_module` VALUES ('515', '1', '192', '2013-01-23 14:05:55', '2013-01-23 14:05:55');
INSERT INTO `tb_support_role_module` VALUES ('516', '1', '197', '2013-01-23 14:05:55', '2013-01-23 14:05:55');
INSERT INTO `tb_support_role_module` VALUES ('517', '1', '198', '2013-01-23 14:05:55', '2013-01-23 14:05:55');
INSERT INTO `tb_support_role_module` VALUES ('518', '1', '199', '2013-01-23 14:05:55', '2013-01-23 14:05:55');
INSERT INTO `tb_support_role_module` VALUES ('519', '1', '200', '2013-01-23 14:05:55', '2013-01-23 14:05:55');
INSERT INTO `tb_support_role_module` VALUES ('520', '1', '201', '2013-01-23 14:05:55', '2013-01-23 14:05:55');
INSERT INTO `tb_support_role_module` VALUES ('521', '1', '202', '2013-01-23 14:05:55', '2013-01-23 14:05:55');
INSERT INTO `tb_support_role_module` VALUES ('522', '1', '204', '2013-01-23 14:05:55', '2013-01-23 14:05:55');
INSERT INTO `tb_support_role_module` VALUES ('523', '1', '222', '2013-01-23 14:05:55', '2013-01-23 14:05:55');
INSERT INTO `tb_support_role_module` VALUES ('524', '1', '235', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_role_module` VALUES ('525', '1', '236', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_role_module` VALUES ('526', '1', '237', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_role_module` VALUES ('527', '1', '238', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_role_module` VALUES ('528', '1', '239', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_role_module` VALUES ('529', '1', '240', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_role_module` VALUES ('530', '1', '241', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_role_module` VALUES ('531', '1', '242', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_role_module` VALUES ('532', '1', '243', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_role_module` VALUES ('533', '1', '244', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_role_module` VALUES ('534', '1', '245', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_role_module` VALUES ('535', '1', '246', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_role_module` VALUES ('536', '1', '247', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_role_module` VALUES ('537', '1', '248', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_role_module` VALUES ('538', '1', '249', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_role_module` VALUES ('539', '1', '250', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_role_module` VALUES ('540', '1', '251', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_role_module` VALUES ('541', '1', '252', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_role_module` VALUES ('542', '1', '253', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_role_module` VALUES ('543', '1', '254', '1970-01-01 00:00:00', '1970-01-01 00:00:00');

-- ----------------------------
-- Table structure for `tb_support_users`
-- ----------------------------
DROP TABLE IF EXISTS `tb_support_users`;
CREATE TABLE `tb_support_users` (
  `id` int(11) NOT NULL,
  `account` varchar(20) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `roleid` int(11) DEFAULT NULL,
  `account_status` tinyint(4) DEFAULT NULL,
  `created` datetime DEFAULT '1970-01-01 00:00:00',
  `modified` datetime DEFAULT '1970-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_support_users
-- ----------------------------
INSERT INTO `tb_support_users` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3', '1', '0', '2013-01-10 14:52:09', '2013-01-10 14:52:09');

-- ----------------------------
-- Table structure for `tb_task_type`
-- ----------------------------
DROP TABLE IF EXISTS `tb_task_type`;
CREATE TABLE `tb_task_type` (
  `task_type_id` int(11) NOT NULL COMMENT '0：同步商品基本信息；1：同步价格；2：同步上下架状态；3：同步商品类目；4：同步供应商信息；5：生成下载统计日报；',
  `task_type_name` varchar(50) NOT NULL,
  `is_loop` tinyint(1) NOT NULL COMMENT '0：一次性任务；1：周期性循环重复任务；',
  `loop_period` varchar(30) NOT NULL COMMENT '0：不需要；1：需要；',
  `created` datetime NOT NULL COMMENT '创建时间',
  `modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`task_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_task_type
-- ----------------------------
INSERT INTO `tb_task_type` VALUES ('1', '同步应用基本信息', '0', '0', '2013-01-10 18:41:19', '2013-01-10 18:41:19');
INSERT INTO `tb_task_type` VALUES ('2', '同步应用价格', '0', '0', '2013-01-10 18:41:20', '2013-01-10 18:41:20');
INSERT INTO `tb_task_type` VALUES ('3', '同步上下架状态', '0', '0', '2013-01-10 18:41:20', '2013-01-10 18:41:20');
INSERT INTO `tb_task_type` VALUES ('4', '同步商品类目', '1', '0 0 3 * * ?', '2013-01-10 18:41:20', '2013-01-10 18:41:20');
INSERT INTO `tb_task_type` VALUES ('5', '生成下载统计日报', '1', '0 30 0 * * ?', '2013-01-10 18:41:20', '2013-01-10 18:41:20');
INSERT INTO `tb_task_type` VALUES ('6', '更新排行榜', '1', '0 0 2 * * ?', '2013-01-10 18:41:20', '2013-01-10 18:41:20');
INSERT INTO `tb_task_type` VALUES ('7', '合到期预警检测', '1', '0 0 8 * * ?', '2013-01-10 18:41:20', '2013-01-10 18:41:20');
INSERT INTO `tb_task_type` VALUES ('8', '上传主图', '0', '0', '2013-01-10 18:41:20', '2013-01-10 18:41:20');
INSERT INTO `tb_task_type` VALUES ('9', '生成应用安装记录日报', '1', '0 30 0 * * ?', '0000-00-00 00:00:00', '0000-00-00 00:00:00');
INSERT INTO `tb_task_type` VALUES ('10', '同步卓望增量接口数据', '1', '0 0 3 * * ?', '0000-00-00 00:00:00', '0000-00-00 00:00:00');

-- ----------------------------
-- Table structure for `tb_topic`
-- ----------------------------
DROP TABLE IF EXISTS `tb_topic`;
CREATE TABLE `tb_topic` (
  `topicid` int(11) NOT NULL,
  `topic_name` varchar(30) DEFAULT NULL,
  `topic_type` tinyint(4) DEFAULT NULL COMMENT '1：移动应用；2：Web应用',
  `logo_url` varchar(150) DEFAULT NULL,
  `intro` varchar(300) DEFAULT NULL,
  `pubed_status` tinyint(4) DEFAULT NULL COMMENT '0：未发布；1：发布',
  `pub_time` datetime DEFAULT NULL,
  `order_seq` int(11) DEFAULT NULL,
  `created` datetime DEFAULT '1970-01-01 00:00:00',
  `modified` datetime DEFAULT '1970-01-01 00:00:00',
  PRIMARY KEY (`topicid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_topic
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_topic_app`
-- ----------------------------
DROP TABLE IF EXISTS `tb_topic_app`;
CREATE TABLE `tb_topic_app` (
  `id` int(11) NOT NULL,
  `topicid` int(11) NOT NULL,
  `appid` int(11) NOT NULL,
  `pubed_status` tinyint(4) DEFAULT NULL COMMENT '0：未发布；1：发布',
  `pub_time` datetime DEFAULT NULL,
  `order_seq` smallint(6) DEFAULT NULL,
  `created` datetime DEFAULT '1970-01-01 00:00:00',
  `modified` datetime DEFAULT '1970-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_topic_app
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_website_notice`
-- ----------------------------
DROP TABLE IF EXISTS `tb_website_notice`;
CREATE TABLE `tb_website_notice` (
  `id` int(11) NOT NULL,
  `subject` varchar(50) DEFAULT NULL,
  `content` varchar(5000) DEFAULT NULL,
  `pub_time` datetime DEFAULT NULL,
  `order_seq` smallint(6) DEFAULT NULL,
  `pubed_status` tinyint(4) DEFAULT NULL COMMENT '0：未发布；1：发布',
  `created` datetime DEFAULT '1970-01-01 00:00:00',
  `modified` datetime DEFAULT '1970-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




DROP TABLE IF EXISTS `tb_activity`;
CREATE TABLE `tb_activity` (
  `id` int(11) NOT NULL,
  `activity_name` varchar(50) DEFAULT NULL,
  `small_pic` varchar(100) DEFAULT NULL,
  `large_pic` varchar(100) DEFAULT NULL,
  `file_url` varchar(100) DEFAULT NULL,
  `seq` int(11) DEFAULT NULL,
  `pubed_status` tinyint(4) DEFAULT NULL COMMENT '0：下线；1：上线',
  `created` datetime DEFAULT '1970-01-01 00:00:00',
  `modified` datetime DEFAULT '1970-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tb_channel_activity`;
CREATE TABLE `tb_channel_activity` (
  `id` int(11) NOT NULL,
  `cid` int(11) DEFAULT NULL,
  `activity_id` int(11) DEFAULT NULL,
  `created` datetime DEFAULT '1970-01-01 00:00:00',
  `modified` datetime DEFAULT '1970-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists tb_pad_update_log;

/*==============================================================*/
/* Table: tb_pad_update_log                                     */
/*==============================================================*/
create table tb_pad_update_log
(
  id                   int,
  imei_number          varchar(20),
  last_update_time     datetime,
  status               int comment '1：一星期未更新
            2：已经更新',
  created              datetime,
  modified             datetime
);


create index ix_erptask_query on tb_backend_task(`status`, task_type_id);
create index ix_applog_appid on tb_app_log(appid);
create index ix_detaillog_appid on tb_app_detail_log(appid);
create index ix_resource_appid on tb_app_resource(appid);

-- ----------------------------
-- Records of tb_website_notice
-- ----------------------------
/*  0 30 0 * * ? */