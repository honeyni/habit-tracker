import { apiGet, apiPost } from './api.js';

const todayList = document.getElementById('today-list');
const addButton = document.getElementById('add-button');
const newHabitInput = document.getElementById('new-today');

async function loadToday() {
  try {
    const habits = await apiGet('/habits');

    todayList.innerHTML = '';

    habits.forEach(habit => {
      const li = document.createElement('li');
      li.className = 'habit today';
      li.textContent = habit.name;
      todayList.appendChild(li);
    });
  } catch (err) {
    console.error('Erreur chargement habits:', err);
  }
}

addButton.addEventListener('click', async () => {
  const name = newHabitInput.value.trim();

  if (!name) {
    return;
  }

  try {
    await apiPost('/habits', {
      name: name,
      description: 'Habitude ajoutée depuis le frontend',
      target: 1
    });

    newHabitInput.value = '';
    loadToday();
  } catch (err) {
    console.error('Erreur ajout habit:', err);
  }
});

loadToday();
