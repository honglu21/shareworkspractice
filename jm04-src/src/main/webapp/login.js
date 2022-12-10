$(function () {
    var username = $('#username');
    var password = $('#password');
    var login = $('#login');

    login.click(function () {
        window.location.href =
            ("Richard" === username.val() && "Raoul" === password.val()) ?
            "login_success.html" :
            "login_fail.html";
    })

});
