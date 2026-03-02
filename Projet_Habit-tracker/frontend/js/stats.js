import { apiGet } from './api.js';

const statsWeek = document.getElementById('stats-week');
const globalCircle = document.getElementById('global-circle');

async function loadStats() {
  try {
    const habits = await apiGet('/habits');
    statsWeek.innerHTML = '';
    let totalPercent = 0;

    habits.forEach(habit => {
      const progress = habit.checked ? 100 : 0;
      totalPercent += progress;

      const statItem = document.createElement('div');
      statItem.className = 'stat-item';
      statItem.innerHTML = `
        <label>${habit.name}</label>
        <div class="progress-bar">
          <div class="progress-fill" style="width: ${progress}%">${progress}%</div>
        </div>
      `;
      statsWeek.appendChild(statItem);
    });

    if (habits.length > 0) {
      const average = Math.round(totalPercent / habits.length);
      globalCircle.style.background = `conic-gradient(#fd79a8 0% ${average}%, #dfe6e9 ${average}% 100%)`;
      globalCircle.textContent = `${average}%`;
    }
  } catch (err) {
    console.error('Erreur chargement stats:', err);
  }
}

loadStats();
