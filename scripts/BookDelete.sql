DELIMITER $$
CREATE PROCEDURE BookDelete( IN _bookId BIGINT) BEGIN
	DELETE FROM book WHERE bookId = _bookId;
END$$
Delimiter ;
