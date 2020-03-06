/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : education

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 11/03/2020 00:09:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员ID',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员名称',
  `nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员昵称',
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员密码',
  `sex` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '性别',
  `phone` varchar(13) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '电话号码',
  `email` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员邮箱',
  `firsttime` datetime(0) NOT NULL COMMENT '创建日期',
  `updatetime` datetime(0) NOT NULL COMMENT '修改时间',
  `lasttime` datetime(0) NOT NULL COMMENT '最后登录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1000', 'admin', 'admin', 'admin', 'Male', '13377211793', '1273647531@qq.com', '2020-02-18 15:03:15', '2020-02-18 15:03:15', '2020-02-18 15:03:18');
INSERT INTO `admin` VALUES ('1001', 'admin01', 'admin', 'admin', 'Female', '133xxxxxxxx', 'c4f3132@163.com', '2020-02-18 15:03:15', '2020-02-18 15:04:28', '2020-02-18 15:04:30');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程表主键',
  `file_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '视频表id',
  `name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程名称',
  `introduction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '视频简介',
  `type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '视频类型',
  `price` int(10) UNSIGNED ZEROFILL NOT NULL COMMENT '视频价格',
  `label` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '视频评价',
  `firsttime` datetime(0) NOT NULL COMMENT '视频创建日期',
  `updatetime` datetime(0) NOT NULL COMMENT '视频修改日期',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `课程名称`(`name`) USING BTREE COMMENT '课程名称的索引',
  UNIQUE INDEX `视频表id`(`file_id`) USING BTREE COMMENT '视频表的id',
  CONSTRAINT `视频表的id` FOREIGN KEY (`file_id`) REFERENCES `course_file` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('5087872237004a79b7c0ff75552f2afd', NULL, 'C#', 'C#', 'vip', 0000000010, '无', '2020-03-03 01:46:47', '2020-03-06 19:39:51');
INSERT INTO `course` VALUES ('935c2ad41320495fbdd8d12cd603550f', NULL, 'Java', 'JavaSE基础', 'vip', 0000000010, '良好', '2020-03-05 17:49:12', '2020-03-06 19:31:32');
INSERT INTO `course` VALUES ('9cddda0b8f1e4af7a57314ea15fa56cc', NULL, 'c++', 'c++', 'free', 0000000000, '无', '2020-03-03 01:46:47', '2020-03-06 19:19:58');
INSERT INTO `course` VALUES ('f3f10feed195498cb13b674ed388bc81', NULL, 'c', 'c', 'free', 0000000000, '一般', '2020-03-03 01:46:47', '2020-03-06 19:16:40');

-- ----------------------------
-- Table structure for course_file
-- ----------------------------
DROP TABLE IF EXISTS `course_file`;
CREATE TABLE `course_file`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '视频文件id',
  `filename` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '视频文件名',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '视频文件路径',
  `firsttime` datetime(0) NOT NULL COMMENT '视频创建日期',
  `updatetime` datetime(0) NOT NULL COMMENT '视频修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course_file
-- ----------------------------
INSERT INTO `course_file` VALUES ('165f54797a58489fa47dd7fdee749a36', '33', 'F:/javaWeb/education/upload/33.Ogg', '2020-03-05 20:35:52', '2020-03-05 20:35:52');
INSERT INTO `course_file` VALUES ('21a51000ef2444e4b06adda8bdfd2dec', '44', 'F:/javaWeb/education/upload/44.Ogg', '2020-03-05 20:35:59', '2020-03-05 20:35:59');
INSERT INTO `course_file` VALUES ('3a5cd8cd838a4a9bb7eb90909cdbe7ee', '22', 'F:/javaWeb/education/upload/22.Ogg', '2020-03-05 18:50:19', '2020-03-05 18:50:19');
INSERT INTO `course_file` VALUES ('5f5f81f50ea64dec9bf61a50c53a8f2b', '11', 'F:/javaWeb/education/upload/11.Ogg', '2020-03-05 18:50:12', '2020-03-05 18:50:12');

-- ----------------------------
-- Table structure for ipset
-- ----------------------------
DROP TABLE IF EXISTS `ipset`;
CREATE TABLE `ipset`  (
  `ip` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '操作者ip',
  `isban` tinyint(1) NOT NULL COMMENT '是否封禁',
  `flag` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '操作类型',
  `bantime` datetime(0) NULL DEFAULT NULL COMMENT '封禁日期',
  `firsttime` datetime(0) NOT NULL COMMENT '创建日期',
  `lasttime` datetime(0) NOT NULL COMMENT '最后登录时间',
  PRIMARY KEY (`ip`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ipset
-- ----------------------------
INSERT INTO `ipset` VALUES ('127.0.0.1', 0, NULL, NULL, '2020-02-18 15:06:31', '2020-02-18 15:06:31');

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`  (
  `id` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '日志id',
  `userid` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户id',
  `type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '操作动作',
  `operationtime` datetime(0) NOT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES ('1', '1000', '管理员注册', '2020-02-18 15:07:03');
INSERT INTO `log` VALUES ('2', '1001', '管理员注册', '2020-02-18 15:07:13');
INSERT INTO `log` VALUES ('3', '2000', '管理员注册', '2020-02-18 15:07:26');
INSERT INTO `log` VALUES ('4', '2000', '管理员注册', '2020-02-18 15:07:34');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户ID',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户账户',
  `nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户昵称',
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户密码',
  `sex` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户性别',
  `phone` varchar(13) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户手机号码',
  `email` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '邮箱地址',
  `wechar` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '微信号',
  `collect` int(10) UNSIGNED ZEROFILL NULL DEFAULT 0000000000 COMMENT '用户余额',
  `education` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '教育程度',
  `vip` datetime(0) NULL DEFAULT NULL COMMENT 'vip日期',
  `firsttime` datetime(0) NOT NULL COMMENT '创建日期',
  `updatetime` datetime(0) NOT NULL COMMENT '修改时间',
  `lasttime` datetime(0) NOT NULL COMMENT '最后登录时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `User_name_nickname`(`name`, `nickname`) USING BTREE COMMENT '用户账号或昵称的索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('0637a7ee1b6a4c72a0cc23a1146db917', 'yz772095101 ', '123', 'adm123', 'Male', '13377211793', 'admin@163.com', '无', 0000000200, '高中', '2020-04-25 04:02:17', '2020-02-23 22:08:26', '2020-03-02 21:16:34', '2020-02-23 22:08:26');
INSERT INTO `user` VALUES ('16b3d9f0d8c84ea7a0ffcc4b32a72b88', 'admin', 'aa', 'admin1234', 'Male', '13377211793', 'admin@funtl.com', '无', 0000000100, '无', '2020-04-25 04:02:17', '2020-02-23 22:08:26', '2020-02-23 22:02:26', '2020-02-27 20:47:17');
INSERT INTO `user` VALUES ('2001', 'user', 'user', 'user321', 'Female', '13313231654', 'djefnehfdnqmh651651@163.com', 'NMTNERN51', 0000000100, '本科', '2020-04-25 04:02:17', '2020-02-23 22:08:26', '2020-03-02 21:13:01', '2020-02-19 19:06:14');
INSERT INTO `user` VALUES ('981f874919ca49d3b0bcb065fcf7e898', '123asd', 'qsdasd ', 'admin123', 'Male', '13377211754', 'admin@163.com', '无', 0000000000, '无', NULL, '2020-02-23 22:08:26', '2020-03-03 02:02:02', '2020-03-03 02:02:02');
INSERT INTO `user` VALUES ('9da45930d937447ebe955018bcf75c45', 'admin123', '124123', 'admin123', 'Male', '13377211793', 'admin@163.com', '无', 0000000000, '无', NULL, '2020-02-23 22:08:26', '2020-03-03 02:12:01', '2020-03-03 02:12:01');
INSERT INTO `user` VALUES ('ae46604ba2d441aa9ccc674a289de6c2', '334', 'c\'c', 'admin12', 'Male', '13377211792', 'admin1111@163.com', '无', 0000000100, '无', '2020-04-25 04:02:17', '2020-02-23 22:08:26', '2020-02-24 22:06:23', '2020-02-24 02:46:24');

SET FOREIGN_KEY_CHECKS = 1;
