CREATE TABLE user_profile (
	id_user_profile BIGINT auto_increment NOT NULL,
	id_user BIGINT NOT NULL,
	gender VARCHAR(25) NOT NULL,
	marital_status varchar(45) NOT NULL,
	education varchar(255) NOT NULL,
	geo_location varchar(255) NOT NULL,
	languages varchar(1024) NOT NULL,
	employment varchar(255) NOT NULL,
	event_frequency varchar(100) NOT NULL,
	device_use TINYINT DEFAULT false NOT NULL,
	reason_device_use varchar(500) NULL,
	date_insert DATETIME NOT NULL,
	date_modify DATETIME NULL,
	notification_recieved TINYINT DEFAULT false NOT NULL,
	date_recieved DATETIME NOT NULL,
	date_notification_experied DATETIME NULL,
	CONSTRAINT user_profile_pk PRIMARY KEY (id_user_profile)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;


CREATE TABLE info_user_profile (
	id_info_user_profile BIGINT auto_increment NOT NULL,
	id_user_profile BIGINT NOT NULL,
	id_event_frequency INT NOT NULL,
	id_viewer INT NOT NULL,
	opera_type varchar(1024) NULL,
	purhasing_opera_items varchar(1024) NULL,
	id_meet_platform INT NOT NULL,
	hobby varchar(1024) NULL,
	date_insert DATETIME NOT NULL,
	date_modify DATETIME NULL,
	CONSTRAINT info_user_profile_pk PRIMARY KEY (id_info_user_profile)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;


CREATE TABLE notification_type (
	id_notification_type BIGINT NOT NULL,
	name varchar(100) NOT NULL,
	description varchar(255) NOT NULL,
	CONSTRAINT notification_type_pk PRIMARY KEY (id_notification_type)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;

CREATE TABLE notification (
	id_notification BIGINT auto_increment NOT NULL,
	id_user_profile BIGINT NOT NULL,
	id_notification_type INT NOT NULL,
	date_insert DATETIME NOT NULL,
	date_modify DATETIME NULL,
	enable TINYINT DEFAULT false NOT NULL,
	CONSTRAINT notification_pk PRIMARY KEY (id_notification)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;

CREATE TABLE event_frequency (
	id_event_frequency INT NOT NULL,
	name varchar(100) NOT NULL,
	description varchar(255) NOT NULL,
	CONSTRAINT event_frequency_pk PRIMARY KEY (id_event_frequency)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;


CREATE TABLE viewer (
	id_viewer INT NOT NULL,
	name varchar(100) NOT NULL,
	description varchar(255) NOT NULL,
	CONSTRAINT viewer_pk PRIMARY KEY (id_viewer)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;


CREATE TABLE meet_platform (
	id_meet_platform INT NOT NULL,
	name varchar(100) NOT NULL,
	description varchar(255) NOT NULL,
	CONSTRAINT meet_platform_pk PRIMARY KEY (id_meet_platform)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;
