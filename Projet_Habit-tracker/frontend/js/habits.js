import { apiGet } from "./api.js";

const target = document.getElementById("habits-list");

async function init() {
  try {
    const habits = await apiGet("/habits");
    target.textContent = JSON.stringify(habits, null, 2);
  } catch (error) {
    target.textContent = `Erreur: ${error.message}`;
  }
}

init();
