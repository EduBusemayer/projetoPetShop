document.getElementById('recSenha').addEventListener('submit', function(event) {
    event.preventDefault();
    showPopup();
});

function showPopup() {
    document.getElementById('popupOverlay').style.display = 'block';
    document.getElementById('successPopup').style.display = 'block';
}

function closePopup() {
    document.getElementById('popupOverlay').style.display = 'none';
    document.getElementById('successPopup').style.display = 'none';
}