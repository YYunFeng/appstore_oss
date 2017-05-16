/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.119
Source Server Version : 50529
Source Host           : 192.168.1.119:3306
Source Database       : appstore_ppad

Target Server Type    : MYSQL
Target Server Version : 50529
File Encoding         : 65001

Date: 2013-03-22 18:30:10
*/

SET FOREIGN_KEY_CHECKS=0;

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
INSERT INTO `tb_support_module` VALUES ('246', '245', '3', '应用的总安装量 ', '/marketStatistics/getMarketStat.action', '应用的总安装量 ', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('247', '245', '3', '应用按渠道统计安装次数', '/marketStatistics/appGetMarketStatByChannel.action', '应用按渠道统计安装次数', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('248', '245', '3', '按应用查看', '/marketStatistics/statByApp.action', '按应用查看', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('249', '245', '3', '应用每个渠道下按促销员查看', '/marketStatistics/appStatsChannelBySaler.action', '应用每个渠道下按促销员查看', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('250', '245', '3', '按渠道查看', '/marketStatistics/statByChannel.action', ' 按渠道查看', '1', '2013-03-22 10:35:31', null);
INSERT INTO `tb_support_module` VALUES ('251', '245', '3', '渠道下按应用查看', '/marketStatistics/statChannelByApps.action', '渠道下按应用查看', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('252', '245', '3', '渠道下按促销员查看安装次数', '/marketStatistics/channlStatBySaler.action', '渠道下按促销员查看安装次数', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('253', '245', '3', '促销员按应用查看安装次数', '/marketStatistics/salerStatsByApps.action', '促销员按应用查看安装次数', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('254', '245', '3', '导出下载统计报表', '/marketStatistics/exportExcel.action', '导出下载统计报表', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('255', '4', '2', '活动管理列表', '/activityManager/activityList.action', '活动管理列表', '0', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('256', '4', '2', '添加活动', '/activityManager/createActivity.action', '添加活动', '0', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('257', '4', '2', '保存活动入库', '/activityManager/saveActivity.action', '保存活动入库', '0', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('258', '4', '2', '删除活动', '/activityManager/deleteActivity.action', '删除活动', '0', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('259', '4', '2', '更新活动上下线状态', '/activityManager/updateActivityPubedStatus.action', '更新活动上下线状态', '0', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('260', '4', '2', '修改活动', '/activityManager/modifyActivity.action', '修改活动', '0', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('261', '4', '2', '修改活动入库', '/activityManager/saveModifyActivity.action', '修改活动', '0', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('262', '4', '2', '活动关联渠道信息', '/activityManager/activityRelevanceChannel.action', '活动关联渠道信息', '0', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('263', '4', '2', '修改关联渠道信息', '/activityManager/createActivityReleanceChannel.action', '修改关联渠道信息', '0', '1970-01-01 00:00:00', '1970-01-01 00:00:00');


INSERT INTO `tb_support_module` VALUES ('264', '3', '2', '促销员排名', '/salesStatistics/salerRankingManager.action', '应用管理-促销员排名', '0', '2013-01-10 14:51:49', '2013-01-10 14:51:49');
INSERT INTO `tb_support_module` VALUES ('265', '3', '2', '手机安装信息', '/salesStatistics/phoneInstallMess.action', '应用管理-手机安装信息', '0', '2013-01-10 14:51:49', '2013-01-10 14:51:49');
INSERT INTO `tb_support_module` VALUES ('266', '3', '2', '每天应用安装信息', '/salesStatistics/dayInstallMess.action', '应用管理-每天应用安装信息', '0', '2013-01-10 14:51:49', '2013-01-10 14:51:49');


INSERT INTO `tb_support_module` VALUES ('267', '264', '3', '促销员排名详细信息', '/salesStatistics/salerRanking.action', '促销员排名-促销员排名详细信息', '1', '2013-01-10 14:51:49', '2013-01-10 14:51:49');
INSERT INTO `tb_support_module` VALUES ('268', '245', '3', '导出统计信息EXCEL', '/salesStatistics/statisticsExcel.action', '导出统计信息EXCEL', '1', '1970-01-01 00:00:00', '1970-01-01 00:00:00');


INSERT INTO `tb_support_module` VALUES ('269', '3', '2', 'PAD管理', '/padImeiManager/padImeiList.action', 'PAD管理', '0', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('270', '269', '3', '添加PAD信息', '/padImeiManager/addPadImei.action', '添加PAD信息', '0', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('271', '269', '3', '保存添加PAD信息', '/padImeiManager/savePadImei.action', '保存添加PAD信息', '0', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('272', '269', '3', '编辑PAD信息', '/padImeiManager/modifyPadImei.action', '编辑PAD信息', '0', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('273', '269', '3', '保存修改PAD信息', '/padImeiManager/saveModifyPadImei.action', '保存修改PAD信息', '0', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('274', '269', '3', '删除PAD信息', '/padImeiManager/deletePadImei.action', '删除PAD信息', '0', '1970-01-01 00:00:00', '1970-01-01 00:00:00');


INSERT INTO `tb_support_module` VALUES ('275', '3', '2', '促销员信息管理', '/salerDetailsManager/salerDetailsManager.action', '促销员信息管理', '0', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('276', '275', '3', '添加促销员信息', '/salerDetailsManager/createSalerDetails.action', '添加促销员信息', '0', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('277', '275', '3', '保存添加促销员信息', '/salerDetailsManager/saveSalerDetails.action', '保存添加促销员信息', '0', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('278', '275', '3', '修改促销员信息', '/salerDetailsManager/modifySalerDetails.action', '修改促销员信息', '0', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('279', '275', '3', '保存修改促销员信息', '/salerDetailsManager/updateSalerDetails.action', '修改促销员信息', '0', '1970-01-01 00:00:00', '1970-01-01 00:00:00');
INSERT INTO `tb_support_module` VALUES ('280', '275', '3', '删除促销员信息', '/salerDetailsManager/deleteSalerDetails.action', '删除促销员信息', '0', '1970-01-01 00:00:00', '1970-01-01 00:00:00');



INSERT INTO `tb_support_module` VALUES ('281', '149', '3', '更新专题下应用的激活状态', '/topicManager/changeActivation.action', '更新专题下应用的激活状态', '1', '2013-01-10 14:51:42', '2013-01-10 14:51:42');

INSERT INTO `tb_support_module` VALUES ('282', '3', '3', '有效装机数统计', '/validmachines/validmachines.action', '有效装机数统计', '1', '2013-01-10 14:51:42', '2013-01-10 14:51:42');
INSERT INTO `tb_support_module` VALUES ('283', '282', '3', '有效装机数统计内容', '/validmachines/validMachinesContent.action', '有效装机数统计内容', '1', '2013-01-10 14:51:42', '2013-01-10 14:51:42');
INSERT INTO `tb_support_module` VALUES ('284', '282', '3', '有效装机数按日期', '/validmachines/validMachinesByTime.action', '有效装机数按日期', '1', '2013-01-10 14:51:42', '2013-01-10 14:51:42');
INSERT INTO `tb_support_module` VALUES ('285', '282', '3', '有效装机数按促销员', '/validmachines/validMachinesBySaler.action', '有效装机数按促销员', '1', '2013-01-10 14:51:42', '2013-01-10 14:51:42');

INSERT INTO `tb_support_module` VALUES ('300', '282', '3', '按渠道查看公司收入统计', '/validmachines/getChannelMachines,.action', '按渠道查看公司收入统计', '1', '2013-01-10 14:51:42', '2013-01-10 14:51:42');
INSERT INTO `tb_support_module` VALUES ('301', '282', '3', '导出公司收入统计', '/validmachines/validMachineExcel,.action', '导出公司收入统计', '1', '2013-01-10 14:51:42', '2013-01-10 14:51:42');




INSERT INTO `tb_support_module` VALUES ('286', '4', '3', '强制安装', '/compulsory/compulsoryInstallation.action', '强制安装', '0', '2013-01-10 14:51:42', '2013-01-10 14:51:42');
INSERT INTO `tb_support_module` VALUES ('287', '287', '3', '添加强制安装应用', '/compulsory/addInstallApp.action', '添加强制安装应用', '1', '2013-01-10 14:51:42', '2013-01-10 14:51:42');
INSERT INTO `tb_support_module` VALUES ('288', '287', '3', '保存添加强制安装应用, '/compulsory/saveIntallApp.action', '保存添加强制安装应用', '1', '2013-01-10 14:51:42', '2013-01-10 14:51:42');
INSERT INTO `tb_support_module` VALUES ('289', '287', '3', '删除强制安装应用, '/compulsory/deleteCompulsoryApp.action', '保存添加强制安装应用', '1', '2013-01-10 14:51:42', '2013-01-10 14:51:42');


INSERT INTO `tb_support_module` VALUES ('290', '4', '3', '苏宁易购的安装页面', '/suning/suNingApps.action', '苏宁易购的安装页面', '0', '2013-01-10 14:51:42', '2013-01-10 14:51:42');
INSERT INTO `tb_support_module` VALUES ('291', '290', '3', '添加苏宁易购页面', '/suning/addSuning.action', '添加苏宁易购页面', '1', '2013-01-10 14:51:42', '2013-01-10 14:51:42');
INSERT INTO `tb_support_module` VALUES ('292', '290', '3', '保存修改苏宁易购页面', '/suning/saveSuning.action', '保存修改苏宁易购页面', '1', '2013-01-10 14:51:42', '2013-01-10 14:51:42');
INSERT INTO `tb_support_module` VALUES ('293', '290', '3', '修改苏宁易购页面', '/suning/modifySuning.action', '修改苏宁易购页面', '1', '2013-01-10 14:51:42', '2013-01-10 14:51:42');
INSERT INTO `tb_support_module` VALUES ('294', '290', '3', '保存修改苏宁易购页面', '/suning/updateSuning.action', '保存修改苏宁易购页面', '1', '2013-01-10 14:51:42', '2013-01-10 14:51:42');
INSERT INTO `tb_support_module` VALUES ('295', '290', '3', '删除苏宁易购页面', '/suning/deleteSuning.action', '保存修改苏宁易购页面', '1', '2013-01-10 14:51:42', '2013-01-10 14:51:42');


INSERT INTO `tb_support_module` VALUES ('296', '4', '3', 'CP激活数据导入', '/cpdateimport/cpDateImport.action', 'CP激活数据导入', '0', '2013-01-10 14:51:42', '2013-01-10 14:51:42');
INSERT INTO `tb_support_module` VALUES ('297', '296', '3', '添加CP激活数据', '/cpdateimport/addCpDateImport.action', '添加CP激活数据', '1', '2013-01-10 14:51:42', '2013-01-10 14:51:42');
INSERT INTO `tb_support_module` VALUES ('298', '296', '3', '保存添加CP激活数据', '/cpdateimport/saveCpDateImport.action', '保存添加CP激活数据', '1', '2013-01-10 14:51:42', '2013-01-10 14:51:42');
INSERT INTO `tb_support_module` VALUES ('299', '296', '3', '删除CP激活数据', '/cpdateimport/deleteCpDateImport.action', '删除CP激活数据', '1', '2013-01-10 14:51:42', '2013-01-10 14:51:42');



INSERT INTO `tb_support_module` VALUES ('302', '3', '3', '应用到达量统计', '/appCounts/appCount,.action', '导出公司收入统计', '0', '2013-01-10 14:51:42', '2013-01-10 14:51:42');
INSERT INTO `tb_support_module` VALUES ('303', '303', '3', '应用到达量统计按CP', '/appCounts/getCountAppsByCp.action', '导出公司收入统计', '1', '2013-01-10 14:51:42', '2013-01-10 14:51:42');
INSERT INTO `tb_support_module` VALUES ('304', '303', '3', '应用到达量统计按应用查看', '/appCounts/getCountAppsByApp.action', '导出公司收入统计', '1', '2013-01-10 14:51:42', '2013-01-10 14:51:42');
INSERT INTO `tb_support_module` VALUES ('305', '303', '3', '查看安装应用的手机串号', '/appCounts/getCountAppsByPhoneImei.action', '导出公司收入统计', '1', '2013-01-10 14:51:42', '2013-01-10 14:51:42');


INSERT INTO `tb_support_module` VALUES ('306', '3', '3', '手机安装信息内容', '/salesStatistics/phoneInstallMessContent,.action', '手机安装信息内容', '1', '2013-01-10 14:51:42', '2013-01-10 14:51:42');
INSERT INTO `tb_support_module` VALUES ('307', '3', '3', '导出手机安装信息', '/salesStatistics/exportExcel.action', '导出手机安装信息', '1', '2013-01-10 14:51:42', '2013-01-10 14:51:42');

INSERT INTO `tb_support_module` VALUES ('308', '3', '2', '省办统计查看', '/validmachines/provinceStatis.action', '省办统计查看', '0', '2013-01-10 14:51:42', '2013-01-10 14:51:42');
INSERT INTO `tb_support_module` VALUES ('309', '308', '3', '省办统计信息', '/validmachines/provinceStatisContent.action', '省办统计信息', '0', '2013-01-10 14:51:42', '2013-01-10 14:51:42');
INSERT INTO `tb_support_module` VALUES ('310', '308', '3', '省办统计信息--按时间查看', '/validmachines/provinceStatisByTime.action', '省办统计信息--按时间查看', '0', '2013-01-10 14:51:42', '2013-01-10 14:51:42');
INSERT INTO `tb_support_module` VALUES ('311', '308', '3', '省办统计信息--按促销员查看', '/validmachines/validMachinesContent.action', '省办统计信息--按促销员查看', '0', '2013-01-10 14:51:42', '2013-01-10 14:51:42');




INSERT INTO `tb_support_module` VALUES ('314', '7', '2', '应用价格设置', '/appPrice/appPrice.action', '应用价格设置', '0', '2013-01-10 14:51:42', '2013-01-10 14:51:42');
INSERT INTO `tb_support_module` VALUES ('315', '314', '3', '添加价格', '/appPrice/createAppPrice.action', '添加价格', '0', '2013-01-10 14:51:42', '2013-01-10 14:51:42');
INSERT INTO `tb_support_module` VALUES ('316', '314', '3', '保存价格设置', '/appPrice/saveAppPrice.action', '保存价格设置', '0', '2013-01-10 14:51:42', '2013-01-10 14:51:42');
INSERT INTO `tb_support_module` VALUES ('317', '314', '3', '修改价格', '/appPrice/modifyAppPrice.action', '修改价格', '0', '2013-01-10 14:51:42', '2013-01-10 14:51:42');
INSERT INTO `tb_support_module` VALUES ('318', '314', '3', '保存修改价格', '/appPrice/updateAppPrice.action', '保存修改价格', '0', '2013-01-10 14:51:42', '2013-01-10 14:51:42');
INSERT INTO `tb_support_module` VALUES ('319', '314', '3', '删除价格', '/appPrice/deleteAppPrice.action', '删除价格', '0', '2013-01-10 14:51:42', '2013-01-10 14:51:42');

INSERT INTO `tb_support_module` VALUES ('320', '314', '2', '统计', '/salesStatistics/provinceMonthly.action', '统计', '0', '2013-01-10 14:51:42', '2013-01-10 14:51:42');
INSERT INTO `tb_support_module` VALUES ('321', '310', '3', '统计内容', '/salesStatistics/provinceMonthlyContent.action', '统计内容', '0', '2013-01-10 14:51:42', '2013-01-10 14:51:42');


INSERT INTO `tb_support_module` VALUES ('322', '7', '2', '异常信息查看', '/exceptionLog/exceptionLogContent.action', '异常信息查看', '0', '2013-01-10 14:51:42', '2013-01-10 14:51:42');

INSERT INTO `tb_support_module` VALUES ('323', '3', '2', '促销员活跃度统计', '/salerActive/salerActive.action', '促销员活跃度统计', '0', '2013-01-10 14:51:42', '2013-01-10 14:51:42');
INSERT INTO `tb_support_module` VALUES ('324', '3', '2', '促销员活跃度统计内容', '/salerActive/salerActiveContent.action', '促销员活跃度统计内容', '0', '2013-01-10 14:51:42', '2013-01-10 14:51:42');
