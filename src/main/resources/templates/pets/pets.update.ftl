<@layout title="UPDATE PET">
<div class="pet-clinic-charts mdl-color--white mdl-cell mdl-cell--12-col mdl-grid">
    <div class="mdl-card mdl-cell mdl-cell--12-col mdl-cell--8-col-tablet mdl-cell--12-col-desktop">
        <div class="mdl-card__title mdl-color-text--white mdl-card--expand mdl-color--blue-grey-800">
            <h2 class="mdl-card__title-text mdl-typography--font-bold">
                <span>UPDATE PET</span>
            </h2>
        </div>
        <form id="update-owner-form" name="pet" action="${requestContext.contextPath}/owners/${owner.id}/pets/new" method="post">
            <div class="mdl-card__supporting-text mdl-color-text--grey-600">
                <#include "pets.details.form.ftl">
            </div>
            <div class="mdl-card__actions mdl-card--border">
                <button class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" type="submit">
                    <i class="material-icons">update</i>
                    <span>UPDATE PET</span>
                </button>
            </div>
        </form>
    </div>
</div>
</@layout>