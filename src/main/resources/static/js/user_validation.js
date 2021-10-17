//Launch modal
$('#btnRegister').on('click', function () {
    $('#storeModal').modal('show');
});

//Password validation
$('[data-pass]').on('keyup', function () {
    var pass1 = $('#password').val();
    var pass2 = $('#passwordConfirm').val();

    if (pass1 == pass2) {
        $('#password').css("border-color", '#D1D3E2');
        $('#passwordConfirm').css("border-color", '#D1D3E2');
        $('#password').removeAttr('title');
        $('#passwordConfirm').removeAttr('title');
        $('#btnRegistrar').prop('disabled', false);
    } else {
        $('#password').css("border-color", "red");
        $('#passwordConfirm').css("border-color", "red");
        $('#passwordConfirm').attr('title', 'Passwords do not match each other');
        $('#password').attr('title', 'Passwords do not match each other');
        $('#btnRegistrar').prop('disabled', true);
    }
});

//Validation exists email
$('#email').keyup(function(){
    var email = $(this).val();

    $.get(`/api/users/${email}/exists-email`, function(res){
        if(res){
            $('#errorMessage').text('This email is already taken.');
            $('#errorMessage').show();
            $('#btnRegistrar').prop('disabled', true);
        }else{
            $('#errorMessage').hide();
            $('#btnRegistrar').prop('disabled', false);
        }
    });
});

//Validation exists id document
$('#idDocument').keyup(function(){
    var id = $(this).val();

    $.get(`/api/users/${id}/exists-id`, function(res){
        if(res){
            $('#errorMessage').text('This ID Document is already taken.');
            $('#errorMessage').show();
            $('#btnRegistrar').prop('disabled', true);
        }else{
            $('#errorMessage').hide();
            $('#btnRegistrar').prop('disabled', false);
        }
    });
});