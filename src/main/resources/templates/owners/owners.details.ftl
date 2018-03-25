<@layout title="OWNER INFORMATION">
<div class="pet-clinic-charts mdl-color--white mdl-cell mdl-cell--12-col mdl-grid">
    <div class="mdl-card mdl-cell mdl-cell--12-col mdl-cell--8-col-tablet mdl-cell--12-col-desktop">
        <div class="mdl-card__title mdl-color-text--white mdl-card--expand mdl-color--blue-grey-800">
            <span><h2 class="mdl-card__title-text mdl-typography--font-bold">OWNER INFORMATION</h2></span>
        </div>
        <div class="mdl-card__supporting-text mdl-color-text--grey-600">
            <table id="owner-details" class="mdl-data-table mdl-js-data-table mdl-shadow--2dp" cellspacing="0" width="100%">
                <tbody>
                    <tr>
                        <th class="mdl-data-table__cell--non-numeric mdl-typography--font-bold">
                            <span>NAME</span>
                        </th>
                        <td>
                            <span>${owner.firstName} ${owner.lastName}</span>
                        </td>
                    </tr>
                    <tr>
                        <th class="mdl-data-table__cell--non-numeric mdl-typography--font-bold">
                            <span>ADDRESS</span>
                        </th>
                    <td>
                        <span>${owner.address}</span>
                    </td>
                    </tr>
                    <tr>
                        <th class="mdl-data-table__cell--non-numeric mdl-typography--font-bold">
                            <span>CITY</span>
                        </th>
                        <td>
                            <span>${owner.city}</span>
                        </td>
                    </tr>
                    <tr>
                        <th class="mdl-data-table__cell--non-numeric mdl-typography--font-bold">
                            <span>TELEPHONE</span>
                        </th>
                        <td>
                            <span>${owner.telephone}</span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <a href="${requestContext.contextPath}/owners/${owner.id}/edit"
                               class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
                                <i class="material-icons">mode_edit</i>
                                <span>EDIT OWNER</span>
                            </a>
                        </td>
                        <td>
                            <a href="${requestContext.contextPath}/owners/${owner.id}/pets/new"
                               class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
                                <i class="material-icons">add_circle_outline</i>
                                <span>ADD NEW PET</span>
                            </a>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<#if owner.pets?has_content >
<div class="pet-clinic-charts mdl-color--white mdl-cell mdl-cell--12-col mdl-grid">
    <div class="mdl-card mdl-cell mdl-cell--12-col mdl-cell--8-col-tablet mdl-cell--12-col-desktop">
        <div class="mdl-card__title mdl-color-text--white mdl-card--expand mdl-color--blue-grey-800">
            <span><h2 class="mdl-card__title-text mdl-typography--font-bold">PETS AND VISITS</h2></span>
        </div>
        <div class="mdl-card__supporting-text mdl-color-text--grey-600">
        <#list owner.pets as pet>
            <table id="pets-and-visits" class="mdl-data-table mdl-js-data-table mdl-shadow--2dp" cellspacing="0" width="100%">
                <tbody>
                    <tr>
                        <td>
                            <ul class="mdl-list">
                                <li class="mdl-list__item">
                                    <span class="mdl-list__item-primary-content">NAME</span>
                                    <span class="mdl-list__item-secondary-action">${pet.name}</span>
                                </li>
                                <li class="mdl-list__item">
                                    <span class="mdl-list__item-primary-content">BIRTH DATE</span>
                                    <span class="mdl-list__item-secondary-action">${pet.birthDate}</span>
                                </li>
                                <li class="mdl-list__item">
                                    <span class="mdl-list__item-primary-content">TYPE</span>
                                    <span class="mdl-list__item-secondary-action">${pet.type}</span>
                                </li>
                            </ul>
                        </td>
                        <td>
                            <table class="mdl-data-tablem dl-js-data-table mdl-shadow--2dp" cellspacing="0" width="100%"
                                <thead>
                                    <tr>
                                        <th class="mdl-typography--font-bold">VISIT DATE</th>
                                        <th class="mdl-typography--font-bold">DESCRIPTION</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <#list pet.visits as visit>
                                    <tr>
                                        <td>
                                            <span>${visit.date}</span>
                                        </td>
                                        <td>
                                            <span>${visit.description}</span>
                                        </td>
                                    </tr>
                                </#list>
                                    <tr>
                                        <td>
                                            <a href="${requestContext.contextPath}/owners/${owner.id}/pets/${pet.id}/edit"
                                               class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
                                                <i class="material-icons">mode_edit</i>
                                                <span>EDIT PET</span>
                                            </a>
                                        </td>
                                        <td>
                                            <a href="${requestContext.contextPath}/owners/${owner.id}/pets/${pet.id}/visits/new"
                                               class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
                                                <i class="material-icons">add_circle_outline</i>
                                                <span>ADD VISIT</span>
                                            </a>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </td>
                    </tr>
                </tbody>
            </table>
            <div class="mdl-layout-spacer"></div>
        </#list>
        </div>
    </div>
</div>
</#if>
</@layout>