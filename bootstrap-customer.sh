#!/usr/bin/env bash
mvn -U io.quarkus:quarkus-maven-plugin:create \
        -DprojectGroupId=org.khang.quarkus.orm \
        -DprojectArtifactId=customer \
        -DpackageName="org.khang.quarkus.jpa" \
        -Dextensions="jdbc-mariadb, hibernate-orm"