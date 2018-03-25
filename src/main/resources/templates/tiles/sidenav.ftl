<div class="cixp-drawer mdl-layout__drawer mdl-color--blue-grey-900 mdl-color-text--blue-grey-50">
    <header class="cixp-drawer-header">
        <div class="mdl-layout-spacer"></div>
        <div class="cixp-avatar-dropdown">
            <img src="${requestContext.contextPath}/images/consilium.logo.png" class="cixp-avatar">
            <p>
                <h4>SPRING PETCLINIC</h4>
            </p>
        </div>
    </header>
    <nav class="cixp-navigation mdl-navigation mdl-color--blue-grey-800">
        <a class="mdl-navigation__link" href="${requestContext.contextPath}/">
            <i class="mdl-color-text--blue-grey-400 material-icons" role="presentation">home</i>
            <span>HOME</span>
        </a>
        <a class="mdl-navigation__link" href="${requestContext.contextPath}/owners/list">
            <i class="mdl-color-text--blue-grey-400 material-icons" role="presentation">people</i>
            <span>OWNER LIST</span>
        </a>
        <a class="mdl-navigation__link" href="${requestContext.contextPath}/">
            <i class="mdl-color-text--blue-grey-400 material-icons" role="presentation">local_hospital</i>
            <span>VETERINARIANS</span>
        </a>
        <a class="mdl-navigation__link" href="${requestContext.contextPath}/error">
            <i class="mdl-color-text--blue-grey-400 material-icons" role="presentation">error</i>
            <span>ERRORS</span>
        </a>
        <div class="mdl-layout-spacer"></div>
    </nav>
</div>