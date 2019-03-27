CREATE TABLE user_info (
	id INT NOT NULL AUTO_INCREMENT,
	user_name VARCHAR(10) NOT NULL,
	user_id BIGINT NOT NULL,
	sex VARCHAR(5) NOT NULL,
	role INT NOT NULL,
	institution_id VARCHAR(10) NOT NULL,
	office_id VARCHAR(10) NOT NULL,
	create_time Datetime NOT NULL DEFAULT now(),
	update_time Datetime NULL DEFAULT NULL,
	PRIMARY KEY (`id`)
) ENGINE = InnoDB CHARSET = utf8 COLLATE utf8_bin STATS_PERSISTENT = 0 COMMENT 'UserInfo';

CREATE UNIQUE INDEX user_info_unique_index ON user_info (user_id, institution_id, office_id);