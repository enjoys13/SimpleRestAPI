/*
 Navicat Premium Data Transfer

 Source Server         : vanelbe
 Source Server Type    : MySQL
 Source Server Version : 100133
 Source Host           : localhost:3306
 Source Schema         : db_simple_rest_api

 Target Server Type    : MySQL
 Target Server Version : 100133
 File Encoding         : 65001

 Date: 27/07/2021 11:45:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for p_customer
-- ----------------------------
DROP TABLE IF EXISTS `p_customer`;
CREATE TABLE `p_customer`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `phone` varchar(30) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of p_customer
-- ----------------------------
INSERT INTO `p_customer` VALUES (2, 'Luffy', '085739218822');
INSERT INTO `p_customer` VALUES (3, 'Zorro', '081239214556');
INSERT INTO `p_customer` VALUES (4, 'Sanji', '085239218256');
INSERT INTO `p_customer` VALUES (5, 'Nami', '081239461246');
INSERT INTO `p_customer` VALUES (6, 'Ussop', '089839275446');
INSERT INTO `p_customer` VALUES (7, 'Chopper', '081239274723');
INSERT INTO `p_customer` VALUES (8, 'Robin', '081239273856');
INSERT INTO `p_customer` VALUES (9, 'Brook', '081239273867');
INSERT INTO `p_customer` VALUES (10, 'Franky', '081239272743');
INSERT INTO `p_customer` VALUES (11, 'Jinbei', '081239272769');

SET FOREIGN_KEY_CHECKS = 1;
