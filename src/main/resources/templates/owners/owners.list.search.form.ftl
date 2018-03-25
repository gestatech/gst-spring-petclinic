<form id="owners-list-paginated-search-form" class="mdl-color--grey-100" onsubmit="return false">
    <fieldset class="cixp-fieldset">
        <legend class="mdl-typography--font-bold mdl-color-text--indigo">FILTER By</legend>
        <div class="mdl-card__supporting-text mdl-color-text--grey-600">
            <div>
                <button class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" disabled>
                    <span class="mdl-color-text--grey-600"></span>
                </button>
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input id="lastNameSearchField" class="mdl-textfield__input" type="text" autocomplete="off">
                    <label class="mdl-textfield__label" for="lastNameSearchField">LAST NAME</label>
                </div>
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input id="firstNameSearchField" class="mdl-textfield__input" type="text"  autocomplete="off">
                    <label class="mdl-textfield__label" for="firstNameSearchField">PET NAME</label>
                </div>
                <#--<div>-->
                <#--DATE OF BITH (From) <input id="minimunDateOfBirthSearchField" type="text" value="">-->
                <#--DATE OF BITH (To) <input id="maximunDateOfBirthSearchField" type="text" value="">-->
                <#--</div>-->
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input id="searchAllSearchField" class="mdl-textfield__input" type="text" autocomplete="off">
                    <label class="mdl-textfield__label" for="searchAllSearchField">SEARCH ALL</label>
                </div>
                <button id="button-reset" class="mdl-button mdl-button--colored mdl-button--raised mdl-js-button mdl-js-ripple-effect" type="submit">
                    <i class="material-icons" role="presentation">refresh</i>
                    <span>RESET</span>
                </button>
            </div>
        </div>
    </fieldset>
</form>