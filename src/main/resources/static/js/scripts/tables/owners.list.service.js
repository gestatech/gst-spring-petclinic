$(document).ready(function () {

    var datePattern = 'YYYY/MM/DD HH:mm:ss.SSS';

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
        //pageLength: 25,
        //lengthMenu: [25, 50,75, 100],
        pagingType: 'full_numbers',
        dom: 'rti',
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
            loadingRecords: '<div class="mdl-spinner mdl-js-spinner is-active"></div>',
            processing: '<div class="mdl-spinner mdl-js-spinner is-active"></div>'
        },
        columns: [
            {data: 'id', name: "ID"},
            {data: 'firstName', name: "FIRST NAME", className: "mdl-data-table__cell--non-numeric mdl-typography--font-bold"},
            {data: 'lastName', name: "LAST NAME", className: "mdl-data-table__cell--non-numeric mdl-typography--font-bold"},
            {data: 'address', name: "ADDRESS", className: "mdl-data-table__cell--non-numeric mdl-typography--font-bold"},
            {data: 'city', name: "CITY", className: "mdl-data-table__cell--non-numeric mdl-typography--font-bold"},
            {data: 'telephone', name: "TELEPHONE", className: "mdl-data-table__cell--non-numeric mdl-typography--font-bold"},
            {data: 'dateOfBirth', name: "DATE OF BIRTH", className: "mdl-data-table__cell--non-numeric mdl-typography--font-bold" },
            {data: 'age', name: "AGE", className: "mdl-data-table__cell--non-numeric mdl-typography--font-bold"},
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
            // {
            //     targets: [6],
            //     render: function ( data, type, row, meta) {
            //         return (moment(data, datePattern).isValid()? moment(data).format(datePattern): '- - -');
            //     }
            // },
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

    var convertToTimestamp = function (dateString) {
        if(dateString != undefined && moment(dateString, datePattern).isValid()){
            var dateTimeParts = dateString.split(' ');
            var dateParts = dateTimeParts[0].split('/');
            var timeParts = dateTimeParts[1].split(':');
            var seconds = timeParts[2].split('.');
            var date = new Date(dateParts[0], parseInt(dateParts[1], 10) - 1, dateParts[2], timeParts[0], timeParts[1], seconds[0], seconds[1]);
            console.log('valid', date.getTime()/1000);
            return date.getTime()/1000;
        } else {
            console.log('invalid', dateString);
            return 00000000000;
        }
    };

    var minimunDateOfBirthSearchField = $('#minimunDateOfBirthSearchField');

    var maximunDateOfBirthSearchField = $('#maximunDateOfBirthSearchField');

    minimunDateOfBirthSearchField.on('keyup change', function () {
        var date = convertToTimestamp(this.value);
        ownersListPaginatedTable.search(date).draw();
    });

    maximunDateOfBirthSearchField.on('keyup change', function () {
        var date = convertToTimestamp(this.value);
        ownersListPaginatedTable.search(date).draw();
    });

    var firstNameSearchField = $('#firstNameSearchField');
    var lastNameSearchField = $('#lastNameSearchField');
    var searchAllSearchField = $('#searchAllSearchField');

    var cleaserSearchFields = function () {
        $('#owners-list-paginated-search-form')[0].reset();
        if (ownersListPaginatedTable != null){
            ownersListPaginatedTable.column(1).search('');
            ownersListPaginatedTable.column(2).search('');
            ownersListPaginatedTable.column(6).search('');
            ownersListPaginatedTable.search('');
            ownersListPaginatedTable.clear();
        }
    };

    firstNameSearchField.on('keyup change', function () {
        ownersListPaginatedTable.column(1).search(this.value).draw();
    });

    lastNameSearchField.on('keyup change', function () {
        ownersListPaginatedTable.column(2).search(this.value).draw();
    });

    searchAllSearchField.on('keyup change', function () {
        ownersListPaginatedTable.search(this.value).draw();
    });

    $('#button-reset').on('click', function () {
        cleaserSearchFields();
        ownersListPaginatedTable.ajax.reload();
    });

    setInterval(function (){
        cleaserSearchFields();
        ownersListPaginatedTable.ajax.reload();
    }, 600000);
});