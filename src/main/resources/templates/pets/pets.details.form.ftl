<div id="pet-owner">
    <input type="hidden" name="id" value="${id!}"/>
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <span>Pet Owner: ${(pet.owner.firstName)!} ${(pet.owner.lastName)!}</span>
    </div>
</div>
<div id="pet-details">
    <div id="name">
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
            <input class="mdl-textfield__input" type="text" type="text"
                   id="name" name="name" value="${(pet.name)!}">
            <label class="mdl-textfield__label" for="name">Pet Name</label>
        </div>
    </div>
    <div id="birthDate">
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
            <input class="mdl-textfield__input" type="text" type="text"
                   id="birthDate" name="birthDate" value="${(pet.birthDate)!}">
            <label class="mdl-textfield__label" for="birthDate">Birth date</label>
        </div>
    </div>
    <div id="type">
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
            <input class="mdl-textfield__input" type="text" type="text"
                   id="type" name="type" value="${(pet.type)!}">
            <label class="mdl-textfield__label" for="type">Type</label>
        </div>
    </div>
</div>
