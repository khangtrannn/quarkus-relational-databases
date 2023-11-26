#!/usr/bin/env bash
mvn -U io.quarkus:quarkus-maven-plugin:create \
        -DprojectGroupId=org.khang.quarkus.orm \
        -DprojectArtifactId=artist \
        -DpackageName="org.khang.quarkus.jdbc" \
        -Dextensions="jdbc-mysql, quarkus-agroal"