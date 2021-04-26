/*
 Navicat Premium Data Transfer

 Source Server         : MySql
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : recruitment

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 26/04/2021 13:44:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` int NOT NULL AUTO_INCREMENT,
  `admin_tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `admin_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `admin_password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE,
  UNIQUE INDEX `admin_tel`(`admin_tel`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, '18112357894', '谢小棋', '12345678');
INSERT INTO `admin` VALUES (2, '13979655426', '张子杰', '12345678');
INSERT INTO `admin` VALUES (3, '15865698452', '秦湘', '12345678');
INSERT INTO `admin` VALUES (4, '18056887452', '房朝', '12345678');
INSERT INTO `admin` VALUES (5, '123', '123', '123');

-- ----------------------------
-- Table structure for application
-- ----------------------------
DROP TABLE IF EXISTS `application`;
CREATE TABLE `application`  (
  `application_id` int NOT NULL AUTO_INCREMENT,
  `job_id` int NOT NULL,
  `resume_id` int NOT NULL,
  `user_id` int NOT NULL,
  `deal_hr_id` int NULL DEFAULT NULL,
  `application_date` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `application_state` int NULL DEFAULT NULL,
  PRIMARY KEY (`application_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of application
-- ----------------------------

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company`  (
  `company_id` int NOT NULL AUTO_INCREMENT,
  `company_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `company_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `company_location` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `company_logo` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `company_tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `company_email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `company_profile` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `company_state` int NULL DEFAULT NULL,
  `company_admin` int NULL DEFAULT NULL,
  PRIMARY KEY (`company_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES (1, '10001', '江西随明教育科技有限公司', '江西吉安', 'default.jpg', '18179628001', '921564484@163.com', '美丽企业', 1, 0);
INSERT INTO `company` VALUES (2, '10002', '南昌如梦教育咨询有限公司', '江西南昌', 'default.jpg', '15845412639', '625433564@163.com', '职等你来', 0, 0);
INSERT INTO `company` VALUES (3, '10003', '杭州阿理巴巴有限公司', '浙江杭州', 'default.jpg', '15483655484', '685642520@163.com', '中国第一', 1, 0);
INSERT INTO `company` VALUES (4, '123', '123', '山西省太原市山西转型综合改革示范区123', 'b762e82438b4416ab77b5d8e9447d15c.png', '15970421063', '123', '111111111111111111111111111111111113踩踩踩踩踩踩踩踩踩踩踩踩从', NULL, NULL);

-- ----------------------------
-- Table structure for hr
-- ----------------------------
DROP TABLE IF EXISTS `hr`;
CREATE TABLE `hr`  (
  `hr_id` int NOT NULL AUTO_INCREMENT,
  `company_id` int NOT NULL,
  `hr_tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `hr_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `hr_password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `hr_logo` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hr_email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hr_profile` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`hr_id`) USING BTREE,
  UNIQUE INDEX `hr_tel`(`hr_tel`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of hr
-- ----------------------------
INSERT INTO `hr` VALUES (1, 1, '15212036598', '张少刚', '12345678', 'default.jpg', '856236584@163.com', '只有靠谱');
INSERT INTO `hr` VALUES (2, 2, '18045786932', '刘博文', '12345678', 'default.jpg', '5632848505@163.com', 'GKD');
INSERT INTO `hr` VALUES (3, 3, '15989625410', '盒子健', '12345678', 'default.jpg', '592154124@qq.com', '紧急招聘，速来');
INSERT INTO `hr` VALUES (5, 3, '123', 'hhh', '111', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for job
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job`  (
  `job_id` int NOT NULL AUTO_INCREMENT,
  `hr_id` int NOT NULL,
  `company_id` int NULL DEFAULT NULL,
  `job_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `salary` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `introduction` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `requirement` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `degree` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `quantity` int NULL DEFAULT NULL,
  `location` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_date` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `job_state` int NULL DEFAULT NULL,
  PRIMARY KEY (`job_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of job
-- ----------------------------
INSERT INTO `job` VALUES (1, 1, 1, '销售', '3000', '卖房', '男女不限', '高中毕业', 100, '江西南昌', '2021.04.13', 1);
INSERT INTO `job` VALUES (2, 1, 1, '人事', '2500', '公司招聘', '心理学证书', '本科毕业', 50, '江西南昌', '2021.03.21', 1);
INSERT INTO `job` VALUES (3, 1, 1, '文员', '2000', '档案整理', '认真仔细', '初中毕业', 100, '广东深圳', '2021.02.10', 1);
INSERT INTO `job` VALUES (4, 1, 1, '部门经理', '6000', '项目运行', '有经验', '本科毕业', 30, '广东广州', '2021.03.12', 1);
INSERT INTO `job` VALUES (5, 2, 2, '销售', '4000', '卖店铺', '是人就行', '初中毕业', 500, '北京', '2021.03.19', 0);
INSERT INTO `job` VALUES (6, 2, 2, '活动企划', '3500', '写活动策划', '1年经验', '本科毕业', 100, '江西吉安', '2021.03.15', 0);
INSERT INTO `job` VALUES (7, 2, 2, '总经理', '8000', '管理公司业务', '3年经验', '本科毕业', 200, '江西吉安', '2021.04.03', 0);
INSERT INTO `job` VALUES (8, 3, 3, '软件开发', '12000', '会java开发', '有java基础', '中专毕业', 1000, '上海', '2021.05.21', 0);
INSERT INTO `job` VALUES (9, 3, 3, '大数据开发', '15000', '掌握大数据开发的基础', '有项目经验', '本科毕业', 500, '浙江杭州', '2021.06.01', NULL);

-- ----------------------------
-- Table structure for resume
-- ----------------------------
DROP TABLE IF EXISTS `resume`;
CREATE TABLE `resume`  (
  `resume_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NULL DEFAULT NULL,
  `real_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` int NOT NULL,
  `birthday` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `university` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `major` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `degree` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `introduction` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `speciality` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `experience` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `target` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hope_salary` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `work_area` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`resume_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of resume
-- ----------------------------
INSERT INTO `resume` VALUES (1, 1, '仇琪琪', 2, '1999.01.01', '东华理工大学', '英语', '大学本科', '性格开朗', '会英语', '实习3月经历', '文员', '5000', '江西南昌');
INSERT INTO `resume` VALUES (2, 2, '尹智博', 1, '1998.01.01', '南昌大学', '土木工程', '大学本科', '认真仔细', '擅长交流', '无', '建筑设计师', '9000', '江西南昌');
INSERT INTO `resume` VALUES (3, 3, '张语', 2, '1997.01.01', '悉尼大学', '社会学', '大学本科', '擅长交流', '能力强', '无', '行政', '15000', '广东深圳');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_logo` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_gender` int NULL DEFAULT NULL,
  `user_email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_birth` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `user_tel`(`user_tel`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '1562659845', '12345678', '飞天的猪', 'default.jpg', 1, '597954215@qq.COM', '1999.01.01');
INSERT INTO `user` VALUES (2, '15326541023', '12345678', '深海的鱼', 'default.jpg', 2, '124036985@qq.com', '1998.01.01');
INSERT INTO `user` VALUES (3, '18962365201', '12345678', '美丽的花', 'default.jpg', 1, '851561659@qq.com', '1997.01.01');
INSERT INTO `user` VALUES (4, '15970421063', '123456', '何子健', '42f2e82bbc5d4a82903b76aca5a9abbb.png', 1, '', '2021-04-05');

SET FOREIGN_KEY_CHECKS = 1;
