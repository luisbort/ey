INSERT INTO EYSCHEMA.TBL_COUNTRY(COUNTRYCODE,COUNTRYNAME) VALUES ('57','COLOMBIA');
INSERT INTO EYSCHEMA.TBL_COUNTRY(COUNTRYCODE,COUNTRYNAME) VALUES ('32','ARGENTINA');

INSERT INTO EYSCHEMA.TBL_CITY (CITYCODE,CITYNAME) VALUES ('1','CIUDAD-1-COL');
INSERT INTO EYSCHEMA.TBL_CITY (CITYCODE,CITYNAME) VALUES ('2','CIUDAD-2-ARG');

INSERT INTO EYSCHEMA.TBL_USERS (USERNAME,USERMAIL,USERPASSWD, DATECREATION, DATEUPDATE, DATELASTLOGIN , ISACTIVE) VALUES ('Luis','luisbort@gmail.com','pw123',CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, '1');
INSERT INTO EYSCHEMA.TBL_USERS (USERNAME,USERMAIL,USERPASSWD, DATECREATION, DATEUPDATE, DATELASTLOGIN , ISACTIVE) VALUES ('Edgardo','luisbort1@gmail.com','pw456',CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, '1');

INSERT INTO EYSCHEMA.TBL_PHONES (PHONENUMBER,COUNTRYID,CITYID,USERID )
VALUES('12345678',
(SELECT COUNTRYID FROM EYSCHEMA.TBL_COUNTRY WHERE COUNTRYCODE='57'),
(SELECT CITYID FROM EYSCHEMA.TBL_CITY WHERE CITYCODE='1'),
(SELECT USERID FROM EYSCHEMA.TBL_USERS WHERE USERID='1')
);

INSERT INTO EYSCHEMA.TBL_PHONES (PHONENUMBER,COUNTRYID,CITYID,USERID )
VALUES('87654321',
(SELECT COUNTRYID FROM EYSCHEMA.TBL_COUNTRY WHERE COUNTRYCODE='57'),
(SELECT CITYID FROM EYSCHEMA.TBL_CITY WHERE CITYCODE='1'),
(SELECT USERID FROM EYSCHEMA.TBL_USERS WHERE USERID='1')
);

INSERT INTO EYSCHEMA.TBL_PHONES (PHONENUMBER,COUNTRYID,CITYID,USERID )
VALUES('135798642',
(SELECT COUNTRYID FROM EYSCHEMA.TBL_COUNTRY WHERE COUNTRYCODE='32'),
(SELECT CITYID FROM EYSCHEMA.TBL_CITY WHERE CITYCODE='2'),
(SELECT USERID FROM EYSCHEMA.TBL_USERS WHERE USERID='2')
);

INSERT INTO EYSCHEMA.TBL_PHONES (PHONENUMBER,COUNTRYID,CITYID,USERID )
VALUES('975312468',
(SELECT COUNTRYID FROM EYSCHEMA.TBL_COUNTRY WHERE COUNTRYCODE='32'),
(SELECT CITYID FROM EYSCHEMA.TBL_CITY WHERE CITYCODE='2'),
(SELECT USERID FROM EYSCHEMA.TBL_USERS WHERE USERID='2')
);