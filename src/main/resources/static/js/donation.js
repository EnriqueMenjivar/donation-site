$(function () {
    //Initialize Select2 Elements
    $('.select2bs4').select2({
        theme: 'bootstrap4'
    })
});

$('#country').on('change', function () {
    var idCountry = $(this).val();
    var html = '';

    $('#institutions').html("<option> Selected country does not have institutions </option>");
    $.get(`/api/countries/${idCountry}/institutions`, function (data) {
        if (data.length > 0) {
            data.forEach(institution => {
                html += `<option value="${institution.id}">${institution.name}</option>`;
            });
            $('#institutions').html("<option>Select an institution </option>" + html);
        }
    })

});