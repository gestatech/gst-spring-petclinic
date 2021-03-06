<@layout title="OWNERS LIST">
<div class="mdl-card__supporting-text mdl-color-text--grey-600">
    <div class="mdl-card__title" style="padding-bottom: 10px;padding-top: 10px;">
        <div class="mdl-layout-spacer"></div>
    </div>
    <#include "owners.list.search.form.ftl">
    <div class="mdl-card__title" style="padding-bottom: 10px;padding-top: 10px;">
        <div class="mdl-layout-spacer"></div>
    </div>
    <table id="owners-list-paginated" class="display mdl-data-table mdl-typography--text-left mdl-shadow--2dp" style="width:100%" cellpadding="0" cellspacing="0" border="0">
        <thead>
        <tr>
            <th>ID</th>
            <th>FIRST NAME</th>
            <th>LAST NAME</th>
            <th>ADDRESS</th>
            <th>CITY</th>
            <th>TELEPHONE</th>
            <th>DATE OF BIRTH</th>
            <th>AGE</th>
            <th></th>
        </tr>
        </thead>
        <tbody></tbody>
    </table>
</div>
</@layout>