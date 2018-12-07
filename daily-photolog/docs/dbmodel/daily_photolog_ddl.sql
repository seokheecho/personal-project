-- 회원
DROP TABLE IF EXISTS `TBL_MEMB` RESTRICT;

-- 포토로그
DROP TABLE IF EXISTS `TBL_PHOTOLOG` RESTRICT;

-- 포토파일
DROP TABLE IF EXISTS `TBL_PHOTOFILE` RESTRICT;

-- 회원
CREATE TABLE `TBL_MEMB` (
	`MNO`   INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
	`EMAIL` VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
	`NAME`  VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
	`PWD`   VARCHAR(100) NOT NULL COMMENT '암호' -- 암호
)
COMMENT '회원';

-- 회원
ALTER TABLE `TBL_MEMB`
	ADD CONSTRAINT `PK_TBL_MEMB` -- 회원 기본키
		PRIMARY KEY (
			`MNO` -- 회원번호
		);

-- 회원 유니크 인덱스
CREATE UNIQUE INDEX `UIX_TBL_MEMB`
	ON `TBL_MEMB` ( -- 회원
		`EMAIL` ASC -- 이메일
	);

ALTER TABLE `TBL_MEMB`
	MODIFY COLUMN `MNO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '회원번호';

-- 포토로그
CREATE TABLE `TBL_PHOTOLOG` (
	`PLNO`  INTEGER      NOT NULL COMMENT '포토로그번호', -- 포토로그번호
	`MNO`   INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
	`DATE`  DATE         NOT NULL COMMENT '날짜', -- 날짜
	`TITLE` VARCHAR(255) NOT NULL COMMENT '제목', -- 제목
	`MEMO`  TEXT         NULL     COMMENT '메모' -- 메모
)
COMMENT '포토로그';

-- 포토로그
ALTER TABLE `TBL_PHOTOLOG`
	ADD CONSTRAINT `PK_TBL_PHOTOLOG` -- 포토로그 기본키
		PRIMARY KEY (
			`PLNO` -- 포토로그번호
		);

ALTER TABLE `TBL_PHOTOLOG`
	MODIFY COLUMN `PLNO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '포토로그번호';

-- 포토파일
CREATE TABLE `TBL_PHOTOFILE` (
	`PFNO`  INTEGER      NOT NULL COMMENT '포토파일번호', -- 포토파일번호
	`PLNO`  INTEGER      NOT NULL COMMENT '포토로그번호', -- 포토로그번호
	`PHOTO` VARCHAR(255) NOT NULL COMMENT '포토파일' -- 포토파일
)
COMMENT '포토파일';

-- 포토파일
ALTER TABLE `TBL_PHOTOFILE`
	ADD CONSTRAINT `PK_TBL_PHOTOFILE` -- 포토파일 기본키
		PRIMARY KEY (
			`PFNO` -- 포토파일번호
		);

-- 포토로그
ALTER TABLE `TBL_PHOTOLOG`
	ADD CONSTRAINT `FK_TBL_MEMB_TO_TBL_PHOTOLOG` -- 회원 -> 포토로그
		FOREIGN KEY (
			`MNO` -- 회원번호
		)
		REFERENCES `TBL_MEMB` ( -- 회원
			`MNO` -- 회원번호
		);

-- 포토파일
ALTER TABLE `TBL_PHOTOFILE`
	ADD CONSTRAINT `FK_TBL_PHOTOLOG_TO_TBL_PHOTOFILE` -- 포토로그 -> 포토파일
		FOREIGN KEY (
			`PLNO` -- 포토로그번호
		)
		REFERENCES `TBL_PHOTOLOG` ( -- 포토로그
			`PLNO` -- 포토로그번호
		);
