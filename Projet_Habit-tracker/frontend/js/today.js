import { apiGet, apiPost } from './api.js';

const todayList = document.getElementById('today-list');
const addButton = document.getElementById('add-button');
const newHabitInput = document.getElementById('new-today');

async function loadToday() {
  try {
    const todayHabits = await apiGet('/today');
    todayList.innerHTML = '';
    todayHabits.forEach(habit => {
      const li = document.createElement('li');
      li.className = 'habit today';
      li.innerHTML = `<label><input type="checkbox" ${habit.todayChecked ? 'checked' : ''}> ${habit.name}</label>`;
      todayList.appendChild(li);

      const checkbox = li.querySelector('input[type="checkbox"]');
      checkbox.addEventListener('change', async () => {
        try {
          await apiPost(`/today/${habit.id}/toggle`, { checked: checkbox.checked });
        } catch (err) {
          console.error('Erreur toggle today habit:', err);
        }
      });
    });
  } catch (err) {
    console.error('Erreur chargement today:', err);
  }
}


addButton?.addEventListener('click', async () => {
  const name = newHabitInput.value.trim();
  if (!name) return;
  try {
    await apiPost('/today', { name });
    newHabitInput.value = '';
    loadToday();
  } catch (err) {
    console.error('Erreur ajout today habit:', err);
  }
});

loadToday();
