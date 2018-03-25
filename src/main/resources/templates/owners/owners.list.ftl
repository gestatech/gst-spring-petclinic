<@layout title="OWNERS LIST">
<div class="cixp-mdl-grid mdl-color--white mdl-cell mdl-cell--12-col mdl-grid">
    <div class="mdl-card mdl-cell mdl-cell--12-col mdl-cell--8-col-tablet mdl-cell--12-col-desktop">
        <div class="mdl-card__supporting-text mdl-color-text--grey-600">
            <div class="mdl-card__title" style="padding-bottom: 10px;padding-top: 10px;">
                <div class="mdl-layout-spacer"></div>
            </div>
            <#include "owners.list.search.form.ftl">
            <div class="mdl-card__title" style="padding-bottom: 10px;padding-top: 10px;">
                <div class="mdl-layout-spacer"></div>
            </div>
            <table id="owners-list-paginated"
                   class="mdl-data-table mdl-typography--text-left mdl-shadow--2dp" style="width:100%">
                <thead>
                <tr>
                    <th><span>ID</span></th>
                    <th><span>FIRST NAME</span></th>
                    <th><span>LAST NAME</span></th>
                    <th><span>ADDRESS</span></th>
                    <th><span>CITY</span></th>
                    <th><span>TELEPHONE</span></th>
                    <th><span>DATE OF BIRTH</span></th>
                    <th><span>AGE</span></th>
                    <th><span></span></th>
                </tr>
                </thead>
                <tbody></tbody>
            </table>
        </div>
    </div>
</div>
</@layout>