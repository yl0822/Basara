/*
Navicat MySQL Data Transfer

Source Server         : 开发
Source Server Version : 50530
Source Host           : 10.120.153.150:3306
Source Database       : yldb

Target Server Type    : MYSQL
Target Server Version : 50530
File Encoding         : 65001

Date: 2016-03-15 15:11:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for TB_Content_CloudSong
-- ----------------------------
DROP TABLE IF EXISTS `TB_Content_CloudSong`;
CREATE TABLE `TB_Content_CloudSong` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) NOT NULL COMMENT '歌名',
  `duration` int(11) NOT NULL DEFAULT '0' COMMENT '时长',
  `lyrics` text COMMENT '歌词',
  `url` varchar(255) DEFAULT NULL COMMENT '歌曲文件存放地址',
  `tag` tinyint(4) DEFAULT NULL COMMENT '标签',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for TB_Content_Singer
-- ----------------------------
DROP TABLE IF EXISTS `TB_Content_Singer`;
CREATE TABLE `TB_Content_Singer` (
  `Id` bigint(20) unsigned NOT NULL COMMENT '主键',
  `name` varchar(128) NOT NULL COMMENT '名字',
  `nickName` varchar(128) NOT NULL COMMENT '昵称',
  `introduce` text NOT NULL COMMENT '简介',
  `tag` tinyint(4) DEFAULT NULL COMMENT '标签',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='歌手表';

-- ----------------------------
-- Table structure for TB_Content_TextPost
-- ----------------------------
DROP TABLE IF EXISTS `TB_Content_TextPost`;
CREATE TABLE `TB_Content_TextPost` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) NOT NULL COMMENT '标题',
  `content` text COMMENT '内容',
  `authName` varchar(255) DEFAULT NULL COMMENT '作者',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `tag` tinyint(4) DEFAULT NULL COMMENT '标签',
  PRIMARY KEY (`id`),
  KEY `postid_idx` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
