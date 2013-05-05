SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Database: `doc`
--

-- CREATE DATABASE `doc` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
-- USE `doc`;

-- --------------------------------------------------------

CREATE TABLE doc
(
uuid int NOT NULL AUTO_INCREMENT,
content varchar(100),
tags varchar(200),
PRIMARY KEY (uuid)
) ENGINE=InnoDB;

-- --------- insert sample data---------------------------------

insert into doc values('1','hello how are you?','personal,ask');
insert into doc values('2','whats your name','name,ask');
insert into doc values('3','Harsha lives in colombo area','personal,area,colombo');
insert into doc values('4','Gayan is a anandian','anandian,ask');
insert into doc values('5','She is very talented','talent');

-- --------- list sample data---------------------------------

select * from doc;
