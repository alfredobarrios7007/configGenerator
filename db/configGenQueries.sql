SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


DROP PROCEDURE IF EXISTS `bds_consola_universal`.`MODIFYUSERPROFILE`;
DELIMITER $$
CREATE PROCEDURE `bds_consola_universal`.`MODIFYUSERPROFILE` (
in P_iduser INT,
in p_platform VARCHAR(10), 
in p_name VARCHAR(50), 
in p_lastname VARCHAR(50), 
in p_enabled CHAR(1), 
in p_organization VARCHAR(250), 
in p_organizationrole VARCHAR(250), 
in p_area VARCHAR(50), 
in p_email VARCHAR(150), 
in p_password VARCHAR(100),
in p_superuser CHAR(1),
in p_photo VARCHAR(200))
BEGIN
-- *************************************************************************************************************************
-- * CREATE_USER
-- *************************************************************************************************************************
-- * This procedures modifies the user profile
-- * Create by: Alfredo Barrios
-- * Created at: oct 9, 2020
-- *************************************************************************************************************************
	DECLARE v_IdUserArea INT;
	DECLARE v_IdOrganization INT;
	DECLARE v_IdOrganizationRole INT;
	DECLARE v_IdOrganizationAdded INT unsigned DEFAULT 0;
	-- Handler error
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;  -- rollback any error in the transaction
    END;
    IF (SELECT COUNT(*) FROM `bds_consola_universal`.`ctUsers` WHERE p_email=`email`) > 0 THEN
    BEGIN
		SIGNAL sqlstate '45000'
        SET MESSAGE_TEXT = 'EMAIL_ALREADY_EXISTS';
	END;
    END IF;
	START TRANSACTION;
		IF (SELECT COUNT(*) FROM `bds_consola_universal`.`ctUserAreas` WHERE p_area=`name`) = 0 THEN
			INSERT INTO `bds_consola_universal`.`ctUserAreas` (`name`, `Notify`) VALUES (p_area, 'N');
		END IF;    
		SELECT `IdUserArea` into v_IdUserArea FROM `bds_consola_universal`.`ctUserAreas` WHERE p_area=`name`;
		-- ********************************************************************************************************************
		IF (SELECT COUNT(*) FROM `bds_consola_universal`.`ctOrganizations` WHERE p_organization=`name`) = 0 THEN
			INSERT INTO `bds_consola_universal`.`ctOrganizations` (`Name`, `IdUserOnCharge`, `Created_Platform`, `Created_Datetime`) VALUES (p_organization, 1, p_platform, SYSDATE());
			SET v_IdOrganizationAdded = 1;
		END IF;
		SELECT `IdOrganization` into v_IdOrganization FROM `bds_consola_universal`.`ctOrganizations` WHERE p_organization=`name`;
		-- ********************************************************************************************************************
		IF (SELECT COUNT(*) FROM `bds_consola_universal`.`ctOrganizationRoles` WHERE p_organizationrole=`name`) = 0 THEN
			INSERT INTO `bds_consola_universal`.`ctOrganizationRoles` (`namees`) VALUES (p_organizationrole);
		END IF;
		SELECT `IdOrganizationRole` into v_IdOrganizationRole FROM `bds_consola_universal`.`ctOrganizationRoles` WHERE p_organizationrole=`name`;
		-- ********************************************************************************************************************
		UPDATE `bds_consola_universal`.`ctUsers` SET
        `IdUserArea`=v_IdUserArea, 
        `Password`=p_password, 
        `Enabled`=p_enabled, 
        `Name`=p_name, 
        `Lastname`=p_lastname, 
        `Email`=p_email, 
        `Superuser`=p_superuser, 
        `IdOrganization`=v_IdOrganization, 
        `IdOrganizationRole`=v_IdOrganizationRole, 
        `photo`=p_photo, 
        `Updated_Platform`=p_platform, 
        `Updated_Datetime`=SYSDATE()
        WHERE
        p_iduser=`iduser`;
    COMMIT;
    SELECT usr.`IdUser`
    , usr.`IdUserArea`
    , usra.`name` AS `UserArea`
    , usr.`IdOrganization`
    , orgn.`name` AS `Organization`
    , usr.`IdOrganizationRol`
    , orgr.`nameES` AS `OrganizationRol`
    , usr.`Password`
    , usr.`Name`
    , usr.`Lastname`
    , usr.`Email`
    , usr.`Superuser`
    , usr.`Confirmed`
    , usr.`Photo`
    , usr.`Enabled`
    , usr.`Created_Datetime`
    , usr.`Created_Platform`
    , usr.`Updated_Datetime`
    , usr.`Updated_Platform` 
    FROM `bds_consola_universal`.`ctUsers` usr INNER JOIN `bds_consola_universal`.`ctUserAreas` usra ON usr.`IdUserArea`= usra.`IdUserArea`
    INNER JOIN `bds_consola_universal`.`ctOrganizations` orgn ON usr.`IdOrganization`= orgn.`IdOrganization`
    LEFT OUTER JOIN `bds_consola_universal`.`ctOrganizationRoles` orgr ON orgr.`IdOrganizationRole`=usr.`IdOrganizationRole`
    WHERE p_iduser = usr.iduser;
END
$$
DELIMITER ;
