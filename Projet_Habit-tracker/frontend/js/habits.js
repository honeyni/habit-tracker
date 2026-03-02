import { apiGet, apiPost } from './api.js';

const habitsList = document.getElementById('habits-list');
const addButton = document.getElementById('add-button');
const newHabitInput = document.getElementById('new-habit');

// Charger toutes les habitudes depuis l'API
async function loadHabits() {
  try {
    const habits = await apiGet('/habits'); // GET http://localhost:8080/api/habits
    habitsList.innerHTML = '';
    habits.forEach(habit => {
      const li = document.createElement('li');
      li.className = 'habit';
      li.innerHTML = `<label><input type="checkbox" ${habit.checked ? 'checked' : ''}> ${habit.name}</label>`;
      habitsList.appendChild(li);

      // Gérer le clic sur la case à cocher
      const checkbox = li.querySelector('input[type="checkbox"]');
      checkbox.addEventListener('change', async () => {
        try {
          await apiPost(`/habits/${habit.id}/toggle`, { checked: checkbox.checked });
          // Optionnel : recharger les stats ou la liste si nécessaire
        } catch (err) {
          console.error('Erreur toggle habit:', err);
        }
      });
    });
  } catch (err) {
    console.error('Erreur chargement habitudes:', err);
  }
}

// Ajouter une nouvelle habitude via l'API
addButton.addEventListener('click', async () => {
  const name = newHabitInput.value.trim();
  if (!name) return;
  try {
    await apiPost('/habits', { name }); // POST /habits { name }
    newHabitInput.value = '';
    loadHabits(); // recharger la liste
  } catch (err) {
    console.error('Erreur ajout habitude:', err);
  }
});

// Initialisation
loadHabits();
