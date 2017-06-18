CREATE TABLE `News_Dashuju` (
  `id` int(6) unsigned NOT NULL AUTO_INCREMENT,
  `url` varchar(255) NOT NULL,
  `title` varchar(45) NOT NULL,
  `source` varchar(45) NOT NULL,
  `date` datetime NOT NULL,
  `content` content NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `url_UNIQUE` (`url`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `url_old` (
  `url` varchar(255) NOT NULL,
  PRIMARY KEY (`url`),
  UNIQUE KEY `url_UNIQUE` (`url`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `News_Rengongzhineng` (
  `id` int(6) unsigned NOT NULL AUTO_INCREMENT,
  `url` varchar(255) NOT NULL,
  `title` varchar(45) NOT NULL,
  `source` varchar(45) NOT NULL,
  `date` datetime NOT NULL,
  `content` content NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `url_UNIQUE` (`url`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `News_Qukuailian` (
  `id` int(6) unsigned NOT NULL AUTO_INCREMENT,
  `url` varchar(255) NOT NULL,
  `title` varchar(45) NOT NULL,
  `source` varchar(45) NOT NULL,
  `date` datetime NOT NULL,
  `content` content NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `url_UNIQUE` (`url`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `News_Qita` (
  `id` int(6) unsigned NOT NULL AUTO_INCREMENT,
  `url` varchar(255) NOT NULL,
  `title` varchar(45) NOT NULL,
  `source` varchar(45) NOT NULL,
  `date` datetime NOT NULL,
  `content` content NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `url_UNIQUE` (`url`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;