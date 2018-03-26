<form id="owners-list-paginated-search-form" onsubmit="return false">
    <fieldset id="cixp-fieldset-id" class="cixp-fieldset mdl-color--grey-200">
        <legend>
            <button id="button-expend" class="mdl-button mdl-button--raised mdl-button--colored mdl-js-button mdl-js-ripple-effect" type="submit">
                <i class="material-icons mdl-color-text--white" role="presentation">import_export</i>
                <span class="mdl-typography--font-bold mdl-color-text--white">FILTER By</span>
            </button>
        </legend>
        <div class="mdl-card__supporting-text mdl-color-text--grey-600">
            <div class="row">
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input id="lastNameSearchField" class="mdl-textfield__input" type="text" autocomplete="off">
                    <label class="mdl-textfield__label" for="lastNameSearchField">LAST NAME</label>
                </div>
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input id="firstNameSearchField" class="mdl-textfield__input" type="text"  autocomplete="off">
                    <label class="mdl-textfield__label" for="firstNameSearchField">PET NAME</label>
                </div>
            </div>
            <div class="row">
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input id="minimunDateOfBirthSearchField"
                           class="mdl-textfield__input"
                           autocomplete="off" placeholder="YYYY-MM-DD HH:mm:ss.SSS">
                    <label class="mdl-textfield__label" for="minimunDateOfBirthSearchField">DATE OF BITH (FROM)</label>
                </div>
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input id="maximunDateOfBirthSearchField"
                           class="mdl-textfield__input"
                           autocomplete="off" placeholder="YYYY-MM-DD HH:mm:ss.SSS">
                    <label class="mdl-textfield__label" for="maximunDateOfBirthSearchField">DATE OF BITH (TO)</label>
                </div>
                <button id="button-reset" class="mdl-button mdl-button--colored mdl-button--raised mdl-js-button mdl-js-ripple-effect" type="submit">
                    <i class="material-icons" role="presentation">refresh</i>
                    <span>RESET</span>
                </button>
            </div>
        </div>
    </fieldset>
</form>