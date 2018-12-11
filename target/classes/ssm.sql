DROP TABLE IF EXISTS `tbl_emp`;
CREATE TABLE `tbl_emp`(
	`emp_id` int(11) UNSIGNED NOT NULL auto_increment,
	`emp_name` VARCHAR(22) NOT NULL DEFAULT '',
  `emp_email` VARCHAR(256) NOT NULL DEFAULT '',
  `gender` CHAR(2) NOT NULL DEFAULT '',
   `department_id` int(11) NOT NULL DEFAULT 0,
	 PRIMARY KEY(`emp_id`)
) ENGINE=INNODB DEFAULT CHARSET=UTF8;


DROP TABLE IF EXISTS `tbl_dept`;
CREATE TABLE `tbl_dept`(
	`dept_id` int(11) UNSIGNED NOT NULL auto_increment,
  `dept_name` VARCHAR(255) NOT NULL DEFAULT '',
	`dept_leader` VARCHAR(255) NOT NULL DEFAULT '',
	PRIMARY KEY(`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_dept
-- ----------------------------
INSERT INTO `tbl_dept` VALUES ('1', '测试部', '黎明');
INSERT INTO `tbl_dept` VALUES ('2', '技术部', 'hello');
INSERT INTO `tbl_dept` VALUES ('3', '客服部', 'talk');
INSERT INTO `tbl_dept` VALUES ('4', '商务部', 'business');
INSERT INTO `tbl_dept` VALUES ('5', '后勤部', 'Tom');
INSERT INTO `tbl_dept` VALUES ('6', '人事部', '托马斯他');

DROP TABLE IF EXISTS `ssm_user`;
CREATE TABLE `ssm_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ssm_user
-- ----------------------------
INSERT INTO `ssm_user` VALUES ('1', 'admin', '$1$noNf7rbr$Xwe/2PJ2gFcU.Ewxu5w5d/');