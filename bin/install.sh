#!/bin/bash
# 部署脚本
exec mvn clean source:jar javadoc:javadoc install -Dmaven.test.skip=false -Dmaven.javadoc.skip=false
