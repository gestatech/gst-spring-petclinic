<@layout title="EXCEPTION">
<div class="cixp-cards mdl-cell mdl-cell--12-col mdl-cell--8-col-tablet mdl-grid mdl-grid--no-spacing">
    <div class="cixp-index-logo mdl-card mdl-shadow--2dp mdl-cell mdl-cell--12-col mdl-cell--8-col-tablet mdl-cell--12-col-desktop">
        <div class="mdl-card__title  mdl-card--expand mdl-color--red-500">
            <h2 class="mdl-card__title-text mdl-color-text--white mdl-typography--font-bold">
                <span>CIxP has encountered an error</span>
            </h2>
        </div>
        <div class="mdl-card__supporting-text mdl-color-text--grey-600 mdl-typography--font-bold">
            <#if errorAttributes??>
                <p><strong>TIMESTAMP:</strong> ${(errorAttributes.timestamp?datetime)!}</p>
                <p><strong>HTTP STATUS:</strong> ${(errorAttributes.status)!}</p>
                <p><strong>HTTP ERROR:</strong> ${(errorAttributes.error)!}</p>
                <p><strong>PATH:</strong> ${(errorAttributes.path)!}</p>
                <p><strong>MESSAGE:</strong> ${(errorAttributes.message)!}</p>
                <p><strong>EXCEPTION:</strong> ${(errorAttributes.exception)!}</p>
            </#if>
        </div>
    </div>
</div>
</@layout>