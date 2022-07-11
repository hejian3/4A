-- clientdetails definition

CREATE TABLE `clientdetails` (
                                 `appId` varchar(256) NOT NULL,
                                 `resourceIds` varchar(256) DEFAULT NULL,
                                 `appSecret` varchar(256) DEFAULT NULL,
                                 `scope` varchar(256) DEFAULT NULL,
                                 `grantTypes` varchar(256) DEFAULT NULL,
                                 `redirectUrl` varchar(256) DEFAULT NULL,
                                 `authorities` varchar(256) DEFAULT NULL,
                                 `access_token_validity` int(11) DEFAULT NULL,
                                 `refresh_token_validity` int(11) DEFAULT NULL,
                                 `additionalInformation` varchar(4096) DEFAULT NULL,
                                 `autoApproveScopes` varchar(256) DEFAULT NULL,
                                 PRIMARY KEY (`appId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- oauth_access_token definition

CREATE TABLE `oauth_access_token` (
                                      `token_id` varchar(255) DEFAULT NULL,
                                      `token` longblob,
                                      `authentication_id` varchar(255) DEFAULT NULL,
                                      `user_name` varchar(255) DEFAULT NULL,
                                      `client_id` varchar(255) DEFAULT NULL,
                                      `authentication` longblob,
                                      `refresh_token` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- oauth_approvals definition

CREATE TABLE `oauth_approvals` (
                                   `userId` varchar(255) DEFAULT NULL,
                                   `clientId` varchar(255) DEFAULT NULL,
                                   `scope` varchar(255) DEFAULT NULL,
                                   `status` varchar(10) DEFAULT NULL,
                                   `expiresAt` datetime DEFAULT NULL,
                                   `lastModifiedAt` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- oauth_client_details definition

CREATE TABLE `oauth_client_details` (
                                        `client_id` varchar(255) NOT NULL,
                                        `resource_ids` varchar(255) DEFAULT NULL,
                                        `client_secret` varchar(255) DEFAULT NULL,
                                        `scope` varchar(255) DEFAULT NULL,
                                        `authorized_grant_types` varchar(255) DEFAULT NULL,
                                        `web_server_redirect_uri` varchar(255) DEFAULT NULL,
                                        `authorities` varchar(255) DEFAULT NULL,
                                        `access_token_validity` int(11) DEFAULT NULL,
                                        `refresh_token_validity` int(11) DEFAULT NULL,
                                        `additional_information` varchar(255) DEFAULT NULL,
                                        `autoapprove` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- oauth_client_token definition

CREATE TABLE `oauth_client_token` (
                                      `token_id` varchar(255) DEFAULT NULL,
                                      `token` longblob,
                                      `authentication_id` varchar(255) DEFAULT NULL,
                                      `user_name` varchar(255) DEFAULT NULL,
                                      `client_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- oauth_code definition

CREATE TABLE `oauth_code` (
                              `code` varchar(255) DEFAULT NULL,
                              `authentication` varbinary(2550) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- oauth_refresh_token definition

CREATE TABLE `oauth_refresh_token` (
                                       `token_id` varchar(255) DEFAULT NULL,
                                       `token` longblob,
                                       `authentication` longblob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- t_ge_privilege definition

CREATE TABLE `t_ge_privilege` (
                                  `PRIVILEGE_ID` int(11) NOT NULL,
                                  `PRIVILEGE_NAME` varchar(80) NOT NULL,
                                  `PRIVILEGE_CODE` varchar(80) DEFAULT NULL,
                                  `PRIVILEGE_DESC` varchar(255) DEFAULT NULL,
                                  `IS_DEL` smallint(6) DEFAULT NULL,
                                  `CREATED_TIME` datetime DEFAULT NULL,
                                  `CREATED_BY` int(11) DEFAULT NULL,
                                  `UPDATED_TIME` datetime DEFAULT NULL,
                                  `UPDATED_BY` int(11) DEFAULT NULL,
                                  PRIMARY KEY (`PRIVILEGE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;


-- t_ge_role definition

CREATE TABLE `t_ge_role` (
                             `ROLE_ID` int(11) NOT NULL AUTO_INCREMENT,
                             `ROLE_NAME` varchar(80) NOT NULL,
                             `ROLE_CODE` varchar(80) DEFAULT NULL,
                             `ROLE_DESC` varchar(255) DEFAULT NULL,
                             `IS_DEL` smallint(6) DEFAULT NULL,
                             `CREATED_TIME` datetime DEFAULT NULL,
                             `CREATED_BY` int(11) DEFAULT NULL,
                             `UPDATED_TIME` datetime DEFAULT NULL,
                             `UPDATED_BY` int(11) DEFAULT NULL,
                             PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;


-- t_ge_role_to_privilege definition

CREATE TABLE `t_ge_role_to_privilege` (
                                          `ID` int(11) NOT NULL,
                                          `PRIVILEGE_ID` int(11) DEFAULT NULL,
                                          `ROLE_ID` int(11) DEFAULT NULL,
                                          PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;


-- t_ge_user definition

CREATE TABLE `t_ge_user` (
                             `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
                             `CLIENT_ID` varchar(255) NOT NULL,
                             `USER_NAME` varchar(80) NOT NULL,
                             `USER_DESC` varchar(255) DEFAULT NULL,
                             `PASSWORD` varchar(60) DEFAULT NULL,
                             `GENDER` tinyint(1) DEFAULT NULL,
                             `BIRTHDAY` date DEFAULT NULL,
                             `MOBILE` varchar(20) DEFAULT NULL,
                             `EMAIL` varchar(100) DEFAULT NULL,
                             `ENABLED` tinyint(1) DEFAULT NULL,
                             `ACCOUNT_NON_EXPIRED` tinyint(1) DEFAULT NULL,
                             `ACCOUNT_NON_LOCKED` tinyint(1) DEFAULT NULL,
                             `CREDENTIALS_NON_EXPIRED` tinyint(1) DEFAULT NULL,
                             `IS_DEL` tinyint(1) DEFAULT NULL,
                             `CREATED_TIME` datetime DEFAULT NULL,
                             `CREATED_BY` int(11) DEFAULT NULL,
                             `UPDATED_TIME` datetime DEFAULT NULL,
                             `UPDATED_BY` int(11) DEFAULT NULL,
                             PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;


-- t_ge_user_to_role definition

CREATE TABLE `t_ge_user_to_role` (
                                     `ID` int(11) NOT NULL,
                                     `USER_ID` int(11) DEFAULT NULL,
                                     `ROLE_ID` int(11) DEFAULT NULL,
                                     PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;


INSERT INTO oauth_client_details (client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove) VALUES ('test', 'test', '$2a$10$1xICToc33sSLBsdgytE62OI2eehgfcmpZRXuPWFjtPZHEdBYsnv8K', 'read,write', 'client_credentials,password', null, null, null, null, null, null);

INSERT INTO t_ge_privilege (PRIVILEGE_ID, PRIVILEGE_NAME, PRIVILEGE_CODE, PRIVILEGE_DESC, IS_DEL, CREATED_TIME, CREATED_BY, UPDATED_TIME, UPDATED_BY) VALUES (1, '查看hello world', 'view_hello_world', '查看hello world', 0, '2022-06-29 00:00:00', 1, '2022-06-29 00:00:00', 1);

INSERT INTO t_ge_role (ROLE_ID, ROLE_NAME, ROLE_CODE, ROLE_DESC, IS_DEL, CREATED_TIME, CREATED_BY, UPDATED_TIME, UPDATED_BY) VALUES (1, '测试', 'test', '测试', 0, '2022-06-29 00:00:00', 1, '2022-06-29 00:00:00', 1);

INSERT INTO t_ge_role_to_privilege (ID, PRIVILEGE_ID, ROLE_ID) VALUES (1, 1, 1);

INSERT INTO t_ge_user (USER_ID, CLIENT_ID, USER_NAME, USER_DESC, PASSWORD, GENDER, BIRTHDAY, MOBILE, EMAIL, ENABLED, ACCOUNT_NON_EXPIRED, ACCOUNT_NON_LOCKED, CREDENTIALS_NON_EXPIRED, IS_DEL, CREATED_TIME, CREATED_BY, UPDATED_TIME, UPDATED_BY) VALUES (1, 'test', 'admin', '超级管理员', '$2a$10$QZEKAGswBu4S8UzJh5uysOozR7lQUL05ZXIoJq7GGc0nKCM6FRZFq', 0, null, null, null, 1, 1, 1, 1, 0, '2022-06-29 00:00:00', 1, '2022-06-29 00:00:00', 1);

INSERT INTO t_ge_user_to_role (ID, USER_ID, ROLE_ID) VALUES (1, 1, 1);
