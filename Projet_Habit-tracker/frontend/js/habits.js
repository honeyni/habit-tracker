import { apiGet, apiPost } from './api.js';

const habitsList = document.getElementById('habits-list');
const addButton = document.getElementById('add-button');
const newHabitInput = document.getElementById('new-habit');

async function loadHabits() {
  try {
    const habits = await apiGet('/habits');
    habitsList.innerHTML = '';
    habits.forEach(habit => {
      const li = document.createElement('li');
      li.className = 'habit';
      li.innerHTML = `<label><input type="checkbox" ${habit.checked ? 'checked' : ''}> ${habit.name}</label>`;
      habitsList.appendChild(li);

      const checkbox = li.querySelector('input[type="checkbox"]');
      checkbox.addEventListener('change', async () => {
        try {
          await apiPost(`/habits/${habit.id}/toggle`, { checked: checkbox.checked });
        } catch (err) {
          console.error('Erreur toggle habit:', err);
        }
      });
    });
  } catch (err) {
    console.error('Erreur chargement habitudes:', err);
  }
}

addButton.addEventListener('click', async () => {
  const name = newHabitInput.value.trim();
  if (!name) return;
  try {
    await apiPost('/habits', { name }); 
    newHabitInput.value = '';
    loadHabits()
  } catch (err) {
    console.error('Erreur ajout habitude:', err);
  }
});

loadHabits();
