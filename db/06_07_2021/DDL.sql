CREATE TABLE user_info_profile (
	id_user_info_profile BIGINT auto_increment NOT NULL,
	id_user BIGINT NOT NULL,
	gender VARCHAR(25) NULL,
	age INT NULL,
	marital_status varchar(45) NULL,
	education varchar(255) NULL,
	geo_location varchar(255)  NULL,
	languages varchar(1024)  NULL,
	employment varchar(255)  NULL,
	frequenter varchar(100)  NULL,
	device_use BIT(1) DEFAULT false  NULL,
	reason_device_use varchar(255) NULL,
	event_frequency varchar(255)  NULL,
	viewer varchar(255)  NULL,
	opera_type varchar(1024) NULL,
	purchasing_opera_items varchar(1024) NULL,
	community_attendance BIT(1)  NULL,
	hobby varchar(1024) NULL,
	cultural_interesting varchar(500) NULL,
	date_insert DATETIME  NULL,
	date_modify DATETIME NULL,
	notification_recieved BIT(1) DEFAULT false  NULL,
	date_notification_recieved DATETIME  NULL,
	date_notification_experied DATETIME NULL,
	CONSTRAINT user_profile_pk PRIMARY KEY (id_user_profile)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;


CREATE TABLE notification (
	id_notification INT auto_increment NOT NULL,
	id_user_info_profile BIGINT NOT NULL,
	description varchar(255) NOT NULL,
	enabled BIT(1) DEFAULT false NULL,
	CONSTRAINT notification_type_pk PRIMARY KEY (id_notification_type)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;

ALTER TABLE notification ADD CONSTRAINT notification_fk FOREIGN KEY (id_user_info_profile) REFERENCES user_info_profile(id_user_info_profile);
