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