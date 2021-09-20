<!--
SPDX-FileCopyrightText: 2021 Alliander N.V.

SPDX-License-Identifier: Apache-2.0
-->

[![Maven Build Github Action Status](<https://img.shields.io/github/workflow/status/com-pas/compas-scl-data-service/Maven%20Build?logo=GitHub>)](https://github.com/com-pas/compas-scl-data-service/actions?query=workflow%3A%22Maven+Build%22)
[![REUSE status](https://api.reuse.software/badge/github.com/com-pas/compas-scl-data-service)](https://api.reuse.software/info/github.com/com-pas/compas-scl-data-service)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=com-pas_compas-scl-data-service&metric=alert_status)](https://sonarcloud.io/dashboard?id=com-pas_compas-scl-data-service)
[![LFX Security Status](https://img.shields.io/badge/dynamic/json?color=orange&label=LFX%20Security%20Tool&query=issues%5B%3F%28%40%5B%27repository-name%27%5D%20%3D%3D%20%27compas-scl-data-service%27%29%5D%5B%27high-open-issues%27%5D&suffix=%20High%20open%20issues&url=https%3A%2F%2Fapi.security.lfx.linuxfoundation.org%2Fv1%2Fproject%2Fe8b6fdf9-2686-44c5-bbaa-6965d04ad3e1%2Fissues)](https://security.lfx.linuxfoundation.org/#/e8b6fdf9-2686-44c5-bbaa-6965d04ad3e1/issues)
[![Slack](https://raw.githubusercontent.com/com-pas/compas-architecture/master/public/LFEnergy-slack.svg)](http://lfenergy.slack.com/)

# compas-scl-data-service

Service to store and retrieve the SCL XML to a database.

In the standard configuration this component is using Quarkus to run and create a native image from it. The different
parts of this repository can also be used separately in your own component to manage SCL XML Files in a database. The
Service Layer can be used as Java component to manage them.

For more information about the architecture take a look at [documentation](doc/compas-scl-data-service.md)

## Application depends on a running BaseX instance

Check [basexhttp on DockerHub](https://hub.docker.com/r/basex/basexhttp/) for a running BaseX docker container.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw package io.quarkus:quarkus-maven-plugin:2.2.3.Final:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `app/target/quarkus-app/` directory. Be aware that it’s not an _über-jar_ as
the dependencies are copied into the `app/target/quarkus-app/lib/` directory.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar app/target/quarkus-app/quarkus-run.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./app/target/code-with-quarkus-local-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html
.

## Environment variables

Below environment variable(s) can be used to configure the connection to BaseX, if BaseX Server is used.

| Environment variable             | Java Property             | Description                                   | Example          |
| -------------------------------- | ------------------------- | --------------------------------------------- | ---------------- |
| BASEX_HOST                       | basex.host                | Name of the Host where BaseX runs.            | localhost        |
| BASEX_PORT                       | basex.port                | Port on the Host on which BaseX runs.         | 1984             |
| BASEX_USERNAME                   | basex.username            | Username under which the application logs in. | admin            |
| BASEX_PASSWORD                   | basex.password            | Password of the username used above.          | admin            |

Below environment variable(s) can be used to configure which claims are used to fill the UserInfo response.

| Environment variable             | Java Property                  | Description                                   | Example          |
| -------------------------------- | ------------------------------ | --------------------------------------------- | ---------------- |
| USERINFO_NAME_CLAIMNAME          | compas.userinfo.name.claimname | The Name of the user logged in.               | name             |
| USERINFO_WHO_CLAIMNAME           | compas.userinfo.who.claimname  | The Name of the user used in the Who History. | name             |

## Security

To use most of the endpoints the users needs to be authenticated using JWT in the authorization header. There are 4
environment variables that can be set in the container to configure the validation/processing of the JWT.

| Environment variable             | Java Property                    | Description                                        | Example                                                                |
| -------------------------------- | -------------------------------- | -------------------------------------------------- | ---------------------------------------------------------------------- |
| JWT_VERIFY_KEY                   | smallrye.jwt.verify.key.location | Location of certificates to verify the JWT.        | http://localhost:8089/auth/realms/compas/protocol/openid-connect/certs |
| JWT_VERIFY_ISSUER                | mp.jwt.verify.issuer             | The issuer of the JWT.                             | http://localhost:8089/auth/realms/compas                               |
| JWT_VERIFY_CLIENT_ID             | mp.jwt.verify.audiences          | The Client ID that should be in the "aud" claim.   | scl-data-service                                                       |
| JWT_GROUPS_PATH                  | smallrye.jwt.path.groups         | The JSON Path where to find the roles of the user. | resource_access/scl-data-service/roles                                 |

The application uses the following list of roles. The fine-grained roles are built up of the types of SCL Files this
service supports and the rights READ/CREATE/UPDATE/DElETE. This way the mapping of the roles to groups/users can be
configured as needed.

- ICD_CREATE
- ICD_DELETE
- ICD_READ
- ICD_UPDATE
- SCD_CREATE
- SCD_DELETE
- SCD_READ
- SCD_UPDATE
- SSD_CREATE
- SSD_DELETE
- SSD_READ
- SSD_UPDATE
- ISD_CREATE
- ISD_DELETE
- ISD_READ
- ISD_UPDATE
- CID_CREATE
- CID_DELETE
- CID_READ
- CID_UPDATE
- IID_CREATE
- IID_DELETE
- IID_READ
- IID_UPDATE
- SED_CREATE
- SED_DELETE
- SED_READ
- SED_UPDATE
