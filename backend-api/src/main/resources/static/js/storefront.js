function filterSelection(filter) {
  // Grab all sections inside filter-container
  const sections = document.querySelectorAll('.filter-container > div');
  
  // Hide all sections
  sections.forEach(section => {
    section.classList.remove('active');
  });

  // Show the selected section
  const selected = document.querySelector('.filter-container .' + filter);
  if (selected) {
    selected.classList.add('active');
  }

  // Update button states
  const buttons = document.querySelectorAll('.filterBtn');
  buttons.forEach(btn => {
    btn.classList.remove('active');
    if (btn.dataset.filter === filter) {
      btn.classList.add('active');
    }
  });
}

/*
* Add product modal form
*/

// Get elements
const modal = document.getElementById("productModal");
const openBtn = document.getElementById("openModal");
const closeBtn = document.querySelector(".close");

// Open modal
openBtn.addEventListener("click", () => {
  modal.style.display = "block";
  modal.style.display = "flex";
});

// Close modal
closeBtn.addEventListener("click", () => {
  modal.style.display = "none";
});

// Close when clicking outside modal
window.addEventListener("click", (event) => {
  if (event.target === modal) {
    modal.style.display = "none";
  }
});

// Handle form submission
document.getElementById("productForm").addEventListener("submit", (e) => {
  e.preventDefault();
  // Collect form data
  const name = document.getElementById("productName").value;
  const price = document.getElementById("productPrice").value;
  const description = document.getElementById("productDescription").value;
  const images = document.getElementById("productImage").files;

  console.log("Product created:", { name, price, description, images });

  // Close modal after save
  modal.style.display = "none";
});
