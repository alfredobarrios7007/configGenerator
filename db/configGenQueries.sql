USE `bds_consola_universal` ;

SELECT iduser,iduserarea,idorganization,idorganizationrol,password,name,lastname,email,superuser,photo,unavaibled,created_datetime,created_platform,updated_datetime,updated_platform FROM ctusers  WHERE Unavaibled='N' AND Email = 'Simone@lamoderna.com' ;

SELECT iduser,iduserarea,idorganization,idorganizationrol,password,name,lastname,email,superuser,photo,unavaibled,created_datetime,created_platform,updated_datetime,updated_platform FROM ctusers  
WHERE Unavaibled='N' AND 'karen@speedy.com' = Email AND '+b79ce0jkFUY/I/Yi4Fr3g==' = Password;

DELETE FROM `bds_consola_universal`.`ctUsers` WHERE 'karen@speedy.com' = Email ;

SELECT * FROM `bds_consola_universal`.`ctUsers` ;
SELECT * FROM `bds_consola_universal`.`ctOrganizations` ;

SELECT idproject,name,description,iconurl,badgeurl,created_datetime,created_platform,updated_datetime,updated_datetime,updated_platform FROM
ctProjects prjs
INNER JOIN rrCompaniesProjects rrcp ON prjs.idproject=rrcp.idproject AND rrcp.Unavaibled='N'
;


CALL FIND_USER_BY_ID(2);

DELIMITER $$
CREATE PROCEDURE `FIND_USER_BY_ID`(in p_iduser int)
begin
	SELECT * FROM `bds_consola_universal`.`ctUsers` WHERE Iduser = p_iduser;
end
$$
DELIMITER ;



    SELECT usr.`IdUser`
    , usr.`IdUserArea`
    , usra.`name` AS `UserArea`
    , usr.`IdOrganization`
    , orgn.`name` AS `Organization`
    , usr.`IdOrganizationRol`
    , orgr.`nameES` AS `OrganizationRol`
    , usr.`Password`
    , usr.`Name`
    , usr.`Firstame`
    , usr.`Email`
    , usr.`Superuser`
    , usr.`Confirmed`
    , usr.`Photo`
    , usr.`Unavaibled`
    , usr.`Created_Datetime`
    , usr.`Created_Platform`
    , usr.`Updated_Datetime`
    , usr.`Updated_Platform` 
    FROM `bds_consola_universal`.`ctUsers` usr INNER JOIN `bds_consola_universal`.`ctUserAreas` usra ON usr.`IdUserArea`= usra.`IdUserArea`
    INNER JOIN `bds_consola_universal`.`ctOrganizations` orgn ON usr.`IdOrganization`= orgn.`IdOrganization`
    LEFT OUTER JOIN `bds_consola_universal`.`ctOrganizationRoles` orgr ON orgr.`IdOrganizationRol`=usr.`IdOrganizationRol`;