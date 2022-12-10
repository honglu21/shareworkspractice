$(function () {
    var title = $('#title');
    var description = $('#description');
    var add = $('#add');
    var entries = $('#entries');

    add.click(function () {
        entries.append($('<p><b>' +title.val()+'</b></p>'));
        entries.append($('<p>' +description.val()+'</p>'));
    })

});
