public Optional<Habit> getHabitById(Long id) {
    return habitRepository.findById(id);
}

public Habit updateHabit(Long id, Habit newData) {
    Optional<Habit> existingHabit = habitRepository.findById(id);

    if (existingHabit.isPresent()) {
        Habit habit = existingHabit.get();
        habit.setName(newData.getName());
        habit.setTarget(newData.getTarget());
        return habitRepository.save(habit);
    }

    return null;
}

public boolean deleteHabit(Long id) {
    if (habitRepository.existsById(id)) {
        habitRepository.deleteById(id);
        return true;
    }
    return false;
}
