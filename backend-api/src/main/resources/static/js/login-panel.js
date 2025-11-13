// View login panel when profile icon is clicked
const profile = document.getElementById('profile');
const loginPanel = document.getElementById('login-panel');

profile.addEventListener('click', () => {
    loginPanel.classList.toggle('show');
});
