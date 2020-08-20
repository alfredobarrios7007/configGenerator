USE `bds_consola_universal` ;

SELECT iduser,iduserarea,idorganization,idorganizationrol,password,name,lastname,email,superuser,photo,unavaibled,created_datetime,created_platform,updated_datetime,updated_platform FROM ctusers  WHERE Unavaibled='N' AND Email = 'Simone@lamoderna.com' ;

SELECT iduser,iduserarea,idorganization,idorganizationrol,password,name,lastname,email,superuser,photo,unavaibled,created_datetime,created_platform,updated_datetime,updated_platform FROM ctusers  
WHERE Unavaibled='N' AND 'karen@speedy.com' = Email AND '+b79ce0jkFUY/I/Yi4Fr3g==' = Password;


SELECT * FROM subscritionsOffers;

INSERT INTO subscritionsOffers (`IdProject`, `Description`, `MaximumDownloads`, `MaximumUsers`, `MaximumApplications`, `MaximumProfiles`, `MaximumVersionByApp`, `Unavaibled`, `Show`, `Datestart`, `Datefinish`, `Created_Datetime`, `Created_Platform`, `Updated_Datetime`, `Updated_Platform`)
VALUES (1, `Config Generator is the most powerful tool in this moment to create and release the app configuration, by country, profile and version.`, 1000000, 3, 1, 2, `10`, `F`, `Y`, SYSDATE(), DATE_ADD(SYSDATE(), INTERVAL 1 YEAR), SYSDATE(), 'INIT_ROW', NULL, NULL);


DELETE FROM `bds_consola_universal`.`ctUsers` WHERE 'karen@speedy.com' = Email ;

SELECT * FROM `bds_consola_universal`.`ctUsers` ;
SELECT * FROM `bds_consola_universal`.`ctOrganizations` ;

SELECT prjs.idproject,prjs.name,prjs.description,prjs.iconurl,prjs.badgeurl,prjs.created_datetime,prjs.created_platform,prjs.updated_datetime,prjs.updated_datetime,prjs.updated_platform 
FROM
ctProjects prjs
INNER JOIN rrCompaniesProjects rrcp ON prjs.idproject=rrcp.idproject AND rrcp.Unavaibled='N'
INNER JOIN ctUsers usrs ON rrcp.IdCompany=usrs.IdUser
WHERE usrs.IdUser=1;


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