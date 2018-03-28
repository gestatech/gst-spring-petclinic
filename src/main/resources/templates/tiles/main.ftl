<#macro layout title>
<!doctype html>
<html lang="${requestContext.locale.language}">
<head>
    <#include "head.ftl">
    <#include "scripts.ftl">
</head>
<body>
<div id="cixp-main-layout"
     class="cixp-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header"
     style="display: none">
    <#include "header.ftl">
    <#include "sidenav.ftl">
    <main class="mdl-layout__content mdl-color--grey-100">
        <div class="mdl-cell mdl-cell--12-col mdl-cell--8-col-tablet mdl-cell--12-col-desktop">
            <#nested>
        </div>
        <footer class="mdl-mini-footer mdl-color--white">
            <!-- Footer Content -->
        </footer>
        <div class="mdl-layout__obfuscator"></div>
    </main>
</div>
</body>
</html>
</#macro>