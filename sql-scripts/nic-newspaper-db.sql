DROP DATABASE  IF EXISTS `nic-newspaper-bd`;

CREATE DATABASE  IF NOT EXISTS `nic-newspaper-bd`;
USE `nic-newspaper-bd`;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` char(80) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `user` (first_name,last_name,email,password)
VALUES 
('John','Doe','john@luv2code.com', '$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K'),
('Mary','Public','mary@luv2code.com', '$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K'),
('Susan','Adams','susan@luv2code.com', '$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K');


DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `role` (name)
VALUES 
('ROLE_AUTHORIZED');


DROP TABLE IF EXISTS `users_roles`;

CREATE TABLE `users_roles` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  
  PRIMARY KEY (`user_id`,`role_id`),
  
  KEY `FK_ROLE_idx` (`role_id`),
  
  CONSTRAINT `FK_USER_05` FOREIGN KEY (`user_id`) 
  REFERENCES `user` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_ROLE` FOREIGN KEY (`role_id`) 
  REFERENCES `role` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO `users_roles` (user_id,role_id)
VALUES 
(1, 1),
(2, 1),
(3, 1);


DROP TABLE IF EXISTS `article`;

CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `header` varchar(255) NOT NULL,
  `content` text NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `article` (header,content,date)
VALUES 
('SpaceX wins Sentinel 6B radar satellite launch contract', 

'SpaceX has won a contract to launch the joint US-European Sentinel 6B radar satellite as early as November 2025.

Five years ago, NASA also chose SpaceX to launch Sentinel 6A, the first of two identical satellites designed to use radar altimeters to determine global sea levels more accurately than ever before. In October 2017, just half a year after SpaceX’s first Falcon 9 rocket booster reuse and well before the cost savings that followed were fully factored in, NASA awarded SpaceX $94 million to launch the 1.1-ton (~2500 lb) to a relatively low 1300-kilometer (~810 mi) orbit.

Five years and two months later, NASA has awarded SpaceX $97 million to launch a virtually identical satellite to the same orbit, from the same launch pad, with the same rocket. SpaceX, however, is far from the same company it was in 2017, and has effectively mastered Falcon booster and payload fairing reuse in the half-decade since.
    — NASA\'s Launch Services Program (@NASA_LSP) December 20, 2022

Beginning in March 2017, SpaceX has reused Falcon boosters on 130 launches, including sensitive US military missions and even NASA astronaut launches. SpaceX has launched almost 70 internal Starlink missions (carrying more than 3600 SpaceX-built satellites) without bankrupting the company. CEO Elon Musk has stated that the marginal cost of a barebones Falcon 9 launch is just $15 million, while another executive once pegged the total cost of a Falcon 9 launch with flight-proven hardware at $28 million.

Perhaps most significantly, SpaceX won a contract in 2019 to launch NASA’s tiny IXPE X-ray telescope on Falcon 9 for only $50 million. SpaceX completed the mission in December 2021, launching the 330-kilogram (~730 lb) spacecraft into a roughly 600-kilometer (~370 mi) orbit. IXPE was initially expected to launch on Aerojet Rocketdyne’s troubled air-launched Pegasus XL rocket, which last launched a small NASA spacecraft for about $55 million.

Writ large, that may be the best explanation for why SpaceX and its executives – both of which have relentlessly reiterated that the company’s purpose is to radically reduce the cost of orbital launches – don’t feel pressure to translate those major cost decreases into major price cuts. Put simply, despite the fact that SpaceX has openly discussed its intentions for more than a decade, there isn’t a rocket on Earth that can beat Falcon 9’s combination of performance, cadence, reliability, and affordability.

In lieu of even a hint of competitive pressure from the rest of the industry, particularly for contracts limited to US industry, SpaceX appears to have decided that the profits from charging as much as possible outweigh the cynicism those actions could convey. To SpaceX’s credit, the reality is also more gray than some of the limited data might imply. Over the last three years, SpaceX’s prices for smallsat rideshare customers have repeatedly decreased and become more flexible. Additionally, accounting for five years of inflation, SpaceX’s $94 million Sentinel 6A contract would be worth about $114 million today, meaning that its $97 million Sentinel 6B launch contract technically represents a modest 15% discount.

It’s also likely that SpaceX’s main competitors, ULA and Arianespace, would have charged tens of millions of dollars more to launch Sentinel 6A or 6B on their current or next-generation rockets. But their existing rockets have no spare capacity for new contracts and their new Vulcan and Ariane 6 rockets have yet to fly, leaving SpaceX without any real competition.

For better or worse, it appears that Falcon 9 rideshare customers and SpaceX’s own Starlink constellation are the only major beneficiaries of Falcon 9’s extraordinary newfound affordability. With potential competitors like Rocket Lab’s Neutron, Relativity’s Terran-R, Blue Origin’s New Glenn, and ULA’s semi-reusable Vulcan variant all years from market entrance, that’s unlikely to change until the mid-to-late 2020s. Until then, even though SpaceX’s pricing is unlikely to revolutionize others’ access to space, Falcon 9 will remain an exceptionally affordable and available option for all launch customers – including NASA and ESA.',
current_time());


DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `article_id` int(11) NOT NULL,
  `text` varchar(1000) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  
  CONSTRAINT `FK_USER` FOREIGN KEY (`user_id`) 
  REFERENCES `user` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_ARTICLE` FOREIGN KEY (`article_id`) 
  REFERENCES `article` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
  
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `comment` (user_id,article_id,text,date)
VALUES 
(1,1,'Greate article!', current_time()),
(2,1,'God bless America', current_time()),
(3,1,'F@ck you Mask!!!', current_time());

