CREATE TABLE `QuickAccessModel` (
	`id`	TEXT UNIQUE,
	`fileurl`	TEXT,
	`nickname`	TEXT,
	`logicalgroup`	TEXT,
	PRIMARY KEY(`id`)
);