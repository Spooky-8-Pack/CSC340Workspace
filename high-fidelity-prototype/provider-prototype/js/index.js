// Functionality for Features scroll
const rotateBtn = document.getElementById('right-rotate-button');
const imageRow = document.getElementById('featured-row');

rotateBtn.addEventListener('click', () => {
    imageRow.classList.add('slide-left');

    setTimeout(() => {
        imageRow.classList.remove('slide-left');
        
        const images = imageRow.querySelectorAll('.featured-item');
        const lastImage = images[images.length - 1];
        imageRow.insertBefore(lastImage, images[0]);
    }, 200);
});

// View login panel when profile icon is clicked
const profile = document.getElementById('profile');
const loginPanel = document.getElementById('login-panel');

profile.addEventListener('click', () => {
    loginPanel.classList.toggle('show');
});

// function clickOutside(element, closeWindow) {
//     document.addEventListener('click', (event) => {
//         if (!element.contains(event.target) && event.target !== element) {
//             callback();
//         }
//     })
// }

// function closeWindow {
//     loginPanel.classList.remove('.show');
// }