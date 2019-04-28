#!/bin/bash

# 帮助信息功能
Help(){
  echo "--------------------------------------------------------------------------"
  echo ""
  echo "使用: ./commons.sh [部署 | 生成JavaDoc | 打包]"
  echo ""
  echo "-install    部署 Commons 到本地Maven仓库."
  echo "-doc        为Commons生成Java Doc Api, 你可以在target目录中看到它"
  echo "-pack       使用Maven制作jar包"
  echo ""
  echo "--------------------------------------------------------------------------"
}


# 开始
./bin/logo.sh
case "$1" in
  'install')
    bin/install.sh
	;;
  'doc')
    bin/javadoc.sh
	;;
  'pack')
    bin/package.sh
	;;
  *)
    help
esac
