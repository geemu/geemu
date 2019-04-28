#!/bin/bash
# 使用 Versions Maven Plugin 来检测pom.xml 中使用的各个组件是否有新版本
mvn versions:display-dependency-updates
