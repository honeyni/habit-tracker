import { apiGet } from "./api.js";

const target = document.getElementById("today-list");

async function init() {
  try {
    const habits = await apiGet("/habits");
    target.textContent = `Habitudes chargees: ${habits.length}`;
  } catch (error) {
    target.textContent = `Erreur: ${error.message}`;
  }
}

init();
