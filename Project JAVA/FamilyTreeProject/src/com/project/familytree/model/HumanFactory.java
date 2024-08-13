public class HumanFactory {
    public Human createHuman(String name, LocalDate birthDate, Gender gender) {
        return new Human(name, birthDate, gender);
    }
}
