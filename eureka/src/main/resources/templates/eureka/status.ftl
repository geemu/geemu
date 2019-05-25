<#import "/spring.ftl" as spring />
<!doctype html>
<!--[if lt IE 7]>
<html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>
<html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>
<html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js"> <!--<![endif]-->
<head>
    <base href="<@spring.url basePath/>">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Eureka</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">

    <link rel="stylesheet" href="eureka/css/wro.css">

</head>

<body id="one">
<#include "header.ftl">
<div class="container-fluid xd-container">
    <#include "navbar.ftl">
    <h1>当前在Eureka注册的实例</h1>
    <table id='instances' class="table table-striped table-hover">
        <thead>
        <tr>
            <th>应用</th>
            <th>AMIs</th>
            <th>可用性区域</th>
            <th>状态</th>
        </tr>
        </thead>
        <tbody>
        <#if apps?has_content>
            <#list apps as app>
                <tr>
                    <td><b>${app.name}</b></td>
                    <td>
                        <#list app.amiCounts as amiCount>
                            <b>${amiCount.key}</b> (${amiCount.value})<#if amiCount_has_next>,</#if>
                        </#list>
                    </td>
                    <td>
                        <#list app.zoneCounts as zoneCount>
                            <b>${zoneCount.key}</b> (${zoneCount.value})<#if zoneCount_has_next>,</#if>
                        </#list>
                    </td>
                    <td>
                        <#list app.instanceInfos as instanceInfo>
                            <#if instanceInfo.isNotUp>
                                <font color=red size=+1><b>
                            </#if>
                            <b>${instanceInfo.status}</b> (${instanceInfo.instances?size}) -
                            <#if instanceInfo.isNotUp>
                                </b></font>
                            </#if>
                            <#list instanceInfo.instances as instance>
                                <#if instance.isHref>
                                    <a href="${instance.url}" target="_blank">${instance.id}</a>
                                <#else>
                                    ${instance.id}
                                </#if><#if instance_has_next>,</#if>
                            </#list>
                        </#list>
                    </td>
                </tr>
            </#list>
        <#else>
            <tr>
                <td colspan="4">没有可用的实例</td>
            </tr>
        </#if>

        </tbody>
    </table>

    <h1>一般信息</h1>

    <table id='generalInfo' class="table table-striped table-hover">
        <thead>
        <tr>
            <th>属性</th>
            <th>值</th>
        </tr>
        </thead>
        <tbody>
        <#list statusInfo.generalStats?keys as stat>

            <#if stat == "total-avail-memory">
                <tr>
                    <td>总内存</td>
                    <td>${statusInfo.generalStats[stat]!""}</td>
                </tr>
            </#if>
            <#if stat == "environment">
                <tr>
                    <td>环境</td>
                    <td>${statusInfo.generalStats[stat]!""}</td>
                </tr>
            </#if>
            <#if stat == "num-of-cpus">
                <tr>
                    <td>CPU核心数</td>
                    <td>${statusInfo.generalStats[stat]!""}</td>
                </tr>
            </#if>
            <#if stat == "current-memory-usage">
                <tr>
                    <td>使用内存</td>
                    <td>${statusInfo.generalStats[stat]!""}</td>
                </tr>
            </#if>
            <#if stat == "server-uptime">
                <tr>
                    <td>服务器正常运行时间</td>
                    <td>${statusInfo.generalStats[stat]!""}</td>
                </tr>
            </#if>
        </#list>
        <#list statusInfo.applicationStats?keys as stat>
            <#if stat == "registered-replicas">
                <tr>
                    <td>注册中心副本</td>
                    <td>${statusInfo.applicationStats[stat]!""}</td>
                </tr>
            </#if>
            <#if stat == "unavailable-replicas">
                <tr>
                    <td>不可用副本</td>
                    <td>${statusInfo.applicationStats[stat]!""}</td>
                </tr>
            </#if>
            <#if stat == "available-replicas">
                <tr>
                    <td>可用副本</td>
                    <td>${statusInfo.applicationStats[stat]!""}</td>
                </tr>
            </#if>
        <#--            <tr>-->
        <#--                <td>${stat}</td>-->
        <#--                <td>${statusInfo.applicationStats[stat]!""}</td>-->
        <#--            </tr>-->
        </#list>
        </tbody>
    </table>

    <h1>实例信息</h1>

    <table id='instanceInfo' class="table table-striped table-hover">
        <thead>
        <tr>
            <th>属性</th>
            <th>值</th>
        </tr>
        <thead>
        <tbody>
        <#list instanceInfo?keys as key>
            <tr>
                <td>${key}</td>
                <td>${instanceInfo[key]!""}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
<script type="text/javascript" src="eureka/js/wro.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $('table.stripeable tr:odd').addClass('odd');
        $('table.stripeable tr:even').addClass('even');
    });
</script>
</body>
</html>
