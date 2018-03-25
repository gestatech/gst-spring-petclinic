<@layout title="FIND OWNERS">
<div class="pet-clinic-charts mdl-color--white mdl-cell mdl-cell--12-col mdl-grid">
    <div class="mdl-card mdl-cell mdl-cell--12-col mdl-cell--8-col-tablet mdl-cell--12-col-desktop">
        <div class="mdl-card__title mdl-color-text--white mdl-card--expand mdl-color--blue-grey-800">
            <span><h2 class="mdl-card__title-text mdl-typography--font-bold">FIND OWNER</h2></span>
        </div>
        <form id="search-owner-form" name="owner" action="${requestContext.contextPath}/owners/list" method="get">
            <div class="mdl-card__supporting-text mdl-color-text--grey-600">
                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="text" id="lastName" name="lastName">
                    <label class="mdl-textfield__label" for="lastName">Last name</label>
                </div>
            </div>
            <div id="search-owner-form-card__actions" class="mdl-card__actions mdl-card--border">
                <button class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" type="submit">
                    <i class="material-icons">search</i>
                    <span>FIND OWNER</span>
                </button>
                <a href="${requestContext.contextPath}/owners/new"
                   class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
                    <i class="material-icons">add_circle_outline</i>
                    <span>ADD OWNER</span>
                </a>
            </div>
        </form>
    </div>
</div>
</@layout>