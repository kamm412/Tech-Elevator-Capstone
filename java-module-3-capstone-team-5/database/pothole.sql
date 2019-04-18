DROP TABLE pothole;

CREATE TABLE pothole
(
	pothole_Id SERIAL NOT NULL,
	street_Name VARCHAR(200) NOT NULL,
	street_Number INTEGER NOT NULL,
	zip_Code INTEGER NOT NULL,
	state VARCHAR(30) NOT NULL,
	city VARCHAR(20) NOT NULL,
	country VARCHAR(80) NOT NULL,
	status_Date timestamp NOT NULL DEFAULT now(),
	status_Code VARCHAR(20) NOT NULL DEFAULT 'reported',
	lat DECIMAL(16,13) NOT NULL,
	lng DECIMAL(16,13) NOT NULL,
	severity INTEGER NOT NULL DEFAULT 0,
	report_Date timestamp NOT NULL DEFAULT now(),
	report_User VARCHAR(30) NOT NULL,
	img_Url VARCHAR(200) NOT NULL,
	
	CONSTRAINT pk_pothole_Id PRIMARY KEY (pothole_Id)
	
);


INSERT INTO pothole(pothole_Id, street_Name, street_Number, zip_Code, state, city, country, status_Date, status_Code, lat, lng, severity, report_Date,report_User, img_Url) VALUES (1, 'Pennsylvania',901, 15233, 'PA','Pittsburgh', 'USA', '10/15/2018', 'Inspected', 40.456257, -80.0189, 2, '10/12/2018', 'Kaelin', 'https://i.imgflip.com/2537yf.jpg' );
INSERT INTO pothole(pothole_Id, street_Name, street_Number, zip_Code, state, city, country, status_Date, status_Code, lat, lng, severity, report_Date,report_User, img_Url) VALUES (2, 'Penn Ave',2801, 15222, 'PA','Pittsburgh','USA', '3/05/2019', 'Reported', 40.457215, -79.9756, 1, '03/05/2019','Ipsita', 'https://i.pinimg.com/236x/b4/9e/3c/b49e3c4cb1f1cfd451abf9d7046e1d82--car-humor-car-memes.jpg' );
INSERT INTO pothole(pothole_Id, street_Name, street_Number, zip_Code, state, city, country, status_Date, status_Code, lat, lng, severity, report_Date,report_User, img_Url) VALUES (3, 'Murray Ave',2112, 15217, 'PA','Pittsburgh', 'USA', '12/25/2018','Repared', 40.433946, -79.9232, 3, '12/25/2018','Lise', 'http://i.imgur.com/4jA5PpN.jpg');  