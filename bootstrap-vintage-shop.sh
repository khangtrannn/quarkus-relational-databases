#!/usr/bin/env bash
mvn -U io.quarkus:quarkus-maven-plugin:create \
        -DprojectGroupId=org.khang.quarkus.orm \
        -DprojectArtifactId=vintage-store \
        -DpackageName="org.khang.quarkus.panache" \
        -Dextensions="jdbc-postgresql, hibernate-orm-panache"