$('#btnAdd').on('click', function () {
    console.log('in');
    $('#storeModal').modal('show');
});

$("#ccNumber").mask('9999999999999999');

$("#ccPIN").mask('9999');