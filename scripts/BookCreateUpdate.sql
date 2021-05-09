DELIMITER $$
CREATE PROCEDURE BookCreateUpdate(
	IN _bookId 	BIGINT
    ,IN _title	VARCHAR(500)
    ,IN _author	VARCHAR(100)
    ,IN _pages 	INT
    ,IN _isbn	VARCHAR(13)
) BEGIN
    
	IF _bookId IS NULL THEN
		INSERT INTO book(title, author, pages, isbn)
        VALUES(_title, _author, _pages, _isbn);
       SELECT LAST_INSERT_ID() INTO _bookId;
	ELSE
		UPDATE book SET
			title = IFNULL(_title, title)
            ,author = IFNULL(_author, author)
            ,pages = IFNULL(_pages, pages)
            ,isbn = IFNULL(_isbn, isbn)
		WHERE bookId = _bookId;
    END IF;
    
    SELECT
		bookId
        ,title
        ,author
        ,pages
        ,isbn
    FROM book
    WHERE bookId = _bookId; 
    
END$$
Delimiter ;
