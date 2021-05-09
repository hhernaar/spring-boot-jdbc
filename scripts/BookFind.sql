DELIMITER $$
CREATE PROCEDURE BookFind( IN _bookId BIGINT) BEGIN
	SELECT
		bookId
        ,title
        ,author
        ,pages
        ,isbn
    FROM book
    WHERE bookId = IFNULL(_bookId, bookId);    
END$$
Delimiter ;
