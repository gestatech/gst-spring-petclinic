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
            <table id="owners-list-paginated" class="table table-striped table-bordered" cellspacing="0" width="100%">
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
    </div>
</div>
</@layout>