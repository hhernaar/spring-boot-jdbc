DROP TABLE IF EXISTS book;
create table book(
	bookId 		BIGINT NOT NULL AUTO_INCREMENT
	,title		VARCHAR(500)
    ,author		VARCHAR(100)
    ,pages		INT
    ,isbn		VARCHAR(13)
    ,creationDate DATETIME DEFAULT NOW()
    ,PRIMARY KEY(bookId)    
);