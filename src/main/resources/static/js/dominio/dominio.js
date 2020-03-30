//Mostrar datos en el modal de desactivar dominio
$('#disable-modal').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget) // Button that triggered the modal
    var recipient_code_domain = button.data('code_domain') // Extract info from data-* attributes
    var recipient_id = button.data('id')
    // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
    // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
    var modal = $(this)
    var modal_title = modal.find('.modal-title');
    modal_title.text(modal_title.text() + ' ' + recipient_code_domain)
    var a = modal.find('.modal-body a')[0];
    a.href = a.href + recipient_id;

})

//Mostrar datos en el modal de activar dominio
$('#enable-modal').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget) // Button that triggered the modal
    var recipient_code_domain = button.data('code_domain') // Extract info from data-* attributes
    var recipient_id = button.data('id')
    // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
    // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
    var modal = $(this)
    var modal_title = modal.find('.modal-title');
    modal_title.text(modal_title.text() + ' ' + recipient_code_domain)
    var a = modal.find('.modal-body a')[0];
    a.href = a.href + recipient_id;

})