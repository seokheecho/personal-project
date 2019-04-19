'use strict'

var liTemplateSrc = $('#li-template').text();
var template = Handlebars.compile(liTemplateSrc);

loadList();

$('#photolog-list').on('click', 'li', (e) => {
    $('#photolog-list li.list-group-item-secondary')
        .removeClass('list-group-item-secondary');
    $(e.target).addClass('list-group-item-secondary');

    var no = $(e.target).attr('data-no');
    $(document.body).trigger('show.detail', [no]);
});

$(document.body).on('refresh.list', () => loadList());

function loadList() {
    $.getJSON(`${serverApiAddr}/json/photolog/list`, (result) => {
        var html = template(result);
        $('#photolog-list').html(html);
        $('#photolog-list li:first-child').click();
    })
}
