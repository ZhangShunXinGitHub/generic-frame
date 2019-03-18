DROP PROCEDURE IF EXISTS add_user_optimizition;
DELIMITER //
    create PROCEDURE add_user_info(in num INT)
    BEGIN
        DECLARE rowid INT DEFAULT 0;
        DECLARE user_id INT DEFAULT 0;
        DECLARE user_name CHAR(5) DEFAULT '';
        DECLARE name1 CHAR(1);
        DECLARE name2 CHAR(1);

        DECLARE sex CHAR(1);
        DECLARE role CHAR(1);
        DECLARE institution_id CHAR(6);
        DECLARE office_id CHAR(3);

        SET @exedata = "";
        WHILE rowid < num DO
            SET user_name = SUBSTRING('赵钱孙李周吴郑王林杨柳刘孙陈江阮侯邹高彭徐',FLOOR(1+21*RAND()),1);
            SET name1 = SUBSTRING('一二三四五六七八九十甲乙丙丁静景京晶名明铭敏闵民军君俊骏天田甜兲恬益依成城诚立莉力黎励',ROUND(1+43*RAND()),1);
            SET name2 = SUBSTRING('一二三四五六七八九十甲乙丙丁静景京晶名明铭敏闵民军君俊骏天田甜兲恬益依成城诚立莉力黎励',ROUND(1+43*RAND()),1);
            SET sex=FLOOR(0 + (RAND() * 2));
						SET role=FLOOR(0 + (RAND() * 2));
						SET institution_id=concat('00000',FLOOR(0 + (RAND() * 9)));
						SET office_id=concat('00',FLOOR(0 + (RAND() * 9)));
            SET user_id= rowid + 1;
            SET rowid = rowid + 1;
            IF ROUND(RAND())=0 THEN
            SET user_name =CONCAT(user_name,name1);
            END IF;
            IF ROUND(RAND())=1 THEN
            SET user_name =CONCAT(user_name, CONCAT(name1,name2));
            END IF;
            IF length(@exedata)>0 THEN
            SET @exedata = CONCAT(@exedata,',');
            END IF;
            SET @exedata=concat(@exedata,"('",user_name,"','",user_id,"','",sex,"','",role,"','",institution_id,"','",office_id,"')");
            IF rowid%1000=0
            THEN
                SET @exesql =concat("insert into user_info(user_name,user_id,sex,role,institution_id,office_id) values ", @exedata);
                prepare stmt from @exesql;
                execute stmt;
                DEALLOCATE prepare stmt;
                SET @exedata = "";
            END IF;
        END WHILE;
        IF length(@exedata)>0
        THEN
            SET @exesql =concat("insert into user_info(user_name,user_id,sex,role,institution_id,office_id) values ", @exedata);
            prepare stmt from @exesql;
            execute stmt;
            DEALLOCATE prepare stmt;
        END IF;
    END //
DELIMITER ;

--call add_user_info(10000000);