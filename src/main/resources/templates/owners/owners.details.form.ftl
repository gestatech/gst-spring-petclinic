<div id="name">
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <input class="mdl-textfield__input" type="text"
               id="firstName" name="firstName" value="${(owner.firstName)!}">
        <label class="mdl-textfield__label" for="firstName">First Name</label>
    </div>
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <input class="mdl-textfield__input" type="text"
               id="lastName" name="lastName" value="${(owner.lastName)!}">
        <label class="mdl-textfield__label" for="lastName">Last Name</label>
    </div>
</div>
<div id="contact">
    <div id="address">
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
            <input class="mdl-textfield__input" type="text" type="text"
                   id="address" name="address" value="${(owner.address)!}">
            <label class="mdl-textfield__label" for="address">Address</label>
        </div>
    </div>
    <div id="city">
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
            <input class="mdl-textfield__input" type="text" type="text"
                   id="city" name="city" value="${(owner.city)!}">
            <label class="mdl-textfield__label" for="city">City</label>
        </div>
    </div>
    <div id="telephone">
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
            <input class="mdl-textfield__input" type="text" pattern="-?[0-9]*(\.[0-9]+)?"
                   id="telephone" name="telephone" value="${(owner.telephone)!}">
            <label class="mdl-textfield__label" for="telephone">Telephone</label>
            <span class="mdl-textfield__error">Telephone must be a number!</span>
        </div>
    </div>
</div>
