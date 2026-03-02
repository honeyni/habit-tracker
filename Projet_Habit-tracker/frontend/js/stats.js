import { apiGet } from "./api.js";

const target = document.getElementById("stats-week");

async function init() {
  try {
    const stats = await apiGet("/stats/week");
    target.textContent = JSON.stringify(stats, null, 2);
  } catch (error) {
    target.textContent = `Erreur: ${error.message}`;
  }
}

init();
