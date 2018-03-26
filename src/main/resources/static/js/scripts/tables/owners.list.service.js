$(document).ready(function () {

    var datePattern = 'yyyy-MM-dd HH:mm:ss.SSS';

    // $.fn.dataTable.moment(datePattern);

    var requestURL = requestContext() + '/owners/list-request';

    var ownersListPaginatedTable = $('#owners-list-paginated').DataTable({
        serverSide: true,
        deferRender: true,
        responsive: true,
        processing: true,
        stateSave: true,
        paging:true,
        lengthChang: false,
        pageLength: 100,
        lengthMenu: [25, 50,75, 100],
        pagingType: 'full_numbers',
        dom: 'lrtip',
        scroller:true,
        scrollY: 450,
        scrollCollapse:true,
        ajax: {
            url: requestURL,
            type: 'GET',
            cache: false
        },
        searchDelay: 800,
        language: {
            loadingRecords: '<div class="mdl-spinner mdl-js-spinner is-active" style="z-index: 9999;"></div>',
            processing: '<div class="mdl-spinner mdl-js-spinner is-active" style="z-index: 9999;"></div>',
            infoFiltered: ""
        },
        columns: [
            {data: 'id', name: "ID"},
            {data: 'firstName', name: "FIRST NAME", className: "mdl-typography--font-bold"},
            {data: 'lastName', name: "LAST NAME", className: "mdl-typography--font-bold"},
            {data: 'address', name: "ADDRESS", className: "mdl-typography--font-bold"},
            {data: 'city', name: "CITY", className: "mdl-typography--font-bold"},
            {data: 'telephone', name: "TELEPHONE", className: "mdl-typography--font-bold"},
            {data: 'dateOfBirth', name: "DATE OF BIRTH", className: "mdl-typography--font-bold" },
            {data: 'age', name: "AGE", className: "mdl-typography--font-bold"},
            {data: 'hasPets', name: "VIEW PETS"}
            //{data: 'pets[,].name', name: "PET NAME", className: "mdl-data-table__cell--non-numeric mdl-typography--font-bold", visible: false}
        ],
        columnDefs: [
            {targets: [0], visible: false},
            {
                targets: [2],
                render: function (data, type, row, meta) {
                    return '<a href="' + requestContext() + '/owners/' + row.id + '"' +
                           '   class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">' +
                                '<span>' + data + '</span>' +
                           '</a>';
                }
            },
            {
                targets: [8],
                render: function (data, type, row, meta) {
                    if(row.hasPets){
                        return '<a href="' + requestContext() + '/owners/' + row.id + '"' +
                                  'class="mdl-button mdl-button--colored mdl-button--raised mdl-js-button mdl-js-ripple-effect">' +
                                '<span>VIEW PETS</span>' +
                               '</a>';
                    } else {
                        return '<button class="mdl-button mdl-js-button mdl-js-ripple-effect" disabled>' +
                                    '<span>VIEW PETS</span>' +
                               '</button>';
                    }
                }
            }
        ]
    });

    ownersListPaginatedTable.columns.adjust().draw();

    var firstNameSearchField = $('#firstNameSearchField');
    var lastNameSearchField = $('#lastNameSearchField');

    firstNameSearchField.on('keyup change', function () {
        ownersListPaginatedTable.column(1).search(this.value).draw();
    });

    lastNameSearchField.on('keyup change', function () {
        ownersListPaginatedTable.column(2).search(this.value).draw();
    });

    var minimunDateOfBirthSearchField = $('#minimunDateOfBirthSearchField');
    var maximunDateOfBirthSearchField = $('#maximunDateOfBirthSearchField');

    minimunDateOfBirthSearchField.on('keyup change', function () {
        var fromDate = this.value;
        var toDate = maximunDateOfBirthSearchField.value;
        if((fromDate != null && moment(toDate, datePattern).isValid()) && (isNaN(toDate) || toDate == null)){
            ownersListPaginatedTable.search(convertToTimestamp(fromDate), false, true).draw();
        } else if(fromDate != null &&  toDate != null){
            ownersListPaginatedTable.search(convertToTimestamp(fromDate) +';'+ convertToTimestamp(toDate), false, true).draw();
        } else {
            if (ownersListPaginatedTable != null){
                ownersListPaginatedTable.column(6).search('');
                ownersListPaginatedTable.ajax.reload();
            }
        }
    });

    maximunDateOfBirthSearchField.on('keyup change', function () {
        var fromDate = minimunDateOfBirthSearchField.value;
        var toDate = this.value;
        if((isNaN(fromDate) || fromDate == null) && (toDate != null && moment(toDate, datePattern).isValid())){
            ownersListPaginatedTable.search(convertToTimestamp(toDate), false, true).draw();
        } else if(fromDate != null &&  toDate != null){
            ownersListPaginatedTable.search(convertToTimestamp(fromDate) +';'+ convertToTimestamp(toDate), false, true).draw();
        } else {
            if (ownersListPaginatedTable != null){
                ownersListPaginatedTable.column(6).search('');
                ownersListPaginatedTable.ajax.reload();
            }
        }
    });

    var cleaserSearchFields = function () {
        $('#owners-list-paginated-search-form')[0].reset();
        if (ownersListPaginatedTable != null){
            ownersListPaginatedTable.column(1).search('');
            ownersListPaginatedTable.column(2).search('');
            ownersListPaginatedTable.search('');
            ownersListPaginatedTable.clear();
        }
    };

    $('#button-reset').on('click', function () {
        cleaserSearchFields();
        ownersListPaginatedTable.ajax.reload();
    });

    setInterval(function (){
        cleaserSearchFields();
        ownersListPaginatedTable.ajax.reload();
    }, 600000);
});